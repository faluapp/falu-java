package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.models.webhooks.WebhookEndpoint;
import io.falu.models.webhooks.WebhookEndpointCreateRequest;
import io.falu.models.webhooks.WebhookEndpointListOptions;
import io.falu.models.webhooks.WebhookEndpointUpdateOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

@ExtendWith(MockitoExtension.class)
public class WebhookServiceTests extends BaseApiServiceTests {

    private final WebhookEndpoint webhookEndpoint = WebhookEndpoint.builder()
        .id("we_123")
        .url("https://localhost:1234")
        .created(new Date())
        .updated(new Date())
        .build();

    @Mock
    private WebhooksService service;

    @Test
    public void test_GetWebhooksWorks() throws IOException {
        service = Mockito.mock(WebhooksService.class, withSettings().useConstructor(options));

        WebhookEndpointListOptions opt = WebhookEndpointListOptions.builder()
            .count(1)
            .build();

        // given
        ResourceResponse<WebhookEndpoint[]> expectedResponse = getResourceResponse(200, new WebhookEndpoint[]{webhookEndpoint});
        when(service.getWebhookEndpoints(opt, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, new WebhookEndpoint[]{webhookEndpoint}));

        // when
        ResourceResponse<WebhookEndpoint[]> response = service.getWebhookEndpoints(opt, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreateWebhooksWorks() throws IOException {
        service = Mockito.mock(WebhooksService.class, withSettings().useConstructor(options));

        WebhookEndpointCreateRequest request = WebhookEndpointCreateRequest.builder()
            .events(new String[]{"payment.succeeded"})
            .url("https://localhost:1234")
            .format("basic")
            .token("e0gNHBa90CfdKbtcWgksn52cvXoXMqCTaLdttJAsQVU=")
            .build();

        // given
        ResourceResponse<WebhookEndpoint> expectedResponse = getResourceResponse(200, webhookEndpoint);
        when(service.createWebhookEndpoints(request, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, webhookEndpoint));

        // when
        ResourceResponse<WebhookEndpoint> response = service.createWebhookEndpoints(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetWebhookWorks() throws IOException {
        service = Mockito.mock(WebhooksService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<WebhookEndpoint> expectedResponse = getResourceResponse(200, webhookEndpoint);
        when(service.getWebhookEndpoint("we_123", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, webhookEndpoint));

        // when
        ResourceResponse<WebhookEndpoint> response = service.getWebhookEndpoint("we_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_updateWebhookWorks() throws IOException {
        service = Mockito.mock(WebhooksService.class, withSettings().useConstructor(options));

        WebhookEndpointUpdateOptions patchModel = WebhookEndpointUpdateOptions.builder()
            .description("cake")
            .build();

        // given
        ResourceResponse<WebhookEndpoint> expectedResponse = getResourceResponse(200, webhookEndpoint);
        when(service.updateWebhookEndpoint("we_123", patchModel, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, webhookEndpoint));

        // when
        ResourceResponse<WebhookEndpoint> response = service.updateWebhookEndpoint("we_123", patchModel, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_deleteWebhookWorks() throws IOException {
        service = Mockito.mock(WebhooksService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse expectedResponse = getResourceResponse(200, null);
        when(service.deleteWebhookEndpoint("we_123", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, webhookEndpoint));

        // when
        ResourceResponse<?> response = service.deleteWebhookEndpoint("we_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
