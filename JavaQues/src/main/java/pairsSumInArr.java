import java.util.Scanner;


public class pairsSumInArr {
    public static void main(String[] args) {

        int arr [] = {4, 5, 7, 11, 9, 13, 8, 12};
        Scanner sc = new Scanner(System.in);
        int sumCheck = sc.nextInt();
        for(int i=0;i< arr.length;i++){
            int n1 = arr[i];
            for(int j=i+1;j<arr.length;j++){
                int n2 = arr[j];
                if((n1+n2) == sumCheck){
                    System.out.println("["+n1+","+n2+"]");
                }
            }
        }
    }
}
