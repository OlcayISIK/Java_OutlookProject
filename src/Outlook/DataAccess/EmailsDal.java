package Outlook.DataAccess;

import java.util.ArrayList;
import java.util.Iterator;

import Outlook.Entities.EMails;
import Outlook.Entities.Users;

public class EmailsDal implements IDataDal { 
	public ArrayList<EMails> Emails = new ArrayList<>();
	public ArrayList<String> emails = (ArrayList<String>)(ArrayList<?>)(Emails);
	Iterator<String> it = emails.iterator(); 

	
	private ArrayList<EMails> ReadEmails = new ArrayList<>();
	public ArrayList<String> readEmails = (ArrayList<String>)(ArrayList<?>)(ReadEmails);
	Iterator<String> it2 = readEmails.iterator(); 
	 
	private ArrayList<EMails> SubmitEmails = new ArrayList<>();
	public ArrayList<String> submitEmails = (ArrayList<String>)(ArrayList<?>)(SubmitEmails);
	Iterator<String> it3 = submitEmails.iterator(); 
	
	public ArrayList<EMails> SpamEmails = new ArrayList<>();
	public ArrayList<String> spamEmails = (ArrayList<String>)(ArrayList<?>)(SpamEmails);
	Iterator<String> it4 = emails.iterator();  



	public ArrayList<String> GetReadEmails(){
		return readEmails;  
	}
	
	public ArrayList<String> GetSubmitEmails(){
		return submitEmails;  
	}
	
	public ArrayList<String> GetSpamEmails(){
		return spamEmails;  
	}

	@Override
	public ArrayList<String> GetList() {
		return emails;
	}

	@Override
	public void addObjectToList(Object o) {
		Emails.add((EMails) o);	
	}	
	
}
