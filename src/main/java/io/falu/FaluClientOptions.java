package io.falu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;

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
    private final String apiVersion = "2024-06-01";

    /**
     * The API Key for authenticating requests to Falu servers
     */
    @NotNull
    private String apiKey;

    /**
     * The maximum number of times requests will be retried.
     */
    private int maxNetworkRetries = 0;

    /**
     * Information about the application.
     */
    private AppInformation appInformation;

    /**
     * Enable the display of HTTP request and response bodies
     */
    private Boolean enableLogging;
}
