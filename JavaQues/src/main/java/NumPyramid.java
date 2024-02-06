public class NumPyramid {
    public static void main(String[] args) {
        int num=5;
        for(int i=1;i<=num;i++){
            for(int j=0;j<=num-i;j++){
                System.out.print("  ");
            }
            for(int k=1;k<=i;k++){
                System.out.print(" "+k);
            }
            int n=i-1;
            for(int l=1;l<i;l++){
                System.out.print(" "+n);
                n--;
            }
            System.out.println();
        }

        for(int i=1;i<=5;i++){
            for(int j=0;j<=num-i;j++){
                System.out.print("  ");
            }
            for(int j =0;j<i;j++){
                System.out.print(i+" ");
            }
            for(int j =1;j<i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
