package Gestion_de_Tienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz {
    private JFrame root;
    private Tienda tienda;
    private JPanel frame;
    private JTextField nombreProductoEntry;
    private JTextField precioProductoEntry;
    private JTextField categoriaProductoEntry;
    private JTextField nombreClienteEntry;
    private JTextField apellidoClienteEntry;
    private JTextField idClienteEntry;
    private JButton botonCrearOrden;

    private final String colorFondo = "#D8BFD8";
    private final String colorBoton = "#9370DB";
    private final String colorRegistrar = "#BA55D3";

    public Interfaz(JFrame root) {
        this.root = root;
        this.tienda = new Tienda();
        this.root.setTitle("Caja");

        this.frame = new JPanel(new BorderLayout());
        this.frame.setBackground(Color.decode(colorFondo));
        this.root.add(frame);

        ImageIcon image = new ImageIcon(getClass().getResource("/Gestion_de_Tienda/Tienda.png"));
        JLabel imageLabel = new JLabel(image);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(imageLabel, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBackground(Color.decode(colorFondo));
        frame.add(panelCentral, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);

        JLabel labelRegistrarProducto = new JLabel("Registrar Producto");
        labelRegistrarProducto.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelCentral.add(labelRegistrarProducto, gbc);

        JLabel labelNombreProducto = new JLabel("Nombre del Producto:");
        labelNombreProducto.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelCentral.add(labelNombreProducto, gbc);

        nombreProductoEntry = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelCentral.add(nombreProductoEntry, gbc);

        JLabel labelPrecioProducto = new JLabel("Precio del Producto:");
        labelPrecioProducto.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        panelCentral.add(labelPrecioProducto, gbc);

        precioProductoEntry = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelCentral.add(precioProductoEntry, gbc);

        JLabel labelCategoriaProducto = new JLabel("Categoría del Producto:");
        labelCategoriaProducto.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        panelCentral.add(labelCategoriaProducto, gbc);

        categoriaProductoEntry = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelCentral.add(categoriaProductoEntry, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panelCentral.add(new JLabel(), gbc);

        JLabel labelRegistrarCliente = new JLabel("Registrar Cliente");
        labelRegistrarCliente.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelCentral.add(labelRegistrarCliente, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel labelNombreCliente = new JLabel("Nombre del Cliente:");
        labelNombreCliente.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 6;
        panelCentral.add(labelNombreCliente, gbc);

        nombreClienteEntry = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelCentral.add(nombreClienteEntry, gbc);

        JLabel labelApellidoCliente = new JLabel("Apellido del Cliente:");
        labelApellidoCliente.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.NONE;
        panelCentral.add(labelApellidoCliente, gbc);

        apellidoClienteEntry = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelCentral.add(apellidoClienteEntry, gbc);

        JLabel labelIdCliente = new JLabel("ID del Cliente:");
        labelIdCliente.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.NONE;
        panelCentral.add(labelIdCliente, gbc);

        idClienteEntry = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelCentral.add(idClienteEntry, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        panelCentral.add(new JLabel(), gbc);

        botonCrearOrden = new JButton("Crear Orden");
        botonCrearOrden.setBackground(Color.decode(colorRegistrar));
        botonCrearOrden.setForeground(Color.WHITE);
        botonCrearOrden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrar();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelCentral.add(botonCrearOrden, gbc);

        root.setVisible(true);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setSize(600, 800);
    }

    private void registrar() {
        if (!nombreProductoEntry.getText().isEmpty()) {
            registrarProducto();
        } else if (!nombreClienteEntry.getText().isEmpty() && !apellidoClienteEntry.getText().isEmpty()) {
            registrarCliente();
        } else {
            JOptionPane.showMessageDialog(root, "Por favor, complete los datos para registrar un producto o cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarProducto() {
        String nombre = nombreProductoEntry.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(root, "Debe ingresar un nombre de producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double precio;
        try {
            precio = Double.parseDouble(precioProductoEntry.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(root, "El precio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreCategoria = categoriaProductoEntry.getText();
        if (nombreCategoria.isEmpty()) {
            JOptionPane.showMessageDialog(root, "Debe ingresar una categoría de producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Categoria categoria = new Categoria(nombreCategoria);
        Producto producto = new Producto(nombre, precio, categoria);
        tienda.registrarProducto(producto);
        JOptionPane.showMessageDialog(root, "Producto registrado: " + producto.mostrarInfo(), "Producto Registrado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void registrarCliente() {
        String nombre = nombreClienteEntry.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(root, "Debe ingresar un nombre de cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String apellido = apellidoClienteEntry.getText();
        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(root, "Debe ingresar un apellido de cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idClienteEntry.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(root, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = new Cliente(nombre, apellido, id);
        tienda.registrarCliente(cliente);
        JOptionPane.showMessageDialog(root, "Cliente registrado: " + cliente.mostrarInfo(), "Cliente Registrado", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame root = new JFrame();
                new Interfaz(root);
            }
        });
    }
}
