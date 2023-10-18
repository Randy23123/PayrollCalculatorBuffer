package com.pluralsight;

import java.io.*;

public class PayrollCalculatorBuffer {
    public static void main(String[] args) throws FileNotFoundException {

        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileEmployee = new FileWriter("src/main/resources/newEmployees.csv");
            BufferedWriter bufWriter = new BufferedWriter(fileEmployee);
            String input;

            bufWriter.write("111|Cameron Tay|3277.65\n" + "222|James Tee|2150.00");
            bufWriter.close();

            while ((input = bufferedReader.readLine()) != null) {
                String[] employee = input.split("\\|");
                long employeeId = Long.parseLong(employee[0]);
                String name = employee[1];
                double hoursWorked = Double.parseDouble(employee[2]);
                double payRate = Double.parseDouble(employee[3]);
                Employees down = new Employees(employeeId, name, hoursWorked, payRate);
                System.out.printf("Employee Id: %d, Name: %s, GrossPay: $%.2f%n", down.getEmployeeId(), down.getName(), down.grossPay());
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
