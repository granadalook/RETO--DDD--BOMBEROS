package co.com.sofkau.operacion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.operacion.entitys.Victima.Victima;
import co.com.sofkau.operacion.entitys.Victima.VictimaId;
import co.com.sofkau.operacion.entitys.liderO.Lider;
import co.com.sofkau.operacion.entitys.liderO.LiderId;
import co.com.sofkau.operacion.events.*;
import co.com.sofkau.operacion.values.Descripcion;
import co.com.sofkau.operacion.values.Pais;
import co.com.sofkau.operacion.values.Region;
import co.com.sofkau.unidadusar.UnidadUsarId;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Agregado ROOT Operaciones
 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class Operacion extends AggregateEvent<OperacionId> {
    protected Set<UnidadUsarId> unidadUsarIds;
    protected Lider lider;
    protected Descripcion descripcion;
    protected Region region;
    protected Pais pais;
    protected Nombre nombre;
    protected Set<Victima> victimas;

    public Operacion(OperacionId entityId, Set<UnidadUsarId> unidadUsarIds, Lider lider,
                     Descripcion descripcion, Region region, Pais pais, Nombre nombre, Set<Victima> victimas) {
        super(entityId);
        this.unidadUsarIds = unidadUsarIds;
        this.lider = lider;
        this.descripcion = descripcion;
        this.region = region;
        this.pais = pais;
        this.nombre = nombre;
        this.victimas = victimas;
        appendChange(new OperacionCreada(unidadUsarIds, lider, descripcion, region, pais, nombre, victimas));
    }

    private Operacion(OperacionId operacionId) {
        super(operacionId);
        subscribe(new OperacionChange(this));
    }

    public static Operacion from(OperacionId operacionId, List<DomainEvent> events) {
        var operacion = new Operacion(operacionId);
        events.forEach(operacion::applyEvent);
        return operacion;
    }


    public void rescatarVictima(VictimaId victimaId, Nombre nombre, Nacionalidad nacionalidad, EdadVictima edad, Genero genero) {
        Objects.requireNonNull(victimaId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(nacionalidad);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(genero);
        appendChange(new VictimaRescatada(victimaId, nombre, nacionalidad, edad, genero));
    }

    public void actualizarDescripcion(Descripcion descripcion) {
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionActualizada(descripcion));
    }

    public void asignarLider(LiderId liderId, Nombre nombre, Nacionalidad nacionalidad, Edad edad, Rango rango, Genero genero) {
        Objects.requireNonNull(liderId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(nacionalidad);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(rango);
        Objects.requireNonNull(genero);
        appendChange(new LiderAsignado(liderId, nombre, nacionalidad, edad, rango, genero));

    }

    public void asignarUnidad(UnidadUsarId unidadUsarId) {
        Objects.requireNonNull(unidadUsarId," ID  de la unidad  obligatoria ");
        appendChange(new UnidadRescatistaAsignada(unidadUsarId));
    }


}
