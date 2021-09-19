package Outlook.UserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Outlook.Controls.ErrorControl;
import Outlook.Controls.MailListControl;
import Outlook.DataAccess.Context;

public class MailPanel extends JPanel {
	
	
	public MailPanel(String eMailAddress) throws FileNotFoundException{ 
		MailListControl mailCtrl = new MailListControl(eMailAddress);
		
		JPanel ErrorPanel = new JPanel();    
		ErrorPanel.setLayout(null);
        this.setLayout(null);
        this.add(ErrorPanel);
        
        this.setBackground(Color.white); 

        DefaultTableModel list = new DefaultTableModel();
        list.addColumn("MailAddress");   
        list.addColumn("Header"); 
        list.addColumn("Topic");
        list.addColumn("Read");
        JTable table = new JTable(list);  
        table.setLayout(new BorderLayout()); 
        JScrollPane spanel = new JScrollPane(table); 
        spanel.setSize(600 ,450);
        spanel.setLocation(0,0);
        table.setBackground(Color.red);
        table.setForeground(Color.white);
        this.add(spanel, BorderLayout.CENTER); 
        
        JLabel SearchLbl = new JLabel("Search Mail"); 
        SearchLbl.setLocation(100, 470);
        SearchLbl.setSize(200,30);
		TableRowSorter sorter = new TableRowSorter<>(list);
		table.setRowSorter(sorter);
		this.add(SearchLbl);
        
        JTextField Searchtxf = new JTextField(15);
        Searchtxf.setLocation(200, 470);
        Searchtxf.setSize(200,30);
        this.add(Searchtxf);
        
        ImageIcon SearchMailIcon = new ImageIcon("icons\\searchmailicon.png"); 
        Image SIcon=SearchMailIcon.getImage();      
        SearchMailIcon = new ImageIcon(SIcon.getScaledInstance(40,40,0));
        JButton Search = new JButton(SearchMailIcon);
        Search.disable();
        Search.setSize(60,60);
        Search.setLocation(410,450);
        Search.disable();
        Search.setBackground(Color.white);
        Search.setBorder(new LineBorder(Color.white));
        this.add(Search);
               
        ImageIcon MailIcon = new ImageIcon("icons\\mailicon.png");  
        Image SizeIcon=MailIcon.getImage();      
        MailIcon = new ImageIcon(SizeIcon.getScaledInstance(60,60,0));
        JButton IconButton = new JButton(MailIcon);
        IconButton.setText("Welcome MailBox");
        IconButton.setSize(300,60);
        IconButton.setLocation(600,20);
        IconButton.disable();
        IconButton.setBackground(Color.red);
        IconButton.setBorder(new LineBorder(Color.white));
        this.add(IconButton);
        
        ImageIcon RefreshIcon = new ImageIcon("icons\\refreshicon.png");  
        Image SizeIcon6=RefreshIcon.getImage();      
        RefreshIcon = new ImageIcon(SizeIcon6.getScaledInstance(40,40,0));
        JButton Refresh = new JButton(RefreshIcon); 
        Refresh.setText("Refresh The List");
        Refresh.setSize(200,40);
        Refresh.setLocation(650,100);
        Refresh.setBackground(Color.white);
        Refresh.setForeground(Color.black);
        Refresh.setBorder(new LineBorder(Color.white));
        this.add(Refresh);
        
        ImageIcon ReadIcon = new ImageIcon("icons\\readicon.png");    
        Image SizeIcon2=ReadIcon.getImage();      
        ReadIcon = new ImageIcon(SizeIcon2.getScaledInstance(40,40,0)); 
        JButton Mark = new JButton(ReadIcon);
        Mark.setText("Mark As Read");
        Mark.setSize(200,40);
        Mark.setLocation(650,180); 
        Mark.setBackground(Color.white);
        Mark.setBorder(new LineBorder(Color.white));
        this.add(Mark);
        
        ImageIcon DeleteIcon = new ImageIcon("icons\\deleteicon.png");   
        Image SizeIcon3=DeleteIcon.getImage();      
        DeleteIcon = new ImageIcon(SizeIcon3.getScaledInstance(40,40,0));
        JButton Delete = new JButton(DeleteIcon);
        Delete.setText("Delete Mail");
        Delete.setSize(200,40);
        Delete.setLocation(650,260);
        Delete.setBackground(Color.white);
        Delete.setBorder(new LineBorder(Color.white));
        this.add(Delete); 
        
        ImageIcon SendIcon = new ImageIcon("icons\\sendicon.png");  
        Image SizeIcon4=SendIcon.getImage();      
        SendIcon = new ImageIcon(SizeIcon4.getScaledInstance(50,50,0));
        JButton Write = new JButton(SendIcon); 
        Write.setText("Send Email");
        Write.setSize(200,40);
        Write.setLocation(650,340);
        Write.setBackground(Color.white);
        Write.setBorder(new LineBorder(Color.white)); 
        this.add(Write);
        
        ImageIcon SpamIcon = new ImageIcon("icons\\spamicon.png");  
        Image SizeIcon5=SpamIcon.getImage();       
        SpamIcon = new ImageIcon(SizeIcon5.getScaledInstance(40,40,0));
        JButton Spam = new JButton(SpamIcon); 
        Spam.setText("Mark As Spam"); 
        Spam.setSize(200,40);
        Spam.setLocation(650,420); 
        Spam.setBackground(Color.white);
        Spam.setBorder(new LineBorder(Color.white)); 
        this.add(Spam);
               

        int i = 0;
        for(i=0;i < mailCtrl.GetMailInformation().size();i+=4) {   
        	     	list.addRow(
        					new Object[] { mailCtrl.GetMailInformation().get(i),   
        							mailCtrl.GetMailInformation().get(i+1),mailCtrl.GetMailInformation().get(i+2),mailCtrl.GetMailInformation().get(i+3)}); 
        }
        
Searchtxf.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				searchMail(Searchtxf.getText());
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				searchMail(Searchtxf.getText());
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				searchMail(Searchtxf.getText());
				
			}
		      public void searchMail(String str) {
		            if (str.length() == 0) {
		               sorter.setRowFilter(null);
		            } else {
		               sorter.setRowFilter(RowFilter.regexFilter(str)); 
		            }
		         }
		      });
        
        table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrame frame=new JFrame("Information");  
				JPanel panel= new JPanel(); 
				panel.setLayout(null);
		        panel.setBounds(0, 0, 650, 650); 
		        
 		        
        String EmailAddress=(String)table.getValueAt(table.getSelectedRow(), 0);
		String Header=(String)table.getValueAt(table.getSelectedRow(), 1);
		String Subject = (String)table.getValueAt(table.getSelectedRow(), 2);
		
        JLabel Recieverlbl = new JLabel("Please Write Reciever Mail:"); 
        Recieverlbl.setLocation(70, 30);
        Recieverlbl.setSize(300, 50);
		panel.add(Recieverlbl);

		JLabel Subjectlbl = new JLabel("Please Write The Subject Of Mail:");
		Subjectlbl.setLocation(70, 100);
		Subjectlbl.setSize(300, 50);
		panel.add(Subjectlbl);

		JLabel Topiclbl = new JLabel("Please Write the Topic:");
		Topiclbl.setLocation(70, 170);
		Topiclbl.setSize(300, 50);
		panel.add(Topiclbl);
		
		JButton Send = new JButton("Send");   
		Send.setLocation(280,300);
		Send.setSize(200, 30);
		Send.setVisible(false);
		panel.add(Send);
		
		JTextField mailAddress = new JTextField();
		mailAddress.setLocation(280, 45);
		mailAddress.setSize(250, 30);
		mailAddress.setText(EmailAddress);
		mailAddress.disable();
		panel.add(mailAddress);
		
		JTextField Subjecttxf = new JTextField();
		Subjecttxf.setLocation(280, 115);
		Subjecttxf.setSize(250, 30);
		Subjecttxf.setText(Header);
		Subjecttxf.disable();
		panel.add(Subjecttxf);
		
		JTextArea Topictxf = new JTextArea();
		Topictxf.setLocation(280, 185);
		Topictxf.setSize(300, 100);
		Topictxf.setText(Subject);
		Topictxf.disable();
		panel.add(Topictxf);
		        
		JButton Reply = new JButton("Reply An E-Mail");
		Reply.setSize(200,30);
		Reply.setLocation(280,300);
		Reply.setVisible(true);
		panel.add(Reply); 
		
		frame.add(panel);
		frame.setSize(650, 400); 
		frame.setVisible(true);
		        
		        Reply.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Reply.setVisible(false);
						Send.setVisible(true);
						Topictxf.setText("");
						Topictxf.enable();
						
				Send.addActionListener(new ActionListener() {   
							
							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									if(Topictxf.getText().equalsIgnoreCase("")) {
										JOptionPane.showMessageDialog(frame, " Please Enter The Topic"); 
									}
									else {
										if(mailCtrl.IsValidEmail(mailAddress.getText())) {
											JOptionPane.showMessageDialog(frame, "Mail Sended");  
											mailCtrl.WriteMail(mailAddress.getText(),eMailAddress,Subjecttxf.getText(),Topictxf.getText());
										}
										else { 
											JOptionPane.showMessageDialog(frame, " Please Enter Valid Email");
										}
									}	
								} catch (FileNotFoundException e1) {    
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
				});		        					
					}
				});		
			}
		});
        
        Mark.addActionListener(new ActionListener() {  
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				String EmailAddress=(String)table.getValueAt(table.getSelectedRow(), 0);
				String Header=(String)table.getValueAt(table.getSelectedRow(), 1);
				String Topic=(String)table.getValueAt(table.getSelectedRow(), 2); 
				String DateTime=(String)table.getValueAt(table.getSelectedRow(), 3); 
				try {
					mailCtrl.MarkMails(EmailAddress,eMailAddress, Header, Topic,DateTime);   
				} catch (FileNotFoundException e1) {
					e1.printStackTrace(); 
				}
				
				DefaultTableModel dm = (DefaultTableModel)table.getModel();  
				while(dm.getRowCount() > 0)
				{
				    dm.removeRow(0); 
				}
				
			    try (BufferedReader br = new BufferedReader(new FileReader("MailBox//" +eMailAddress+ "#MailBox.txt")))
			    {
			    	ArrayList<String> DefaultList = new ArrayList<String>();  

			        String sCurrentLine;

			        while ((sCurrentLine = br.readLine()) != null) {
			        	DefaultList.add(sCurrentLine);
			        }
			        for(int a=0;a < DefaultList.size();a+=4) {
	        	    	    
	          	     	list.addRow(
	          					new Object[] {DefaultList.get(a),DefaultList.get(a+1),DefaultList.get(a+2),
	          							DefaultList.get(a+3) });    
	          	   
			        }

			    } catch (IOException e2) {
			        e2.printStackTrace();
			    }	
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(ErrorPanel, " Please Select Mail From Table");
				}
			}
		});
        Delete.addActionListener(new ActionListener() { 
			 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
				String EmailAddress=(String)table.getValueAt(table.getSelectedRow(), 0); 
				String Header=(String)table.getValueAt(table.getSelectedRow(), 1);
				String Topic=(String)table.getValueAt(table.getSelectedRow(), 2);
				String DateTime=(String)table.getValueAt(table.getSelectedRow(), 3);
				try {
					mailCtrl.DeleteMails(eMailAddress,EmailAddress, Header, Topic,DateTime); 
				} catch (FileNotFoundException e1) { 
					e1.printStackTrace(); 
				}
				
				DefaultTableModel dm = (DefaultTableModel)table.getModel(); 
				while(dm.getRowCount() > 0)
				{
				    dm.removeRow(0); 
				}
			    try (BufferedReader br = new BufferedReader(new FileReader("MailBox//" +eMailAddress+ "#MailBox.txt")))
			    {
			    	ArrayList<String> DefaultList = new ArrayList<String>(); 

			        String sCurrentLine;

			        while ((sCurrentLine = br.readLine()) != null) {
			        	DefaultList.add(sCurrentLine);
			        }
			        for(int a=0;a < DefaultList.size();a+=4) {
	        	    	    
	          	     	list.addRow(
	          					new Object[] {DefaultList.get(a),DefaultList.get(a+1),DefaultList.get(a+2),
	          							DefaultList.get(a+3) });    
	          	   
			        }

			    } catch (IOException e2) {
			        e2.printStackTrace();
			    }
			}
			    catch(Exception ex) {
					JOptionPane.showMessageDialog(ErrorPanel, " Please Select Mail From Table");
				} 
			}
		});
    
        Write.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame=new JFrame("Send E-Mail");  
				JPanel panel= new JPanel(); 
				panel.setLayout(null);
		        panel.setBounds(0, 0, 350, 800);
		        
		        JLabel Recieverlbl = new JLabel(" Please Write Reciever Mail:");
		        Recieverlbl.setLocation(70, 30);
		        Recieverlbl.setSize(300, 50);
				panel.add(Recieverlbl);

				JLabel Subjectlbl = new JLabel("Please Write The Subject Of Mail:");
				Subjectlbl.setLocation(70, 100);
				Subjectlbl.setSize(300, 50);
				panel.add(Subjectlbl);

				JLabel Topiclbl = new JLabel("Please Write the Topic:");
				Topiclbl.setLocation(70, 170);
				Topiclbl.setSize(300, 50);
				panel.add(Topiclbl);
				
				JButton Send = new JButton("Send"); 
				Send.setLocation(280, 300);
				Send.setSize(200, 30);
				panel.add(Send);
				
				JTextField mailAddress = new JTextField();
				mailAddress.setLocation(280, 45);
				mailAddress.setSize(200, 30);
				panel.add(mailAddress);
				
				JTextField Subjecttxf = new JTextField();
				Subjecttxf.setLocation(280, 115);
				Subjecttxf.setSize(200, 30);
				panel.add(Subjecttxf);
				
				JTextArea Topictxf = new JTextArea();
				Topictxf.setLocation(280, 185);
				Topictxf.setSize(250, 100);
				panel.add(Topictxf);		
				
				Send.addActionListener(new ActionListener() {  
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							if(mailAddress.getText().equalsIgnoreCase("") && Topictxf.getText().equalsIgnoreCase("")) {
								JOptionPane.showMessageDialog(frame, " Please Enter All The Fields Correctly Email");
							}
							else {
								if(mailCtrl.IsValidEmail(mailAddress.getText())) {
									JOptionPane.showMessageDialog(frame, "Mail Sended"); 
									mailCtrl.WriteMail(mailAddress.getText(),eMailAddress,Subjecttxf.getText(),Topictxf.getText());  
								}
								else {
									JOptionPane.showMessageDialog(frame, "User Couldn't Find");
								}
							}	
						} catch (FileNotFoundException e1) {   
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
					}
				});
				
				
				
				frame.add(panel);
				frame.setSize(650, 400);
				frame.setVisible(true);
				
			}
		});
	
        Spam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				String EmailAddress=(String)table.getValueAt(table.getSelectedRow(), 0);
				String Header=(String)table.getValueAt(table.getSelectedRow(), 1);
				String Topic=(String)table.getValueAt(table.getSelectedRow(), 2); 
				String DateTime=(String)table.getValueAt(table.getSelectedRow(), 3); 
				try {
					mailCtrl.MarkSpamMails(eMailAddress,EmailAddress, Header, Topic,DateTime);    
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				DefaultTableModel dm = (DefaultTableModel)table.getModel(); 
				while(dm.getRowCount() > 0)
				{
				    dm.removeRow(0); 
				}
			    try (BufferedReader br = new BufferedReader(new FileReader("MailBox//" +eMailAddress+ "#MailBox.txt")))
			    {
			    	ArrayList<String> DefaultList = new ArrayList<String>(); 

			        String sCurrentLine;

			        while ((sCurrentLine = br.readLine()) != null) {
			        	DefaultList.add(sCurrentLine);
			        }
			        for(int a=0;a < DefaultList.size();a+=4) {
	        	    	    
	          	     	list.addRow(
	          					new Object[] {DefaultList.get(a),DefaultList.get(a+1),DefaultList.get(a+2),
	          							DefaultList.get(a+3) });    
	          	   
			        }

			    } catch (IOException e2) {
			        e2.printStackTrace();
			    }
			} catch(Exception ex) {
					JOptionPane.showMessageDialog(ErrorPanel, " Please Select Mail From Table");
				}
			}
		});
        
        Refresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dm = (DefaultTableModel)table.getModel(); 
				while(dm.getRowCount() > 0)
				{
				    dm.removeRow(0); 
				}
			    try (BufferedReader br = new BufferedReader(new FileReader("MailBox//" +eMailAddress+ "#MailBox.txt")))
			    {
			    	ArrayList<String> DefaultList = new ArrayList<String>(); 

			        String sCurrentLine;

			        while ((sCurrentLine = br.readLine()) != null) {
			        	DefaultList.add(sCurrentLine);
			        }
			        for(int a=0;a < DefaultList.size();a+=4) {
	          	     	list.addRow(
	          					new Object[] {DefaultList.get(a),DefaultList.get(a+1),DefaultList.get(a+2),
	          							DefaultList.get(a+3) });    
	          	   
			        }

			    } catch (IOException e2) {
			        e2.printStackTrace();
			    }
				
			}
		});
	}
}