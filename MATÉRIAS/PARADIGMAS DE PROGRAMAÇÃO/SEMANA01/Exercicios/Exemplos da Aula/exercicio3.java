public class exercicio3 {
    
    public static void main(String[] args) {

        int mult, soma;
        soma = 0;

        for (int i = 1; i <= 10; i++){
            mult = 3 * i;
            soma = soma + mult;
        }

        System.out.println("Soma: " + soma);
    }
}
