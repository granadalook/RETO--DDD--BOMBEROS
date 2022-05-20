package co.com.sofkau.unidadmedica;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;


import co.com.sofkau.operacion.OperacionChange;
import co.com.sofkau.operacion.values.Descripcion;
import co.com.sofkau.operacion.values.Pais;
import co.com.sofkau.operacion.values.Region;
import co.com.sofkau.unidadmedica.entitys.LiderM.Lider;
import co.com.sofkau.unidadmedica.entitys.LiderM.LiderId;
import co.com.sofkau.unidadmedica.entitys.VictimaR.Victima;
import co.com.sofkau.unidadmedica.entitys.VictimaR.VictimaId;
import co.com.sofkau.unidadmedica.events.LiderMedAsignado;
import co.com.sofkau.unidadmedica.events.VictimaValorada;
import co.com.sofkau.unidadusar.UnidadUsarChange;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UnidadMed extends AggregateEvent<UnidadMedId> {
    protected Set<UnidadMedId> unidadMedIds;
    protected Lider lider;
    protected Descripcion descripcion;
    protected Region region;
    protected Pais pais;
    protected Nombre nombre;
    protected Set<Victima> victimas;

    public UnidadMed(UnidadMedId entityId, Set<UnidadMedId> unidadMedIds, Lider lider,
                     Descripcion descripcion, Region region, Pais pais, Nombre nombre, Set<Victima> victimas) {
        super(entityId);
        this.unidadMedIds = unidadMedIds;
        this.lider = lider;
        this.descripcion = descripcion;
        this.region = region;
        this.pais = pais;
        this.nombre = nombre;
        this.victimas = victimas;

    }

    public UnidadMed(UnidadMedId unidadMedId) {
            super(unidadMedId);
        subscribe(new UnidadMedChange(this));
    }

    public static UnidadMed from(UnidadMedId unidadMedId, List<DomainEvent> events) {
        var unidadmedica = new UnidadMed(unidadMedId);
        events.forEach(unidadmedica::applyEvent);
        return unidadmedica;

    }

    public void valorarVictima(VictimaId victimaId, Nombre nombre, Nacionalidad nacionalidad, EdadVictima edad, Genero genero) {
        Objects.requireNonNull(victimaId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(nacionalidad);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(genero);
        appendChange(new VictimaValorada(victimaId, nombre, nacionalidad, edad, genero));
    }


    public void asignarLiderMed(LiderId liderId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Rango rango, Genero genero) {
        Objects.requireNonNull(liderId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(nacionalidad);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(rango);
        Objects.requireNonNull(genero);
        appendChange(new LiderMedAsignado(liderId, nombre, nacionalidad, edad, rango, genero));

    }


}
