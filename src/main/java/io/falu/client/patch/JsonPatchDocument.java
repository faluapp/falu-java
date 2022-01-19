package io.falu.client.patch;

import io.falu.client.patch.operations.*;
import io.falu.models.AbstractCreationRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class JsonPatchDocument<T extends AbstractCreationRequest> {
    private final ArrayList<JsonPatchOperation> operations = new ArrayList<>();

    public JsonPatchDocument<T> add(String path, Object value) {
        operations.add(new AddOperation(path, value));
        return this;
    }

    public JsonPatchDocument<T> remove(String path) {
        operations.add(new RemoveOperation(path));
        return this;
    }

    public JsonPatchDocument<T> replace(String path, Object value) {
        operations.add(new ReplaceOperation(path, value));
        return this;
    }

    public JsonPatchDocument<T> test(String path, Object value) {
        operations.add(new TestOperation(path, value));
        return this;
    }

    public JsonPatchDocument<T> move(String from, String path) {
        operations.add(new MoveOperation(from, path));
        return this;
    }

    public JsonPatchDocument<T> copy(String from, String path) {
        operations.add(new MoveOperation(from, path));
        return this;
    }

    public List<JsonPatchOperation> getOperations() {
        return operations;
    }
}
