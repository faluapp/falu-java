package io.falu.client.patch.operations;

import io.falu.client.patch.JsonPatchOperation;
import lombok.Getter;

@Getter
public class RemoveOperation extends JsonPatchOperation {
    private final String path;

    public RemoveOperation(String path) {
        super("remove");
        this.path = path;
    }
}
