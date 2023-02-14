package TRABALHO.funçõesGeração;

import java.util.ArrayList;
import java.util.Random;

import TRABALHO.funções.Posição;
import TRABALHO.personagens.*;
import TRABALHO.setores.Setor;

public class GerarPersonagens {

    // Inicializa os jogadores
    public void gerarJogadores(Jogador[] jogadores) {

        jogadores[0] = new JogadorSimples(2, 2, true, 2, 6);
        jogadores[1] = new JogadorSuporte(2, 2, true, 1, 7);
    }

    // Gera os inimigos no tabuleiro
    public void gerarInimigos(Setor[][] tabuleiro, Posição posiçãoX) {

        int linha, coluna, virus, contador;
        Random random;
        ArrayList<Inimigo> inimigos;
        Inimigo inimigo;

        random = new Random();

        for (linha = 0; linha < 5; linha++) {
            for (coluna = 0; coluna < 5; coluna++) {

                inimigos = new ArrayList<Inimigo>();
                // Não coloca inimigos na saída e no centro
                if ((posiçãoX.getLinha() != linha || posiçãoX.getColuna() != coluna) && (linha != 2 || coluna != 2)) {

                    tabuleiro[linha][coluna].setQuantidadeInimigos(random.nextInt(3) + 1);

                    for (contador = 0; contador < tabuleiro[linha][coluna].getQuantidadeInimigos(); contador++) {
                        virus = random.nextInt(3) + 1;
                        inimigo = new Inimigo(linha, coluna, true, virus, virus);
                        inimigos.add(inimigo);
                    }
                    tabuleiro[linha][coluna].setInimigos(inimigos);
                }
            }
        }
    }
}
