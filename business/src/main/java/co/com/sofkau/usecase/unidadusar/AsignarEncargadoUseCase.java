package co.com.sofkau.usecase.unidadusar;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.unidadusar.UnidadUsar;
import co.com.sofkau.unidadusar.commands.AsignarEncargado;

public class AsignarEncargadoUseCase extends UseCase<RequestCommand<AsignarEncargado>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarEncargado> asignarEncargadoRequestCommand) {
        var command = asignarEncargadoRequestCommand.getCommand();
        var unidadUsar = UnidadUsar.from(command.getUnidadUsarId(), retrieveEvents(command.getRescatistaId().value()));

        unidadUsar.AsignarEncargado(command.getRescatistaId(), command.getNombre(), command.getNacionalidad(),
                command.getEdad(), command.getRango(), command.getGenero());
        emit().onResponse(new ResponseEvents((unidadUsar.getUncommittedChanges())));
    }
}