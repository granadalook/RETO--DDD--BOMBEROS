package co.com.sofkau.usecase.unidadmedica;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.unidadmedica.UnidadMed;
import co.com.sofkau.unidadmedica.commands.ValorarVictima;

public class ValorarVictimaUseCase extends UseCase<RequestCommand<ValorarVictima>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ValorarVictima> valorarVictimaRequestCommand) {
        var command =valorarVictimaRequestCommand.getCommand();
        var unidadmedica = UnidadMed.from(command.getUnidadMedId(),retrieveEvents(command.getUnidadMedId().value()));

        if(command.getEdad().value()<5)
            throw new BusinessException(command.getUnidadMedId().value(),"menor de 5 años RESCATADO Y VALORADO--- ACTIVAR PROTOCOLO NEONATOS---");

        unidadmedica.valorarVictima(command.getVictimaId(),command.getNombre(),command.getNacionalidad(),
                command.getEdad(),command.getGenero());
        emit().onResponse(new ResponseEvents(unidadmedica.getUncommittedChanges()));

    }
}
