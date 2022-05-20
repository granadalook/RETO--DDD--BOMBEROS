package co.com.sofkau.generi.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * EdadVictima es un  objeto de valor generico
 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class EdadVictima implements ValueObject<Integer> {
    private final Integer value;

    public EdadVictima(Integer value) {
        this.value = this.rules(value);
    }

    public Integer value() {
        return value;
    }

    private Integer rules(Integer value) {
        if (value < 18)
            throw new IllegalArgumentException("victimas menor de edad ");
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EdadVictima)) return false;
        EdadVictima that = (EdadVictima) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}