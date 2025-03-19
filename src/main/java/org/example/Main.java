package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Müslüm","Gürses"));
        employees.add(new Employee(1,"Müslüm","Gürses"));
        employees.add(new Employee(2,"Orhan","Gencebay"));
        employees.add(new Employee(2,"Orhan","Gencebay"));
        employees.add(new Employee(3,"Ferdi","Tayfur"));
        employees.add(new Employee(3,"Ferdi","Tayfur"));
        employees.add(new Employee(4,"Yıldız","Tilbe"));

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Duplicates: ");
        for (Employee employee : duplicates) {
            System.out.println(employee.getFirstname() + " " + employee.getLastname());
        }

        Map<Integer, Employee> uniqueEmployees = findUniques(employees);
        System.out.println("\nUnique Employees:");
        for (Integer key : uniqueEmployees.keySet()) {
            Employee employee = uniqueEmployees.get(key);
            System.out.println(employee.getFirstname() + " " + employee.getLastname());
        }

        List<Employee> nonDuplicateList = removeDuplicates(employees);
        System.out.println("\nList after Removing Duplicates:");
        for (Employee employee : nonDuplicateList) {
            System.out.println(employee.getFirstname() + " " + employee.getLastname());
        }
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Set<Employee> uniqueEmployees = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();

        for (Employee employee : employees) {
            if (!uniqueEmployees.add(employee)) {
                duplicates.add(employee);
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                uniqueMap.put(employee.getId(), employee);
            }
        }

        return uniqueMap;
    }


    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Set<Employee> seen = new HashSet<>();
        Set<Employee> duplicates = new HashSet<>();
        List<Employee> uniqueEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee != null && !seen.add(employee)) {
                duplicates.add(employee);
            }
        }

        for (Employee employee : employees) {
            if (employee != null && !duplicates.contains(employee)) {
                uniqueEmployees.add(employee);
            }
        }

        return uniqueEmployees;
    }

}
