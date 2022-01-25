[<img src="https://cdn.falu.io/tools/logo.png" alt="Falu Logo" title="Falu" width="120" height="120" align="right">
](https://www.falu.io)

# Falu JAVA

![GitHub tag (latest by date)][sdk-version]

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
        AppInformation information = AppInformation.builder()
                .name("Java-Tests")
                .version("1.0")
                .build();

        FaluClientOptions options = FaluClientOptions.builder()
                .apiKey("sk_test_123")
                .enableLogging(true)
                .appInformation(information)
                .build();

        EvaluationService service = new EvaluationService(options);
        ResourceResponse<Evaluation> response = service.getEvaluation("evt_123", null);

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
RequestOptions requestOptions=RequestOptions.builder()
        .idempotencyKey("05bc69eb-...")
        .workspace("wrk_1243")
        .live(false)
        .build();

 ResourceResponse<Evaluation> response=service.getEvaluation("evt_123",requestOptions);
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

falu.getPaymentsService().createPayment(request, requestOptions);
```

## Development

For any requests, bug or comments, please [open an issue][issues] or [submit a pull request][pulls].

[api-docs]: https://docs.falu.io/api?lang=dotnet

[service-tests]: https://github.com/tinglesoftware/falu-java/tree/main/src/test/java/io/falu/services

[idempotency-keys]: https://docs.falu.io/guides/developer/idempotency

[issues]: https://github.com/tingle/falu-java/issues/new

[pulls]: https://github.com/tingle/falu-java/pulls

[falu]: https://falu.io

[workspace-settings]: https://dashboard.falu.io/settings

[sdk-version]: https://img.shields.io/github/v/tag/tinglesoftware/falu-java?label=gradle

### License

The Library is licensed under
the [MIT](http://www.opensource.org/licenses/mit-license.php "Read more about the MIT license form") license. Refer to
the [LICENSE](./LICENSE) file for more information.
