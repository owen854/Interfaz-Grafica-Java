package com.mycompany.mundial;

import javax.swing.SwingUtilities;

public class Mundial {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MundialGUI app = new MundialGUI();
            app.setVisible(true);
        });
    }
}
