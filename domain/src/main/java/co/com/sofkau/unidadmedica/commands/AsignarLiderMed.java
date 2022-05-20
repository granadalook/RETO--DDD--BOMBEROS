package co.com.sofkau.unidadmedica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.generi.values.*;

import co.com.sofkau.unidadmedica.UnidadMedId;
import co.com.sofkau.unidadmedica.entitys.LiderM.LiderId;


public class AsignarLiderMed extends Command {
    private final UnidadMedId unidadMedId;
    private final LiderId liderId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;
    private final Edad edad;
    private final Rango rango;
    private final Genero genero;

    public AsignarLiderMed(UnidadMedId unidadMedId, LiderId liderId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Rango rango, Genero genero) {
        this.unidadMedId = unidadMedId;
        this.liderId = liderId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.rango = rango;
        this.genero = genero;
    }

    public UnidadMedId getOperacionId() {
        return unidadMedId;
    }

    public LiderId getLiderId() {
        return liderId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public Edad getEdad() {
        return edad;
    }

    public Rango getRango() {
        return rango;
    }

    public Genero getGenero() {
        return genero;
    }
}