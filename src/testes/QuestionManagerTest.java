package testes;

import exceptions.EmptyQuestionListException;
import org.junit.jupiter.api.Test;
import perguntas.Question;
import perguntas.QuestionManager;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionManagerTest {

    @Test
    void getPerguntaDaParte_valida_paraParte1() {
        QuestionManager qm = new QuestionManager();
        Question q = qm.getPerguntaDaParte(1);
        assertNotNull(q);
        assertEquals("1- O que significa a sigla COP?", q.getPergunta());
    }


    @Test
    void getPerguntaDaParte_parteInvalida_deveLancar() {
        QuestionManager qm = new QuestionManager();
        assertThrows(EmptyQuestionListException.class, () -> qm.getPerguntaDaParte(0));
        assertThrows(EmptyQuestionListException.class, () -> qm.getPerguntaDaParte(40));
    }
}
