package io.falu.models.files.links;

import io.falu.models.FaluModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * A file link.
 */
@NoArgsConstructor
@Getter
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
