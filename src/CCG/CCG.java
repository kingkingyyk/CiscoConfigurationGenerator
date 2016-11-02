package CCG;

import java.util.LinkedList;

import javax.swing.UIManager;

public class CCG {

	public static LinkedList<Interface> ints=new LinkedList<>();
	public static String STP,PortFast;
	public static boolean backboneFast,uplinkFast;
	  
	  
	public static void main (String [] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		UI u=new UI();
		u.setLocationRelativeTo(null);
		u.setVisible(true);
	}
}
