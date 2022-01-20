package io.falu.models.transfers.reversals;

import io.falu.models.AbstractCreationRequest;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * A model representing details that can be changed about a transfer reversal.
 */
@Getter
@SuperBuilder
public class TransferReversalPatchModel extends AbstractCreationRequest {
}
