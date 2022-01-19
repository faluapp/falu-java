package io.falu.client.patch.operations;

import io.falu.client.patch.JsonPatchOperation;

public class CopyOperation extends JsonPatchOperation {
    public CopyOperation(String path, String from) {
        super("copy");
    }
}
