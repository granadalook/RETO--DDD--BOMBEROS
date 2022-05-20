package co.com.sofkau.unidadusar;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.unidadusar.commands.CrearUnidadUsar;
import co.com.sofkau.unidadusar.entitys.camion.Camion;
import co.com.sofkau.unidadusar.entitys.camion.CamionId;
import co.com.sofkau.unidadusar.entitys.equipos.Equipos;
import co.com.sofkau.unidadusar.entitys.equipos.EquiposId;
import co.com.sofkau.unidadusar.entitys.rescatista.RescatistaId;
import co.com.sofkau.unidadusar.entitys.rescatista.Rscatista;
import co.com.sofkau.unidadusar.events.UnidadRescatistaCreada;
import co.com.sofkau.unidadusar.values.PropositoCamion;
import co.com.sofkau.unidadusar.values.TipoCamion;
import co.com.sofkau.unidadusar.values.TipoEquipo;
import co.com.sofkau.unidadusar.values.TipoUnidad;
import co.com.sofkau.usecase.unidadusar.CrearUnidadUsarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class CrearUnidadUsarUseCaseTest {
    private CrearUnidadUsarUseCase crearUnidadUsarUseCase;


    @BeforeEach
    public void setup() {
        crearUnidadUsarUseCase = new CrearUnidadUsarUseCase();
    }


    @Test
    public void crearUnidadUsarHappyPath() {
        //arrange

        Set<Rscatista> rscatistas = new HashSet<Rscatista>();
        rscatistas.add(new Rscatista(RescatistaId.of("negativo"), new Nombre("pinpinela"), new Nacionalidad("mexicana"),
                new Edad(45), new Rango("General"), new Genero('M')));

        Set<Camion> camions = new HashSet<Camion>();
        camions.add(new Camion(new CamionId("154"), new TipoCamion("extintora"), new PropositoCamion("prevencion de incendios")));

        Set<Equipos> equipos = new HashSet<Equipos>();
        equipos.add(new Equipos(new EquiposId(), new TipoEquipo("Mandarria")));


        Rscatista encargado = new Rscatista(RescatistaId.of("segundo"), new Nombre("Alejandro"), new Nacionalidad("Colombiano"),
                new Edad(30), new Rango("cabo"), new Genero('H'));


        var command = new CrearUnidadUsar(UnidadUsarId.of("123456"), new TipoUnidad("localizacion"),
                rscatistas, camions, equipos, encargado);


        //act
        var response = UseCaseHandler.getInstance()
                .syncExecutor(crearUnidadUsarUseCase, new RequestCommand<>(command))
                .orElseThrow();


        var events = response.getDomainEvents();

        //Asserts

        UnidadRescatistaCreada unidadRescatistaCreada = (UnidadRescatistaCreada) events.get(0);
        Assertions.assertEquals("Alejandro", unidadRescatistaCreada.encargado().nombre().value());
        Assertions.assertEquals('H', unidadRescatistaCreada.encargado().genero().value());
        Assertions.assertEquals(1, rscatistas.size());
    }
}