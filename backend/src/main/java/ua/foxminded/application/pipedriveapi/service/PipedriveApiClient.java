package ua.foxminded.application.pipedriveapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ua.foxminded.domain.activity.model.entity.Activity;
import ua.foxminded.domain.pipedriveapi.model.ActivityPipedriveApi;

@Service
public class PipedriveApiClient {

    private final WebClient webClient;

    @Value("${pipedrive.url}")
    private String PIPEDRIVE_URL;

    @Value("${pipedrive.token}")
    private String PIPEDRIVE_TOKEN;
    private final String ACTIVITY_URL = "/activities";
    private final String OWNER_URL = "/owners";
    private final String DEAL_URL = "/deals";
    private final String AUTH_KEY = "api_token";

    public PipedriveApiClient(final WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(PIPEDRIVE_URL).build();
    }

    public Mono<ActivityPipedriveApi> getActivityById(final Long id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(ACTIVITY_URL + "/{id}")
                        .queryParam(AUTH_KEY, PIPEDRIVE_TOKEN)
                        .build(id))
                .retrieve()
                .bodyToMono(String.class) // Temporarily return the response as a String
                .doOnNext(response -> {
                    // Log or print the response for debugging
                    System.out.println("Pipedrive API Response: " + response);
                })
                .map(response -> {
                    // Convert the response string back to ActivityPipedriveApi
                    // Use ObjectMapper or some other method to manually inspect the structure
                    return null;
                });
    }}
