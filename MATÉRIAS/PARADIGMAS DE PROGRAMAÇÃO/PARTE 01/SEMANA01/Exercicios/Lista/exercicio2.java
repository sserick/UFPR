import java.util.Scanner;

public class exercicio2 {
    
    public static void main(String[] args) {
        
        int num;

        Scanner lerNumero = new Scanner(System.in);
        System.out.print("Digite um número: ");
        num = lerNumero.nextInt();

        if (num % 2 == 0){
            System.out.print("Este número é par!");
        } else {
            System.out.println("Este número é ímpar!");
        }

        lerNumero.close();
    }
}