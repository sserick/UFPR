import java.util.Scanner;

public class exemplo2 {
    
    public static void main(String[] args) {
        int numero;

        Scanner input = new Scanner(System.in);
        System.out.print("Digite um número: ");
        numero = input.nextInt();

        System.out.println("Numero digitado: " + numero);

        input.close();
    }
}