package DSApreparation2025;

import java.util.Scanner;

public class CharHashArray {
    public static void main(String [] args){
        String str = "abcdefabdf";

        int hash[] = new int[26];
        for(int i= 0;i<str.length();i++){
            hash[str.charAt(i) -'a'] +=1;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Total Itrs...");
        int totalChars = sc.nextInt();
        while(totalChars-- !=0) {
            System.out.println("Enter SearchChar...");
            char ch = sc.next().charAt(0);
            System.out.println("found... " + hash[ch - 'a'] + " times");
        }
    }
}
