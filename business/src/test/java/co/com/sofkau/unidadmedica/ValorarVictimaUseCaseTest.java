package co.com.sofkau.unidadmedica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;

import co.com.sofkau.operacion.entitys.liderO.Lider;
import co.com.sofkau.operacion.entitys.liderO.LiderId;
import co.com.sofkau.operacion.events.OperacionCreada;
import co.com.sofkau.operacion.values.Descripcion;
import co.com.sofkau.operacion.values.Pais;
import co.com.sofkau.operacion.values.Region;
import co.com.sofkau.unidadmedica.commands.ValorarVictima;
import co.com.sofkau.unidadmedica.entitys.VictimaR.Victima;
import co.com.sofkau.unidadmedica.entitys.VictimaR.VictimaId;
import co.com.sofkau.unidadmedica.events.VictimaValorada;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.usecase.unidadmedica.ValorarVictimaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ValorarVictimaUseCaseTest {
    private ValorarVictimaUseCase valorarVictimaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp() {
        valorarVictimaUseCase = new ValorarVictimaUseCase();
        repository = mock(DomainEventRepository.class);
        valorarVictimaUseCase.addRepository(repository);
    }


    @Test
    void ValorarVictimaCorrectamente() {
        //Arage
        var command = new ValorarVictima(UnidadMedId.of("123"), VictimaId.of("1"), new Nombre("Jaimito el demalas"),
                new Nacionalidad("Colombiano"), new EdadVictima(42), new Genero('H'));

        when(repository.getEventsBy(any())).thenReturn(eventVictimaAsignada());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor(("123"))
                .syncExecutor(valorarVictimaUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        //Assert
        VictimaValorada victimaValorada = (VictimaValorada) events.get(0);
        Assertions.assertEquals("sofkau.unidadmedica.events.victimavalorada", victimaValorada.type);
        Assertions.assertEquals("Jaimito el demalas", victimaValorada.getNombre().value());
        Assertions.assertEquals(42, victimaValorada.getEdadVictima().value());

    }

    private List<DomainEvent> eventVictimaAsignada() {

        Set<UnidadUsarId> unidadUsarIds = new HashSet<>();
        unidadUsarIds.add(UnidadUsarId.of("32"));
        Lider lider = new Lider(LiderId.of("123"), new Nombre("Jhon Stiven"), new Nacionalidad("Colombiano"),
                new Edad(25), new Rango("General"), new Genero('H'));
        Set<Victima> victimas = new HashSet<>();
        Victima victima = new Victima(VictimaId.of("45"), new Nombre("Juan Fernando castaño"),
                new Nacionalidad("Chileno"), new EdadVictima(50), new Genero('H'));


        Set<co.com.sofkau.operacion.entitys.Victima.Victima> victimaOs = new HashSet<>();
        Victima victimao = new Victima(VictimaId.of("45"), new Nombre("Juan Fernando castaño"),
                new Nacionalidad("Chileno"), new EdadVictima(50), new Genero('H'));;
        return List.of(new OperacionCreada(unidadUsarIds, lider, new Descripcion("Busqueda victimas"),
                new Region("quilpue"), new Pais("Chile"), new Nombre("busqueda y rescate urbano "),
                victimaOs));
    }
}