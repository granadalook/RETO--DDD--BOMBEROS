package co.com.sofkau.operacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Pais es un  objeto de valor del  agregado Operacion
 *
 * @Version 1.0
 * @Author Jhon Stiven Granada Acevedo
 * @Email tiven17.jsga@gmail.com
 * *
 */
public class Pais implements ValueObject<String> {
    private final String value;

    public Pais(String value) {
        this.value = this.rules(value);
    }
    public String rules(String value){
        if (value.length()<4)
            throw new IllegalArgumentException("Ingrese un pais valido, debe tener mas de 4 caracteres");
        return value;
    }


    public String value() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pais)) return false;
        Pais pais = (Pais) o;
        return Objects.equals(value, pais.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}