package io.falu.models.transfers;

import io.falu.models.core.AbstractCreationRequest;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * A model representing details that can be changed about a transfer.
 */
@Getter
@SuperBuilder
public class TransferPatchModel extends AbstractCreationRequest {
}
