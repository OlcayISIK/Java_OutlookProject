package Outlook.UserInterface;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

public class UpdatingPanel {
		AdminControl adminCtrl = new AdminControl();
		CustomerServiceControl CSCtrl = new CustomerServiceControl();
		public void getFrame() {
			JFrame frame= new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			JPanel UpdatingPanel = new JPanel();   
			UpdatingPanel.setLayout(null);
			UpdatingPanel.setVisible(true);
			UpdatingPanel.setSize(600,400);
			UpdatingPanel.setLocation(100, 100);
			UpdatingPanel.setBackground(Color.white);
			
			JPanel panel = new JPanel();   
			panel.setLayout(null);
			panel.setVisible(true); 
			
			JLabel select =new JLabel("Please Select:");
			select.setLocation(30, 0);     
			select.setSize(200, 130);   
			UpdatingPanel.add(select);
		    
			JComboBox Employee=new  JComboBox();	
			Employee.setLocation(150,50);
			Employee.setSize(150, 30); 
			Employee.addItem("User");
			Employee.addItem("Customer Service"); 
			UpdatingPanel.add(Employee);
			
			JLabel UserID =new JLabel("Please Enter User ID:");
			UserID.setLocation(50, 140);      
			UserID.setSize(200, 30);
			UserID.setVisible(true);
			UpdatingPanel.add(UserID);
			
			JLabel UserMail =new JLabel("Please Enter User MailAddress:");
			UserMail.setLocation(50, 200);     
			UserMail.setSize(200, 30); 
			UserMail.setVisible(true);
			UpdatingPanel.add(UserMail);
			
			JLabel UserPassword =new JLabel("Please Enter User Passoword");
			UserPassword.setLocation(50, 260);     
			UserPassword.setSize(200, 30); 
			UserPassword.setVisible(true);
			UpdatingPanel.add(UserPassword);
			
			JTextField UserIDtxt = new JTextField();
			UserIDtxt.setLocation(260, 140);
			UserIDtxt.setSize(200, 30);
			UserIDtxt.setVisible(true);
			UpdatingPanel.add(UserIDtxt);
			
			JTextField UserMailtxf = new JTextField();
			UserMailtxf.setLocation(260, 200);
			UserMailtxf.setSize(200, 30);
			UserMailtxf.setVisible(true);
			UserMailtxf.disable();
			UpdatingPanel.add(UserMailtxf); 
			
			JTextField UserPaswordtxf = new JTextField();
			UserPaswordtxf.setLocation(260, 260); 
			UserPaswordtxf.setSize(200, 30);
			UserPaswordtxf.setVisible(true);
			UserPaswordtxf.disable();
			UpdatingPanel.add(UserPaswordtxf);
			
	        ImageIcon UpadateUserIcon = new ImageIcon("icons\\updateusericon.png");  
	        Image SizeIcon=UpadateUserIcon.getImage();      
	        UpadateUserIcon = new ImageIcon(SizeIcon.getScaledInstance(40,40,0));
			JButton UpdateButton = new JButton(UpadateUserIcon);
			UpdateButton.setText("Update User");
			UpdateButton.setLocation(230, 340);     
			UpdateButton.setSize(250, 40); 
			UpdateButton.setVisible(true);
			UpdatingPanel.add(UpdateButton);
			
			JLabel CSID =new JLabel("CustomerService ID:");
			CSID.setLocation(50, 140);     
			CSID.setSize(250, 30); 
			CSID.setVisible(false);
			UpdatingPanel.add(CSID);
			
			JLabel CSName =new JLabel("CustomerService Name And Surname:"); 
			CSName.setLocation(50, 200);     
			CSName.setSize(250, 30); 
			CSName.setVisible(false);
			UpdatingPanel.add(CSName);
			
			JLabel CSSurname =new JLabel("Please Enter CustomerService Photo:");
			CSSurname.setLocation(50, 260);     
			CSSurname.setSize(250, 30); 
			CSSurname.setVisible(false);
			UpdatingPanel.add(CSSurname);
			
			JTextField CSIDtxf = new JTextField();
			CSIDtxf.setLocation(300, 140);
			CSIDtxf.setSize(200, 30);
			CSIDtxf.setVisible(false);
			UpdatingPanel.add(CSIDtxf);
			
			JTextField CSNametxf = new JTextField();
			CSNametxf.setLocation(300, 200);
			CSNametxf.setSize(200, 30);
			CSNametxf.setVisible(false);
			CSNametxf.disable();
			UpdatingPanel.add(CSNametxf);
			
			JTextField CSPhoto = new JTextField();
			CSPhoto.setLocation(300, 260);
			CSPhoto.setSize(200, 30);
			CSPhoto.setVisible(false);
			CSPhoto.disable();
			UpdatingPanel.add(CSPhoto);
			
			ImageIcon UpadateCSIcon = new ImageIcon("icons\\updateemployeeicon.png");  
	        Image SizeIcon2=UpadateCSIcon.getImage();      
	        UpadateCSIcon = new ImageIcon(SizeIcon2.getScaledInstance(40,40,0));
			JButton UpdateCS = new JButton(UpadateCSIcon);
			UpdateCS.setText("Update Customer Service");
			UpdateCS.setLocation(260, 340);     
			UpdateCS.setSize(250, 40); 
			UpdateCS.setVisible(false);
			UpdatingPanel.add(UpdateCS);
			
			Employee.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(((String) Employee.getSelectedItem()).equals("Customer Service")) {
						CSName.setVisible(true);
						CSSurname.setVisible(true); 
						UpdateCS.setVisible(true);
						CSID.setVisible(true);
						CSNametxf.setVisible(true);
						CSPhoto.setVisible(true);
						CSIDtxf.setVisible(true);
						
						UserID.setVisible(false);
						UserMail.setVisible(false);
						UpdateButton.setVisible(false);
						UserPassword.setVisible(false);
						UserIDtxt.setVisible(false);
						UserPaswordtxf.setVisible(false);
						UserMailtxf.setVisible(false);
					}else {
						CSName.setVisible(false);
						CSSurname.setVisible(false);
						UpdateCS.setVisible(false);
						CSID.setVisible(false);
						CSNametxf.setVisible(false);
						CSPhoto.setVisible(false);
						CSIDtxf.setVisible(false);
						
						UserID.setVisible(true);
						UserMail.setVisible(true);
						UpdateButton.setVisible(true);
						UserPassword.setVisible(true);
						UserIDtxt.setVisible(true);
						UserPaswordtxf.setVisible(true);
						UserMailtxf.setVisible(true);
					}
					
				}
			});
			
			UserIDtxt.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String Mail = adminCtrl.TakeMailInfo(UserIDtxt.getText());  
					
					if(Mail.equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(frame, "User Couldn't Find");
					}else {
						UserMailtxf.setText(adminCtrl.TakeMailInfo(UserIDtxt.getText()));
						UserPaswordtxf.setText(adminCtrl.TakePasswordInfo(UserIDtxt.getText()));
						UserPaswordtxf.enable(); 
						UserIDtxt.disable();
					}
					UpdateButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							adminCtrl.UpdateUserInfo(UserIDtxt.getText(), UserPaswordtxf.getText());
							JOptionPane.showMessageDialog(frame, "User Updated"); 
						}
					});	
				} 
			});
			
			CSIDtxf.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				String Username = CSCtrl.TakeCSNameInfo(CSIDtxf.getText());
				if(Username.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(frame, "User Couldn't Find");
				}else {
					CSNametxf.setText(CSCtrl.TakeCSNameInfo(CSIDtxf.getText()));
					CSPhoto.setText(CSCtrl.TakeCSPhotoInfo(CSIDtxf.getText()));  
					CSIDtxf.disable();
					CSPhoto.enable();
					CSNametxf.enable();
				}
				
				UpdateCS.addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent e) {
						CSCtrl.UpdateCustomerServiceInfo(CSIDtxf.getText(),CSNametxf.getText(),CSPhoto.getText());	
					}
				});
				
					
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
			
			frame.add(UpdatingPanel);
			frame.add(panel);  
			panel.add(tb);
			frame.setSize(800,700);   
	        frame.setVisible(true); 
	} 
}
