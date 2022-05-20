package co.com.sofkau.unidadusar.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.unidadusar.entitys.camion.Camion;
import co.com.sofkau.unidadusar.entitys.equipos.Equipos;
import co.com.sofkau.unidadusar.entitys.rescatista.Rscatista;
import co.com.sofkau.unidadusar.values.TipoUnidad;

import java.util.Set;
/**
 * Comando  CrearUnidadUsar
 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class CrearUnidadUsar extends Command {
    private final UnidadUsarId unidadUsarId;
    private final TipoUnidad tipoUnidad;
    private final Set<Rscatista> rscatistas;
    private final Set<Camion> camions;
    private final Set<Equipos> equipos;
    private final Rscatista encargado;

    public CrearUnidadUsar(UnidadUsarId unidadUsarId, TipoUnidad tipoUnidad, Set<Rscatista> rscatistas,
                           Set<Camion> camions, Set<Equipos> equipos, Rscatista encargado) {
        this.unidadUsarId = unidadUsarId;
        this.tipoUnidad = tipoUnidad;
        this.rscatistas = rscatistas;
        this.camions = camions;
        this.equipos = equipos;
        this.encargado = encargado;
    }

    public UnidadUsarId unidadUsarId() {
        return unidadUsarId;
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
