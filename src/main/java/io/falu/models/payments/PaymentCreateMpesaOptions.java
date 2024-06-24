package io.falu.models.payments;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Information for initiating a payment from a customer to the business via MPESA.
 */
@SuperBuilder
@NoArgsConstructor
public class PaymentCreateMpesaOptions {
    /**
     * The phone number representing the account to be charged.
     */
    private String phone;

    /**
     * The reference that the payment will be made in.
     * This can be an account number.
     */
    private String reference;

    /**
     * Set true if the payment to be initiated is to be made to a paybill;
     * false, the payment is made to a BuyGoods till.
     */
    private Boolean paybill;

    /**
     * The shortcode of the receiver.
     * When not provided, it defaults to the default recipient.
     * When not provided, either the default incoming business code
     * or the first business code for the workspace is used depending on the <c>Kind</c>.
     * This value is usually required and different from the business short code when using BuyGoods.
     */
    private String destination;
}
