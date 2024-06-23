package Gestion_de_Tienda;

public class ItemOrden {
    private Producto producto;
    private int cantidad;

    public ItemOrden(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    public String mostrarInfo() {
        return String.format("Producto: %s, Cantidad: %d", producto.getNombre(), cantidad);
    }
}
