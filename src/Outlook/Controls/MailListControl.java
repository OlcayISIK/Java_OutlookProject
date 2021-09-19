package Outlook.Controls;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Outlook.DataAccess.Context;
import Outlook.Entities.Admin;
import Outlook.Entities.EMails;

public class MailListControl extends Context {
	
	public MailListControl(String MailAddress) {
	    try (BufferedReader br = new BufferedReader(new FileReader("MailBox//" +MailAddress+ "#MailBox.txt")))
	    {
 
	        String sCurrentLine;

	        while ((sCurrentLine = br.readLine()) != null) {  
	        	mailDal.GetList().add(sCurrentLine);
	        }

	    } catch (IOException e) {  
	        e.printStackTrace();
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader("MailBox//" +MailAddress+ "#SpamMail.txt"))) 
	    {

	        String sCurrentLine;

	        while ((sCurrentLine = br.readLine()) != null) {
	        	mailDal.GetSpamEmails().add(sCurrentLine);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader("MailBox//" +MailAddress+ "#ReadMail.txt")))
	    {

	        String sCurrentLine;

	        while ((sCurrentLine = br.readLine()) != null) {
	        	mailDal.GetReadEmails().add(sCurrentLine);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    try (BufferedReader br = new BufferedReader(new FileReader("SentMailBox//" +MailAddress+ "#SentMailBox.txt")))
	    {

	        String sCurrentLine;

	        while ((sCurrentLine = br.readLine()) != null) {
	        	mailDal.GetSubmitEmails().add(sCurrentLine);
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
	} 
	
	public void MarkMails(String ReceiverAddress,String UserEmailAddress, String Header,String Topic,String DateTime) throws FileNotFoundException {
		EMails emails = new EMails(ReceiverAddress, Header, Topic,DateTime);
		mailDal.GetReadEmails().add(emails.getRecieverMailAddress());
		mailDal.GetReadEmails().add(emails.getMailSubject()); 
		mailDal.GetReadEmails().add(emails.getMailBody());	
		mailDal.GetReadEmails().add(emails.getDateTime()); 
		WriteReadMailsToFile(mailDal.GetReadEmails(),UserEmailAddress); 
				for(int a = 0; a < mailDal.GetList().size(); a+=4)
					if(mailDal.GetList().get(a).equalsIgnoreCase((ReceiverAddress)) && mailDal.GetList().get(a+3).equalsIgnoreCase((DateTime))) {
						mailDal.GetList().remove(a);  
						mailDal.GetList().remove(a);    
						mailDal.GetList().remove(a);   
						mailDal.GetList().remove(a);   
      				break;
					} 
      					
				WriteMailsToFile(mailDal.GetList(),UserEmailAddress);  
				
      		}
	
	public void MarkSpamMails(String ReceiverAddress,String UserEmailAddress, String Header,String Topic,String DateTime) throws FileNotFoundException {
		EMails emails = new EMails(UserEmailAddress,Header, Topic, DateTime);
		mailDal.GetSpamEmails().add(emails.getRecieverMailAddress());  
		mailDal.GetSpamEmails().add(emails.getMailSubject()); 
		mailDal.GetSpamEmails().add(emails.getMailBody());	
		mailDal.GetSpamEmails().add(emails.getDateTime());
		WriteSpamMailsToFile(mailDal.GetSpamEmails(),ReceiverAddress);
				for(int a = 0; a < mailDal.GetList().size(); a+=4)
					if(mailDal.GetList().get(a).equalsIgnoreCase((UserEmailAddress)) && mailDal.GetList().get(a+3).equalsIgnoreCase(DateTime)) {
						mailDal.GetList().remove(a);  
						mailDal.GetList().remove(a);  
						mailDal.GetList().remove(a);   
						mailDal.GetList().remove(a);
      				break;
					} 		
				WriteMailsToFile(mailDal.GetList(),ReceiverAddress);  
				
      		}
	    	
	public void DeleteMails(String ReceiverAddress,String UserMailAddress, String Header,String Topic,String DateTime) throws FileNotFoundException {
		for(int a = 0; a < mailDal.GetList().size(); a+=4)
			if(mailDal.GetList().get(a).equalsIgnoreCase((UserMailAddress)) && mailDal.GetList().get(a+3).equalsIgnoreCase(DateTime)) { 
				mailDal.GetList().remove(a);  
				mailDal.GetList().remove(a);  
				mailDal.GetList().remove(a);    
				mailDal.GetList().remove(a);
			}
				WriteMailsToFile(mailDal.GetList(),ReceiverAddress);
	}
	
	public void WriteMail(String RecieverMailAddress,String UserMailAddress,String Subject,String Body) throws FileNotFoundException {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();
		   ArrayList<String> DefaultSpamList = new ArrayList<String>();
		   ArrayList<String> DefaultSubmitList = new ArrayList<String>();
		   ArrayList<String> DefaultMailList = new ArrayList<String>();
		   try (BufferedReader br = new BufferedReader(new FileReader("MailBox//" +RecieverMailAddress+ "#SpamMail.txt"))) 
		    {

		        String sCurrentLine;

		        while ((sCurrentLine = br.readLine()) != null) {
		        	DefaultSpamList.add(sCurrentLine);
		        }

		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    try (BufferedReader br = new BufferedReader(new FileReader("SentMailBox//" +UserMailAddress+ "#SentMailBox.txt")))
		    {

		        String sCurrentLine;

		        while ((sCurrentLine = br.readLine()) != null) {
		        	DefaultSubmitList.add(sCurrentLine);
		        }

		    } catch (IOException e) { 
		        e.printStackTrace();
		    }
		    try (BufferedReader br = new BufferedReader(new FileReader("MailBox//" +RecieverMailAddress+ "#MailBox.txt")))
		    {

		        String sCurrentLine;
 
		        while ((sCurrentLine = br.readLine()) != null) {  
		        	DefaultMailList.add(sCurrentLine);
		        }

		    } catch (IOException e) { 
		        e.printStackTrace();
		    }
		if(Subject.equalsIgnoreCase("")) {
				EMails spamemails = new EMails(UserMailAddress,Subject,Body,String.valueOf(now));  
				DefaultSpamList.add(spamemails.getRecieverMailAddress());
				DefaultSpamList.add("null");
				DefaultSpamList.add(spamemails.getMailBody()); 
				DefaultSpamList.add(spamemails.getDateTime());
				WriteSpamMailsToFile(DefaultSpamList,RecieverMailAddress); 
				
				EMails submitemails = new EMails(RecieverMailAddress,Subject,Body,String.valueOf(now) );
				DefaultSubmitList.add(submitemails.getRecieverMailAddress());
				DefaultSubmitList.add("null");
				DefaultSubmitList.add(submitemails.getMailBody()); 
				DefaultSubmitList.add(submitemails.getDateTime());	
				WriteSubmitMailsToFile(DefaultSubmitList,UserMailAddress);	
			}else {
				EMails emails = new EMails(UserMailAddress,Subject,Body,String.valueOf(now) );  
				mailDal.addObjectToList(emails);
				DefaultMailList.add(emails.getRecieverMailAddress());
				DefaultMailList.add(emails.getMailSubject());
				DefaultMailList.add(emails.getMailBody());  
				DefaultMailList.add(emails.getDateTime());
				WriteMailsToFile(DefaultMailList,RecieverMailAddress); 
						
				EMails submitemails = new EMails(RecieverMailAddress,Subject,Body,String.valueOf(now) );	
				DefaultSubmitList.add(submitemails.getRecieverMailAddress());
				DefaultSubmitList.add(submitemails.getMailSubject());
				DefaultSubmitList.add(submitemails.getMailBody()); 
				DefaultSubmitList.add(submitemails.getDateTime());	
				WriteSubmitMailsToFile(DefaultSubmitList,UserMailAddress);	 
				}
	}

	public ArrayList<String> GetSubmitMailInformation() throws FileNotFoundException{
		return mailDal.GetSubmitEmails();
	} 
	
	public ArrayList<String> GetMailInformation() throws FileNotFoundException{
		return mailDal.GetList();
	}
	
	public void DeleteSubmitMails(String ReceiverAddress,String UserMailAddress, String Header,String Topic,String DateTime) throws FileNotFoundException {
		for(int a = 0; a < mailDal.GetSubmitEmails().size(); a+=4)
			if(mailDal.GetSubmitEmails().get(a).equalsIgnoreCase((UserMailAddress)) && mailDal.GetSubmitEmails().get(a+3).equalsIgnoreCase((DateTime))) { 
				mailDal.GetSubmitEmails().remove(a); 
				mailDal.GetSubmitEmails().remove(a);  
				mailDal.GetSubmitEmails().remove(a);    
				mailDal.GetSubmitEmails().remove(a);
				break;
			}
				WriteSubmitMailsToFile(mailDal.GetSubmitEmails(),ReceiverAddress); 
	}
	
	public void DeleteSpamMails(String ReceiverAddress,String UserMailAddress, String Header,String Topic,String DateTime) throws FileNotFoundException {
		for(int a = 0; a < mailDal.GetSpamEmails().size(); a+=4)
			if(mailDal.GetSpamEmails().get(a).equalsIgnoreCase((UserMailAddress)) && mailDal.GetSpamEmails().get(a+3).equalsIgnoreCase((DateTime)) ) { 
				mailDal.GetSpamEmails().remove(a); 
				mailDal.GetSpamEmails().remove(a);  
				mailDal.GetSpamEmails().remove(a);    
				mailDal.GetSpamEmails().remove(a); 
				break;
			}
				WriteSpamMailsToFile(mailDal.GetSpamEmails(),ReceiverAddress); 
	}
	
	public void DeleteReadMails(String ReceiverAddress,String UserMailAddress, String Header,String Topic,String DateTime) throws FileNotFoundException {
		for(int a = 0; a < mailDal.GetReadEmails().size(); a+=4)
			if(mailDal.GetReadEmails().get(a).equalsIgnoreCase((UserMailAddress)) && mailDal.GetReadEmails().get(a+3).equalsIgnoreCase((DateTime))) { 
				mailDal.GetReadEmails().remove(a);  
				mailDal.GetReadEmails().remove(a);  
				mailDal.GetReadEmails().remove(a);    
				mailDal.GetReadEmails().remove(a);
				break;
			}
		WriteReadMailsToFile(mailDal.GetReadEmails(),ReceiverAddress);
	}

	public ArrayList<String> GetReadMailInformation() throws FileNotFoundException{
		return mailDal.GetReadEmails();
	}
	
	public ArrayList<String> GetSpamMailInformation() throws FileNotFoundException{
		return mailDal.GetSpamEmails();
	}

	public boolean IsValidEmail(String ReceiverAddress) throws FileNotFoundException {
		for(int i=1;i < userDal.GetList().size();i+=3) 
			if(userDal.GetList().get(i).equalsIgnoreCase(ReceiverAddress)) { 
				return true;  
			} 
				return false;
	}
	
	public void RemoveSpamMail(String ReceiverAddress,String UserEmailAddress, String Header,String Topic,String DateTime) throws FileNotFoundException {
		EMails emails = new EMails(ReceiverAddress,UserEmailAddress, Header, Topic);
		mailDal.addObjectToList(emails);
		mailDal.GetList().add(emails.getRecieverMailAddress());  
		mailDal.GetList().add(emails.getMailSubject()); 
		mailDal.GetList().add(emails.getMailBody());	
		mailDal.GetList().add(emails.getDateTime());
		WriteMailsToFile(mailDal.GetSpamEmails(),ReceiverAddress);  
				for(int a = 0; a < mailDal.GetSpamEmails().size(); a+=4)
					if(mailDal.GetList().get(a).equalsIgnoreCase((ReceiverAddress))) {
						mailDal.GetSpamEmails().remove(a);  
						mailDal.GetSpamEmails().remove(a);  
						mailDal.GetSpamEmails().remove(a);   
						mailDal.GetSpamEmails().remove(a);
      				break;
					} 		
				WriteSpamMailsToFile(mailDal.GetSpamEmails(),ReceiverAddress);   	 
      		}

	
	
}
	 

