import java.util.Scanner;

public class exercicio7 {
    
    public static void main(String[] args) {
        
        int cont = 1;
        int nota1, nota2, nota3, nota4, maiorNotaAluno, maiorNotaTurma; 

        maiorNotaTurma = 0;
        maiorNotaAluno = 0;
        Scanner lerNumero = new Scanner(System.in);

        while (cont != 30){
            System.out.println("Digite as 4 notas do " + cont + " aluno: ");
            nota1 = lerNumero.nextInt();
            nota2 = lerNumero.nextInt();
            nota3 = lerNumero.nextInt();
            nota4 = lerNumero.nextInt();

            if (nota1 > maiorNotaAluno){
                maiorNotaAluno = nota1;
            } 
            if (nota2 > maiorNotaAluno) {
                maiorNotaAluno = nota2;
            }
            if (nota3 > maiorNotaAluno) {
                maiorNotaAluno = nota3;
            }
            if (nota4 > maiorNotaAluno) {
                maiorNotaAluno = nota4;
            }
            if (maiorNotaAluno > maiorNotaTurma){
                maiorNotaTurma = maiorNotaAluno;
            }

            maiorNotaAluno = 0;
            cont = cont + 1;
            System.out.println("A maior nota desse aluno é: " + maiorNotaAluno);
        }

        System.out.println("A maior nota dessa turma é: " + maiorNotaTurma);
        lerNumero.close();

    }
}
