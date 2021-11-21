import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
	// Perguntas
	private static String p1 = "Por que tudo junto se escreve separado, e separado se escreve tudo junto?";

	private static String p2 = "Escolha a alternativa correta que descreve o conceito de IF e IF ELSE? "
			+ "    A estrutura IF executa um comando sempre que a condi��o seja falsa\n"
			+ "    A estrutura IF executa um comando quando a condicional seja verdadeira correta\n"
			+ "    Podemos afirmar que o IF ELSE executa o comando e depois faz a verifica��o\n"
			+ "    A estrutura IF ELSE executa um conjunto de comandos caso a condi��o IF seja falsa\n"
			+ "    Podemos afirmar que IF ELSE � utilizado para o teste de m�ltiplos caso seria IF ELSE aninhado correta";


	private static String p3 = ("elseif (nota == 10) {\n"
			+ "			System.out.println(nome + \" Parab�ns voc� ganhou uma     bolsa de estudos\");\n"
			+ "		} else if (nota > 7 && nota < 10) {\n"
			+ "			System.out.println(nome + \"voc� ganhou 20% de desconto na mensalidade\");\n"
			+ "		} else if (nota >= 05 && nota < 7) {\n"
			+ "			System.out.println(nome + \" voc� ganhou desconto de 10% na mensalidade\");\n"
			+ "		} else if nota <= 5 || nota == 0 {\n"
			+ "			System.out.println(nome + \" Infelizmente voc� n�o Passou no processo seletivo\");\n"
			+ "		}\n O c�digo acima mostra a verifica��o de um processo seletivo de um aluno\n"
			+ "	 Identifique os erros que est� impedindo o programa executar corretamente.\n" + "");

	private static String p4 = "Escolha a op��o que descreve como o break funciona quando � utilizado dentro de um la�o de repeti��o aninhado.";

	private static String p5 = "O la�o de repeti��o abaixo est� formando uma metade de uma pir�mide, sendo criada por linhas e colunas. Por�m o c�digo n�o est� rodando, o porqu� o la�o de repeti��o for n�o est� rodando?"
			+ "\"for (int linha = 0; linha < 10; linha + linha) {\"\n"
			+ "	 for (int coluna = 0; coluna <= 10; coluna++) {\"\n" + "		if (coluna > linha)\"\n"
			+ "			break;\"\n" + "				System.out.print(\" *\");\"\n" + "			}\"\n"
			+ "			System.out.println();\"\n" + "		}\"\n";

	// Respostas
	private static ArrayList<String> r1 = new ArrayList<>(Arrays.asList("por que sim(CERTA RESPOSTA)",
			"por que foi feito assim", "porque sim", "porque não?", "e eu sei lá?"));

	private static ArrayList<String> r2 = new ArrayList<>(Arrays.asList("(I e II e VI) Est�o corretas",
			"(I e II e III) Est�o corretas", "(II e V) Est�o corretas (CERTA RESPOSTA)", "(IV e II) Est�o corretas",
			"(I e IV e V) Est�o corretas)", "I ) Est�o corretas"));

	private static ArrayList<String> r3 = new ArrayList<>(
			Arrays.asList("A estrutura IF n�o serve para verificar condicional. ",
					"A estrutura � iniciada primeiro com IF e a condi��o � entre (). (CERTA RESPOSTA)",
					"Tem que declarar uma vari�vel dentro da condi��o para poder executar o c�digo.",
					"A estrutura n�o pode ter um IF dentro de outro IF.",
					"A estrutura sempre ter� um IF dentro de outro IF"));

	private static ArrayList<String> r4 = new ArrayList<>(Arrays.asList(
			"Finaliza a execu��o do programa no momento em que � chamado.",
			"Para a execu��o de todos os la�os de repeti��o aninhados que o cont�m e continua normalmente o programa.",
			"Para a execu��o do la�o que cont�m o comando break e continua executando os la�os mais externos. (CERTA RESPOSTA)",
			"Ele para todos os la�os de repeti��o que tem dentro do programa. "));

	private static ArrayList<String> r5 = new ArrayList<>(Arrays.asList(
			"A estrutura FOR n�o se deve ter outro FOR dentro",
			"O c�digo n�o est� rodando, pois o break deve ser fora do la�o de repeti��o FOR.",
			"A estrutura n�o executa, pois a express�o linha + linha est� incorreta, para seu c�digo executa se deve considerar: linha++ ou linha = linha + 1. (CERTA RESPOSTA)",
			"O c�digo n�o vai rodar, pois o IF dentro do for est� sem o ELSE.",
			"Nenhuma das alternativas, o c�digo est� certo."));

	// Historias
	private static String h1 = "Uhmmm, hoje est� um excelente dia para filosofar...";

	public static void main(String[] args) throws InterruptedException {
		historia(1);
		pergunta(1);
		pergunta(2);
		pergunta(3);
		pergunta(4);
		pergunta(5);

	}

	// id = id da pergunta
	public static void historia(int id) throws InterruptedException {
		switch (id) {
		case 1:
			imprimir(h1, 10l);

		}
	}

	// id = id da pergunta
	public static void pergunta(int id) throws InterruptedException {
		switch (id) {

		case 1:
			imprimir(p1, 10l);
			System.out.println(imprimirQuestao(r1));

		case 2:
			imprimir(p2, 10l);
			System.out.println(imprimirQuestao(r2));

		case 3:
			imprimir(p3, 10l);
			System.out.println(imprimirQuestao(r3));

		case 4:
			imprimir(p4, 10l);
			System.out.println(imprimirQuestao(r4));

		case 5:
			imprimir(p5, 10l);
			System.out.println(imprimirQuestao(r5));
		}
	}

	public static void imprimir(String texto, long tempo) throws InterruptedException {
		for (Character per : texto.toCharArray()) {
			System.out.print(per);
			TimeUnit.MILLISECONDS.sleep(tempo);
		}
		System.out.println();
	}

	public static boolean imprimirQuestao(ArrayList<String> perguntas) {
		Scanner scan = new Scanner(System.in);
		Collections.shuffle(perguntas);
		String respostaCerta = "";
		for (int i = 0; i < perguntas.size(); i++) {
			if (perguntas.get(i).indexOf("(CERTA RESPOSTA)") != -1) {
				respostaCerta = Character.toString((char) i + 97);
			}
			System.out.println(
					Character.toString((char) i + 97) + ") " + perguntas.get(i).replaceAll("(CERTA RESPOSTA)", ""));
		}
		String resp = scan.next();
		return respostaCerta.toUpperCase(Locale.ROOT).equals(resp.toUpperCase(Locale.ROOT));
	}

}
