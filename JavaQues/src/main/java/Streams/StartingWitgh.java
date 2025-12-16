package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StartingWitgh {

    public static void main(String[] args) {
        int arr[] = { 11, 18, 20, 24, 85, 66, 13,1234};
        List<Integer> nums =  Arrays.stream(arr).boxed()
                .filter(x ->{
                    while(x>=10){
                        x = x/10;
                    }
                    return x==1;
                })
                .collect(Collectors.toList());

        System.out.println(nums);
    }
}
