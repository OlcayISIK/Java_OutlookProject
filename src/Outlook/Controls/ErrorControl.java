package Outlook.Controls;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorControl extends Exception {
    public ErrorControl(String message) {
        super(message);
    }
}

class ErrorManager {
	 
    public void WriteError(JFrame frame) throws ErrorControl {
    	JOptionPane.showMessageDialog(frame, " Please Select Mail From Table");

    }
}
