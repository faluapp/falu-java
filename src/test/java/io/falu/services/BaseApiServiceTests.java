package io.falu.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.falu.AppInformation;
import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.networking.RequestOptions;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public abstract class BaseApiServiceTests {
    protected final String BASE_URL = "https://api.falu.io";
    protected final AppInformation information = AppInformation.builder()
        .name("Java-Tests")
        .version("1.0")
        .build();
    protected final FaluClientOptions options = FaluClientOptions.builder()
        .apiKey("sk_test_123")
        .enableLogging(true)
        .build();
    protected final RequestOptions requestOptions = RequestOptions
        .builder()
        .idempotencyKey("05bc69eb-218d-46f2-8812-5bede8592abf")
        .live(false)
        .build();
    protected MockWebServer mockWebServer;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    protected void setup() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

//    @AfterEach
//    protected void shutdown() throws IOException {
//        mockWebServer.shutdown();
//    }

    protected <T> MockResponse getMockedResponse(int statusCode, T tResponse) {
        String responseBody = null;

        try {
            responseBody = objectMapper.writeValueAsString(tResponse);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return new MockResponse()
            .setResponseCode(statusCode)
            .setBody(responseBody);
    }

    protected <T> ResourceResponse<T> getResourceResponse(int statusCode, T tResponse) {
        MockResponse mockResponse = getMockedResponse(statusCode, tResponse);

        return (ResourceResponse<T>) ResourceResponse.builder()
            .statusCode(statusCode)
            .headers(mockResponse.getHeaders())
            .resource(tResponse)
            .error(null)
            .build();
    }
}
