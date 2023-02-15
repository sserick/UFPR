package TRABALHO.setores;

import java.util.ArrayList;

import TRABALHO.personagens.Inimigo;

public class SetorPrivado extends Setor {

    public SetorPrivado(int linha, int coluna, char[] ladosSetor, int quantidadeInimigos, ArrayList<Inimigo> inimigos,
            boolean mostrarSetor) {
        super(linha, coluna, ladosSetor, quantidadeInimigos, inimigos, mostrarSetor);
    }

    public SetorPrivado(int linha, int coluna, char[] ladosSetor, boolean mostrarSetor) {
        super(linha, coluna, ladosSetor, mostrarSetor);
    }
}
