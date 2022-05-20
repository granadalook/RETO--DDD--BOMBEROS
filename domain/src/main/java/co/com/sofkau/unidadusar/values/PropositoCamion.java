package co.com.sofkau.unidadusar.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PropositoCamion implements ValueObject<String> {
    private final String value;

    public PropositoCamion(String proposito) {
        this.value = proposito;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropositoCamion)) return false;
        PropositoCamion proposito1 = (PropositoCamion) o;
        return Objects.equals(value, proposito1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
