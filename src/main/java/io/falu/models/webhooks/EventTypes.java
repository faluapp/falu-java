package io.falu.models.webhooks;

///
public class EventTypes {
    //region Messages

    /**
     * Occurs whenever a message is sent.
     */
    public static String MESSAGE_SENT = "message.sent";

    /**
     * Occurs whenever a message fails to send.
     */
    public static String MESSAGE_FAILED = "message.failed";

    /**
     * Occurs whenever an SMS is delivered successfully.
     * NOTE: only called when a provider with delivery reports is enabled configured
     */
    public static String MESSAGE_DELIVERED = "message.delivered";

    //endregion

    //region MessageTemplates

    /**
     * Occurs whenever a message template is created.
     */
    public static String MESSAGE_TEMPLATE_CREATED = "message_template.created";

    /**
     * Occurs whenever a message template is updated.
     */
    public static String MESSAGE_TEMPLATE_UPDATED = "message_template.updated";

    /**
     * Occurs whenever a message template is deleted.
     */
    public static String MESSAGE_TEMPLATE_DELETED = "message_template.deleted";

    //endregion

    //region Money Balances

    /**
     * Occurs whenever a money balances are updated.
     */
    public static String MONEY_BALANCES_UPDATED = "money_balances.updated";

    //endregion

    //region Payments

    /**
     * Occurs whenever a payment is updated.
     */
    public static String PAYMENT_UPDATED = "payment.updated";

    /**
     * Occurs whenever a payment succeeds.
     */
    public static String PAYMENT_SUCCEEDED = "payment.succeeded";

    /**
     * Occurs whenever a payment fails.
     */
    public static String PAYMENT_FAILED = "payment.failed";

    //endregion

    //region PaymentAuthorizations

    /**
     * Occurs whenever a payment authorization is requested.
     */
    public static String PAYMENT_AUTHORIZATION_REQUEST = "payment.authorization.request";

    /**
     * Occurs whenever a payment authorization is created.
     */
    public static String PAYMENT_AUTHORIZATION_CREATED = "payment.authorization.created";

    /**
     * Occurs whenever a payment authorization is updated.
     */
    public static String PAYMENT_AUTHORIZATION_UPDATED = "payment.authorization.updated";
    //endregion

    //region PaymentRefunds

    /**
     * Occurs whenever a payment refund is created.
     */
    public static String PAYMENT_REFUND_CREATED = "payment.refund.created";

    /**
     * Occurs whenever a payment refund is updated.
     */
    public static String PAYMENT_REFUND_UPDATED = "payment.refund.updated";

    /**
     * Occurs whenever a payment refund succeeds.
     */
    public static String PAYMENT_REFUND_SUCCEEDED = "payment.refund.succeeded";

    /**
     * Occurs whenever a payment refund fails.
     */
    public static String PAYMENT_REFUND_FAILED = "payment.refund.failed";

    //endregion


    //region Transfer
    /**
     * Occurs whenever a transfer is created.
     */
    public static String TRANSFER_CREATED = "transfer.created";

    /**
     * Occurs whenever a transfer is updated.
     */
    public static String TRANSFER_UPDATED = "transfer.updated";

    /**
     * Occurs whenever a transfer succeeds.
     */
    public static String TRANSFER_SUCCEEDED = "transfer.succeeded";

    /**
     * Occurs whenever a transfer fails.
     */
    public static String TRANSFER_FAILED = "transfer.failed";
    //endregion


    //region Transfer

    /**
     * Occurs whenever a transfer reversal is created.
     */
    public static String TRANSFER_REVERSAL_CREATED = "transfer.reversal.created";

    /**
     * Occurs whenever a transfer reversal is updated.
     */
    public static String TRANSFER_REVERSAL_UPDATED = "transfer.reversal.updated";

    /**
     * Occurs whenever a transfer reversal succeeds.
     */
    public static String TRANSFER_REVERSAL_SUCCEEDED = "transfer.reversal.succeeded";

    /**
     * Occurs whenever a transfer reversal fails.
     */
    public static String TRANSFER_REVERSAL_FAILED = "transfer.reversal.failed";
    //endregion
}
