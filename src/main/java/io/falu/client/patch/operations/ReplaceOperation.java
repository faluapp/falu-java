package io.falu.client.patch.operations;

import io.falu.client.patch.JsonPatchOperation;

public class ReplaceOperation extends JsonPatchOperation {
    public ReplaceOperation(String path, Object value) {
        super("replace");
    }
}
