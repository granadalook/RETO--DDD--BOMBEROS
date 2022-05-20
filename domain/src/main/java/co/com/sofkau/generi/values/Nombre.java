package co.com.sofkau.generi.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Nombre es un  objeto de valor generico
 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class Nombre implements ValueObject<String> {
    private final String value;

    public Nombre(String value) {

        this.value = value;
    }

    private String rules(String value) {
        if (value.length() < 6)
            throw new IllegalArgumentException("Los nombres no pueden tener menos de 6 caracteres");
        return value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nombre)) return false;
        Nombre nombre = (Nombre) o;
        return Objects.equals(value(), nombre.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }

}
