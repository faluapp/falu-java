package io.falu.models.messages;

import io.falu.models.AbstractCreationRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
public class MessageCreateRequest extends AbstractCreationRequest {
    /**
     * Destination phone number in ${https://en.wikipedia.org/wiki/E.164} E.164 format</see>.
     */
    private String[] to;

    /**
     * Actual message content to be sent.
     * Required if ${Template} is not specified.
     */
    private String body;

    /**
     * The template to use.
     * Required if ${Body} is not specified.
     */
    private MessageSourceTemplate template;

    /**
     * The stream to use.
     * It can either be the name or unique identifier of the stream.
     * If not provided, message will default to the "transactional" stream.
     */
    private String stream;
}
