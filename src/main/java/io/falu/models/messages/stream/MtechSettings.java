package io.falu.models.messages.stream;

import lombok.*;

/**
 * Settings for using the Mtech provider.
 */
@Data
@Getter
@Setter
@NoArgsConstructor
public class MtechSettings {
    /**
     * Application user-name for authentication.
     */
    @NonNull
    private String username;

    /**
     * Application password for authentication.
     */
    @NonNull
    private String password;

    /**
     * Short code for sending messages.
     */
    @NonNull
    private String shortCode;
}
