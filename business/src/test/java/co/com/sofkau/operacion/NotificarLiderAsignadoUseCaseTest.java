package co.com.sofkau.operacion;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.operacion.entitys.liderO.LiderId;
import co.com.sofkau.operacion.events.LiderAsignado;
import co.com.sofkau.usecase.operacion.NotificarLiderAsignadoUseCase;
import co.com.sofkau.usecase.operacion.OperacionService;
import co.com.sofkau.usecase.operacion.SenderEmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;


class NotificarLiderAsignadoUseCaseTest {
    private NotificarLiderAsignadoUseCase notificarLiderAsignadoUseCase;
    private OperacionService operacionService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setup() {

        notificarLiderAsignadoUseCase = new NotificarLiderAsignadoUseCase();
        operacionService = Mockito.mock(OperacionService.class);
        senderEmailService = Mockito.mock(SenderEmailService.class);
        ServiceBuilder builder = new ServiceBuilder()
                .addService(operacionService)
                .addService(senderEmailService);
        notificarLiderAsignadoUseCase.addServiceBuilder(builder);

    }
    @Test
    void senEmailCorrectamente() {
        //Arrage
        var event = new LiderAsignado(
                LiderId.of("12"), new Nombre("vanessa palacio"), new Nacionalidad("Colombiano"),
                new Edad(35), new Rango("General"), new Genero('M'));
        Mockito.when(operacionService.getLiderNameByOperacionId(ArgumentMatchers.any())).thenReturn("vanessa palacio");
        Mockito.doNothing().when(senderEmailService).sendEmail(ArgumentMatchers.anyString(), ArgumentMatchers.anyString());

        //act

        UseCaseHandler.getInstance()
                .syncExecutor(notificarLiderAsignadoUseCase, new TriggeredEvent<>(event));

        //Assert
        Mockito.verify(operacionService).getLiderNameByOperacionId(ArgumentMatchers.any());
        Mockito.verify(senderEmailService).sendEmail(ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
    }
}