package ua.foxminded.application.pipedriveapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ua.foxminded.domain.pipedriveapi.model.ActivityPipedriveApi;

@Service
public class PipedriveApiClient {

    private final WebClient webClient;

    private String PIPEDRIVE_TOKEN;
    private final String ACTIVITY_URL = "/activities";
    private final String OWNER_URL = "/owners";
    private final String DEAL_URL = "/deals";
    private final String AUTH_KEY = "api_token";

    public PipedriveApiClient(final WebClient.Builder webClientBuilder,
                              @Value("${pipedrive.url}") final String PIPEDRIVE_URL,
                              @Value("${pipedrive.token}") final String PIPEDRIVE_TOKEN
    ) {
        this.PIPEDRIVE_TOKEN = PIPEDRIVE_TOKEN;
        this.webClient = webClientBuilder.baseUrl(PIPEDRIVE_URL).build();
    }

    public Mono<ActivityPipedriveApi> getActivityById(final Long id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(ACTIVITY_URL + "/{id}")
                        .queryParam(AUTH_KEY, PIPEDRIVE_TOKEN)
                        .build(id))
                .retrieve()
                .bodyToMono(ActivityPipedriveApi.class);
    }
}