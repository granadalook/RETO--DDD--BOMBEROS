package co.com.sofkau.unidadusar.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Locale;
import java.util.Objects;
/**
 * TipoUnidad es un  objeto de valor del  agregado UnidadUsar

 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class TipoUnidad implements ValueObject<String> {
    private final String value;

    public String value() {
        return value;
    }

    public TipoUnidad(String value) {
        this.value = this.rules(value);
    }
    public String rules(String value){
        value = value.toLowerCase(Locale.ROOT);
        if (value.equals("busqueda") ||value.equals("localizacion")||value.equals("rescate") )
            return value;
        throw new IllegalArgumentException("Las unidades solo pueden ser de, busqueda, localizacion o rescate");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoUnidad)) return false;
        TipoUnidad that = (TipoUnidad) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
