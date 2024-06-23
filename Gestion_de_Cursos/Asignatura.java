package Gestion_de_Cursos;

public class Asignatura {
    private String nombre;
    private Profesor profesor;

    public Asignatura(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
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

    public void mostrarInfo() {
        System.out.println("Asignatura: " + nombre + ", Profesor: " + profesor.getNombre() + " " + profesor.getApellido());
    }

    public static void main(String[] args) {

        Profesor profesor = new Profesor("Juan", "Perez");
        Asignatura asignatura = new Asignatura("Matemáticas", profesor);
        asignatura.mostrarInfo();
    }
}
