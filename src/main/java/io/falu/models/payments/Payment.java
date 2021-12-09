package io.falu.models.payments;

import com.google.gson.annotations.JsonAdapter;
import io.falu.client.adapters.ISO8601DateAdapter;
import io.falu.models.FaluModel;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Represents a transaction done by a customer to the business.
 */
@NoArgsConstructor
public class Payment extends FaluModel {
    /**
     * Unique identifier for the object.
     */
    String id;

    /**
     * Three-letter ISO currency code, in lowercase.
     */
    String currency;

    /**
     * Amount of the payment in smallest currency unit.
     */
    int amount;

    /**
     * The status of a payment.
     */
    PaymentStatus status;

    /**
     * Time at which the object was created.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    Date created;

    /**
     * Time at which the object was last updated.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    Date updated;

    /**
     * Time at which the payment succeeded. Only populated when successful.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    Date succeeded;

    /**
     * Identifier of the authorization, if the payment passed through a flow requiring authorization.
     */
    String authorizationId;

    /**
     * The medium used for the payment.
     */
    PaymentType type;

    /**
     * Details about failure of a payment, transfer or reversal.
     */
    Object pesalink;

    /**
     * If this is an MPESA Payment, this contains details about the MPESA payment.
     */
    MpesaPayment mpesa;

    /**
     * Identifier of the payment refund, if the payment has been refunded.
     */
    String refundId;
}
