package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.events.EventListOptions;
import io.falu.models.events.WebhookEvent;
import io.falu.networking.RequestOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class EventsService extends BaseApiService {
    public EventsService(@NotNull FaluClientOptions options) {
        super(options);
    }

    /**
     * Get Webhook Events.
     *
     * @param listOptions    Options for filtering and pagination of list webhook events.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<WebhookEvent[]> getWebhookEvents(@Nullable EventListOptions listOptions, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getWebhookEvents(listOptions, requestOptions);
    }

    /**
     * Get Webhook Event.
     *
     * @param eventId        Unique identifier of the webhook.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<WebhookEvent> getWebhookEvent(@NotNull String eventId, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getWebhookEvent(eventId, requestOptions);
    }
}
