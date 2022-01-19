package io.falu.models.messages.stream;

import lombok.*;

/**
 * Settings for using the Crossgate provider.
 */
@Data
@Getter
@Setter
@Builder
public class CrossgateSettings {
    /**
     * The application identifier for making requests with.
     */
    @NonNull
    private String appKey;

    /**
     * The application secret for making requests with.
     */
    @NonNull
    private String appSecret;

    /**
     * The profile to use when making requests.
     */
    @NonNull
    private String profileId;
}
