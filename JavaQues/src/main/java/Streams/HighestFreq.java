package Streams;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HighestFreq {



    public static void main(String[] args) {
        int arr[] = {1,5,3,4,6,2,4,2,6,2,8,2,9,2};
        var num = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(
                        i -> i,
                        Collectors.counting()
                        ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())                 // find entry with highest count
                .orElseThrow();
        System.out.println(num);
    }
}
