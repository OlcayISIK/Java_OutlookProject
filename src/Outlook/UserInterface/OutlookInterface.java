package Outlook.UserInterface;

import java.awt.*;
import java.io.FileNotFoundException;

import javax.swing.*;

public class OutlookInterface {
	  
	 public static void getInterface(String EMailAddress) throws FileNotFoundException {
	        //Restaurant restaurant = new Restaurant();

	        JFrame frame = new JFrame("Project"); 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(900, 600);
	        frame.setMinimumSize(new Dimension(900, 600));

	        JTabbedPane tabbedPane = new JTabbedPane();

	        JPanel MailPanel = new MailPanel(EMailAddress);   
	        tabbedPane.add("MailBox", MailPanel);  
	        
	        JPanel SubmittedPanel = new SubmittedPanel(EMailAddress);
	        tabbedPane.add("SentMailBox", SubmittedPanel);
	     
	        JPanel ReadPanel = new ReadPanel(EMailAddress); 
	        tabbedPane.add("Read", ReadPanel);
	           
	        JPanel SpamPanel = new SpamPanel(EMailAddress);
	        tabbedPane.add("Spam", SpamPanel); 

	        JPanel HelpPanel = new HelpPanel(EMailAddress);
	        tabbedPane.add("Help", HelpPanel);
	        	        
	        


	        frame.add(tabbedPane);
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }
}
