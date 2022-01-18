package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.models.messages.Message;
import io.falu.models.messages.MessageCreateRequest;
import io.falu.models.messages.MessageResponse;
import io.falu.networking.RequestOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Date;
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

}
