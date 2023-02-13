package SEMANA05.exercicio;

public class CartaoNatal extends CartaoWeb {

    public CartaoNatal(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public void retornarMensagem(String remetente) {
        System.out.println("--------------------------------");
        System.out.printf("Queridx, %s,\nFeliz Natal!\nEspero que aproveite bastante as festas!\nDe todo meu coração,\n%s\n", this.destinatario, remetente);        
        System.out.println("--------------------------------");
    }
    
    
}
