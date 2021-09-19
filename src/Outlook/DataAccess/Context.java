package Outlook.DataAccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Outlook.Entities.CustomerService;
import Outlook.Entities.Users;


public abstract class Context {
	protected UserDal userDal = new UserDal();
	protected EmailsDal mailDal = new EmailsDal();
	protected AdminDal adminDal = new AdminDal();
	protected CustomerServiceDal customerServiceDal = new CustomerServiceDal();
	
	
	public void WriteAdmin(ArrayList<String> UserInfo) {
		File file = new File("C:\\Users\\ABRA\\eclipse-workspace\\OutlookProject\\admins.txt"); 
		FileWriter fw = null; 
		try {
			fw = new FileWriter(file);
		} catch (IOException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int a = 0; a < UserInfo.size(); a++)
		{
			try {
				fw.write(UserInfo.get(a) + "\n"); 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();  
			}
		}

		try {
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // Close the file.

	}

	public void WriteUser(ArrayList<String> UserInfo) {
		File file = new File("C:\\Users\\ABRA\\eclipse-workspace\\OutlookProject\\users.txt"); 
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int a = 0; a < UserInfo.size(); a++)
		{
			try {
				fw.write(UserInfo.get(a) + "\n"); 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); 
			}
		}

		try {
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // Close the file.

	}
	
	public void WriteMailsToFile(ArrayList<String> MailInfo,String MailAddress) {
		File file = new File("MailBox//" +MailAddress+ "#MailBox.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int a = 0; a < MailInfo.size(); a++)
		{
			try {
				fw.write(MailInfo.get(a) + "\n"); 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); 
			}
		}

		try {
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // Close the file.

	}

	public void WriteReadMailsToFile(ArrayList<String> MailInfo,String MailAddress) {
		File file = new File("MailBox//" +MailAddress+ "#ReadMail.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int a = 0; a < MailInfo.size(); a++)
		{
			try {
				fw.write(MailInfo.get(a) + "\n"); 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); 
			}
		}

		try {
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // Close the file.
	}
	
	public void WriteSubmitMailsToFile(ArrayList<String> MailInfo,String MailAddress) {
		File file = new File("SentMailBox//" +MailAddress+ "#SentMailBox.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int a = 0; a < MailInfo.size(); a++)
		{
			try {
				fw.write(MailInfo.get(a) + "\n"); 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); 
			}
		}

		try {
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // Close the file.
	}

	public void WriteSpamMailsToFile(ArrayList<String> MailInfo,String MailAddress) {
		File file = new File("MailBox//" +MailAddress+ "#SpamMail.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int a = 0; a < MailInfo.size(); a++)
		{
			try {
				fw.write(MailInfo.get(a) + "\n"); 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); 
			}
		}

		try {
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // Close the file.
}

	public void WriteCustomerServiceToFile(ArrayList<String> CustomerServiceInfo) {
		File file = new File("C:\\Users\\ABRA\\eclipse-workspace\\OutlookProject\\customerservice.txt");
		FileWriter fw = null; 
		try {
			fw = new FileWriter(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int a = 0; a < CustomerServiceInfo.size(); a++)
		{
			try {
				fw.write(CustomerServiceInfo.get(a) + "\n"); 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); 
			}
		}

		try {
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public ArrayList<String> ReadCustomerService() throws FileNotFoundException {
		ArrayList<String> DefaultList = new ArrayList<String>();
		File file = new File("C:\\Users\\ABRA\\eclipse-workspace\\OutlookProject\\customerservice.txt");
		Scanner read = new Scanner(file);  

		while (read.hasNextLine()) {
			String write = read.nextLine();
			DefaultList.add(write);
		}
		for(int y=0; y< DefaultList.size();y++) {
			customerServiceDal.GetList().add(DefaultList.get(y));
		}
		
		return customerServiceDal.GetList();
	}

	public void CreateFile(String MailAddress) throws IOException {

        File file = new File("MailBox//" +MailAddress+ "#MailBox.txt");
        if (!file.exists()) {
            file.createNewFile(); 
        }
        File file2 = new File("SentMailBox//" +MailAddress+ "#SentMailBox.txt");
        if (!file2.exists()) {
            file2.createNewFile();
        }   
        File file3 = new File("MailBox//" +MailAddress+ "#SpamMail.txt");
        if (!file3.exists()) {
            file3.createNewFile(); 
        }
        File file4 = new File("MailBox//" +MailAddress+ "#ReadMail.txt");
        if (!file4.exists()) {
            file4.createNewFile();
        }
        
	}
	
	public void WriteCompliement(ArrayList<String> UserInfo) throws IOException {
        File file = new File("compliement.txt");
        if (!file.exists()) {
            file.createNewFile(); 
        }else {
 
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int a = 0; a < UserInfo.size(); a++)
		{
			try {
				fw.write(UserInfo.get(a) + "\n"); 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); 
			}
		}

		try {
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}// Close the file.
        }

	}
}


	
	