package io.falu.services;

import io.falu.ApiResultCallback;
import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.messages.Message;
import io.falu.models.messages.MessageCreateRequest;
import io.falu.models.messages.stream.MessageStream;
import io.falu.models.messages.stream.MessageStreamCreateRequest;
import io.falu.models.messages.template.MessageTemplate;
import io.falu.models.messages.template.MessageTemplateRequest;
import io.falu.models.messages.template.MessageTemplateValidationRequest;
import io.falu.models.messages.template.MessageTemplateValidationResponse;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MessagesService extends BaseApiService {

    public MessagesService(FaluClientOptions options) {
        super(options);
    }

    //region Messages
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
    //endregion

    //region Templates
    public void getMessageTemplates(@NotNull ApiResultCallback<MessageTemplate[]> callback) {
        try {
            ResourceResponse<MessageTemplate[]> response = getApiClient().getMessageTemplates();
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void createMessageTemplate(@NotNull MessageTemplateRequest request, @NotNull ApiResultCallback<MessageTemplate> callback) {
        try {
            ResourceResponse<MessageTemplate> response = getApiClient().createMessageTemplate(request);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void getMessageTemplate(@NotNull String templateId, @NotNull ApiResultCallback<MessageTemplate> callback) {
        try {
            ResourceResponse<MessageTemplate> response = getApiClient().getMessageTemplate(templateId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void deleteMessageTemplate(@NotNull String templateId, @NotNull ApiResultCallback<Object> callback) {
        try {
            ResourceResponse<Object> response = getApiClient().deleteMessageTemplate(templateId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void validateMessageTemplate(@NotNull MessageTemplateValidationRequest request, @NotNull ApiResultCallback<MessageTemplateValidationResponse> callback) {
        try {
            ResourceResponse<MessageTemplateValidationResponse> response = getApiClient().validateMessageTemplate(request);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
    //endregion

    //region Streams
    public void getMessageStreams(@NotNull ApiResultCallback<MessageStream[]> callback) {
        try {
            ResourceResponse<MessageStream[]> response = getApiClient().getMessageStreams();
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void createMessageStream(@NotNull MessageStreamCreateRequest request, @NotNull ApiResultCallback<MessageStream> callback) {
        try {
            ResourceResponse<MessageStream> response = getApiClient().createMessageStream(request);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void getMessageStream(@NotNull String streamId, @NotNull ApiResultCallback<MessageStream> callback) {
        try {
            ResourceResponse<MessageStream> response = getApiClient().getMessageStream(streamId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void deleteMessageStream(@NotNull String streamId, @NotNull ApiResultCallback<Object> callback) {
        try {
            ResourceResponse<Object> response = getApiClient().deleteMessageStream(streamId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void archiveMessageStream(@NotNull String streamId, @NotNull ApiResultCallback<MessageStream> callback) {
        try {
            ResourceResponse<MessageStream> response = getApiClient().archiveMessageStream(streamId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void unarchiveMessageStream(@NotNull String streamId, @NotNull ApiResultCallback<MessageStream> callback) {
        try {
            ResourceResponse<MessageStream> response = getApiClient().unarchiveMessageStream(streamId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
    //endregion
}
