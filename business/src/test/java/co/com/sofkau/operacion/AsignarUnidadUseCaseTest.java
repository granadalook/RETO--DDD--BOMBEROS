package co.com.sofkau.operacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.operacion.commands.AsignarUnidadRescatista;
import co.com.sofkau.operacion.entitys.Victima.Victima;
import co.com.sofkau.operacion.entitys.Victima.VictimaId;
import co.com.sofkau.operacion.entitys.liderO.Lider;
import co.com.sofkau.operacion.entitys.liderO.LiderId;
import co.com.sofkau.operacion.events.OperacionCreada;
import co.com.sofkau.operacion.events.UnidadRescatistaAsignada;
import co.com.sofkau.operacion.values.Descripcion;
import co.com.sofkau.generi.values.EdadVictima;
import co.com.sofkau.operacion.values.Pais;
import co.com.sofkau.operacion.values.Region;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.usecase.operacion.AsignarUnidadUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



class AsignarUnidadUseCaseTest {

    private AsignarUnidadUseCase asignarUnidadUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp() {
        asignarUnidadUseCase = new AsignarUnidadUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        asignarUnidadUseCase.addRepository(repository);
    }

    @Test
    void AsignarUnidadCorrectamente() {
        //arrage
        var command = new AsignarUnidadRescatista(OperacionId.of("50"), UnidadUsarId.of("2"));

        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventsUnidadRescatistaAsignada());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("50")
                .syncExecutor(asignarUnidadUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        //Assert
        UnidadRescatistaAsignada asignadaUnidadMilitarUseCase = (UnidadRescatistaAsignada) events.get(0);
        Assertions.assertEquals("sofkau.operacion.events.inidadrescatistaasignada", asignadaUnidadMilitarUseCase.type);

    }

    private List<DomainEvent> eventsUnidadRescatistaAsignada() {

        Set<UnidadUsarId> unidadUsarIds = new HashSet<>();
        unidadUsarIds.add(UnidadUsarId.of("32"));
        Lider lider = new Lider(LiderId.of("123"),new Nombre("Jhon Stiven"),new Nacionalidad("Colombiano"),
                new Edad(35),new Rango("General"),new Genero('M'));
        Set<Victima> victimas = new HashSet<>();
        Victima victima = new Victima(VictimaId.of("45"),new Nombre("Juan Fernando castaño"),
                new Nacionalidad("Chileno"),new EdadVictima(50),new Genero('M'));

        return  List.of(new OperacionCreada(unidadUsarIds,lider, new Descripcion("Busqueda victimas"),
                new Region("quilpue"),new Pais("Chile"),new Nombre("busqueda y rescate urbano "),
                victimas));
    }
}