package SEMANA04.exercicio;

public class MonthlyEmployee extends Employee{
    // Atributos
    private Double monthlySalary;

    // Construtor
    public MonthlyEmployee(String name, String registration, boolean ehForeigner, Double monthlySalary) {
        super(name, registration, ehForeigner);
        this.monthlySalary = monthlySalary;
    }

    // Getters
    public Double getMonthlySalary() {
        return monthlySalary;
    }

    //Setters
    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    // Métodos
    public void printMonthlyEmployee(){
        super.printEmployee();
        System.out.println("Salário Mensal: " + getMonthlySalary());
    }

    public Double calculateFinalSalary(){
        return monthlySalary;
    }
}
