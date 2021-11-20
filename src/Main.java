import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class Main {
    //Perguntas
    private static String p1 = "Por que tudo junto se escreve separado, e separado se escreve tudo junto?";
private static String p2 =("elseif (nota == 10) {\r\n"
		+ "			System.out.println(nome + \" Parab�ns voc� ganhou uma     bolsa de estudos\");\r\n"
		+ "		} else if (nota > 7 && nota < 10) {\r\n"
		+ "			System.out.println(nome + \"voc� ganhou 20% de desconto na mensalidade\");\r\n"
		+ "		} else if (nota >= 05 && nota < 7) {\r\n"
		+ "			System.out.println(nome + \" voc� ganhou desconto de 10% na mensalidade\");\r\n"
		+ "		} else if nota <= 5 || nota == 0 {\r\n"
		+ "			System.out.println(nome + \" Infelizmente voc� n�o Passou no processo seletivo\");\r\n"
		+ "		}\n O c�digo acima mostra a verifica��o de um processo seletivo de um aluno\r\n"
		+ "	 Identifique os erros que est� impedindo o programa executar corretamente.\n"
		+ "");

    //Respostas
    private static ArrayList<String> r1 = new ArrayList<>(Arrays.asList("por que sim(CERTA RESPOSTA)","por que foi feito assim","porque sim","porque não?","e eu sei lá?"));
    private static ArrayList<String> r2 = new ArrayList<>(Arrays.asList("A estrutura IF n�o serve para verificar condicional. ", "A estrutura � iniciada primeiro com IF e a condi��o � entre (). (CERTA RESPOSTA)",
    		"Tem que declarar uma vari�vel dentro da condi��o para poder executar o c�digo.", "A estrutura n�o pode ter um IF dentro de outro IF."));
    
    //Historias
    private static String h1 = "Uhmmm, hoje é um excelente dia para filosofar...";


    public static void main(String[] args) throws InterruptedException {
        historia(1);
        pergunta(2);
    }

    //id = id da pergunta
    public static void historia(int id) throws InterruptedException {
        switch (id) {
            case 1:
                imprimir(h1, 10l);

        }
    }

    //id = id da pergunta
    public static void pergunta(int id) throws InterruptedException {
        switch (id) {
            case 1:
                imprimir(p1, 10l);

                System.out.println(imprimirQuestao(r1));
            case 2: imprimir(p2, 10l);
            System.out.println(imprimirQuestao(r2));
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
            if(perguntas.get(i).indexOf("(CERTA RESPOSTA)") != -1){
                respostaCerta = Character.toString ((char) i+97);
            }
            System.out.println( Character.toString ((char) i+97)+  ") " +  perguntas.get(i).replaceAll("\\(CERTA RESPOSTA\\)",""));

        }
        String resp = scan.next();
        return respostaCerta.toUpperCase(Locale.ROOT).equals(resp.toUpperCase(Locale.ROOT));
    }


}
