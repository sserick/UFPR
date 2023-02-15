package TRABALHO.setores;

import java.util.ArrayList;
import java.util.Random;

import TRABALHO.personagens.*;

public class SetorOculto extends Setor {

    public SetorOculto(int linha, int coluna, char[] ladosSetor, int quantidadeInimigos, ArrayList<Inimigo> inimigos,
            boolean mostrarSetor) {
        super(linha, coluna, ladosSetor, quantidadeInimigos, inimigos, mostrarSetor);
    }

    public SetorOculto(int linha, int coluna, char[] ladosSetor, boolean mostrarSetor) {
        super(linha, coluna, ladosSetor, mostrarSetor);
    }

    @Override
    public void atacar(int inimigo, int ataqueJogador) {

        int defesaInimigo, atacar;
        Random random;

        random = new Random();
        atacar = random.nextInt(2);

        if (atacar == 0) {
            defesaInimigo = this.inimigos.get(inimigo).getDefesa();
            defesaInimigo = defesaInimigo - ataqueJogador;

            if (defesaInimigo <= 0) {
                this.inimigos.remove(inimigo);
            } else {
                this.inimigos.get(inimigo).setDefesa(defesaInimigo);
            }
        }
    }
}
