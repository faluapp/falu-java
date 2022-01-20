package io.falu.models.payments;

import io.falu.models.AbstractCreationRequest;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * A model representing details that can be changed about a payment.
 */
@Getter
@SuperBuilder
public class PaymentPatchModel extends AbstractCreationRequest {
}
