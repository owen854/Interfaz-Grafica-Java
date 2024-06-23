package Gestion_de_Tienda;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame root = new JFrame();
                Interfaz interfaz = new Interfaz(root);
            }
        });
    }
}
