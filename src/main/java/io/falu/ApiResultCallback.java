package io.falu;

/**
 * Generic interface for an API operation callback that either returns a
 * result, [TResult], or an [Exception]
 */
public interface ApiResultCallback<TResult> {
    void onSuccess(TResult result);

    void onError(Exception e);
}
