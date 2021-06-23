package com.cpsi.salary.service;

import com.cpsi.salary.entity.ContractEmp;
import com.cpsi.salary.entity.Employee;
import com.cpsi.salary.entity.FullTimeEmp;
import com.cpsi.salary.entity.PartTimeEmp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateEmployees {

    // Creates list of employees based on given file
    public static ArrayList<Employee> create(File fName){
        ArrayList<Employee> emp= new ArrayList<Employee>();
        Scanner sc=null;
        // Ensures File is found
        try {
            sc = new Scanner(fName);
        } catch (FileNotFoundException e) {
            System.out.print("File Not Found"+e.getStackTrace());
        }
        sc.useDelimiter("\n");   //sets the delimiter pattern
        while (sc.hasNext())  // Creates Employee based on Role and adds it to Employee List
        {
            String[] ef=sc.next().split("\\|");
            Employee e;
            if(ef[3].contains("FULL")){
                e= new FullTimeEmp(ef[0],Float.parseFloat(ef[1]),Float.parseFloat(ef[2]),ef[3]);
            }
            else if(ef[3].contains("PART")){
                e=new PartTimeEmp(ef[0],Float.parseFloat(ef[1]),Float.parseFloat(ef[2]),ef[3]);
            }
            else{
                e = new ContractEmp(ef[0],Float.parseFloat(ef[1]),Float.parseFloat(ef[2]),ef[3]);
            }

            emp.add(e);
        }
        sc.close();  //closes the scanner

        return emp;
    }
}
