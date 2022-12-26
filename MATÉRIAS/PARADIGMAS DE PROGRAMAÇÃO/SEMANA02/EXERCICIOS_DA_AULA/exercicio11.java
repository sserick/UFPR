public class exercicio11 {
    
    public static void main(String[] args) {
        
        int m[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
        int n[][] = {{10,11,12}, {13,14,15}, {16,17,18}};
        int resul[][] = new int[3][3];
        int i, j;

        // Soma das matrizes 3X3
        for (i = 0; i < 3; i++){
            for (j = 0; j < 3; j++){
                resul[i][j] = m[i][j] + n[i][j];
            }
        }

        // Imprime a matriz m
        for (i = 0; i < 3; i++){
            for (j = 0; j < 3; j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");

        // Imprime a matriz n
        for (i = 0; i < 3; i++){
            for (j = 0; j < 3; j++){
                System.out.print(n[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");

        // Imprime a matriz resul
        for (i = 0; i < 3; i++){
            for (j = 0; j < 3; j++){
                System.out.print(resul[i][j] + " ");
            }
            System.out.print("\n");
        }

    }
}
