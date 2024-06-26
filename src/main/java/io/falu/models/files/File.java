package io.falu.models.files;

import io.falu.models.core.FaluModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * A file on Falu's servers.
 */
@NoArgsConstructor
@Getter
@SuperBuilder
public class File extends FaluModel {
    /**
     * The unique identifier of the file
     */
    private String id;

    /**
     * Purpose of the file.
     */
    private String purpose;

    /**
     * Type of file e.g. image/png
     */
    private String type;

    /**
     * A name of the file suitable for saving to a filesystem.
     */
    private String fileName;

    /**
     * Size in bytes of the file.
     */
    private long size;

    /**
     * Time at which the file expires.
     */
    private Date expires;
}
