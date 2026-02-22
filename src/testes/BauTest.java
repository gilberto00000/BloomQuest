package testes;

import baus.Bau;
import exceptions.InvalidAnswerException;
import org.junit.jupiter.api.Test;
import perguntas.BloomLevel;
import perguntas.Question;

import static org.junit.jupiter.api.Assertions.*;

public class BauTest {

    @Test
    void exibirPergunta_retornaTextoDaPergunta() {
        Question q = new Question("1- O que significa a sigla COP?", new String[]{"A) Comitê de Proteção Oceânica","B) Conferência das Partes","C) Conselho Operacional de Políticas","D) Comissão de Planejamento Climático"}, 1, BloomLevel.LEMBRAR);
        Bau bau = new Bau(q);
        assertEquals("1- O que significa a sigla COP?", bau.exibirPergunta());
    }

    @Test
    void verificarPergunta_correta_retornaTrue() {
        Question q = new Question("1- O que significa a sigla COP?", new String[]{"A) Comitê de Proteção Oceânica","B) Conferência das Partes","C) Conselho Operacional de Políticas","D) Comissão de Planejamento Climático"}, 1, BloomLevel.LEMBRAR);
        Bau bau = new Bau(q);
        assertTrue(bau.verificarPergunta("B"));
    }

    @Test
    void verificarPergunta_invalida_lancaException() {
        Question q = new Question("1- O que significa a sigla COP?", new String[]{"A) Comitê de Proteção Oceânica","B) Conferência das Partes","C) Conselho Operacional de Políticas","D) Comissão de Planejamento Climático"}, 1, BloomLevel.LEMBRAR);
        Bau bau = new Bau(q);
        assertThrows(InvalidAnswerException.class, () -> bau.verificarPergunta(""));
    }
}

