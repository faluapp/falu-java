package io.falu.models.evaluationReports;

import com.google.gson.annotations.JsonAdapter;
import io.falu.client.adapters.ISO8601DateAdapter;
import io.falu.models.core.Period;
import lombok.Getter;

import java.util.Date;

@Getter
public class EvaluationReportStatement {
    /**
     * Provider of the uploaded document.
     */
    private String provider;

    /**
     * Identifier of the file holding the uploaded document used.
     */
    private String document;

    /**
     * Password for the uploaded document.
     * Present for password-protected files.
     */
    private String password;

    /**
     * Email of the owner as it appears in the document.
     */
    private String email;

    /**
     * Name of the owner as it appears in the document.
     */
    private String name;

    /**
     * Phone number of the owner as it appears in the document.
     */
    private String phone;

    /**
     * Period for which the uploaded document covers.
     */
    private Period period;

    /**
     * Risk probability. The higher the value, the higher the risk
     */
    private float risk;

    /**
     * Limit advised for lending in the smallest currency unit.
     */
    private Long limit;

    /**
     * Time till when the score is deemed valid.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    private Date expires;
}
