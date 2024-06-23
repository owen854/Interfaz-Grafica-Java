package Gestion_de_Cursos;

public class Evaluacion {
    private Curso curso;
    private Estudiante estudiante;
    private double nota;

    public Evaluacion(Curso curso, Estudiante estudiante, double nota) {
        this.curso = curso;
        this.estudiante = estudiante;
        this.nota = nota;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void mostrarInfo() {
        System.out.printf("Evaluación del curso %s para %s %s:\nNota: %.2f\n",
                curso.getNombre(), estudiante.getNombre(), estudiante.getApellido(), nota);
    }
}
