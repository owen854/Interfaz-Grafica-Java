package com.mycompany.mundial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class Equipo {
    String nombre;
    String entrenador;
    List<Jugador> jugadores;
    int victorias;

    public Equipo(String nombre, String entrenador) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.jugadores = new ArrayList<>();
        this.victorias = 0;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }
}

class Jugador {
    String nombre;
    int edad;
    String posicion;

    public Jugador(String nombre, int edad, String posicion) {
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
    }
}

class Estadio {
    String nombre;
    String ciudad;
    int capacidad;

    public Estadio(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
    }
}

public class MundialGUI extends JFrame {
    private List<Equipo> teams;
    private List<Estadio> estadios;
    private Map<String, List<Equipo>> grupos;
    private Map<String, Map<String, Integer[]>> resultados;

    public MundialGUI() {
        setTitle("Mundial de Fútbol");
        setSize(1024, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        teams = generarEquipos();
        estadios = generarEstadios();
        grupos = dividirEnGrupos();
        resultados = generarResultados();

        configurarGUI();
        mostrarPantallaPrincipal();
    }

    private void configurarGUI() {
        // Configuración de la barra superior
        JPanel barraSuperior = new JPanel();
        barraSuperior.setBackground(Color.DARK_GRAY);
        barraSuperior.setPreferredSize(new Dimension(1024, 50));
        barraSuperior.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel labelTitulo = new JLabel("Mundial de Fútbol");
        labelTitulo.setForeground(Color.WHITE);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        barraSuperior.add(labelTitulo);

        add(barraSuperior, BorderLayout.NORTH);

        // Configuración del menú lateral
        JPanel menuLateral = new JPanel();
        menuLateral.setBackground(Color.DARK_GRAY);
        menuLateral.setPreferredSize(new Dimension(150, 600));
        menuLateral.setLayout(new BoxLayout(menuLateral, BoxLayout.Y_AXIS));

        String[] botonesInfo = {"Estadios", "Equipos", "Grupos", "Partidos", "Octavos", "Cuartos de Final", "Semifinal", "Final"};
        ActionListener[] comandos = {this::mostrarEstadios, this::mostrarEquipos, this::mostrarGrupos, this::mostrarPartidos, this::mostrarOctavos, null, null, null};

        for (int i = 0; i < botonesInfo.length; i++) {
            JButton button = new JButton(botonesInfo[i]);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Arial", Font.PLAIN, 12));
            button.setFocusPainted(false);
            if (comandos[i] != null) {
                button.addActionListener(comandos[i]);
            }
            menuLateral.add(button);
            menuLateral.add(Box.createVerticalStrut(10));
        }

        add(menuLateral, BorderLayout.WEST);

        // Configuración del cuerpo principal
        JPanel cuerpoPrincipal = new JPanel();
        cuerpoPrincipal.setBackground(Color.WHITE);
        cuerpoPrincipal.setLayout(new BorderLayout());
        add(cuerpoPrincipal, BorderLayout.CENTER);
    }

    private void mostrarPantallaPrincipal() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(new GridBagLayout());

        JLabel labelBienvenida = new JLabel("¡Bienvenidos al Mundial de Fútbol!");
        labelBienvenida.setFont(new Font("Arial", Font.BOLD, 24));
        labelBienvenida.setForeground(Color.DARK_GRAY);

        panelPrincipal.add(labelBienvenida);
        getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        validate();
    }

    private List<Equipo> generarEquipos() {
        List<Equipo> equipos = new ArrayList<>();
        String[][] nombresEquipos = {
                {"Brasil", "Tite"}, {"Argentina", "Lionel Scaloni"}, {"Francia", "Didier Deschamps"},
                {"Alemania", "Hansi Flick"}, {"España", "Luis Enrique"}, {"Inglaterra", "Gareth Southgate"},
                {"Italia", "Roberto Mancini"}, {"Bélgica", "Roberto Martínez"}, {"Portugal", "Fernando Santos"},
                {"Países Bajos", "Frank de Boer"}, {"Croacia", "Zlatko Dalic"}, {"Uruguay", "Diego Alonso"},
                {"México", "Gerardo Martino"}, {"Colombia", "Reinaldo Rueda"}, {"Suiza", "Murat Yakin"},
                {"Estados Unidos", "Gregg Berhalter"}
        };

        for (String[] equipoInfo : nombresEquipos) {
            Equipo equipo = new Equipo(equipoInfo[0], equipoInfo[1]);
            equipos.add(equipo);
        }

        return equipos;
    }

    private List<Estadio> generarEstadios() {
        List<Estadio> estadios = new ArrayList<>();
        estadios.add(new Estadio("Estadio Azteca", "Ciudad de México", 87000));
        estadios.add(new Estadio("Maracaná", "Río de Janeiro", 78000));
        estadios.add(new Estadio("Wembley", "Londres", 90000));
        estadios.add(new Estadio("Camp Nou", "Barcelona", 99354));
        estadios.add(new Estadio("San Siro", "Milán", 80018));
        estadios.add(new Estadio("Allianz Arena", "Múnich", 75000));
        return estadios;
    }

    private Map<String, List<Equipo>> dividirEnGrupos() {
        Map<String, List<Equipo>> grupos = new HashMap<>();
        String[] nombresGrupos = {"Grupo A", "Grupo B", "Grupo C", "Grupo D"};
        int equiposPorGrupo = teams.size() / nombresGrupos.length;

        for (int i = 0; i < nombresGrupos.length; i++) {
            List<Equipo> grupo = teams.subList(i * equiposPorGrupo, (i + 1) * equiposPorGrupo);
            grupos.put(nombresGrupos[i], grupo);
        }

        return grupos;
    }

    private void mostrarEquipos(ActionEvent e) {
        getContentPane().removeAll();
        JPanel panelEquipos = new JPanel();
        panelEquipos.setBackground(Color.WHITE);
        panelEquipos.setLayout(new BoxLayout(panelEquipos, BoxLayout.Y_AXIS));

        for (Map.Entry<String, List<Equipo>> entry : grupos.entrySet()) {
            String grupo = entry.getKey();
            List<Equipo> equipos = entry.getValue();

            JPanel panelGrupo = new JPanel();
            panelGrupo.setBackground(Color.WHITE);
            panelGrupo.setLayout(new BoxLayout(panelGrupo, BoxLayout.Y_AXIS));
            panelGrupo.setBorder(BorderFactory.createTitledBorder(grupo));

            for (Equipo equipo : equipos) {
                JPanel panelEquipo = new JPanel();
                panelEquipo.setBackground(Color.WHITE);
                panelEquipo.setLayout(new BorderLayout());

                JLabel labelNombre = new JLabel(equipo.nombre + " - Entrenador: " + equipo.entrenador);
                labelNombre.setFont(new Font("Arial", Font.PLAIN, 12));

                JButton buttonAlineacion = new JButton("Ver Alineación");
                buttonAlineacion.setBackground(Color.GRAY);
                buttonAlineacion.setForeground(Color.WHITE);
                buttonAlineacion.setFont(new Font("Arial", Font.PLAIN, 12));
                buttonAlineacion.setFocusPainted(false);
                buttonAlineacion.addActionListener(a -> mostrarAlineacion(equipo));

                panelEquipo.add(labelNombre, BorderLayout.CENTER);
                panelEquipo.add(buttonAlineacion, BorderLayout.EAST);
                panelGrupo.add(panelEquipo);
            }

            panelEquipos.add(panelGrupo);
            panelEquipos.add(Box.createVerticalStrut(10));
        }

        add(panelEquipos, BorderLayout.CENTER);
        validate();
        repaint();
    }

    private void mostrarAlineacion(Equipo equipo) {
        getContentPane().removeAll();
        JPanel panelAlineacion = new JPanel();
        panelAlineacion.setBackground(Color.WHITE);
        panelAlineacion.setLayout(new BoxLayout(panelAlineacion, BoxLayout.Y_AXIS));

        JLabel labelEquipo = new JLabel("Alineación de " + equipo.nombre);
        labelEquipo.setFont(new Font("Arial", Font.BOLD, 16));
        panelAlineacion.add(labelEquipo);
        panelAlineacion.add(Box.createVerticalStrut(10));

        for (Jugador jugador : equipo.jugadores) {
            JLabel labelJugador = new JLabel(jugador.nombre + " - Edad: " + jugador.edad + " - Posición: " + jugador.posicion);
            labelJugador.setFont(new Font("Arial", Font.PLAIN, 12));
            panelAlineacion.add(labelJugador);
        }

        add(panelAlineacion, BorderLayout.CENTER);
        validate();
        repaint();
    }

    private void mostrarEstadios(ActionEvent e) {
        getContentPane().removeAll();
        JPanel panelEstadios = new JPanel();
        panelEstadios.setBackground(Color.WHITE);
        panelEstadios.setLayout(new BoxLayout(panelEstadios, BoxLayout.Y_AXIS));

        for (Estadio estadio : estadios) {
            JLabel labelEstadio = new JLabel(estadio.nombre + " - " + estadio.ciudad + " - Capacidad: " + estadio.capacidad);
            labelEstadio.setFont(new Font("Arial", Font.PLAIN, 12));
            panelEstadios.add(labelEstadio);
            panelEstadios.add(Box.createVerticalStrut(10));
        }

        add(panelEstadios, BorderLayout.CENTER);
        validate();
        repaint();
    }

    private void mostrarGrupos(ActionEvent e) {
        getContentPane().removeAll();
        JPanel panelGrupos = new JPanel();
        panelGrupos.setBackground(Color.WHITE);
        panelGrupos.setLayout(new BoxLayout(panelGrupos, BoxLayout.Y_AXIS));

        for (Map.Entry<String, List<Equipo>> entry : grupos.entrySet()) {
            String grupo = entry.getKey();
            List<Equipo> equipos = entry.getValue();

            JLabel labelGrupo = new JLabel(grupo);
            labelGrupo.setFont(new Font("Arial", Font.BOLD, 16));
            panelGrupos.add(labelGrupo);
            panelGrupos.add(Box.createVerticalStrut(10));

            for (Equipo equipo : equipos) {
                JLabel labelEquipo = new JLabel(equipo.nombre);
                labelEquipo.setFont(new Font("Arial", Font.PLAIN, 12));
                panelGrupos.add(labelEquipo);
                panelGrupos.add(Box.createVerticalStrut(5));
            }
            panelGrupos.add(Box.createVerticalStrut(10));
        }

        add(panelGrupos, BorderLayout.CENTER);
        validate();
        repaint();
    }

    private Map<String, Map<String, Integer[]>> generarResultados() {
        Map<String, Map<String, Integer[]>> resultados = new HashMap<>();
        Random rand = new Random();

        for (String grupo : grupos.keySet()) {
            Map<String, Integer[]> resultadosGrupo = new HashMap<>();
            List<Equipo> equipos = grupos.get(grupo);

            for (int i = 0; i < equipos.size(); i++) {
                for (int j = i + 1; j < equipos.size(); j++) {
                    String partido = equipos.get(i).nombre + " vs " + equipos.get(j).nombre;
                    Integer[] resultado = {rand.nextInt(5), rand.nextInt(5)};
                    resultadosGrupo.put(partido, resultado);
                }
            }
            resultados.put(grupo, resultadosGrupo);
        }

        return resultados;
    }

    private void mostrarPartidos(ActionEvent e) {
        getContentPane().removeAll();
        JPanel panelPartidos = new JPanel();
        panelPartidos.setBackground(Color.WHITE);
        panelPartidos.setLayout(new BoxLayout(panelPartidos, BoxLayout.Y_AXIS));

        for (Map.Entry<String, Map<String, Integer[]>> entry : resultados.entrySet()) {
            String grupo = entry.getKey();
            Map<String, Integer[]> resultadosGrupo = entry.getValue();

            JLabel labelGrupo = new JLabel(grupo);
            labelGrupo.setFont(new Font("Arial", Font.BOLD, 16));
            panelPartidos.add(labelGrupo);
            panelPartidos.add(Box.createVerticalStrut(10));

            for (Map.Entry<String, Integer[]> partido : resultadosGrupo.entrySet()) {
                JLabel labelPartido = new JLabel(partido.getKey() + " - Resultado: " + partido.getValue()[0] + " - " + partido.getValue()[1]);
                labelPartido.setFont(new Font("Arial", Font.PLAIN, 12));
                panelPartidos.add(labelPartido);
                panelPartidos.add(Box.createVerticalStrut(5));
            }
            panelPartidos.add(Box.createVerticalStrut(10));
        }

        add(panelPartidos, BorderLayout.CENTER);
        validate();
        repaint();
    }

    private void mostrarOctavos(ActionEvent e) {
        // Aquí deberías implementar la lógica para mostrar los partidos de octavos de final
    }
}
