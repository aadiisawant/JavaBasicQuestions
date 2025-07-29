package DSApreparation2025;

import java.util.HashMap;

public class HashMapFeqnc {
    public static void main(String []args) {
        int arr[] = {1, 2, 3, 1, 2, 5, 6,1};
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hMap.containsKey(arr[i])){
                hMap.put(arr[i], hMap.get(arr[i])+1);
            }else{
                hMap.put(arr[i],1);
            }
        }
        System.out.println(hMap);
    }
}
