package testes;

import org.junit.jupiter.api.Test;
import perguntas.BloomLevel;
import perguntas.Question;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {

    @Test
    void respostaCorreta_A_retornaTrue() {
        Question q = new Question("1- O que significa a sigla COP?", new String[]{"A) Comitê de Proteção Oceânica","B) Conferência das Partes","C) Conselho Operacional de Políticas","D) Comissão de Planejamento Climático"}, 1, BloomLevel.LEMBRAR);
        assertTrue(q.verificarResposta("B"));
        assertTrue(q.verificarResposta("b"));

    }

    @Test
    void respostaIncorreta_retornaFalse() {
        Question q = new Question("1- O que significa a sigla COP?", new String[]{"A) Comitê de Proteção Oceânica","B) Conferência das Partes","C) Conselho Operacional de Políticas","D) Comissão de Planejamento Climático"}, 1, BloomLevel.LEMBRAR);
        assertFalse(q.verificarResposta("A"));
        assertFalse(q.verificarResposta("C"));
        assertFalse(q.verificarResposta("D"));
    }

    @Test
    void entradaInvalida_retornaFalse() {
        Question q = new Question("1- O que significa a sigla COP?", new String[]{"A) Comitê de Proteção Oceânica","B) Conferência das Partes","C) Conselho Operacional de Políticas","D) Comissão de Planejamento Climático"}, 1, BloomLevel.LEMBRAR);
        assertFalse(q.verificarResposta("Z"));
        assertFalse(q.verificarResposta(""));
        assertFalse(q.verificarResposta(null));
    }
}
