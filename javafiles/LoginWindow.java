
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LoginWindow extends JPanel {
private JTextField un1,p1;
private JLabel un,p;
private JTextPane content;
private JButton Enter;

public LoginWindow(){
	setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
	un = new JLabel("Username:");
	p = new JLabel("Password:");
	
	un1 = new JTextField(30);
	p1 = new JTextField(30);
	
	Enter = new JButton("Enter");
	Enter.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(DBTools.testAll(un1.getText(), p1.getText())){
				//JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "Success");
			}
			else JOptionPane.showMessageDialog(null, "Record Not Found");
			//DBTools.insert(un1.getText(), p1.getText());
			}
		});
		add(un);
		add(un1);
		add(Box.createRigidArea(new Dimension (100, 20)));
		add(p);
		add(p1);
		
		add(Enter);
		
		setBackground(Color.white);
		content = new JTextPane();
		content.setPreferredSize(new Dimension(500,200));
		add(content);
	}
	
}