import java.util.Scanner;

public class exercicio2 {
    
    public static void main(String[] args) {
        
        int m[][] = new int[3][3];
        int i, j, num1, num2, num3;
        Scanner lerMatriz = new Scanner(System.in);
        System.out.println("Digite a matriz 3x3: ");
        for (i = 0; i < 3; i++){
            for (j = 0; j < 3; j++){
                m[i][j] = lerMatriz.nextInt();
                if (j == 2){
                    m[i][j] = lerMatriz.nextInt();
                }
            }
        }

        num1 = m[1][1] + m[2][1] + m[3][1];
        num2 = m[1][2] + m[2][2] + m[3][2];
        num3 = m[1][3] + m[2][3] + m[3][3];

        System.out.println("o array: " + num1 + " " + num2 + " " + num3);

        lerMatriz.close();
    }
}
