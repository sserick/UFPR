package TRABALHO;

import java.util.Scanner;

import TRABALHO.sectors.Sector;
import TRABALHO.personages.Personage;

public class ShowInfo {

    public String showMenu(int cycles, int player) {

        Scanner input = new Scanner(System.in);
        String option;

        if (cycles == 0) {
            System.out.printf("Para onde vai o Player %d (P%d)\n", player, player);
            System.out.println("  U - Up");
            System.out.println("  D - Down");
            System.out.println("  L - Left");
            System.out.println("  R - Right");

            option = input.nextLine();

        } else {
            option = " ";
        }

        return option;
    }

    public void showSector() {

    }

    public void showBoard(Sector[][] board) {

        boolean actual, next, prev;
        int lin, col, cont;
        char sides[];

        lin = 0;
        cont = 0;

        System.out.println("----------------------------");
        System.out.println("|   Antivírus por um dia   |");
        System.out.println("----------------------------");
        System.out.println("      1   2   3   4   5     ");
        System.out.println("    |---|---|---|---|---|   ");

        while (lin < 5) {

            if (cont == 1) {
                System.out.printf("    ");
                cont++;
            } else {
                System.out.printf("%d   ", lin + 1);
                cont++;
            }

            for (col = 0; col < 5; col++) {

                actual = board[lin][col].isShowSector();
                sides = board[lin][col].getSides();

                // Linhas das paredes verticais
                if (cont == 1) {
                    if (col == 4)
                        next = false;
                    else
                        next = board[lin][col + 1].isShowSector();

                    // Se for pra mostrar o setor mostra as paredes com as portas se não mostra
                    // somente as paredes
                    if (actual) {

                        // Coloca a parede da esquerda
                        System.out.printf("%c", sides[0]);

                        // Coloca os Jogadores no Centro do setor se tiverem no setor
                        if (board[lin][col].isHasSinglePlayer() && board[lin][col].isHasSupportPlayer()) {
                            System.out.printf("P12");
                        } else if (board[lin][col].isHasSinglePlayer()) {
                            System.out.printf("P1 ");
                        } else if (board[lin][col].isHasSupportPlayer()) {
                            System.out.printf("P2 ");
                        } else if (board[lin][col].isHasX()) {
                            System.out.printf(" X ");
                        } else if (board[lin][col].isCenter()) {
                            System.out.printf(" C ");
                        } else {
                            System.out.printf("   ");
                        }

                        // Coloca a parede da Direita
                        if (next == false) {
                            System.out.printf("%c", sides[3]);
                        }
                    } else {
                        if (col > 0)
                            prev = board[lin][col - 1].isShowSector();
                        else
                            prev = false;
                        if (prev == false)
                            System.out.printf("|");
                        if (board[lin][col].isHasX()) {
                            System.out.printf(" X ");
                        } else {
                            System.out.printf("   ");
                        }
                    }
                } else {
                    if (lin == 4)
                        next = false;
                    else
                        next = board[lin + 1][col].isShowSector();

                    if (!actual) {
                        if (next) {
                            if (lin == 1 && col == 2) {
                                System.out.printf("|-*-");
                            } else {
                                System.out.printf("|-%c-", sides[2]);
                            }
                        } else {
                            System.out.printf("|---");
                        }
                    } else {
                        System.out.printf("|-%c-", sides[2]);
                    }
                }

                if (col == 4) {
                    System.out.printf("|");
                }
            }

            System.out.printf("\n");
            if (cont == 2) {
                lin++;
                cont = 0;
            }
        }
        System.out.printf("\n");
    }

    public void show(Sector[][] board) {
        showBoard(board);
    }

}
