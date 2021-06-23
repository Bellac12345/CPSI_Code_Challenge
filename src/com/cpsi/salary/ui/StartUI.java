package com.cpsi.salary.ui;

import com.cpsi.salary.entity.Employee;
import com.cpsi.salary.service.CreateEmployees;

import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class StartUI {

    // List of Employees
    private static ArrayList<Employee> emps;

    public static void main(String[]args){
        Scanner scan =new Scanner(System.in);
        while(true){
            // Open CSV File
            System.out.print("Enter CSV File Name Without Extension: ");
            String fName= "resources/"+scan.nextLine()+".csv";
            File f = new File(fName);
            while(!f.exists()){
                System.out.print("File Not Found, Please Enter Correct File Name WithOut Extension: ");
                fName= "resources/"+scan.nextLine()+".csv";
                f= new File(fName);
            }

            // Creates a list of Employees based on file
            emps = CreateEmployees.create(f);

            Integer choice=null;
            // Get Valid selection of calculation
            while(true){
                printMenu();
                try{
                    choice= Integer.parseInt(scan.nextLine());
                    while(choice <1 || choice > 4){
                        System.out.println("Invalid Choice.\nPlease Enter Valid Choice From Menu Below:");
                        printMenu();
                        choice= Integer.parseInt(scan.nextLine());
                    }
                    break;
                }
                catch(Exception e){
                    System.out.println("Invalid Input.\nPlease Enter Valid Input From The Menu Below:");
                }
            }

            // Perform Calculation chosen
            switch(choice){
                case 1:
                    System.out.print("Enter Name Of Employee: ");
                    String name= scan.nextLine();
                    opt1(name);
                    break;
                case 2:
                    opt2();
                    break;
                case 3:
                    System.out.print("Enter Role (FULL TIME, PART TIME, CONTRACT): ");
                    String rol= scan.nextLine();
                    opt3(rol);
                    break;
                case 4:
                    scan.close();
                    System.exit(0);
            }

        }

    }

    // Calculate Total Salary By Employee Name
    public static void opt1(String n){
        boolean contains=false;
        for(Employee i:emps){
            if(i.getName().equals(n)){
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.CEILING);
                System.out.println("Total Salary for "+n+" is: $"+df.format(i.getSalary()));
                contains=true;
            }
        }
        if(!contains){
            System.out.println("No Employee Found With That Name");
            return;
        }



    }

    // Calculate Total salary Of Every Employee
    public static void opt2(){
        Float sal=Float.valueOf(0);
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        for(Employee x: emps){
            System.out.println("Total Salary for "+x.getName()+" is: $"+df.format(x.getSalary()));
            sal+=x.getSalary();
        }
        System.out.println("Total Employee Salary: $"+df.format(sal));
    }

    // Calculate Salary by Employee Role
    public static void opt3(String r){
        Float sal=Float.valueOf(0);
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        for(Employee x: emps){
            if(x.getRole().contains(r)){
                sal+=x.getSalary();
            }
        }

        System.out.println("Total Salary grouped by "+r+": $"+df.format(sal));
    }

    // Print Calculation options
    public static void printMenu(){
        System.out.println("Pick from the following calculations:\n" +
                "1)Total Salary in dollars by Employee Name\n" +
                "2)Total Salary in dollars for Every Employee\n" +
                "3)Total Salary in dollars grouped by role\n" +
                "4)Quit");
    }



}
