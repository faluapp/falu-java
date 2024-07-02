package io.falu.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

/**
 * A machine-readable format for specifying errors in HTTP API responses based on
 * https://tools.ietf.org/html/rfc7807.
 * This is normally used when the response status code does not indicate success such as 400 etc
 */
class HttpResponseProblem {
    /**
     * A URI reference [RFC3986] that identifies the problem type. This specification encourages
     * that, when dereferenced, it provide human-readable documentation for the problem type
     * (e.g., using HTML [W3C.REC-html5-20141028]).  When this member is not present, its value
     * is assumed to be "about:blank".
     */
    String type;

    /**
     * A short, human-readable summary of the problem type.It SHOULD NOT change from occurrence
     * to occurrence of the problem, except for purposes of localization(e.g., using proactive
     * content negotiation; see[RFC7231], Section 3.4).
     */
    String title;

    /**
     * A human-readable explanation specific to this occurrence of the problem.
     */
    String detail;

    /**
     * A URI reference that identifies the specific occurrence of the problem.It may or may
     * not yield further information if dereferenced.
     */
    String instance;

    /**
     * Gets the validation errors associated with this instance of ProblemDetails.
     */
    HashMap<String, List<String>> errors;

    /**
     * Gets the validation errors associated with this instance of ProblemDetails.
     */
    @JsonProperty("error_code")
    String legacyCode;

    /**
     * The detailed description for the error.
     * Where provided, it can be used as a display message to the user in an interactive environment.
     */
    @JsonProperty("error_description")
    String legacyDescription;

    String getCode() {
        return title == null ? legacyCode : title;
    }

    String getDescription() {
        return detail != null ? detail : legacyDescription;
    }
}
