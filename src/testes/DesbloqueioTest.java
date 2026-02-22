package testes;

import baus.Desbloqueio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DesbloqueioTest {

    @Test
    void aoAcertar_quatroAcertos_desbloqueiaArea() {
        Desbloqueio d = new Desbloqueio();

        assertEquals(4, d.getAcertosNecessarios());

        d.aoOcorrer("ACERTOU", null);
        d.aoOcorrer("ACERTOU", null);
        d.aoOcorrer("ACERTOU", null);

        assertEquals("Área 2 - Bloqueada", d.getAreas().get(1));

        d.aoOcorrer("ACERTOU", null);

        assertEquals("Área 2 - Desbloqueada", d.getAreas().get(1));
    }

    @Test
    void desbloqueiaAreasNaOrdemCorreta() {
        Desbloqueio d = new Desbloqueio();

        for (int i = 0; i < 4; i++) d.aoOcorrer("ACERTOU", null);
        assertEquals("Área 2 - Desbloqueada", d.getAreas().get(1));

        for (int i = 0; i < 4; i++) d.aoOcorrer("ACERTOU", null);
        assertEquals("Área 3 - Desbloqueada", d.getAreas().get(2));

        for (int i = 0; i < 4; i++) d.aoOcorrer("ACERTOU", null);
        assertEquals("Área 4 - Desbloqueada", d.getAreas().get(3));

        for (int i = 0; i < 4; i++) d.aoOcorrer("ACERTOU", null);
        assertEquals("Área 5 - Desbloqueada", d.getAreas().get(4));

        for (int i = 0; i < 4; i++) d.aoOcorrer("ACERTOU", null);
        assertEquals("Área 6 - Desbloqueada", d.getAreas().get(5));
    }
}
