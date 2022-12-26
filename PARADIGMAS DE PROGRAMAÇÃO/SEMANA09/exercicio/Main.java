package SEMANA09.exercicio;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        
        ElectronicProduct produto = new ElectronicProduct("Geladeira", "Eletrolux", 10, 110);
        Service servico = new Service("domicílio", 30, "Marcos");
        ArrayList<Shop> offering = new ArrayList<Shop>();

        offering.add(produto);
        offering.add(servico);

        for(Shop offeringPS : offering){
            System.out.println("------------------");
            offeringPS.sell();
            offeringPS.triggerWarranty();
        }
    }
}
