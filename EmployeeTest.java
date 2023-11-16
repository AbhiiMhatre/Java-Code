package com.mini.ui;
import java.util.*;
import com.mini.dao.EmployeeDaoImpl;
import com.mini.pojo.Employee;
public class EmployeeTest {
	
	public static void main(String args[]) {
		
	Scanner sc = new Scanner(System.in);
	System.out.println("------------>Before we start, please log in with your email ID and password<----------------");
	Employee[] employees = new Employee[5]; 
       
        employees[0] = new Employee("abhishekmhatre@gmail.com", "abhiim");
        employees[1] = new Employee("lionelmessi@gmail.com", "messi10");
        employees[2] = new Employee("cristianoronaldo@gmail.com", "ronaldo7");
        employees[3] = new Employee("realmadrid@gmail.com", "realm");
        employees[4] = new Employee("cmpunk@gmail.com", "cmpunk");

        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.print("Enter your EmailId: ");
            String LoginId = sc.nextLine();
            System.out.print("Enter your password: ");
            String Password = sc.nextLine();

            for (Employee e : employees) {
                if (e != null && e.getLoginId().equals(LoginId) && e.getPassword().equals(Password)) {
                    System.out.println("Login successful!!");
                    loggedIn = true;
                    break;
                }
            }

            if (!loggedIn) {
                System.out.println("Login failed. Please try again.");
            }
        }

		boolean exit = false;
		boolean flag;
		int empId = 101;
		String empName;
	    String designation;
	    double salary;
	    
	    Employee e = null;
	    EmployeeDaoImpl eimpl = new EmployeeDaoImpl();
	    Employee[] emplist= null;
				
		System.out.println("**********Welcome to SocialEmp*********");

		while (!exit) 
		{
			System.out.println("\nPlease enter the number as given in option...");
			System.out.println("1-----> Register Employee");
			System.out.println("2-----> Show All Employees");
			System.out.println("3-----> Search Employee by Id");
			System.out.println("4-----> Update Employee details");
			System.out.println("5-----> Delete Employee profile");
			System.out.println("6-----> Exit");
			
			System.out.println("Choose any number: ");
			
			int option = sc.nextInt();
			sc.nextLine();
			Employee[] empList;
			switch(option)
			{
			
			case 1:
				System.out.println("Enter your name: ");
				empName = sc.nextLine();
				
				System.out.println("Enter your Designation: ");
				designation = sc.nextLine();
				
				System.out.println("Enter your Salary: ");
				salary = sc.nextDouble();
				sc.nextLine();
				
				empId+= 12;
				
				e= new Employee(empId, empName, designation, salary);
				
				 flag = eimpl.addEmployee(e);
				 if (flag) {
                 			    System.out.println("Employee registration completed successfully.");
                    			    Employee[] allEmployees = eimpl.showAllEmployees();
                  			   for (Employee emp : allEmployees) {
                     			    if (emp != null) {
                        			   System.out.println(emp);
                         			   System.out.println("___________________________________________");
                         }
                     }
                   			  System.out.println();
                			 } else
               				      System.err.println("Error while adding Employee!!!");

              					   break;
                 
	    	 case 2:
	                emplist = eimpl.showAllEmployees();
	                
	                for (Employee e1:emplist) {
	                    if (e1!= null) {
	                        System.out.println(e1);
	                        System.out.println("---------------------------------------------------------");
	                    } 
	                }
	                break;
	               
			 case 3:
				    System.out.println("Search employees by: ");
				    System.out.println("1. Id");
				    System.out.println("2. Name");
				    System.out.println("Choose One Option: ");
				    int searchBy = sc.nextInt();
				    sc.nextLine(); 

				    switch (searchBy) {
				        case 1:
				            System.out.println("Enter the employee ID for the search: ");
				            int id = sc.nextInt();
				            sc.nextLine();

				            e = eimpl.searchEmployeeById(id);

				            if (e != null) {
				                System.out.println("Employee found with the provided ID:\n" + e);
				                System.out.println("---------------------------------------------------------");
				            } else {
				                System.out.println("No employee matches the provided ID.");
				            }
				            break;

				        case 2:
				            System.out.println("Enter the employee name for the search: ");
				            String name = sc.nextLine();

				            e = eimpl.searchEmployeeByName(name);

				            if (e != null) {
				                System.out.println("Employee found with the provided name:\n" + e);
				                System.out.println("---------------------------------------------------------");
				            } else {
				                System.out.println("No employee matches the provided name.");
				            }
				            break;

				        default:
				            System.out.println("Invalid search option. Please select 1 for ID or 2 for Name.");
				            break;
				    }
				    break;


            	
			 case 4:
				    System.out.print("Enter ID of the employee to be updated: ");
				    int idToUpdate = sc.nextInt();
				    sc.nextLine();

				    e = eimpl.searchEmployeeById(idToUpdate);

				    if (e != null) {
				        System.out.println("******Employee profile details as per the provided employee Id******");
				        System.out.println(e);

				        System.out.println("\nWhich detail do you want to update?");
				        System.out.println("1. Name");
				        System.out.println("2. Designation");
				        System.out.println("3. Salary");
				        System.out.println("Choose one option: ");
				        int updateChoice = sc.nextInt();
				        sc.nextLine();

				        switch (updateChoice) {
				            case 1:
				                System.out.print("Enter the new name: ");
				                empName = sc.nextLine();
				                e.setEmpName(empName);
				                break;
				            case 2:
				                System.out.print("Enter the new designation: ");
				                designation = sc.nextLine();
				                e.setDesignation(designation);
				                break;
				            case 3:
				                System.out.print("Enter the new salary: ");
				                salary = sc.nextDouble();
				                sc.nextLine();
				                e.setSalary(salary);
				                break;
				            default:
				                System.out.println("Invalid option...Select a valid option");
				                break;
				        }

				        flag = eimpl.updateEmployee(e);

				        if (flag) {
				           
				            System.out.println("Employee updated successfully");
				            System.out.println("---------------------------------------------------------");
				        } else {
				            System.out.println("Error while updating employee profile!!");
				        }
				    } else {
				        System.out.println("No employee with this ID found!!");
				    }
				    break;

				
            	
            case 5:
                System.out.println("Enter the ID of the employee you want to delete: ");
                int deleteId = sc.nextInt();
                sc.nextLine();
                    
                    boolean deleteFlag = eimpl.deleteEmployee(deleteId);

                    if (deleteFlag) {
                        System.out.println("Employee with ID " + deleteId + " has been deleted.");
                    } else {
                        System.out.println("Employee profile deletion failed.");
                    }
               
                break;
    
            case 6:
            	exit=true;
            	System.out.println("Thanks! Visit us again. Goodbye!");
            	break;
            	}
			}
		}	
}