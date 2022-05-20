package co.com.sofkau.unidadusar;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.unidadusar.commands.AgregarEquipos;
import co.com.sofkau.unidadusar.entitys.camion.Camion;
import co.com.sofkau.unidadusar.entitys.camion.CamionId;
import co.com.sofkau.unidadusar.entitys.equipos.Equipos;
import co.com.sofkau.unidadusar.entitys.equipos.EquiposId;
import co.com.sofkau.unidadusar.entitys.rescatista.RescatistaId;
import co.com.sofkau.unidadusar.entitys.rescatista.Rscatista;
import co.com.sofkau.unidadusar.events.EquiposAgregados;
import co.com.sofkau.unidadusar.events.UnidadRescatistaCreada;
import co.com.sofkau.unidadusar.values.*;
import co.com.sofkau.usecase.unidadusar.AgregarEquiposUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;
import java.util.Set;




class AgregarEquiposUseCaseTest {
    private AgregarEquiposUseCase agregarEquiposUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        agregarEquiposUseCase = new AgregarEquiposUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        agregarEquiposUseCase.addRepository(repository);
    }


    @Test
    void AgregarEquiposCorrectamente(){
        //arrage
        var command = new AgregarEquipos(UnidadUsarId.of("845"), EquiposId.of("548"),new TipoEquipo("cortadora de plasta"));

        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventsAgregarArmamento());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("845")
                .syncExecutor(agregarEquiposUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        //
        EquiposAgregados equiposAgregados = (EquiposAgregados) events.get(0);
        Assertions.assertEquals("sofkau.unidadusar.events.equiposagregados",equiposAgregados.type);
        Assertions.assertEquals("cortadora de plasta",equiposAgregados.tipoEquipo().value());

    }

    private List<DomainEvent> eventsAgregarArmamento() {
        Set<Rscatista> rscatistas = new HashSet<Rscatista>();
        rscatistas.add(new Rscatista(RescatistaId.of("alfa"),new Nombre("juan charrasqueado"),new Nacionalidad("mexicano"),
                new Edad(19),new Rango("General"), new Genero('H')));
        Set<Camion> camions = new HashSet<Camion>();
        camions.add(new Camion(new CamionId("174"),new TipoCamion("Rescate pesado"), new PropositoCamion("trasporte de equipo pesado")));
        Set<Equipos> equipos = new HashSet<Equipos>();
        equipos.add(new Equipos(new EquiposId(),new TipoEquipo("corte y penetracion") ));
        Rscatista encargado = new Rscatista(RescatistaId.of("charly"),new Nombre("diomedes dias"),new Nacionalidad("Colombiano"),
                new Edad(30),new Rango("cabo"), new Genero('H'));


        return List.of(new UnidadRescatistaCreada(new TipoUnidad("busqueda"),
                rscatistas,camions,equipos,encargado));
    }

}