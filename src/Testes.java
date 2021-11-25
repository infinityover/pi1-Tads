import java.util.*;
import java.util.concurrent.TimeUnit;

public class Testes {
    public static void main(String[] args) throws InterruptedException {
        if(Main.pontuar(true) == true){
            System.out.println("Teste pontuar passou");
        }else{

            System.out.println("Teste pontuar falhou");
        }
        if(Main.exibePontuacao() == 1){
            System.out.println("Teste exibePontuacao passou");
        }else{

            System.out.println("Teste exibePontuacao falhou");
        }

        if(Main.imprimir("Teste testoso", 10l)){
            System.out.println("Teste imprimir passou");
        }else{

            System.out.println("Teste imprimir falhou");
        }

        if(Main.imprimirRespostaErrada(new String[]{"A estrutura FOR não se deve ter outro FOR dentro."}, 10l)){
            System.out.println("Teste imprimirRespostaErrada passou");
        }else{

            System.out.println("Teste imprimirRespostaErrada falhou");
        }

        String nome = "(NOME) foi jogar bola";
        Main.nome = "José";
        if(Main.geraHistoria(nome).equals("José foi jogar bola")){
            System.out.println("Teste geraHistoria passou");
        }else{
            System.out.println("Teste geraHistoria falhou");
        }
    }


}
