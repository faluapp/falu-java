package io.falu.models.identiityVerificationReports;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import io.falu.client.adapters.ISO8601DateAdapter;
import lombok.Getter;

import java.util.Date;

@Getter
public class IdentityVerificationReportIdNumber extends AbstractIdentityVerificationReportCheck {
    /**
     * Type of ID number.
     */
    @SerializedName("id_number_type")
    private String IdNumberType;

    /**
     * Identification number.
     */
    @SerializedName("id_number")
    private String IdNumber;

    /**
     * First name as it appears in the document.
     */
    @SerializedName("first_name")
    private String firstName;

    /**
     * Last name as it appears in the document.
     */
    @SerializedName("last_name")
    private String lastName;

    /**
     * Other names as they appear in the document.
     */
    private String[] otherNames;

    /**
     * Sex as it appears on the document
     */
    @SerializedName("sex")
    private String sex;

    /**
     * Date of birth as it appears in the document.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    private Date birthday;
}
