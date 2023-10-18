package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class PayrollCalculatorBuffer {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Make a new file and include a .csv: ");
        String secondFile = scanner.next();

        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileEmployee = new FileWriter(secondFile);
            BufferedWriter bufWriter = new BufferedWriter(fileEmployee);
            String input;


            while ((input = bufferedReader.readLine()) != null) {
                String[] employee = input.split("\\|");
                long employeeId = Long.parseLong(employee[0]);
                String name = employee[1];
                double hoursWorked = Double.parseDouble(employee[2]);
                double payRate = Double.parseDouble(employee[3]);
                Employees down = new Employees(employeeId, name, hoursWorked, payRate);
                System.out.printf("Employee Id: %d, Name: %s, GrossPay: $%.2f%n ", down.getEmployeeId(), down.getName(), down.grossPay());
                bufWriter.write("Employee Id: " + down.getEmployeeId() + "Name: " + down.getName() + "GrossPay: " + down.grossPay() + "\n");
            }
            bufferedReader.close();
            bufWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
