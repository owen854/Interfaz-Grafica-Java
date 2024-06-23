package Gestion_de_Tienda;

public class Categoria {
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String mostrarInfo() {
        return "Categoría: " + nombre;
    }
}
