package entity;

import main.PainelDoJogo;
import main.KeyHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Jogador extends Entidade {

    PainelDoJogo gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public int hasKey = 0;

    public Jogador(PainelDoJogo gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 -  (gp.tileSize/2);

        solidArea = new Rectangle(); // you can change this using parametter. example: solidArea = new Rectangle(8, 16, 32, 32);
        solidArea.x = 8;
        solidArea.y = 16;
        areadeInteracaoX = solidArea.x;
        areadeInteracaoY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();

    }
    public void getPlayerImage(){

        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/cima.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/cima1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/baixo.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/baixo1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/esquerda.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/esquerda1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/direita.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/direita1.png"));


        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 42;
        worldY = gp.tileSize * 73;
        speed = 5;
        direction = "down";

    }

    public void responderPergunta(){
    }

    public void update(){
        if (keyH.upPressed == true || keyH.downPressed == true ||
                keyH.leftPressed == true || keyH.rightPressed == true) {

            if (keyH.upPressed == true){
                direction = "up";
            }
            else if (keyH.downPressed == true){
                direction = "down";
            }
            else if (keyH.leftPressed == true){
                direction = "left";
            }
            else if (keyH.rightPressed == true){
                direction = "right";
            }

            //checa colisao de tiles
            colisaoOn = false;
            gp.cChecker.checkTile(this);

            //se nao houver colisao, o player se move
            if (colisaoOn == false){
                switch (direction){
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }




            spriteCounter++;

            if (spriteCounter > 12){
                if (spriteNum == 1){
                    spriteNum = 2;
                }
                else if (spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }

    }
    public void draw(Graphics2D g2){

//        g2.setColor(Color.WHITE);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage img = null;

        switch (direction){
            case "up":
                if (spriteNum == 1){
                    img = up1;
                }
                if(spriteNum == 2){
                    img = up2;
                }
                break;
            case "down":
                if (spriteNum == 1){
                    img = down1;
                }
                if(spriteNum == 2){
                    img = down2;
                }
                break;
            case "left":
                if (spriteNum == 1){
                    img = left1;
                }
                if(spriteNum == 2){
                    img = left2;
                }
                break;
            case "right":
                if (spriteNum == 1){
                    img = right1;
                }
                if(spriteNum == 2){
                    img = right2;
                }
                break;
        }
        g2.drawImage(img, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
