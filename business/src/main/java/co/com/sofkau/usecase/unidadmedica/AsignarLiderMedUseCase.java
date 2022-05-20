package co.com.sofkau.usecase.unidadmedica;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.unidadmedica.UnidadMed;
import co.com.sofkau.unidadmedica.commands.AsignarLiderMed;

public class AsignarLiderMedUseCase extends UseCase<RequestCommand<AsignarLiderMed>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarLiderMed> asignarLiderMedRequestCommand){
        var command = asignarLiderMedRequestCommand.getCommand();
        var unidadmedica = UnidadMed.from(command.getOperacionId(),retrieveEvents(command.getOperacionId().value()));

        if(command.getEdad().value()<18)
            throw new BusinessException(unidadmedica.identity().value(),"Ningun lider de UNIDAD MEDICA USAR puede ser menor de 18 años");

        unidadmedica.asignarLiderMed(command.getLiderId(),command.getNombre(),command.getNacionalidad(),command.getEdad(),
                command.getRango(),command.getGenero());

        emit().onResponse(new ResponseEvents(unidadmedica.getUncommittedChanges()));
    }

}