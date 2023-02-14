package TRABALHO.funções;

import TRABALHO.personagens.*;

public class VerificarRegras {

    public boolean verificarJogoTerminou(int ciclos, boolean ganhou[], Jogador jogadores[]) {

        int defesaP1, defesaP2;
        boolean continuarJogo, jogadoresPerderam, p1Morreu, p1Ganhou, p2Ganhou;

        defesaP1 = ((JogadorSimples) jogadores[0]).getDefesa();
        defesaP2 = ((JogadorSuporte) jogadores[1]).getDefesa();

        // Verifica se o ciclo é >= 25 e se ninguém ganhou
        continuarJogo = (ciclos < 25 && (!ganhou[0] && !ganhou[1]) && defesaP1 != 0) ? true : false;
        // Verifica se as defesas são iguais a zero: os dois perdem
        jogadoresPerderam = (defesaP1 == 0 && defesaP2 == 0) ? true : false;
        // Verifica se a defesa de P1 é igual a zero
        p1Morreu = (defesaP1 == 0 && defesaP2 != 0) ? true : false;
        // Verifica se P1 chegou a X
        p1Ganhou = (ganhou[0]) ? true : false;
        // Verifica se P2 chegou a X
        p2Ganhou = (ganhou[1]) ? true : false;

        if (continuarJogo) {
            return true;
        } else {
            if (ciclos >= 25) {
                System.out.println("--------------------------------------");
                System.out.println("Perderam, número de ciclos atingidos!!");
                System.out.println("--------------------------------------");
            } else if (jogadoresPerderam) {
                System.out.println("--------------------------------------");
                System.out.println("       Perderam, pois morreram        ");
                System.out.println("--------------------------------------");
            } else if (p1Morreu) {
                jogadores[1].setEstaVivo(false);
                System.out.println("--------------------------------------");
                System.out.println("       Perderam, pois P1 morreu       ");
                System.out.println("--------------------------------------");
            } else if (p1Ganhou) {
                System.out.println("---------------------------------");
                System.out.println("           P1 ganhou!!           ");
                System.out.println("---------------------------------");
            } else if (p2Ganhou) {
                System.out.println("---------------------------------");
                System.out.println("           P2 ganhou!!           ");
                System.out.println("---------------------------------");
            }
            return false;
        }
    }
}
