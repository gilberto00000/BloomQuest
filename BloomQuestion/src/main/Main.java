package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Reino Verdejante");

        PainelDoJogo painelDoJogo = new PainelDoJogo();
        window.add(painelDoJogo);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        painelDoJogo.startGameThread();
    }
}
