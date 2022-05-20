package co.com.sofkau.unidadusar.entitys.equipos;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.unidadusar.values.TipoEquipo;
/**
 * Entidad  Equipos
 *  son equipos para el trabajo de liberacion de victimas
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class Equipos extends Entity<EquiposId> {
    private TipoEquipo value;

    public Equipos(EquiposId entityId, TipoEquipo tipoEquipo) {
        super(entityId);
        this.value = tipoEquipo;
    }

    public TipoEquipo tipoEquipo() {
        return value;
    }

    public void actualizarTipoEquipo(TipoEquipo tipoEquipo) {
        this.value = tipoEquipo;
    }
}
