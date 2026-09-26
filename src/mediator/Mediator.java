package mediator;

import colleague.Estudiante;
import model.Libro;

public interface Mediator {

    void registrarEstudiante(Estudiante estudiante);

    void registrarLibro(Libro libro);

    void solicitarPrestamo(Estudiante estudiante, String tituloLibro);

    void devolverLibro(Estudiante estudiante, String tituloLibro);
}
