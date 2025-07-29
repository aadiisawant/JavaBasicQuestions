package StringQues;

public class StringOper {
    static String revMethod(String str){
        if(str == null || str.length()<=1){
            return str;
        }
        return revMethod(str.substring(1))+str.charAt(0);
    }


    public static void main(String[] args) {
        String str = "Aditya";
        String revstr = revMethod(str);
        System.out.println(revstr);
        //StringBuffer
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        System.out.println(sb);
    }
}
