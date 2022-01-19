package io.falu.client.patch.operations;

import io.falu.client.patch.JsonPatchOperation;
import lombok.Getter;

@Getter
public class ReplaceOperation extends JsonPatchOperation {
    private final String path;
    private final Object value;

    public ReplaceOperation(String path, Object value) {
        super("replace");
        this.path = path;
        this.value = value;
    }
}
