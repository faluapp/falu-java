package io.falu.client.patch.operations;

import io.falu.client.patch.JsonPatchOperation;

public class RemoveOperation extends JsonPatchOperation {
    public RemoveOperation(String path) {
        super("remove");
    }
}
