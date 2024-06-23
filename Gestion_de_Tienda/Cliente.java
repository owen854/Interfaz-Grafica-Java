package Gestion_de_Tienda;

public class Cliente {
    private String nombre;
    private String apellido;
    private int idCliente;

    public Cliente(String nombre, String apellido, int idCliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idCliente = idCliente;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String mostrarInfo() {
        return "Cliente: " + nombre + " " + apellido + ", ID: " + idCliente;
    }
}
