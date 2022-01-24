package io.falu.models.files;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import okhttp3.MediaType;
import org.jetbrains.annotations.NotNull;

import java.net.URLConnection;
import java.util.Date;

/**
 * Information for creating a file.
 */
@NoArgsConstructor
@Getter
@SuperBuilder
public class FileCreateRequest {
    /**
     * Contents of the file
     */
    @NotNull
    private java.io.File content;

    /**
     * Purpose of the file
     */
    @NotNull
    private String purpose;

    /***/
    @NotNull
    private String description;

    /**
     * Time at which the file expires.
     */
    private Date expires;

    @NotNull
    public MediaType getMediaType() {
        String mimeType = URLConnection.guessContentTypeFromName(content.getName());
        return MediaType.get(mimeType);
    }
}
