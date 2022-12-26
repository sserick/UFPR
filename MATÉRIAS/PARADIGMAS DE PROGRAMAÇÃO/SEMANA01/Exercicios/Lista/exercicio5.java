import java.util.Scanner;

public class exercicio5 {
    
    public static void main(String[] args) {
        
        int x;
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        x = inputScanner.nextInt();

        if (x >= 0 && x < 5){
            System.out.println("Resultado: " + x);
        } else if (x >= 5 && x < 10) {
            System.out.println("Resultado: " + (2 * x + 1));
        } else {
            System.out.println("Resultado: " + (x - 3));
        }

        inputScanner.close();
    }
}
