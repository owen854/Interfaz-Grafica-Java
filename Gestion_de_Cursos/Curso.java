package Gestion_de_Cursos;

import java.util.ArrayList;

public class Curso {
    private String nombre;
    private Profesor profesor;
    private ArrayList<Estudiante> estudiantes;
    private Horario horario;
    private Asignatura asignatura;

    public Curso(String nombre, Profesor profesor, Horario horario, Asignatura asignatura) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
        this.horario = horario;
        this.asignatura = asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void mostrarInfo() {
        System.out.println("Curso: " + nombre + ", Profesor: " + profesor.getNombre() + " " + profesor.getApellido() +
                ", Horario: " + horario.getDia() + " " + horario.getHoraInicio() + "-" + horario.getHoraFin());
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
}
