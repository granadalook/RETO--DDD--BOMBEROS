package co.com.sofkau.usecase.unidadusar;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.unidadusar.UnidadUsar;
import co.com.sofkau.unidadusar.commands.AsignarRescatista;

public class AsigarRescatistaUseCase extends UseCase<RequestCommand<AsignarRescatista>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarRescatista> AsignarRescatistaRequestCommand) {
        var command = AsignarRescatistaRequestCommand.getCommand();
        var unidadUsar = UnidadUsar.from(command.getUnidadUsarId(), retrieveEvents(command.getUnidadUsarId().value()));

        if (command.getEdad().value() < 18)
            throw new BusinessException(command.getUnidadUsarId().value(), "No pueden haber rescatistas menores de 18 años sin experiencia en el area de operaciones");


        unidadUsar.AsignarRescatista(command.getRescatistaId(), command.getNombre(), command.getNacionalidad(),
                command.getEdad(), command.getRango(), command.getGenero());


        emit().onResponse(new ResponseEvents(unidadUsar.getUncommittedChanges()));

    }
}
