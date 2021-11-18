import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    //Perguntas
    private static String p1 = "Por que tudo junto se escreve separado, e separado se escreve tudo junto?";


    //Respostas
    private static ArrayList<String> r1 = new ArrayList<>(Arrays.asList("por que sim(CERTA RESPOSTA)","por que foi feito assim","porque sim","porque não?","e eu sei lá?"));

    //Historias
    private static String h1 = "Uhmmm, hoje é um excelente dia para filosofar...";


    public static void main(String[] args) throws InterruptedException {
        historia(1);
        pergunta(1);
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
