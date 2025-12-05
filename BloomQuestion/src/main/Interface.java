package main;

import baus.Desbloqueio;

import java.awt.*;

public class Interface {
    PainelDoJogo gp;
    Font arial_35;
    Desbloqueio db;

    public Interface(PainelDoJogo gp, Desbloqueio db){
        this.gp = gp;
        this.db = db;

        arial_35 = new Font("Arial", Font.ITALIC, 25);
    }

    public void draw(Graphics2D g2){

        g2.setFont(arial_35);
        g2.setColor(Color.WHITE);
        g2.drawString("acertos = " + db.acertosAtual, 22, 30);
    }
}
