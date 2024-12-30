package DSApreparation2025;

import java.util.HashMap;

public class HashMapFeqnc {
    public static void main(String []args) {
        int arr[] = {1, 2, 3, 1, 2, 5, 6};
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int freq = 0;
            if(hMap.containsKey(arr[i])) freq +=1;
            freq++;
            hMap.put(arr[i],freq);
        }
        System.out.println(hMap);
    }
}
