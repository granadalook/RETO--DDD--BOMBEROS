package co.com.sofkau.unidadusar.entitys.camion;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.unidadusar.values.PropositoCamion;
import co.com.sofkau.unidadusar.values.TipoCamion;

import java.util.Objects;
/**
 * Entidad  Camion
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class Camion extends Entity<CamionId> {

    private TipoCamion tipoCamion;
    private PropositoCamion propositoCamion;

    public Camion(CamionId entityId, TipoCamion tipoCamion, PropositoCamion propositoCamion) {
        super(entityId);
        this.propositoCamion = propositoCamion;
        this.tipoCamion = tipoCamion;
    }

    public TipoCamion tipoCamion() {
        return tipoCamion;
    }

    public void asignarTipoCamion(TipoCamion tipoCamion) {
        this.tipoCamion = Objects.requireNonNull(tipoCamion);
    }

    public PropositoCamion propositoCamion() {
        return propositoCamion;
    }

    public void PropositoCamion(PropositoCamion propositoCamion) {
        this.propositoCamion = Objects.requireNonNull(propositoCamion);
    }
}
