package io.falu.models.payments.refunds;

import io.falu.models.core.AbstractCreateOptions;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * A model representing details that can be changed about a payment refund.
 */
@Getter
@SuperBuilder
public class PaymentRefundUpdateOptions extends AbstractCreateOptions {
}
