package io.falu.models.payments;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;

/**
 * Information for creating a payment.
 */
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class PaymentCreateOptions {
    /**
     * Three-letter ISO currency code, in lowercase.
     */
    private String currency;

    /**
     * Amount of the payment in the smallest currency unit.
     */
    private int amount;

    /**
     * For mpesa payments
     */
    private MpesaPaymentRequest mpesa;

    /**
     * An optional arbitrary string attached to the object. Mainly used to describe the object and often useful for displaying to users.
     */
    private String description;

    /**
     * Set of key-value pairs that you can attach to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * The key can only contain alphanumeric, and -, _ characters, and the string has to start with a letter.
     */
    Map<String, String> metadata;
}
