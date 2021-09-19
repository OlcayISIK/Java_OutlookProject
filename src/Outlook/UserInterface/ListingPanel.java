package Outlook.UserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Outlook.Controls.AdminControl;

public class ListingPanel {
	AdminControl adminCtrl = new AdminControl();
	public void getFrame() throws FileNotFoundException {
		JFrame frame = new JFrame("Listing Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBounds(0, 0, 1005, 380); 
		DefaultTableModel list = new DefaultTableModel();
		list.addColumn("Mail Address");
		list.addColumn("Compliement");
			
		JTable table = new JTable(list);
		table.setLayout(new BorderLayout());
		JScrollPane spanel = new JScrollPane(table);
		spanel.setSize(1005, 380);
		spanel.setLocation(0, 0);
		panel.add(spanel, BorderLayout.CENTER); 
		
        JLabel SearchLbl = new JLabel("Search Mail");
        SearchLbl.setLocation(200, 400);
        SearchLbl.setSize(200,30);
		TableRowSorter sorter = new TableRowSorter<>(list);
		table.setRowSorter(sorter);
		frame.add(SearchLbl);
        
        JTextField Searchtxf = new JTextField(15);
        Searchtxf.setLocation(300, 400);
        Searchtxf.setSize(200,30);
        frame.add(Searchtxf);
        
        ImageIcon SearchMailIcon = new ImageIcon("icons\\searchicon.png"); 
        Image SIcon=SearchMailIcon.getImage();      
        SearchMailIcon = new ImageIcon(SIcon.getScaledInstance(40,40,0));
        JButton Search = new JButton(SearchMailIcon);
        Search.disable();
        Search.setSize(60,60);
        Search.setLocation(510,380);
        Search.disable();
        Search.setBackground(Color.LIGHT_GRAY);
        Search.setBorder(new LineBorder(Color.white));
        frame.add(Search);
		
		
        int i = 0;
        for(i=0;i < adminCtrl.GetCompliementInformation().size();i+=2) {   
        	     	list.addRow(
        					new Object[] { adminCtrl.GetCompliementInformation().get(i),   
        							adminCtrl.GetCompliementInformation().get(i+1)}); 
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
        
		JButton tb = new JButton("Turn Back"); 
		tb.setBackground(Color.YELLOW);
		tb.setLocation(900, 400);
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
		frame.add(tb);
		frame.setSize(1024, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}


}
