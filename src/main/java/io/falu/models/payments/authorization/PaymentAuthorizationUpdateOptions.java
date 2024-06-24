package io.falu.models.payments.authorization;

import io.falu.models.core.AbstractCreateOptions;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * Represents the details that can be patched in a payment authorization.
 */
@Getter
@SuperBuilder
public class PaymentAuthorizationUpdateOptions extends AbstractCreateOptions {
}
