package ArrayQues;

public class SpiralMatrix {
    public static void main(String[] args) {


        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int t = 0, l = 0;
        int r = matrix[0].length-1;
        int b = matrix.length-1;

        while(t<=b && l<=r){
            //left to right
            for(int i=l; i<=r; i++){
                System.out.print(matrix[t][i]+" ");
            }
            t++;
            //right to bottom
            for(int i=t; i<=b; i++){
                System.out.print(matrix[i][r]+" ");
            }
            r--;
            //bottom to left
            for(int i=r; i>=l; i--){
                System.out.print(matrix[b][i]+" ");
            }
            b--;
            //left to top
            for(int i=b; i>=t; i--){
                System.out.print(matrix[i][l]+" ");
            }
            l++;
        }

    }
}
