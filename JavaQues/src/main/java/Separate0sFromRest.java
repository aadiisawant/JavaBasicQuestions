import java.util.Arrays;

//How to separate zeros from non-zeros in an array?
public class Separate0sFromRest {
    public static void main(String[] args) {


        int[] arr1 = {14, 0, 5, 2, 0, 3, 0};

//        Arrays.sort(arr1); 

        //Sliding window concept
        int index =0;
        for(int j=1;j< arr1.length;j++){
            if(arr1[j]==0){
                    int temp = arr1[index];
                    arr1[index] = arr1[j];
                    arr1[j]=temp;
                    index++;
            }
        }

        for(int num : arr1) {
            System.out.print(num+" ");
        }

    }
}
