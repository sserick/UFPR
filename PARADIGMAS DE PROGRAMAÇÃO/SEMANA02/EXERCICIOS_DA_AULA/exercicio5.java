import java.util.Scanner;

public class exercicio5 {
    
    public static void main(String[] args) {
        
        String nome;
        Scanner lerFrase = new Scanner(System.in);
        System.out.println("Digite a frase: ");
        nome = lerFrase.nextLine();

        nome = nome.replaceAll("a","@");

        System.out.println(nome);

        lerFrase.close();
    }
}
