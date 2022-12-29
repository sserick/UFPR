package TRABALHO;

import java.util.Scanner;

import TRABALHO.personages.Personage;
import TRABALHO.personages.SinglePlayer;
import TRABALHO.personages.SupportPlayer;
import TRABALHO.sectors.Sector;

public class Main {

    public static void main(String[] args) {

        // Inicializando Funções usadas
        GenerateBoard generateBoard = new GenerateBoard();
        ShowInfo showBoard = new ShowInfo();
        Scanner input;

        // Atributos
        String choice;
        int cycles = 0;
        Sector board[][] = new Sector[5][5];
        Personage player1 = new SinglePlayer(2, 2, 2, 6, true);
        Personage player2 = new SupportPlayer(2, 2, 1, 7, true);

        // Iniciando o Tabuleiro
        generateBoard.generate(board);
        board[2][2].setHasSinglePlayer(true);
        board[2][2].setHasSupportPlayer(true);

        showBoard.show(board);

        while (cycles < 1) {

            if (cycles == 0) {
                choice = showBoard.showMenu(cycles, 1);

                player1.move(choice, player1, board);
                player2.move(choice, player2, board);

            } else {

            }

            cycles++;
        }

        showBoard.show(board);

    }
}
