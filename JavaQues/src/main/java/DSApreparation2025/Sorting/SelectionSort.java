package DSApreparation2025.Sorting;

public class SelectionSort {
    public static void main(String [] args){
        int arr [] = {2,3,8,1,9,4,7,6};
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        for(int num : arr){
            System.out.print(num+" ");
        }

    }
}
