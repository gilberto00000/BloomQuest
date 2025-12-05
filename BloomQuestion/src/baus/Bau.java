package baus;

import entity.Entidade;
import exceptions.InvalidAnswerException;
import main.PainelDoJogo;
import perguntas.Question;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Bau extends Entidade {
    private int x, y;
    private Question qm;
    PainelDoJogo gp;

    public Bau(Question q) {
        super();
        this.qm = q;

    }

    public void getImageBau(){
        try{
             up1 = ImageIO.read(getClass().getResourceAsStream("/tiles/bau.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public Bau(int x, int y, PainelDoJogo gp) {
        this.x = x;
        this.y = y;
        this.gp = gp;

        getImageBau();
    }

    public String exibirPergunta(){
        return qm.getPergunta();
    }

    public boolean verificarPergunta(String resposta) {

        if (resposta == null || resposta.isBlank()) {
            throw new InvalidAnswerException("A resposta não pode ser vazia.");
        }

        resposta = resposta.trim().toUpperCase();

        if (!resposta.matches("[ABCD]")) {
            throw new InvalidAnswerException("Resposta inválida. Use apenas A, B, C ou D.");
        }

        boolean correta = qm.verificarResposta(resposta);

        if (correta) {
            System.out.println("Resposta correta!");
        } else {
            System.out.println("Resposta incorreta.");
        }

        return correta;
    }

    public Question getQuestion() {
        return qm;
    }

    public void draw(Graphics2D g2){
        //g2.setColor(Color.orange);
        //g2.fillRect(  x - gp.jogador.worldX + gp.jogador.screenX, y - gp.jogador.worldY + gp.jogador.screenY, gp.tileSize, gp.tileSize);

        BufferedImage img = null;

        img = up1;

        g2.drawImage(img, x - gp.jogador.worldX + gp.jogador.screenX, y - gp.jogador.worldY + gp.jogador.screenY, gp.tileSize, gp.tileSize, null);

    }
}