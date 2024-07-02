package io.falu.models.identiityVerificationReports;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;

@Getter
public class IdentityVerificationReportIdNumber extends AbstractIdentityVerificationReportCheck {
    /**
     * Type of ID number.
     */
    @JsonProperty("id_number_type")
    private String IdNumberType;

    /**
     * Identification number.
     */
    @JsonProperty("id_number")
    private String IdNumber;

    /**
     * First name as it appears in the document.
     */
    @JsonProperty("first_name")
    private String firstName;

    /**
     * Last name as it appears in the document.
     */
    @JsonProperty("last_name")
    private String lastName;

    /**
     * Other names as they appear in the document.
     */
    private String[] otherNames;

    /**
     * Sex as it appears on the document
     */
    @JsonProperty("sex")
    private String sex;

    /**
     * Date of birth as it appears in the document.
     */
    private Date birthday;
}
