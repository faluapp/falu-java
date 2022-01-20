package io.falu.models.payments.refunds;

import io.falu.models.AbstractCreationRequest;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * A model representing details that can be changed about a payment refund.
 */
@Getter
@SuperBuilder
public class PaymentRefundPatchModel extends AbstractCreationRequest {
}
