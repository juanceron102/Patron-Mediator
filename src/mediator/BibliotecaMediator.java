package mediator;

import colleague.Estudiante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Libro;

public class BibliotecaMediator implements Mediator {

    private final Map<String, Libro> catalogo = new HashMap<>();
    private final List<Estudiante> estudiantes = new ArrayList<>();

    @Override
    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    @Override
    public void registrarLibro(Libro libro) {
        catalogo.put(libro.getTitulo(), libro);
    }

    @Override
    public void solicitarPrestamo(Estudiante estudiante, String tituloLibro) {
        if (!estaRegistrado(estudiante)) {
            return;
        }

        Libro libro = catalogo.get(tituloLibro);
        if (libro == null) {
            estudiante.recibirMensaje("el libro \"" + tituloLibro + "\" no existe en el catálogo.");
        } else if (libro.isDisponible()) {
            libro.prestar(estudiante.getNombre());
            estudiante.recibirMensaje("préstamo aprobado para " + estudiante.getNombre() + ".");
        } else {
            estudiante.recibirMensaje("el libro no está disponible.");
        }
    }

    @Override
    public void devolverLibro(Estudiante estudiante, String tituloLibro) {
        if (!estaRegistrado(estudiante)) {
            return;
        }

        Libro libro = catalogo.get(tituloLibro);
        if (libro == null || !estudiante.getNombre().equals(libro.getPrestadoA())) {
            estudiante.recibirMensaje("no hay un préstamo de \"" + tituloLibro + "\" a nombre de "
                    + estudiante.getNombre() + ".");
            return;
        }

        libro.devolver();
        estudiante.recibirMensaje("libro disponible nuevamente.");
    }

    private boolean estaRegistrado(Estudiante estudiante) {
        if (estudiantes.contains(estudiante)) {
            return true;
        }
        estudiante.recibirMensaje("el estudiante no está registrado en la biblioteca.");
        return false;
    }
}
