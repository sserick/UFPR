package TRABALHO.personagens;

import TRABALHO.setores.Setor;

public class Jogador extends Personagem {

    public Jogador(int linha, int coluna, boolean estaVivo) {
        super(linha, coluna, estaVivo);
    }

    // Métodos
    public int movimentar(char jogada, Personagem jogador, Setor[][] tabuleiro) {

        int linha, coluna, opçãoValida;
        char[] ladosSetor;

        // Entra com a opção válida
        opçãoValida = 1;

        linha = jogador.getLinha();
        coluna = jogador.getColuna();
        ladosSetor = tabuleiro[linha][coluna].getLadosSetor();

        if (jogada == 'U' || jogada == 'u') {
            // Para cima
            if (ladosSetor[0] == '*') {
                tabuleiro[linha - 1][coluna].setMostrarSetor(true);
                jogador.setLinha(linha - 1);
            }
        } else if (jogada == 'D' || jogada == 'd') {
            // Para baixo
            if (ladosSetor[2] == '*') {
                tabuleiro[linha + 1][coluna].setMostrarSetor(true);
                jogador.setLinha(linha + 1);
            }
        } else if (jogada == 'L' || jogada == 'l') {
            // Para esquerda
            if (ladosSetor[1] == '*') {
                tabuleiro[linha][coluna - 1].setMostrarSetor(true);
                jogador.setColuna(coluna - 1);
            }
        } else if (jogada == 'R' || jogada == 'r') {
            // Para direita
            if (ladosSetor[3] == '*') {
                tabuleiro[linha][coluna + 1].setMostrarSetor(true);
                jogador.setColuna(coluna + 1);
            }
        } else {
            opçãoValida = 0;
            System.out.println("---------------------------------");
            System.out.println("Opção inválida, tente novamente!!");
            System.out.println("---------------------------------");
        }

        return opçãoValida;
    }

    public void ataqueJogador(int jogada, Setor[][] tabuleiro, int qualJogador) {
        int linha, coluna, inimigo, ataque;

        linha = this.getLinha();
        coluna = this.getColuna();
        if (qualJogador == 1)
            ataque = ((JogadorSimples) this).getAtaque();
        else
            ataque = ((JogadorSuporte) this).getAtaque();

        // Qual inimigo vai atacar
        if (jogada == 'a')
            inimigo = 0;
        else if (jogada == 'b')
            inimigo = 1;
        else
            inimigo = 2;

        tabuleiro[linha][coluna].atacar(inimigo, ataque);
    }
}
