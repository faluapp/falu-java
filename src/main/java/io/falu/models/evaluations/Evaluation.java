package io.falu.models.evaluations;

import io.falu.models.FaluModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * [The evaluation object](<a href="https://docs.falu.io/api/#evaluations/evaluations/schema">...</a>)
 * Represents a financial evaluation.
 */
@Getter
@SuperBuilder(toBuilder = true)
public class Evaluation extends FaluModel {
    /**
     * Unique identifier of the evaluation.
     */
    private String id;

    /**
     * Three-letter ISO currency code, in lowercase.
     */
    private String currency;


    /**
     * Represents the status of an evaluation
     */
    private String status;

    /**
     * A set of options for the evaluation's process.
     */
    private EvaluationScoringOptions options;

    /**
     * The short-lived client secret used by front-end libraries to show an evaluation modal inside your app.
     * This client secret expires after 24 hours and can only be used once.
     * Don’t store it, log it, embed it in a URL, or expose it to anyone other than the user.
     * Make sure that you have TLS enabled on any page that includes the client secret.
     */
    private String clientSecret;

    /**
     * The short-lived URL that you use to redirect a user to Falu to submit their evaluation information.
     * This link expires after 24 hours and can only be used once.
     * Don’t store it, log it, send it in emails or expose it to anyone other than the target user.
     */
    private String url;

    /**
     * Unique identifiers of the reports for this verification.
     */
    private String[] reports;

    /**
     * If present, this property tells you the last error encountered when processing the evaluation.
     */
    private EvaluationLastError error;

    /**
     * The evaluations and scoring output data.
     */
    private EvaluationScoringOutputs outputs;
}
