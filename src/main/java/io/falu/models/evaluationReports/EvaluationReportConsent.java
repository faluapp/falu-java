package io.falu.models.evaluationReports;

import lombok.Getter;

import java.util.Date;

@Getter
public class EvaluationReportConsent {
    /**
     * Time at which the user gave consent for the evaluation to be done.
     */
    private Date date;

    /**
     * IP address from which the user gave consent for the evaluation to be done.
     */
    private String ip;

    /**
     * User agent of the device (e.g. browser) from which the user gave consent for the evaluation to be done.
     */
    private String userAgent;
}
