package SEMANA02.CONTEUDO.LISTA.teste;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Date dataVetor[] = new Date[10];
        int dia, mes, ano, i;
        Scanner lerData = new Scanner(System.in);
        
        for (i = 0; i < 10; i++){
            dia = lerData.nextInt();
            mes = lerData.nextInt();
            ano = lerData.nextInt();

            dataVetor[i] = new Date();
            dataVetor[i].armazenar(dia, mes, ano);
            dataVetor[i].imprimir();
        }

        lerData.close();
    }
}
