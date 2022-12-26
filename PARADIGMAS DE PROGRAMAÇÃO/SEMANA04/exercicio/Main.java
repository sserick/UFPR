package SEMANA04.exercicio;

public class Main {
    
    public static void main(String[] args) {
        
        MonthlyEmployee[] employeeMonth = new MonthlyEmployee[100];
        HourlyEmployee[] employeeHour = new HourlyEmployee[100];
        Double FinalSalary;
        Double sumMonth = 0.0;
        Double sumHour = 0.0;
        int i;

        for(i = 0; i < 100; i++){
            employeeMonth[i] = new MonthlyEmployee("Fernando", "GRR20182554", false, 5000.50);
            FinalSalary = employeeMonth[i].calculateFinalSalary();
            employeeMonth[i].setMonthlySalary(FinalSalary); 
            employeeMonth[i].printMonthlyEmployee();
            sumMonth = sumMonth + FinalSalary;

            employeeHour[i] = new HourlyEmployee("Claudia", "GRR20215668", true, 20.45, 30);
            FinalSalary = employeeHour[i].calculateFinalSalary();
            employeeHour[i].printHourlyEmployee();
            sumHour = sumHour + FinalSalary;
            System.out.println("Salário Mensal: " + FinalSalary);
        }

        System.out.println("----------------------------");
        System.out.println("Média Salarial do Funcionário Mensalista: " + (sumMonth / 100));
        System.out.println("Média Salarial do Funcionário Horista: " + (sumHour / 100));
    }   
}
