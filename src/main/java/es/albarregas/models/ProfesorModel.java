package es.albarregas.models;

import es.albarregas.beans.Profesor;

public class ProfesorModel {
    public static boolean validarProfesor(Profesor profesor) {
        return profesor.getNombre() != null && !profesor.getNombre().isEmpty() &&
                profesor.getApe1() != null && !profesor.getApe1().isEmpty() &&
                profesor.getCodigo() != null && profesor.getCodigo().getId() != null &&
                profesor.getCodigo().getTipo() != null && !profesor.getCodigo().getTipo().isEmpty();

    }
}
