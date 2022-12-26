package SEMANA04.exercicio;

public class Employee {
    // Atributos
    protected String name;
    protected String registration;
    protected boolean ehForeigner;
    
    // Construtor
    public Employee(final String name, final String registration, final boolean ehForeigner) {
        this.name = name;
        this.registration = registration;
        this.ehForeigner = ehForeigner;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getRegistration() {
        return registration;
    }
    public boolean isEhForeigner() {
        return ehForeigner;
    }

    // Setters
    public void setName(final String name) {
        this.name = name;
    }
    public void setRegistration(final String registration) {
        this.registration = registration;
    }
    public void setEhForeigner(final boolean ehForeigner) {
        this.ehForeigner = ehForeigner;
    }  

    // Métodos
    public void printEmployee(){
        System.out.println("----------------------");
        System.out.println("Nome do Funcionário: " + getName());
        System.out.println("Número da Matrícula: " + getRegistration());
        System.out.println("É estrangeiro: " + isEhForeigner());
    }

    public Double calculateFinalSalary(){
        return 0.0;
    }

    final void fitForPromotion(String fit){
        if(fit == "Sim"){
            System.out.println("Está apto para promoção");
        } else {
            System.out.println("Não está apto para promoção");
        }
    }

}
