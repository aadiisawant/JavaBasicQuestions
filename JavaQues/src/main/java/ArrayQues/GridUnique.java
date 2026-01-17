package ArrayQues;

public class GridUnique {
    static int m=3, n=3;
    public static int GridP(int i, int j){
        if(i>=m || j>=n){
            return 0;
        }
        if(i==(m-1) && j==(n-1)){
            return 1;
        }

        return GridP(i+1, j)+GridP(i,j+1);
    }
    public static void main(String[] args) {

        int res = GridP(0,0);
        System.out.println(res);
    }
}
