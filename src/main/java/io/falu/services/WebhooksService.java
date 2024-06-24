package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.client.patch.JsonPatchDocument;
import io.falu.models.webhooks.WebhookEndpoint;
import io.falu.models.webhooks.WebhookEndpointCreateRequest;
import io.falu.models.webhooks.WebhookEndpointListOptions;
import io.falu.models.webhooks.WebhookEndpointPatchModel;
import io.falu.networking.RequestOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class WebhooksService extends BaseApiService {
    public WebhooksService(@NotNull FaluClientOptions options) {
        super(options);
    }

    /**
     * Get Webhook Endpoints.
     *
     * @param listOptions    Options for filtering and pagination of list webhooks.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<WebhookEndpoint[]> getWebhookEndpoints(@Nullable WebhookEndpointListOptions listOptions, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getWebhookEndpoints(listOptions, requestOptions);
    }

    /**
     * Get Webhook Endpoints.
     *
     * @param request        Information for creating a webhook.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<WebhookEndpoint> createWebhookEndpoints(@NotNull WebhookEndpointCreateRequest request, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().createWebhookEndpoint(request, requestOptions);
    }

    /**
     * Get Webhook Endpoints.
     *
     * @param endpointId     Unique identifier of the webhook.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<WebhookEndpoint> getWebhookEndpoint(@NotNull String endpointId, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getWebhookEndpoint(endpointId, requestOptions);
    }

    /**
     * Get Webhook Endpoints.
     *
     * @param endpointId     Unique identifier of the webhook.
     * @param patch          Details about what is to be changed.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<WebhookEndpoint> updateWebhookEndpoint(@NotNull String endpointId,
        WebhookEndpointPatchModel patchModel, @Nullable RequestOptions requestOptions) throws IOException {

        return getApiClient().updateWebhookEndpoint(endpointId, patchModel, requestOptions);
    }

    /**
     * Get Webhook Endpoints.
     *
     * @param endpointId     Unique identifier of the webhook.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<?> deleteWebhookEndpoint(@NotNull String endpointId, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().deleteWebhookEndpoint(endpointId, requestOptions);
    }
}
