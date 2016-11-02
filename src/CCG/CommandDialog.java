package CCG;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;

public class CommandDialog extends JDialog {
	private static final long serialVersionUID = 4270988323243490805L;

	public CommandDialog(String s) {
		setTitle("Commands");
		setModal(true);
		setBounds(100, 100, 450, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea(s);
		scrollPane.setViewportView(textArea);
	}

}
