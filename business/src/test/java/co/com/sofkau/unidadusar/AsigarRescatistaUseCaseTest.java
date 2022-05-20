package co.com.sofkau.unidadusar;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.unidadusar.commands.AsignarRescatista;
import co.com.sofkau.unidadusar.entitys.camion.Camion;
import co.com.sofkau.unidadusar.entitys.camion.CamionId;
import co.com.sofkau.unidadusar.entitys.equipos.Equipos;
import co.com.sofkau.unidadusar.entitys.equipos.EquiposId;
import co.com.sofkau.unidadusar.entitys.rescatista.RescatistaId;
import co.com.sofkau.unidadusar.entitys.rescatista.Rscatista;
import co.com.sofkau.unidadusar.events.RscatistaAsignado;
import co.com.sofkau.unidadusar.events.UnidadRescatistaCreada;
import co.com.sofkau.unidadusar.values.*;
import co.com.sofkau.usecase.unidadusar.AsigarRescatistaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



class AsigarRescatistaUseCaseTest {
    private AsigarRescatistaUseCase asigarRescatistaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp() {
        asigarRescatistaUseCase = new AsigarRescatistaUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        asigarRescatistaUseCase.addRepository(repository);
    }

    @Test
    void AsignarrescatistaUnidadCorrectamente() {

        //arrage
        var command = new AsignarRescatista(UnidadUsarId.of("123"), RescatistaId.of("123"),
                new Nombre("juan el terrible"), new Nacionalidad("Colombiano"),
                new Edad(33), new Rango("General"), new Genero('H'));

        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventsRescatistaAsignado());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("123")
                .syncExecutor(asigarRescatistaUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        //assert
        RscatistaAsignado rscatistaAsignado = (RscatistaAsignado) events.get(0);
        Assertions.assertEquals("juan el terrible", rscatistaAsignado.nombre().value());
        Assertions.assertEquals(33, rscatistaAsignado.edad().value());
    }

    private List<DomainEvent> eventsRescatistaAsignado() {
        Set<Rscatista> rscatistas = new HashSet<Rscatista>();
        rscatistas.add(new Rscatista(RescatistaId.of("beta"), new Nombre("michael jackson"), new Nacionalidad("usa"),
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