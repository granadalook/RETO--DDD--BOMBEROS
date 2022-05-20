package co.com.sofkau.operacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.operacion.entitys.Victima.Victima;
import co.com.sofkau.operacion.entitys.liderO.Lider;
import co.com.sofkau.operacion.values.Descripcion;
import co.com.sofkau.operacion.values.Pais;
import co.com.sofkau.operacion.values.Region;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.generi.values.Nombre;

import java.util.Set;

public class OperacionCreada extends DomainEvent {
    private final Set<UnidadUsarId> unidadUsarIds;
    private final Lider lider;
    private final Descripcion descripcion;
    private final Region region;
    private final Pais pais;
    private final Nombre nombre;
    private final Set<Victima> victimas;

    public OperacionCreada(Set<UnidadUsarId> unidadUsarIds, Lider lider, Descripcion descripcion,
                           Region region, Pais pais, Nombre nombre, Set<Victima> victimas) {
        super("sofkau.operacion.events.operacioncreada");
        this.unidadUsarIds = unidadUsarIds;
        this.lider = lider;
        this.descripcion = descripcion;
        this.region = region;
        this.pais = pais;
        this.nombre = nombre;
        this.victimas = victimas;
    }

    public Set<UnidadUsarId> unidadUsarIds() {
        return unidadUsarIds;
    }

    public Lider lider() {
        return lider;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Region region() {
        return region;
    }

    public Pais pais() {
        return pais;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Set<Victima> victimas() {
        return victimas;
    }
}