package Gestion_de_Tienda;

import java.util.ArrayList;

public class Tienda {
    private ArrayList<Producto> productos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Orden> ordenes;
    private ArrayList<Categoria> categorias;

    public Tienda() {
        this.productos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.ordenes = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(ArrayList<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void registrarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public Cliente buscarClientePorNombre(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    public void crearOrden(Orden orden) {
        orden.calcularTotal();
        ordenes.add(orden);
    }

    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto.mostrarInfo());
        }
    }

    public void mostrarOrdenes() {
        for (Orden orden : ordenes) {
            System.out.println(orden.mostrarInfo());
        }
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void eliminarCategoria(Categoria categoria) {
        categorias.remove(categoria);
    }

    public void mostrarCategorias() {
        for (Categoria categoria : categorias) {
            System.out.println(categoria.mostrarInfo());
        }
    }
}
