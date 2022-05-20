package co.com.sofkau.usecase.unidadusar;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.unidadusar.events.RscatistaAsignado;

public class NotificarCantidadDeRescatistas extends UseCase<TriggeredEvent<RscatistaAsignado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<RscatistaAsignado> RscatistaAsignadoTriggeredEvent) {
        var event = RscatistaAsignadoTriggeredEvent.getDomainEvent();
        var unidadUsarService = getService(UnidadUsarService.class).orElseThrow();
        var sender = getService(SenderEmailService.class).orElseThrow();

        var email = unidadUsarService.rescatistaNameById(event.rescatistaId());
        sender.sendEmail(email, "Notificacion de cantidad de rescatistas en el area de operacion");

    }
}
