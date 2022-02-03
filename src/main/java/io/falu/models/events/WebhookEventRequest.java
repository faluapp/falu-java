package io.falu.models.events;

import com.google.gson.annotations.SerializedName;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The basic details about a request that triggered a webhook event.
 * Usually embedded in the webhook event.
 */
@SuperBuilder
@NoArgsConstructor
public class WebhookEventRequest {

    /**
     * ID of the API request that caused the event. If null, the event was automatic
     * (e.g., automatic balance updates).
     */
    private String id;

    /**
     * The idempotency key transmitted during the request, if any.
     */
    @SerializedName("idempotency_key")
    private String idempotencyKey;
}
