package io.falu.client.patch;

import io.falu.client.patch.operations.*;

import java.util.ArrayList;
import java.util.List;

public class JsonPatchDocument {
    private final ArrayList<JsonPatchOperation> operations = new ArrayList<>();

    public JsonPatchDocument add(String path, Object value) {
        operations.add(new AddOperation(path, value));
        return this;
    }

    public JsonPatchDocument remove(String path) {
        operations.add(new RemoveOperation(path));
        return this;
    }

    public JsonPatchDocument replace(String path, Object value) {
        operations.add(new ReplaceOperation(path, value));
        return this;
    }

    public JsonPatchDocument test(String path, Object value) {
        operations.add(new TestOperation(path, value));
        return this;
    }

    public JsonPatchDocument move(String from, String path) {
        operations.add(new MoveOperation(from, path));
        return this;
    }

    public JsonPatchDocument copy(String from, String path) {
        operations.add(new MoveOperation(from, path));
        return this;
    }

    public List<JsonPatchOperation> getOperations() {
        return operations;
    }
}
