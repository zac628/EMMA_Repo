
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
	Enter.addActionListener(new TempListener());
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
private class TempListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{	
			System.out.println(un.getText()+ " " +un1.getText());
			System.out.println(p.getText()+" " +p1.getText());
			
		}

	}
	
}