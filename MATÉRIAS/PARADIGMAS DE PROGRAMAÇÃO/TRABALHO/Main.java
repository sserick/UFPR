package TRABALHO;

import TRABALHO.funções.*;
import TRABALHO.funçõesGeração.*;
import TRABALHO.personagens.*;
import TRABALHO.setores.Setor;

public class Main {

    public static void main(String[] args) {

        // Inicializando Funções usadas
        GerarTabuleiro gerarTabuleiro = new GerarTabuleiro(null);
        Imprimir mostrarTabuleiro = new Imprimir();
        VerificarRegras verificações = new VerificarRegras();

        // Atributos
        char jogada;
        int i, ação, opçãoInvalida, linha, coluna, qtdInimigos, contador, ciclos = 0;
        boolean estaVivo, finalizado, ganhou[] = new boolean[2];
        Setor tabuleiro[][] = new Setor[5][5];
        Jogador jogadores[] = new Jogador[2];
        Inimigo inimigo[];
        Posição posX;

        // Inicializando atributos
        finalizado = true;
        ganhou[0] = ganhou[1] = false;

        // Iniciando o Tabuleiro
        gerarTabuleiro.gerarTabuleiro(tabuleiro, jogadores);
        posX = gerarTabuleiro.getPosiçãoX();

        // Turnos
        while (finalizado != false) {

            // Ações dos jogadores
            if (ciclos == 0) {
                // Turno 0
                mostrarTabuleiro.mostrar(tabuleiro, jogadores, posX);
                for (ação = 0; ação < 2; ação++) {
                    opçãoInvalida = 0;
                    while (opçãoInvalida != 1) {
                        jogada = mostrarTabuleiro.mostrarMenu(tabuleiro, 2, 2, ação + 1, "Menu movimentos",
                                jogadores[0]);
                        opçãoInvalida = jogadores[ação].movimentar(jogada, jogadores[ação], tabuleiro);
                        ganhou[ação] = ((posX.getLinha() == jogadores[ação].getLinha()
                                && posX.getColuna() == jogadores[ação].getColuna()) ? true : false);
                    }
                }
            } else {

                // Escolha dos jogadores (P1 e P2)
                for (i = 0; i < 2; i++) {
                    // As duas ações de cada jogador
                    for (ação = 0; ação < 2; ação++) {
                        estaVivo = false;
                        linha = jogadores[i].getLinha();
                        coluna = jogadores[i].getColuna();
                        inimigo = tabuleiro[linha][coluna].getInimigos();
                        qtdInimigos = tabuleiro[linha][coluna].getQuantidadeInimigos();

                        // Verifica se os inimigos estão vivos
                        for (contador = 0; contador < qtdInimigos; contador++) {
                            if (inimigo[contador].isEstaVivo() != false)
                                estaVivo = true;
                        }

                        if (estaVivo == true) {
                            jogada = mostrarTabuleiro.mostrarMenu(tabuleiro, linha, coluna, i + 1, "Menu ações 1",
                                    jogadores[0]);

                            if (jogada == 'A' || jogada == 'a') {
                                // Atacar
                                jogada = mostrarTabuleiro.mostrarMenu(tabuleiro, linha, coluna, i + 1,
                                        "Menu escolha inimigo", jogadores[0]);
                                jogadores[i].ataqueJogador(jogada, tabuleiro, i + 1);

                            } else if (jogada == 'P' || jogada == 'p') {
                                // Procurar
                                tabuleiro[linha][coluna].procurar(tabuleiro, jogadores[i]);
                            } else if (jogada == 'R' || jogada == 'r' || jogada == 'S' || jogada == 's') {
                                // Recuperar defesa
                                if (jogada == 'R' || jogada == 'r')
                                    ((JogadorSuporte) jogadores[0]).recuperar(jogada, jogadores[0]);
                                else
                                    ((JogadorSuporte) jogadores[0]).recuperar(jogada, jogadores[1]);
                            }
                        } else {
                            jogada = mostrarTabuleiro.mostrarMenu(tabuleiro, linha, coluna, i + 1, "Menu ações 2",
                                    jogadores[0]);

                            if (jogada == 'P' || jogada == 'p') {
                                // Procurar
                                tabuleiro[linha][coluna].procurar(tabuleiro, jogadores[i]);

                            } else if (jogada == 'R' || jogada == 'r' || jogada == 'S' || jogada == 's') {
                                // Recuperar defesa
                                if (jogada == 'R' || jogada == 'r')
                                    ((JogadorSuporte) jogadores[0]).recuperar(jogada, jogadores[0]);
                                else
                                    ((JogadorSuporte) jogadores[0]).recuperar(jogada, jogadores[1]);
                            } else {
                                // Movimentar
                                opçãoInvalida = 0;
                                while (opçãoInvalida != 1) {
                                    jogada = mostrarTabuleiro.mostrarMenu(tabuleiro, linha, coluna, i + 1,
                                            "Menu movimentos", jogadores[0]);
                                    opçãoInvalida = jogadores[i].movimentar(jogada, jogadores[i], tabuleiro);
                                    ganhou[i] = ((posX.getLinha() == jogadores[i].getLinha()
                                            && posX.getColuna() == jogadores[i].getColuna()) ? true : false);
                                }
                            }
                        }
                        mostrarTabuleiro.mostrar(tabuleiro, jogadores, posX);
                    }
                }

                // Ação dos inimigos - ataque
                for (i = 0; i < 2; i++) {
                    linha = jogadores[i].getLinha();
                    coluna = jogadores[i].getColuna();
                    inimigo = tabuleiro[linha][coluna].getInimigos();
                    qtdInimigos = tabuleiro[linha][coluna].getQuantidadeInimigos();

                    for (contador = 0; contador < qtdInimigos; contador++) {
                        if (inimigo[contador].isEstaVivo())
                            inimigo[contador].ataqueInimigo(jogadores[i], i);
                    }

                }
            }

            ciclos++;
            mostrarTabuleiro.mostrar(tabuleiro, jogadores, posX);
            finalizado = verificações.verificarJogoTerminou(ciclos, ganhou, jogadores);
        }
    }
}
