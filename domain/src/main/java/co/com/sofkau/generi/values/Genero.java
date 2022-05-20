package co.com.sofkau.generi.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Genero es un  objeto de valor generico
 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class Genero implements ValueObject<Character> {
    private final Character value;

    public Genero(Character value) {
        this.value = this.rules(value);
    }

    private Character rules(Character value) {
        Character M = 'M';
        Character H = 'H';
        value = Character.toUpperCase(value);
        if (value.equals(M) || value.equals(H))
            return value;
        throw new IllegalArgumentException("Solo se admiten los caracteres H para hombre y M para mujer");
    }

    public Character value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genero)) return false;
        Genero genero = (Genero) o;
        return Objects.equals(value, genero.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
