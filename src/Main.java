import java.awt.font.GraphicAttribute;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    private static long tempo = 1l;
    private static int pontuacao = 0;


    private static ArrayList<String> erradas = new ArrayList<>(Arrays.asList(
            "Uhmmm, que pena, essa resposta n�o era a correta, mas vamos seguir mesmo assim.",
            "Olha... Esta resposta n�o � a correta, mas n�o tem problemas, voc� pode tentar acerta-la em outra vida! MUAHAHAHAHA",
            "Parece que voc� errou e sua vida acaba aqui MUAHAHAHAHA... Brincadeirinha, vamos seguir.",
            "Est�..... Incorreta, perdeu tudo o drama do aluno que se ferrou!!! Mentira, vamos seguir os estudos!"));
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
            +PURPLE+"for " + RESET + "(int" + GREEN + " linha " + PURPLE + "= " + BLUE + "0" + RESET + "; " + GREEN + "linha" + PURPLE + " < " + BLUE + "10" + RESET + "; " + GREEN + "linha " + PURPLE + "+" + GREEN + " linha" + RESET + "){\n" +
            PURPLE+"    for " + RESET + "(int" + GREEN + " coluna " + PURPLE + "= " + BLUE + "0" + RESET + "; " + GREEN + "coluna" + PURPLE + " <= " + BLUE + "10" + RESET + "; " + GREEN + "coluna" + PURPLE + "++"+ RESET + "){\n" +
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
    // Historias
    private static String h1 = "Uhmmm, hoje est� um excelente dia para filosofar...";

    public static void main(String[] args) throws InterruptedException {
		historia(1);
		pergunta(1);
		pergunta(2);
		pergunta(3);
        pergunta(4);
        pergunta(5);
        pergunta(9);
        pergunta(10);

    }

    // id = id da historia
    public static void historia(int id) throws InterruptedException {
        switch (id) {
            case 1:
                imprimir(h1, tempo);

        }
    }

    // id = id da pergunta
    public static void pergunta(int id) throws InterruptedException {
        switch (id) {

            case 1:
                imprimir(p1, tempo);
                pontuar(imprimirQuestao(r1));
                break;

            case 2:
                imprimir(p2, tempo);
                pontuar(imprimirQuestao(r2));
                break;

            case 3:
                imprimir(p3, tempo);
                pontuar(imprimirQuestao(r3));
                break;

            case 4:
                imprimir(p4, tempo);
                pontuar(imprimirQuestao(r4));
                break;
            case 9:
                imprimir(p9, tempo);
                pontuar(imprimirQuestao(r9));
                break;
            case 10:
                imprimir(p10, tempo);
                pontuar(imprimirQuestao(r10));
                break;
//		case 5:
//			imprimir(p5, tempo);
//			System.out.println(imprimirQuestao(r5));
        }
    }

    public static void pontuar(boolean acertou) throws InterruptedException {
        if (acertou) {
            pontuacao++;
        } else {
            imprimirRespostaErrada(erradas, tempo);
        }
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
    public static boolean imprimirQuestao(ArrayList<String> perguntas) {
        Scanner scan = new Scanner(System.in);
        //embaralha as perguntas para n�o ser sempre a mesma op��o
        Collections.shuffle(perguntas);
        String respostaCerta = "";
        ArrayList<String> listaRespostas = new ArrayList<>();

        for (int i = 0; i < perguntas.size(); i++) {
            //Verifica qual � a resposta correta ap�s o embaralhamento
            if (perguntas.get(i).indexOf("(CERTA RESPOSTA)") != -1) {
                respostaCerta = Character.toString((char) i + 97);
            }

            //Adicionando a lista de respostas a letra correspondente, tanto maiusculo como minisculo.
            listaRespostas.add(Character.toString((char) i + 97));
            listaRespostas.add(Character.toString((char) i + 97).toUpperCase(Locale.ROOT));

            //imprime a pergunta removendo o marcador de certa resposta
            System.out.println(
                    Character.toString((char) i + 97) + ") " + perguntas.get(i).replaceAll("\\(CERTA RESPOSTA\\)", ""));
        }
        System.out.print("A resposta correta �: ");
        String resp = scan.next();
        //verifica se a resposta dada � v�lida ao conjunto de respostas validas
        if (listaRespostas.indexOf(resp) == -1) {
            System.out.println("Esta resposta � inv�lida, tente apenas respostas validas.\nTente novamente.\n\n");
            imprimirQuestao(perguntas);
        }
        return respostaCerta.toUpperCase(Locale.ROOT).equals(resp.toUpperCase(Locale.ROOT));
    }

}
