package co.com.sofkau.generi.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Nacionalidad es un  objeto de valor generico
 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class Nacionalidad implements ValueObject<String> {
    private final String value;

    public Nacionalidad(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nacionalidad)) return false;
        Nacionalidad that = (Nacionalidad) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
