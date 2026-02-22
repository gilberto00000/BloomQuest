package testes;

import baus.Mapa;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapaTest {

    @Test
    void parteInicial_deveSer1() {
        Mapa mapa = new Mapa();
        assertEquals(1, mapa.getParteAtual());
    }

    @Test
    void desbloquearProximaParte_incrementaParte() {
        Mapa mapa = new Mapa();
        int inicial = mapa.getParteAtual();
        mapa.desbloquearProximaParte();
        assertEquals(inicial + 1, mapa.getParteAtual());
    }

    @Test
    void nao_excede_limite_39() {
        Mapa mapa = new Mapa();
        for (int i = 1; i < 39; i++) {
            mapa.desbloquearProximaParte();
        }
        assertEquals(39, mapa.getParteAtual());
        mapa.desbloquearProximaParte();
        assertEquals(39, mapa.getParteAtual());
    }
}
