package com.yash.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yash.Model.Account;
import com.yash.Util.DataBase;

public class SBI implements RBI
{
	List<Account> acList=new ArrayList<Account>();

Scanner sc=new Scanner(System.in);
@Override
public void createAccount() {
	
	
	Scanner sc=new Scanner(System.in);
	System.out.println("How Many Account to be Created");
	int n=sc.nextInt();
	for(int i=0;i<n;i++)
	{
		Account ac=new Account();
	System.out.println("Enter Your Account Number");
	long accno=sc.nextLong();
	
	System.out.println("Enter Your Name");
	String name=sc.next()+sc.nextLine();
	System.out.println("Enter Your Address");
	String addr=sc.next();
	System.out.println("Enter Your Pan Number");
	String pan=sc.next();
	System.out.println("Enter Your Balance");
	int balance=sc.nextInt();
	System.out.println("Enter your Gender");
	String gender=sc.next();
	
	ac.setAccno(accno);
	
	ac.setName(name);
	ac.setAddress(addr);
	ac.setPan(pan);
	ac.setBalance(balance);
	ac.setGender(gender);
	acList.add(ac);
	
	
	
//	try {
		//Connection con=DataBase.getConnection();
//		String sql="create table bank(accountno int(10),name varchar(20),address varchar(20),panno varchar(20),Balance int(10),Gender varchar(10))";
	//	Statement smt=con.createStatement();
		//smt.execute(sql);
		
//		String sql="insert into bank Values(?,?,?,?,?,?)";
//
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setLong(1, accno);
//		ps.setString(2, name);
//		ps.setString(3, addr);
//		ps.setString(4,pan);
//		ps.setInt(5, balance);
//		ps.setString(6, gender);
//		
//		ps.execute();
//		
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	
	
	
	
	}
}
@Override
public void viewAccountDetails() {
	// TODO Auto-generated method stub
	System.out.println("1.Enter Your Account");
	System.out.println("----OR----");
	System.out.println("2.Exit");
	
	int key=sc.nextInt();
	switch(key)
	{
	case 1:
		System.out.println("Enter Your Account Number");
	long accno=sc.nextLong();
	boolean flag=true;
	for(Account ac:acList)
	{
		if(ac.getAccno()!=0&&ac.getAccno()==accno)
	{
		System.out.println("Your Account Number:"+ac.getAccno());
		if(ac.getGender()=="Male"||ac.getGender()=="male") 
		{
			System.out.println("Your Name:Mr."+ac.getName());
		}
		else  
		{
			System.out.println("your Name:Mrs."+ac.getName());
		}
		System.out.println("Your Address:"+ac.getAddress());
		System.out.println("Your Pan Number:"+ac.getPan());
		System.out.println("Your Balance:"+ac.getBalance());
		flag=false;
		
	}
		break;
//	else {
//		System.out.println("Please Enter Correct Account Number");
//		break;
	}
	if(flag)
	{
		System.out.println("Please Enter Correct Account Number");
	}
	case 2:
		
		break;
	}
}
	

@Override
public void viewBalance() {
	System.out.println("Enter Your Account");
	long accno=sc.nextLong();
	
	for(Account ac:acList)
	{
	if(ac.getAccno()!=0&&ac.getAccno()==accno)
	{
	System.out.println("Your Balance:"+ac.getBalance());
	}
	
	try {
		Connection con=DataBase.getConnection();
		String sql="select * from bank where accountno=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("Enter Account number");
		int ac1=sc.nextInt();
		ps.setInt(1, ac1);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getDouble(5));
			System.out.println(rs.getString(6));
			
		}
		ps.close();
		con.close();
			
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
	
	
	
	
	
	
//	else {
//		System.out.println("Please Enter Correct Account Number");
//	}
}
	}
	
@Override
public void withdrawMoney() {
	System.out.println("Enter Your Account");
	long accno=sc.nextLong();
	for(Account ac:acList)
	{
	if(ac.getAccno()!=0&&ac.getAccno()==accno)
	{
System.out.println("Enter Your Withdraw Amount");
int a=sc.nextInt();

if(ac.getBalance()>a&&ac.getBalance()>500)
{
	System.out.println("Collect Your Cash:"+a);
double d=ac.getBalance()-a;
ac.setBalance(d);
System.out.println("Your Remaining Balance:"+d);

}
else {
	System.out.println("Insufficent Balance");
}
}
	else
		System.out.println("Please Enter Correct Account Number");
	
}}
@Override
public void depositeMoney() {
	System.out.println("Enter Your Account");
	long accno=sc.nextLong();
	for(Account ac:acList)
	{
	if(ac.getAccno()!=0&&ac.getAccno()==accno)
	{
		System.out.println("Enter Your Deposite Amount");
		int d=sc.nextInt();
		
		double a=ac.getBalance()+d;
		ac.setBalance(a);
		System.out.println("Your Available Balance:"+a);
		
	}
	else
		System.out.println("Please Enter Correct Account Number");
	
}}
@Override
public void updatesAccountDetails() {
	System.out.println("Enter Your Account");
	long accno=sc.nextLong();
	for(Account ac:acList)
	{
	if(ac.getAccno()!=0&&ac.getAccno()==accno)
	{
		System.out.println("1-Update Your Name");
		System.out.println("2-Update Your address");
	System.out.println("3-Update Your Pan Number");
	int key=sc.nextInt();
	
	switch(key)
	{
	case 1:
		System.out.println("Enter Your Gender");
		String gender=sc.next();
		System.out.println("Enter Your Updated Name");
		String name=sc.next()+sc.nextLine();
		ac.setGender(gender);
		ac.setName(name);
	
		if(ac.getGender()=="Male"||ac.getGender()=="male") {
			System.out.println("Your Name:Mr."+ac.getName());
		}
		else if(ac.getGender()=="Female"|| ac.getGender()=="female") {
			System.out.println("your Name:Mrs."+ac.getName());
		}
	break;
	
	case 2:
		System.out.println("Enter Your Updated Address");
	String addr=sc.next();
	ac.setAddress(addr);
    System.out.println("Your Updated Address:"+addr);	
	break;
	
	case 3:
		System.out.println("Enter Your Updated Pan Number");
	    String pan=sc.next();
	    ac.setPan(pan);
	    System.out.println("Your Updated Pan Number:"+pan);
	    break;
	case 4:
		System.out.println("Invalid Input");
		break;
	
	}
	
	}
	else
		System.out.println("Please Enter Correct Account Number");
}
}
}


























