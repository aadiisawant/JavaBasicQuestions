import java.util.Scanner;


public class pairsSumInArr {
    public static void main(String[] args) {

        int arr [] = {4, 5, 7, 11, 9, 13, 8, 12};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Sum to check:");
        boolean flag = false;
        int sumCheck = sc.nextInt();
        for(int i=0;i< arr.length;i++){
            int n1 = arr[i];
            //if the given sum is present in an array itself( with out adding)
            if(n1 == sumCheck){
                System.out.println("["+n1+"]");
                flag = true;
            }
            for(int j=i+1;j<arr.length;j++){
                int n2 = arr[j];
                if((n1+n2) == sumCheck){
                    System.out.println("["+n1+","+n2+"]");
                    flag = true;
                }
            }
        }
        if(!flag) {
            System.out.println("404! Not Found");
        }
    }
}
