package ArrayQues;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

//Contiguous sub arrays with given sum
public class ContiguousSumArr {

    public static void main(String[] args) {

        int arr [] = {5, -9, 4, -2, 7, 1, -4, -3, -7};
        Scanner Sc  = new Scanner(System.in);
        System.out.println("Enter the Sum: ");
        int n = Sc.nextInt();
        // -9 4 -2 = -7
        for(int i=0;i<arr.length;i++){
            int sum = arr[i];
            if(sum == n){
                System.out.println("[ "+arr[i]+" ]");
                System.out.println("sum :"+sum);
            }
            LinkedHashSet<Integer> hs = new LinkedHashSet<>();
            hs.add(i);
            for(int j=i+1;j< arr.length;j++){
                sum += arr[j];

                hs.add(j);
                if(sum == n){
                    System.out.print("[");
                    for(int k : hs){
                        System.out.print(" "+arr[k]+" ");
                    }
                    System.out.println("]");
                    System.out.println("sum :"+sum);
                    break;
                }
            }
            hs.clear();
        }
    }
}
