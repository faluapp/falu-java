package io.falu.models.files.links;

import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Options for filtering and pagination of list file links.
 */
@NoArgsConstructor
@Getter
@SuperBuilder
public class FileLinksListOptions extends BasicListOptions {
    /**
     * Unique identifier of the file.
     */
    private String file;

    /**
     * Filter options for ${FileLink.expired} property.
     */
    private Boolean expired;

    @Override
    public void populate(QueryValues values) {
        super.populate(values);
        values
                .add("file", file)
                .add("expired", expired);
    }
}
