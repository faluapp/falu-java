package io.falu.models.webhooks;

import io.falu.models.FaluModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The basic implementation of a Webhook irrespective of the usage
 */
@Getter
@NoArgsConstructor
@SuperBuilder
public class WebhookEndpoint extends FaluModel {
    /**
     * The unique identifier of the object
     */
    private String id;

    /**
     * The list of events to enable for this endpoint.
     * Possible values are available in @{EventTypes}
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

    /**
     * The full value is only returned at creation.
     * Otherwise, a secured value is returned.
     * For example: <c>e0gNHBa90CfdKbtcWgksn52cvXoXMqCTaLdttJAsQVU=</c> would be
     * returned in full on creation. However, subsequent times like read/get/update,
     * would return either <c>null</c> or <c>e0gNHBa90..</c>.
     */
    private String secret;
}
