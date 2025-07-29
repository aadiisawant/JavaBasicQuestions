package StringQues;

import java.util.Scanner;
//Program to rotate the String. can be used to rotate the nums also. ;)
public class StringRotation {

    static void usingArray(String str){
        String arr [] =str.split(" ");
//        for(String s : arr){
//            System.out.println(s);
//        }
        int len = arr.length;
        System.out.println("How many times you want to rotate?");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=1;i<=num;i++){

            String temp = arr[len-1];
            for(int j= len-1;j>0;j--){
               arr[j] = arr[j-1];
            }
            arr[0] = temp;
        }
        for(String s : arr){
            System.out.print(s+" ");
        }
        System.out.println();
    }

    static  void checkStr2IsRotnOfStr1(String s1,String s2){
        if(s1.length() != s2.length()){
            System.out.println("s2 is not rotated version of s1");
        }else{
            String s3 = s1+s1;
            if(s3.contains(s2)){
                System.out.println("s2 is rotated version of s1");
            }else{
                System.out.println("s2 is not rotated version of s1");
            }
        }
    }

    public static void main(String[] args) {

        String str = "I'm Aditya sawant";
        StringRotation.usingArray(str);

       // If s1 and s2 are two given strings, then write a java program to check whether s2 is a rotated version of s1?
        String s1 = "JavaJ2eeStrutsHibernate";
        String s2 = "StrutsHibernateJavaJ2ee";
        StringRotation.checkStr2IsRotnOfStr1(s1,s2);
    }
}
