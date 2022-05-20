package co.com.sofkau.unidadusar.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadusar.entitys.camion.Camion;
import co.com.sofkau.unidadusar.entitys.equipos.Equipos;
import co.com.sofkau.unidadusar.entitys.rescatista.Rscatista;
import co.com.sofkau.unidadusar.values.TipoUnidad;

import java.util.Set;

public class UnidadRescatistaCreada extends DomainEvent {
    private final TipoUnidad tipoUnidad;
    private final Set<Rscatista> rscatistas;
    private final Set<Camion> camions;
    private final Set<Equipos> equipos;
    private final Rscatista encargado;

    public UnidadRescatistaCreada(TipoUnidad tipoUnidad, Set<Rscatista> rscatistas, Set<Camion> camions, Set<Equipos> equipos, Rscatista encargado) {
        super("sofkau.unidadusar.events.unidadrescatistacreada");

        this.tipoUnidad = tipoUnidad;
        this.rscatistas = rscatistas;
        this.camions = camions;
        this.equipos = equipos;
        this.encargado = encargado;
    }

    public TipoUnidad tipoUnidad() {
        return tipoUnidad;
    }

    public Set<Rscatista> rscatistas() {
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
