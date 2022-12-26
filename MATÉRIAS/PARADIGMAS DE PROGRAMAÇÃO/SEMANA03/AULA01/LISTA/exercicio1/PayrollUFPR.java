package SEMANA03.AULA01.LISTA.exercicio1;

public class PayrollUFPR {

    // Atributos
    private EmployeeUFPR employee;
    private int monthOfPayment, yearOfPayment; 
    private Double totalPayments;
    

    // Construtor
    public PayrollUFPR(EmployeeUFPR employee, int monthOfPayment, int yearOfPayment, Double totalPayments) {
        this.employee = employee;
        this.monthOfPayment = monthOfPayment;
        this.yearOfPayment = yearOfPayment;
        this.totalPayments = totalPayments;
    }

    // Getters
    public EmployeeUFPR getEmployee() {
        return employee;
    }

    public int getMonthOfPayment() {
        return monthOfPayment;
    }

    public int getYearOfPayment() {
        return yearOfPayment;
    }

    public Double getTotalPayments() {
        return totalPayments;
    }

    // Setters
    public void setEmployee(EmployeeUFPR employee) {
        this.employee = employee;
    }

    public void setMonthOfPayment(int monthOfPayment) {
        this.monthOfPayment = monthOfPayment;
    }

    public void setYearOfPayment(int yearOfPayment) {
        this.yearOfPayment = yearOfPayment;
    }

    public void setTotalPayments(Double totalPayments) {
        this.totalPayments = totalPayments;
    }

    // Métodos
    public void printPayroll(){
        System.out.println("----------------------------");
        System.out.println("Funcionário: " + this.employee.getName());
        System.out.println("Matrícula: " + this.employee.getRegistration());
        System.out.print("Data de Nascimento: ");
        this.employee.getBirthDate().printDate();
        System.out.println("Cargo: " + this.employee.getOffice());
        System.out.println("Mês e ano de pagamento: " + this.getMonthOfPayment() + "/" + this.getYearOfPayment());
        System.out.println("Total de vencimentos: " + this.getTotalPayments());
    }
    
}
