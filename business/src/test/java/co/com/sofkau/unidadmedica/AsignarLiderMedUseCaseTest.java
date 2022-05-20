package co.com.sofkau.unidadmedica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.operacion.events.OperacionCreada;
import co.com.sofkau.operacion.values.Descripcion;
import co.com.sofkau.operacion.values.Pais;
import co.com.sofkau.operacion.values.Region;
import co.com.sofkau.unidadmedica.commands.AsignarLiderMed;
import co.com.sofkau.unidadmedica.entitys.LiderM.Lider;
import co.com.sofkau.unidadmedica.entitys.LiderM.LiderId;
import co.com.sofkau.unidadmedica.events.LiderMedAsignado;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.usecase.unidadmedica.AsignarLiderMedUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AsignarLiderMedUseCaseTest {

    private AsignarLiderMedUseCase asignarLiderMedUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp() {
        asignarLiderMedUseCase = new AsignarLiderMedUseCase();
        repository = mock(DomainEventRepository.class);
        asignarLiderMedUseCase.addRepository(repository);
    }

    @Test
    void AsignarLiderMedicodCorrectamente() {
        //arrage
        var command = new AsignarLiderMed(new UnidadMedId().of("1"), LiderId.of("12"), new Nombre("juan camilo"), new Nacionalidad("colombiano"),
                new Edad(50), new Rango("medico"), new Genero('M'));

        when(repository.getEventsBy(any())).thenReturn(eventsLiderMedAsignado());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(asignarLiderMedUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        //Assert

        LiderMedAsignado asignarMedLiderUseCase = (LiderMedAsignado) events.get(0);
        Assertions.assertEquals("sofkau.unidadmedica.events.lidermedasignado", asignarMedLiderUseCase.type);
        Assertions.assertEquals("colombiano", asignarMedLiderUseCase.getNacionalidad().value());
        Assertions.assertEquals("juan camilo", asignarMedLiderUseCase.getNombre().value());

    }

    private List<DomainEvent> eventsLiderMedAsignado() {

        Set<UnidadUsarId> unidadUsarIds = new HashSet<>();
        unidadUsarIds.add(UnidadUsarId.of("32"));
        co.com.sofkau.unidadmedica.entitys.LiderM.Lider lider = new Lider(co.com.sofkau.unidadmedica.entitys.LiderM.LiderId.of("123"), new Nombre("Jhon Stiven"), new Nacionalidad("Colombiano"),
                new Edad(35), new Rango("General"), new Genero('H'));
        Set<co.com.sofkau.operacion.entitys.Victima.Victima> victimas = new HashSet<>();



        co.com.sofkau.operacion.entitys.liderO.Lider    LiderO = new co.com.sofkau.operacion.entitys.liderO.Lider(co.com.sofkau.operacion.entitys.liderO.LiderId.of("123"), new Nombre("Jhon Stiven"), new Nacionalidad("Colombiano"),
                new Edad(35), new Rango("General"), new Genero('H'));
        return List.of(new OperacionCreada(unidadUsarIds, LiderO,  new Descripcion("Busqueda victimas"),
                new Region("quilpue"), new Pais("Chile"), new Nombre("busqueda y rescate urbano "),
                victimas));
    }
}