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
        Objects.requireNonNull(tipoUnidad," tipo de unidad para actualizar requerida");
        appendChange(new TipoUnudadActualizada(tipoUnidad));
    }

    public void AsignarRescatista(RescatistaId rescatistaId, Nombre nombre, Nacionalidad nacionalidad,
                                  Edad edad, Rango rango, Genero genero){
        Objects.requireNonNull(rescatistaId,"Id del rescatista que vas a asignar al Grupo usar obligatorio ");
        Objects.requireNonNull(nombre,"nombre del rescatista requerido ");
        Objects.requireNonNull(nacionalidad,"nacionaliad  del rescatista requerido ");
        Objects.requireNonNull(edad, " edad  del rescatista  requerido");
        Objects.requireNonNull(rango," rango del rescatista requerido");
        Objects.requireNonNull(genero, "genaro del rescatista requerido");
        appendChange(new RscatistaAsignado(rescatistaId,nombre,nacionalidad,edad,rango,genero));
    }



    public void AsignarEncargado(RescatistaId rescatistaId, Nombre nombre, Nacionalidad nacionalidad, Edad edad,Rango rango, Genero genero){
        Objects.requireNonNull(rescatistaId,"ID  del rescatista para   asiganar  requerido ");
        Objects.requireNonNull(nombre,"  nombre del encargado requerido");
        Objects.requireNonNull(nacionalidad," nacionalidad del encargado requerido");
        Objects.requireNonNull(edad," edad del encargado requerido");
        Objects.requireNonNull(rango," rango del encargado requerido ");
        Objects.requireNonNull(genero, " genero del encargado requerido ");
        appendChange(new EncargadoAsignado(rescatistaId,nombre,nacionalidad,edad,rango,genero));
    }



    public void AgregarEquipo(EquiposId equiposId, TipoEquipo tipoEquipo){
        Objects.requireNonNull(equiposId, " Id del  equipo para aquegar a la unidad usar requerido ");
        Objects.requireNonNull(tipoEquipo,"  tipo de equipo requerido  recuerda  que pueden ser herrramientas manuelas o electricas");
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

