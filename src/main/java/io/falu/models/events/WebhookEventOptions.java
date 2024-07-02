package io.falu.models.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The basic details about a request that triggered a webhook event.
 * Usually embedded in the webhook event.
 */
@SuperBuilder
@NoArgsConstructor
public class WebhookEventOptions {

    /**
     * ID of the API request that caused the event. If null, the event was automatic
     * (e.g., automatic balance updates).
     */
    private String id;

    /**
     * The idempotency key transmitted during the request, if any.
     */
    @JsonProperty("idempotency_key")
    private String idempotencyKey;
}
