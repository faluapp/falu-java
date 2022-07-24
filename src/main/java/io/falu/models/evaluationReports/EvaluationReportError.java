package io.falu.models.evaluationReports;

import lombok.Getter;

@Getter
public class EvaluationReportError {
    /**
     * A short machine-readable string giving the reason for evaluation or user-session failure.
     */
    private String code;

    /**
     * A human-readable message that explains the reason for evaluation or user-session failure.
     * These message can be shown to your user.
     */
    private String description;
}
