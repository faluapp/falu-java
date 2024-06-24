package io.falu.models.files.links;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Information for creating a file link
 */
@Getter
@NoArgsConstructor
@SuperBuilder
public class FileLinkCreateOptions {
    /**
     * Unique identifier of the file.
     */
    private String fileId;
}
