package Controller;

import java.util.Scanner;

import com.yash.Service.RBI;
import com.yash.Service.SBI;



public class Admin {
	
	
	public static void main(String[] args) {
		
		RBI rbi=new SBI();
		Scanner sc=new Scanner(System.in);
		
		boolean flag=true;
		
		while(flag)
		{

			System.out.println("----Welcome-----");
			System.out.println("1-Create Your Account number");
			System.out.println("2-View Your Account Details");
			System.out.println("3-View Your Balance");
			System.out.println("4-Withdraw Money");
			System.out.println("5-Deposite Money");
			System.out.println("6-Update Account details");
			System.out.println("7-Exit");
			
			int key=sc.nextInt();
			
			switch(key)
			{
			case 1:
				rbi.createAccount();
				break;
				
			case 2:
				rbi.viewAccountDetails();
				break;
			case 3:
				rbi.viewBalance();
				break;
			case 4:
				rbi.withdrawMoney();
				break;
			case 5:
				rbi.depositeMoney();
				break;
			case 6:
				rbi.updatesAccountDetails();
				break;
			case 7:
				flag=false;
				break;
				default :
					System.out.println("Invalid Input");
					break;
			
			}
		}
	}
}
