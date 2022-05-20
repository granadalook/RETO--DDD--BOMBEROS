package co.com.sofkau.usecase.operacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.operacion.Operacion;
import co.com.sofkau.operacion.commands.CrearOperacion;

public class CrearOperacionUseCase extends UseCase<RequestCommand<CrearOperacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearOperacion> crearOperacionRequestCommand) {
        var command = crearOperacionRequestCommand.getCommand();
        var operacion = new Operacion(command.getOperacionId(), command.getUnidadUsarIds(), command.getLider(),
                command.getDescripcion(), command.getRegion(), command.getPais(), command.getNombre(), command.getVictimas());

        if (command.getLider().edad().value() < 25)
            throw new BusinessException(command.getOperacionId().value(), "Ningun encargado de operacion puede tener menos de 25 anos de edad");

        if (command.getUnidadUsarIds().size() < 1)
            throw new BusinessException(command.getOperacionId().value(), "No pueden existir operaciones sin unidades USAR rescatistas  asignados");

        emit().onResponse(new ResponseEvents(operacion.getUncommittedChanges()));
    }
}