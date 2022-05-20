package co.com.sofkau.unidadmedica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generi.values.EdadVictima;
import co.com.sofkau.generi.values.Genero;
import co.com.sofkau.generi.values.Nacionalidad;
import co.com.sofkau.generi.values.Nombre;
import co.com.sofkau.unidadmedica.UnidadMedId;
import co.com.sofkau.unidadmedica.entitys.VictimaR.VictimaId;


public class ValorarVictima extends Command {
    private final UnidadMedId unidadMedId;
    private final VictimaId victimaId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;
    private final EdadVictima edad;
    private final Genero genero;

    public UnidadMedId getUnidadMedId() {
        return unidadMedId;
    }

    public ValorarVictima(UnidadMedId unidadMedId, VictimaId victimaId, Nombre nombre, Nacionalidad nacionalidad, EdadVictima edad, Genero genero) {
        this.unidadMedId = unidadMedId;
        this.victimaId = victimaId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.genero = genero;
    }



    public VictimaId getVictimaId() {
        return victimaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public EdadVictima getEdad() {
        return edad;
    }

    public Genero getGenero() {
        return genero;
    }
}