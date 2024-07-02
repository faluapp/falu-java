package io.falu.models.files.links;

import io.falu.common.Optional;
import io.falu.models.core.AbstractCreateOptions;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * A model representing details that can be changed about a file link.
 */
@NoArgsConstructor
@SuperBuilder
public class FileLinkUpdateOptions extends AbstractCreateOptions {
    /**
     * Time at which the link expires
     */
    public Optional<Date> expires;
}
