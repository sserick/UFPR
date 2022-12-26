import java.util.Scanner;

public class exercicio1 {
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        int numero;

        Scanner lerNumero = new Scanner(System.in);
        System.out.print("Digite um número: ");
        numero = lerNumero.nextInt();
    
        if (numero >= 0){
            System.out.println("Esse número é positivo!");
        } else {
            System.out.println("Esse número é negativo!");
        }

        lerNumero.close();
    }
}
