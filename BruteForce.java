import java.io.*;
import java.util.*;

public class BruteForce {



    static class Employee {
        String name;
        int id;
        int supervisorId;
        double evaluationScore;

        public Employee(int supervisorId, String name, int id, double evaluationScore) {
            this.supervisorId = supervisorId;
            this.name = name;
            this.id = id;
            this.evaluationScore = evaluationScore;
        }
    }

    // Function to read the input file and create employees list
    public static List<Employee> readEmployeesFromFile(String filename) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                int supervisorId = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int id = Integer.parseInt(parts[2].trim());
                double evaluationScore = Double.parseDouble(parts[3].trim());
                employees.add(new Employee(supervisorId, name, id, evaluationScore));
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }

        return employees;
    }

    // Function to print employees in the required format
    public static void printEmployees(List<Employee> employees) {
        System.out.println("ID Name");
        for (Employee e : employees) {
            System.out.println(e.id + " " + e.name);
        }
    }

    // Main function to read the input and output results
    public static void main(String[] args) {
        // Ensure example.txt is in the same directory or specify the absolute path
        String filename = "example.txt"; // Adjust the path if necessary
        
        List<Employee> employees = readEmployeesFromFile(filename);

        if (employees.isEmpty()) {
            System.out.println("No employees found. Please check the input file.");
        } else {
            printEmployees(employees);
        }
    }
}
