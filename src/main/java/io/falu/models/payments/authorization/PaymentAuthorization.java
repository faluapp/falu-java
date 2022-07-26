package io.falu.models.payments.authorization;


import io.falu.models.core.FaluModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Represents a payment authorization.
 */
@Getter
@NoArgsConstructor
@SuperBuilder
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
    private String status;

    /**
     * Reason for a given status of payment authorization.
     */
    private String reason;

    /**
     * The medium used for the payment.
     */
    private String type;

    /**
     * Identifier of the payment created after the authorization is approved and closed.
     */
    private String paymentId;
}
