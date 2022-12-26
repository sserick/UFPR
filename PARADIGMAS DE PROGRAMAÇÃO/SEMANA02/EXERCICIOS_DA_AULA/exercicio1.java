import java.util.Scanner;

public class exercicio1 {

    public static void main(String[] args) {

        String frase;
        int tamFrase;

        Scanner lerFrase = new Scanner(System.in);
        System.out.println("Digite a frase:");
        frase = lerFrase.nextLine();
        tamFrase = frase.length();

        System.out.println("O tamanho da frase é:" + tamFrase);

        lerFrase.close();
    }
    
}