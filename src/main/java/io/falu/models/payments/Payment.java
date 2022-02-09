package io.falu.models.payments;

import com.google.gson.annotations.JsonAdapter;
import io.falu.client.adapters.ISO8601DateAdapter;
import io.falu.models.FaluModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * Represents a transaction done by a customer to the business.
 */
@NoArgsConstructor
@Getter
@SuperBuilder
public class Payment extends FaluModel {
    /**
     * Unique identifier for the object.
     */
    private String id;

    /**
     * Three-letter ISO currency code, in lowercase.
     */
    private String currency;

    /**
     * Amount of the payment in smallest currency unit.
     */
    private int amount;

    /**
     * The status of a payment.
     */
    private String status;

    /**
     * Time at which the payment succeeded. Only populated when successful.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    private Date succeeded;

    /**
     * Identifier of the authorization, if the payment passed through a flow requiring authorization.
     */
    private String authorizationId;

    /**
     * The medium used for the payment.
     */
    private String type;

    /**
     * Details about failure of a payment, transfer or reversal.
     */
    private Object pesalink;

    /**
     * If this is an MPESA Payment, this contains details about the MPESA payment.
     */
    private MpesaPayment mpesa;

    /**
     * Identifier of the payment refund, if the payment has been refunded.
     */
    private String refundId;
}
