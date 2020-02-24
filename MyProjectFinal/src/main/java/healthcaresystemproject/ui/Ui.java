package healthcaresystemproject.ui;

import java.util.HashMap;
import java.util.Scanner;

import HealthException.HealthException;
import healthcaresystemproject.service.IService;
import healthcaresystemproject.service.ServiceImpl;

public class Ui {
	static HashMap<String,String> adminList =new HashMap();
	static IService service=new ServiceImpl();
	public Ui()
	{
		addSomeAdminDetails();
	}
	
    private void addSomeAdminDetails() {
		adminList.put("harish","112233");
		adminList.put("king","007");
				
	}

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws HealthException{
		int flag1=1;
	while(flag1==1)
	{
		System.out.println("Welcome to Health Care Management");
		
	
	
			Ui u=new Ui();
			System.out.println("Welcome_____ADMIN");
			
		    	int flag=1;
			  while(flag==1) {
				try
				{
					System.out.println("Username :");
					String userName=sc.next();
					System.out.println("Password :");
					String password=sc.next();
					
				if(adminList.containsKey(userName) && adminList.containsValue(password))
		    	{
					flag=0;
				
				
				 service.approveAppointment();break;
				}
			    
				else
				{
				 flag=1;
				  throw new HealthException("invalid admin details");
				}
				}
				catch(HealthException e)
				{
			     	System.out.println(e);	
				}
			  }
			
	
		
		System.out.println("Enter 0 to exit ");
		flag1=sc.nextInt();
	}
	}
}
