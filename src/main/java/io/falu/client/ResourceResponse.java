package io.falu.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import okhttp3.Headers;

/**
 * Abstraction of HTTP response to an API
 *
 * @param <TResource> the type of resource
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class ResourceResponse<TResource> {
    // the status code of the response
    Integer statusCode;

    // the headers of the response
    Headers headers;

    // the de-serialized resource
    TResource resource;

    // error de-serialized from the response
    HttpResponseProblem error;
}
