package baus;

import exceptions.BelezanegativaInvalidoException;

public class Mapa {

    public int beleza = 0;
    private int parteAtual;

    public Mapa() {
        this.parteAtual = 1; // Começa na primeira parte
    }

    public void exibirMapa() {
        System.out.println("Parte atual desbloqueada: " + parteAtual + "/39");
    }

    public boolean estaCompleto() {
        return parteAtual > 39;
    }

    public void desbloquearProximaParte() {
        if (parteAtual < 39) {
            parteAtual++;
        }
    }

    public void melhorarBeleza() {
        beleza++;
        System.out.println("Beleza ficou mais bonita. Beleza = " + beleza);
    }

    public void piorarAmbiente() {
        beleza--;
        if (beleza < 0) {
            throw new BelezanegativaInvalidoException("Beleza não pode ser negativa!");
        }
        System.out.println("Beleza ficou baixa. Beleza = " + beleza);
    }

    public void mostrarEstadoMapa() {
        System.out.println("Beleza = " + beleza);
    }

    public int getBeleza() {
        return beleza;
    }

    public int getParteAtual() {
        return parteAtual;
    }
}
