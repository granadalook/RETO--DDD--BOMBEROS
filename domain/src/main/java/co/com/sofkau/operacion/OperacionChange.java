package co.com.sofkau.operacion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.operacion.entitys.Victima.Victima;
import co.com.sofkau.operacion.entitys.liderO.Lider;
import co.com.sofkau.operacion.events.*;

public class OperacionChange extends EventChange {
    public OperacionChange(Operacion operacion) {
        apply((DescripcionActualizada event) -> {
            operacion.descripcion = event.descripcion();
        });

        apply((LiderAsignado event) -> {
            operacion.lider = new Lider(event.liderId(), event.nombre(), event.nacionalidad(), event.edad(), event.rango(), event.genero());
        });


        apply((OperacionCreada event) -> {
            operacion.nombre = event.nombre();
            operacion.victimas = event.victimas();
            operacion.pais = event.pais();
            operacion.region = event.region();
            operacion.lider = event.lider();
            operacion.descripcion = event.descripcion();
            operacion.unidadUsarIds = event.unidadUsarIds();
        });

        apply((VictimaRescatada event) -> {
            if (event.getEdadVictima().value() <= 18)
                throw new IllegalArgumentException("Victima menor de edad rescatada Equipo especializado requerido");
            operacion.victimas.add(new Victima(event.getVictimaId(), event.getNombre(),
                    event.getNacionalidad(), event.getEdadVictima(), event.getGenero()));
        });

        apply((UnidadRescatistaAsignada event) -> {
            operacion.unidadUsarIds.add(event.getUnidadUsarId());
        });


    }
}