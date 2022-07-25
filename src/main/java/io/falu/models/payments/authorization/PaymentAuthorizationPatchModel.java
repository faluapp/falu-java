package io.falu.models.payments.authorization;

import io.falu.models.core.AbstractCreationRequest;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * Represents the details that can be patched in a payment authorization.
 */
@Getter
@SuperBuilder
public class PaymentAuthorizationPatchModel extends AbstractCreationRequest {
}
