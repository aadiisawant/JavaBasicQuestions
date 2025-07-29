package ArrayQues;

import java.util.Arrays;
import java.util.HashSet;
//Write a java program to find common elements between two arrays?
public class ComnEleIn2Arr {
    static void useHashset(Integer ar1[], Integer ar2[]){
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(ar1));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(ar2));
        set1.retainAll(set2);
        System.out.println(set1);
    }
    static void UseLoopNhashset(Integer ar1[], Integer ar2[]){
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i< ar1.length;i++){
            for(int j=0;j<ar2.length;j++){
                if(ar1[i].equals(ar2[j])){
                    hs.add(ar1[i]);
                }
            }
        }
        System.out.println(hs);
    }

    public static void main(String[] args) {
        Integer arr1[] = {1,2,3,4,5,6};
        Integer arr2[] = {5,6,7,8,9,10};

//        ArrayQues.ComnEleIn2Arr.useHashset(arr1,arr2);
        ComnEleIn2Arr.UseLoopNhashset(arr1,arr2);
    }
}
