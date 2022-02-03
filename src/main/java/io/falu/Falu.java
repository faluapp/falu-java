package io.falu;

import io.falu.services.*;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * Entry-point to the Falu SDK
 */

@Getter
public class Falu {
    private final EvaluationsService evaluationsService;
    private final IdentityService identityService;
    private final MessagesService messagesService;
    private final MoneyBalancesService moneyBalancesService;
    private final PaymentsService paymentsService;
    private final TransfersService transfersService;
    private final FilesService filesService;
    private final WebhooksService webhooksService;
    private final EventsService eventsService;

    public Falu(@NotNull FaluClientOptions options) {
        this.evaluationsService = new EvaluationsService(options);
        this.identityService = new IdentityService(options);
        this.messagesService = new MessagesService(options);
        this.moneyBalancesService = new MoneyBalancesService(options);
        this.paymentsService = new PaymentsService(options);
        this.transfersService = new TransfersService(options);
        this.filesService = new FilesService(options);
        this.webhooksService = new WebhooksService(options);
        this.eventsService = new EventsService(options);
    }
}
