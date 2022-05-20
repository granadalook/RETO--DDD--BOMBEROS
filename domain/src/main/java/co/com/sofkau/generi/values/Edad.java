package co.com.sofkau.generi.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Edad es un  objeto de valor generico
 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class Edad implements ValueObject<Integer> {
    private final Integer value;

    public Edad(Integer value) {
        this.value = this.rules(value);
    }


    private Integer rules(Integer value) {
        if (value < 18)
            throw new IllegalArgumentException("Ingrese una edad valida, no pueden haber rescatistas menores de 18 anos");
        return value;
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edad)) return false;
        Edad edad = (Edad) o;
        return Objects.equals(value, edad.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
