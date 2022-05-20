package co.com.sofkau.usecase.unidadusar;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.unidadusar.UnidadUsar;
import co.com.sofkau.unidadusar.commands.AgregarEquipos;
import co.com.sofkau.unidadusar.entitys.equipos.EquiposId;

public class AgregarEquiposUseCase extends UseCase<RequestCommand<AgregarEquipos>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarEquipos> agregarEquiposRequestCommand) {
        var command = agregarEquiposRequestCommand.getCommand();
        var unidadUsar = UnidadUsar.from(command.getUnidadUsarId(), retrieveEvents(command.getEquiposId().value()));

        unidadUsar.AgregarEquipo(EquiposId.of("587"), command.getTipoEquipo());
        emit().onResponse(new ResponseEvents(unidadUsar.getUncommittedChanges()));
    }
}