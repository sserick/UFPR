public class exercicio4 {
 
    public static void main(String[] args) {
        
        String nome = "Engenharia de Software";
        int tam = nome.length();

        for (int i = tam - 1; i >= 0; i--){
            System.out.print(nome.charAt(i));
        }

        System.out.print("\n");
    }
}
