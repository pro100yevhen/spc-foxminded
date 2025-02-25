package ua.foxminded.application.deal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.foxminded.common.filter.Filter;
import ua.foxminded.infrastructure.mapper.TypeMapperFacade;
import ua.foxminded.domain.deal.model.dto.DealDto;
import ua.foxminded.domain.deal.model.entity.Deal;
import ua.foxminded.domain.deal.model.webhook.WebhookDealModel;
import ua.foxminded.domain.deal.service.DealService;
import ua.foxminded.infrastructure.util.JsonParser;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/deal")
public class DealResource {

    private static final Logger LOG = LoggerFactory.getLogger(DealResource.class);

    private final JsonParser jsonParser;
    private final Filter filter;
    private final DealService dealService;
    private final TypeMapperFacade mapper;

    public DealResource(final JsonParser jsonParser, final Filter <WebhookDealModel> filter,
                        final DealService dealService, final TypeMapperFacade typeMapperFacade) {
        this.jsonParser = jsonParser;
        this.filter = filter;
        this.dealService = dealService;
        this.mapper = typeMapperFacade;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody final String deal) {
        final WebhookDealModel webhookEvent = jsonParser.parseJson(deal, WebhookDealModel.class);
        LOG.info("Parsed WebhookDealModel: {}", webhookEvent.getEvent());

        if (filter.apply(webhookEvent)) {
            LOG.info("Deal passed the filter criteria");

            final Deal dealToSave = mapper.map(webhookEvent, Deal.class);
            LOG.info("Mapped Deal entity: {}", dealToSave);

            dealService.save(dealToSave);
            LOG.info("Deal saved successfully");
        } else {
            LOG.info("Deal did not pass the filter criteria: {}", webhookEvent.getMeta());
        }

        // Return 200 OK regardless of whether the deal was saved or not
        return ResponseEntity.ok("Processed successfully");
    }

    @GetMapping
    public List<DealDto> findByOwnerAndDate(@RequestParam final Long ownerId, @RequestParam final LocalDate date) {
        return dealService.findByOwnerAndDate(ownerId, date).stream()
                .map(deal -> mapper.map(deal, DealDto.class))
                .collect(Collectors.toList());
    }

    @DeleteMapping
    public void delete(@RequestParam final Long id) {
        dealService.delete(id);
    }
}
