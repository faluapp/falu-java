package io.falu.models.webhooks;

import io.falu.models.AbstractCreationRequest;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

/**
 * Information for creating a webhook endpoint.
 */
@NoArgsConstructor
@SuperBuilder
public class WebhookEndpointCreateRequest extends AbstractCreationRequest {
    /**
     * The format to be used for a request to a webhook endpoint.
     */
    @NonNull
    private String format;

    /**
     * The list of events this endpoint accepts.
     */
    @NonNull
    private String[] events;

    /**
     * The URL of the webhook endpoint.
     */
    @NonNull
    private String url;

    /**
     * The active status of a Webhook
     */
    private String status;

    /**
     * The access token to be sent in the Authorization request header field defined by HTTP/1.1. This value is populated using the "Bearer" scheme, using the OAuth 2.0 Bearer Token RFC6750 model.
     * <p>
     * When not present, the Authorization request header is not populated.
     */
    private String token;
}
