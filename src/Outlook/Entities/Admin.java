package Outlook.Entities;

public class Admin {
	 private String Email;
	 private String Password;
	   

	    public Admin(String Email,String Password){
	        this.Email = Email;
	        this.Password = Password; 
	        
	    }

	    public String getEmail() {
	        return Email;
	    }
	    

		public String getPassword() {
			return Password;
		}
}
