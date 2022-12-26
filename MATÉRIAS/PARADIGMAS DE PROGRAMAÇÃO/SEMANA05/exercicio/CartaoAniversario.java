package SEMANA05.exercicio;

public class CartaoAniversario extends CartaoWeb{
    
    public CartaoAniversario(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public void retornarMensagem(String remetente) {
        System.out.println("--------------------------------");
        System.out.printf("Queridx, %s,\nFeliz Aniversário!\nDesejo tudo de bom pra você nessa data, aproveite seu dia!\nDe todo meu coração,\n%s\n", this.destinatario, remetente);        
        System.out.println("--------------------------------");
    }
}
