package CCG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldIpv4Address;
	private JTextField textFieldIpv4Subnet;
	private JTextField textFieldIpv6Address;
	private JTextField textFieldIpv6Subnet;
	private JTextField textFieldOSPF;
	private JTextField textFieldOSPFv3;
	private JTable tableStaticRouting;
	private JTextField textFieldHostname;
	private JTable tableSummaryAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JButton btnGenerate = new JButton("Generate");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGenerate))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnGenerate))
		);
		
		JPanel panelGeneral = new JPanel();
		tabbedPane.addTab("General", null, panelGeneral, null);
		
		JLabel lblHostname = new JLabel("Hostname :");
		
		textFieldHostname = new JTextField();
		textFieldHostname.setColumns(10);
		GroupLayout gl_panelGeneral = new GroupLayout(panelGeneral);
		gl_panelGeneral.setHorizontalGroup(
			gl_panelGeneral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGeneral.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHostname)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldHostname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(379, Short.MAX_VALUE))
		);
		gl_panelGeneral.setVerticalGroup(
			gl_panelGeneral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGeneral.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelGeneral.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHostname)
						.addComponent(textFieldHostname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(282, Short.MAX_VALUE))
		);
		panelGeneral.setLayout(gl_panelGeneral);
		
		JPanel panelL3Interface = new JPanel();
		tabbedPane.addTab("L3 Interfaces", null, panelL3Interface, null);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblInterface = new JLabel("Interface :");
		lblInterface.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblSelectInterface = new JLabel("Select Interface :");
		
		JButton btnNewButton = new JButton("Add Interface");
		
		textFieldIpv4Address = new JTextField();
		textFieldIpv4Address.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		
		JLabel lblIpv4Address = new JLabel("IPv4 Address :");
		lblIpv4Address.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldIpv4Subnet = new JTextField();
		textFieldIpv4Subnet.setColumns(10);
		
		JLabel lblIpv6Address = new JLabel("IPv6 Address :");
		lblIpv6Address.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldIpv6Address = new JTextField();
		textFieldIpv6Address.setColumns(10);
		
		JLabel label_1 = new JLabel("/");
		
		textFieldIpv6Subnet = new JTextField();
		textFieldIpv6Subnet.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("OSPF");
		
		textFieldOSPF = new JTextField();
		textFieldOSPF.setColumns(10);
		
		JCheckBox chckbxEIGRP = new JCheckBox("EIGRP");
		
		JCheckBox chckbxRipv2 = new JCheckBox("RIPv2");
		
		JCheckBox chckbxOspfv = new JCheckBox("OSPFv3");
		
		textFieldOSPFv3 = new JTextField();
		textFieldOSPFv3.setColumns(10);
		
		JCheckBox chckbxEigrpIpv = new JCheckBox("EIGRP IPv6");
		
		JCheckBox chckbxRipng = new JCheckBox("RIPng");
		GroupLayout gl_panelL3Interface = new GroupLayout(panelL3Interface);
		gl_panelL3Interface.setHorizontalGroup(
			gl_panelL3Interface.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelL3Interface.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelL3Interface.createSequentialGroup()
							.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblInterface, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblSelectInterface, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblIpv4Address, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelL3Interface.createSequentialGroup()
									.addComponent(textFieldIpv4Address, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldIpv4Subnet, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelL3Interface.createSequentialGroup()
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton))
								.addComponent(comboBox, 0, 420, Short.MAX_VALUE)))
						.addGroup(gl_panelL3Interface.createSequentialGroup()
							.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panelL3Interface.createSequentialGroup()
									.addComponent(chckbxNewCheckBox)
									.addGap(14)
									.addComponent(textFieldOSPF, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxEIGRP, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(chckbxRipv2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_panelL3Interface.createSequentialGroup()
									.addComponent(chckbxOspfv, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldOSPFv3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxEigrpIpv, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxRipng, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_panelL3Interface.createSequentialGroup()
									.addComponent(lblIpv6Address, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldIpv6Address, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)))
							.addGap(4)
							.addComponent(textFieldIpv6Subnet, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelL3Interface.setVerticalGroup(
			gl_panelL3Interface.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelL3Interface.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInterface)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectInterface)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIpv4Address)
						.addComponent(textFieldIpv4Address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(textFieldIpv4Subnet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxNewCheckBox)
						.addComponent(textFieldOSPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxEIGRP)
						.addComponent(chckbxRipv2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelL3Interface.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(textFieldIpv6Subnet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblIpv6Address)
							.addComponent(textFieldIpv6Address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxOspfv)
						.addComponent(chckbxEigrpIpv)
						.addComponent(chckbxRipng)
						.addComponent(textFieldOSPFv3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(158))
		);
		panelL3Interface.setLayout(gl_panelL3Interface);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Static Routing", null, scrollPane, null);
		
		tableStaticRouting = new JTable();
		tableStaticRouting.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Network Address", "Subnet Prefix", "Next Hop"
			}
		));
		tableStaticRouting.getColumnModel().getColumn(0).setPreferredWidth(135);
		tableStaticRouting.getColumnModel().getColumn(1).setPreferredWidth(87);
		tableStaticRouting.getColumnModel().getColumn(2).setPreferredWidth(115);
		scrollPane.setViewportView(tableStaticRouting);
		
		JPanel panel = new JPanel();
		scrollPane.setRowHeaderView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton btnAddNewStaticRoute = new JButton("Add");
		panel.add(btnAddNewStaticRoute);
		
		JButton btnDeleteStaticRoute = new JButton("Delete");
		btnDeleteStaticRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnDeleteStaticRoute);
		
		JPanel panelOSPF = new JPanel();
		tabbedPane.addTab("OSPF", null, panelOSPF, null);
		
		JLabel lblSummaryAddress = new JLabel("Summary Address :");
		
		JScrollPane scrollPaneSummaryAddress = new JScrollPane();
		
		JButton btnAddSummaryAddress = new JButton("Add");
		
		JButton btnDeleteSummaryAddress = new JButton("Delete");
		GroupLayout gl_panelOSPF = new GroupLayout(panelOSPF);
		gl_panelOSPF.setHorizontalGroup(
			gl_panelOSPF.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOSPF.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelOSPF.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneSummaryAddress, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
						.addGroup(gl_panelOSPF.createSequentialGroup()
							.addComponent(lblSummaryAddress)
							.addPreferredGap(ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
							.addComponent(btnAddSummaryAddress)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeleteSummaryAddress)))
					.addContainerGap())
		);
		gl_panelOSPF.setVerticalGroup(
			gl_panelOSPF.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOSPF.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelOSPF.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSummaryAddress)
						.addComponent(btnAddSummaryAddress)
						.addComponent(btnDeleteSummaryAddress))
					.addGap(8)
					.addComponent(scrollPaneSummaryAddress, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(192, Short.MAX_VALUE))
		);
		
		tableSummaryAddress = new JTable();
		tableSummaryAddress.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Area", "Address"
			}
		));
		tableSummaryAddress.getColumnModel().getColumn(0).setPreferredWidth(164);
		scrollPaneSummaryAddress.setViewportView(tableSummaryAddress);
		panelOSPF.setLayout(gl_panelOSPF);
		
		JPanel panelEIGRP = new JPanel();
		tabbedPane.addTab("EIGRP", null, panelEIGRP, null);
		
		JPanel panelSwitching = new JPanel();
		tabbedPane.addTab("Switching", null, panelSwitching, null);
		
		JLabel lblSpanningTree = new JLabel("Spanning Tree :");
		
		JComboBox comboBoxSpanningTree = new JComboBox();
		GroupLayout gl_panelSwitching = new GroupLayout(panelSwitching);
		gl_panelSwitching.setHorizontalGroup(
			gl_panelSwitching.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSwitching.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSpanningTree)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxSpanningTree, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(246, Short.MAX_VALUE))
		);
		gl_panelSwitching.setVerticalGroup(
			gl_panelSwitching.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSwitching.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSwitching.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpanningTree)
						.addComponent(comboBoxSpanningTree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(282, Short.MAX_VALUE))
		);
		panelSwitching.setLayout(gl_panelSwitching);
		contentPane.setLayout(gl_contentPane);
	}
}
