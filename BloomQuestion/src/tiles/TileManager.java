package tiles;

import baus.Desbloqueio;
import main.PainelDoJogo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    PainelDoJogo gp;
    public Tile[] tile;
    public int mapTileNum[] [];
    public Desbloqueio db;

    public TileManager(PainelDoJogo gp, Desbloqueio db) {
        this.gp = gp;
        this.db = db;

        tile = new Tile[30];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/world01");
    }

    public void getTileImage() {
        try {
            if (db.acertosAtual >= 2){
                tile[0] = new Tile();
                tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            }else {
                tile[0] = new Tile();
                tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grama.png"));
            }

            if (db.acertosAtual >= 30){
                tile[15] = new Tile();
                tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            }else {
                tile[15] = new Tile();
                tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grama.png"));
            }

            if (db.acertosAtual >= 4){
                tile[16] = new Tile();
                tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            }else {
                tile[16] = new Tile();
                tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grama.png"));
            }

            if (db.acertosAtual >= 6){
                tile[17] = new Tile();
                tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            }else {
                tile[17] = new Tile();
                tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grama.png"));
            }

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tijolo.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/agua.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/areia.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/areia.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/areia1.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/areia2.png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/areia3.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/areia4.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/areia5.png"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/areia6.png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/areia7.png"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/areia8.png"));





        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();

                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch (Exception e){

        }
    }

    public void draw(Graphics g2) {
        int worldCol = 0;
        int worldRow  = 0;


        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.jogador.worldX + gp.jogador.screenX;
            int screenY = worldY - gp.jogador.worldY + gp.jogador.screenY;


            if (worldX  + gp.tileSize >  gp.jogador.worldX - gp.jogador.screenX &&
                worldX  - gp.tileSize < gp.jogador.worldX + gp.jogador.screenX &&
                worldY  + gp.tileSize > gp.jogador.worldY - gp.jogador.screenY &&
                worldY - gp.tileSize < gp.jogador.worldY + gp.jogador.screenY){

            }
            worldCol++;
            g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            if(worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;

            }
        }
    }
}
