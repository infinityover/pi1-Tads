import java.awt.font.GraphicAttribute;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    private static long tempo = 1l;
    private static int pontuacao = 0;
    private static String nome = "";


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
    private static final String BLACK = "\033[0;30m";   // BLACK
    private static final String RED = "\033[0;31m";     // RED
    private static final String GREEN = "\033[0;32m";   // GREEN
    private static final String YELLOW = "\033[0;33m";  // YELLOW
    private static final String BLUE = "\033[0;34m";    // BLUE
    private static final String PURPLE = "\033[0;35m";  // PURPLE
    private static final String CYAN = "\033[0;36m";    // CYAN
    private static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    private static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    private static final String RED_BOLD = "\033[1;31m";    // RED
    private static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    private static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    private static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    private static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    private static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    private static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    private static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    private static final String RED_UNDERLINED = "\033[4;31m";    // RED
    private static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    private static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    private static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    private static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    private static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    private static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    private static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    private static final String RED_BACKGROUND = "\033[41m";    // RED
    private static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    private static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    private static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    private static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    private static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    private static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    private static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    private static final String RED_BRIGHT = "\033[0;91m";    // RED
    private static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    private static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    private static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    private static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    private static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    private static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    private static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    private static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    private static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    private static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    private static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    private static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    private static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    private static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    private static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    private static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    private static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    private static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    private static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    private static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    private static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    private static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE


    private static ArrayList<String> poderes = new ArrayList<>(
            Arrays.asList());

    private static String desafio1 = "Voc� assiste as aulas como o Jefferson sugeriu?";
    private static String desafio2 = "Voc� l� o livro que Jefferson sugeriu?";

    // Perguntas
    private static String p1 = "Escolha a alternativa correta que descreve o conceito de IF e IF ELSE? \n"
            + "I)   A estrutura IF executa um comando sempre que a condi��o seja falsa\n"
            + "II)  A estrutura IF executa um comando quando a condicional seja verdadeira correta\n"
            + "III) Podemos afirmar que o IF ELSE executa o comando e depois faz a verifica��o\n"
            + "IV)  A estrutura IF ELSE executa um conjunto de comandos caso a condi��o IF seja falsa\n"
            + "V)   Podemos afirmar que IF ELSE � utilizado para o teste de m�ltiplos caso seria IF ELSE aninhado correta\n";

    private static String p2 = ("" +
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

    private static String p3 = "Escolha a op��o que descreve como o break funciona quando � utilizado dentro de um la�o de repeti��o aninhado.";

    private static String p4 = "O la�o de repeti��o abaixo est� formando uma metade de uma pir�mide, sendo criada por linhas e colunas. Por�m o c�digo n�o est� rodando, o porqu� o la�o de repeti��o for n�o est� rodando?\n"
            + PURPLE + "for " + RESET + "(int" + GREEN + " linha " + PURPLE + "= " + BLUE + "0" + RESET + "; " + GREEN + "linha" + PURPLE + " < " + BLUE + "10" + RESET + "; " + GREEN + "linha " + PURPLE + "+" + GREEN + " linha" + RESET + "){\n" +
            PURPLE + "    for " + RESET + "(int" + GREEN + " coluna " + PURPLE + "= " + BLUE + "0" + RESET + "; " + GREEN + "coluna" + PURPLE + " <= " + BLUE + "10" + RESET + "; " + GREEN + "coluna" + PURPLE + "++" + RESET + "){\n" +
            "		" + PURPLE + "if " + RESET + "(" + GREEN + "coluna " + PURPLE + "> " + GREEN + "linha" + RESET + ")\n" +
            "			" + PURPLE + "break" + RESET + ";\n" +
            "		" + GREEN + "System" + RESET + "." + GREEN + "out" + RESET + "." + GREEN + "print" + RESET + "(" + YELLOW + "\"*\"" + RESET + ");\n" +
            "	}\n" +
            "" + GREEN + "System" + RESET + "." + GREEN + "out" + RESET + "." + GREEN + "print" + RESET + "();\n" +
            "}";

    private static String p9 = "No que tange fun��es podemos descrev�-las como";

    private static String p10 = "Qual o erro do c�digo abaixo?\n" + PURPLE + " static void " + GREEN + "soma" + YELLOW + "(" + PURPLE + "int" + RESET + " a, " + PURPLE + "int" + RESET + " b" + YELLOW + ")" + WHITE + "{\n" +
            "   " + PURPLE + "return " + WHITE + "a+b;\n" +
            "}" + RESET;

    // Respostas
    private static ArrayList<String> r1 = new ArrayList<>(Arrays.asList("(I e II e VI) Est�o corretas",
            "(I e II e III) Est�o corretas",
            "(II e V) Est�o corretas (CERTA RESPOSTA)",
            "(IV e II) Est�o corretas",
            "(I e IV e V) Est�o corretas",
            "(I) Est� correta"));

    private static ArrayList<String> r2 = new ArrayList<>(
            Arrays.asList("A estrutura IF n�o serve para verificar condicional.",
                    "A estrutura � iniciada primeiro com IF e a condi��o � entre (). (CERTA RESPOSTA)",
                    "Tem que declarar uma vari�vel dentro da condi��o para poder executar o c�digo.",
                    "A estrutura n�o pode ter um IF dentro de outro IF.",
                    "A estrutura sempre ter� um IF dentro de outro IF."));

    private static ArrayList<String> r3 = new ArrayList<>(Arrays.asList(
            "Finaliza a execu��o do programa no momento em que � chamado.",
            "Para a execu��o de todos os la�os de repeti��o aninhados que o cont�m e continua normalmente o programa.",
            "Para a execu��o do la�o que cont�m o comando break e continua executando os la�os mais externos.(CERTA RESPOSTA)",
            "Ele para todos os la�os de repeti��o que tem dentro do programa."));

    private static ArrayList<String> r4 = new ArrayList<>(Arrays.asList(
            "A estrutura FOR n�o se deve ter outro FOR dentro.",
            "O c�digo n�o est� rodando, pois o break deve ser fora do la�o de repeti��o FOR.",
            "A estrutura n�o executa, pois a express�o linha + linha est� incorreta, para seu c�digo executa se deve considerar: linha++ ou linha = linha + 1.(CERTA RESPOSTA)",
            "O c�digo n�o vai rodar, pois o IF dentro do for est� sem o ELSE.",
            "Nenhuma das alternativas, o c�digo est� certo."));

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

    private static String h92 = "Na mesma semana, voc� encontra Jefferson, nos corredores da empresa";


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

            if (desafiosBooleanos(desafio2)) {
                poderes.add("Consultar o livro");
                System.out.println("Voc� liberou o poder de consultar o livro, isto pode ser �til em alguma quest�o que tenha que responder");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        System.out.println("O jogo se baseia no genero RPG de texto, ser� necessario colocar em uso o seu conhecimento de programa��o\npara responder as mais diversas perguntas sobre desenvolvimento, ent�o2" +
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
    public static void imprimir(String texto, long tempo) throws InterruptedException {
        for (Character per : texto.toCharArray()) {
            System.out.print(per);
            TimeUnit.MILLISECONDS.sleep(tempo);
        }
        System.out.println();
    }

    public static void imprimirRespostaErrada(ArrayList<String> possiblidades, long tempo) throws InterruptedException {
        Random rand = new Random();
        String texto = possiblidades.get(rand.nextInt(possiblidades.size()));

        for (Character per : texto.toCharArray()) {
            System.out.print(per);
            TimeUnit.MILLISECONDS.sleep(tempo);
        }

        System.out.println();
    }


    //Recebe o array de perguntas a serem impressas sem as suas letras correspondentes
    public static boolean imprimirQuestao(ArrayList<String> respostas, int id) {
        Scanner scan = new Scanner(System.in);
        //embaralha as perguntas para n�o ser sempre a mesma op��o
        Collections.shuffle(respostas);
        String respostaCerta = "";
        ArrayList<String> listaRespostas = new ArrayList<>();

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
        System.out.print("Digite qual a resposta correta, ou (P) para usar seus poderes: ");
        String resp = scan.next();
        if (resp.toUpperCase(Locale.ROOT).equals("P")) {
            if (poderes.size() == 0) {
                System.out.println("Voc� n�o tem poderes, teremos que seguir sem utilizar ajuda.");
                return imprimirQuestao(respostas, id);
            }
            imprimePoderes();
            System.out.println(ajudas.get(id - 1));
            poderes.remove(id - 1);
            return imprimirQuestao(respostas, id);
        }
        //verifica se a resposta dada � v�lida ao conjunto de respostas validas
        else if (listaRespostas.indexOf(resp) == -1) {
            System.out.println("Esta resposta � inv�lida, tente apenas respostas validas.\nTente novamente.\n\n");
            imprimirQuestao(respostas, id);
        }
        return respostaCerta.toUpperCase(Locale.ROOT).equals(resp.toUpperCase(Locale.ROOT));
    }

    private static int imprimePoderes() {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < poderes.size(); i++) {
            System.out.println(Character.toString((char) i + 97) + ") " + poderes.get(i));
        }
        System.out.print("Selecione qual poder deseja utilizar: ");
        String resp = scan.next();
        //verifica se a resposta dada � v�lida ao conjunto de respostas validas
        if (resp.toLowerCase(Locale.ROOT).toCharArray()[0] - 97 == -1) {
            System.out.println("Este poder n�o existe, tente novamente");
            return imprimePoderes();
        }
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
