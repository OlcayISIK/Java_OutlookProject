package Outlook.Controls;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Outlook.DataAccess.Context;
import Outlook.DataAccess.UserDal;
import Outlook.UserInterface.OutlookInterface;

public class LoginControl extends Context {
		public ArrayList<String> GetMailInformation() throws FileNotFoundException{
		return userDal.GetList();
	}
	public boolean CheckLogin(String MailAddress,String Password) throws FileNotFoundException {
	    try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) 
	    {

	        String sCurrentLine;

	        while ((sCurrentLine = br.readLine()) != null) {
	        	userDal.GetList().add(sCurrentLine);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		boolean control = false; 
		for(int i=0;i < userDal.GetList().size(); i+=3) 
			if(userDal.GetList().get(i+1).equalsIgnoreCase(MailAddress) && userDal.GetList().get(i+2).equalsIgnoreCase(Password)) { 
				control = true; 
			}
		return control;
	}
	
	public boolean CheckAdminLogin(String MailAddress,String Password) throws FileNotFoundException {
	    try (BufferedReader br = new BufferedReader(new FileReader("admins.txt"))) 
	    {

	        String sCurrentLine;

	        while ((sCurrentLine = br.readLine()) != null) {
	        	adminDal.GetList().add(sCurrentLine); 
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		boolean control = false;
		for(int i=0;i < adminDal.GetList().size(); i+=2) 
			if(adminDal.GetList().get(i).equalsIgnoreCase(MailAddress) && adminDal.GetList().get(i+1).equalsIgnoreCase(Password)) { 
				control = true; 
			}
		return control;
	}
	
	

	
	}
	

	

