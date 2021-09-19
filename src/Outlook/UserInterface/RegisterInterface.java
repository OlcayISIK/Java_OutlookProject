package Outlook.UserInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import Outlook.Controls.LoginControl;
import Outlook.Controls.RegisterControl;

public class RegisterInterface {
	RegisterControl registerCtrl = new RegisterControl();
	public void getFrame() {
		JFrame frame = new JFrame("Register Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("");
		label.setSize(690, 685);
		label.setLocation(-15, -100); 
		label.setIcon(icon);

		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLocation(150, 150); 
		panel.setSize(500,400);
		panel.setLayout(null);
		
		JPanel mainpanel = new JPanel();
		mainpanel.setBackground(Color.blue);
		mainpanel.setLayout(null);

		JLabel emailAddress = new JLabel("Email Address :");
		emailAddress.setSize(100, 30); 
		emailAddress.setLocation(50, 100);
		panel.add(emailAddress);
		
		JTextField mailAddress = new JTextField();
		mailAddress.setLocation(220, 100);
		mailAddress.setSize(230, 30);
		panel.add(mailAddress);

		JLabel passl = new JLabel("Password :");
		passl.setSize(200, 30);
		passl.setLocation(50, 170);
		panel.add(passl);
		JPasswordField password = new JPasswordField();
		password.setLocation(220, 170);
		password.setSize(230, 30);
		panel.add(password);

		JLabel passl1 = new JLabel("Password Repeat :");
		passl1.setSize(200, 30);
		passl1.setLocation(50, 240);
		panel.add(passl1);
		JPasswordField password2 = new JPasswordField();
		password2.setLocation(220, 240);
		password2.setSize(230, 30);
		
        ImageIcon RegiterIcon = new ImageIcon("icons\\registericon.png");     
        Image SizeIcon=RegiterIcon.getImage();        
        RegiterIcon = new ImageIcon(SizeIcon.getScaledInstance(40,40,0));
        JButton Register = new JButton(RegiterIcon);
        Register.setText("Sign-Up Now"); 
        Register.setSize(200,40);
        Register.setLocation(50,310); 
        Register.setBackground(Color.white);
        Register.setBorder(new LineBorder(Color.white)); 
        panel.add(Register);
        
        Register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (password.getText().equals(password2.getText())) {
					try {
						if(registerCtrl.CheckMailAddress(mailAddress.getText(), password.getText())){
							JOptionPane.showMessageDialog(frame, " This E-mail is Taken");
						}else {
						if(registerCtrl.RegisterUser(mailAddress.getText(), password.getText())) {
							JOptionPane.showMessageDialog(frame, " Register Complete.");    
						} else {
							JOptionPane.showMessageDialog(frame, " Please Enter the Mail in True Format"); 
						}
						}
					} catch (HeadlessException e) { 
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Your password didn't match"); 
				}
			}
		});

		JButton tb = new JButton("Go Login"); 
		tb.setBackground(Color.cyan);
		tb.setLocation(350, 310);
		tb.setSize(100, 30);
		tb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginInterface loginInterface = LoginInterface.getlogin(); 
				try {
					loginInterface.getFrame(); 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(password2);  
		panel.add(tb);
		panel.add(label);
		frame.add(panel);
		frame.add(mainpanel);
		frame.setSize(800, 800);
		frame.setVisible(true);

	}
}
