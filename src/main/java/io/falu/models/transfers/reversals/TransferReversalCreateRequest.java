package io.falu.models.transfers.reversals;

import io.falu.models.payments.refunds.PaymentRefundReason;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class TransferReversalCreateRequest {
    /**
     * Identifier of the Transfer to reverse.
     */
    public String transfer;

    /**
     * Reason for the reversal.
     */
    public PaymentRefundReason reason;
}
