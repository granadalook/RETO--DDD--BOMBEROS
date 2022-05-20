package co.com.sofkau.unidadusar.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.unidadusar.entitys.rescatista.RescatistaId;

public class RscatistaAsignado extends DomainEvent {
    private final RescatistaId rescatistaId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;
    private final Edad edad;
    private final Rango rango;
    private final Genero genero;

    public RscatistaAsignado(RescatistaId rescatistaId, Nombre nombre, Nacionalidad nacionalidad, Edad edad,Rango rango, Genero genero) {
        super("sofkau.unidadusar.events.rescatistaasignado");
        this.rescatistaId = rescatistaId;
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
        this.edad=edad;
        this.rango = rango;
        this.genero=genero;
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

    public RescatistaId rescatistaId() {
        return rescatistaId;
    }
}
