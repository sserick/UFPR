package TRABALHO.funcaoGeracao;

import java.util.Random;

import TRABALHO.setores.*;

public class GerarLadosSetor {

    // Gera um random para ver se será parede ou porta
    // Se 0 será parede, se 1 será porta
    private char randomPortaParede(String tipo) {
        Random random;
        int portaParede;

        random = new Random();
        portaParede = random.nextInt(2);

        if (portaParede == 0 && tipo == "direita")
            return '|';
        else if (portaParede == 0 && tipo == "baixo")
            return '-';
        else
            return '*';
    }

    // Gera um random para o tipo de setor
    private Setor tipoSetor(int linha, int coluna, char ladosSetor[]) {

        Random random;
        int tipoSetor;
        Setor setorTemporario;
        boolean mostrarSetor = false;

        random = new Random();
        tipoSetor = random.nextInt(3);

        // Se for centro deixar para mostrar o setor e colocar que é centro
        if (linha == 2 && coluna == 2)
            mostrarSetor = true;

        // Se 0 - setor normal, se 1 - setor oculto, se 2 - setor privado
        // Seta com os lados do setor
        if (tipoSetor == 0)
            setorTemporario = new SetorNormal(linha, coluna, ladosSetor, mostrarSetor);
        else if (tipoSetor == 1)
            setorTemporario = new SetorOculto(linha, coluna, ladosSetor, mostrarSetor);
        else
            setorTemporario = new SetorPrivado(linha, coluna, ladosSetor, mostrarSetor);

        return setorTemporario;
    }

    // Coloca os lados do setor no vetor
    private char[] inserirLados(char cima, char esquerda, char baixo, char direita) {
        char ladosSetor[] = new char[4];

        ladosSetor[0] = cima;
        ladosSetor[1] = esquerda;
        ladosSetor[2] = baixo;
        ladosSetor[3] = direita;

        return ladosSetor;
    }

    // Gerar os lados do tabuleiro
    public void gerarLados(Setor[][] tabuleiro) {

        char ladoCima, ladoBaixo, ladoDireita, ladoEsquerda, ladosAnterior[];
        int linha, coluna;

        for (linha = 0; linha < 5; linha++) {
            for (coluna = 0; coluna < 5; coluna++) {

                ladoCima = ladoBaixo = '-';
                ladoDireita = ladoEsquerda = '|';

                if (coluna > 0) {
                    ladosAnterior = tabuleiro[linha][coluna - 1].getLadosSetor();
                    ladoEsquerda = ladosAnterior[3];
                }
                if (linha > 0) {
                    ladosAnterior = tabuleiro[linha - 1][coluna].getLadosSetor();
                    ladoCima = ladosAnterior[2];
                }
                if (coluna < 4) {
                    if ((coluna == 1 || coluna == 2) && linha == 2)
                        ladoDireita = '*';
                    else
                        ladoDireita = randomPortaParede("direita");
                }
                if (linha < 4) {
                    if ((linha == 1 || linha == 2) && coluna == 2)
                        ladoBaixo = '*';
                    else
                        ladoBaixo = randomPortaParede("baixo");
                }

                tabuleiro[linha][coluna] = tipoSetor(linha, coluna,
                        inserirLados(ladoCima, ladoEsquerda, ladoBaixo, ladoDireita));
            }
        }
    }
}