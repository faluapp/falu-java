package io.falu.models.identity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;

/**
 * Information for searching for an entity's identity.
 */
@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class IdentitySearchModel {
    /**
     * Three-letter ISO country code, in lowercase, where the record exists.
     */
    @NotNull
    public String country = "kes";

    /**
     * The phone number to search in E.164 format. Required if DocumentNumber is not specified.
     */
    public String phone;

    /**
     * The kind of document to search for.
     * Required if ${phone} is not specified.
     */
    public String documentNumber;

    /**
     * The identification document number to search.
     * Required if ${phone} is not specified.
     */
    public IdentityDocumentType documentType;
}
