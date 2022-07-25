package io.falu.models.events;

import io.falu.models.core.FaluModel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The basic implementation of a Webhook Event irrespective of the usage
 */
@SuperBuilder
@NoArgsConstructor
public class WebhookEvent<TObject> extends FaluModel {
    /**
     * Type of event (e.g. payment.updated, money_balances.updated, etc.).
     * Possible values are available in ${Webhooks.EventTypes}.
     */
    private String type;

    /**
     * Information on the API request that instigated the event.
     */
    public WebhookEventRequest request;

    /**
     * Object containing data associated with the event.
     */
    public WebhookEventData<TObject> data;
}
