[<img src="https://cdn.falu.io/tools/logo.png" alt="Falu Logo" title="Falu" width="120" height="120" align="right">
](https://www.falu.io)

# Falu JAVA

![GitHub tag (latest by date)][sdk-version]
[![Build and Publish](https://github.com/faluapp/falu-java/actions/workflows/build-release.yml/badge.svg)](https://github.com/faluapp/falu-java/actions/workflows/build-release.yml)

The official [Falu][falu] Java library, supporting Java 1.8+.

## Installation

### Maven

```maven
<dependency>
  <groupId>io.falu</groupId>
  <artifactId>falu-java</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Gradle

```groovy
implementation "io.falu:falu-java:1.0.0"
```

## Documentation

For a comprehensive list of examples, check out the [API documentation][api-docs].

## Usage

FaluExample.java

```java
public class FaluExample {

    public static void main(String[] args) {

        FaluClientOptions options = FaluClientOptions.builder()
                .apiKey("sk_test_123")
                .appInformation(information)
                .build();

        MessagesService service = new MessagesService(options);
        ResourceResponse<Message> response = service.getMessage("msg_123", null);

        if (response != null && response.successful() && response.getResource()) {
            System.out.println(response.getResource().getId());
        }
    }
}
```

See the project's [service tests][service-tests] for more examples.

### Per-request Configuration

All the service request methods accept an optional `RequestOptions` object. This is used if you want to set
an [idempotency key][idempotency-keys].

```java
RequestOptions requestOptions = RequestOptions.builder()
        .idempotencyKey("05bc69eb-...")
        .workspace("wksp_1243")
        .live(false)
        .build();

 ResourceResponse<Message> response = service.getMessage("msg_123",requestOptions);
```

## Messages

With `Falu` you can send both transactional and bulk messages to customers. You can use pre-created templates to
streamline sending of your messages. Below is a sample of how to create a template then used it to send a message.

```java
Falu falu; // brevity omission

// creating message template (only needs to be done once)
MessageTemplateRequest request = MessageTemplateRequest.builder()
    .alias("Loyalty")
    .body("Hi {{name}}! Thanks for being a loyal customer. We appreciate you!")
    .build();

falu.getMessagesService().createMessageTemplate(request, null);

// sending of messages
MessageCreateRequest request = MessageCreateRequest.builder()
        .to(new String[]{"+25472200000"})
        .body(message.getBody())
        .stream("transactional")
        .build();

falu.getMessagesService().createMessages(request, null);
```

> Templates should be created only once before use. Store the template ID or the Alias in your application and use either to reference the template.

## Payments

Below is a sample of how to request money from a customer via MPESA STK Push (a.k.a. Popup, Checkout, etc.).

```java
PaymentCreateRequest request = PaymentCreateRequest.builder()
        .amount(1000)
        .currency("kes")
        .mpesa(MpesaPaymentRequest.builder()
                    .phone("+254722000000")
                    .paybill(true)  // false to tills (a.k.a Buygoods)
                    .reference("<put-your-ref-here>")
                    .destination("<put-short-code-here>")
                    .build()
        )
        .build();

falu.getPaymentsService().createPayment(request, null);
```

> Your incoming account for MPESA must be configured in your [Workspace settings][workspace-settings] before you can initiate an outgoing payment to a customer.

## Transfers

With `Falu` you can send and receive money to and from customers or businesses via multiple payment providers. Below is
a sample of how to send money to a customer via MPESA.

```java
TransferCreateRequestMpesa mpesa=TransferCreateRequestMpesa.builder()
        .customer(TransferCreateRequestMpesaToCustomer.builder().phone("+254722000000").build())
        .build();

        TransferCreateRequest request=TransferCreateRequest.builder()
        .amount(1000)
        .currency("kes")
        .purpose(TransferPurpose.SALARY)
        .mpesa(mpesa)
        .build();

        falu.getTransfersService().createTransfer(request,null);
```

> Your outgoing account for MPESA must be configured in your [Workspace settings][workspace-settings] before you can initiate an outgoing payment to a customer.

## Identity

With `Falu` you can verify your user's identity from a documentation perspective. Below is a sample of how to do verify
the user's phone number against a name or id card.

```java
IdentityVerificationOptionsForDocument document = IdentityVerificationOptionsForDocument.builder()
    .allowed(new String[]{})
    .build();

IdentityVerificationOptions verificationOptions = IdentityVerificationOptions.builder()
    .document(document)
    .build();

IdentityVerificationCreateRequest request = IdentityVerificationCreateRequest.builder()
    .returnUrl("https://my-app.com/verify/waiting?userId=123456")
    .type("document")
    .options(verificationOptions)
    .build();

falu.getIdentityService().searchIdentity(searchModel, null);
```

## Development

For any requests, bug or comments, please [open an issue][issues] or [submit a pull request][pulls].

[api-docs]: https://docs.falu.io/api?lang=dotnet

[service-tests]: https://github.com/faluapp/falu-java/tree/main/src/test/java/io/falu/services

[idempotency-keys]: https://docs.falu.io/guides/developer/idempotency

[issues]: https://github.com/faluapp/falu-java/issues/new

[pulls]: https://github.com/faluapp/falu-java/pulls

[falu]: https://falu.io

[workspace-settings]: https://dashboard.falu.io/settings

[sdk-version]: https://img.shields.io/github/v/tag/faluapp/falu-java?label=gradle

### License

The Library is licensed under
the [MIT](http://www.opensource.org/licenses/mit-license.php "Read more about the MIT license form") license. Refer to
the [LICENSE](./LICENSE) file for more information.
