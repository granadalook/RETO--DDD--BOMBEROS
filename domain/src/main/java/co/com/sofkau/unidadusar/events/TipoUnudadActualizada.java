package co.com.sofkau.unidadusar.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.unidadusar.values.TipoUnidad;



public class TipoUnudadActualizada extends DomainEvent {
    private final TipoUnidad tipoUnidad;

    public TipoUnudadActualizada(TipoUnidad tipoUnidad) {
        super("sofkau.unidadusar.events.tipounudadactualizada");
        this.tipoUnidad = tipoUnidad;
    }
    public TipoUnidad tipoUnidad() {
        return tipoUnidad;
    }
}
