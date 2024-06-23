package Gestion_Biblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Interfazmenu {
    private JFrame frame;
    private JTextField usuarioField;
    private JTextField idField;
    private JTextField libroField;
    private JTextField autorField;
    private JTextField categoriaField;
    private ArrayList<HashMap<String, String>> registros;

    public Interfazmenu() {
        frame = new JFrame("Biblioteca Socratica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 700); // Incrementa el tamaño de la ventana

        Color bgColor = new Color(253, 245, 230);
        Color labelColor = new Color(139, 69, 19);
        Color buttonColor = new Color(227, 197, 101);
        Color buttonTextColor = new Color(139, 69, 19);
        Color buttonHoverColor = new Color(211, 180, 111);
        Color entryBgColor = new Color(255, 248, 220);

        frame.getContentPane().setBackground(bgColor);
        frame.setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon(getClass().getResource("Biblioteca.png"));
        JLabel imagenLabel = new JLabel(icon);
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(imagenLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setBackground(bgColor);
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        Font fontStyle = new Font("Helvetica", Font.BOLD, 12);

        JLabel usuarioLabel = new JLabel("Nombre completo de Usuario:");
        usuarioLabel.setForeground(labelColor);
        usuarioLabel.setFont(fontStyle);
        panel.add(usuarioLabel);

        usuarioField = new JTextField();
        usuarioField.setBackground(entryBgColor);
        panel.add(usuarioField);

        JLabel idLabel = new JLabel("Número de Identificación:");
        idLabel.setForeground(labelColor);
        idLabel.setFont(fontStyle);
        panel.add(idLabel);

        idField = new JTextField();
        idField.setBackground(entryBgColor);
        panel.add(idField);

        JLabel libroLabel = new JLabel("Nombre del Libro:");
        libroLabel.setForeground(labelColor);
        libroLabel.setFont(fontStyle);
        panel.add(libroLabel);

        libroField = new JTextField();
        libroField.setBackground(entryBgColor);
        panel.add(libroField);

        JLabel autorLabel = new JLabel("Autor del Libro:");
        autorLabel.setForeground(labelColor);
        autorLabel.setFont(fontStyle);
        panel.add(autorLabel);

        autorField = new JTextField();
        autorField.setBackground(entryBgColor);
        panel.add(autorField);

        JLabel categoriaLabel = new JLabel("Categoría del Libro:");
        categoriaLabel.setForeground(labelColor);
        categoriaLabel.setFont(fontStyle);
        panel.add(categoriaLabel);

        categoriaField = new JTextField();
        categoriaField.setBackground(entryBgColor);
        panel.add(categoriaField);

        frame.add(panel, BorderLayout.CENTER);

        // Crear un panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(bgColor);
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10));

        JButton prestamoButton = new JButton("Realizar Préstamo");
        prestamoButton.setBackground(buttonColor);
        prestamoButton.setForeground(buttonTextColor);
        prestamoButton.setFont(fontStyle);
        prestamoButton.setBorder(BorderFactory.createLineBorder(labelColor));
        prestamoButton.setFocusPainted(false);
        prestamoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPrestamo();
            }
        });
        prestamoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                prestamoButton.setBackground(buttonHoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                prestamoButton.setBackground(buttonColor);
            }
        });
        buttonPanel.add(prestamoButton);

        JButton mostrarRegistrosButton = new JButton("Mostrar Registros");
        mostrarRegistrosButton.setBackground(buttonColor);
        mostrarRegistrosButton.setForeground(buttonTextColor);
        mostrarRegistrosButton.setFont(fontStyle);
        mostrarRegistrosButton.setBorder(BorderFactory.createLineBorder(labelColor));
        mostrarRegistrosButton.setFocusPainted(false);
        mostrarRegistrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRegistros();
            }
        });
        mostrarRegistrosButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mostrarRegistrosButton.setBackground(buttonHoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                mostrarRegistrosButton.setBackground(buttonColor);
            }
        });
        buttonPanel.add(mostrarRegistrosButton);

        // Centrar los botones
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setBackground(bgColor);
        centerPanel.add(buttonPanel);

        frame.add(centerPanel, BorderLayout.SOUTH);

        registros = new ArrayList<>();

        frame.setVisible(true);
    }

    private void realizarPrestamo() {
        String nombreUsuario = usuarioField.getText();
        String idUsuario = idField.getText();
        String nombreLibro = libroField.getText();
        String autorLibro = autorField.getText();
        String categoriaLibro = categoriaField.getText();

        HashMap<String, String> registro = new HashMap<>();
        registro.put("Nombre de Usuario", nombreUsuario);
        registro.put("Número de Identificación", idUsuario);
        registro.put("Nombre del Libro", nombreLibro);
        registro.put("Autor del Libro", autorLibro);
        registro.put("Categoría del Libro", categoriaLibro);

        registros.add(registro);

        JOptionPane.showMessageDialog(frame, "El préstamo se realizó con éxito.");

        usuarioField.setText("");
        idField.setText("");
        libroField.setText("");
        autorField.setText("");
        categoriaField.setText("");
    }

    private void mostrarRegistros() {
        StringBuilder registrosTexto = new StringBuilder();
        for (HashMap<String, String> registro : registros) {
            registrosTexto.append("Nombre de Usuario: ").append(registro.get("Nombre de Usuario")).append("\n");
            registrosTexto.append("Número de Identificación: ").append(registro.get("Número de Identificación")).append("\n");
            registrosTexto.append("Nombre del Libro: ").append(registro.get("Nombre del Libro")).append("\n");
            registrosTexto.append("Autor del Libro: ").append(registro.get("Autor del Libro")).append("\n");
            registrosTexto.append("Categoría del Libro: ").append(registro.get("Categoría del Libro")).append("\n");
            registrosTexto.append("-".repeat(40)).append("\n");
        }

        JOptionPane.showMessageDialog(frame, registrosTexto.toString(), "Registros de Préstamos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Interfazmenu::new);
    }
}
