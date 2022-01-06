package io.falu.models.messages.stream;

import lombok.*;

/**
 * Settings for using the Mobi4tech provider.
 */
@Data
@Getter
@Setter
@NoArgsConstructor
public class Mobi4techSettings {
    /**
     * Application username for authentication.
     */
    @NonNull
    private String username;

    /**
     * Application password for authentication.
     */
    @NonNull
    private String password;

    /**
     * Authentication Key to access the API.
     */
    @NonNull
    private String apiKey;

    /**
     * Identifier of the Plan to be used.
     */
    @NonNull
    private String planId;

    /**
     * Identifier of the sender to be used. This can be the shortcode.
     */
    @NonNull
    private String senderId;
}
