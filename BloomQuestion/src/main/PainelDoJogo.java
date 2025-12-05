package main;

import baus.Bau;
import baus.Desbloqueio;
import entity.Jogador;
import exceptions.BelezanegativaInvalidoException;
import exceptions.EmptyQuestionListException;
import exceptions.InvalidAnswerException;
import perguntas.Question;
import perguntas.QuestionManager;
import tiles.TileManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class PainelDoJogo extends JPanel implements Runnable {
    @Override

    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long currentTime;
        long lastTime = System.nanoTime();
        long timer = 0;
        int drawCounter = 0;

        while (gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >=1){
                update();
                repaint();
                delta--;
                drawCounter++;
            }
            if (timer >= 1000000000){
                System.out.println("FPS: " + drawCounter);
                drawCounter = 0;
                timer = 0;
            }
        }
    }

    final int originalTileSize = 16;
    final int scale = 4;

    public final int tileSize = originalTileSize * scale; // 64x64 tile
    public final int maxScreenCol = 30;
    public final int maxScreenRow = 17;
    public final int screenWidth = tileSize * maxScreenCol; //
    public final int screenHeight = tileSize * maxScreenRow; //

    //config do mundo
    public final int maxWorldCol = 84;
    public final int maxWorldRow = 84;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;


    //sistema
    Desbloqueio db = new Desbloqueio();
    TileManager tileM = new TileManager(this, db);
    KeyHandler keyH = new KeyHandler();
    public CollisionCheck cChecker = new CollisionCheck(this);
    public Interface anInterface = new Interface(this, db);
    Thread gameThread;
    QuestionManager qm;
    List<Bau> baus = new ArrayList<>();
    List<Botao> botoes = new ArrayList<>();
    public Jogador jogador = new Jogador(this, keyH);






    public PainelDoJogo() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.green);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        qm = new QuestionManager();

        this.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                int mx = e.getX();
                int my = e.getY();

                for (Botao b: botoes){
                    int telaX = b.x - jogador.worldX + jogador.screenX;
                    int telaY = b.y - jogador.worldY + jogador.screenY;

                    if (mx > telaX && mx < telaX + b.largura &&
                            my > telaY && my < telaY + b.altura){
                        b.abrirPergunta(b.perguntaID);
                    }
                }
            }
        });

        botoes.add(new Botao((42 - 5)*tileSize, (73 + 3)*tileSize, 48, 48, 1, "Pergunta 1"));
        baus.add(new Bau((42 - 5)*tileSize, (73 + 3)*tileSize, this));
        botoes.add(new Botao((42 - 5)*tileSize, (73 + 3)*tileSize, 48, 48, 2, "Pergunta 2"));
        baus.add(new Bau((42 - 5)*tileSize, (73 + 3)*tileSize, this));
        botoes.add(new Botao((42-16)*tileSize, (73 + 3)*tileSize, 48, 48, 3, "Pergunta 3"));
        baus.add(new Bau((42-16)*tileSize, (73 + 3)*tileSize, this));
        botoes.add(new Botao((42-16)*tileSize, (73 + 3)*tileSize, 48, 48, 4, "Pergunta 4"));
        baus.add(new Bau((42-16)*tileSize, (73 + 3)*tileSize, this));
        botoes.add(new Botao((42-25)*tileSize, (73 + 3)*tileSize, 48, 48, 5, "Pergunta 1"));
        baus.add(new Bau((42-25)*tileSize, (73 + 3)*tileSize, this));
        botoes.add(new Botao((42-25)*tileSize, (73 + 3)*tileSize, 48, 48, 6, "Pergunta 2"));
        baus.add(new Bau((42-25)*tileSize, (73 + 3)*tileSize, this));
        botoes.add(new Botao((42 - 34)*tileSize, (73 + 3)*tileSize, 48, 48, 7, "Pergunta 4"));
        baus.add(new Bau((42 - 34)*tileSize, (73 + 3)*tileSize, this));
        botoes.add(new Botao((42 - 34)*tileSize, (73 + 3)*tileSize, 48, 48, 8, "Pergunta 1"));
        baus.add(new Bau((42 - 34)*tileSize, (73 + 3)*tileSize, this));
        botoes.add(new Botao((42 - 5)*tileSize, 72*tileSize, 48, 48, 9, "Pergunta 2"));
        baus.add(new Bau((42 - 5)*tileSize, 72*tileSize, this));
        botoes.add(new Botao((42 - 5)*tileSize, 72*tileSize, 48, 48, 10, "Pergunta 3"));
        baus.add(new Bau((42 - 5)*tileSize, 72*tileSize, this));
        botoes.add(new Botao((42 - 16)*tileSize, 72*tileSize, 48, 48, 11, "Pergunta 4"));
        baus.add(new Bau((42 - 16)*tileSize, 72*tileSize, this));
        botoes.add(new Botao((42 - 16)*tileSize, 72*tileSize, 48, 48, 12, "Pergunta 1"));
        baus.add(new Bau((42 - 16)*tileSize, 72*tileSize, this));
        botoes.add(new Botao((42 - 25)*tileSize, 72*tileSize, 48, 48, 13, "Pergunta 2"));
        baus.add(new Bau((42 - 25)*tileSize, 72*tileSize, this));
        botoes.add(new Botao((42 - 25)*tileSize, 72*tileSize, 48, 48, 14, "Pergunta 3"));
        baus.add(new Bau((42 - 25)*tileSize, 72*tileSize, this));
        botoes.add(new Botao((42 - 34)*tileSize, 72*tileSize, 48, 48, 15, "Pergunta 4"));
        baus.add(new Bau((42 - 34)*tileSize, 72*tileSize, this));
        botoes.add(new Botao((42 - 34)*tileSize, 72*tileSize, 48, 48, 16, "Pergunta 3"));
        baus.add(new Bau((42 - 34)*tileSize, 72*tileSize, this));
        botoes.add(new Botao((42 - 5)*tileSize, 65*tileSize, 48, 48, 17, "Pergunta 1"));
        baus.add(new Bau((42 - 5)*tileSize, 65*tileSize, this));
        botoes.add(new Botao((42 - 5)*tileSize, 65*tileSize, 48, 48, 18, "Pergunta 2"));
        baus.add(new Bau((42 - 5)*tileSize, 65*tileSize, this));
        botoes.add(new Botao((42 - 16)*tileSize, 65*tileSize, 48, 48, 19, "Pergunta 3"));
        baus.add(new Bau((42 - 16)*tileSize, 65*tileSize, this));
        botoes.add(new Botao((42 - 16)*tileSize, 65*tileSize, 48, 48, 20, "Pergunta 4"));
        baus.add(new Bau((42 - 16)*tileSize, 65*tileSize, this));
        botoes.add(new Botao((42-25)*tileSize, 65*tileSize, 48, 48, 21, "Pergunta 1"));
        baus.add(new Bau((42-25)*tileSize, 65*tileSize, this));
        botoes.add(new Botao((42-25)*tileSize, 65*tileSize, 48, 48, 22, "Pergunta 2"));
        baus.add(new Bau((42-25)*tileSize, 65*tileSize, this));
        botoes.add(new Botao((42 - 34)*tileSize, 65*tileSize, 48, 48, 23, "Pergunta 4"));
        baus.add(new Bau((42 - 34)*tileSize, 65*tileSize, this));
        botoes.add(new Botao((42 - 34)*tileSize, 65*tileSize, 48, 48, 24, "Pergunta 1"));
        baus.add(new Bau((42 - 34)*tileSize, 65*tileSize, this));
        botoes.add(new Botao(31*tileSize, 5*tileSize, 48, 48, 25, "Pergunta 2"));
        baus.add(new Bau(31*tileSize, 5*tileSize, this));
        botoes.add(new Botao(31*tileSize, 10*tileSize, 48, 48, 26, "Pergunta 3"));
        baus.add(new Bau(31*tileSize, 10*tileSize, this));
        botoes.add(new Botao(31*tileSize, 15*tileSize, 48, 48, 27, "Pergunta 4"));
        baus.add(new Bau(31*tileSize, 15*tileSize, this));
        botoes.add(new Botao(31*tileSize, 1*tileSize, 48, 48, 28, "Pergunta 1"));
        baus.add(new Bau(31*tileSize, 1*tileSize, this));
        botoes.add(new Botao(31*tileSize, 5*tileSize, 48, 48, 29, "Pergunta 2"));
        baus.add(new Bau(31*tileSize, 5*tileSize, this));
        botoes.add(new Botao(31*tileSize, 10*tileSize, 48, 48, 30, "Pergunta 3"));
        baus.add(new Bau(31*tileSize, 10*tileSize, this));
        botoes.add(new Botao(26*tileSize, 15*tileSize, 48, 48, 31, "Pergunta 4"));
        baus.add(new Bau(26*tileSize, 15*tileSize, this));
        botoes.add(new Botao(26*tileSize, 10*tileSize, 48, 48, 32, "Pergunta 3"));
        baus.add(new Bau(26*tileSize, 10*tileSize, this));
        botoes.add(new Botao(26*tileSize, 1*tileSize, 48, 48, 33, "Pergunta 1"));
        baus.add(new Bau(26*tileSize, 1*tileSize, this));
        botoes.add(new Botao(26*tileSize, 5*tileSize, 48, 48, 34, "Pergunta 2"));
        baus.add(new Bau(26*tileSize, 5*tileSize, this));
        botoes.add(new Botao(26*tileSize, 10*tileSize, 48, 48, 35, "Pergunta 3"));
        baus.add(new Bau(26*tileSize, 10*tileSize, this));
        botoes.add(new Botao(26*tileSize, 15*tileSize, 48, 48, 36, "Pergunta 4"));
        baus.add(new Bau(26*tileSize, 15*tileSize, this));
        botoes.add(new Botao(26*tileSize, 10*tileSize, 48, 48, 37, "Pergunta 3"));
        baus.add(new Bau(26*tileSize, 10*tileSize, this));
        botoes.add(new Botao(26*tileSize, 15*tileSize, 48, 48, 38, "Pergunta 4"));
        baus.add(new Bau(26*tileSize, 15*tileSize, this));
        botoes.add(new Botao(26*tileSize, 10*tileSize, 48, 48, 39, "Pergunta 3"));
        baus.add(new Bau(26*tileSize, 10*tileSize, this));

    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    public void update() {
        jogador.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);


        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);

        for (Bau b: baus){
            b.draw(g2);
        }

        jogador.draw(g2);


        g2.setColor(Color.WHITE);

        for (Botao b: botoes){
            int telaX = b.x - jogador.worldX + jogador.screenX;
            int telaY = b.y - jogador.worldY + jogador.screenY;

            if (telaX + b.largura > 0 && telaX < screenWidth &&
                    telaY + b.altura > 0 && telaY < screenHeight) {
                if (b.img != null) {
                    g2.drawImage(
                            b.img,
                            telaX, telaY,
                            b.largura, b.altura,
                            null
                    );
                } else {
                    // desenho normal se a imagem não carregar
                    g2.setColor(new Color(0, 0, 0, 150));
                    g2.fillRoundRect( telaX, telaY, b.largura, b.altura, 20, 20);

                    g2.setColor(Color.WHITE);
                    g2.drawRoundRect(b.x - jogador.worldX + jogador.screenX, b.y - jogador.worldY + jogador.screenY, b.largura, b.altura, 20, 20);

                    g2.drawString(b.texto, b.x - jogador.worldX + jogador.screenX + 10, b.y - jogador.worldY + jogador.screenY + 25);
                }
            }
        }

        anInterface.draw(g2);
        g2.dispose();
    }

    class Botao extends Component {
        int x, y, largura, altura;
        int perguntaID;
        String texto;
        Image img;

        public Botao(int x, int y, int l, int a, int ID, String texto){
            this.x = x;
            this.y = y;
            this.largura = l;
            this.altura = a;
            this.perguntaID = ID;
            this.texto = texto;

            getBotaoImg();

        }
        public void getBotaoImg(){
            try {
                img = new ImageIcon("caminho/da/bau.png").getImage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public boolean jaClick(int mx, int my){
            return mx > x && mx < x + largura
                    && my > y && my < y + altura;
        }

        public void abrirPergunta(int parte){
            try {

                Question q = qm.getPerguntaDaParte(parte);  // pode lançar EmptyQuestionListException

                if (q.respondido) {
                    JOptionPane.showMessageDialog(null, "Pergunta já respondida.");
                    return;
                }

                String pergunta = q.getPergunta();
                String[] opcoes = q.getAlternativas();

                int escolha = JOptionPane.showOptionDialog(
                        this,
                        pergunta,
                        "Pergunta " + parte,
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]
                );

                if (escolha == JOptionPane.CLOSED_OPTION) {
                    throw new InvalidAnswerException("Você fechou a pergunta sem responder.");
                }

                if (escolha == q.getRespostaCorreta()) {
                    db.acertosAtual++;
                    q.respondido = true;
                    tileM.getTileImage();
                    JOptionPane.showMessageDialog(null, "Resposta correta!");

                } else {
                    throw new InvalidAnswerException("Resposta incorreta!");
                }

                if (jogador.beleza < 0) {
                    throw new BelezanegativaInvalidoException("A beleza ficou negativa!");
                }

            } catch (EmptyQuestionListException e) {
                JOptionPane.showMessageDialog(null,
                        "Erro: Nenhuma pergunta encontrada.\n" + e.getMessage());

            } catch (InvalidAnswerException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            } catch (BelezanegativaInvalidoException e) {
                JOptionPane.showMessageDialog(null,
                        "Erro crítico: " + e.getMessage());
            }

        }
    }
}
