import java.util.Scanner;

public class exercicio2 {
    
    public static void main(String[] args) {

        int num = 0;
        int soma = 0;
        Scanner lerNumero = new Scanner(System.in);

        while (num != -1){
            System.out.println("Digite um número: ");
            num = lerNumero.nextInt();

            if (num != -1){
                soma = soma + num;
            }
        }

        System.out.println("Soma: " + soma);
        lerNumero.close();
    }
}
