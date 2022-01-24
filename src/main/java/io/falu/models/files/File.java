package io.falu.models.files;

import com.google.gson.annotations.JsonAdapter;
import io.falu.client.adapters.ISO8601DateAdapter;
import io.falu.models.FaluModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * A file on Falu's servers.
 */
@NoArgsConstructor
@Getter
public class File extends FaluModel {
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
    @JsonAdapter(ISO8601DateAdapter.class)
    private Date expires;
}
