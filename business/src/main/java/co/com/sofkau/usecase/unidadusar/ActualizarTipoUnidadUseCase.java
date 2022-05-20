package co.com.sofkau.usecase.unidadusar;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.unidadusar.UnidadUsar;
import co.com.sofkau.unidadusar.commands.ActualizarTipoUnidad;

public class ActualizarTipoUnidadUseCase extends UseCase<RequestCommand<ActualizarTipoUnidad>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarTipoUnidad> actualizadaTipoUnidadRequestCommand) {
        var command = actualizadaTipoUnidadRequestCommand.getCommand();
        var unidadUsar = UnidadUsar.from(command.getUnidadUsarId(), retrieveEvents(command.getUnidadUsarId().value()));

        unidadUsar.ActualizarTipoUnidad(command.getTipoUnidad());
        emit().onResponse(new ResponseEvents(unidadUsar.getUncommittedChanges()));
    }
}