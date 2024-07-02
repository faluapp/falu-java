package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.common.Optional;
import io.falu.models.messages.*;
import io.falu.models.messages.stream.*;
import io.falu.models.messages.template.*;
import io.falu.networking.RequestOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTests extends BaseApiServiceTests {

    private final Message message = Message.builder()
        .id("msg_123")
        .created(new Date())
        .updated(new Date())
        .to("+254722000000")
        .body("This is a test message")
        .build();

    private final MessageResponse messageResponse = MessageResponse.builder()
        .ids(new String[]{"msg_123"})
        .build();

    private final MessageTemplate messageTemplate = MessageTemplate.builder()
        .id("tmp_123")
        .build();

    private final MessageStream messageStream = MessageStream.builder()
        .id("str_123")
        .defaultStream(true)
        .provider("crossgate")
        .type("transactional")
        .build();

    @Mock
    private MessagesService service;

    @Test
    public void test_GettingMessageWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        ResourceResponse<Message> expectedResponse = getResourceResponse(200, message);
        when(service.getMessage(message.getId(), requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, message));

        ResourceResponse<Message> response = service.getMessage(message.getId(), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
        Assertions.assertEquals(message.getId(), response.getResource().getId());
    }

    @Test
    public void test_GettingMessagesWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        MessagesListOptions opt = MessagesListOptions.builder()
            .count(1)
            .build();

        ResourceResponse<Message[]> expectedResponse = getResourceResponse(200, new Message[]{message});
        when(service.getMessages(opt, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, new Message[]{message}));

        ResourceResponse<Message[]> response = service.getMessages(opt, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_SendingMessageWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        MessageCreateOptions request = MessageCreateOptions.builder()
            .to(new String[]{message.getTo()})
            .body(message.getBody())
            .stream("transactional")
            .build();

        ResourceResponse<MessageResponse> expectedResponse = getResourceResponse(200, messageResponse);
        when(service.createMessages(request, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));

        ResourceResponse<MessageResponse> response = service.createMessages(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_SendingBulkMessagesWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        MessageCreateOptions request = MessageCreateOptions.builder()
            .to(new String[]{message.getTo()})
            .body(message.getBody())
            .stream("transactional")
            .build();

        MessageCreateOptions[] messages = new MessageCreateOptions[]{request};

        ResourceResponse<MessageResponse> expectedResponse = getResourceResponse(200, messageResponse);
        when(service.sendBulkMessages(List.of(messages), requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));

        ResourceResponse<MessageResponse> response = service.sendBulkMessages(List.of(messages), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_UpdatingMessageWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        MessageUpdateOptions updateOptions = MessageUpdateOptions.builder()
            .metadata(Optional.of(new HashMap<>()))
            .build();

        ResourceResponse<Message> expectedResponse = getResourceResponse(200, message);
        when(service.updateMessage(message.getId(), updateOptions, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));

        // when
        ResourceResponse<Message> response = service.updateMessage(message.getId(), updateOptions, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GettingMessageTemplateWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<MessageTemplate> expectedResponse = getResourceResponse(200, messageTemplate);
        when(service.getMessageTemplate(messageTemplate.getId(), requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));

        // when
        ResourceResponse<MessageTemplate> response = service.getMessageTemplate(messageTemplate.getId(), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
        Assertions.assertEquals(messageTemplate.getId(), response.getResource().getId());
    }

    @Test
    public void test_GettingMessageTemplatesWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        MessageTemplatesListOptions opt = MessageTemplatesListOptions.builder()
            .count(1)
            .build();

        // given
        ResourceResponse<MessageTemplate[]> expectedResponse = getResourceResponse(200, new MessageTemplate[]{messageTemplate});
        when(service.getMessageTemplates(opt, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));

        //when
        ResourceResponse<MessageTemplate[]> response = service.getMessageTemplates(opt, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreateMessageTemplateWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        MessageTemplateCreateOptions request = MessageTemplateCreateOptions.builder()
            .alias("Loyalty")
            .body("Hi {{name}}! Thanks for being a loyal customer. We appreciate you!")
            .build();

        // given
        ResourceResponse<MessageTemplate> expectedResponse = getResourceResponse(200, messageTemplate);
        when(service.createMessageTemplate(request, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));

        // when
        ResourceResponse<MessageTemplate> response = service.createMessageTemplate(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_UpdateMessageTemplateWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        MessageTemplateUpdateOptions patchModel = MessageTemplateUpdateOptions.builder().description(Optional.of("cake")).build();

        // given
        ResourceResponse<MessageTemplate> expectedResponse = getResourceResponse(200, messageTemplate);
        when(service.updateMessageTemplate("tmp_123", patchModel, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));

        // when
        ResourceResponse<MessageTemplate> response = service.updateMessageTemplate("tmp_123", patchModel, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_deleteMessageTemplateWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        RequestOptions requestOptions = RequestOptions.builder()
            .live(false)
            .build();

        // given
        ResourceResponse expectedResponse = getResourceResponse(200, null);
        when(service.deleteMessageTemplate(message.getId(), requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, null));

        // given
        ResourceResponse<?> response = service.deleteMessageTemplate(message.getId(), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNull(response.getResource());
    }

    @Test
    public void test_validateMessageTemplateWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "cake");

        MessageTemplateValidationRequest request = MessageTemplateValidationRequest.builder()
            .model(map)
            .body("Hi {{name}}! Thanks for being a loyal customer. We appreciate you!")
            .build();

        MessageTemplateValidationResponse validationResponse = new MessageTemplateValidationResponse();

        // given
        ResourceResponse<MessageTemplateValidationResponse> expectedResponse = getResourceResponse(200, validationResponse);
        when(service.validateMessageTemplate(request, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));

        // when
        ResourceResponse<MessageTemplateValidationResponse> response = service.validateMessageTemplate(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GettingMessageStreamWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<MessageStream> expectedResponse = getResourceResponse(200, messageStream);
        when(service.getMessageStream(message.getId(), requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));

        // when
        ResourceResponse<MessageStream> response = service.getMessageStream(message.getId(), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetMessageStreamsWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        MessageStreamsListOptions opt = MessageStreamsListOptions.builder()
            .count(1)
            .build();

        ResourceResponse<MessageStream[]> expectedResponse = getResourceResponse(200, new MessageStream[]{messageStream});
        when(service.getMessageStreams(opt, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));

        ResourceResponse<MessageStream[]> response = service.getMessageStreams(opt, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreateMessageStreamWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        CrossgateSettings crossgateSettings = CrossgateSettings.builder()
            .appKey("cake")
            .appSecret("cake")
            .appSecret("cake")
            .profileId("cake")
            .build();


        MessageStreamCreateOptions request = MessageStreamCreateOptions.builder()
            .name("default")
            .type("transactional")
            .provider("crossgate")
            .settings(MessageStreamSettings.builder().crossgate(crossgateSettings).build())
            .build();

        // given
        ResourceResponse<MessageStream> expectedResponse = getResourceResponse(200, messageStream);
        when(service.createMessageStream(request, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));


        // when
        ResourceResponse<MessageStream> response = service.createMessageStream(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_UpdateMessageStreamWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        MessageStreamUpdateOptions updateOptions = MessageStreamUpdateOptions.builder()
            .description(Optional.of("cake"))
            .build();

        // given
        ResourceResponse<MessageStream> expectedResponse = getResourceResponse(200, messageStream);
        when(service.updateMessageStream("mstr_123", updateOptions, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));

        // when
        ResourceResponse<MessageStream> response = service.updateMessageStream("mstr_123", updateOptions, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_DeleteMessageStreamWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse expectedResponse = getResourceResponse(200, null);
        when(service.deleteMessageStream(message.getId(), requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));

        // when
        ResourceResponse<?> response = service.deleteMessageStream(message.getId(), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNull(response.getResource());
    }

    @Test
    public void test_ArchiveMessageStreamWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<MessageStream> expectedResponse = getResourceResponse(200, messageStream);
        when(service.archiveMessageStream(messageStream.getId(), requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));

        // when
        ResourceResponse<MessageStream> response = service.archiveMessageStream(messageStream.getId(), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_unarchiveMessageStreamWorks() throws IOException {
        service = Mockito.mock(MessagesService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<MessageStream> expectedResponse = getResourceResponse(200, messageStream);
        when(service.unarchiveMessageStream(message.getId(), requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, messageResponse));

        // when
        ResourceResponse<MessageStream> response = service.unarchiveMessageStream(message.getId(), requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }
}
