package co.com.sofkau.unidadusar.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoEquipo implements ValueObject<String> {
    private final String tipoEquipo;

    public TipoEquipo(String tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    @Override
    public String value() {
        return tipoEquipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoEquipo)) return false;
        TipoEquipo tipoArma1 = (TipoEquipo) o;
        return Objects.equals(tipoEquipo, tipoArma1.tipoEquipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoEquipo);
    }

}
