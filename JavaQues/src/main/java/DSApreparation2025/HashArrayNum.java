package DSApreparation2025;

import java.util.Scanner;

public class HashArrayNum {
//    public static void HashFun(int arr[]){
//
//    }
    public static void main(String []args){
        int arr[] = {1,2,3,1,2,5,6};
        int hash[] = new int[13];
        for(int i=0;i<arr.length;i++){
            hash[arr[i]] += 1;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Total Itrs...");
        int totalNums = sc.nextInt();
        while(totalNums-- !=0){
            System.out.println("Enter SearchNum...");
            int SearchNum = sc.nextInt();
            System.out.println("found... "+hash[SearchNum]+" times");
        }

    }
}
