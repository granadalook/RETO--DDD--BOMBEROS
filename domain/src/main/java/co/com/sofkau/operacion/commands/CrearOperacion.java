package co.com.sofkau.operacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.operacion.OperacionId;
import co.com.sofkau.operacion.entitys.Victima.Victima;
import co.com.sofkau.operacion.entitys.liderO.Lider;
import co.com.sofkau.operacion.values.Descripcion;
import co.com.sofkau.operacion.values.Pais;
import co.com.sofkau.operacion.values.Region;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.generi.values.Nombre;

import java.util.Set;

public class CrearOperacion extends Command {
    private final OperacionId operacionId;
    private final Set<UnidadUsarId> unidadUsarIds;
    private final Lider lider;
    private final Descripcion descripcion;
    private final Region region;
    private final Pais pais;
    private final Nombre nombre;
    private final Set<Victima> victimas;

    public CrearOperacion(OperacionId operacionId,Set<UnidadUsarId> unidadUsarIds, Lider lider,
                          Descripcion descripcion, Region region, Pais pais, Nombre nombre, Set<Victima> victimas) {
        this.operacionId = operacionId;
        this.unidadUsarIds = unidadUsarIds;
        this.lider = lider;
        this.descripcion = descripcion;
        this.region = region;
        this.pais = pais;
        this.nombre = nombre;
        this.victimas = victimas;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public Set<UnidadUsarId> getUnidadUsarIds() {
        return unidadUsarIds;
    }

    public Lider getLider() {
        return lider;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Region getRegion() {
        return region;
    }

    public Pais getPais() {
        return pais;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Set<Victima> getVictimas() {
        return victimas;
    }
}
