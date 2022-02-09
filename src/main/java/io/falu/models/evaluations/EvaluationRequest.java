package io.falu.models.evaluations;

import io.falu.models.AbstractCreationRequest;
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
     * Represents the scope within which an evaluation is generated.
     * This can also be considered the purpose of the evaluation.
     */
    private String scope;

    /**
     * Represents the kind of provider used for a statement in an evaluation.
     */
    private String provider;

    /**
     * The full name of the person or business that owns the statement.
     */
    private String name;

    /**
     * The Phone number for attached to the statement.
     * Only required for statements generated against a phone number e.g. mpesa
     */
    private String phone;

    /**
     * Password to open the uploaded file. Only required for password-protected files.
     * Certain providers only provide password-protected files.
     * In such cases the password should always be provided.
     */
    private String password;

    /**
     * Unique identifier of the file containing the statement.
     */
    private String file;
}
