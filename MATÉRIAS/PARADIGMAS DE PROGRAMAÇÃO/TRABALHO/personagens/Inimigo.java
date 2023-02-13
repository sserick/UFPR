package TRABALHO.personagens;

import java.util.Random;

public class Inimigo extends Personagem {

    // Atributos
    protected int ataque;
    protected int defesa;

    // Construtor
    public Inimigo(int linha, int coluna, boolean estaVivo, int ataque, int defesa) {
        super(linha, coluna, estaVivo);
        this.ataque = ataque;
        this.defesa = defesa;
    }

    // Getters e Setters
    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        if (ataque >= 0 && ataque <= 3)
            this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        if (defesa >= 0 && defesa <= 3)
            this.defesa = defesa;
    }

    // Ataque realizado pelo inimigo ao jogador
    public void ataqueInimigo(Jogador jogador, int qualJogador) {

        int defesaJogador, ataqueInimigo, vaiAtacar;
        Random random = new Random();

        if (qualJogador == 0)
            defesaJogador = ((JogadorSimples) jogador).getDefesa();
        else
            defesaJogador = ((JogadorSuporte) jogador).getDefesa();
        ataqueInimigo = this.ataque;
        vaiAtacar = random.nextInt(6) + 1;

        if (vaiAtacar == 2 || vaiAtacar == 4 || vaiAtacar == 6) {
            defesaJogador = defesaJogador - ataqueInimigo;
            if (defesaJogador < 0) {
                defesaJogador = 0;
                jogador.setEstaVivo(false);
            }
            if (qualJogador == 0)
                ((JogadorSimples) jogador).setDefesa(defesaJogador);
            else
                ((JogadorSuporte) jogador).setDefesa(defesaJogador);
        }
    }
}
