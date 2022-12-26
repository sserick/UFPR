package SEMANA03.AULA01.LISTA.exercicio1;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        PayrollUFPR[] PayrollData = new PayrollUFPR[3];
        EmployeeUFPR employee = new EmployeeUFPR(null, null, null, null);
        String nameEmployee, registration, office;
        Date birthDate;
        int i, day, month, year, monthPayment, yearPayment;
        Double totalSalary;

        Scanner input = new Scanner(System.in);

        for (i = 0; i < 3; i++){
            System.out.println("----------------------------");
            System.out.printf("Digite o nome do %d funcionário:\n", i + 1);
            nameEmployee = input.nextLine();

            System.out.println("Digite o número da matrícula:");
            registration = input.nextLine();

            System.out.println("Digite a data de nascimento (somente números):");
            day = Integer.parseInt(input.nextLine());
            month = Integer.parseInt(input.nextLine());
            year = Integer.parseInt(input.nextLine());

            System.out.println("Digite o cargo do funcionário:");
            office = input.nextLine();

            System.out.println("Digite o mês e ano do pagamento (somente números):");
            monthPayment = Integer.parseInt(input.nextLine());
            yearPayment = Integer.parseInt(input.nextLine());
            System.out.println("Digite o total de vencimento:");
            totalSalary = Double.parseDouble(input.nextLine());

            birthDate = new Date(day, month, year);
            
            employee.setName(nameEmployee);
            employee.setRegistration(registration);
            employee.setBirthDate(birthDate);
            employee.setOffice(office);
            
            PayrollData[i] = new PayrollUFPR(employee, monthPayment, yearPayment, totalSalary);
            PayrollData[i].setEmployee(employee);
            PayrollData[i].setMonthOfPayment(monthPayment);
            PayrollData[i].setYearOfPayment(yearPayment);
            PayrollData[i].setTotalPayments(totalSalary);
        }

        for (i = 0; i < 3; i++){
            PayrollData[i].printPayroll();
        }

        input.close();
    }
}
