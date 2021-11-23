import java.awt.font.GraphicAttribute;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    private static long tempo = 1l;
    private static int pontuacao = 0;
    public static String nome = "";


    private static ArrayList<String> erradas = new ArrayList<>(Arrays.asList(
            "Uhmmm, que pena, essa resposta não era a correta, mas vamos seguir mesmo assim.",
            "Olha... Esta resposta não é a correta, mas não tem problemas, você pode tentar acerta-la em outra vida! MUAHAHAHAHA",
            "Parece que você errou e sua vida acaba aqui MUAHAHAHAHA... Brincadeirinha, vamos seguir.",
            "Está..... Incorreta, perdeu tudo o drama do aluno que se ferrou!!! Mentira, vamos seguir os estudos!",
            "ERRRROOUUUU",
            "Errou feio, erro feio, errou rude"
    ));

    private static ArrayList<String> menuList = new ArrayList<>(Arrays.asList(
            "Jogar",
            "Instruções",
            "Créditos",
            "Sair"));

    // Reset
    private static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    private static final String GREEN = "\033[0;32m";   // GREEN
    private static final String YELLOW = "\033[0;33m";  // YELLOW
    private static final String BLUE = "\033[0;34m";    // BLUE
    private static final String PURPLE = "\033[0;35m";  // PURPLE
    private static final String WHITE = "\033[0;37m";   // WHITE

    private static ArrayList<String> poderes = new ArrayList<>();

    private static String desafio1 = "Você assiste as aulas como o Jefferson sugeriu?";
    private static String desafio2 = "Você lê o livro que Jefferson sugeriu?";
    private static String desafio3 = "Você pede ajuda a Jefferson?";

    // Perguntas

    private static String p1 = "PERGUNTA 1? \n";
    private static String p2 = "PERGUNTA 2? \n";

    private static String p3 = "Escolha a alternativa correta que descreve o conceito de IF e IF ELSE? \n"
            + "I)   A estrutura IF executa um comando sempre que a condição seja falsa\n"
            + "II)  A estrutura IF executa um comando quando a condicional seja verdadeira correta\n"
            + "III) Podemos afirmar que o IF ELSE executa o comando e depois faz a verificação\n"
            + "IV)  A estrutura IF ELSE executa um conjunto de comandos caso a condição IF seja falsa\n"
            + "V)   Podemos afirmar que IF ELSE é utilizado para o teste de múltiplos caso seria IF ELSE aninhado correta\n";

    private static String p4 = ("" +
            "O código abaixo mostra a verificação de um processo seletivo de um aluno\n" +
            "Identifique os erros que está impedindo o programa executar corretamente.\n\n" +
            PURPLE + "elseif " + RESET + "(" + GREEN + "nota " + PURPLE + "== " + BLUE + "10" + RESET + ") {\n"
            + "		" + GREEN + "System" + RESET + "." + GREEN + "out" + RESET + "." + GREEN + "println" + RESET + "(" + GREEN + "nome " + PURPLE + "+ " + YELLOW + "\" Parabéns você ganhou uma bolsa de estudos\"" + RESET + ");\n"
            + "} " + PURPLE + "else if " + RESET + "(" + GREEN + "nota " + PURPLE + "> " + BLUE + "7" + PURPLE + " && " + GREEN + "nota " + PURPLE + "< " + BLUE + "10" + RESET + ") {\n"
            + "		" + GREEN + "System" + RESET + "." + GREEN + "out" + RESET + "." + GREEN + "println" + RESET + "(" + GREEN + "nome + " + YELLOW + "\"você ganhou 20% de desconto na mensalidade\"" + RESET + ");\n"
            + "} " + PURPLE + "else if " + RESET + "(" + GREEN + "nota " + PURPLE + ">=" + BLUE + "05" + PURPLE + " && " + GREEN + "nota " + PURPLE + "< " + BLUE + "7" + RESET + ") {\n"
            + "		" + GREEN + "System" + RESET + "." + GREEN + "out" + RESET + "." + GREEN + "println" + RESET + "(" + GREEN + "nome + " + YELLOW + "\"você ganhou desconto de 10% na mensalidade\"" + RESET + ");\n"
            + "} " + PURPLE + "else if " + RESET + "(" + GREEN + "nota " + PURPLE + "<=" + BLUE + "5" + PURPLE + " || " + GREEN + "nota " + PURPLE + "== " + BLUE + "0" + RESET + ") {\n"
            + "		" + GREEN + "System" + RESET + "." + GREEN + "out" + RESET + "." + GREEN + "println" + RESET + "(" + GREEN + "nome + " + YELLOW + "\"Infelizmente você não Passou no processo seletivo\"" + RESET + ");\n"
            + "}\n");

    private static String p5 = "Escolha a opção que descreve como o break funciona quando é utilizado dentro de um laço de repetição aninhado.";

    private static String p6 = "O laço de repetição abaixo está formando uma metade de uma pirâmide, sendo criada por linhas e colunas. Porém o código não está rodando, o porquê o laço de repetição for não está rodando?\n"
            + PURPLE + "for " + RESET + "(int" + GREEN + " linha " + PURPLE + "= " + BLUE + "0" + RESET + "; " + GREEN + "linha" + PURPLE + " < " + BLUE + "10" + RESET + "; " + GREEN + "linha " + PURPLE + "+" + GREEN + " linha" + RESET + "){\n" +
            PURPLE + "    for " + RESET + "(int" + GREEN + " coluna " + PURPLE + "= " + BLUE + "0" + RESET + "; " + GREEN + "coluna" + PURPLE + " <= " + BLUE + "10" + RESET + "; " + GREEN + "coluna" + PURPLE + "++" + RESET + "){\n" +
            "		" + PURPLE + "if " + RESET + "(" + GREEN + "coluna " + PURPLE + "> " + GREEN + "linha" + RESET + ")\n" +
            "			" + PURPLE + "break" + RESET + ";\n" +
            "		" + GREEN + "System" + RESET + "." + GREEN + "out" + RESET + "." + GREEN + "print" + RESET + "(" + YELLOW + "\"*\"" + RESET + ");\n" +
            "	}\n" +
            "" + GREEN + "System" + RESET + "." + GREEN + "out" + RESET + "." + GREEN + "print" + RESET + "();\n" +
            "}";

    private static String p7 = "Utilizamos o Switch Case quando nosso codigo tem muitos(as)? \n";

    private static String p8 = PURPLE + "import " + GREEN + "java.util.Scanner;\r\n"
            + "\r\n"
            + PURPLE + "public class " + GREEN + "jogo {\r\n"
            + "\r\n"
            + PURPLE + "	public static" + " void" + GREEN + " main" + "(String[]" + GREEN + " args" + ") {\r\n"
            + "    int " + GREEN + "opcoes" + PURPLE + " =" + BLUE + " 0" + ";\r\n"
            + "\r\n"
            + GREEN + "		System.out.println" + WHITE + "(\r\n"
            + "				" + YELLOW + "Você deverá fazer uma apresentação para o final do semestre, onde enfretará o impiedoso OEKAT\\n\"\r\n"
            + "						+ \"E terá que escolher uma das opções para se sair bem na apresentação, porém, toda escolha terá uma consequencia\\n\"\r\n"
            + "						+ \"1- Você faz um codigo bem estruturado\\n\"\r\n"
            + "						+ \"2- A história do seu jogo é a melhor e mais criativa\\n\"\r\n"
            + "						+ \"3- Você e seu grupo fizeram varias reuniões e o trabalho está de acordo com o que foi pedido \"\r\n"
            + "						+ \"4- Os testes de código do seu grupo deram todos certos\"\r\n"
            + "						+ \"5- Você sabe tudo sobre o código e caso alguém caia durante a apresentação, você saberá explicar\"" + WHITE + ");\r\n"
            + "\r\n"
            + PURPLE + "		switch" + WHITE + " (" + GREEN + "opcoes" + WHITE + ") {\r\n"
            + PURPLE + "		case " + BLUE + "1" + ":\r\n"
            + GREEN + "			System.out.println" + WHITE + "(" + YELLOW + "\"Mas não faz os testes\"" + PURPLE + "+" + "Assim o impiedoso OEKAT tira 5 pontos do seu grupo\"" + ");\r\n"
            + PURPLE + "			break" + WHITE + ";\r\n"
            + "\r\n"
            + PURPLE + "		case" + BLUE + " 2:\r\n"
            + GREEN + "			System.out.println" + WHITE + "(" + YELLOW + "\"Mas no meio da apresentação seu código da uma crashada sem querer\"\r\n"
            + "					+ \"Você até consegue disfarçar, mas o impiedoso OEKAT tira 2 pontos do seu grupo\"" + WHITE + ");\r\n"
            + PURPLE + "			break" + WHITE + ";\r\n"
            + "\r\n"
            + PURPLE + "		case" + BLUE + " 3:\r\n"
            + GREEN + "			System.out.println" + WHITE + "(" + YELLOW + "\"Mas no dia da apresentação 3 membros do seu grupo ficam presos no transito\"\r\n"
            + "					+ \"pois está tendo um protesto de crianças que não ganharam um playstation quando ligaram no bom dia e cia\\n\"\r\n"
            + "					+ \"Seu grupo atrasa um pouco a aula e o impiedoso OEKAT tira 1 ponto do seu grupo\"" + WHITE + ");\r\n"
            + PURPLE + "			break;\r\n"
            + "\r\n"
            + PURPLE + "		case" + BLUE + "4:\r\n"
            + GREEN + "			System.out.println" + WHITE + "(" + YELLOW + "\"Mas no dia da apresentação você cai e como a nota é individual\"\r\n"
            + "					+ \"O impiedoso OEKAT desconta 3 pontos seu, em compensação, seu grupo se deu bem \"" + WHITE + ");\r\n"
            + PURPLE + "			break;\r\n" + WHITE
            + "		}\r\n"
            + "	}\r\n"
            + "}\r\n\n"
            + "De acordo com o código acima, podemos afirmar que : \n" +
            "I) Tem case a mais \n" +
            "II) O código está sem a entrada de dados \n" +
            "III) A variável está errada \n" +
            "IV) Tem case a menos \n";

    private static String p9 = "No que tange funções podemos descrevê-las como";

    private static String p10 = "Qual o erro do código abaixo?\n" + PURPLE + " static void " + GREEN + "soma" + YELLOW + "(" + PURPLE + "int" + RESET + " a, " + PURPLE + "int" + RESET + " b" + YELLOW + ")" + WHITE + "{\n" +
            "   " + PURPLE + "return " + WHITE + "a+b;\n" +
            "}" + RESET;

    // Respostas

    private static ArrayList<String> r1 = new ArrayList<>(Arrays.asList(
            "",
            "",
            "",
            "",
            ""));

    private static ArrayList<String> r2 = new ArrayList<>(Arrays.asList(
            "",
            "",
            "",
            "",
            ""));

    private static ArrayList<String> r3 = new ArrayList<>(Arrays.asList("(I e II e VI) Estão corretas",
            "(I e II e III) Estão corretas",
            "(II e V) Estão corretas (CERTA RESPOSTA)",
            "(IV e II) Estão corretas",
            "(I e IV e V) Estão corretas",
            "(I) Está correta"));

    private static ArrayList<String> r4 = new ArrayList<>(
            Arrays.asList("A estrutura IF não serve para verificar condicional.",
                    "A estrutura é iniciada primeiro com IF e a condição é entre (). (CERTA RESPOSTA)",
                    "Tem que declarar uma variável dentro da condição para poder executar o código.",
                    "A estrutura não pode ter um IF dentro de outro IF.",
                    "A estrutura sempre terá um IF dentro de outro IF."));

    private static ArrayList<String> r5 = new ArrayList<>(Arrays.asList(
            "Finaliza a execução do programa no momento em que é chamado.",
            "Para a execução de todos os laços de repetição aninhados que o contém e continua normalmente o programa.",
            "Para a execução do laço que contém o comando break e continua executando os laços mais externos.(CERTA RESPOSTA)",
            "Ele para todos os laços de repetição que tem dentro do programa."));

    private static ArrayList<String> r6 = new ArrayList<>(Arrays.asList(
            "A estrutura FOR não se deve ter outro FOR dentro.",
            "O código não está rodando, pois o break deve ser fora do laço de repetição FOR.",
            "A estrutura não executa, pois a expressão linha + linha está incorreta, para seu código executa se deve considerar: linha++ ou linha = linha + 1.(CERTA RESPOSTA)",
            "O código não vai rodar, pois o IF dentro do for está sem o ELSE.",
            "Nenhuma das alternativas, o código está certo."));

    private static ArrayList<String> r7 = new ArrayList<>(Arrays.asList(
            "Variáveis", "Bibliotecas importadas", "Laços de repetição", "If else (CERTA RESPOSTA)", "Sysout.out.println"));

    private static ArrayList<String> r8 = new ArrayList<>(Arrays.asList("I e a II estão corretas",
            "I e IV estão corretas",
            "II e IV estão corretas(CERTA RESPOSTA)",
            "II, III e IV estão corretas",
            "Todas as afirmativas estão corretas"));


    private static ArrayList<String> r9 = new ArrayList<>(Arrays.asList(
            "São partes do código que possuem objetivos específicos, que podem ser chamadas em qualquer parte daquele código, e podem retornar algum valor.(CERTA RESPOSTA)",
            "São fragmentos de código que só podem ser chamados dentro de ifs",
            "São partes de um mesmo código feitos somente para não se repetir código",
            "São blocos de código como if, else, switch, for",
            "Nenhuma das outras respostas"));


    private static ArrayList<String> r10 = new ArrayList<>(Arrays.asList(
            "Os tipos não condizem com soma",
            "Soma é feita através de sum(a,b)",
            "Problema com o tipo de retorno(CERTA RESPOSTA)",
            "Falta public no início da função",
            "Não tem problemas"));

    private static ArrayList<String> ajudas = new ArrayList<>(Arrays.asList(
            "Lembre-se o IF é uma estrutura para tomadas de decisão (se isso, faça isso)",
            "Veja, sempre um se, depois um senão, e nos se, devem ser envolvidos por parênteses",
            "O break, é uma instrução para parar a execução atual",
            "For's são laços de repetição, e como todo laço de repetição é necessário haver um metódo de sair dele, para evitar o loop infinito",
            "R5",
            "R6",
            "R7",
            "R8",
            "Funções são estruturas que utilizamos para organizar o nosso código e realizar tarefas com mais clareza",
            "Para funções são necessários tipos de retornos condizentes com o que o código está fazendo"));


    // Historias
    private static String h1 = "Você acorda obstinado para um novo dia em seu emprego.\n" +
            "Como sempre está infeliz com o seu chefe pegando no seu pé dia sim, dia também.\nLogo que chega pela manhã no escritório encontra Renata, então ela diz:" +
            "Bom dia ____________";

    private static String h2 = "- \"Bom dia (NOME), pronto pra mais um dia do Claudio (Seu chefe), pegando no seu pé? rs\" diz Renata. \n" +
            "- \"Ficou sabendo de ontem?!? Ele simplesmente implicou comigo por que eu cheguei 5 minutos atrasado do almoço, assim não tá dando,\n vou tentar sair área ou procurar um novo emprego, fiquei sabendo que TI é uma área legal, o pessoal parace ser maluco, mas gente boa\" \n" +
            "- \"Pois é menino, esse Claudio ta passando dos limites... Enfim acho que se quer isso, deveria tentar mesmo, eu conheço um rapaz da área de TI, vou te passar o contato dele, para vocês trocarem figurinhas.\"";

    private static String h3 = "Nessa mesma tarde Renata adiciona você e Jefferson em um grupo para se conversarem\n" +
            "-\"Opa Jefferson, esse daí é o (NOME), é o rapaz que eu te falei que está tentando entrar na sua área, e ainda não conhece muita coisa, você poderia dar o caminho das pedras pra ele?\"\n" +
            "-\"Claro que sim Renatinha, o que que você não me pede chorando que eu não faça rindo?!?\"\n" +
            "-\"Fala (NOME), tudo certo? Cara vou te passar algumas coisas pra tu ir estudando e ver se gosta da área e tal, você já viu as videoaulas do Takeo na internet? São bem boas ele passa um conteúdo legal pra quem está começando\"\n";

    private static String h4 = "Se passa uma semana, desde a sua conversa com Jefferson\n" +
            "-\"Fala (NOME), como que tu tá?\" pergunta, Jefferson\n" +
            "-\"Ahh tamo aí né meu...\" você responde \n" +
            "-\"Assim que é bom, animado igual um leão faminto na savana africana, ahahahah, enfim, depois de uma semana,\n" +
            " acho que deu tempo de tu estudar algumas coisas, vamos a nossa primeira pergunta, para eu poder saber se você aprendeu algo nesse tempo ou ainda nada.\"\n";

    private static String h51 = "-\"Eita, então você é o bixão mesmo ein. Parece que estudou pelo menos um pouco, vamos ver se você aprendeu mesmo sobre esse tema\n";

    private static String h52 = "-\"É... Como deve ter percebido até o narrador está tirando uma com a sua cara, e você vai fazer o que com isso? \n" +
            "Euuuuu particularmente não deixava...\" - diz Jefferson \n" +
            "\"E eu digo mais... Mais\" - diz o narrador" +
            "\"Bom deixando a zueira de lado, vamos continuar aqui com os nossos desafios\" - dispara Jefferson";

    private static String h61 = "-\"Você estou bem então... Vamos vou te passar uma recomendação de livro pra tu dar uma olhada,\n mas mesmo assim eu te aconselho a se inscrever em um curso para poder se aprimorar nisso.\n";

    private static String h62 = "-\"Pois é, o narrador, parece estar te zuando mesmo. Enfim, parece que você até estudou," +
            "\n mas não o tanto que deveria, vou te recomendar estudar mais, e tambem dar uma olhada em algumas referencias de livros por aí \"\n";

    private static String h7 = "Na mesma noite, você corre para o computador assim que chega em casa, para dar um olhada nos cursos que existem dentro da área,\n você percebe que gestão em TI, não é muito a sua cara, nem Bacharel em ciências da computação.\n" +
            "Já tecnólogo em analise e desenvolvimento de sistemas, se encaixa perfeitmente no que você esperava, como é maio, você já corre para fazer a sua inscrição, e passa no vestibular.\n" +
            "Logo nas primeiras semanas, você se enturma, e essas pessoas serão o seu grupo de PI";

    private static String h8 = "Uma das suas primeiras tarefas vem a seguir, é uma ADO de PI.";

    private static String h91 = "Na mesma semana, você encontra Jefferson, nos corredores da empresa, e comenta que está fazendo faculdade.\n" +
            "-\"Eai (NOME), está curtindo?\"\n" +
            "-\"Estou sim, o pessoal é bem legal\".";

    private static String h92 = "Na mesma semana, você encontra Jefferson, nos corredores da empresa, vocês se cumprimentam e seguem a vida";

    private static String h10 = "-\"Parece que daqui pra frente os exercicios serão mais intensos, então é melhor se preparar\" - diz Enzo, seu colega de PI\n" +
            "Já para o outro dia já temos mais exercicios para serem feitos.";

    private static String h11 = "Vamos para outro exercício logo em seguida";

    private static String h12 = "Você volta pra casa para descansar durante o fim de semana,\n" +
            "no domingo você saí para ir pra casa da sua tia Suelita, lá encontra o seu primo Pedro, e comenta com ele que está fazendo faculdade, \n" +
            "Pedro é desenvolvedor de jogos, e te ajuda a fazer a próxima atividade.";

    private static String h131 = "- \"É isso mesmo (NOME), parabéns, você está aprendendo certinho\" - diz Pedro\n" +
            "- \"Esse é meu menino\", grita a sua mãe da sala";

    private static String h14 = "Já na próxima aula.\n" +
            "- \"Temos que seguir adiante nos aprendizados\" - diz Fabiano, professor de lógica de programação\n" +
            "- \"Então hoje vamos falar sobre switch, a primeira pergunta é...\" - completa Fabiano";

    private static String h151 = "- \"Isto mesmo, o (NOME), como vocês podem ver, já sabe sobre switch, vamos ver então se você aprendeu direitinho\" - diz Fabiano para toda a sala\n";

    private static String h152 = "- \"Uhmmm, não é bem assim, mas vamos ver se você acerta essa...\" - diz Fabiano para toda a sala\n";

    private static String h16 = "Está chegando o fim do semestre, e pra isso é necessário dar um gás a mais nos estudo, então nos responda...";

    private static String h171 = "Então já que é o sabichão e sabia essa me responda...";


    //Função do jogo
    private static void jogar() {
        try {
            historia(1);
            setNomeJogador();
            historia(2);
            historia(3);


            if (desafiosBooleanos(desafio1)) {
                poderes.add("Perguntar pro Takeo");
                System.out.println("Você liberou o poder de perguntar para o Takeo, isto poderá ser util em momentos de dificuldades");
            }

            historia(4);
            if (pergunta(1)) {
                historia(51);
            } else {
                historia(52);
            }

            if (pergunta(2)) {
                historia(61);
            } else {
                historia(62);
            }
            historia(7);
            if (desafiosBooleanos(desafio2)) {
                poderes.add("Consultar o livro");
                System.out.println("Você liberou o poder de consultar o livro, pode ser que isso seja útil em algum momento");
            }
            historia(8);
            if (pergunta(3)) {
                historia(91);
                if (desafiosBooleanos(desafio3)) {
                    poderes.add("Pedir ajuda a Jefferson");
                    System.out.println("Você liberou o poder de perguntar ao Jefferson, pode ser que ele te ajude em uma dificuldade");
                }
            } else {
                historia(92);
            }
            historia(10);
            pergunta(4);
            historia(11);
            pergunta(5);
            historia(12);
            if (pergunta(6)) {
                historia(131);
            }
            historia(14);
            if (pergunta(7)) {
                historia(151);
            } else {
                historia(152);
            }
            pergunta(8);
            historia(16);
            if (pergunta(9)) {
                historia(171);
            }
            pergunta(10);
            exibePontuacao();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Exibe a pontuação que o jogador conseguiu dentro do jogo.
    //Este retorno só serve para fazer teste
    public static int exibePontuacao() {
        if (pontuacao == 0) {
            System.out.println("Você foi demitido do seu emprego, devido a um corte de gasto");
        } else if (pontuacao >= 1 && pontuacao <= 4) {
            System.out.println("PARABÉNSSSSSS\n" +
                    "Devido ao seu esforço de estudos você recebeu uma proposta de emprego na empresa concorrente, com o cargo de desenvolvedor júnior");
        } else if (pontuacao >= 4 && pontuacao <= 6) {
            System.out.println("PARABÉNSSSSSS\n" +
                    "Devido ao seu esforço de estudos você recebeu uma proposta de emprego na empresa concorrente, com o cargo de desenvolvedor pleno");
        } else if (pontuacao >= 7 && pontuacao <= 9) {
            System.out.println("PARABÉNSSSSSS\n" +
                    "Devido ao seu esforço de estudos você recebeu uma proposta de emprego na empresa em que trabalha, com o cargo de desenvolvedor sênior");
        } else if (pontuacao == 10) {
            System.out.println("PARABÉNSSSSSS\n" +
                    "Devido ao seu esforço de estudos você recebeu uma proposta de emprego na empresa concorrente, com o cargo de especialista técnico");
        }
        return pontuacao;
    }

    public static void main(String[] args) throws InterruptedException {
        menu();

    }

    public static void menu() {

        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println(i + 1 + ") " + menuList.get(i));
        }
        System.out.print("Selecione para qual opção deseja seguir: ");
        int resp = scan.nextInt();

        switch (resp) {
            case 1:
                jogar();
                break;
            case 2:
                instrucoes();
                break;
            case 3:
                creditos();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Você selecionou uma opção invalida, tente novamente");
                menu();
                break;
        }
    }

    //Imprime créditos
    private static void creditos() {
        System.out.println("Este jogo foi desenvolvido com esméro por:\n" +
                "Paulo Belfi\n\n");
        menu();
    }

    //Imprime as instruções do jogo
    private static void instrucoes() {
        System.out.println("O jogo se baseia no genero RPG de texto, será necessario colocar em uso o seu conhecimento de programação\npara responder as mais diversas perguntas sobre desenvolvimento, então" +
                " se prepare aventureiro, vamos entrar de cabeça nesse mundo.\n\n");
        menu();
    }

    // id = id da historia
    public static void historia(int id) throws InterruptedException {
        switch (id) {
            case 1:
                imprimir(geraHistoria(h1), tempo);
                break;
            case 2:
                imprimir(geraHistoria(h2), tempo);
                break;
            case 3:
                imprimir(geraHistoria(h3), tempo);
                break;
            case 4:
                imprimir(geraHistoria(h4), tempo);
                break;
            case 51:
                imprimir(geraHistoria(h51), tempo);
                break;
            case 52:
                imprimir(geraHistoria(h52), tempo);
                break;
            case 61:
                imprimir(geraHistoria(h61), tempo);
                break;
            case 62:
                imprimir(geraHistoria(h62), tempo);
                break;
            case 7:
                imprimir(geraHistoria(h7), tempo);
                break;
            case 8:
                imprimir(geraHistoria(h8), tempo);
                break;
            case 91:
                imprimir(geraHistoria(h91), tempo);
                break;
            case 92:
                imprimir(geraHistoria(h92), tempo);
                break;
            case 10:
                imprimir(geraHistoria(h10), tempo);
                break;
            case 11:
                imprimir(geraHistoria(h11), tempo);
                break;
            case 12:
                imprimir(geraHistoria(h12), tempo);
                break;
            case 131:
                imprimir(geraHistoria(h131), tempo);
                break;
            case 14:
                imprimir(geraHistoria(h14), tempo);
                break;
            case 151:
                imprimir(geraHistoria(h151), tempo);
                break;
            case 152:
                imprimir(geraHistoria(h152), tempo);
                break;
            case 16:
                imprimir(geraHistoria(h16), tempo);
                break;
            case 171:
                imprimir(geraHistoria(h171), tempo);
                break;
        }
    }

    // id = id da pergunta
    public static boolean pergunta(int id) throws InterruptedException {
        switch (id) {

            case 1:
                imprimir(p1, tempo);
                return pontuar(imprimirQuestao(r1, id));

            case 2:
                imprimir(p2, tempo);
                return pontuar(imprimirQuestao(r2, id));

            case 3:
                imprimir(p3, tempo);
                return pontuar(imprimirQuestao(r3, id));

            case 4:
                imprimir(p4, tempo);
                return pontuar(imprimirQuestao(r4, id));
            case 5:
                imprimir(p5, tempo);
                return pontuar(imprimirQuestao(r5, id));
            case 6:
                imprimir(p6, tempo);
                return pontuar(imprimirQuestao(r6, id));

            case 7:
                imprimir(p7, tempo);
                return pontuar(imprimirQuestao(r7, id));

            case 8:
                imprimir(p8, tempo);
                return pontuar(imprimirQuestao(r8, id));

            case 9:
                imprimir(p9, tempo);
                return pontuar(imprimirQuestao(r9, id));
            case 10:
                imprimir(p10, tempo);
                return pontuar(imprimirQuestao(r10, id));
            default:
                return false;
        }
    }

    public static boolean pontuar(boolean acertou) throws InterruptedException {
        if (acertou) {
            pontuacao++;
        } else {
            imprimirRespostaErrada(erradas, tempo);
        }
        return acertou;
    }

    //Recebe o texto a ser impresso e em qual velocidade devem ser digitadas as letras
    //retorno somente para teste
    public static boolean imprimir(String texto, long tempo) throws InterruptedException {
        //converte texto para vetor de caracteres, e faz um for pelo texto, imprimindo letra por letra
        //e esperando um intevalo em milisegundos entre cada letra
        for (Character per : texto.toCharArray()) {
            System.out.print(per);
            //tempo em millisegundos
            TimeUnit.MILLISECONDS.sleep(tempo);
        }
        System.out.println();
        return true;
    }

    //recebe uma array de possibilidades
    public static boolean imprimirRespostaErrada(ArrayList<String> possiblidades, long tempo) throws InterruptedException {
        Random rand = new Random();
        //pega uma resposta aleatoria da array de respostas possiveis, e imprime ela
        //utilizando metodo de impressão digitada
        String texto = possiblidades.get(rand.nextInt(possiblidades.size()));

        imprimir(texto,tempo);
        System.out.println();
        return true;
    }

    //Recebe o array de perguntas a serem impressas sem as suas letras correspondentes
    public static boolean imprimirQuestao(ArrayList<String> respostas, int id) {
        Scanner scan = new Scanner(System.in);
        //embaralha as perguntas para não ser sempre a mesma opção
        Collections.shuffle(respostas);

        String respostaCerta = "";
        ArrayList<String> listaRespostas = new ArrayList<>();


        //laço para imprir as respostas
        for (int i = 0; i < respostas.size(); i++) {
            //Verifica qual é a resposta correta após o embaralhamento
            if (respostas.get(i).indexOf("(CERTA RESPOSTA)") != -1) {
                respostaCerta = Character.toString((char) i + 97);
            }

            //Adicionando a lista de respostas a letra correspondente, tanto maiusculo como minisculo.
            listaRespostas.add(Character.toString((char) i + 97));
            listaRespostas.add(Character.toString((char) i + 97).toUpperCase(Locale.ROOT));

            //imprime a pergunta removendo o marcador de certa resposta
            System.out.println(
                    Character.toString((char) i + 97) + ") " + respostas.get(i).replaceAll("\\(CERTA RESPOSTA\\)", ""));
        }
        //le a resposta do jogador
        System.out.print("Digite qual a resposta correta, ou (P) para usar seus poderes: ");
        String resp = scan.next();

        //controle de ajudas
        if (resp.toUpperCase(Locale.ROOT).equals("P")) {
            //se poderes forem iguais a 0 não deve fazer nada
            if (poderes.size() == 0) {
                System.out.println("Você não tem poderes, teremos que seguir sem utilizar ajuda.");
                return imprimirQuestao(respostas, id);
            }
            //Poderes/ajudas
            int ajudaGasta = imprimePoderes();
            //imprime poder selecionado
            System.out.println(ajudas.get(id-1));
            //remove o poder selecionado
            poderes.remove(ajudaGasta);
            return imprimirQuestao(respostas, id);
        }

        //verifica se a resposta dada é válida ao conjunto de respostas validas
        else if (listaRespostas.indexOf(resp) == -1) {
            System.out.println("Esta resposta é inválida, tente apenas respostas validas.\nTente novamente.\n\n");
            imprimirQuestao(respostas, id);
        }
        return respostaCerta.toUpperCase(Locale.ROOT).equals(resp.toUpperCase(Locale.ROOT));
    }

    //imprime os poderes possiveis do jogador
    private static int imprimePoderes() {
        Scanner scan = new Scanner(System.in);
        //faz um laço na arrai para imprimir todos os poderes possiveis
        for (int i = 0; i < poderes.size(); i++) {
            //Character.toString((char) i + 97) = tabela ascii
            System.out.println(Character.toString((char) i + 97) + ") " + poderes.get(i));
        }

        System.out.print("Selecione qual poder deseja utilizar: ");
        String resp = scan.next();
        //verifica se a resposta dada é válida, não pode ser -1 nem maior do que a quantidade de poderes -1
        if (resp.toLowerCase(Locale.ROOT).toCharArray()[0] - 97 < 0 ||
                resp.toLowerCase(Locale.ROOT).toCharArray()[0] - 97 > poderes.size()-1) {
            System.out.println("Este poder não existe, tente novamente");
            return imprimePoderes();
        }
        //retorna indice da resposta
        return resp.toLowerCase(Locale.ROOT).toCharArray()[0] - 97;
    }


    //Função para setar o nome do jogador
    public static void setNomeJogador() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o seu nome para continuarmos");
        nome = scan.next();
    }

    public static String geraHistoria(String texto) {
        return texto.replaceAll("\\(NOME\\)", nome);
    }

    public static boolean desafiosBooleanos(String pergunta) {
        System.out.println(pergunta);
        System.out.println("Responda com S (Sim) ou N (Não): ");
        Scanner scan = new Scanner(System.in);

        return scan.next().toUpperCase(Locale.ROOT).equals("S");
    }
}
