package co.com.sofkau.usecase.operacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.operacion.Operacion;
import co.com.sofkau.operacion.commands.RescatarVictima;

public class RescatarVictimaUseCase extends UseCase<RequestCommand<RescatarVictima>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<RescatarVictima> rescatarVictimaRequestCommand) {
        var command = rescatarVictimaRequestCommand.getCommand();
        var operacion = Operacion.from(command.getOperacionId(), retrieveEvents(command.getOperacionId().value()));

        if (command.getEdad().value() < 5)
            throw new BusinessException(command.getOperacionId().value(), "menor de 5 años rescatado ACTIVAR PROTOCOLO NEONATOS");

        operacion.rescatarVictima(command.getVictimaId(), command.getNombre(), command.getNacionalidad(),
                command.getEdad(), command.getGenero());
        emit().onResponse(new ResponseEvents(operacion.getUncommittedChanges()));

    }
}