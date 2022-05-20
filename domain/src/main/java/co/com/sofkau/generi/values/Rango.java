package co.com.sofkau.generi.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
/**
 * Rango es un  objeto de valor generico
 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class Rango implements ValueObject<String> {
    private final String value;

    public Rango(String value) {
        this.value = this.rules(value);
    }

    public String value() {
        return value;
    }

    public String rules(String value) {
        Set<String> cadenaDeMando = new HashSet<>();
        cadenaDeMando.add("general");
        cadenaDeMando.add("comandante");
        cadenaDeMando.add("brigadier");
        cadenaDeMando.add("coronel");
        cadenaDeMando.add("mayor");
        cadenaDeMando.add("capitan");
        cadenaDeMando.add("teniente");
        cadenaDeMando.add("sargento");
        cadenaDeMando.add("cabo");
        cadenaDeMando.add("bombero");
        cadenaDeMando.add("medico");

        if (!cadenaDeMando.contains(value.toLowerCase(Locale.ROOT)))
            throw new IllegalArgumentException("Rango incorrecto, revise la cadena de Rango.");
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rango)) return false;
        Rango autoridad = (Rango) o;
        return Objects.equals(value, autoridad.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
