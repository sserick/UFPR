import java.util.Scanner;

public class exercicio7 {
    
    public static void main(String[] args) {
        
        String nome;
        int tam, space, i;

        Scanner lerFrase = new Scanner(System.in);
        System.out.println("Digite a frase: ");
        nome = lerFrase.nextLine();
        tam = nome.length();
        space = nome.indexOf(" ") + 1;

        for (i = space; i <= tam - 1; i++){
            System.out.print(nome.charAt(i));
        }

        System.out.println(", " + nome.charAt(0) + ".");

        lerFrase.close();
    }
}
