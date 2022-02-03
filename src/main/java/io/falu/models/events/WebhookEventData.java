package io.falu.models.events;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The data associated with a webhook event
 */
@SuperBuilder
@Getter
@NoArgsConstructor
public class WebhookEventData<TObject> {
    /**
     * Object containing the API resource relevant to the event.
     * For example, a <c>money_balances.updated</c> event will have a full balance object.
     **/
    public TObject object;

    /**
     * Object containing the names of the properties that have changed, and their previous
     * values (sent along only with <c>*.updated</c> events).
     */
    public TObject previous;
}
