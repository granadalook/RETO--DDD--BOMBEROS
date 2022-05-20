package co.com.sofkau.usecase.unidadusar;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.unidadusar.UnidadUsar;
import co.com.sofkau.unidadusar.commands.CrearUnidadUsar;

public class CrearUnidadUsarUseCase extends UseCase<RequestCommand<CrearUnidadUsar>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearUnidadUsar> CrearUnidadUsarRequestCommand) {
        var command = CrearUnidadUsarRequestCommand.getCommand();
        var unidadUsar = new UnidadUsar(command.unidadUsarId(), command.tipoUnidad(), command.rscatistas(),
                command.camions(), command.equipos(), command.encargado());

        if (command.rscatistas().contains(command.encargado()))
            throw new IllegalArgumentException("El encagado no puede estar entre los rescatistas de la unidad, asegurese de retirarlo de las fuertas de tarea primero.");

        emit().onResponse(new ResponseEvents(unidadUsar.getUncommittedChanges()));
    }
}
