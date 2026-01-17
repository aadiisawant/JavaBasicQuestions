package ArrayQues;

public class MatrixND {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int n= matrix[0].length;
        int m= matrix.length;
        int rotated [][]= new int[m][n];
        int col=n-1;
        for(int i=0; i<m;i++){

            for(int j=0;j<n;j++){
                rotated[j][col]=matrix[i][j];
            }
            col--;
        }
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(rotated[i][j]+" ");
            }
            System.out.println();
        }
    }
}
