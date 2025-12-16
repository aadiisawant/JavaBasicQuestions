package ArrayQues;

import java.util.ArrayList;
import java.util.List;

public class ARL1 {

    static int arr[] = {6,12,5,13,9,9,17,1,16,2,10,8,2};
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int t1=0, t2=1, t=18;

        while(t2<arr.length){
            List<Integer>l = new ArrayList<>();
            if(arr[t1]+arr[t2]==t){
                l.add(arr[t1]);
                l.add(arr[t2]);
                t1=t2+1;
                t2=t2+2;
                list.add(l);
            }else{
                t2 +=1;
            }

        }
        list.forEach(System.out::println);
    }
}
