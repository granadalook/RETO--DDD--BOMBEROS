package co.com.sofkau.unidadusar;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.unidadusar.entitys.rescatista.RescatistaId;
import co.com.sofkau.unidadusar.events.RscatistaAsignado;
import co.com.sofkau.usecase.unidadusar.NotificarCantidadDeRescatistas;
import co.com.sofkau.usecase.unidadusar.SenderEmailService;
import co.com.sofkau.usecase.unidadusar.UnidadUsarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;


class NotificarCantidadDeRescatistasTest {
    private NotificarCantidadDeRescatistas notificarCantidadDeRescatistas;
    private UnidadUsarService unidadUsarService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setUp() {
        notificarCantidadDeRescatistas = new NotificarCantidadDeRescatistas();
        unidadUsarService = Mockito.mock(UnidadUsarService.class);
        senderEmailService = Mockito.mock(SenderEmailService.class);
        ServiceBuilder builder = new ServiceBuilder()
                .addService(unidadUsarService)
                .addService(senderEmailService);
        notificarCantidadDeRescatistas.addServiceBuilder(builder);
    }


    @Test
    void sendEmailCorrectamente() {
        //Arrage
        var event = new RscatistaAsignado(RescatistaId.of("565"), new Nombre("mr been"),
                new Nacionalidad("inglaterra"), new Edad(20), new Rango("Cabo"), new Genero('H'));

        Mockito.when(unidadUsarService.rescatistaNameById(ArgumentMatchers.any())).thenReturn("mr been");
        Mockito.doNothing().when(senderEmailService).sendEmail(ArgumentMatchers.anyString(), ArgumentMatchers.anyString());


        //act
        UseCaseHandler.getInstance()
                .syncExecutor(notificarCantidadDeRescatistas, new TriggeredEvent<>(event));

        //act

        Mockito.verify(unidadUsarService).rescatistaNameById(ArgumentMatchers.any());
        Mockito.verify(senderEmailService).sendEmail(ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
    }

}