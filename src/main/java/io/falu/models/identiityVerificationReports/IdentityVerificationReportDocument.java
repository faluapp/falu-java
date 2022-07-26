package io.falu.models.identiityVerificationReports;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import io.falu.client.adapters.ISO8601DateAdapter;
import io.falu.models.core.PhysicalAddress;
import lombok.Getter;

import java.util.Date;

@Getter
public class IdentityVerificationReportDocument extends AbstractIdentityVerificationReportCheck {
    /**
     * Expiry date of the document.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    private Date expiry;

    /**
     * Issued date of the document.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    private Date issued;

    /**
     * Issued date of the document.
     */
    private String issuer;

    /**
     * Three-letter <see href="https://www.iso.org/iso-3166-country-codes.html">ISO country code</see>,
     * in lowercase, where the entity issued the document originates from.
     */
    private String nationality;

    /**
     * Type of the document.
     */
    private String type;

    /**
     * Sub-type for the document
     */
    @SerializedName("sub_type")
    private String subType;

    /**
     * Document identification number.
     */
    private String number;

    /**
     * Personal number
     */
    @SerializedName("personal_number")
    private String personalNumber;

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

    /**
     * Address as it appears in the document.
     */
    private PhysicalAddress address;

    /**
     * The driving license vehicle categories. Only populated if this report is for a driving licence.
     */
    @SerializedName("driving_license_categories")
    private String[] drivingLicenseCategories;

    /**
     * Unique identifiers of the files containing images for this document.
     */
    private String[] files;
}
