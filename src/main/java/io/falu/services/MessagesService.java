package io.falu.services;

import io.falu.ApiResultCallback;
import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.messages.Message;
import io.falu.models.messages.MessageCreateRequest;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MessagesService extends BaseApiService {

    MessagesService(FaluClientOptions options) {
        super(options);
    }

    public void getMessages(@NotNull ApiResultCallback<Message[]> callback) {
        try {
            ResourceResponse<Message[]> response = getApiClient().getMessages();
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void createMessages(@NotNull MessageCreateRequest request, @NotNull ApiResultCallback<Message> callback) {
        try {
            ResourceResponse<Message> response = getApiClient().createMessage(request);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void getMessage(@NotNull String messageId, @NotNull ApiResultCallback<Message> callback) {
        try {
            ResourceResponse<Message> response = getApiClient().getMessage(messageId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void sendBulkMessages(@NotNull List<MessageCreateRequest> messages, @NotNull ApiResultCallback<Message[]> callback) {
        try {
            ResourceResponse<Message[]> response = getApiClient().sendBulkMessages(messages);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

}
