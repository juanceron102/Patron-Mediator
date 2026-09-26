package colleague;

import mediator.Mediator;

public class Estudiante {

    private final String nombre;
    private final Mediator mediator;

    public Estudiante(String nombre, Mediator mediator) {
        this.nombre = nombre;
        this.mediator = mediator;
        mediator.registrarEstudiante(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void solicitarLibro(String tituloLibro) {
        System.out.println(nombre + " solicita el libro \"" + tituloLibro + "\".");
        mediator.solicitarPrestamo(this, tituloLibro);
    }

    public void devolverLibro(String tituloLibro) {
        System.out.println(nombre + " devuelve el libro \"" + tituloLibro + "\".");
        mediator.devolverLibro(this, tituloLibro);
    }

    public void recibirMensaje(String mensaje) {
        System.out.println("Biblioteca: " + mensaje);
        System.out.println();
    }
}
