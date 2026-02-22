package testes;

import baus.GerenciadorEventos;
import baus.OuvinteEvento;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorEventosTest {

    @Test
    void registrar_e_emitir_notificaOuvinte() {
        GerenciadorEventos ge = new GerenciadorEventos();
        final boolean[] notified = {false};

        OuvinteEvento o = (nomeEvento, dado) -> {
            if ("TESTE".equals(nomeEvento)) {
                notified[0] = true;
            }
        };

        ge.registrar("TESTE", o);
        ge.emitir("TESTE", null);

        assertTrue(notified[0], "O ouvinte deve ter sido notificado");
    }

    @Test
    void emitir_semOuvintes_naoLanca() {
        GerenciadorEventos ge = new GerenciadorEventos();
        assertDoesNotThrow(() -> ge.emitir("NAO EXISTE", null));
    }
}
