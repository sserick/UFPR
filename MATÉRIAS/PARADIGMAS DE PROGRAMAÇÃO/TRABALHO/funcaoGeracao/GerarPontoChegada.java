package TRABALHO.funcaoGeracao;

import java.util.Random;

import TRABALHO.funcoes.Posicao;
import TRABALHO.setores.Setor;

public class GerarPontoChegada {

    // Gera um random para a posição do X
    public Posicao gerarPosiçãoX(Setor[][] tabuleiro) {
        Random random;
        int posLinha, posColuna;
        random = new Random();
        Posicao posTemp = new Posicao(0, 0);

        posLinha = random.nextInt(5);
        posColuna = random.nextInt(5);

        // Não colocar o X no centro
        while (posLinha == 2 && posColuna == 2) {
            posLinha = random.nextInt(5);
            posColuna = random.nextInt(5);
        }

        posTemp.setLinha(posLinha);
        posTemp.setColuna(posColuna);

        return posTemp;
    }
}
