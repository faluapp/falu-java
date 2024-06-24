package io.falu.models.transfers.reversals;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class TransferReversalCreateOptions {
    /**
     * Identifier of the Transfer to reverse.
     */
    public String transfer;

    /**
     * Reason for the reversal.
     */
    public String reason;
}
