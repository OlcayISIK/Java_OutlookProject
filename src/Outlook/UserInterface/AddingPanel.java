package Outlook.UserInterface;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;

import Outlook.Controls.AdminControl;
import Outlook.Controls.CustomerServiceControl;

public class AddingPanel {
	AdminControl adminCtrl = new AdminControl();
	CustomerServiceControl CSCtrl = new CustomerServiceControl();
	public void getFrame() {
		JFrame frame= new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		JPanel AddingPanel = new JPanel();   
		AddingPanel.setLayout(null);
		AddingPanel.setVisible(true); 
		AddingPanel.setSize(600,400);
		AddingPanel.setLocation(100, 100);
		AddingPanel.setBackground(Color.white);
		
		JPanel panel = new JPanel();   
		panel.setLayout(null);
		panel.setVisible(true); 
		
		JLabel select =new JLabel("Please Select:");
		select.setLocation(30, 0);     
		select.setSize(100, 130);   
		AddingPanel.add(select);
	     
		JComboBox Employee=new  JComboBox();	  
		Employee.setLocation(140,50);
		Employee.setSize(150, 30); 
		Employee.addItem("Admin");
		Employee.addItem("Customer Service");
		AddingPanel.add(Employee);
		
		JLabel AdminMail =new JLabel("Please Enter Admin Mail Address:");
		AdminMail.setLocation(50, 120);      
		AdminMail.setSize(200, 30);
		AdminMail.setVisible(true);
		AddingPanel.add(AdminMail);
		
		JLabel AdminPassword =new JLabel("Please Enter Admin Password:");
		AdminPassword.setLocation(50, 200);     
		AdminPassword.setSize(200, 30);  
		AdminPassword.setVisible(true);
		AddingPanel.add(AdminPassword);
		
		JLabel AdminPasswordRepeat =new JLabel("Please Repeat Admin Password:");
		AdminPasswordRepeat.setLocation(50, 280);     
		AdminPasswordRepeat.setSize(300, 30); 
		AdminPasswordRepeat.setVisible(true);
		AddingPanel.add(AdminPasswordRepeat);
		
		JTextField AdminMailtxt = new JTextField();
		AdminMailtxt.setLocation(260, 120);
		AdminMailtxt.setSize(200, 30);
		AdminMailtxt.setVisible(true);
		AddingPanel.add(AdminMailtxt);
		
		JPasswordField Passwordtxf = new JPasswordField();
		Passwordtxf.setLocation(260, 200);
		Passwordtxf.setSize(200, 30);
		Passwordtxf.setVisible(true);
		AddingPanel.add(Passwordtxf);
		
		JPasswordField RepPasswordtxf = new JPasswordField();
		RepPasswordtxf.setLocation(260, 280);
		RepPasswordtxf.setSize(200, 30);
		RepPasswordtxf.setVisible(true);
		AddingPanel.add(RepPasswordtxf); 
		
        ImageIcon AddAdminIcon = new ImageIcon("icons\\addadminicon.png");  
        Image SizeIcon=AddAdminIcon.getImage();      
        AddAdminIcon = new ImageIcon(SizeIcon.getScaledInstance(40,40,0));
		JButton AddButton = new JButton(AddAdminIcon); 
		AddButton.setText("Add Admin");
		AddButton.setLocation(260, 340);     
		AddButton.setSize(200, 30); 
		AddButton.setVisible(true);
		AddingPanel.add(AddButton);
		
		JLabel CSName =new JLabel("Please Enter Name And Surname:");
		CSName.setLocation(50, 120);     
		CSName.setSize(300, 30); 
		CSName.setVisible(false);
		AddingPanel.add(CSName);
		
		JLabel CSSurname =new JLabel("Please Enter CustomerService Photo:");
		CSSurname.setLocation(50, 200);     
		CSSurname.setSize(300, 30); 
		CSSurname.setVisible(false);
		AddingPanel.add(CSSurname);
		
		
		JTextField CSNametxf = new JTextField();
		CSNametxf.setLocation(300, 120);
		CSNametxf.setSize(200, 30); 
		CSNametxf.setVisible(false);
		AddingPanel.add(CSNametxf);
		
		JTextField CSPhoto = new JTextField();
		CSPhoto.setLocation(300, 200);
		CSPhoto.setSize(200, 30);
		CSPhoto.setVisible(false);
		AddingPanel.add(CSPhoto);
		
        ImageIcon AddCSIcon = new ImageIcon("icons\\addusericon.png");  
        Image SizeIcon2=AddCSIcon.getImage();      
        AddCSIcon = new ImageIcon(SizeIcon2.getScaledInstance(40,40,0));
		JButton AddCS = new JButton(AddCSIcon);
		AddCS.setText("Add Customer Service");
		AddCS.setLocation(300, 260);     
		AddCS.setSize(200, 30);  
		AddCS.setVisible(false);
		AddingPanel.add(AddCS);
		
	
		
		Employee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(((String) Employee.getSelectedItem()).equals("Customer Service")) {
					CSName.setVisible(true);
					CSSurname.setVisible(true); 
					AddCS.setVisible(true);
					CSNametxf.setVisible(true);
					CSPhoto.setVisible(true);
					
					AdminMail.setVisible(false);
					AdminPassword.setVisible(false);
					AddButton.setVisible(false);
					AdminPasswordRepeat.setVisible(false);
					AdminMailtxt.setVisible(false);
					Passwordtxf.setVisible(false);
					RepPasswordtxf.setVisible(false);
				}else {
					CSName.setVisible(false);
					CSSurname.setVisible(false);
					AddCS.setVisible(false);
					CSNametxf.setVisible(false);
					CSPhoto.setVisible(false);
					
					AdminMail.setVisible(true);
					AdminPassword.setVisible(true);
					AddButton.setVisible(true);
					AdminPasswordRepeat.setVisible(true);
					AdminMailtxt.setVisible(true);
					Passwordtxf.setVisible(true);
					RepPasswordtxf.setVisible(true);
				}
				
			}
		});
		
		AddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(adminCtrl.AddAdmin(AdminMailtxt.getText(), Passwordtxf.getText(),RepPasswordtxf.getText())) {
					JOptionPane.showMessageDialog(frame, "Adding Completed");
				}else {
					JOptionPane.showMessageDialog(frame, "Passwords Didn't Match");
				}
				
			}
		});
		
		AddCS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					CSCtrl.AddCustomerService(CSNametxf.getText(), CSPhoto.getText());
					JOptionPane.showMessageDialog(frame, "Adding Completed");
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(frame, "One Problem Occured");
					e.printStackTrace();
				} 
				
			}
		});
		
		JButton tb = new JButton("Turn Back");
		tb.setBackground(Color.YELLOW);
		tb.setLocation(500, 550);
		tb.setSize(200, 40);
		tb.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			AdminInterface adminInterface = new AdminInterface();
			adminInterface.getInterface();
		} 
	});
	
		frame.add(AddingPanel); 
		frame.add(panel);
		panel.add(tb);
		frame.setSize(800,700);  
        frame.setVisible(true);  
	}

}
