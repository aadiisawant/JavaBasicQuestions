package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String args[]){
        List<List<String>> listOfLists= new ArrayList<>();
        listOfLists = Arrays.asList(
                Arrays.asList("Shimla", "Selu", "Manali"),
                Arrays.asList("Nanded", "Hyderabad", "Basar","Shimla"),
                Arrays.asList("Pune", "Mumbai","Surat", "Shirdi")
        );
        Set<String> strData = new HashSet<>();
        List<String> result=
                listOfLists
                        .stream()
                .flatMap(List::stream)
                .filter(str -> str.startsWith("S"))
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                        .peek(str -> strData.add(str))
                .collect(Collectors.toList());
        System.out.println(result);
        strData.stream().forEach(System.out::println);

        String stringAlt = Arrays.asList("Nanded", "Hyderabad", "Basar","Shimla").stream()
                .reduce("",(s1,s2) -> s1+" "+s2);
        System.out.println(stringAlt.trim());
        Optional<Integer> sum = Arrays.asList(1,3,6,4,8).stream().reduce((n1, n2) -> n1+n2);
        System.out.println(sum);
    }
}
