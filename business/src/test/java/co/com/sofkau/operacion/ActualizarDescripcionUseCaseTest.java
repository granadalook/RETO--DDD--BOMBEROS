package co.com.sofkau.operacion;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.operacion.commands.ActualizarDescripcion;
import co.com.sofkau.operacion.entitys.Victima.Victima;
import co.com.sofkau.operacion.entitys.Victima.VictimaId;
import co.com.sofkau.operacion.entitys.liderO.Lider;
import co.com.sofkau.operacion.entitys.liderO.LiderId;
import co.com.sofkau.operacion.events.DescripcionActualizada;
import co.com.sofkau.operacion.events.OperacionCreada;
import co.com.sofkau.operacion.values.Descripcion;
import co.com.sofkau.generi.values.EdadVictima;
import co.com.sofkau.operacion.values.Pais;
import co.com.sofkau.operacion.values.Region;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.usecase.operacion.ActualizarDescripcionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;
import java.util.Set;




class ActualizarDescripcionUseCaseTest {

    private ActualizarDescripcionUseCase actualizarDescripcionUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        actualizarDescripcionUseCase= new ActualizarDescripcionUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        actualizarDescripcionUseCase.addRepository(repository);
    }
    @Test
    void ActualizarDescripcionCorrectamente(){
        //arrage
        var command = new ActualizarDescripcion(OperacionId.of("125"),new Descripcion("Busqueda y rescate  en las  en chile por terremoto --posibles victimas --"));

        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventsDescripcionActualizado());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("123")
                .syncExecutor(actualizarDescripcionUseCase,new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        //assert

        DescripcionActualizada actualizarDescripcionUseCase = (DescripcionActualizada) events.get(0);
        Assertions.assertEquals("sofkau.operacion.events.descripcionactualizada",actualizarDescripcionUseCase.type);
        Assertions.assertEquals("Busqueda y rescate  en las  en chile por terremoto --posibles victimas --",actualizarDescripcionUseCase.descripcion().value());
    }

    private List<DomainEvent> eventsDescripcionActualizado() {
        Set<UnidadUsarId> unidadUsarIds = new HashSet<>();
        unidadUsarIds.add(UnidadUsarId.of("32"));
        Lider lider = new Lider(LiderId.of("123"),new Nombre("Jhon Stiven"),new Nacionalidad("Colombiano"),
                new Edad(35),new Rango("General"),new Genero('H'));
        Set<Victima> victimas = new HashSet<>();
        Victima victima = new Victima(VictimaId.of("45"),new Nombre("Juan Fernando castaño"),
                new Nacionalidad("Chileno"),new EdadVictima(50),new Genero('H'));

        return  List.of(new OperacionCreada(unidadUsarIds,lider, new Descripcion("Busqueda victimas"),
                new Region("quilpue"),new Pais("Chile"),new Nombre("busqueda y rescate urbano "),
                victimas));
    }
}