import java.util.Scanner;

public class exercicio10 {
    
    public static void main(String[] args) {
        
        int idade[] = new int[10];
        int i, soma = 0;
        double media;

        Scanner lerIdade = new Scanner(System.in);
        System.out.println("Digite as idades: ");
        for (i = 0; i < 10; i++){
            idade[i] = lerIdade.nextInt();
        }

        // Soma e média das idades
        for (i = 0; i < 10; i++){
            soma = soma + idade[i];
        }
        media = soma / 10;
        System.out.println("A média das idades é: " + media);

        // idades acima da média
        System.out.print("As idades acima da média são: ");
        for (i = 0; i < 10; i++){
            if (idade[i] > media){
                System.out.print(idade[i] + " ");
            }
        }

        System.out.print("\n");

        // idades acima da média
        System.out.print("As idades abaixo da média são: ");
        for (i = 0; i < 10; i++){
            if (idade[i] < media){
                System.out.print(idade[i] + " ");
            }
        }

        System.out.print("\n");

        lerIdade.close();
    }
}
