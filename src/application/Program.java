package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entitiess.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter departmentś name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base Salary: ");
        int baseSalary  = sc.nextInt();


        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),baseSalary,new Department(departmentName));

        System.out.print("How many contracts to this work? ");
        int numberOfContracts = sc.nextInt();

        for (int i = 0; i < numberOfContracts; i++) {
            System.out.print("Enter contract #" +  i + "data: ");
            System.out.print("Date(DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hour): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate,valuePerHour, hours);
            worker.addContract(contract);

        }

        System.out.println("");
        System.out.print("Entwe month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.print("name: " + worker.getName());
        System.out.print("Department: " + worker.getDepartment().getName());
        System.out.println("income FOR " + monthAndYear + ": " + String.format("%02d", worker.income(month, year)));

        sc.close();
    }
}
