package io.falu.models.payments;

import lombok.Builder;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

/**
 * The Mpesa Payment request object
 */
@Builder
public class MpesaPaymentRequest {
    /**
     * Phone number representing the account to be charged, in E.164 format.
     */
    @NonNull
    private String phone;

    /**
     * Reference that the payment will be made in. This can be an account number.
     */
    @NonNull
    private String reference;

    /**
     * Set true if the payment to be initiated is to be made to a paybill; false, the payment is made to a BuyGoods till.
     */
    @Nullable
    private Boolean paybill;

    /**
     * The shortcode of the receiver. When not provided, it defaults to the default recipient.
     * When not provided, either the default incoming business code or the first business code for the workspace is used when paybill is set to true.
     * <p>
     * This value is usually different from the business short code when using BuyGoods.
     */
    @Nullable
    private String destination;
}
