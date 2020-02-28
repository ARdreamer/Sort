package array.zhi_zi_xing;

public class PrintZhi {
    public static void printMatrixZigZag(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix.length - 1;
        boolean frontUp = false;
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, frontUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            frontUp = !frontUp;
        }
        System.out.println();
    }

    private static void printLevel(int[][] matrix, int tR, int tC, int dR, int dC, boolean frontUp) {
        if (frontUp) {
            while (tR != dR + 1) {
                System.out.print(matrix[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.print(matrix[dR--][dC++] + " ");
            }
        }
    }
}
