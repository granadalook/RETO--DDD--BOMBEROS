package co.com.sofkau.usecase.operacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.operacion.Operacion;
import co.com.sofkau.operacion.commands.AsignarLider;

public class AsignarLiderUseCase extends UseCase<RequestCommand<AsignarLider>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarLider> asignarLiderRequestCommand){
        var command = asignarLiderRequestCommand.getCommand();
        var operacion = Operacion.from(command.getOperacionId(),retrieveEvents(command.getOperacionId().value()));

        if(command.getEdad().value()<25)
            throw new BusinessException(operacion.identity().value(),"Ningun lider de operacion USAR puede ser menor de 25 años");

        operacion.asignarLider(command.getLiderId(),command.getNombre(),command.getNacionalidad(),command.getEdad(),
                command.getRango(),command.getGenero());

        emit().onResponse(new ResponseEvents(operacion.getUncommittedChanges()));

    }
}