package Outlook.Controls;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Outlook.DataAccess.Context;
import Outlook.Entities.Users;

public class RegisterControl extends Context {
	public RegisterControl() {
		
	
    try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) 
    {

        String sCurrentLine;

        while ((sCurrentLine = br.readLine()) != null) {
        	userDal.GetList().add(sCurrentLine);
        }

    } catch (IOException e) { 
        e.printStackTrace();
    }
	}
	
	 static boolean isValid(String email) {
		 String str ="^(.+)@(stu.edu.tr+)$";
         Pattern pattern = Pattern.compile(str);
         Matcher matcher = pattern.matcher((CharSequence)email );
         return matcher.matches();  
	 }
	 
	 public int GenerateUserID() throws FileNotFoundException {
		 int RandomNumber = new Random().nextInt(900000) + 100000; 
			 return RandomNumber;  
		 }
	 
	 
	 public boolean CheckMailAddress(String Mail,String password) {
		 boolean control = false;
		 for(int i=1;i<userDal.GetList().size();i+=3)
				if(userDal.GetList().get(i).equalsIgnoreCase(Mail)) {
					control = true;
					return control;
				}
		 return control;
	 }
	
	public boolean RegisterUser(String Mail,String password) throws IOException {
		if(isValid(Mail)) {  
				Users newuser = new Users(GenerateUserID(), Mail, password); 
				userDal.GetList().add((Integer.toString(newuser.getId()))); 
				userDal.GetList().add(newuser.getMailAddress());
				userDal.GetList().add(newuser.getPassword());
				WriteUser(userDal.GetList());
				CreateFile(Mail); 
				return true;
		}else{
			return false;
		} 
	}
}
