package main;

import colleague.Estudiante;
import mediator.BibliotecaMediator;
import mediator.Mediator;
import model.Libro;

public class Main {

    public static void main(String[] args) {
        Mediator biblioteca = new BibliotecaMediator();
        biblioteca.registrarLibro(new Libro("Patrones de Diseño"));

        Estudiante ana = new Estudiante("Ana", biblioteca);
        Estudiante carlos = new Estudiante("Carlos", biblioteca);

        ana.solicitarLibro("Patrones de Diseño");
        carlos.solicitarLibro("Patrones de Diseño");
        ana.devolverLibro("Patrones de Diseño");
        carlos.solicitarLibro("Patrones de Diseño");
    }
}
