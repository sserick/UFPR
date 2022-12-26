import java.util.Scanner;

public class exercicio8 {
    
    public static void main(String[] args) {
        
        int peso, cont, altura, imc;
        cont = 0;

        Scanner lerNumero = new Scanner(System.in);

        while (true){
            System.out.print("Digite o seu peso: ");
            peso = lerNumero.nextInt();
            if (peso == -1){
                break;
            }
            System.out.print("Digite a sua altura (cm): ");
            altura = lerNumero.nextInt();
            if (altura == -1){
                break;
            }

            imc = peso/((altura*altura)/10000);

            if (imc > 25){
                cont = cont + 1;
            }
        }

        System.out.println("A quantidade de pessoas acima do peso é: " + cont);

        lerNumero.close();
    }
}
