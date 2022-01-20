package io.falu.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * A model representing details that can be changed about a message
 */
@Getter
@SuperBuilder
public class MessagePatchModel extends AbstractCreationRequest {
}
