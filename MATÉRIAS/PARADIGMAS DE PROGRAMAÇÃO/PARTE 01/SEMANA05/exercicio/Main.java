package SEMANA05.exercicio;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        CartaoWeb[] cartoesWeb = new CartaoWeb[3];
        int i, tipoCartao;
        String destinatario, remetente;
        Scanner input = new Scanner(System.in);

        for(i = 0; i < 3; i++){
            System.out.println("Escolha o tipo de Cartão (Número):\n1- Dia dos Namorados\n2- Natal\n3- Aniversário");
            tipoCartao = Integer.parseInt(input.nextLine());
            
            System.out.println("Quem é Destinatario?");
            destinatario = input.nextLine();

            System.out.println("Quem é Remetente?");
            remetente = input.nextLine();
    
            if (tipoCartao == 1){
                cartoesWeb[i] = new CartaoDiaDosNamorados(destinatario);
                cartoesWeb[i].retornarMensagem(remetente);
            } else if (tipoCartao == 2){
                cartoesWeb[i] = new CartaoNatal(destinatario);
                cartoesWeb[i].retornarMensagem(remetente);
            } else if (tipoCartao == 3){
                cartoesWeb[i] = new CartaoAniversario(destinatario);
                cartoesWeb[i].retornarMensagem(remetente);
            } else {
                System.out.println("Não existe essa possibilidade de cartão");
            }
        }

        input.close();
    }
}
