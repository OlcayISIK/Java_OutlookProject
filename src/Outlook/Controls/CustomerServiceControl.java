package Outlook.Controls;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Outlook.DataAccess.Context;
import Outlook.DataAccess.CustomerServiceDal;
import Outlook.Entities.Admin;
import Outlook.Entities.CustomerService;

public class CustomerServiceControl extends Context{
	CustomerServiceDal customerServiceDal = new CustomerServiceDal();
	public CustomerServiceControl() {    
		try (BufferedReader br = new BufferedReader(new FileReader("customerservice.txt"))) 
    {
        String sCurrentLine;

        while ((sCurrentLine = br.readLine()) != null) {
        	customerServiceDal.GetList().add(sCurrentLine); 
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
	}
	
	
	public String GenerateEmployeeName() {
		ArrayList<String> CSNameList = new ArrayList<String>();
		for(int i=1;i < customerServiceDal.GetList().size();i+=3) { 
			CSNameList.add(customerServiceDal.GetList().get(i));
		}
		Random rand = new Random();
	    String randomElement = CSNameList.get(rand.nextInt(CSNameList.size()));
	    return randomElement;  
	} 
	
	 public int GenerateEmployeeID() throws FileNotFoundException {
		 int RandomNumber = new Random().nextInt(900000) + 100000; 
			 return RandomNumber;  
		 }
	
	public void AddCustomerService(String CSName_Surname,String Photo) throws FileNotFoundException {
			CustomerService employee = new CustomerService(GenerateEmployeeID(), CSName_Surname, Photo);
			customerServiceDal.GetList().add(String.valueOf(employee.getId()));
			customerServiceDal.GetList().add(employee.getName_Surname());
			customerServiceDal.GetList().add(employee.getPhoto()); 
			WriteCustomerServiceToFile(customerServiceDal.GetList());
	}
	
	public void SendCompliement(String MailAddress,String Compliement) throws IOException {
		ArrayList<String> CompliementList = new ArrayList<String>();
		CompliementList.add(MailAddress); 
		CompliementList.add(Compliement);
		WriteCompliement(CompliementList);
	}
	
	
	public String TakeCSNameInfo(String ID) {
		String Info = null;
		for(int a=0;a<customerServiceDal.GetList().size();a+=3)
			if(customerServiceDal.GetList().get(a).equalsIgnoreCase(ID)) {
				Info = customerServiceDal.GetList().get(a+1);
				return Info;
			}
		return "";
	}
	
	public String TakeCSPhotoInfo(String ID) {
		String Info = null;
		for(int a=0;a<customerServiceDal.GetList().size();a+=3)
			if(customerServiceDal.GetList().get(a).equalsIgnoreCase(ID)) {
				Info = customerServiceDal.GetList().get(a+2);
				return Info; 
			}
		return ""; 
	}
	
	public void UpdateCustomerServiceInfo(String ID,String Name,String Photo) { 
		for(int a=0;a<customerServiceDal.GetList().size();a+=3)
			if(customerServiceDal.GetList().get(a).equalsIgnoreCase(ID)) {
				customerServiceDal.GetList().set(a+1, Name);
				customerServiceDal.GetList().set(a+2, Photo);
				WriteCustomerServiceToFile(customerServiceDal.GetList()); 
			}
	}
	public boolean DeleteCustomerService(String ID) {
		boolean control = false;
		for(int a=0;a<customerServiceDal.GetList().size();a+=3)
			if(customerServiceDal.GetList().get(a).equalsIgnoreCase(ID)) {
				customerServiceDal.GetList().remove(a);
				customerServiceDal.GetList().remove(a);
				customerServiceDal.GetList().remove(a);
				WriteCustomerServiceToFile(customerServiceDal.GetList()); 
				control = true;
				return control; 
			}
		return control;
	}
	
	
	

}
