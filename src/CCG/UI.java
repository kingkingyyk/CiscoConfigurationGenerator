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
import javax.swing.DefaultComboBoxModel;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldL3Interface;
	private JTextField textFieldIpv4Address;
	private JTextField textFieldIpv4Subnet;
	private JTextField textFieldIpv6Address;
	private JTextField textFieldIpv6Subnet;
	private JTextField textFieldOSPF;
	private JTextField textFieldOSPFv3;
	private JTable tableStaticRouting;
	private JTextField textFieldHostname;
	private JTable tableSummaryAddress;
	private JTable tableVLAN;
	private JTextField textField_1;
	private JTextField textFieldTrunk;
	private JTextField textFieldOSPFPassiveInterfaces;
	private JTextField textFieldEIGRPassiveInterfaces;
	private JTextField textFieldEIGRPPassiveInterfaces;
	private JTextField textFieldBGPASNumber;
	private JTable tableBGPNeighbors;
	private JTextField textFieldHSRPIP;
	private JTextField textFieldHSRPPriority;
	private JTextField textFieldHSRPv3IP;
	private JTextField textFieldHSRPv3Priority;

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
		setTitle("Cisco Configuration Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JButton btnGenerate = new JButton("Generate");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(tabbedPane)
				.addComponent(btnGenerate)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 335, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
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
		
		textFieldL3Interface = new JTextField();
		textFieldL3Interface.setColumns(10);
		
		JComboBox comboBoxInterface = new JComboBox();
		
		JLabel lblInterface = new JLabel("Interface :");
		lblInterface.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblSelectInterface = new JLabel("Select Interface :");
		
		JButton btnAddInterface = new JButton("Add Interface");
		
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
		
		JCheckBox chckbxInterfaceOSPF = new JCheckBox("OSPF");
		
		textFieldOSPF = new JTextField();
		textFieldOSPF.setColumns(10);
		
		JCheckBox chckbxEIGRP = new JCheckBox("EIGRP");
		
		JCheckBox chckbxRipv2 = new JCheckBox("RIPv2");
		
		JCheckBox chckbxOspfv = new JCheckBox("OSPFv3");
		
		textFieldOSPFv3 = new JTextField();
		textFieldOSPFv3.setColumns(10);
		
		JCheckBox chckbxEigrpIpv = new JCheckBox("EIGRP IPv6");
		
		JCheckBox chckbxRipng = new JCheckBox("RIPng");
		
		JLabel lblHSRP = new JLabel("HSRP IP :");
		lblHSRP.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldHSRPIP = new JTextField();
		textFieldHSRPIP.setColumns(10);
		
		JLabel lblHsrpPriority = new JLabel("Priority :");
		lblHsrpPriority.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldHSRPPriority = new JTextField();
		textFieldHSRPPriority.setColumns(10);
		
		JLabel lblHsrpv3Ip = new JLabel("HSRPv3 IP :");
		lblHsrpv3Ip.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldHSRPv3IP = new JTextField();
		textFieldHSRPv3IP.setColumns(10);
		
		JLabel lblHSRPv3Priority = new JLabel("Priority :");
		lblHSRPv3Priority.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldHSRPv3Priority = new JTextField();
		textFieldHSRPv3Priority.setColumns(10);
		
		JCheckBox chckbxBgp = new JCheckBox("BGP");
		
		JCheckBox checkBoxBgpv3 = new JCheckBox("BGPv6");
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
									.addComponent(textFieldL3Interface, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAddInterface))
								.addComponent(comboBoxInterface, 0, 426, Short.MAX_VALUE)))
						.addGroup(gl_panelL3Interface.createSequentialGroup()
							.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelL3Interface.createSequentialGroup()
									.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblHSRP, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(chckbxOspfv, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelL3Interface.createSequentialGroup()
											.addComponent(textFieldOSPFv3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addGap(44)
											.addComponent(chckbxEigrpIpv, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(chckbxRipng, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(checkBoxBgpv3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelL3Interface.createSequentialGroup()
											.addComponent(textFieldHSRPIP, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblHsrpPriority, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldHSRPPriority, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panelL3Interface.createSequentialGroup()
									.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_panelL3Interface.createSequentialGroup()
											.addComponent(chckbxInterfaceOSPF)
											.addGap(14)
											.addComponent(textFieldOSPF, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addGap(54)
											.addComponent(chckbxEIGRP, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(chckbxRipv2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.LEADING, gl_panelL3Interface.createSequentialGroup()
											.addComponent(lblIpv6Address, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textFieldIpv6Address, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldIpv6Subnet, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addComponent(chckbxBgp, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 122, Short.MAX_VALUE))
						.addGroup(gl_panelL3Interface.createSequentialGroup()
							.addComponent(lblHsrpv3Ip, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldHSRPv3IP, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHSRPv3Priority, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldHSRPv3Priority, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelL3Interface.setVerticalGroup(
			gl_panelL3Interface.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelL3Interface.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInterface)
						.addComponent(textFieldL3Interface, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddInterface))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectInterface)
						.addComponent(comboBoxInterface, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIpv4Address)
						.addComponent(textFieldIpv4Address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(textFieldIpv4Subnet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxInterfaceOSPF)
						.addComponent(textFieldOSPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxEIGRP)
						.addComponent(chckbxRipv2)
						.addComponent(chckbxBgp))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelL3Interface.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(textFieldIpv6Subnet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblIpv6Address)
							.addComponent(textFieldIpv6Address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxOspfv)
						.addComponent(textFieldOSPFv3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxEigrpIpv)
						.addComponent(chckbxRipng)
						.addComponent(checkBoxBgpv3))
					.addGap(18)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHSRP)
						.addComponent(textFieldHSRPIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHsrpPriority)
						.addComponent(textFieldHSRPPriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHsrpv3Ip)
						.addComponent(textFieldHSRPv3IP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHSRPv3Priority)
						.addComponent(textFieldHSRPv3Priority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(63))
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
		
		JLabel lblOSPFPassiveInterfaces = new JLabel("Passive Interfaces :");
		
		textFieldOSPFPassiveInterfaces = new JTextField();
		textFieldOSPFPassiveInterfaces.setColumns(10);
		
		JCheckBox chckbxOSPFRedistributeEigrp = new JCheckBox("Redistribute EIGRP");
		
		JCheckBox chckbxOSPFRedistributeBgp = new JCheckBox("Redistribute BGP");
		
		JCheckBox chckbxOSPFRedistributeRip = new JCheckBox("Redistribute RIP");
		
		JCheckBox chckbxOSPFRedistributeEigrpV6 = new JCheckBox("Redistribute EIGRP v6");
		
		JCheckBox chckbxOSPFRedistributeBgpV6 = new JCheckBox("Redistribute BGP v6");
		
		JCheckBox chckbxOSPFRedistributeRipng = new JCheckBox("Redistribute RIPng");
		
		JCheckBox chckbxOSPFRedistributeStatic = new JCheckBox("Redistribute Static");
		
		JCheckBox chckbxOSPFRedistributeStaticV6 = new JCheckBox("Redistribute Static");
		GroupLayout gl_panelOSPF = new GroupLayout(panelOSPF);
		gl_panelOSPF.setHorizontalGroup(
			gl_panelOSPF.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOSPF.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelOSPF.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneSummaryAddress, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
						.addGroup(gl_panelOSPF.createSequentialGroup()
							.addComponent(lblSummaryAddress)
							.addPreferredGap(ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
							.addComponent(btnAddSummaryAddress)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeleteSummaryAddress))
						.addGroup(gl_panelOSPF.createSequentialGroup()
							.addComponent(lblOSPFPassiveInterfaces, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldOSPFPassiveInterfaces, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
						.addGroup(gl_panelOSPF.createSequentialGroup()
							.addGroup(gl_panelOSPF.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxOSPFRedistributeEigrp)
								.addComponent(chckbxOSPFRedistributeEigrpV6))
							.addGap(18)
							.addGroup(gl_panelOSPF.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxOSPFRedistributeBgp, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxOSPFRedistributeBgpV6, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelOSPF.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelOSPF.createSequentialGroup()
									.addComponent(chckbxOSPFRedistributeRipng, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(chckbxOSPFRedistributeStaticV6, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelOSPF.createSequentialGroup()
									.addComponent(chckbxOSPFRedistributeRip, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxOSPFRedistributeStatic, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))))
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
					.addComponent(scrollPaneSummaryAddress, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelOSPF.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOSPFPassiveInterfaces)
						.addComponent(textFieldOSPFPassiveInterfaces, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelOSPF.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxOSPFRedistributeEigrp)
						.addComponent(chckbxOSPFRedistributeBgp)
						.addComponent(chckbxOSPFRedistributeRip)
						.addComponent(chckbxOSPFRedistributeStatic))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelOSPF.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxOSPFRedistributeEigrpV6)
						.addComponent(chckbxOSPFRedistributeBgpV6)
						.addComponent(chckbxOSPFRedistributeRipng)
						.addComponent(chckbxOSPFRedistributeStaticV6))
					.addGap(85))
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
		
		JCheckBox chckbxEIGRPNoSummary = new JCheckBox("No Summary Address");
		
		JLabel lblEIGRPPassiveInterfaces = new JLabel("Passive Interfaces :");
		
		textFieldEIGRPPassiveInterfaces = new JTextField();
		textFieldEIGRPPassiveInterfaces.setColumns(10);
		
		JCheckBox chckbxEIGRPRedistributeOspf = new JCheckBox("Redistribute OSPF");
		
		JCheckBox chckbxEIGRPRedistributeBgp = new JCheckBox("Redistribute BGP");
		
		JCheckBox chckbxEIGRPRedistributeRip = new JCheckBox("Redistribute RIP");
		
		JCheckBox chckbxEIGRPRedistributeStatic = new JCheckBox("Redistribute Static");
		
		JCheckBox chckbxEIGRPRedistributeOSPFv3 = new JCheckBox("Redistribute OSPFv3");
		
		JCheckBox chckbxEIGRPRedistributeBgpV6 = new JCheckBox("Redistribute BGP v6");
		
		JCheckBox chckbxEIGRPRedistributeRipng = new JCheckBox("Redistribute RIPng");
		
		JCheckBox chckbxEIGRPRedistributeStaticV6 = new JCheckBox("Redistribute Static");
		GroupLayout gl_panelEIGRP = new GroupLayout(panelEIGRP);
		gl_panelEIGRP.setHorizontalGroup(
			gl_panelEIGRP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEIGRP.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelEIGRP.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelEIGRP.createSequentialGroup()
							.addComponent(chckbxEIGRPRedistributeOSPFv3, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(chckbxEIGRPRedistributeBgpV6, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxEIGRPRedistributeRipng, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxEIGRPRedistributeStaticV6, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addComponent(chckbxEIGRPNoSummary)
						.addGroup(gl_panelEIGRP.createSequentialGroup()
							.addComponent(lblEIGRPPassiveInterfaces, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
							.addComponent(textFieldEIGRPPassiveInterfaces, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelEIGRP.createSequentialGroup()
							.addComponent(chckbxEIGRPRedistributeOspf, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(chckbxEIGRPRedistributeBgp, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(chckbxEIGRPRedistributeRip, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxEIGRPRedistributeStatic, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelEIGRP.setVerticalGroup(
			gl_panelEIGRP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEIGRP.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxEIGRPNoSummary)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelEIGRP.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEIGRPPassiveInterfaces)
						.addComponent(textFieldEIGRPPassiveInterfaces, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelEIGRP.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxEIGRPRedistributeOspf)
						.addComponent(chckbxEIGRPRedistributeBgp)
						.addComponent(chckbxEIGRPRedistributeRip)
						.addComponent(chckbxEIGRPRedistributeStatic))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelEIGRP.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxEIGRPRedistributeOSPFv3)
						.addComponent(chckbxEIGRPRedistributeBgpV6)
						.addComponent(chckbxEIGRPRedistributeRipng)
						.addComponent(chckbxEIGRPRedistributeStaticV6))
					.addContainerGap(194, Short.MAX_VALUE))
		);
		panelEIGRP.setLayout(gl_panelEIGRP);
		
		JPanel panelBGP = new JPanel();
		tabbedPane.addTab("BGP", null, panelBGP, null);
		
		JLabel lblBGPASNumber = new JLabel("AS Number :");
		
		textFieldBGPASNumber = new JTextField();
		textFieldBGPASNumber.setColumns(10);
		
		JLabel lblBGPNeighbors = new JLabel("Neighbors");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JButton btnBGPAddNeighbor = new JButton("Add");
		
		JButton btnBGPDeleteNeighbor = new JButton("Delete");
		
		JCheckBox chckbxBGPRedistributeOSPF = new JCheckBox("Redistribute OSPF");
		
		JCheckBox chckbxBGPRedistributeEigrp = new JCheckBox("Redistribute EIGRP");
		
		JCheckBox chckbxBGPRedistributeRip = new JCheckBox("Redistribute RIP");
		
		JCheckBox chckbxBGPRedistributeStatic = new JCheckBox("Redistribute Static");
		
		JCheckBox chckbxBGPRedistributeOspfV = new JCheckBox("Redistribute OSPF v3");
		
		JCheckBox chckbxBGPRedistributeEigrpV = new JCheckBox("Redistribute EIGRP v6");
		
		JCheckBox chckbxBGPRedistributeRipng = new JCheckBox("Redistribute RIPng");
		
		JCheckBox chckbxBGPRedistributeStaticV6 = new JCheckBox("Redistribute Static");
		GroupLayout gl_panelBGP = new GroupLayout(panelBGP);
		gl_panelBGP.setHorizontalGroup(
			gl_panelBGP.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelBGP.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBGP.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
						.addGroup(gl_panelBGP.createSequentialGroup()
							.addComponent(lblBGPASNumber, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldBGPASNumber, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelBGP.createSequentialGroup()
							.addComponent(lblBGPNeighbors, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
							.addComponent(btnBGPAddNeighbor, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(btnBGPDeleteNeighbor, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelBGP.createSequentialGroup()
							.addGroup(gl_panelBGP.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelBGP.createSequentialGroup()
									.addComponent(chckbxBGPRedistributeOSPF)
									.addGap(12)
									.addComponent(chckbxBGPRedistributeEigrp))
								.addGroup(gl_panelBGP.createSequentialGroup()
									.addComponent(chckbxBGPRedistributeOspfV)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxBGPRedistributeEigrpV)))
							.addGap(18)
							.addGroup(gl_panelBGP.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelBGP.createSequentialGroup()
									.addComponent(chckbxBGPRedistributeRipng)
									.addGap(6)
									.addComponent(chckbxBGPRedistributeStaticV6, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelBGP.createSequentialGroup()
									.addComponent(chckbxBGPRedistributeRip)
									.addGap(18)
									.addComponent(chckbxBGPRedistributeStatic, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_panelBGP.setVerticalGroup(
			gl_panelBGP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBGP.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBGP.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldBGPASNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBGPASNumber))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelBGP.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBGPNeighbors)
						.addComponent(btnBGPAddNeighbor)
						.addComponent(btnBGPDeleteNeighbor))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panelBGP.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxBGPRedistributeOSPF)
						.addComponent(chckbxBGPRedistributeStatic)
						.addComponent(chckbxBGPRedistributeRip)
						.addComponent(chckbxBGPRedistributeEigrp))
					.addGap(2)
					.addGroup(gl_panelBGP.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxBGPRedistributeOspfV)
						.addComponent(chckbxBGPRedistributeEigrpV)
						.addComponent(chckbxBGPRedistributeRipng)
						.addComponent(chckbxBGPRedistributeStaticV6))
					.addContainerGap())
		);
		
		tableBGPNeighbors = new JTable();
		tableBGPNeighbors.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"IP Address", "Remote-AS"
			}
		));
		tableBGPNeighbors.getColumnModel().getColumn(0).setPreferredWidth(252);
		scrollPane_2.setViewportView(tableBGPNeighbors);
		panelBGP.setLayout(gl_panelBGP);
		
		JPanel panelVLAN = new JPanel();
		tabbedPane.addTab("VLAN", null, panelVLAN, null);
		
		JCheckBox chckbxSwitchLegacyIOS = new JCheckBox("Legacy iOS");
		
		JScrollPane scrollPaneVLAN = new JScrollPane();
		
		JButton btnAddVLAN = new JButton("Add VLAN");
		btnAddVLAN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnDeleteVLAN = new JButton("Delete VLAN");
		
		JLabel lblTrunk = new JLabel("Trunk :");
		lblTrunk.setHorizontalAlignment(SwingConstants.CENTER);
		
		textFieldTrunk = new JTextField();
		textFieldTrunk.setColumns(10);
		GroupLayout gl_panelVLAN = new GroupLayout(panelVLAN);
		gl_panelVLAN.setHorizontalGroup(
			gl_panelVLAN.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVLAN.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelVLAN.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneVLAN, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
						.addGroup(gl_panelVLAN.createSequentialGroup()
							.addComponent(chckbxSwitchLegacyIOS)
							.addPreferredGap(ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
							.addComponent(btnAddVLAN)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeleteVLAN))
						.addGroup(gl_panelVLAN.createSequentialGroup()
							.addComponent(lblTrunk, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldTrunk, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelVLAN.setVerticalGroup(
			gl_panelVLAN.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVLAN.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelVLAN.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxSwitchLegacyIOS)
						.addComponent(btnAddVLAN)
						.addComponent(btnDeleteVLAN))
					.addGap(18)
					.addComponent(scrollPaneVLAN, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelVLAN.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTrunk)
						.addComponent(textFieldTrunk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5))
		);
		
		tableVLAN = new JTable();
		tableVLAN.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"VLAN", "Name", "Interfaces", "IP", "RootGuard", "Root Primary", "Root Secondary"
			}
		));
		tableVLAN.getColumnModel().getColumn(6).setPreferredWidth(94);
		scrollPaneVLAN.setViewportView(tableVLAN);
		panelVLAN.setLayout(gl_panelVLAN);
		
		JPanel panelSpanningTree = new JPanel();
		tabbedPane.addTab("Spanning Tree", null, panelSpanningTree, null);
		
		JLabel labelSTP = new JLabel("Spanning Tree :");
		
		JComboBox comboBoxSTP = new JComboBox();
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblPortFast = new JLabel("PortFast :");
		lblPortFast.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JCheckBox chckbxBackboneFast = new JCheckBox("BackboneFast");
		
		JCheckBox chckbxUplinkfast = new JCheckBox("UplinkFast");
		GroupLayout gl_panelSpanningTree = new GroupLayout(panelSpanningTree);
		gl_panelSpanningTree.setHorizontalGroup(
			gl_panelSpanningTree.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSpanningTree.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSpanningTree.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSpanningTree.createSequentialGroup()
							.addGroup(gl_panelSpanningTree.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblPortFast, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(labelSTP, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
							.addGap(4)
							.addGroup(gl_panelSpanningTree.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxSTP, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)))
						.addGroup(gl_panelSpanningTree.createSequentialGroup()
							.addComponent(chckbxBackboneFast)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxUplinkfast)))
					.addContainerGap())
		);
		gl_panelSpanningTree.setVerticalGroup(
			gl_panelSpanningTree.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSpanningTree.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSpanningTree.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSpanningTree.createSequentialGroup()
							.addGap(3)
							.addComponent(labelSTP))
						.addComponent(comboBoxSTP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelSpanningTree.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPortFast))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelSpanningTree.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxBackboneFast)
						.addComponent(chckbxUplinkfast))
					.addContainerGap(215, Short.MAX_VALUE))
		);
		panelSpanningTree.setLayout(gl_panelSpanningTree);
		contentPane.setLayout(gl_contentPane);
	}
}
