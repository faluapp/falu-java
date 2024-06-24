package io.falu.models.files.links;

import com.google.gson.annotations.JsonAdapter;
import io.falu.client.adapters.ISO8601DateAdapter;
import io.falu.models.core.AbstractCreateOptions;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * A model representing details that can be changed about a file link.
 */
@NoArgsConstructor
@SuperBuilder
public class FileLinkPatchModel extends AbstractCreateOptions {
    /**
     * Time at which the link expires
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    public Date expires;
}
