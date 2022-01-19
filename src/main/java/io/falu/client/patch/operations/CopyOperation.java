package io.falu.client.patch.operations;

import io.falu.client.patch.JsonPatchOperation;
import lombok.Getter;

@Getter
public class CopyOperation extends JsonPatchOperation {
    private final String from;
    private final String path;

    public CopyOperation(String path, String from) {
        super("copy");
        this.path = path;
        this.from = from;
    }
}
