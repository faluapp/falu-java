package io.falu.models.evaluations;

import com.google.gson.annotations.SerializedName;
import io.falu.models.core.AbstractCreationRequest;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * [The evaluation request object](https://falu.io)
 */
@Setter
@SuperBuilder()
public class EvaluationRequest extends AbstractCreationRequest {
    /**
     * Represents the currency e.g kes
     */
    private String currency;

    /**
     * A set of options for the evaluation's checks.
     */
    private EvaluationScoringOptions options;

    /**
     * The URL the user will be redirected to upon completing the evaluation/scoring flow.
     */
    @SerializedName("return_url")
    private String returnUrl;
}
