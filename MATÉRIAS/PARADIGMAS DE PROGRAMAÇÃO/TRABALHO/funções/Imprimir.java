package TRABALHO.funções;

import java.util.Scanner;

import TRABALHO.personagens.*;
import TRABALHO.setores.Setor;

public class Imprimir {

    public char mostrarMenu(Setor[][] tabuleiro, int linha, int coluna, int numeroJogador, String tipoMenu,
            Jogador jogador) {

        int qtdInimigos, contador;
        char opção, ladosSetor[];
        boolean p1NoSetor;
        String setorPrivado;
        Inimigo inimigos[];
        Scanner input = new Scanner(System.in);

        setorPrivado = tabuleiro[linha][coluna].getClass().getSimpleName();
        ladosSetor = tabuleiro[linha][coluna].getLadosSetor();
        qtdInimigos = tabuleiro[linha][coluna].getQuantidadeInimigos();
        inimigos = new Inimigo[qtdInimigos];
        inimigos = tabuleiro[linha][coluna].getInimigos();
        p1NoSetor = (linha == jogador.getLinha() && coluna == jogador.getColuna()) ? true : false;

        if (tipoMenu == "Menu movimentos") {
            System.out.printf("Para onde vai o Player %d (P%d)\n", numeroJogador, numeroJogador);
            if (ladosSetor[0] != '-')
                System.out.println("  U - Up");
            if (ladosSetor[0] != '-')
                System.out.println("  D - Down");
            if (ladosSetor[0] != '|')
                System.out.println("  L - Left");
            if (ladosSetor[0] != '|')
                System.out.println("  R - Right");
        } else if (tipoMenu == "Menu escolha inimigo") {
            System.out.printf("Escolha qual inimigo quer atacar (P%d):\n", numeroJogador);
            for (contador = 0; contador < qtdInimigos; contador++) {
                if (inimigos[contador].isEstaVivo() == true)
                    if (contador == 0)
                        System.out.printf("  a - Inimigo\n");
                    else if (contador == 1)
                        System.out.printf("  b - Inimigo\n");
                    else
                        System.out.printf("  c - Inimigo\n");
            }
        } else {
            System.out.printf("Escolha sua ação Player %d (P%d)\n", numeroJogador, numeroJogador);
            if (tipoMenu == "Menu ações 1")
                System.out.println("  A - Atacar");
            else
                System.out.println("  M - Movimentar");
            if (setorPrivado.intern() != "SetorPrivado")
                System.out.println("  P - Procurar");
            if (numeroJogador == 2) {
                if (p1NoSetor)
                    System.out.println("  R - Recuperar defesa P1");
                System.out.println("  S - Recuperar defesa P2");
            }
        }

        opção = input.next().charAt(0);
        return opção;
    }

    private void mostrarInimigosSetor(int qtdInimigosSetor, Inimigo inimigosSetor[]) {

        if (qtdInimigosSetor == 1) {
            System.out.printf("| %d/%d         |      ", inimigosSetor[0].getAtaque(),
                    inimigosSetor[0].getDefesa());
        } else if (qtdInimigosSetor == 2) {
            System.out.printf("| %d/%d %d/%d     |      ", inimigosSetor[0].getAtaque(),
                    inimigosSetor[0].getDefesa(), inimigosSetor[1].getAtaque(),
                    inimigosSetor[1].getDefesa());
        } else if (qtdInimigosSetor == 3) {
            System.out.printf("| %d/%d %d/%d %d/%d |      ", inimigosSetor[0].getAtaque(),
                    inimigosSetor[0].getDefesa(), inimigosSetor[1].getAtaque(),
                    inimigosSetor[1].getDefesa(), inimigosSetor[2].getAtaque(),
                    inimigosSetor[2].getDefesa());
        } else {
            System.out.printf("|             |      ");
        }
    }

    private void mostrarSetor(int linha, int linhaPorta, Personagem jogadores[], Setor[][] tabuleiro) {

        boolean jogadoresMesmoSetor;
        int linhaP1, linhaP2, colunaP1, colunaP2, qtdInimigosSetor1, qtdInimigosSetor2;
        char ladosSetor1[], ladosSetor2[];
        Inimigo inimigosSetor1[], inimigosSetor2[];

        linhaP1 = jogadores[0].getLinha();
        linhaP2 = jogadores[1].getLinha();
        colunaP1 = jogadores[0].getColuna();
        colunaP2 = jogadores[1].getColuna();

        ladosSetor1 = tabuleiro[linhaP1][colunaP1].getLadosSetor();
        ladosSetor2 = tabuleiro[linhaP2][colunaP2].getLadosSetor();

        qtdInimigosSetor1 = tabuleiro[linhaP1][colunaP1].getQuantidadeInimigos();
        qtdInimigosSetor2 = tabuleiro[linhaP2][colunaP2].getQuantidadeInimigos();
        inimigosSetor1 = tabuleiro[linhaP1][colunaP1].getInimigos();
        inimigosSetor2 = tabuleiro[linhaP2][colunaP2].getInimigos();

        jogadoresMesmoSetor = (linhaP1 == linhaP2) && (colunaP1 == colunaP2) ? true : false;

        if (linha == 0 && linhaPorta == 1) {
            if (jogadoresMesmoSetor)
                System.out.printf("  Setor [%d,%d]  ", linhaP1 + 1, colunaP1 + 1);
            else
                System.out.printf("  Setor [%d,%d]          Setor [%d,%d]", linhaP1 + 1, colunaP1 + 1, linhaP2 + 1,
                        colunaP2 + 1);
        } else if (linha == 1 && linhaPorta == 1) {
            if (jogadoresMesmoSetor)
                System.out.printf("|------%c------|", ladosSetor1[0]);
            else
                System.out.printf("|------%c------|      |------%c------|", ladosSetor1[0], ladosSetor2[0]);
        } else if (linha == 1 && linhaPorta == 2) {
            if (jogadoresMesmoSetor) {
                mostrarInimigosSetor(qtdInimigosSetor1, inimigosSetor1);
            } else {
                mostrarInimigosSetor(qtdInimigosSetor1, inimigosSetor1);
                mostrarInimigosSetor(qtdInimigosSetor2, inimigosSetor2);
            }
        } else if (linha == 2 && linhaPorta == 1) {
            if (jogadoresMesmoSetor)
                System.out.printf("|             |");
            else
                System.out.printf("|             |      |             |");
        } else if (linha == 2 && linhaPorta == 2) {
            if (jogadoresMesmoSetor)
                System.out.printf("%c             %c", ladosSetor1[1], ladosSetor1[3]);
            else
                System.out.printf("%c             %c      %c             %c", ladosSetor1[1], ladosSetor1[3],
                        ladosSetor2[1], ladosSetor2[3]);
        } else if (linha == 3 && linhaPorta == 1) {
            if (jogadoresMesmoSetor)
                System.out.printf("|  P1    P2   |");
            else
                System.out.printf("|  P1         |      |  P2         |");
        } else if (linha == 3 && linhaPorta == 2) {
            if (jogadoresMesmoSetor)
                System.out.printf("|  %d/%d   %d/%d  |", ((JogadorSimples) jogadores[0]).getAtaque(),
                        ((JogadorSimples) jogadores[0]).getDefesa(),
                        ((JogadorSuporte) jogadores[1]).getAtaque(), ((JogadorSuporte) jogadores[1]).getDefesa());
            else
                System.out.printf("|  %d/%d        |      |  %d/%d        |",
                        ((JogadorSimples) jogadores[0]).getAtaque(),
                        ((JogadorSimples) jogadores[0]).getDefesa(), ((JogadorSuporte) jogadores[1]).getAtaque(),
                        ((JogadorSuporte) jogadores[1]).getDefesa());
        } else if (linha == 4 && linhaPorta == 1) {
            if (jogadoresMesmoSetor)
                System.out.printf("|------%c------|", ladosSetor1[2]);
            else
                System.out.printf("|------%c------|      |------%c------|", ladosSetor1[2], ladosSetor2[2]);
        } else {
            System.out.printf("  ");
        }
    }

    private void mostrarTabuleiro(Setor[][] tabuleiro, Personagem jogadores[], Posição posX) {

        boolean mostrarSetorAtual, mostrarProxSetor, mostrarSetorAnterior, jogadorSuporte, jogadorSimples, posiçãoX;
        int linha, coluna, linhaPorta;
        char ladosSetor[];

        linha = 0;
        linhaPorta = 0;

        System.out.println("----------------------------");
        System.out.println("|   Antivírus por um dia   |");
        System.out.println("----------------------------");
        System.out.println("      1   2   3   4   5     ");
        System.out.println("    |---|---|---|---|---|   ");

        while (linha < 5) {

            // Numeração das linhas
            if (linhaPorta == 1) {
                System.out.printf("    ");
                linhaPorta++;
            } else {
                System.out.printf("%d   ", linha + 1);
                linhaPorta++;
            }

            for (coluna = 0; coluna < 5; coluna++) {
                // Verifica se o jogador simples está no setor
                jogadorSimples = ((jogadores[0].getLinha() == linha && jogadores[0].getColuna() == coluna) ? true
                        : false);
                // Verifica se o jogador suporte está no setor
                jogadorSuporte = ((jogadores[1].getLinha() == linha && jogadores[1].getColuna() == coluna) ? true
                        : false);
                // Verifica se é a posição de saída: X
                posiçãoX = ((posX.getLinha() == linha && posX.getColuna() == coluna) ? true
                        : false);

                mostrarSetorAtual = tabuleiro[linha][coluna].isMostrarSetor();
                ladosSetor = tabuleiro[linha][coluna].getLadosSetor();

                // Linhas das paredes verticais
                if (linhaPorta == 1) {
                    if (coluna == 4)
                        mostrarProxSetor = false;
                    else
                        mostrarProxSetor = tabuleiro[linha][coluna + 1].isMostrarSetor();

                    // Se for pra mostrar o setor mostra as paredes com as portas se não mostra
                    // somente as paredes
                    if (mostrarSetorAtual) {
                        // Coloca a parede da esquerda
                        System.out.printf("%c", ladosSetor[1]);

                        // Coloca os Jogadores no Centro do setor se tiverem no setor
                        if (jogadorSimples && jogadorSuporte)
                            System.out.printf("P12");
                        else if (jogadorSimples)
                            System.out.printf("P1 ");
                        else if (jogadorSuporte)
                            System.out.printf("P2 ");
                        else if (posiçãoX)
                            System.out.printf(" X ");
                        else if (linha == 2 && coluna == 2)
                            System.out.printf(" C ");
                        else
                            System.out.printf("   ");

                        // Coloca a parede da Direita
                        if (!mostrarProxSetor)
                            System.out.printf("%c", ladosSetor[3]);
                    } else {
                        if (coluna > 0)
                            mostrarSetorAnterior = tabuleiro[linha][coluna - 1].isMostrarSetor();
                        else
                            mostrarSetorAnterior = false;

                        if (!mostrarSetorAnterior)
                            System.out.printf("|");
                        if (posiçãoX)
                            System.out.printf(" X ");
                        else
                            System.out.printf("   ");
                    }
                } else {
                    if (linha == 4)
                        mostrarProxSetor = false;
                    else
                        mostrarProxSetor = tabuleiro[linha + 1][coluna].isMostrarSetor();

                    if (!mostrarSetorAtual) {
                        if (mostrarProxSetor) {
                            if (linha == 1 && coluna == 2)
                                System.out.printf("|-*-");
                            else
                                System.out.printf("|-%c-", ladosSetor[2]);
                        } else {
                            System.out.printf("|---");
                        }
                    } else
                        System.out.printf("|-%c-", ladosSetor[2]);
                }
                if (coluna == 4) {
                    System.out.printf("|      ");
                    mostrarSetor(linha, linhaPorta, jogadores, tabuleiro);
                }
            }

            System.out.printf("\n");
            if (linhaPorta == 2) {
                linha++;
                linhaPorta = 0;
            }
        }
        System.out.printf("\n");
    }

    public void mostrar(Setor[][] tabuleiro, Personagem jogadores[], Posição posX) {

        System.out.print("\033[H\033[2J");
        System.out.flush();
        mostrarTabuleiro(tabuleiro, jogadores, posX);
    }
}
