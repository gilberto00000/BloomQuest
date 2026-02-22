package baus;

import java.util.ArrayList;
import java.util.List;

public class Desbloqueio implements OuvinteEvento {

    private int acertosNecessarios = 4;
    public int acertosAtual = 0;

    private final List<String> areas = new ArrayList<>();
    private int proximaArea = 2;

    public Desbloqueio() {
        inicializarAreas();
    }

    public Desbloqueio(int acertosNecessarios) {
        this();
        this.acertosNecessarios = acertosNecessarios;
    }

    private void inicializarAreas() {
        areas.clear();
        areas.add("Área 1 - Desbloqueada");
        areas.add("Área 2 - Bloqueada");
        areas.add("Área 3 - Bloqueada");
        areas.add("Área 4 - Bloqueada");
        areas.add("Área 5 - Bloqueada");
        areas.add("Área 6 - Bloqueada");
    }

    public int getAcertosNecessarios() {
        return acertosNecessarios;
    }

    public int getAcertosAtual() {
        return acertosAtual;
    }

    public List<String> getAreas() {
        return areas;
    }

    @Override
    public void aoOcorrer(String nomeEvento, Object dado) {
        if ("ACERTOU".equals(nomeEvento)) {
            acertosAtual++;
            verificarDesbloqueio();
        }
    }

    private void verificarDesbloqueio() {
        if (acertosAtual >= acertosNecessarios) {
            desbloquearArea();
            acertosAtual = 0;
        }
    }

    private void desbloquearArea() {
        if (proximaArea > 6) {
            return;
        }

        int index = proximaArea - 1;
        String nomeArea = "Área " + proximaArea;

        areas.set(index, nomeArea + " - Desbloqueada");
        System.out.println("NOVA ÁREA DESBLOQUEADA → " + nomeArea);

        proximaArea++;
    }


}

