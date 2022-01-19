package io.falu.client.patch.operations;

import io.falu.client.patch.JsonPatchOperation;
import lombok.Getter;

@Getter
public class AddOperation extends JsonPatchOperation {
    private final String path;
    private final Object value;

    public AddOperation(String path, Object value) {
        super("add");
        this.path = path;
        this.value = value;
    }
}
