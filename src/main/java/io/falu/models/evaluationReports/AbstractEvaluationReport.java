package io.falu.models.evaluationReports;

import io.falu.models.FaluModel;

public abstract class AbstractEvaluationReport extends FaluModel {
    /**
     * Details on the evaluation error.
     * Present when not completed.
     */
    private EvaluationReportError error;

    /**
     * Whether the check resulted in a successful evaluation.
     */
    private Boolean completed;
}
