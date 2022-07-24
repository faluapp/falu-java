package io.falu.models.evaluationReports;

import io.falu.models.FaluModel;
import io.falu.models.evaluations.EvaluationScoringOptions;
import lombok.Getter;

@Getter
public class EvaluationReport extends FaluModel {
    /**
     * Identifier of the evaluation that created this report.
     */
    private String evaluation;

    /**
     * The options that initiated this report.
     */
    private EvaluationScoringOptions options;

    /**
     * Details on the user’s acceptance of the Services Agreement.
     */
    private EvaluationReportConsent consent;

    /**
     * Result from a financial statement.
     */
    private EvaluationReportStatement statement;
}
