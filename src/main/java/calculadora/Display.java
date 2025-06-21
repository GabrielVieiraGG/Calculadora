package calculadora;
import java.util.Scanner;


public class Display{

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String entrada;

        Operacoes operacao = new Operacoes();

        //Recebe o valor digitado pelo usuário.
        entrada = scan.nextLine().replaceAll(" ", "");

        //Verifica se o valor recebido foi usado vírgula ao invés de ponto e refaz.
        entrada = entrada.replaceAll(",", ".");


        //Converte a entrada para char.
        char[] valor = entrada.toCharArray();

        System.out.print("Entrada original: ");

        for(int i=0; i<entrada.length();i++){
            System.out.print(valor[i] + " ");
        }

        System.out.println("");
        System.out.println("");

        operacao.valor(valor);

    }
}
