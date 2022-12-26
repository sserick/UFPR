import java.util.Scanner;

public class exercicio2 {
    
    public static void main(String[] args) {
        
        String palavra1, palavra2;
        boolean saoIguais;

        Scanner lerPalvra = new Scanner(System.in);
        System.out.println("Digite a primeira palavra:");
        palavra1 = lerPalvra.nextLine();
        System.out.println("Digite a segunda palavra:");
        palavra2 = lerPalvra.nextLine();

        saoIguais = palavra1.equals(palavra2);

        if (saoIguais){
            System.out.println("As palavras " + palavra1 + " e " + palavra2 + " são iguais");
        } else {
            System.out.println("As palavras " + palavra1 + " e " + palavra2 + " não são iguais");
        }

        lerPalvra.close();
    }
}
