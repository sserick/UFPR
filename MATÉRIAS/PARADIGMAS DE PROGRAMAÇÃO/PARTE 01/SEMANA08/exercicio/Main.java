package SEMANA08.exercicio;

public class Main {
    
    public static void main(String[] args) {

        Imovel[] imoveis = new Imovel[200];
        int i;

        for (i = 0; i < 200; i++){

            System.out.println("");
            
                imoveis[i] = new ImovelNovo(null, null);
        }

    }
}
