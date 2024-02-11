import java.util.Scanner;

public class MissingNumInArr {

    static int SumOfNnums(int n){
        n = (n*(n+1))/2;
        return n;
    }

    static int sumOfELe(int arr[]){
        int sum = 0;
        for(int n : arr){
            sum +=n;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element: ");
        int n = sc.nextInt(); //8
        int arr [] = {1,2,3,5,6,7,8};
        int sumOfn = MissingNumInArr.SumOfNnums(n);
        int SumofEle = MissingNumInArr.sumOfELe(arr);
        int MsngNum  = sumOfn - SumofEle;
        System.out.println("Missing Number is: "+MsngNum);
    }
}
