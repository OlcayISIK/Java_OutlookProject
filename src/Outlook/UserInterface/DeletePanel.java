package Outlook.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Outlook.Controls.AdminControl;
import Outlook.Controls.CustomerServiceControl;
 
public class DeletePanel {
	AdminControl adminCtrl = new AdminControl();
	CustomerServiceControl CSCtrl = new CustomerServiceControl();
	public void getFrame() {
		JFrame frame = new JFrame("Deleting Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
		JPanel panel = new JPanel(); 
		panel.setLayout(null);
			
		JLabel select =new JLabel("Please Select:");
		select.setLocation(30, 0);      
		select.setSize(200, 130);   
		select.setForeground(Color.white);
		panel.add(select);
	    
		JComboBox Employee=new  JComboBox();	 
		Employee.setLocation(180,50);
		Employee.setSize(150, 30); 
		Employee.addItem("User");
		Employee.addItem("Customer Service");  
		panel.add(Employee);
		
		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("wallpapers\\delete.jpg");
		label.setSize(800, 300);
		label.setLocation(-200, 0);
		label.setIcon(icon); 

		JLabel UserID = new JLabel("Enter The User ID:");
		UserID.setLocation(10, 10);
		UserID.setSize(300, 200); 
		panel.add(UserID);
		UserID.setForeground(Color.white);
		UserID.setFont(new Font("TimesRoman", Font.PLAIN, 20));

		JTextField UserIDtxf = new JTextField();
		UserIDtxf.setLocation(300, 100);
		UserIDtxf.setSize(150, 30);
		panel.add(UserIDtxf); 
		
        ImageIcon DeleteUserIcon = new ImageIcon("icons\\deleteusericon.png");   
        Image SizeIcon=DeleteUserIcon.getImage();      
        DeleteUserIcon = new ImageIcon(SizeIcon.getScaledInstance(40,40,0));
		JButton delete = new JButton(DeleteUserIcon);
		delete.setText("Delete User");
		delete.setLocation(150, 160);
		delete.setSize(200, 50);
		delete.setBackground(Color.red); 
		delete.setForeground(Color.white);
		delete.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		panel.add(delete);
		
		JLabel CSID = new JLabel("Enter CustomerService ID:");
		CSID.setLocation(10, 10);
		CSID.setSize(300, 200);
		CSID.setVisible(false);
		CSID.setForeground(Color.white);
		CSID.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		panel.add(CSID);
		
		JTextField CSIDtxf = new JTextField();
		CSIDtxf.setLocation(300, 100);
		CSIDtxf.setSize(150, 30);
		CSIDtxf.setVisible(false);
		panel.add(CSIDtxf);
		
        ImageIcon DeleteCSIcon = new ImageIcon("icons\\deleteusericon.png");  
        Image SizeIcon2=DeleteCSIcon.getImage();      
        DeleteCSIcon = new ImageIcon(SizeIcon2.getScaledInstance(40,40,0));
		JButton DeleteCS = new JButton(DeleteCSIcon);
		DeleteCS.setText("Delete Customer Service");
		DeleteCS.setLocation(100, 160);
		DeleteCS.setSize(300, 50);
		DeleteCS.setVisible(false);
		DeleteCS.setBackground(Color.red);
		DeleteCS.setForeground(Color.white);
		DeleteCS.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		panel.add(DeleteCS);
		
		Employee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(((String) Employee.getSelectedItem()).equals("Customer Service")) { 
					CSID.setVisible(true);
					CSIDtxf.setVisible(true);
					DeleteCS.setVisible(true);
					
					UserID.setVisible(false);
					UserIDtxf.setVisible(false);
					delete.setVisible(false);
				}else {
					CSID.setVisible(false);
					CSIDtxf.setVisible(false);
					DeleteCS.setVisible(false);
					
					delete.setVisible(true);
					UserID.setVisible(true);
					UserIDtxf.setVisible(true); 
				}
			}
		});
		DeleteCS.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(CSCtrl.DeleteCustomerService(CSIDtxf.getText())) {
						JOptionPane.showMessageDialog(frame, "Customer Service Deleted");
					}else {
						JOptionPane.showMessageDialog(frame, "Customer Service Couldn't Find");
					}	
				}
			});
			delete.addActionListener(new ActionListener() {
				 
				@Override
				public void actionPerformed(ActionEvent e) {
					if(adminCtrl.DeleteUser(UserIDtxf.getText())){
						JOptionPane.showMessageDialog(frame, "User Deleted");
					}else {
						JOptionPane.showMessageDialog(frame, "User Couldn't Find");
					}	
					
				}
			});
			
			JButton tb = new JButton("Turn Back"); 
			tb.setBackground(Color.YELLOW);
			tb.setLocation(350, 250);
			tb.setSize(100, 30);
			tb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminInterface adminInterface = new AdminInterface();
				adminInterface.getInterface();
			}
		});
			
			frame.add(panel);
			panel.add(label);
			panel.add(tb);
			frame.setSize(600, 340);
			frame.setVisible(true);
	} 

}
