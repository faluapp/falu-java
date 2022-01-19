package io.falu.models.identity;

import com.google.gson.annotations.JsonAdapter;
import io.falu.client.adapters.ISO8601DateAdapter;
import io.falu.models.FaluModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * The identification record for an entity.
 */
@Getter
@SuperBuilder
public class IdentityRecord extends FaluModel {
    /**
     * Unique identifier for the record
     */
    String id;

    /**
     * Three-letter ISO country code, in lowercase, where the record exists.
     */
    String country;

    /**
     * The kind of identity document
     */
    String documentType;

    /**
     * The identification document number.
     */
    String documentNumber;

    /**
     * The full name of the entity.
     */
    String name;

    /**
     * The date of birth of the entity if specified.
     * This value is not guaranteed to be availed.
     * For entities that are not human (e.g. companies, businesses, NGOs,)
     * this value represents the date of registration or incorporation.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    Date birthday;

    /**
     * Phone numbers attached to the identity.
     */
    String[] phones;

    /**
     * Email addresses attached to the identity.
     */
    String[] emails;

    /**
     * The gender of the entity.
     * This value may be fixed or predicted.
     * This value may be fixed or predicted.
     * When predicted "GenderConfidence" will have a value.
     */
    String gender;

    /**
     * The confidence for the value predicted in ${gender}.
     * This value is null when the gender is fixed and not predicted.
     * It should not be used to determine predicted gender.
     */
    Float genderConfidence;
}
