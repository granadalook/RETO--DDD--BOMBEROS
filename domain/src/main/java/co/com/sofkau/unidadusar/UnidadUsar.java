package co.com.sofkau.unidadusar;


import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generi.values.*;
import co.com.sofkau.unidadusar.entitys.camion.Camion;
import co.com.sofkau.unidadusar.entitys.camion.CamionId;
import co.com.sofkau.unidadusar.entitys.equipos.Equipos;
import co.com.sofkau.unidadusar.entitys.equipos.EquiposId;
import co.com.sofkau.unidadusar.entitys.rescatista.RescatistaId;
import co.com.sofkau.unidadusar.entitys.rescatista.Rscatista;
import co.com.sofkau.unidadusar.events.*;
import co.com.sofkau.unidadusar.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;
/**
 * Agregado ROOT Unidad USAR

 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class UnidadUsar extends AggregateEvent<UnidadUsarId> {
    protected TipoUnidad tipoUnidad;
    protected Set<Rscatista> rscatistas;
    protected Set<Camion> camions;
    protected Set<Equipos> equipos;
    protected Rscatista encargado;


    public UnidadUsar(UnidadUsarId entityId, TipoUnidad tipoUnidad, Set<Rscatista> rscatistas, Set<Camion> camions,
                      Set<Equipos> equipos, Rscatista encargado) {
        super(entityId);
        this.tipoUnidad = tipoUnidad;
        this.rscatistas = rscatistas;
        this.camions = camions;
        this.equipos =equipos;
        this.encargado = encargado;
        appendChange(new UnidadRescatistaCreada(tipoUnidad,rscatistas,camions,equipos,encargado)).apply();
    }

    private UnidadUsar(UnidadUsarId unidadUsarId){
        super(unidadUsarId);
        subscribe(new UnidadUsarChange(this));
    }

    public static UnidadUsar from(UnidadUsarId unidadUsarId, List<DomainEvent> events){
        var unidadUsar= new UnidadUsar(unidadUsarId);
        events.forEach(unidadUsar::applyEvent);
        return unidadUsar;
    }

    public void ActualizarTipoUnidad(TipoUnidad tipoUnidad){
        Objects.requireNonNull(tipoUnidad);
        appendChange(new TipoUnudadActualizada(tipoUnidad));
    }

    public void AsignarRescatista(RescatistaId rescatistaId, Nombre nombre, Nacionalidad nacionalidad,
                                  Edad edad, Rango rango, Genero genero){
        Objects.requireNonNull(rescatistaId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(nacionalidad);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(rango);
        Objects.requireNonNull(genero);
        appendChange(new RscatistaAsignado(rescatistaId,nombre,nacionalidad,edad,rango,genero));
    }



    public void AsignarEncargado(RescatistaId rescatistaId, Nombre nombre, Nacionalidad nacionalidad, Edad edad,Rango rango, Genero genero){
        Objects.requireNonNull(rescatistaId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(nacionalidad);
        Objects.requireNonNull(edad);
        Objects.requireNonNull(rango);
        Objects.requireNonNull(genero);
        appendChange(new EncargadoAsignado(rescatistaId,nombre,nacionalidad,edad,rango,genero));
    }



    public void AgregarEquipo(EquiposId equiposId, TipoEquipo tipoEquipo){
        Objects.requireNonNull(equiposId);
        Objects.requireNonNull(tipoEquipo);
        appendChange(new EquiposAgregados(equiposId,tipoEquipo));
    }

    public TipoUnidad tipoUnidad() {
        return tipoUnidad;
    }

    public  Set<Rscatista> rscatistas() {
        return rscatistas;
    }

    public Set<Camion> camions() {
        return camions;
    }

    public Set<Equipos> equipos() {
        return equipos;
    }

    public Rscatista encargado() {
        return encargado;
    }

}

