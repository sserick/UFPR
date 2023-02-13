package TRABALHO.setores;

import java.util.Random;

import TRABALHO.personagens.*;

public class SetorOculto extends Setor {

    public SetorOculto(int linha, int coluna, char[] ladosSetor, int quantidadeInimigos, Inimigo[] inimigos,
            boolean mostrarSetor) {
        super(linha, coluna, ladosSetor, quantidadeInimigos, inimigos, mostrarSetor);
    }

    @Override
    public void atacar(int inimigo, int ataqueJogador) {

        int defesaInimigo, atacar;
        Random random;

        random = new Random();
        atacar = random.nextInt(2);

        if (atacar == 0) {
            defesaInimigo = this.inimigos[inimigo].getDefesa();
            defesaInimigo = defesaInimigo - ataqueJogador;

            if (defesaInimigo <= 0) {
                defesaInimigo = 0;
                this.inimigos[inimigo].setEstaVivo(false);
            }

            this.inimigos[inimigo].setDefesa(defesaInimigo);
        }
    }
}
