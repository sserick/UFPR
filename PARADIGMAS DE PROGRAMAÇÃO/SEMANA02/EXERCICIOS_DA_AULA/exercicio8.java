import java.util.Scanner;

public class exercicio8 {
    
    public static void main(String[] args) {
        
        int num[] = new int[5];
        int i, soma = 0;

        Scanner lerNum = new Scanner(System.in);
        System.out.println("Digite os 5 números: ");

        for (i = 0; i < 5; i++){
            num[i] = lerNum.nextInt();
            soma = soma + num[i];
        }

        System.out.println("Soma: " + soma);

        lerNum.close();
    }

}
