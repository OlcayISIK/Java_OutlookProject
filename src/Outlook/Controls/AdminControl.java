package Outlook.Controls;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Outlook.DataAccess.Context;
import Outlook.Entities.Admin;

public class AdminControl extends Context {
	ArrayList<String> CompliementList = new ArrayList<String>();
	public AdminControl() {	
	    try (BufferedReader br = new BufferedReader(new FileReader("admins.txt"))) 
	    {

	        String sCurrentLine;
 
	        while ((sCurrentLine = br.readLine()) != null) {
	        	adminDal.GetList().add(sCurrentLine);
	        }

	    } catch (IOException e) { 
	        e.printStackTrace();
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) 
	    {

	        String sCurrentLine;
 
	        while ((sCurrentLine = br.readLine()) != null) { 
	        	userDal.GetList().add(sCurrentLine);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader("customerservice.txt"))) 
	    {

	        String sCurrentLine;
 
	        while ((sCurrentLine = br.readLine()) != null) {
	        	customerServiceDal.GetList().add(sCurrentLine);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    try (BufferedReader br = new BufferedReader(new FileReader("compliement.txt"))) 
	    {

	        String sCurrentLine;
 
	        while ((sCurrentLine = br.readLine()) != null) {
	        	CompliementList.add(sCurrentLine);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	 static boolean isValid(String email) {
		 String str ="^(.+)@(aydin.edu.tr+)$";
         Pattern pattern = Pattern.compile(str);
         Matcher matcher = pattern.matcher((CharSequence)email );
         return matcher.matches();  
	 }
	 
	public boolean AddAdmin(String AdminMail,String AdminPassword,String RepeatAdminPassword) {
		boolean control = false;
		if(isValid(AdminMail)) { 
		if(AdminPassword.equalsIgnoreCase(RepeatAdminPassword)) {
			Admin admin = new Admin(AdminMail, AdminPassword);
			adminDal.GetList().add(admin.getEmail());
			adminDal.GetList().add(admin.getPassword());
			WriteAdmin(adminDal.GetList()); 
			control = true;
		}
		return control;
		}
		else {
			return control;
		} 
	}
	
	public String TakeMailInfo(String ID) {
		String Info = null;
		for(int a=0;a<userDal.GetList().size();a+=3) {
			if(userDal.GetList().get(a).equalsIgnoreCase(ID)) {
				Info = userDal.GetList().get(a+1);  
				return Info;
				 
			}
			}
				return "";
	}
	
	public String TakePasswordInfo(String ID) { 
		String Info = null;
		for(int a=0;a<userDal.GetList().size();a+=3)
			if(userDal.GetList().get(a).equalsIgnoreCase(ID)) {
				Info = userDal.GetList().get(a+2);
				return Info;
			}
				return "";
	}
	
	public boolean DeleteUser(String ID) {
		boolean control = false;
		for(int a=0;a<userDal.GetList().size();a+=3)
			if(userDal.GetList().get(a).equalsIgnoreCase(ID)) {
				userDal.GetList().remove(a);
				userDal.GetList().remove(a);
				userDal.GetList().remove(a);
				WriteUser(userDal.GetList()); 
				control = true;
				return control;
			}
		return control;
	}
	
	public void UpdateUserInfo(String ID,String NewPassword) {
		for(int a=0;a<userDal.GetList().size();a+=3) 
			if(userDal.GetList().get(a).equalsIgnoreCase(ID)) {
				userDal.GetList().set(a+2, NewPassword);
				WriteUser(userDal.GetList()); 
			}
	}
	
	public ArrayList<String> GetCompliementInformation() throws FileNotFoundException{
		return CompliementList;
	}
	
	
	
}


