package io.falu.models.evaluations;

import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * [The evaluation request object](https://falu.io)
 */
@Setter
@SuperBuilder()
public class EvaluationRequest {
    /**
     * Represents the currency e.g kes
     */
    String currency = "kes";

    /**
     * Represents the scope within which an evaluation is generated.
     * This can also be considered the purpose of the evaluation.
     */
    EvaluationScope scope;

    /**
     * Represents the kind of provider used for a statement in an evaluation.
     */
    StatementProvider provider = StatementProvider.MPESA;

    /**
     * The full name of the person or business that owns the statement.
     */
    String name;

    /**
     * The Phone number for attached to the statement.
     * Only required for statements generated against a phone number e.g. mpesa
     */
    String phone;

    /**
     * Password to open the uploaded file. Only required for password-protected files.
     * Certain providers only provide password-protected files.
     * In such cases the password should always be provided.
     */
    String password;

    /**
     * Unique identifier of the file containing the statement.
     */
    String fileId;
}
