package SEMANA05.exercicio;

public class CartaoDiaDosNamorados extends CartaoWeb {

    public CartaoDiaDosNamorados(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public void retornarMensagem(String remetente) {
        System.out.println("--------------------------------");
        System.out.printf("Queridx, %s,\nFeliz Dia dos Namorados!\nEspero que esse tenha sido o único cartão do dia dos namorados que tenha ganhado nessa data!\nDe todo meu coração,\n%s\n", this.destinatario, remetente);        
        System.out.println("--------------------------------");
    }
    
}
