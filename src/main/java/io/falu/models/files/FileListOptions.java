package io.falu.models.files;

import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Options for filtering and pagination of list files
 */
@NoArgsConstructor
@SuperBuilder
public class FileListOptions extends BasicListOptions {
    /**
     * Filter options for ${purpose} property.
     */
    private String[] purpose;

    @Override
    public void populate(QueryValues values) {
        super.populate(values);
        values.add("purpose", purpose);
    }
}
