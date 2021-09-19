package Outlook.UserInterface;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Outlook.Controls.CustomerServiceControl;

public class HelpPanel extends JPanel {
	CustomerServiceControl CSCtrl = new CustomerServiceControl();

public HelpPanel(String eMailAddress) throws FileNotFoundException{
		
        JPanel panel = new JPanel();
        this.setLayout(null);
   
        
		JButton GetHelp = new JButton("Get Help From \n Customer Service"); 
		GetHelp.setLocation(300, 200);  
		GetHelp.setSize(300, 60);
		GetHelp.setVisible(true);
		this.add(GetHelp);
		
		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("icons\\customerserviceicon.png"); 
        Image SizeIcon=icon.getImage();      
        icon = new ImageIcon(SizeIcon.getScaledInstance(300,300,0));
		label.setSize(300,300);  
		label.setLocation(85,50); 
	    label.setIcon(icon); 
	    label.setVisible(false);
	    this.add(label);
		 
		
		JButton SendCompliement = new JButton("Send Compliement"); 
		SendCompliement.setLocation(475, 450); 
		SendCompliement.setSize(200, 30);
		SendCompliement.setVisible(false);
		this.add(SendCompliement);
		
		JTextArea Compliementtxt = new JTextArea();
		Compliementtxt.setLocation(400, 25);
		Compliementtxt.setSize(400, 400);
		Compliementtxt.setVisible(false);
		this.add(Compliementtxt);
		
		GetHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			      JPanel CompliementPanel = new JPanel();
			      CompliementPanel.setLayout(null);
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(panel, "Hello My Name is "+ CSCtrl.GenerateEmployeeName() + " I'm Here To Help You Please Write Your Compliement"); 
				

				GetHelp.setVisible(false); 
				Compliementtxt.setVisible(true); 
				SendCompliement.setVisible(true);
				label.setVisible(true);
				
				SendCompliement.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							CSCtrl.SendCompliement(eMailAddress,Compliementtxt.getText());
							JOptionPane.showMessageDialog(panel, "Compliement Sended");
						} catch (IOException e) {
							JOptionPane.showMessageDialog(panel, "Something Gone Wrong");
							e.printStackTrace();
						}
						
					}
				});
			}
		});	 
        
	

}
}

