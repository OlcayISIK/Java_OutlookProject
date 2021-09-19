package Outlook.UserInterface;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Outlook.Controls.LoginControl;

public class LoginInterface  {
	private LoginControl loginControl = new LoginControl();
	private static LoginInterface loginInterface = new LoginInterface();

	private void LoginInterface() {
	}

	public static LoginInterface getlogin() {
		return loginInterface;
	}
	boolean k = false;

	public void getFrame() throws IOException { 
		
		JFrame frame = new JFrame("Login Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainpanel = new JPanel();
		mainpanel.setBackground(Color.blue);
		mainpanel.setLayout(null); 
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLocation(150, 150);  
		panel.setSize(500,400);
		panel.setLayout(null);
		
		ImageIcon icon = new ImageIcon("wallpapers\\logininterfacephoto.jpg");
		JLabel label = new JLabel(icon);
		label.setIcon(icon);
		label.setSize(800, 1080);
		label.setLocation(0, -280); 
		mainpanel.add(label);

		JLabel signlbl = new JLabel("Don't You Have an Account ?");
		signlbl.setLocation(280, 310);
		signlbl.setSize(300, 50);
		panel.add(signlbl);

		JLabel Usernamelbl = new JLabel("Please Enter Your Mail Address:"); 
		Usernamelbl.setLocation(50, 30); 
		Usernamelbl.setSize(200, 200);
		panel.add(Usernamelbl); 

		JLabel Passwordlbl = new JLabel("Please Enter the Password:");
		Passwordlbl.setLocation(50, 100);
		Passwordlbl.setSize(200, 200);
		panel.add(Passwordlbl);

		JTextField mailAddress = new JTextField();
		mailAddress.setLocation(260, 115);
		mailAddress.setSize(150, 30);
		panel.add(mailAddress);

		JPasswordField password = new JPasswordField(); 
		password.setLocation(260, 185);
		password.setSize(150, 30);
		panel.add(password);

		JButton add = new JButton("LOGIN");
		add.setLocation(50, 280);
		add.setSize(150, 45);
		add.setBackground(Color.CYAN);
		add.setToolTipText("Login your Stock Management Program");
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
							try {
								if(loginControl.CheckLogin(mailAddress.getText(),password.getText())) {
									OutlookInterface outlookInterface = new OutlookInterface(); 
									outlookInterface.getInterface(mailAddress.getText());     
									frame.dispose();
								}
								else if(loginControl.CheckAdminLogin(mailAddress.getText(), password.getText())) {
									AdminInterface adminInterface = new AdminInterface(); 
									adminInterface.getInterface();    
									frame.dispose(); 
								}  
								else {
									JOptionPane.showMessageDialog(frame, " Your username or password is wrong.");
								}
							} catch (HeadlessException | FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}
		});

		JButton register = new JButton("SIGNUP");
		register.setLocation(280, 280); 
		register.setSize(150, 45);
		register.setBackground(Color.CYAN); 
		register.setToolTipText("If you haven't registered yet"); 
		register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterInterface register = new RegisterInterface();
				register.getFrame();
				frame.dispose(); 
			}
		});


		panel.add(register);
		panel.add(add);
		panel.add(password);
		frame.add(panel);
		frame.add(mainpanel);
		frame.setSize(800, 800);
		frame.setVisible(true);
	}

}

