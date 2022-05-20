package co.com.sofkau.unidadusar.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * TipoCamion es un  objeto de valor del  agregado UnidadUsar

 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class TipoCamion implements ValueObject<String> {
    private final String value;

    public TipoCamion(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoCamion)) return false;
        TipoCamion that = (TipoCamion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
