package io.falu.models.evaluations;

import io.falu.common.BasicListOptions;
import lombok.experimental.SuperBuilder;

/**
 * Options for filtering and pagination of evaluations.
 */
@SuperBuilder
public class EvaluationsListOptions extends BasicListOptions {
    /**
     * Email address of the evaluations.
     */
    private String email;

    /**
     * Phone number of the evaluations
     */
    private String phone;

    /**
     * Filter options for Evaluation.Status property.
     */
    private String[] status;
}
