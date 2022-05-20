package co.com.sofkau.unidadusar.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.unidadusar.entitys.equipos.EquiposId;
import co.com.sofkau.unidadusar.entitys.rescatista.RescatistaId;
import co.com.sofkau.unidadusar.values.*;
/**
 * Comando  AgregarEquipos
 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class AgregarEquipos  extends Command {
    private final UnidadUsarId unidadUsarId;
    private final EquiposId equiposId;
    private final TipoEquipo tipoEquipo;

    public AgregarEquipos(UnidadUsarId unidadUsarId, EquiposId equiposId, TipoEquipo tipoEquipo) {
        this.unidadUsarId = unidadUsarId;
        this.equiposId = equiposId;
        this.tipoEquipo = tipoEquipo;
    }

    public UnidadUsarId getUnidadUsarId() {
        return unidadUsarId;
    }

    public EquiposId getEquiposId() {
        return equiposId;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }
}
