package TRABALHO.personages;

import TRABALHO.sectors.Sector;

public class SinglePlayer extends Personage {

    // Construtor
    public SinglePlayer(int lin, int col, int attack, int defense, boolean isAlive) {
        super(lin, col, attack, defense, isAlive);
    }

    // Métodos
    @Override
    public void move(String choice, Personage player, Sector[][] board) {

        int lin, col;
        char[] sides;

        if (choice == "U" || choice == "u") {
            lin = player.getLin();
            col = player.getCol();
            sides = board[lin][col].getSides();

            if (sides[0] == '*') {
                board[lin][col].setHasSinglePlayer(false);
                board[lin - 1][col].setHasSinglePlayer(true);

                board[lin - 1][col].setShowSector(true);

                player.setLin(lin - 1);
            } else {

            }

        } else if (choice == "D") {

        } else if (choice == "L") {

        } else if (choice == "R") {
            System.out.println("Opção inválida");
        }
    }

    @Override
    public void attack() {

    }

    @Override
    public void search() {

    }
}
