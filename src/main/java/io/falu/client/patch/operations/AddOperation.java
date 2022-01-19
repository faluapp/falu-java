package io.falu.client.patch.operations;

import io.falu.client.patch.JsonPatchOperation;

public class AddOperation extends JsonPatchOperation {

    public AddOperation(String path, Object value) {
        super("add");
    }
}
