import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class Main {
    //Perguntas
    private static String p1 = "Por que tudo junto se escreve separado, e separado se escreve tudo junto?";
private static String p2 =("elseif (nota == 10) {\r\n"
		+ "			System.out.println(nome + \" Parabéns você ganhou uma     bolsa de estudos\");\r\n"
		+ "		} else if (nota > 7 && nota < 10) {\r\n"
		+ "			System.out.println(nome + \"você ganhou 20% de desconto na mensalidade\");\r\n"
		+ "		} else if (nota >= 05 && nota < 7) {\r\n"
		+ "			System.out.println(nome + \" você ganhou desconto de 10% na mensalidade\");\r\n"
		+ "		} else if nota <= 5 || nota == 0 {\r\n"
		+ "			System.out.println(nome + \" Infelizmente você não Passou no processo seletivo\");\r\n"
		+ "		}\n O código acima mostra a verificação de um processo seletivo de um aluno\r\n"
		+ "	 Identifique os erros que está impedindo o programa executar corretamente.\n"
		+ "");

    //Respostas
    private static ArrayList<String> r1 = new ArrayList<>(Arrays.asList("por que sim(CERTA RESPOSTA)","por que foi feito assim","porque sim","porque nÃ£o?","e eu sei lÃ¡?"));
    private static ArrayList<String> r2 = new ArrayList<>(Arrays.asList("A estrutura IF não serve para verificar condicional. ", "A estrutura é iniciada primeiro com IF e a condição é entre (). (CERTA RESPOSTA)",
    		"Tem que declarar uma variável dentro da condição para poder executar o código.", "A estrutura não pode ter um IF dentro de outro IF."));
    
    //Historias
    private static String h1 = "Uhmmm, hoje Ã© um excelente dia para filosofar...";


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
