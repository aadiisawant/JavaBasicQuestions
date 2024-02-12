import java.util.HashSet;

//How To Find Array Triplets With Sum Of Two Elements Equals Third?
public class FindArrayTriplets {

    public static void main(String[] args) {
        int arr [] ={21, 13, 47, 61, 34, 40, 55, 71, 87};
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hashSet.add(arr[i]);
        }

        System.out.println(hashSet);
        for(int i=0;i<arr.length;i++){
            for(int j= i+1; j< arr.length;j++){
                if(hashSet.contains(arr[i]+arr[j])){
                    System.out.println("[ "+arr[i]+", "+arr[j]+", "+(arr[i]+arr[j])+" ]");
                }
            }
        }

    }
}
