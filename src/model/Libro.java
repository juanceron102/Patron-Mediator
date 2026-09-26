package model;

public class Libro {

    private final String titulo;
    private String prestadoA;

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponible() {
        return prestadoA == null;
    }

    public String getPrestadoA() {
        return prestadoA;
    }

    public void prestar(String nombreEstudiante) {
        this.prestadoA = nombreEstudiante;
    }

    public void devolver() {
        this.prestadoA = null;
    }
}
