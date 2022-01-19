package io.falu.client.patch.operations;

import io.falu.client.patch.JsonPatchOperation;
import lombok.Getter;

@Getter
public class TestOperation extends JsonPatchOperation {
    private final String path;
    private final Object value;

    public TestOperation(String path, Object value) {
        super("test");
        this.path = path;
        this.value = value;
    }
}
