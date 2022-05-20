package co.com.sofkau.unidadmedica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.unidadmedica.entitys.LiderM.LiderId;


public class LiderMedAsignado extends DomainEvent {
    private final LiderId liderId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;
    private final Edad edad;
    private final Rango rango;
    private final Genero genero;

    public LiderMedAsignado(LiderId liderId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Rango rango, Genero genero) {
        super("sofkau.unidadmedica.events.lidermedasignado");
        this.liderId = liderId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.rango =  rango;
        this.genero = genero;
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
