package co.com.sofkau.unidadusar;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.unidadusar.commands.ActualizarTipoUnidad;
import co.com.sofkau.unidadusar.entitys.camion.Camion;
import co.com.sofkau.unidadusar.entitys.camion.CamionId;
import co.com.sofkau.unidadusar.entitys.equipos.Equipos;
import co.com.sofkau.unidadusar.entitys.equipos.EquiposId;
import co.com.sofkau.unidadusar.entitys.rescatista.RescatistaId;
import co.com.sofkau.unidadusar.entitys.rescatista.Rscatista;
import co.com.sofkau.unidadusar.events.TipoUnudadActualizada;
import co.com.sofkau.unidadusar.events.UnidadRescatistaCreada;
import co.com.sofkau.unidadusar.values.PropositoCamion;
import co.com.sofkau.unidadusar.values.TipoCamion;
import co.com.sofkau.unidadusar.values.TipoEquipo;
import co.com.sofkau.unidadusar.values.TipoUnidad;
import co.com.sofkau.usecase.unidadusar.ActualizarTipoUnidadUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


class ActualizarTipoUnidadUseCaseTest {
    private ActualizarTipoUnidadUseCase actualizarTipoUnidadUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp() {
        actualizarTipoUnidadUseCase = new ActualizarTipoUnidadUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        actualizarTipoUnidadUseCase.addRepository(repository);
    }

    @Test
    void ActualizarTipoUnidadCorrectamente() {
        //arrage
        var command = new ActualizarTipoUnidad(UnidadUsarId.of("911"), new TipoUnidad("busqueda"));

        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventsTipoUnidadActuaizado());


        //act

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("911")
                .syncExecutor(actualizarTipoUnidadUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        //assert
        TipoUnudadActualizada actualizarTipoUnidadUseCase = (TipoUnudadActualizada) events.get(0);
        Assertions.assertEquals("busqueda", actualizarTipoUnidadUseCase.tipoUnidad().value());

    }

    private List<DomainEvent> eventsTipoUnidadActuaizado() {
        Set<Rscatista> rscatistas = new HashSet<Rscatista>();
        rscatistas.add(new Rscatista(RescatistaId.of("alfa"), new Nombre("juan charrasqueado"), new Nacionalidad("mexicano"),
                new Edad(19), new Rango("General"), new Genero('H')));
        Set<Camion> camions = new HashSet<Camion>();
        camions.add(new Camion(new CamionId("174"), new TipoCamion("Rescate pesado"), new PropositoCamion("trasporte de equipo pesado")));
        Set<Equipos> equipos = new HashSet<Equipos>();
        equipos.add(new Equipos(new EquiposId(), new TipoEquipo("corte y penetracion")));
        Rscatista encargado = new Rscatista(RescatistaId.of("charly"), new Nombre("diomedes dias"), new Nacionalidad("Colombiano"),
                new Edad(30), new Rango("cabo"), new Genero('H'));


        return List.of(new UnidadRescatistaCreada(new TipoUnidad("busqueda"),
                rscatistas, camions, equipos, encargado));
    }


}