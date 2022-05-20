package co.com.sofkau.unidadusar.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.unidadusar.values.TipoUnidad;

public class ActualizarTipoUnidad extends Command {
    private final UnidadUsarId unidadUsarId;
    private final TipoUnidad tipoUnidad;

    public ActualizarTipoUnidad(UnidadUsarId unidadUsarId, TipoUnidad tipoUnidad) {
        this.unidadUsarId = unidadUsarId;
        this.tipoUnidad = tipoUnidad;
    }

    public UnidadUsarId getUnidadUsarId() {
        return unidadUsarId;
    }

    public TipoUnidad getTipoUnidad() {
        return tipoUnidad;
    }
}
