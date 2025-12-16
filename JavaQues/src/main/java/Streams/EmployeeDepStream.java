package Streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeDepStream {

    String name;
    int id;
    int salary;
    String department;

    public EmployeeDepStream(String name, int id, String dep, int salary){
        this.name = name;
        this.id=id;
        this.salary=salary;
        department = dep;
    }

    @Override
    public String toString() {
        return "EmployeeDepStream{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        List<EmployeeDepStream> employees = Arrays.asList(
                new EmployeeDepStream("Aditya", 1, "IT", 5000),
                new EmployeeDepStream("xyz",2,"CSE",6000),
                new EmployeeDepStream("gfk",3,"IT",4000),
                new EmployeeDepStream("jmnb",6,"MBA",4560)
        );
        Map<String, List<EmployeeDepStream>> hMap = employees.stream().collect(Collectors.groupingBy(dep -> dep.department));
//        System.out.println(hMap.get("IT"));
        hMap.forEach((dep,emp)->{
            System.out.println("dep :"+dep+", emp:"+emp);
        });
        employees.stream()
                .filter(emp ->{
                    return emp.department.equals("IT");
                })
                .forEach(e -> e.salary = (int) (e.salary*1.20));

        employees.forEach(System.out::println);

    }
}
