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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Outlook.Controls.MailListControl;

public class SpamPanel extends JPanel {
	
	public SpamPanel(String eMailAddress) throws FileNotFoundException {
		MailListControl mailCtrl = new MailListControl(eMailAddress);
	     this.setLayout(null);
	     this.setBackground(Color.white);
	     
	     	JPanel ErrorPanel = new JPanel();    
			ErrorPanel.setLayout(null);
	        this.setLayout(null);
	        this.add(ErrorPanel);
	        
	     ImageIcon MailIcon = new ImageIcon("icons\\spammailicon.png");  
	     Image SizeIcon=MailIcon.getImage();      
	     MailIcon = new ImageIcon(SizeIcon.getScaledInstance(60,60,0));
	     JButton IconButton = new JButton(MailIcon);
	     IconButton.setText("Welcome SpamMailBox");
	     IconButton.setSize(300,60);
	     IconButton.setLocation(600,20);
	     IconButton.disable();
	     IconButton.setBackground(Color.red);
	     IconButton.setBorder(new LineBorder(Color.white));
	     this.add(IconButton);  
	        
	     DefaultTableModel list = new DefaultTableModel();
	     list.addColumn("Sent Address");  
	     list.addColumn("Header");
	     list.addColumn("Topic");
	     list.addColumn("Time");
	     JTable table = new JTable(list);
	     table.setLayout(new BorderLayout()); 
	     JScrollPane spanel = new JScrollPane(table);
	     spanel.setSize(600 ,450);
	     spanel.setLocation(0,0);
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
	     

	        ImageIcon DeleteIcon = new ImageIcon("icons\\deleteicon.png");  
	        Image SizeIcon3=DeleteIcon.getImage();      
	        DeleteIcon = new ImageIcon(SizeIcon3.getScaledInstance(40,40,0));
	        JButton Delete = new JButton(DeleteIcon);
	        Delete.setText("Delete Mail");
	        Delete.setSize(200,40);
	        Delete.setLocation(650,180);
	        Delete.setBackground(Color.white);
	        Delete.setForeground(Color.black);
	        Delete.setBorder(new LineBorder(Color.white));
	        this.add(Delete); 
	        
	        ImageIcon RefreshIcon = new ImageIcon("icons\\refreshicon.png");  
	        Image SizeIcon2=RefreshIcon.getImage();      
	        RefreshIcon = new ImageIcon(SizeIcon2.getScaledInstance(40,40,0));
	        JButton Refresh = new JButton(RefreshIcon); 
	        Refresh.setText("Refresh The List");
	        Refresh.setSize(200,40);
	        Refresh.setLocation(650,100);
	        Refresh.setBackground(Color.white);
	        Refresh.setForeground(Color.black);
	        Refresh.setBorder(new LineBorder(Color.white));
	        this.add(Refresh); 
	        
	        ImageIcon MarkMailIcon = new ImageIcon("icons\\mail.png");  
	        Image SizeIcon4=MarkMailIcon.getImage();      
	        MarkMailIcon = new ImageIcon(SizeIcon4.getScaledInstance(40,40,0));
	        JButton Mark = new JButton(MarkMailIcon);  
	        Mark.setText("Remove From Spam");
	        Mark.setSize(200,40);
	        Mark.setLocation(650,260);
	        Mark.setBackground(Color.white);
	        Mark.setForeground(Color.black);
	        Mark.setBorder(new LineBorder(Color.white));
	        this.add(Mark); 
	        
	        int i = 0;
	        for(i=0;i < mailCtrl.GetSpamMailInformation().size();i+=4) {        	    	   
	        	     	list.addRow(
	        					new Object[] { mailCtrl.GetSpamMailInformation().get(i),mailCtrl.GetSpamMailInformation().get(i+1),     
	        							mailCtrl.GetSpamMailInformation().get(i+2),mailCtrl.GetSpamMailInformation().get(i+3) });   
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
			frame.add(panel);
			frame.setSize(650, 400); 
			frame.setVisible(true);
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
						mailCtrl.DeleteSpamMails(eMailAddress, EmailAddress, Header, Topic,DateTime);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					
					DefaultTableModel dm = (DefaultTableModel)table.getModel(); 
					while(dm.getRowCount() > 0)
					{
					    dm.removeRow(0); 
					}
				    try (BufferedReader br = new BufferedReader(new FileReader("MailBox//" +eMailAddress+ "#SpamMail.txt")))
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
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel dm = (DefaultTableModel)table.getModel(); 
					while(dm.getRowCount() > 0)
					{
					    dm.removeRow(0); 
					}
				    try (BufferedReader br = new BufferedReader(new FileReader("MailBox//" +eMailAddress+ "#SpamMail.txt")))
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
	        
	        Mark.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
					String EmailAddress=(String)table.getValueAt(table.getSelectedRow(), 0);
					String Header=(String)table.getValueAt(table.getSelectedRow(), 1);
					String Topic=(String)table.getValueAt(table.getSelectedRow(), 2); 
					String DateTime=(String)table.getValueAt(table.getSelectedRow(), 3); 
					try {
						mailCtrl.RemoveSpamMail(eMailAddress,EmailAddress, Header, Topic,DateTime);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					DefaultTableModel dm = (DefaultTableModel)table.getModel(); 
					while(dm.getRowCount() > 0)
					{
					    dm.removeRow(0); 
					}
				    try (BufferedReader br = new BufferedReader(new FileReader("MailBox//" +eMailAddress+ "#SpamMail.txt")))
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
	}
	

}