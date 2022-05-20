package co.com.sofkau.unidadmedica;

import co.com.sofka.domain.generic.EventChange;

import co.com.sofkau.operacion.events.VictimaRescatada;
import co.com.sofkau.unidadmedica.entitys.LiderM.Lider;
import co.com.sofkau.unidadmedica.entitys.VictimaR.Victima;
import co.com.sofkau.unidadmedica.events.LiderMedAsignado;
import co.com.sofkau.unidadmedica.events.VictimaValorada;

public class UnidadMedChange extends EventChange {
    public UnidadMedChange(UnidadMed unidadMed) {


        apply((LiderMedAsignado event) -> {
            unidadMed.lider = new Lider(event.getLiderId(), event.getNombre(), event.getNacionalidad(), event.getEdad(), event.getRango(), event.getGenero());
        });

        apply((VictimaValorada event) -> {
            if (event.getEdadVictima().value() >0)
                throw new IllegalArgumentException("no hay victimas a valorar");
            unidadMed.victimas.add(new Victima(event.getVictimaId(), event.getNombre(),
                    event.getNacionalidad(), event.getEdadVictima(), event.getGenero()));
        });
    }
}