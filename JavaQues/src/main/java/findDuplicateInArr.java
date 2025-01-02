import java.util.HashMap;

public class findDuplicateInArr {
    public static void arrNumFreq(int arr[]){
        int n= arr.length;
        int freq[] = new int[n];
        for(int i=0;i<n;i++){
            if(freq[arr[i]]==0){
                freq[arr[i]] +=1;
            }
            else{
                System.out.println(arr[i]);
            }
        }
    }
    public static void main(String args[]){
        int arr [] = {1,3,4,2,2};
        HashMap<Integer, Integer> numFreq = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(numFreq.containsKey(arr[i])){
                numFreq.put(arr[i], numFreq.get(arr[i])+1);
            }else{
                numFreq.put(arr[i],1);
            }
        }
        System.out.println(numFreq);
        arrNumFreq(arr);
    }
}
