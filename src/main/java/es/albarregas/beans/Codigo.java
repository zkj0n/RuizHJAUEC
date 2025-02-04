package es.albarregas.beans;

import java.io.Serializable;
import java.util.Objects;

public class Codigo implements Serializable {
    private Integer id;
    private String tipo;

    public Codigo() {
    }

    public Codigo(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Codigo)) return false;
        Codigo codigo = (Codigo) o;
        return Objects.equals(id, codigo.id) && Objects.equals(tipo, codigo.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo);
    }
}
