package io.falu.models.identityVerification;

import io.falu.models.core.PhysicalAddress;
import lombok.Getter;

import java.util.Date;

@Getter
public class IdentityVerificationOutputs {
    /**
     * The user’s verified id number type.
     */
    private String idNumberType;

    /**
     * The user’s verified id number.
     */
    private String idNumber;

    /**
     * The user’s verified first name.
     */
    private String firstName;

    /**
     * The user’s verified last name.
     */
    private String lastName;

    /**
     * The user’s verified date of birth.
     */
    private Date birthday;

    /**
     * The user’s other verified names.
     */
    private String[] otherNames;

    /**
     * The user’s verified address.
     */
    private PhysicalAddress address;
}
