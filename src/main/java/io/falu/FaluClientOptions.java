package io.falu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Falu SDK Configuration options
 */
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
public class FaluClientOptions {
    /**
     * The ApiVersion that the SDK conforms to
     */
    private final String apiVersion = "2021-09-03";

    /**
     * The API Key for authenticating requests to Falu servers
     */
    private String apiKey;

    /**
     * Information about the application.
     */
    private AppInformation appInformation;

    /**
     * Enable the display of HTTP request and response bodies
     */
    private Boolean enableLogging = false;
}
