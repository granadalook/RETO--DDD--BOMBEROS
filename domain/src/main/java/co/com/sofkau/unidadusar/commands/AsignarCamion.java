package co.com.sofkau.unidadusar.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.unidadusar.UnidadUsarId;
import co.com.sofkau.unidadusar.entitys.camion.CamionId;
import co.com.sofkau.unidadusar.values.PropositoCamion;
import co.com.sofkau.unidadusar.values.TipoCamion;
/**
 * Comando  AsignarCamion
 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class AsignarCamion extends Command {
    private final UnidadUsarId unidadUsarId;
    private final CamionId camionId;
    private final TipoCamion tipoCamion;
    private final PropositoCamion propositoCamion;


    public AsignarCamion(UnidadUsarId unidadUsarId, CamionId camionId, TipoCamion tipoCamion, PropositoCamion propositoCamion) {
        this.unidadUsarId = unidadUsarId;
        this.camionId = camionId;
        this.tipoCamion = tipoCamion;
        this.propositoCamion = propositoCamion;
    }

    public UnidadUsarId getUnidadUsarId() {
        return unidadUsarId;
    }

    public CamionId getCamionId() {
        return camionId;
    }

    public TipoCamion getTipoCamion() {
        return tipoCamion;
    }

    public PropositoCamion getPropositoCamion() {
        return propositoCamion;
    }
}
