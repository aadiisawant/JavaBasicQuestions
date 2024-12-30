package DSApreparation2025;

public class PatternPrints {
    public static void main (String[] args){
        int n = 5;
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n*2-(2*i-1);j++){
                System.out.print("*");//9
            }
            System.out.println("");
        }

    }
}
