package TRABALHO.setores;

import java.util.Random;

import TRABALHO.funções.Posição;
import TRABALHO.personagens.*;

public class Setor extends Posição {

    // Atributos
    protected char[] ladosSetor;
    protected int quantidadeInimigos;
    protected Inimigo[] inimigos;
    protected boolean mostrarSetor;

    // Construtor
    public Setor(int linha, int coluna, char[] ladosSetor, int quantidadeInimigos, Inimigo[] inimigos,
            boolean mostrarSetor) {
        super(linha, coluna);
        this.ladosSetor = ladosSetor;
        this.quantidadeInimigos = quantidadeInimigos;
        this.inimigos = inimigos;
        this.mostrarSetor = mostrarSetor;
    }

    // Getters e Setters
    public char[] getLadosSetor() {
        return ladosSetor;
    }

    public void setLadosSetor(char[] ladosSetor) {
        this.ladosSetor = ladosSetor;
    }

    public int getQuantidadeInimigos() {
        return quantidadeInimigos;
    }

    public void setQuantidadeInimigos(int quantidadeInimigos) {
        if (quantidadeInimigos >= 0 && quantidadeInimigos <= 3)
            this.quantidadeInimigos = quantidadeInimigos;
    }

    public Inimigo[] getInimigos() {
        return inimigos;
    }

    public void setInimigos(Inimigo[] inimigos) {
        this.inimigos = inimigos;
    }

    public boolean isMostrarSetor() {
        return mostrarSetor;
    }

    public void setMostrarSetor(boolean mostrarSetor) {
        this.mostrarSetor = mostrarSetor;
    }

    // Métodos
    public void atacar(int inimigo, int ataqueJogador) {

        int defesaInimigo;

        defesaInimigo = this.inimigos[inimigo].getDefesa();
        defesaInimigo = defesaInimigo - ataqueJogador;

        if (defesaInimigo <= 0) {
            defesaInimigo = 0;
            this.inimigos[inimigo].setEstaVivo(false);
        }

        this.inimigos[inimigo].setDefesa(defesaInimigo);
    }

    // Procurar no setor
    public void procurar(Setor[][] tabuleiro, Jogador jogador) {
        Random random;
        random = new Random();
        int gerarNumero, ganharDefesa, perderDefesa, linha, coluna, QuantidadeInimigos, contador;
        Inimigo[] inimigos;

        gerarNumero = random.nextInt(6) + 1;
        linha = jogador.getLinha();
        coluna = jogador.getColuna();
        QuantidadeInimigos = tabuleiro[linha][coluna].getQuantidadeInimigos();
        inimigos = new Inimigo[QuantidadeInimigos];
        inimigos = tabuleiro[linha][coluna].getInimigos();

        if (jogador.getClass().getSimpleName() == "JogadorSimples")
            ganharDefesa = ((JogadorSimples) jogador).getDefesa();
        else
            ganharDefesa = ((JogadorSuporte) jogador).getDefesa();

        if (gerarNumero >= 1 && gerarNumero <= 3) {
            System.out.println("---------------------------------");
            System.out.println("   Nada encontrado no setor!!    ");
            System.out.println("---------------------------------");
        } else if (gerarNumero == 4) {
            ganharDefesa = +1;
        } else if (gerarNumero == 5) {
            ganharDefesa = +2;
        } else {
            for (contador = 0; contador < QuantidadeInimigos; contador++) {
                perderDefesa = inimigos[contador].getDefesa();
                perderDefesa = -1;
                if (perderDefesa < 0)
                    perderDefesa = 0;
                inimigos[contador].setDefesa(perderDefesa);
                if (inimigos[contador].getDefesa() == 0)
                    inimigos[contador].setEstaVivo(false);
            }
        }

        if (gerarNumero == 4 || gerarNumero == 5) {
            if (jogador.getClass().getSimpleName() == "JogadorSimples")
                ((JogadorSimples) jogador).setDefesa(ganharDefesa);
            else
                ((JogadorSuporte) jogador).setDefesa(ganharDefesa);
        }
    }
}
