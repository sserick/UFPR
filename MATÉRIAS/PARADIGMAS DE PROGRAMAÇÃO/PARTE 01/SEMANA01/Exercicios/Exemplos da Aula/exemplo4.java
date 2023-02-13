import java.util.Scanner;

public class exemplo4 {
    
    public static void main(String[] args) {
        int num;

        Scanner lerNumero = new Scanner(System.in);
        System.out.print("Digite um número: ");
        num = lerNumero.nextInt();

        for (int i = 1; i <= 10; i++){
            int mult = num * i;
            System.out.println(num + " * " + i + " = " + mult);
        }

        lerNumero.close();
    }
}
