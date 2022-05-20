package co.com.sofkau.operacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.operacion.commands.AsignarLider;
import co.com.sofkau.operacion.entitys.Victima.Victima;
import co.com.sofkau.operacion.entitys.Victima.VictimaId;
import co.com.sofkau.operacion.entitys.liderO.Lider;
import co.com.sofkau.operacion.entitys.liderO.LiderId;
import co.com.sofkau.operacion.events.LiderAsignado;
import co.com.sofkau.operacion.events.OperacionCreada;
import co.com.sofkau.operacion.values.Descripcion;
import co.com.sofkau.generi.values.EdadVictima;
import co.com.sofkau.operacion.values.Pais;
import co.com.sofkau.operacion.values.Region;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.usecase.operacion.AsignarLiderUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



class AsignarLiderUseCaseTest {


    private AsignarLiderUseCase asignarLiderUseCase;
    private DomainEventRepository repository;


    @BeforeEach
    public void setUp(){
        asignarLiderUseCase = new AsignarLiderUseCase();
        repository= Mockito.mock(DomainEventRepository.class);
        asignarLiderUseCase.addRepository(repository);
    }



    @Test
    void AsignarLiderdCorrectamente() {
        //arrage
        var command = new AsignarLider(OperacionId.of("1"), LiderId.of("12"), new Nombre("juan camilo"), new Nacionalidad("colombiano"),
                new Edad(50), new Rango("bombero"), new Genero('M'));

        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventsLiderAsignado());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(asignarLiderUseCase,new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        //Assert

        LiderAsignado asignarLiderUseCase = (LiderAsignado) events.get(0);
        Assertions.assertEquals("sofkau.operacion.events.liderasignado",asignarLiderUseCase.type);
        Assertions.assertEquals("colombiano",asignarLiderUseCase.nacionalidad().value());
        Assertions.assertEquals("juan camilo",asignarLiderUseCase.nombre().value());

    }

    private List<DomainEvent> eventsLiderAsignado() {

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