import java.util.Scanner;

public class exercicio3 {
    
    public static void main(String[] args) {
        
        String palavra1, palavra2, palavraCompleta;

        Scanner lerPalvra = new Scanner(System.in);
        System.out.println("Digite a primeira palavra:");
        palavra1 = lerPalvra.nextLine();
        System.out.println("Digite a segunda palavra:");
        palavra2 = lerPalvra.nextLine();

        palavraCompleta = palavra1.concat(palavra2);

        System.out.println("String Concatenadas: " + palavraCompleta);

        lerPalvra.close();
    }
}
