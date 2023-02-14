package TRABALHO.setores;

import java.util.ArrayList;

import TRABALHO.personagens.Inimigo;

public class SetorNormal extends Setor {

    public SetorNormal(int linha, int coluna, char[] ladosSetor, int quantidadeInimigos, ArrayList<Inimigo> inimigos,
            boolean mostrarSetor) {
        super(linha, coluna, ladosSetor, quantidadeInimigos, inimigos, mostrarSetor);
    }

}
