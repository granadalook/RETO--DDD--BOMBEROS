package co.com.sofkau.usecase.operacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.operacion.Operacion;
import co.com.sofkau.operacion.commands.AsignarUnidadRescatista;

public class AsignarUnidadUseCase extends UseCase<RequestCommand<AsignarUnidadRescatista>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarUnidadRescatista> AsignarUnidadRescatistaRequestCommand){
        var command =AsignarUnidadRescatistaRequestCommand.getCommand();
        var operacion = Operacion.from(command.getOperacionId(),retrieveEvents(command.getOperacionId().value()));



        operacion.asignarUnidad(command.getUnidadUsarId());
        emit().onResponse(new ResponseEvents(operacion.getUncommittedChanges()));

    }
}