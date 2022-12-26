package SEMANA02.CONTEUDO.LISTA.exercicio;

import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        
        Data dataVetor[] = new Data[10];
        int dia, mes, ano, i;
        Scanner lerData = new Scanner(System.in);
        
        for (i = 0; i < 10; i++){
            dia = lerData.nextInt();
            mes = lerData.nextInt();
            ano = lerData.nextInt();

            dataVetor[i] = new Data();
            dataVetor[i].armazenar(dia, mes, ano);
            dataVetor[i].imprimir();
        }

        lerData.close();
    }
}
