package io.falu.models.evaluations;

import io.falu.models.AbstractCreationRequest;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * A model representing details that can be changed about an evaluation.
 */
@Getter
@SuperBuilder
public class EvaluationPatchModel extends AbstractCreationRequest {
}
