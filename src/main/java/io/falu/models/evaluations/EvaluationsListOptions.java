package io.falu.models.evaluations;

import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
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

    @Override
    public void populate(QueryValues values) {
        super.populate(values);
        values
                .add("email", email)
                .add("phone", phone)
                .add("status", status);
    }
}
