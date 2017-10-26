import javax.swing.JFrame;
public class Login {
	public void Login_VC()
	{
	JFrame frame = new JFrame("EMMA");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	LoginWindow panel = new LoginWindow();
	frame.getContentPane().add(panel);
	frame.pack();
	frame.setVisible(true);
	}
}