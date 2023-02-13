import java.util.Scanner;

public class exercicio1 {
    
    public static void main(String[] args) {
        
        int i, contI = 0;
        int somaP = 0;
        int num[] = new int[10];
        Scanner lerNum = new Scanner(System.in);

        System.out.println("Digite os 10 números: ");
        for (i = 0; i < 10; i++){
            num[i] = lerNum.nextInt();
        }

        // numeros pares
        System.out.print("Os números pares: ");
        for (i = 0; i < 10; i++){
            if (num[i] % 2 == 0){
                System.out.print(num[i] + " ");
                somaP = somaP + num[i];
            }
        }
        System.out.println("\nA soma dos números pares: " + somaP);

        // numeros pares
        System.out.print("Os números ímpares: ");
        for (i = 0; i < 10; i++){
            if (num[i] % 2 != 0){
                System.out.print(num[i] + " ");
                contI++;
            }
        }
        System.out.println("\nA quantidade de números ímpares: " + contI);

        lerNum.close();
    }
}
