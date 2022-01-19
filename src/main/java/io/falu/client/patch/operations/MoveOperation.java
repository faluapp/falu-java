package io.falu.client.patch.operations;

import io.falu.client.patch.JsonPatchOperation;
import lombok.Getter;

@Getter
public class MoveOperation extends JsonPatchOperation {
    private final String from;
    private final String path;

    public MoveOperation(String from, String path) {
        super("move");
        this.from = from;
        this.path = path;
    }
}
