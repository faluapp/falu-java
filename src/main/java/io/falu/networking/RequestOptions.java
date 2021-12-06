package io.falu.networking;

import lombok.EqualsAndHashCode;
import lombok.Setter;

/**
 * Options that can be included in all requests/operations.
 */
@EqualsAndHashCode(callSuper = false)
@Setter
public class RequestOptions {
    /**
     * The value to use for idempotent requests.
     * This value is set in the <c>X-Idempotency-Key</c> request header.
     * It can only be set for requests that are not idempotent by default.
     * These are requests/operations that create new data or mutate existing data.
     */
    String idempotencyKey;

    /**
     * The identifier of the workspace to target.
     * This is only required when using user account bearer token, as the user may have access to one or more workspaces.
     * For API key authentication, the key already identifies the workspace.
     * This value is set in the <c>X-Falu-Workspace-Id</c> request header.
     */
    String workspace;

    /**
     * Gets or sets value indicating if the request is targeted to the live or test environment.
     * This is only required when using user account bearer token.
     * For API key authentication, the key already identifies environment.
     * This value is set in the <c>X-Live-Mode</c> request header.
     */
    Boolean live;
}
