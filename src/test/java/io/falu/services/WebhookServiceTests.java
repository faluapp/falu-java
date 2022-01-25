package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.client.patch.JsonPatchDocument;
import io.falu.models.webhooks.WebhookEndpoint;
import io.falu.models.webhooks.WebhookEndpointCreateRequest;
import io.falu.models.webhooks.WebhookEndpointListOptions;
import io.falu.models.webhooks.WebhookEndpointPatchModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class WebhookServiceTests extends BaseApiServiceTests {

    @Test
    public void test_GetWebhooksWorks() throws IOException {
        WebhooksService service = new WebhooksService(options);

        WebhookEndpointListOptions opt = WebhookEndpointListOptions.builder()
                .count(1)
                .build();

        ResourceResponse<WebhookEndpoint[]> response = service.getWebhookEndpoints(opt, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreateWebhooksWorks() throws IOException {
        WebhooksService service = new WebhooksService(options);

        WebhookEndpointCreateRequest request = WebhookEndpointCreateRequest.builder()
                .events(new String[]{"evaluation.completed"})
                .url("https://localhost:1234")
                .format("basic")
                .token("e0gNHBa90CfdKbtcWgksn52cvXoXMqCTaLdttJAsQVU=")
                .build();

        ResourceResponse<WebhookEndpoint> response = service.createWebhookEndpoints(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetWebhookWorks() throws IOException {
        WebhooksService service = new WebhooksService(options);

        ResourceResponse<WebhookEndpoint> response = service.getWebhookEndpoint("we_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_updateWebhookWorks() throws IOException {
        WebhooksService service = new WebhooksService(options);

        JsonPatchDocument<WebhookEndpointPatchModel> document = new JsonPatchDocument<WebhookEndpointPatchModel>()
                .replace("description", "cake");

        ResourceResponse<WebhookEndpoint> response = service.updateWebhookEndpoint("we_123", document, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_deleteWebhookWorks() throws IOException {
        WebhooksService service = new WebhooksService(options);

        ResourceResponse<?> response = service.deleteWebhookEndpoint("we_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
