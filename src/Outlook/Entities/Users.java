package Outlook.Entities;

import java.io.Serializable;

public class Users {
    private int id;
    private String MailAddress;
    private String password;
   

    public Users(int id,String MailAddress,String password){
        this.id = id;
        this.MailAddress = MailAddress;
        this.password = password; 
        
    }

    public int getId() {
        return id;
    }
    

	public String getPassword() {
		return password;
	}

	public String getMailAddress() {
		return MailAddress;
	}
	
}