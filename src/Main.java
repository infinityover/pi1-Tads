import java.awt.font.GraphicAttribute;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    private static long tempo = 1l;
    private static int pontuacao = 0;
    public static String nome = "";


    private static ArrayList<String> erradas = new ArrayList<>(Arrays.asList(
            "Uhmmm, que pena, essa resposta n�o era a correta, mas vamos seguir mesmo assim.",
            "Olha... Esta resposta n�o � a correta, mas n�o tem problemas, voc� pode tentar acerta-la em outra vida! MUAHAHAHAHA",
            "Parece que voc� errou e sua vida acaba aqui MUAHAHAHAHA... Brincadeirinha, vamos seguir.",
            "Est�..... Incorreta, perdeu tudo o drama do aluno que se ferrou!!! Mentira, vamos seguir os estudos!",
            "ERRRROOUUUU",
            "Errou feio, erro feio, errou rude"
    ));

    private static ArrayList<String> menuList = new ArrayList<>(Arrays.asList(
            "Jogar",
            "Instru��es",
            "Cr�ditos",
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

    private static String desafio1 = "Voc� assiste as aulas como o Jefferson sugeriu?";
    private static String desafio2 = "Voc� l� o livro que Jefferson sugeriu?";
    private static String desafio3 = "Voc� pede ajuda a Jefferson?";

    // Perguntas

    private static String p1 = "PERGUNTA 1? \n";
    private static String p2 = "PERGUNTA 2? \n";

    private static String p3 = "Escolha a alternativa correta que descreve o conceito de IF e IF ELSE? \n"
            + "I)   A estrutura IF executa um comando sempre que a condi��o seja falsa\n"
            + "II)  A estrutura IF executa um comando quando a condicional seja verdadeira correta\n"
            + "III) Podemos afirmar que o IF ELSE executa o comando e depois faz a verifica��o\n"
            + "IV)  A estrutura IF ELSE executa um conjunto de comandos caso a condi��o IF seja falsa\n"
            + "V)   Podemos afirmar que IF ELSE � utilizado para o teste de m�ltiplos caso seria IF ELSE aninhado correta\n";

    private static String p4 = ("" +
            "O c�digo abaixo mostra a verifica��o de um processo seletivo de um aluno\n" +
            "Identifique os erros que est� impedindo o programa executar corretamente.\n\n" +
            PURPLE + "elseif " + RESET + "(" + GREEN + "nota " + PURPLE + "== " + BLUE + "10" + RESET + ") {\n"
            + "		" + GREEN + "System" + RESET + "." + GREEN + "out" + RESET + "." + GREEN + "println" + RESET + "(" + GREEN + "nome " + PURPLE + "+ " + YELLOW + "\" Parab�ns voc� ganhou uma bolsa de estudos\"" + RESET + ");\n"
            + "} " + PURPLE + "else if " + RESET + "(" + GREEN + "nota " + PURPLE + "> " + BLUE + "7" + PURPLE + " && " + GREEN + "nota " + PURPLE + "< " + BLUE + "10" + RESET + ") {\n"
            + "		" + GREEN + "System" + RESET + "." + GREEN + "out" + RESET + "." + GREEN + "println" + RESET + "(" + GREEN + "nome + " + YELLOW + "\"voc� ganhou 20% de desconto na mensalidade\"" + RESET + ");\n"
            + "} " + PURPLE + "else if " + RESET + "(" + GREEN + "nota " + PURPLE + ">=" + BLUE + "05" + PURPLE + " && " + GREEN + "nota " + PURPLE + "< " + BLUE + "7" + RESET + ") {\n"
            + "		" + GREEN + "System" + RESET + "." + GREEN + "out" + RESET + "." + GREEN + "println" + RESET + "(" + GREEN + "nome + " + YELLOW + "\"voc� ganhou desconto de 10% na mensalidade\"" + RESET + ");\n"
            + "} " + PURPLE + "else if " + RESET + "(" + GREEN + "nota " + PURPLE + "<=" + BLUE + "5" + PURPLE + " || " + GREEN + "nota " + PURPLE + "== " + BLUE + "0" + RESET + ") {\n"
            + "		" + GREEN + "System" + RESET + "." + GREEN + "out" + RESET + "." + GREEN + "println" + RESET + "(" + GREEN + "nome + " + YELLOW + "\"Infelizmente voc� n�o Passou no processo seletivo\"" + RESET + ");\n"
            + "}\n");

    private static String p5 = "Escolha a op��o que descreve como o break funciona quando � utilizado dentro de um la�o de repeti��o aninhado.";

    private static String p6 = "O la�o de repeti��o abaixo est� formando uma metade de uma pir�mide, sendo criada por linhas e colunas. Por�m o c�digo n�o est� rodando, o porqu� o la�o de repeti��o for n�o est� rodando?\n"
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
            + "				" + YELLOW + "Voc� dever� fazer uma apresenta��o para o final do semestre, onde enfretar� o impiedoso OEKAT\\n\"\r\n"
            + "						+ \"E ter� que escolher uma das op��es para se sair bem na apresenta��o, por�m, toda escolha ter� uma consequencia\\n\"\r\n"
            + "						+ \"1- Voc� faz um codigo bem estruturado\\n\"\r\n"
            + "						+ \"2- A hist�ria do seu jogo � a melhor e mais criativa\\n\"\r\n"
            + "						+ \"3- Voc� e seu grupo fizeram varias reuni�es e o trabalho est� de acordo com o que foi pedido \"\r\n"
            + "						+ \"4- Os testes de c�digo do seu grupo deram todos certos\"\r\n"
            + "						+ \"5- Voc� sabe tudo sobre o c�digo e caso algu�m caia durante a apresenta��o, voc� saber� explicar\"" + WHITE + ");\r\n"
            + "\r\n"
            + PURPLE + "		switch" + WHITE + " (" + GREEN + "opcoes" + WHITE + ") {\r\n"
            + PURPLE + "		case " + BLUE + "1" + ":\r\n"
            + GREEN + "			System.out.println" + WHITE + "(" + YELLOW + "\"Mas n�o faz os testes\"" + PURPLE + "+" + "Assim o impiedoso OEKAT tira 5 pontos do seu grupo\"" + ");\r\n"
            + PURPLE + "			break" + WHITE + ";\r\n"
            + "\r\n"
            + PURPLE + "		case" + BLUE + " 2:\r\n"
            + GREEN + "			System.out.println" + WHITE + "(" + YELLOW + "\"Mas no meio da apresenta��o seu c�digo da uma crashada sem querer\"\r\n"
            + "					+ \"Voc� at� consegue disfar�ar, mas o impiedoso OEKAT tira 2 pontos do seu grupo\"" + WHITE + ");\r\n"
            + PURPLE + "			break" + WHITE + ";\r\n"
            + "\r\n"
            + PURPLE + "		case" + BLUE + " 3:\r\n"
            + GREEN + "			System.out.println" + WHITE + "(" + YELLOW + "\"Mas no dia da apresenta��o 3 membros do seu grupo ficam presos no transito\"\r\n"
            + "					+ \"pois est� tendo um protesto de crian�as que n�o ganharam um playstation quando ligaram no bom dia e cia\\n\"\r\n"
            + "					+ \"Seu grupo atrasa um pouco a aula e o impiedoso OEKAT tira 1 ponto do seu grupo\"" + WHITE + ");\r\n"
            + PURPLE + "			break;\r\n"
            + "\r\n"
            + PURPLE + "		case" + BLUE + "4:\r\n"
            + GREEN + "			System.out.println" + WHITE + "(" + YELLOW + "\"Mas no dia da apresenta��o voc� cai e como a nota � individual\"\r\n"
            + "					+ \"O impiedoso OEKAT desconta 3 pontos seu, em compensa��o, seu grupo se deu bem \"" + WHITE + ");\r\n"
            + PURPLE + "			break;\r\n" + WHITE
            + "		}\r\n"
            + "	}\r\n"
            + "}\r\n\n"
            + "De acordo com o c�digo acima, podemos afirmar que : \n" +
            "I) Tem case a mais \n" +
            "II) O c�digo est� sem a entrada de dados \n" +
            "III) A vari�vel est� errada \n" +
            "IV) Tem case a menos \n";

    private static String p9 = "No que tange fun��es podemos descrev�-las como";

    private static String p10 = "Qual o erro do c�digo abaixo?\n" + PURPLE + " static void " + GREEN + "soma" + YELLOW + "(" + PURPLE + "int" + RESET + " a, " + PURPLE + "int" + RESET + " b" + YELLOW + ")" + WHITE + "{\n" +
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

    private static ArrayList<String> r3 = new ArrayList<>(Arrays.asList("(I e II e VI) Est�o corretas",
            "(I e II e III) Est�o corretas",
            "(II e V) Est�o corretas (CERTA RESPOSTA)",
            "(IV e II) Est�o corretas",
            "(I e IV e V) Est�o corretas",
            "(I) Est� correta"));

    private static ArrayList<String> r4 = new ArrayList<>(
            Arrays.asList("A estrutura IF n�o serve para verificar condicional.",
                    "A estrutura � iniciada primeiro com IF e a condi��o � entre (). (CERTA RESPOSTA)",
                    "Tem que declarar uma vari�vel dentro da condi��o para poder executar o c�digo.",
                    "A estrutura n�o pode ter um IF dentro de outro IF.",
                    "A estrutura sempre ter� um IF dentro de outro IF."));

    private static ArrayList<String> r5 = new ArrayList<>(Arrays.asList(
            "Finaliza a execu��o do programa no momento em que � chamado.",
            "Para a execu��o de todos os la�os de repeti��o aninhados que o cont�m e continua normalmente o programa.",
            "Para a execu��o do la�o que cont�m o comando break e continua executando os la�os mais externos.(CERTA RESPOSTA)",
            "Ele para todos os la�os de repeti��o que tem dentro do programa."));

    private static ArrayList<String> r6 = new ArrayList<>(Arrays.asList(
            "A estrutura FOR n�o se deve ter outro FOR dentro.",
            "O c�digo n�o est� rodando, pois o break deve ser fora do la�o de repeti��o FOR.",
            "A estrutura n�o executa, pois a express�o linha + linha est� incorreta, para seu c�digo executa se deve considerar: linha++ ou linha = linha + 1.(CERTA RESPOSTA)",
            "O c�digo n�o vai rodar, pois o IF dentro do for est� sem o ELSE.",
            "Nenhuma das alternativas, o c�digo est� certo."));

    private static ArrayList<String> r7 = new ArrayList<>(Arrays.asList(
            "Vari�veis", "Bibliotecas importadas", "La�os de repeti��o", "If else (CERTA RESPOSTA)", "Sysout.out.println"));

    private static ArrayList<String> r8 = new ArrayList<>(Arrays.asList("I e a II est�o corretas",
            "I e IV est�o corretas",
            "II e IV est�o corretas(CERTA RESPOSTA)",
            "II, III e IV est�o corretas",
            "Todas as afirmativas est�o corretas"));


    private static ArrayList<String> r9 = new ArrayList<>(Arrays.asList(
            "S�o partes do c�digo que possuem objetivos espec�ficos, que podem ser chamadas em qualquer parte daquele c�digo, e podem retornar algum valor.(CERTA RESPOSTA)",
            "S�o fragmentos de c�digo que s� podem ser chamados dentro de ifs",
            "S�o partes de um mesmo c�digo feitos somente para n�o se repetir c�digo",
            "S�o blocos de c�digo como if, else, switch, for",
            "Nenhuma das outras respostas"));


    private static ArrayList<String> r10 = new ArrayList<>(Arrays.asList(
            "Os tipos n�o condizem com soma",
            "Soma � feita atrav�s de sum(a,b)",
            "Problema com o tipo de retorno(CERTA RESPOSTA)",
            "Falta public no in�cio da fun��o",
            "N�o tem problemas"));

    private static ArrayList<String> ajudas = new ArrayList<>(Arrays.asList(
            "Lembre-se o IF � uma estrutura para tomadas de decis�o (se isso, fa�a isso)",
            "Veja, sempre um se, depois um sen�o, e nos se, devem ser envolvidos por par�nteses",
            "O break, � uma instru��o para parar a execu��o atual",
            "For's s�o la�os de repeti��o, e como todo la�o de repeti��o � necess�rio haver um met�do de sair dele, para evitar o loop infinito",
            "R5",
            "R6",
            "R7",
            "R8",
            "Fun��es s�o estruturas que utilizamos para organizar o nosso c�digo e realizar tarefas com mais clareza",
            "Para fun��es s�o necess�rios tipos de retornos condizentes com o que o c�digo est� fazendo"));


    // Historias
    private static String h1 = "Voc� acorda obstinado para um novo dia em seu emprego.\n" +
            "Como sempre est� infeliz com o seu chefe pegando no seu p� dia sim, dia tamb�m.\nLogo que chega pela manh� no escrit�rio encontra Renata, ent�o ela diz:" +
            "Bom dia ____________";

    private static String h2 = "- \"Bom dia (NOME), pronto pra mais um dia do Claudio (Seu chefe), pegando no seu p�? rs\" diz Renata. \n" +
            "- \"Ficou sabendo de ontem?!? Ele simplesmente implicou comigo por que eu cheguei 5 minutos atrasado do almo�o, assim n�o t� dando,\n vou tentar sair �rea ou procurar um novo emprego, fiquei sabendo que TI � uma �rea legal, o pessoal parace ser maluco, mas gente boa\" \n" +
            "- \"Pois � menino, esse Claudio ta passando dos limites... Enfim acho que se quer isso, deveria tentar mesmo, eu conhe�o um rapaz da �rea de TI, vou te passar o contato dele, para voc�s trocarem figurinhas.\"";

    private static String h3 = "Nessa mesma tarde Renata adiciona voc� e Jefferson em um grupo para se conversarem\n" +
            "-\"Opa Jefferson, esse da� � o (NOME), � o rapaz que eu te falei que est� tentando entrar na sua �rea, e ainda n�o conhece muita coisa, voc� poderia dar o caminho das pedras pra ele?\"\n" +
            "-\"Claro que sim Renatinha, o que que voc� n�o me pede chorando que eu n�o fa�a rindo?!?\"\n" +
            "-\"Fala (NOME), tudo certo? Cara vou te passar algumas coisas pra tu ir estudando e ver se gosta da �rea e tal, voc� j� viu as videoaulas do Takeo na internet? S�o bem boas ele passa um conte�do legal pra quem est� come�ando\"\n";

    private static String h4 = "Se passa uma semana, desde a sua conversa com Jefferson\n" +
            "-\"Fala (NOME), como que tu t�?\" pergunta, Jefferson\n" +
            "-\"Ahh tamo a� n� meu...\" voc� responde \n" +
            "-\"Assim que � bom, animado igual um le�o faminto na savana africana, ahahahah, enfim, depois de uma semana,\n" +
            " acho que deu tempo de tu estudar algumas coisas, vamos a nossa primeira pergunta, para eu poder saber se voc� aprendeu algo nesse tempo ou ainda nada.\"\n";

    private static String h51 = "-\"Eita, ent�o voc� � o bix�o mesmo ein. Parece que estudou pelo menos um pouco, vamos ver se voc� aprendeu mesmo sobre esse tema\n";

    private static String h52 = "-\"�... Como deve ter percebido at� o narrador est� tirando uma com a sua cara, e voc� vai fazer o que com isso? \n" +
            "Euuuuu particularmente n�o deixava...\" - diz Jefferson \n" +
            "\"E eu digo mais... Mais\" - diz o narrador" +
            "\"Bom deixando a zueira de lado, vamos continuar aqui com os nossos desafios\" - dispara Jefferson";

    private static String h61 = "-\"Voc� estou bem ent�o... Vamos vou te passar uma recomenda��o de livro pra tu dar uma olhada,\n mas mesmo assim eu te aconselho a se inscrever em um curso para poder se aprimorar nisso.\n";

    private static String h62 = "-\"Pois �, o narrador, parece estar te zuando mesmo. Enfim, parece que voc� at� estudou," +
            "\n mas n�o o tanto que deveria, vou te recomendar estudar mais, e tambem dar uma olhada em algumas referencias de livros por a� \"\n";

    private static String h7 = "Na mesma noite, voc� corre para o computador assim que chega em casa, para dar um olhada nos cursos que existem dentro da �rea,\n voc� percebe que gest�o em TI, n�o � muito a sua cara, nem Bacharel em ci�ncias da computa��o.\n" +
            "J� tecn�logo em analise e desenvolvimento de sistemas, se encaixa perfeitmente no que voc� esperava, como � maio, voc� j� corre para fazer a sua inscri��o, e passa no vestibular.\n" +
            "Logo nas primeiras semanas, voc� se enturma, e essas pessoas ser�o o seu grupo de PI";

    private static String h8 = "Uma das suas primeiras tarefas vem a seguir, � uma ADO de PI.";

    private static String h91 = "Na mesma semana, voc� encontra Jefferson, nos corredores da empresa, e comenta que est� fazendo faculdade.\n" +
            "-\"Eai (NOME), est� curtindo?\"\n" +
            "-\"Estou sim, o pessoal � bem legal\".";

    private static String h92 = "Na mesma semana, voc� encontra Jefferson, nos corredores da empresa, voc�s se cumprimentam e seguem a vida";

    private static String h10 = "-\"Parece que daqui pra frente os exercicios ser�o mais intensos, ent�o � melhor se preparar\" - diz Enzo, seu colega de PI\n" +
            "J� para o outro dia j� temos mais exercicios para serem feitos.";

    private static String h11 = "Vamos para outro exerc�cio logo em seguida";

    private static String h12 = "Voc� volta pra casa para descansar durante o fim de semana,\n" +
            "no domingo voc� sa� para ir pra casa da sua tia Suelita, l� encontra o seu primo Pedro, e comenta com ele que est� fazendo faculdade, \n" +
            "Pedro � desenvolvedor de jogos, e te ajuda a fazer a pr�xima atividade.";

    private static String h131 = "- \"� isso mesmo (NOME), parab�ns, voc� est� aprendendo certinho\" - diz Pedro\n" +
            "- \"Esse � meu menino\", grita a sua m�e da sala";

    private static String h14 = "J� na pr�xima aula.\n" +
            "- \"Temos que seguir adiante nos aprendizados\" - diz Fabiano, professor de l�gica de programa��o\n" +
            "- \"Ent�o hoje vamos falar sobre switch, a primeira pergunta �...\" - completa Fabiano";

    private static String h151 = "- \"Isto mesmo, o (NOME), como voc�s podem ver, j� sabe sobre switch, vamos ver ent�o se voc� aprendeu direitinho\" - diz Fabiano para toda a sala\n";

    private static String h152 = "- \"Uhmmm, n�o � bem assim, mas vamos ver se voc� acerta essa...\" - diz Fabiano para toda a sala\n";

    private static String h16 = "Est� chegando o fim do semestre, e pra isso � necess�rio dar um g�s a mais nos estudo, ent�o nos responda...";

    private static String h171 = "Ent�o j� que � o sabich�o e sabia essa me responda...";


    //Fun��o do jogo
    private static void jogar() {
        try {
            historia(1);
            setNomeJogador();
            historia(2);
            historia(3);


            if (desafiosBooleanos(desafio1)) {
                poderes.add("Perguntar pro Takeo");
                System.out.println("Voc� liberou o poder de perguntar para o Takeo, isto poder� ser util em momentos de dificuldades");
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
                System.out.println("Voc� liberou o poder de consultar o livro, pode ser que isso seja �til em algum momento");
            }
            historia(8);
            if (pergunta(3)) {
                historia(91);
                if (desafiosBooleanos(desafio3)) {
                    poderes.add("Pedir ajuda a Jefferson");
                    System.out.println("Voc� liberou o poder de perguntar ao Jefferson, pode ser que ele te ajude em uma dificuldade");
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

    //Exibe a pontua��o que o jogador conseguiu dentro do jogo.
    //Este retorno s� serve para fazer teste
    public static int exibePontuacao() {
        if (pontuacao == 0) {
            System.out.println("Voc� foi demitido do seu emprego, devido a um corte de gasto");
        } else if (pontuacao >= 1 && pontuacao <= 4) {
            System.out.println("PARAB�NSSSSSS\n" +
                    "Devido ao seu esfor�o de estudos voc� recebeu uma proposta de emprego na empresa concorrente, com o cargo de desenvolvedor j�nior");
        } else if (pontuacao >= 4 && pontuacao <= 6) {
            System.out.println("PARAB�NSSSSSS\n" +
                    "Devido ao seu esfor�o de estudos voc� recebeu uma proposta de emprego na empresa concorrente, com o cargo de desenvolvedor pleno");
        } else if (pontuacao >= 7 && pontuacao <= 9) {
            System.out.println("PARAB�NSSSSSS\n" +
                    "Devido ao seu esfor�o de estudos voc� recebeu uma proposta de emprego na empresa em que trabalha, com o cargo de desenvolvedor s�nior");
        } else if (pontuacao == 10) {
            System.out.println("PARAB�NSSSSSS\n" +
                    "Devido ao seu esfor�o de estudos voc� recebeu uma proposta de emprego na empresa concorrente, com o cargo de especialista t�cnico");
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
        System.out.print("Selecione para qual op��o deseja seguir: ");
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
                System.out.println("Voc� selecionou uma op��o invalida, tente novamente");
                menu();
                break;
        }
    }

    //Imprime cr�ditos
    private static void creditos() {
        System.out.println("Este jogo foi desenvolvido com esm�ro por:\n" +
                "Paulo Belfi\n\n");
        menu();
    }

    //Imprime as instru��es do jogo
    private static void instrucoes() {
        System.out.println("O jogo se baseia no genero RPG de texto, ser� necessario colocar em uso o seu conhecimento de programa��o\npara responder as mais diversas perguntas sobre desenvolvimento, ent�o" +
                " se prepare aventureiro, vamos entrar de cabe�a nesse mundo.\n\n");
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
        //utilizando metodo de impress�o digitada
        String texto = possiblidades.get(rand.nextInt(possiblidades.size()));

        imprimir(texto,tempo);
        System.out.println();
        return true;
    }

    //Recebe o array de perguntas a serem impressas sem as suas letras correspondentes
    public static boolean imprimirQuestao(ArrayList<String> respostas, int id) {
        Scanner scan = new Scanner(System.in);
        //embaralha as perguntas para n�o ser sempre a mesma op��o
        Collections.shuffle(respostas);

        String respostaCerta = "";
        ArrayList<String> listaRespostas = new ArrayList<>();


        //la�o para imprir as respostas
        for (int i = 0; i < respostas.size(); i++) {
            //Verifica qual � a resposta correta ap�s o embaralhamento
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
            //se poderes forem iguais a 0 n�o deve fazer nada
            if (poderes.size() == 0) {
                System.out.println("Voc� n�o tem poderes, teremos que seguir sem utilizar ajuda.");
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

        //verifica se a resposta dada � v�lida ao conjunto de respostas validas
        else if (listaRespostas.indexOf(resp) == -1) {
            System.out.println("Esta resposta � inv�lida, tente apenas respostas validas.\nTente novamente.\n\n");
            imprimirQuestao(respostas, id);
        }
        return respostaCerta.toUpperCase(Locale.ROOT).equals(resp.toUpperCase(Locale.ROOT));
    }

    //imprime os poderes possiveis do jogador
    private static int imprimePoderes() {
        Scanner scan = new Scanner(System.in);
        //faz um la�o na arrai para imprimir todos os poderes possiveis
        for (int i = 0; i < poderes.size(); i++) {
            //Character.toString((char) i + 97) = tabela ascii
            System.out.println(Character.toString((char) i + 97) + ") " + poderes.get(i));
        }

        System.out.print("Selecione qual poder deseja utilizar: ");
        String resp = scan.next();
        //verifica se a resposta dada � v�lida, n�o pode ser -1 nem maior do que a quantidade de poderes -1
        if (resp.toLowerCase(Locale.ROOT).toCharArray()[0] - 97 < 0 ||
                resp.toLowerCase(Locale.ROOT).toCharArray()[0] - 97 > poderes.size()-1) {
            System.out.println("Este poder n�o existe, tente novamente");
            return imprimePoderes();
        }
        //retorna indice da resposta
        return resp.toLowerCase(Locale.ROOT).toCharArray()[0] - 97;
    }


    //Fun��o para setar o nome do jogador
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
        System.out.println("Responda com S (Sim) ou N (N�o): ");
        Scanner scan = new Scanner(System.in);

        return scan.next().toUpperCase(Locale.ROOT).equals("S");
    }
}
