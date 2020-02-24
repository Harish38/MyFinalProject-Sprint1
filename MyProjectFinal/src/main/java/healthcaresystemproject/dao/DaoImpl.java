package healthcaresystemproject.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import HealthException.HealthException;
import healthcaresystemproject.dto.Appointment;
import healthcaresystemproject.dto.DiagnosticCenter;
import healthcaresystemproject.dto.Test;
import healthcaresystemproject.dto.User;

public class DaoImpl implements IDao {
	static HashMap<String,DiagnosticCenter> centerList=new HashMap<String, DiagnosticCenter>();
    HashMap<String,User> userList= new HashMap<String,User>();
    
    public DaoImpl()
    {
    	DiagnosticCenter d1=new DiagnosticCenter();
    	DiagnosticCenter d2=new DiagnosticCenter();
    	d1.setCenterId("1122");
    	d1.setCenterName("APOLO");
    	d2.setCenterId("3344");
    	d2.setCenterName("KIMS");
    	
    	Test t1=new Test();
    	t1.setTestId("101");
    	t1.setTestName("Blood Group");
    	Test t2=new Test();
    	t2.setTestId("102");
    	t2.setTestName("Blood Pressure");
    	Test t3=new Test();
    	t2.setTestId("102");
    	t2.setTestName("Blood Sugar");
    	d1.setListOfTests(Arrays.asList(t1,t2,t3));
    	d2.setListOfTests(Arrays.asList(t1,t2,t3));
    	
    	User u1=new User("101","john","kite",9505411992L,"Cutomer","johnabc@gmail.com");
    	User u2=new User("102","goerge","helo",9059689933L,"Cutomer","george@gmail.com");
    	User u3=new User("103","helly","happy",9999988888L,"Cutomer","helly@gmail.com");
    	
    	Appointment a1=new Appointment();
    	a1.setAppointmentId(10000000001L);
    	a1.setDatetime(new Date(2020,1,20));
    	a1.setTest(t1);
    	a1.setUser(u1);
    	a1.setApproved(false);
    	
    	
    	Appointment a2=new Appointment();
    	a2.setAppointmentId(10000000002L);
    	a2.setDatetime(new Date(2020,1,22));
    	a2.setTest(t2);
    	a2.setUser(u2);
    	a2.setApproved(false);
    	
    	
    	Appointment a3=new Appointment();
    	a3.setAppointmentId(10000000003L);
    	a3.setDatetime(new Date(2020,4,2));
    	a3.setTest(t3);
    	a3.setUser(u3);
    	a3.setApproved(false);
    	d1.setAppointmentList(Arrays.asList(a1,a2));
    	d1.setAppointmentList(Arrays.asList(a1,a2));
    	d2.setAppointmentList(Arrays.asList(a2,a3));
    	
    	
    	centerList.put(d1.getCenterName(), d1);
    	centerList.put(d2.getCenterName(), d2);
    	
    	
    	
    }
	public String addCenter(DiagnosticCenter center) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeCenter(DiagnosticCenter center) {
		// TODO Auto-generated method stub
		return false;
	}

	public String addTest(Test test) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeTest(Test test) {
		// TODO Auto-generated method stub
		return false;
	}

	public long makeAppointment(User user, DiagnosticCenter center, Test test, Date datetime) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String register(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean approveAppointment() {
		IDao di=new DaoImpl();
		Set<String> s=centerList.keySet();
		System.out.println("List of Centers");
		for(String i:s)
			System.out.println(i);
		System.out.println("Enter Center Name which you want to select ");
		String centerName=null;
		int flag2=1;
		while(flag2==1)
		{
		try {
		 centerName=new Scanner(System.in).next();
	if(s.contains(centerName)) {
		flag2=0;
		//throw new HealthException();
		}
	else {
		flag2=1;
		throw new Exception("Input Mismatch");
	}
		}
		
		 catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("enter correct input name shown above");
		}
	
		}
		DiagnosticCenter d1=centerList.get(centerName);
		List<Appointment> list=d1.getAppointmentList();
		System.out.println("Enter true=Approve ");
		System.out.println("  \tfalse=Reject ");
		for(Appointment a:list)
		{    
			
			long l=a.getAppointmentId();
			System.out.println("Appointment ID is: "+l);
			System.out.println("customer is: "+a.getUser());
			ArrayList<Boolean> mylist=new ArrayList<Boolean>();
			mylist.add(true);
			mylist.add(false);
			boolean b=false;
			int flag3=1;
			while(flag3==1) {
				
			
				try {
				 b=new Scanner(System.in).nextBoolean();
				
			if(mylist.contains(b))
			{
			flag3=0;
			}
			else
			{
				flag3=1;
				throw new Exception("input Mismatch");
			}
				}
			
				
				 catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					System.out.println("enter correct input name shown above");
				}
			}
			a.setApproved(b);
			System.out.println(a.getAppointmentId()+"----"+a.isApproved());
		}
		System.out.println(list);
		d1.setAppointmentList(list);
		System.out.println("Thank you");
		return false;
	}
	

}
