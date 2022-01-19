package io.falu.client.patch;

public abstract class JsonPatchOperation {
    protected String op;

    public JsonPatchOperation(String op) {
        this.op = op;
    }
}
