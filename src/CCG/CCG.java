package CCG;

import javax.swing.UIManager;

public class CCG {

	public static void main (String [] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		UI u=new UI();
		u.setLocationRelativeTo(null);
		u.setVisible(true);
	}
}
