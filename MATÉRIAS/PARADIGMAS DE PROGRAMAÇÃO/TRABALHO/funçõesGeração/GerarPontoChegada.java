package TRABALHO.funçõesGeração;

import java.util.Random;

import TRABALHO.funções.Posição;
import TRABALHO.setores.Setor;

public class GerarPontoChegada {

    // Gera um random para a posição do X
    public Posição gerarPosiçãoX(Setor[][] tabuleiro) {
        Random random;
        int posLinha, posColuna;
        random = new Random();
        Posição posTemp = new Posição(0, 0);

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
