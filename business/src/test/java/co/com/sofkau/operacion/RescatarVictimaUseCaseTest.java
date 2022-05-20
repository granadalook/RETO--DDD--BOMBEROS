package co.com.sofkau.operacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.operacion.commands.RescatarVictima;
import co.com.sofkau.operacion.entitys.Victima.Victima;
import co.com.sofkau.operacion.entitys.Victima.VictimaId;
import co.com.sofkau.operacion.entitys.liderO.Lider;
import co.com.sofkau.operacion.entitys.liderO.LiderId;
import co.com.sofkau.operacion.events.OperacionCreada;
import co.com.sofkau.operacion.events.VictimaRescatada;
import co.com.sofkau.operacion.values.Descripcion;
import co.com.sofkau.generi.values.EdadVictima;
import co.com.sofkau.operacion.values.Pais;
import co.com.sofkau.operacion.values.Region;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.usecase.operacion.RescatarVictimaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



class RescatarVictimaUseCaseTest {

    private RescatarVictimaUseCase rescatarVictimaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        rescatarVictimaUseCase = new RescatarVictimaUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        rescatarVictimaUseCase.addRepository(repository);
    }


    @Test
    void RescatarVictimaCorrectamente(){
        //Arage
        var command = new RescatarVictima(OperacionId.of("123"), VictimaId.of("1"),new Nombre("Jaimito el demalas"),
                new Nacionalidad("Colombiano"),new EdadVictima(42),new Genero('H'));

        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventVictimaAsignada());

        //act
        var response= UseCaseHandler.getInstance()
                .setIdentifyExecutor(("123"))
                .syncExecutor(rescatarVictimaUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        //Assert
        VictimaRescatada victimaRescatada = (VictimaRescatada) events.get(0);
        Assertions.assertEquals("sofkau.operacion.events.victimarescatada",victimaRescatada.type);
        Assertions.assertEquals("Jaimito el demalas", victimaRescatada.getNombre().value());
        Assertions.assertEquals(42,victimaRescatada.getEdadVictima().value());

    }

    private List<DomainEvent> eventVictimaAsignada() {

        Set<UnidadUsarId> unidadUsarIds = new HashSet<>();
        unidadUsarIds.add(UnidadUsarId.of("32"));
        Lider lider = new Lider(LiderId.of("123"),new Nombre("Jhon Stiven"),new Nacionalidad("Colombiano"),
                new Edad(25),new Rango("General"),new Genero('H'));
        Set<Victima> victimas = new HashSet<>();
        Victima victima = new Victima(VictimaId.of("45"),new Nombre("Juan Fernando castaño"),
                new Nacionalidad("Chileno"),new EdadVictima(50),new Genero('H'));

        return  List.of(new OperacionCreada(unidadUsarIds,lider, new Descripcion("Busqueda victimas"),
                new Region("quilpue"),new Pais("Chile"),new Nombre("busqueda y rescate urbano "),
                victimas));
    }
}