package Outlook.Entities;

public class EMails{
	private String RecieverMailAddress;
	private String DateTime;
	private String MailSubject;
	private String MailBody;

	
	public EMails(String RecieverMailAddress,String MailSubject,String MailBody,String DateTime) {
		this.RecieverMailAddress = RecieverMailAddress;  
		this.MailSubject = MailSubject;
		this.MailBody = MailBody;
		this.DateTime = DateTime; 
	}
	
	
	public String getRecieverMailAddress() {
		return RecieverMailAddress;
	}
	
	public String getMailSubject() {
		return MailSubject;
	}
	
	public String getMailBody() {
		return MailBody;
	}
	public String getDateTime() {
		return DateTime;
	}
}
