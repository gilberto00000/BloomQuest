package perguntas;

import exceptions.EmptyQuestionListException;

import java.util.*;

public class QuestionManager {

    private Map<Integer, List<Question>> perguntasMapa;
    private Random random;

    public QuestionManager() {
        this.perguntasMapa = new HashMap<>();
        this.random = new Random();
        carregarPerguntas();
    }

    private void carregarPerguntas() {

        List<Question> parte1 = new ArrayList<>();
        parte1.add(new Question(
                "1- O que significa a sigla COP?",
                new String[]{
                        "A) Comitê de Proteção Oceânica",
                        "B) Conferência das Partes",
                        "C) Conselho Operacional de Políticas",
                        "D) Comissão de Planejamento Climático"
                },
                1,
                BloomLevel.LEMBRAR
        ));

        List<Question> parte2 = new ArrayList<>();
        parte2.add(new Question(
                "2- O que é o efeito estufa?",
                new String[]{
                        "A) Aumento da radiação solar",
                        "B) Acúmulo de gás ozônio na atmosfera",
                        "C) Retenção de calor na atmosfera por gases específicos",
                        "D) Fenômeno de resfriamento da Terra"
                },
                2,
                BloomLevel.LEMBRAR
        ));
        List<Question> parte3 = new ArrayList<>();
        parte3.add(new Question(
                "3- O que são gases de efeito estufa?",
                new String[]{
                        "A) Gases que filtram luz ultravioleta",
                        "B) Gases que aquecem a atmofera",
                        "C) Gases liberados por plantas",
                        "D) Gases presentes somente em indústrias"
                },
                1,
                BloomLevel.LEMBRAR
        ));
        List<Question> parte4 = new ArrayList<>();
        parte4.add(new Question(
                "4- O que é desmatamento?",
                new String[]{
                        "A) Cultivo de árvores",
                        "B) Remoção de árvores de uma floresta",
                        "C) Reflorestamento urbano",
                        "D) Proteção de áreas verdes"
                },
                1,
                BloomLevel.LEMBRAR
        ));
        List<Question> parte5 = new ArrayList<>();
        parte5.add(new Question(
                "1- Por que a COP30 é importante para o meio ambiente?",
                new String[]{
                        "A) Porque trata de esportes sustentáveis",
                        "B) Porque discute metas globais contra a crise climática",
                        "C) Porque define feriados internacionais",
                        "D) Porque regula preços de energia"
                },
                1,
                BloomLevel.COMPREENDER
        ));
        List<Question> parte6 = new ArrayList<>();
        parte6.add(new Question(
                "2- Por que o desmatamento aumenta a emissão de carbono?",
                new String[]{
                        "A) Árvores absorvem oxigênio",
                        "B) Árvores liberam o metano ao crescer",
                        "C) Árvores armazenam carbono e liberam ao serem derrubadas",
                        "D) Árvores aumentam a chuva ácida"
                },
                2,
                BloomLevel.COMPREENDER
        ));
        List<Question> parte7 = new ArrayList<>();
        parte7.add(new Question(
                "3- Como a poluição do ar impacta a saúde humana?",
                new String[]{
                        "A) Aumenta a fertilidade",
                        "B) Melhora o sistema imunológico",
                        "C) Pode causar doenças respiratórias",
                        "D) Reduz alergias"
                },
                2,
                BloomLevel.COMPREENDER
        ));
        List<Question> parte8 = new ArrayList<>();
        parte8.add(new Question(
                "4- Por que a Amazônia é essencial?",
                new String[]{
                        "A) Produz a maior parte do oxigênio mundial",
                        "B) Regula o clima e abriga enorme biodiversidade",
                        "C) É a única floresta tropical do planeta",
                        "D) Possui o maior lago do mundo"
                },
                1,
                BloomLevel.COMPREENDER
        ));
        List<Question> parte9 = new ArrayList<>();
        parte9.add(new Question(
                "5- Como o aquecimento global afeta os oceanos?",
                new String[]{
                        "A) Reduz a temperatura da água",
                        "B) Aumenta o nível da água",
                        "C) Faz os oceanos secarem",
                        "D) Diminui o sal da água"
                },
                2,
                BloomLevel.COMPREENDER
        ));
        List<Question> parte10 = new ArrayList<>();
        parte10.add(new Question(
                "1- Como uma cidade pode reduzir a poluição do ar?",
                new String[]{
                        "A) Aumentando a frota de carros",
                        "B) Incentivando transporte público e bicicletas",
                        "C) Reduzindo áreas verdes",
                        "D) Estimulando combustíveis fósseis"
                },
                1,
                BloomLevel.APLICAR
        ));
        List<Question> parte11 = new ArrayList<>();
        parte11.add(new Question(
                "2- Como o cidadão pode reduzir emissões?",
                new String[]{
                        "A) Usando carro sempre",
                        "B) Comprando mais plástico",
                        "C) Reduzindo consumo e reciclando",
                        "D) Aumentando o uso de energia"
                },
                2,
                BloomLevel.APLICAR
        ));
        List<Question> parte12 = new ArrayList<>();
        parte12.add(new Question(
                "3- Como aplicar economia circular no dia a dia?",
                new String[]{
                        "A) Jogando fora itens pouco usados",
                        "B) Comprando tudo novo",
                        "C) Usando produtos descartáveis",
                        "D) Reutilizando, consertando e reciclando"
                },
                3,
                BloomLevel.APLICAR
        ));
        List<Question> parte13 = new ArrayList<>();
        parte13.add(new Question(
                "4- Como empresa podem diminuir resíduos?",
                new String[]{
                        "A) Produzindo mais embalagens",
                        "B) Incentivando descarte irregular",
                        "C) Reduzindo, reutilizando e criando logística reversa",
                        "D) Aumentando o consumo sem restrição"
                },
                2,
                BloomLevel.APLICAR
        ));
        List<Question> parte14 = new ArrayList<>();
        parte14.add(new Question(
                "5- Como aplicar consumo consciente em casa?",
                new String[]{
                        "A) Deixar luzes acesas",
                        "B) Comprar sem necessidade",
                        "C) Reduzir desperdícios e priorizar reutilização",
                        "D) Usar mais plástico"
                },
                2,
                BloomLevel.APLICAR
        ));
        List<Question> parte15 = new ArrayList<>();
        parte15.add(new Question(
                "6- Como municípios podem usar energia limpa?",
                new String[]{
                        "A) Aumentando usinas de carvão",
                        "B) Expandindo termoelétricas",
                        "C) Ampliando combutíveis fósseis",
                        "D) Icentivando energia solar e eólica"
                },
                3,
                BloomLevel.APLICAR
        ));
        List<Question> parte16 = new ArrayList<>();
        parte16.add(new Question(
                "1- Quais são os impactos sociais do desmatamento?",
                new String[]{
                        "A) Aumento da renda imediata",
                        "B) Prejuízo a comunidades tradicionais",
                        "C) Expansão de áreas verdes",
                        "D) Redução da poluição"
                },
                1,
                BloomLevel.ANALISAR
        ));
        List<Question> parte17 = new ArrayList<>();
        parte17.add(new Question(
                "2- Como a mudança climática afeta a segurança alimentar?",
                new String[]{
                        "A) Aumenta a produtividade agrícola",
                        "B) Diminui variações climáticas",
                        "C) Causa perdas de safra e altera regimes de chuva",
                        "D) Melhora o solo"
                },
                2,
                BloomLevel.ANALISAR
        ));
        List<Question> parte18 = new ArrayList<>();
        parte18.add(new Question(
                "3- Fatores que aumentam emissões no Brasil:",
                new String[]{
                        "A) Aumento de rios",
                        "B) Desmatamento e queimadas",
                        "C) Crescimento de parques",
                        "D) Reflorestamento"
                },
                1,
                BloomLevel.ANALISAR
        ));
        List<Question> parte19 = new ArrayList<>();
        parte19.add(new Question(
                "4- Quem tem maior responsabilidade nas metas climáticas?",
                new String[]{
                        "A) Os cidadãos",
                        "B) O governo",
                        "C) Governo, empresas e sociedade",
                        "D) ONGs"
                },
                2,
                BloomLevel.ANALISAR
        ));
        List<Question> parte20 = new ArrayList<>();
        parte20.add(new Question(
                "5- Desafios para políticas sustentáveis:",
                new String[]{
                        "A) Baixo custo inicial",
                        "B) Excesso de florestas",
                        "C) Alto apoio público",
                        "D) Falta de interesse político e investimentos"
                },
                3,
                BloomLevel.ANALISAR
        ));
        List<Question> parte21 = new ArrayList<>();
        parte21.add(new Question(
                "6- Eventos climáticos extremos afetam:",
                new String[]{
                        "A) Somente pessoas ricas",
                        "B) Apenas animais",
                        "C) Populações vulneráveis com mais intensidade",
                        "D) Ninguém"
                },
                2,
                BloomLevel.ANALISAR
        ));
        List<Question> parte22 = new ArrayList<>();
        parte22.add(new Question(
                "7- Como decisões da COP30 influenciam países?",
                new String[]{
                        "A) Não influenciam",
                        "B) Criam metas e compromissos climáticos globais",
                        "C) Alteram o turismo",
                        "D) Afetam apenas a exportação"
                },
                1,
                BloomLevel.ANALISAR
        ));
        List<Question> parte23 = new ArrayList<>();
        parte23.add(new Question(
                "1- Metas climáticas do Brasil são suficientes?",
                new String[]{
                        "A) Não há metas",
                        "B) Sim, totalmente",
                        "C) Não importa",
                        "D) Há avanços, mas ainda insuficientes"
                },
                3,
                BloomLevel.AVALIAR
        ));
        List<Question> parte24 = new ArrayList<>();
        parte24.add(new Question(
                "2- Agronegócio brasileiro pode ser sustentável?",
                new String[]{
                        "A) Não pode",
                        "B) Apenas com práticas de baixo impacto",
                        "C) Apenas sem tecnologia",
                        "D) Apenas com desmatamento"
                },
                1,
                BloomLevel.AVALIAR
        ));
        List<Question> parte25 = new ArrayList<>();
        parte25.add(new Question(
                "3- Políticas de proteção da Amazônia são eficazes?",
                new String[]{
                        "A) Sempre eficazes",
                        "B) Totalmente ineficazes",
                        "C) Têm avanços, mas enfrentam falhas na fiscalização",
                        "D) Não existem"
                },
                3,
                BloomLevel.AVALIAR
        ));
        List<Question> parte26 = new ArrayList<>();
        parte26.add(new Question(
                "4- Impactos econômicos da energia limpa:",
                new String[]{
                        "A) Só prejuízos",
                        "B) Só benefícios",
                        "C) Custos iniciais altos, mas retorno positivo",
                        "D) Nenhuma diferença"
                },
                2,
                BloomLevel.AVALIAR
        ));
        List<Question> parte27 = new ArrayList<>();
        parte27.add(new Question(
                "5- Carbono zero no Brasil é viável?",
                new String[]{
                        "A) Não é possível",
                        "B) Só com desmatamento",
                        "C) Apenas com combustíveis fósseis",
                        "D) Sim, mas exige investimentos e políticas fortes"
                },
                3,
                BloomLevel.AVALIAR
        ));
        List<Question> parte28 = new ArrayList<>();
        parte28.add(new Question(
                "6- Reciclagem é solução suficiente?",
                new String[]{
                        "A) Sim",
                        "B) Não, precisa de redução e reutilização também",
                        "C) Não funciona",
                        "D) Resolve tudo"
                },
                1,
                BloomLevel.AVALIAR
        ));
        List<Question> parte29 = new ArrayList<>();
        parte29.add(new Question(
                "7- Acordo de Paris está sendo cumprido?",
                new String[]{
                        "A) Sim",
                        "B) Nenhum país cumpre",
                        "C) Parcialmente, com dificuldades",
                        "D) Não existe"
                },
                2,
                BloomLevel.AVALIAR
        ));
        List<Question> parte30 = new ArrayList<>();
        parte30.add(new Question(
                "8- COP30 pode acelerar acordos climáticos?",
                new String[]{
                        "A) Não",
                        "B) Sim, ao fortalecer compromissos entre países",
                        "C) Só se mudar de país",
                        "D) Apenas se for anual"
                },
                1,
                BloomLevel.AVALIAR
        ));
        List<Question> parte31 = new ArrayList<>();
        parte31.add(new Question(
                "1- Projeto sustentável para uma cidade:",
                new String[]{
                        "A) Aumentar lixo",
                        "B) Criar um programa de arborização urbana",
                        "C) Reduzir áreas verdes",
                        "D) Incentivar carros"
                },
                1,
                BloomLevel.CRIAR
        ));
        List<Question> parte32 = new ArrayList<>();
        parte32.add(new Question(
                "2- Campanha contra uso de plástico:",
                new String[]{
                        "A) Promover uso de sacolas retornáveis",
                        "B) Incentivar descartáveis",
                        "C) Aumentar plástico",
                        "D)  Proibir reciclagem"
                },
                0,
                BloomLevel.CRIAR
        ));
        List<Question> parte33 = new ArrayList<>();
        parte33.add(new Question(
                "3- Solução para desperdício de água:",
                new String[]{
                        "A) Aumentar banhos longos",
                        "B) Usar mangueira sempre",
                        "C) Deixar torneiras abertas",
                        "D) Instalar sistemas de reaproveitamento de água"
                },
                3,
                BloomLevel.CRIAR
        ));
        List<Question> parte34 = new ArrayList<>();
        parte34.add(new Question(
                "4- Políticas contra desmatamento:",
                new String[]{
                        "A) Reduzir fiscalização",
                        "B) Incentivar queimadas",
                        "C) Ampliar monitoramento e punições",
                        "D) Derrubar áreas protegidas"
                },
                2,
                BloomLevel.CRIAR
        ));
        List<Question> parte35 = new ArrayList<>();
        parte35.add(new Question(
                "5- Plano para empresas reduzirem carbono:",
                new String[]{
                        "A) Implementar energias renováveis",
                        "B) Usar mais petróleo",
                        "C) Reduzir reciclagem",
                        "D) Aumentar resíduos"
                },
                0,
                BloomLevel.CRIAR
        ));
        List<Question> parte36 = new ArrayList<>();
        parte36.add(new Question(
                "6- Transporte sustentável:",
                new String[]{
                        "A) Incentivar carros a diesel",
                        "B) Aumentar estradas",
                        "C) Criar ciclovias e transporte elétrico",
                        "D) Diminuir ônibus"
                },
                2,
                BloomLevel.CRIAR
        ));
        List<Question> parte37 = new ArrayList<>();
        parte37.add(new Question(
                "7- Coleta seletiva para cidade:",
                new String[]{
                        "A) Misturar tudo",
                        "B) Criar pontos de coleta por tipo de material",
                        "C) Diminuir reciclagem",
                        "D) Proibir separação"
                },
                1,
                BloomLevel.CRIAR
        ));
        List<Question> parte38 = new ArrayList<>();
        parte38.add(new Question(
                "8- Proposta para COP30:",
                new String[]{
                        "A) Reduzir metas climáticas",
                        "B) Aumentar emissões",
                        "C)  Incentivar combustíveis fósseis",
                        "D) Ampliar proteção a florestas tropicais"
                },
                3,
                BloomLevel.CRIAR
        ));
        List<Question> parte39 = new ArrayList<>();
        parte39.add(new Question(
                "9- Aumentar participação popular:",
                new String[]{
                        "A) Proibir debates ambientais",
                        "B) Criar campanhas educativas e fóruns públicos",
                        "C) Restringir acesso à informação",
                        "D) Diminuir transparência"
                },
                1,
                BloomLevel.CRIAR
        ));





        perguntasMapa.put(1, parte1);
        perguntasMapa.put(2, parte2);
        perguntasMapa.put(3,parte3);
        perguntasMapa.put(4,parte4);
        perguntasMapa.put(5,parte5);
        perguntasMapa.put(6,parte6);
        perguntasMapa.put(7,parte7);
        perguntasMapa.put(8,parte8);
        perguntasMapa.put(9,parte9);
        perguntasMapa.put(10,parte10);
        perguntasMapa.put(11,parte11);
        perguntasMapa.put(12,parte12);
        perguntasMapa.put(13,parte13);
        perguntasMapa.put(14,parte14);
        perguntasMapa.put(15,parte15);
        perguntasMapa.put(16,parte16);
        perguntasMapa.put(17, parte17);
        perguntasMapa.put(18, parte18);
        perguntasMapa.put(19,parte19);
        perguntasMapa.put(20,parte20);
        perguntasMapa.put(21,parte21);
        perguntasMapa.put(22,parte22);
        perguntasMapa.put(23,parte23);
        perguntasMapa.put(24,parte24);
        perguntasMapa.put(25,parte25);
        perguntasMapa.put(26,parte26);
        perguntasMapa.put(27,parte27);
        perguntasMapa.put(28,parte28);
        perguntasMapa.put(29,parte29);
        perguntasMapa.put(30,parte30);
        perguntasMapa.put(31,parte31);
        perguntasMapa.put(32,parte32);
        perguntasMapa.put(33,parte33);
        perguntasMapa.put(34,parte34);
        perguntasMapa.put(35,parte35);
        perguntasMapa.put(36,parte36);
        perguntasMapa.put(37,parte37);
        perguntasMapa.put(38,parte38);
        perguntasMapa.put(39,parte39);

    }

    public Question getPerguntaDaParte(int parte) {
        List<Question> lista = perguntasMapa.get(parte);

        if (lista == null || lista.isEmpty()) {
            throw new EmptyQuestionListException("Não há perguntas na parte " + parte);
        }

        return lista.get(0);
    }
}

