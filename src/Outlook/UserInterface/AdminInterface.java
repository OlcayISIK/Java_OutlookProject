package Outlook.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class AdminInterface {
	public void getInterface() {
		JFrame frame = new JFrame("Admin Page");  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel labelpanel = new JPanel();
		labelpanel.setBackground(Color.white);
		labelpanel.setLocation(10, 10); 
		labelpanel.setSize(370,530);
		labelpanel.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.blue);
		panel.setLayout(null); 
		
		JLabel label = new JLabel("WELCOME"); 
		label.setSize(300, 80);
		label.setLocation(40, 20); 
		label.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		labelpanel.add(label);
		
		JLabel label2 = new JLabel("Admin Panel"); 
		label2.setSize(300, 110);
		label2.setLocation(40, 100); 
		label2.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		labelpanel.add(label2);
		
        ImageIcon AdminIcon = new ImageIcon("icons\\adminicon.png"); 
        Image SizeIcon5=AdminIcon.getImage();      
        AdminIcon = new ImageIcon(SizeIcon5.getScaledInstance(300,270,0));
        JButton AdminImage = new JButton(AdminIcon);
        AdminImage.disable();
        AdminImage.setSize(300,270);
        AdminImage.setLocation(40,210);
        AdminImage.disable();
        AdminImage.setBackground(Color.white);
        AdminImage.setBorder(new LineBorder(Color.white));
        labelpanel.add(AdminImage);
		
	    ImageIcon AddIcon = new ImageIcon("icons\\addicon.png"); 
	    Image SizeIcon=AddIcon.getImage();      
	    AddIcon = new ImageIcon(SizeIcon.getScaledInstance(60,60,0));				
		JButton add = new JButton(AddIcon);
		add.setText("Adding");
		add.setBackground(Color.orange);
		add.setLocation(400, 50);
		add.setSize(200, 200);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddingPanel adding = new AddingPanel();
				adding.getFrame();
				frame.dispose(); 

			} 
		});
		panel.add(add);
		
	    ImageIcon UpdateIcon = new ImageIcon("icons\\updateicon.png"); 
	    Image SizeIcon2=UpdateIcon.getImage();      
	    UpdateIcon = new ImageIcon(SizeIcon2.getScaledInstance(60,60,0));
		JButton update = new JButton(UpdateIcon);
		update.setText("Updating");
		update.setBackground(Color.orange); 
		update.setLocation(400, 300);
		update.setSize(200, 200);
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UpdatingPanel updating = new UpdatingPanel();
				updating.getFrame();
				frame.dispose();

			}
		});
		panel.add(update);
		
	    ImageIcon DeleteIcon = new ImageIcon("icons\\admindeleteicon.png"); 
	    Image SizeIcon3=DeleteIcon.getImage();      
	    DeleteIcon = new ImageIcon(SizeIcon3.getScaledInstance(60,60,0));
		JButton delete = new JButton(DeleteIcon);
		delete.setText("Deleting");
		delete.setBackground(Color.orange);
		delete.setLocation(650, 50);
		delete.setSize(200, 200);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DeletePanel deleting = new DeletePanel();
				deleting.getFrame();
				frame.dispose();

			}
		});
		panel.add(delete);
		
	    ImageIcon ListIcon = new ImageIcon("icons\\listingicon.png"); 
		Image SizeIcon4=ListIcon.getImage();      
	    ListIcon = new ImageIcon(SizeIcon4.getScaledInstance(60,60,0));
		JButton listing = new JButton(ListIcon);
		listing.setText("Listing");
		listing.setBackground(Color.orange);
		listing.setLocation(650, 300);
		listing.setSize(200, 200); 
		listing.addActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent e) {
				ListingPanel list = new ListingPanel();
				try {
					list.getFrame();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				frame.dispose();

			}
		});
		panel.add(listing);
		frame.add(labelpanel);
		frame.add(panel);
		frame.setSize(900, 600);
		frame.setVisible(true);
	}

}
