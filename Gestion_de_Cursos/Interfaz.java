package Gestion_de_Cursos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class Interfaz {
    private JFrame root;
    private JPanel frame;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JTextField estudianteEntry;
    private JTextField apellidoEstudianteEntry;
    private JTextField idEstudianteEntry;
    private JButton botonRegistrar;
    private JButton botonMostrarHorario;

    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Asignatura> asignaturas;
    private ArrayList<Horario> horarios;
    private ArrayList<Curso> cursos;

    private final String bg_color = "#CFFFE5";
    private final String label_color = "#333333";
    private final Color button_color = Color.decode("#5DB7A1");
    private final Color button_text_color = Color.BLACK;

    public Interfaz() {
        root = new JFrame("Proceso de inscripción de Cursos");
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setSize(700, 500);
        root.getContentPane().setBackground(Color.decode(bg_color));

        frame = new JPanel(new BorderLayout());
        frame.setBackground(Color.decode(bg_color));

        URL imageUrl = getClass().getResource("/Gestion_de_Cursos/Academia.PNG");
        if (imageUrl != null) {
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            Image image = imageIcon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            frame.add(imageLabel, BorderLayout.NORTH);
        } else {
            System.err.println("No se pudo encontrar la imagen Academia.PNG en el package Gestion_de_Cursos.");
        }

        inputPanel = new JPanel();
        inputPanel.setBackground(Color.decode(bg_color));
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label1 = new JLabel("Nombre del Estudiante:");
        label1.setForeground(Color.decode(label_color));
        inputPanel.add(label1);

        estudianteEntry = new JTextField();
        estudianteEntry.setColumns(20);
        inputPanel.add(estudianteEntry);

        JLabel label2 = new JLabel("Apellido del Estudiante:");
        label2.setForeground(Color.decode(label_color));
        inputPanel.add(label2);

        apellidoEstudianteEntry = new JTextField();
        apellidoEstudianteEntry.setColumns(20);
        inputPanel.add(apellidoEstudianteEntry);

        JLabel label3 = new JLabel("ID del Estudiante:");
        label3.setForeground(Color.decode(label_color));
        inputPanel.add(label3);

        idEstudianteEntry = new JTextField();
        idEstudianteEntry.setColumns(20);
        inputPanel.add(idEstudianteEntry);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode(bg_color));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        botonRegistrar = new JButton("Registrar Estudiante");
        botonRegistrar.setBackground(button_color);
        botonRegistrar.setForeground(button_text_color);
        botonRegistrar.setPreferredSize(new Dimension(200, 30));
        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEstudiante();
            }
        });
        buttonPanel.add(botonRegistrar);

        botonMostrarHorario = new JButton("Mostrar Horario");
        botonMostrarHorario.setBackground(button_color);
        botonMostrarHorario.setForeground(button_text_color);
        botonMostrarHorario.setPreferredSize(new Dimension(200, 30));
        botonMostrarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarHorario();
            }
        });
        buttonPanel.add(botonMostrarHorario);

        frame.add(inputPanel, BorderLayout.WEST);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        root.add(frame);
        root.setVisible(true);

        estudiantes = new ArrayList<>();
        asignaturas = new ArrayList<>();
        horarios = new ArrayList<>();
        cursos = new ArrayList<>();

        asignaturas.add(new Asignatura("Matemáticas", new Profesor("Carlos", "Sanchez")));
        asignaturas.add(new Asignatura("Español", new Profesor("Maria", "Velez")));
        asignaturas.add(new Asignatura("Naturales", new Profesor("Valentina", "Claro")));

        horarios.add(new Horario("Lunes", "10:00", "12:00"));
        horarios.add(new Horario("Lunes", "06:00", "08:00"));
        horarios.add(new Horario("Lunes", "08:00", "10:00"));
        horarios.add(new Horario("Jueves", "10:00", "12:00"));
        horarios.add(new Horario("Jueves", "06:00", "08:00"));
        horarios.add(new Horario("Jueves", "08:00", "10:00"));

        cursos.add(new Curso("6-A", new Profesor("Carlos", "Sanchez"), horarios.get(0), asignaturas.get(0)));
        cursos.add(new Curso("6-A", new Profesor("Maria", "Velez"), horarios.get(1), asignaturas.get(1)));
        cursos.add(new Curso("6-A", new Profesor("Valentina", "Claro"), horarios.get(2), asignaturas.get(2)));
        cursos.add(new Curso("6-B", new Profesor("Carlos", "Sanchez"), horarios.get(3), asignaturas.get(0)));
        cursos.add(new Curso("6-B", new Profesor("Maria", "Velez"), horarios.get(4), asignaturas.get(1)));
        cursos.add(new Curso("6-B", new Profesor("Valentina", "Claro"), horarios.get(5), asignaturas.get(2)));
    }
    private void registrarEstudiante() {
        JFrame top = new JFrame("Registrar Estudiante en Curso");
        top.setSize(300, 200);
        top.getContentPane().setBackground(Color.decode(bg_color));
        top.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel label = new JLabel("Seleccione un Curso:");
        label.setForeground(Color.decode(label_color));
        top.add(label);

        DefaultListModel<String> cursoListModel = new DefaultListModel<>();
        JList<String> listaCursos = new JList<>(cursoListModel);
        for (Curso curso : cursos) {
            cursoListModel.addElement(curso.getNombre() + " - " + curso.getProfesor().getNombre());
        }
        top.add(new JScrollPane(listaCursos));

        JButton botonRegistrarCurso = new JButton("Registrar en Curso");
        botonRegistrarCurso.setBackground(button_color);
        botonRegistrarCurso.setForeground(button_text_color);
        botonRegistrarCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaCursos.getSelectedIndex();
                if (selectedIndex != -1) {
                    registrarEstudianteCurso(selectedIndex);
                    top.dispose();
                } else {
                    JOptionPane.showMessageDialog(root, "Por favor, seleccione un curso.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        top.add(botonRegistrarCurso);

        top.setVisible(true);
    }

    private void registrarEstudianteCurso(int selectedIndex) {
        String nombreEstudiante = estudianteEntry.getText();
        String apellidoEstudiante = apellidoEstudianteEntry.getText();
        String idEstudianteStr = idEstudianteEntry.getText();

        if (nombreEstudiante.isEmpty() || apellidoEstudiante.isEmpty() || idEstudianteStr.isEmpty()) {
            JOptionPane.showMessageDialog(root, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idEstudiante;
        try {
            idEstudiante = Integer.parseInt(idEstudianteStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(root, "ID del Estudiante debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Curso cursoSeleccionado = cursos.get(selectedIndex);

        if ((cursoSeleccionado.getNombre().equals("6-A") && !cursoSeleccionado.getHorario().getDia().equals("Lunes")) ||
                (cursoSeleccionado.getNombre().equals("6-B") && !cursoSeleccionado.getHorario().getDia().equals("Jueves"))) {
            JOptionPane.showMessageDialog(root, "El curso seleccionado es solo para " + cursoSeleccionado.getHorario().getDia() + ".", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Estudiante estudiante = new Estudiante(nombreEstudiante, apellidoEstudiante, idEstudiante);

        if (cursoSeleccionado.getEstudiantes().contains(estudiante)) {
            JOptionPane.showMessageDialog(root, "El estudiante ya está registrado en este curso.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cursoSeleccionado.agregarEstudiante(estudiante);

        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        }

        estudianteEntry.setText("");
        apellidoEstudianteEntry.setText("");
        idEstudianteEntry.setText("");

        JOptionPane.showMessageDialog(root, "El estudiante ha sido registrado en el curso con éxito.", "Registro realizado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarHorario() {
        if (estudiantes.isEmpty()) {
            JOptionPane.showMessageDialog(root, "No hay estudiantes registrados.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFrame top = new JFrame("Horario de Clases");
        top.setSize(400, 300);
        top.getContentPane().setBackground(Color.decode(bg_color));
        top.setLayout(new GridLayout(2, 1, 10, 10));

        JLabel label = new JLabel("Seleccione un Estudiante:");
        label.setForeground(Color.decode(label_color));
        top.add(label);

        DefaultListModel<String> estudianteListModel = new DefaultListModel<>();
        JList<String> listaEstudiantes = new JList<>(estudianteListModel);
        for (Estudiante estudiante : estudiantes) {
            estudianteListModel.addElement(estudiante.getNombre() + " " + estudiante.getApellido());
        }
        top.add(new JScrollPane(listaEstudiantes));

        JButton botonVerHorario = new JButton("Ver Horario");
        botonVerHorario.setBackground(button_color);
        botonVerHorario.setForeground(Color.WHITE);
        botonVerHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaEstudiantes.getSelectedIndex();
                if (selectedIndex != -1) {
                    verHorario(selectedIndex);
                    top.dispose();
                } else {
                    JOptionPane.showMessageDialog(root, "Por favor, seleccione un estudiante.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        top.add(botonVerHorario);

        top.setVisible(true);
    }

    private void verHorario(int selectedIndex) {
        Estudiante estudianteSeleccionado = estudiantes.get(selectedIndex);
        ArrayList<String> horariosEstudiante = new ArrayList<>();

        for (Curso curso : cursos) {
            if (curso.getEstudiantes().contains(estudianteSeleccionado)) {
                horariosEstudiante.add("Asignatura: " + curso.getAsignatura().getNombre() +
                        ", Profesor: " + curso.getProfesor().getNombre() +
                        ", Día: " + curso.getHorario().getDia() +
                        ", Hora de inicio: " + curso.getHorario().getHoraInicio() +
                        ", Hora de fin: " + curso.getHorario().getHoraFin());
            }
        }

        JTextArea horariosTextArea = new JTextArea();
        horariosTextArea.setEditable(false);
        horariosTextArea.setBackground(Color.decode(bg_color));
        horariosTextArea.setForeground(Color.decode(label_color));
        for (String horario : horariosEstudiante) {
            horariosTextArea.append(horario + "\n");
        }

        JFrame horarioFrame = new JFrame("Horario de " + estudianteSeleccionado.getNombre() + " " + estudianteSeleccionado.getApellido());
        horarioFrame.getContentPane().setBackground(Color.decode(bg_color));
        horarioFrame.add(new JScrollPane(horariosTextArea));
        horarioFrame.setSize(500, 300);
        horarioFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz();
            }
        });
    }
}

