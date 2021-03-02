/*************************************************************************
* Name: HW 5 One Dim Array Synchronized with Two Dim Array
* File: mOsterman_HW5.java
* Author: Milo Osterman
* Date: 2/28/2021
* Prompt: 
* 
* You will use a one dimensional array of type int to store employee ID numbers and a two
* dimensional array to represent payroll data. Each row of the two-dimensional array will
* represent data for an employee. Column 0 will represent hours worked, column 1 pay rate,
* column 2 gross regular pay, column 3 gross overtime pay and column 4 total gross pay.
* 
*************************************************************************/


public class mOsterman_HW5 {

	public static final double OVERTIME_PAY = 1.5;
	
	public static void main(String[] args) {
		//Declare employee and payroll arrays
		int [] employeeIdArray = new int [6];
		double [] [] payrollArray = new double [6] [5];
		//Pass employee array into method to populate with hardcoded IDs
		populateEmployeeIds(employeeIdArray);
		//Pass payroll array in method to populate with hardcoded hours and pay rates
		populatePayroll(payrollArray);
		//Pass payroll array to method to calculate gross regular pay, overtime, and total pay
		calculatePay(payrollArray);
		//Display method to output employee ID, hours worked, pay rate, gross pay, overtime pay, and total pay
		displayResults(employeeIdArray, payrollArray);
	}
	
	//Populate employee ID method
	public static void populateEmployeeIds(int [] employeeIdArray) {
		employeeIdArray[0] = 100;
		employeeIdArray[1] = 200;
		employeeIdArray[2] = 300;
		employeeIdArray[3] = 400;
		employeeIdArray[4] = 500;
		employeeIdArray[5] = 600;
		
	}
	
	//Populate payroll method
	public static void populatePayroll(double [] [] payrollArray) {
		//Populate hours worked
		payrollArray[0][0] = 50;
		payrollArray[1][0] = 15;
		payrollArray[2][0] = 48;
		payrollArray[3][0] = 40;
		payrollArray[4][0] = 40;
		payrollArray[5][0] = 45;
		
		//Populate pay rate
		payrollArray[0][1] = 25;
		payrollArray[1][1] = 15;
		payrollArray[2][1] = 27;
		payrollArray[3][1] = 25;
		payrollArray[4][1] = 23;
		payrollArray[5][1] = 10;
		
		
	}
	
	//Calculate gross regular pay, overtime pay, and total pay
	public static void calculatePay(double [] [] payrollArray) {
		//Calculate regular pay
		for(int i = 0; i < payrollArray.length; i++) {
			payrollArray[i][2] = payrollArray[i][0] <= 40 ? payrollArray[i][0] * payrollArray [i][1] : 40 * payrollArray[i][1];
		}
		//Calculate total overtime pay
		for(int i = 0; i < payrollArray.length; i++) {
			payrollArray[i][3] = payrollArray[i][0] <= 40 ? 0 : (payrollArray[i][0] - 40) * (OVERTIME_PAY * payrollArray[i][1]);
		}
		//Calculate total gross pay
		for (int i = 0; i < payrollArray.length; i++) {
			payrollArray[i][4] = payrollArray[i][2] + payrollArray [i][3];
		}
	}
	
	//Display employee ID, hours worked, and pay rates
	public static void displayResults(int [] employeeIdArray, double [] [] payrollArray) {
		//Print header
		System.out.println("                Hours                   Regular       Overtime    Total");
		System.out.println("Employee ID     Worked      Pay Rate    Gross Pay     Gross Pay   Gross Pay\n");
		
		for (int i = 0; i < employeeIdArray.length; i++) {
			System.out.printf("%-8d", employeeIdArray[i]); //Print employee ID
			for (int j = 0; j < payrollArray[0].length; j++) {
				System.out.printf("%13.2f", payrollArray[i][j]); //Print payroll information
			}
			System.out.println();
		}
	}
}
