package io.falu.models.messages;

import io.falu.models.core.AbstractCreateOptions;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * A model representing details that can be changed about a message
 */
@Getter
@SuperBuilder
public class MessageUpdateOptions extends AbstractCreateOptions {
}
