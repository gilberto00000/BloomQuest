package baus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GerenciadorEventos {

    private HashMap<String, List<OuvinteEvento>> ouvintes = new HashMap<>();

    public void registrar(String nomeEvento, OuvinteEvento ouvinte) {
        ouvintes.putIfAbsent(nomeEvento, new ArrayList<>());
        ouvintes.get(nomeEvento).add(ouvinte);

        System.out.println("Registrado ouvinte para " + nomeEvento);
    }
    public void desbloquearProximaParte(Mapa mapa) {
        mapa.desbloquearProximaParte();
    }

    public void emitir(String nomeEvento, Object dado) {

        List<OuvinteEvento> lista = ouvintes.get(nomeEvento);

        if (lista == null || lista.isEmpty()) {
            System.out.println("Nenhum ouvinte para " + nomeEvento);
            return;
        }

        int count = 0;

        for (OuvinteEvento o : lista) {
            try {
                o.aoOcorrer(nomeEvento, dado);
                count++;
            } catch (Exception e) {
                System.out.println("Erro ao notificar ouvinte: " + e.getMessage());
            }
        }

        System.out.println("Notificados " + count + " ouvintes para " + nomeEvento);
    }
}