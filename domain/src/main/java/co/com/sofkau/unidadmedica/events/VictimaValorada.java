package co.com.sofkau.unidadmedica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.EdadVictima;
import co.com.sofkau.generi.values.Genero;
import co.com.sofkau.generi.values.Nacionalidad;
import co.com.sofkau.generi.values.Nombre;
import co.com.sofkau.unidadmedica.entitys.VictimaR.VictimaId;


public class VictimaValorada extends DomainEvent {
    private final VictimaId victimaId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;
    private final EdadVictima edadVictima;
    private final Genero genero;

    public VictimaValorada(VictimaId victimaId, Nombre nombre, Nacionalidad nacionalidad, EdadVictima edadVictima, Genero genero) {
        super("sofkau.unidadmedica.events.victimavalorada");
        this.victimaId = victimaId;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edadVictima = edadVictima;
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

    public EdadVictima getEdadVictima() {
        return edadVictima;
    }

    public Genero getGenero() {
        return genero;
    }
}
