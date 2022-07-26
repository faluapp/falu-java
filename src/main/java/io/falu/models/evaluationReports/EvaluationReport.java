package io.falu.models.evaluationReports;

import io.falu.models.core.FaluModel;
import io.falu.models.evaluations.EvaluationScoringOptions;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
public class EvaluationReport extends FaluModel {
    /**
     * Unique identifier of the evaluation report.
     */
    private String id;

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
