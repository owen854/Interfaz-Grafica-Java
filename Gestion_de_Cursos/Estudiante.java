package Gestion_de_Cursos;

import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int idEstudiante;
    private ArrayList<Curso> cursos;

    public Estudiante(String nombre, String apellido, int idEstudiante) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idEstudiante = idEstudiante;
        this.cursos = new ArrayList<>();
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

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " " + apellido + ", ID: " + idEstudiante);
    }
}
