package Gestion_de_Cursos;

import java.util.ArrayList;

public class Profesor {
    private String nombre;
    private String apellido;
    private ArrayList<Asignatura> asignaturas;

    public Profesor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignaturas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public void mostrarInfo() {
        System.out.println("Profesor: " + nombre + " " + apellido);
    }

    public static void main(String[] args) {
        Profesor profesor = new Profesor("Juan", "Perez");
        profesor.mostrarInfo();
    }
}
