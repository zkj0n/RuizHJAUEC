package es.albarregas.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@Table(name = "profesoresComp")
public class Profesor implements Serializable{
    @EmbeddedId
    private Codigo codigo;
    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;
    @Column(name = "ape1", length = 15, nullable = false)
    private String ape1;
    @Column(name = "ape2", length = 15, nullable = true)
    private String ape2;
    @Column(name = "escala", columnDefinition = "set('s','t') default 's'", insertable = false)
    private String escala;
    @Column(name = "fecha", columnDefinition = "datetime default now()", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha;
    @Transient
    private String fechaFormateada;

    public Codigo getCodigo() {
        return codigo;
    }

    public void setCodigo(Codigo codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getFechaFormateada() {
        if (fecha == null) {
            return "Fecha no disponible";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        return sdf.format(fecha.getTime());
    }


}
