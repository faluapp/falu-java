package io.falu.models.files.links;

import io.falu.models.FaluModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * A file link.
 */
@NoArgsConstructor
@Getter
@SuperBuilder
public class FileLink extends FaluModel {
    /**
     * Unique identifier of the file.
     */
    private String fileId;

    /**
     * Publicly accessible URL to download the file.
     */
    private String url;

    /**
     * Whether this link is already expired.
     */
    private Boolean expired;
}
