package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.client.patch.JsonPatchDocument;
import io.falu.models.messages.Message;
import io.falu.models.messages.MessageCreateRequest;
import io.falu.models.messages.MessagePatchModel;
import io.falu.models.messages.MessageResponse;
import io.falu.models.messages.stream.*;
import io.falu.models.messages.template.*;
import io.falu.networking.RequestOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTests extends BaseApiServiceTests {

    private final Message message = Message.builder()
            .id("msg_123")
            .created(new Date())
            .updated(new Date())
            .to("+254722000000")
            .body("This is a test message")
            .build();

    @Test
    public void test_GettingMessageWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        ResourceResponse<Message> response = service.getMessage(message.getId(), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
        Assertions.assertEquals(message.getId(), response.getResource().getId());
    }

    @Test
    public void test_GettingMessagesWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        ResourceResponse<Message[]> response = service.getMessages(requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_SendingMessageWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        MessageCreateRequest request = MessageCreateRequest.builder()
                .to(new String[]{message.getTo()})
                .body(message.getBody())
                .stream("transactional")
                .build();

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        ResourceResponse<MessageResponse> response = service.createMessages(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_SendingBulkMessagesWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        MessageCreateRequest request = MessageCreateRequest.builder()
                .to(new String[]{message.getTo()})
                .body(message.getBody())
                .stream("transactional")
                .build();

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        MessageCreateRequest[] messages = new MessageCreateRequest[]{request};

        ResourceResponse<MessageResponse> response = service.sendBulkMessages(List.of(messages), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_UpdatingMessageWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        JsonPatchDocument<MessagePatchModel> document = new JsonPatchDocument<MessagePatchModel>()
                .replace("metadata", new HashMap<>());

        ResourceResponse<Message> response = service.updateMessage(message.getId(), document, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GettingMessageTemplateWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        ResourceResponse<MessageTemplate> response = service.getMessageTemplate(message.getId(), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
        Assertions.assertEquals(message.getId(), response.getResource().getId());
    }

    @Test
    public void test_GettingMessageTemplatesWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        ResourceResponse<MessageTemplate[]> response = service.getMessageTemplates(requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreateMessageTemplateWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        MessageTemplateRequest request = MessageTemplateRequest.builder()
                .alias("Loyalty")
                .body("Hi {{name}}! Thanks for being a loyal customer. We appreciate you!")
                .build();
        ResourceResponse<MessageTemplate> response = service.createMessageTemplate(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_UpdateMessageTemplateWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        JsonPatchDocument<MessageTemplatePatchModel> document = new JsonPatchDocument<MessageTemplatePatchModel>()
                .replace("description", "cake");

        ResourceResponse<MessageTemplate> response = service.updateMessageTemplate("", document, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_deleteMessageTemplateWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        ResourceResponse<?> response = service.deleteMessageTemplate(message.getId(), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNull(response.getResource());
    }

    @Test
    public void test_validateMessageTemplateWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "cake");

        MessageTemplateValidationRequest request = MessageTemplateValidationRequest.builder()
                .model(map)
                .body("Hi {{name}}! Thanks for being a loyal customer. We appreciate you!")
                .build();

        ResourceResponse<MessageTemplateValidationResponse> response = service.validateMessageTemplate(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GettingMessageStreamWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        ResourceResponse<MessageStream> response = service.getMessageStream(message.getId(), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetMessageStreamsWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        ResourceResponse<MessageStream[]> response = service.getMessageStreams(requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreateMessageStreamWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        CrossgateSettings crossgateSettings = CrossgateSettings.builder()
                .appKey("cake")
                .appSecret("cake")
                .appSecret("cake")
                .profileId("cake")
                .build();


        MessageStreamCreateRequest request = MessageStreamCreateRequest.builder()
                .name("default")
                .type(MessageStreamType.TRANSACTIONAL)
                .provider(MessageStreamProviderType.CROSS_GATE)
                .settings(MessageStreamSettings.builder().crossgate(crossgateSettings).build())
                .build();

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        ResourceResponse<MessageStream> response = service.getApiClient().createMessageStream(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_UpdateMessageStreamWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        JsonPatchDocument<MessageStreamPatchModel> document = new JsonPatchDocument<MessageStreamPatchModel>()
                .replace("description", "cake");

        ResourceResponse<MessageStream> response = service.updateMessageStream("mstr_123", document, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_DeleteMessageStreamWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        ResourceResponse<?> response = service.deleteMessageStream(message.getId(), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNull(response.getResource());
    }

    @Test
    public void test_ArchiveMessageStreamWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        ResourceResponse<MessageStream> response = service.archiveMessageStream(message.getId(), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNull(response.getResource());
    }

    @Test
    public void test_unarchiveMessageStreamWorks() throws IOException {
        MessagesService service = new MessagesService(options);

        ResourceResponse<MessageStream> response = service.unarchiveMessageStream(message.getId(), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNull(response.getResource());
    }
}
