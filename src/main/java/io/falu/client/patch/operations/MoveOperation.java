package io.falu.client.patch.operations;

import io.falu.client.patch.JsonPatchOperation;

public class MoveOperation extends JsonPatchOperation {
    public MoveOperation(String from, String path) {
        super("move");
    }
}
