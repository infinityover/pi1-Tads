import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
	// Perguntas
	private static String p1 = "Por que tudo junto se escreve separado, e separado se escreve tudo junto?";

	private static String p2 = "Escolha a alternativa correta que descreve o conceito de IF e IF ELSE? "
			+ "    A estrutura IF executa um comando sempre que a condição seja falsa\n"
			+ "    A estrutura IF executa um comando quando a condicional seja verdadeira correta\n"
			+ "    Podemos afirmar que o IF ELSE executa o comando e depois faz a verificação\n"
			+ "    A estrutura IF ELSE executa um conjunto de comandos caso a condição IF seja falsa\n"
			+ "    Podemos afirmar que IF ELSE é utilizado para o teste de múltiplos caso seria IF ELSE aninhado correta";


	private static String p3 = ("elseif (nota == 10) {\n"
			+ "			System.out.println(nome + \" Parabéns você ganhou uma     bolsa de estudos\");\n"
			+ "		} else if (nota > 7 && nota < 10) {\n"
			+ "			System.out.println(nome + \"você ganhou 20% de desconto na mensalidade\");\n"
			+ "		} else if (nota >= 05 && nota < 7) {\n"
			+ "			System.out.println(nome + \" você ganhou desconto de 10% na mensalidade\");\n"
			+ "		} else if nota <= 5 || nota == 0 {\n"
			+ "			System.out.println(nome + \" Infelizmente você não Passou no processo seletivo\");\n"
			+ "		}\n O código acima mostra a verificação de um processo seletivo de um aluno\n"
			+ "	 Identifique os erros que está impedindo o programa executar corretamente.\n" + "");

	private static String p4 = "Escolha a opção que descreve como o break funciona quando é utilizado dentro de um laço de repetição aninhado.";

	private static String p5 = "O laço de repetição abaixo está formando uma metade de uma pirâmide, sendo criada por linhas e colunas. Porém o código não está rodando, o porquê o laço de repetição for não está rodando?"
			+ "\"for (int linha = 0; linha < 10; linha + linha) {\"\n"
			+ "	 for (int coluna = 0; coluna <= 10; coluna++) {\"\n" + "		if (coluna > linha)\"\n"
			+ "			break;\"\n" + "				System.out.print(\" *\");\"\n" + "			}\"\n"
			+ "			System.out.println();\"\n" + "		}\"\n";

	// Respostas
	private static ArrayList<String> r1 = new ArrayList<>(Arrays.asList("por que sim(CERTA RESPOSTA)",
			"por que foi feito assim", "porque sim", "porque nÃ£o?", "e eu sei lÃ¡?"));

	private static ArrayList<String> r2 = new ArrayList<>(Arrays.asList("(I e II e VI) Estão corretas",
			"(I e II e III) Estão corretas", "(II e V) Estão corretas (CERTA RESPOSTA)", "(IV e II) Estão corretas",
			"(I e IV e V) Estão corretas)", "I ) Estão corretas"));

	private static ArrayList<String> r3 = new ArrayList<>(
			Arrays.asList("A estrutura IF não serve para verificar condicional. ",
					"A estrutura é iniciada primeiro com IF e a condição é entre (). (CERTA RESPOSTA)",
					"Tem que declarar uma variável dentro da condição para poder executar o código.",
					"A estrutura não pode ter um IF dentro de outro IF.",
					"A estrutura sempre terá um IF dentro de outro IF"));

	private static ArrayList<String> r4 = new ArrayList<>(Arrays.asList(
			"Finaliza a execução do programa no momento em que é chamado.",
			"Para a execução de todos os laços de repetição aninhados que o contém e continua normalmente o programa.",
			"Para a execução do laço que contém o comando break e continua executando os laços mais externos. (CERTA RESPOSTA)",
			"Ele para todos os laços de repetição que tem dentro do programa. "));

	private static ArrayList<String> r5 = new ArrayList<>(Arrays.asList(
			"A estrutura FOR não se deve ter outro FOR dentro",
			"O código não está rodando, pois o break deve ser fora do laço de repetição FOR.",
			"A estrutura não executa, pois a expressão linha + linha está incorreta, para seu código executa se deve considerar: linha++ ou linha = linha + 1. (CERTA RESPOSTA)",
			"O código não vai rodar, pois o IF dentro do for está sem o ELSE.",
			"Nenhuma das alternativas, o código está certo."));

	// Historias
	private static String h1 = "Uhmmm, hoje está um excelente dia para filosofar...";

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
