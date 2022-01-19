package io.falu.models.payments.authorization;


import com.google.gson.annotations.JsonAdapter;
import io.falu.client.adapters.ISO8601DateAdapter;
import io.falu.models.FaluModel;
import io.falu.models.payments.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Represents a payment authorization.
 */
@Getter
@NoArgsConstructor
public class PaymentAuthorization extends FaluModel {
    /**
     * Unique identifier for the object.
     */
    private String id;

    /**
     * Three-letter ISO currency code, in lowercase.
     */
    private String currency;

    /**
     * Amount that was authorized or rejected, in smallest currency unit.
     */
    private int amount;

    /**
     * Whether the authorization has been approved.
     */
    private boolean approved;

    /**
     * The authorization was reversed by the payment provider or expired without capture.
     */
    private PaymentAuthorizationStatus status;

    /**
     * Reason for a given status of payment authorization.
     */
    private PaymentAuthorizationReason reason;

    /**
     * The medium used for the payment.
     */
    private PaymentType type;

    /**
     * Identifier of the payment created after the authorization is approved and closed.
     */
    private String paymentId;
}
