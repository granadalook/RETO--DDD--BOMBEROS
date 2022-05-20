package co.com.sofkau.operacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.operacion.commands.CrearOperacion;
import co.com.sofkau.operacion.entitys.Victima.Victima;
import co.com.sofkau.operacion.entitys.liderO.Lider;
import co.com.sofkau.operacion.entitys.liderO.LiderId;
import co.com.sofkau.operacion.events.OperacionCreada;
import co.com.sofkau.operacion.values.Descripcion;
import co.com.sofkau.operacion.values.Pais;
import co.com.sofkau.operacion.values.Region;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.usecase.operacion.CrearOperacionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class CrearOperacionUseCaseTest {

    private CrearOperacionUseCase crearOperacionUseCase;

    @BeforeEach
    private void  setUp(){
        crearOperacionUseCase = new CrearOperacionUseCase();
    }


    @Test
    public void crearOperacionCorrectamente(){
        //arrage
        Set<UnidadUsarId> unidadUsarIds =new HashSet<>();
        unidadUsarIds.add(UnidadUsarId.of("541"));
        Set<Victima> victimas = new HashSet<>();
        Lider lider = new Lider(LiderId.of("123"),new Nombre("juan carlos correa"),new Nacionalidad("Colombiano"),
                new Edad(35),new Rango("General"),new Genero('H'));
        var command = new CrearOperacion(OperacionId.of("1"),unidadUsarIds,lider,new Descripcion("rescatar victimas entre los escombros"),
                new Region("Sureste quilpue"),new Pais("chile"),new Nombre("Victimas seguras"),victimas);

        //act
        var response = UseCaseHandler.getInstance()
                .syncExecutor(crearOperacionUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //Asserts

        OperacionCreada operacionCreada = (OperacionCreada) events.get(0);
        Assertions.assertEquals("sofkau.operacion.events.operacioncreada", operacionCreada.type);
        Assertions.assertEquals("juan carlos correa",operacionCreada.lider().nombre().value());
        Assertions.assertEquals(0,operacionCreada.victimas().size());

    }

}