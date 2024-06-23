package Gestion_de_Tienda;

import java.util.ArrayList;

public class Orden {
    private Cliente cliente;
    private ArrayList<ItemOrden> items;
    private double total;

    public Orden(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
        this.total = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemOrden> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemOrden> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void agregarItem(ItemOrden item) {
        items.add(item);
    }

    public void calcularTotal() {
        double total = 0;
        for (ItemOrden item : items) {
            total += item.calcularSubtotal();
        }
        this.total = total;
    }

    public String mostrarInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Cliente: ").append(cliente.getNombre()).append(" ").append(cliente.getApellido()).append(", Total: ").append(total).append("\n");
        for (ItemOrden item : items) {
            info.append(item.mostrarInfo()).append("\n");
        }
        return info.toString();
    }
}
