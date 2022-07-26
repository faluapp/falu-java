package io.falu.models.evaluationReports;

import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
import lombok.experimental.SuperBuilder;

/**
 * Options for filtering and pagination of evaluation reports.
 */
@SuperBuilder
public class EvaluationReportsListOptions extends BasicListOptions {

    /**
     * Unique identifier of the evaluation to filter for.
     */
    private String evaluation;

    @Override
    public void populate(QueryValues values) {
        super.populate(values);
        values.add("evaluation", evaluation);
    }
}
