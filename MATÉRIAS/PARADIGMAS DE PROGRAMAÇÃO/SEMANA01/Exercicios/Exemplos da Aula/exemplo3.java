import java.util.Scanner;

public class exemplo3 {
    
    public static void main(String[] args) {
        
        int num1, num2;
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite os dois números: ");
        num1 = teclado.nextInt();
        num2 = teclado.nextInt();

        if (num1 > num2){
            System.out.println(num2 + " " + num1);
        } else {
            System.out.println(num1 + " " + num2);
        }

        teclado.close();
    }
}
