package main;

import entity.Entidade;

public class CollisionCheck {
    PainelDoJogo gp;

    public CollisionCheck(PainelDoJogo gp) {
        this.gp = gp;
    }

    public void checkTile(Entidade entidade){
        int esquerdaDaEntidadeMundoX = entidade.worldX + entidade.solidArea.x;
        int direitaDaEntidadeMundoX = entidade.worldX + entidade.solidArea.x + entidade.solidArea.width;
        int topoDaEntidadeMundoY = entidade.worldY + entidade.solidArea.y;
        int baseDaEntidadeMundoY = entidade.worldY + entidade.solidArea.y + entidade.solidArea.height;

        int colunaEsquerdaDaEntidade = esquerdaDaEntidadeMundoX/gp.tileSize;
        int colunaDireitaDaEntidade = direitaDaEntidadeMundoX/gp.tileSize;
        int linhaTopoDaEntidade = topoDaEntidadeMundoY/gp.tileSize;
        int linhaBaseDaEntidade = baseDaEntidadeMundoY/gp.tileSize;

        int primeiroTile, segundoTile;

        switch (entidade.direction){
            case "up":
                linhaTopoDaEntidade = (topoDaEntidadeMundoY - entidade.speed)/gp.tileSize;
                primeiroTile = gp.tileM.mapTileNum[colunaEsquerdaDaEntidade][linhaTopoDaEntidade];
                segundoTile = gp.tileM.mapTileNum[colunaDireitaDaEntidade][linhaTopoDaEntidade];
                if (gp.tileM.tile[primeiroTile].collision == true
                    || gp.tileM.tile[segundoTile].collision == true){
                    entidade.colisaoOn = true;
                }
                break;
            case "down":
                linhaBaseDaEntidade = (baseDaEntidadeMundoY - entidade.speed)/gp.tileSize;
                primeiroTile = gp.tileM.mapTileNum[colunaEsquerdaDaEntidade][linhaBaseDaEntidade];
                segundoTile = gp.tileM.mapTileNum[colunaDireitaDaEntidade][linhaBaseDaEntidade];
                if (gp.tileM.tile[primeiroTile].collision == true
                        || gp.tileM.tile[segundoTile].collision == true){
                    entidade.colisaoOn = true;
                }
                break;
            case "left":
                colunaEsquerdaDaEntidade = (esquerdaDaEntidadeMundoX - entidade.speed)/gp.tileSize;
                primeiroTile = gp.tileM.mapTileNum[colunaEsquerdaDaEntidade][linhaTopoDaEntidade];
                segundoTile = gp.tileM.mapTileNum[colunaEsquerdaDaEntidade][linhaBaseDaEntidade];
                if (gp.tileM.tile[primeiroTile].collision == true
                        || gp.tileM.tile[segundoTile].collision == true){
                    entidade.colisaoOn = true;
                }
                break;
            case "right":
                colunaDireitaDaEntidade = (direitaDaEntidadeMundoX - entidade.speed)/gp.tileSize;
                primeiroTile = gp.tileM.mapTileNum[colunaDireitaDaEntidade][linhaTopoDaEntidade];
                segundoTile = gp.tileM.mapTileNum[colunaDireitaDaEntidade][linhaBaseDaEntidade];
                if (gp.tileM.tile[primeiroTile].collision == true
                        || gp.tileM.tile[segundoTile].collision == true){
                    entidade.colisaoOn = true;
                }
                break;

        }
    }
}
