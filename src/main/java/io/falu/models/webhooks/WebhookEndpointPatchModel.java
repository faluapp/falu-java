package io.falu.models.webhooks;

import io.falu.models.AbstractCreationRequest;
import lombok.experimental.SuperBuilder;

/**
 * A model representing details that can be changed about a Webhook endpoint
 */
@SuperBuilder
public class WebhookEndpointPatchModel extends AbstractCreationRequest {
    /**
     * The list of events to enable for this endpoint.
     */
    private String[] events;

    /**
     * The status of the webhook.
     */
    private String status;

    /**
     * The URL of the webhook endpoint
     */
    private String url;
}
