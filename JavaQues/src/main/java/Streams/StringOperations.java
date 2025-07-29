package Streams;//How to reverse each word of a string in Java?


public class StringOperations {

    public static void main(String[] args) {
        String str = "Java Concept Of The Day" ;
        String s2="";
        String [] sArr = str.split(" ");

        for(int j = 0;j<sArr.length;j++){
            StringBuilder sb = new StringBuilder(sArr[j]);
            sb.reverse();
//            sArr[j]= sb.toString();
            s2 = s2+sb.toString()+" ";
        }

        System.out.println(s2);
    }
}
