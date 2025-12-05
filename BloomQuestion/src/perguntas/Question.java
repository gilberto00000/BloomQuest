package perguntas;

public class Question {
    private String pergunta;
    private String[] alternativas;
    protected int respostaCorreta;
    private BloomLevel level;
    public boolean respondido;

    public Question(String pergunta, String[] alternativas, int respostaCorreta, BloomLevel level) {
        this.pergunta = pergunta;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
        this.level = level;
    }

    public boolean verificarResposta(String r) {
        if (r == null || r.isEmpty()) return false;

        r = r.toUpperCase();
        char letra = r.charAt(0);

        if (letra < 'A' || letra > 'D') {
            return false; // resposta inválida
        }

        int indice = letra - 'A';
        return indice == respostaCorreta;
    }

    public BloomLevel getLevel() {
        return level;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(String[] alternativas) {
        this.alternativas = alternativas;
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(int respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public void setLevel(BloomLevel level) {
        this.level = level;
    }

    public int respostaCorreta() {
        return respostaCorreta;
    }

    public String getOpcaoA() {
        return alternativas[0];
    }

    public String getOpcaoB() {
        return alternativas[1];
    }

    public String getOpcaoC() {
        return alternativas[2];
    }

    public String getOpcaoD() {
        return alternativas[3];
    }
}



