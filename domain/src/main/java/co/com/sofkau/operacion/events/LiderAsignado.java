package co.com.sofkau.operacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.operacion.entitys.liderO.LiderId;

public class LiderAsignado extends DomainEvent {
    private final LiderId liderId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;
    private final Edad edad;
    private final Rango rango;
    private final Genero genero;

    public LiderAsignado(LiderId liderId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Rango rango, Genero genero) {
        super("sofkau.operacion.events.liderasignado");
        this.liderId = liderId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.rango =  rango;
        this.genero = genero;
    }

    public LiderId liderId() {
        return liderId;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Nacionalidad nacionalidad() {
        return nacionalidad;
    }

    public Edad edad() {
        return edad;
    }

    public Rango rango() {
        return rango;
    }

    public Genero genero() {
        return genero;
    }
}