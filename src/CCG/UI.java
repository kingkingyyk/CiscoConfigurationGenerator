package CCG;

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
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class UI extends JFrame {
	private static final long serialVersionUID = 4825412069624844585L;
	private JPanel contentPane;
	private JTextField textFieldL3Interface;
	private JTextField textFieldIpv4Address;
	private JTextField textFieldIpv4Subnet;
	private JTextField textFieldIpv6Address;
	private JTextField textFieldIpv6Subnet;
	private JTextField textFieldOSPFArea;
	private JTextField textFieldOSPFv3;
	private JTable tableStaticRouting;
	private JTextField textFieldHostname;
	private JTable tableOSPFSummaryAddress;
	private JTable tableVLAN;
	private JTextField textFieldPortFast;
	private JTextField textFieldTrunk;
	private JTextField textFieldOSPFPassiveInterfaces;
	private JTextField textFieldEIGRPPassiveInterfaces;
	private JTextField textFieldBGPASNumber;
	private JTable tableBGPNeighbors;
	private JTextField textFieldHSRPIP;
	private JTextField textFieldHSRPPriority;
	private JTextField textFieldHSRPv3IP;
	private JTextField textFieldHSRPv3Priority;
	private JComboBox<Interface> comboBoxInterface;
	private JButton btnAddInterface;
	private JButton btnDeleteInterface;
	private JCheckBox chckbxInterfaceOSPF;
	private JCheckBox chckbxEIGRP;
	private JCheckBox chckbxRipv2;
	private JCheckBox chckbxBgp;
	private JCheckBox chckbxOspfv3;
	private JCheckBox chckbxEigrpIpv6;
	private JCheckBox chckbxRipng;
	private JCheckBox checkBoxBgpv3;
	private JScrollPane scrollPaneSummaryAddress;
	private JCheckBox chckbxOSPFRedistributeEigrp;
	private JCheckBox chckbxOSPFRedistributeBgp;
	private JCheckBox chckbxOSPFRedistributeEigrpV6;
	private JCheckBox chckbxOSPFRedistributeBgpV6;
	private JCheckBox chckbxOSPFRedistributeRip;
	private JCheckBox chckbxOSPFRedistributeRipng;
	private JCheckBox chckbxOSPFRedistributeStatic;
	private JCheckBox chckbxOSPFRedistributeStaticV6;
	private JCheckBox chckbxEIGRPRedistributeOspf;
	private JCheckBox chckbxEIGRPNoSummary;
	private JCheckBox chckbxEIGRPRedistributeBgp;
	private JCheckBox chckbxEIGRPRedistributeRip;
	private JCheckBox chckbxEIGRPRedistributeStatic;
	private JCheckBox chckbxEIGRPRedistributeOSPFv3;
	private JCheckBox chckbxEIGRPRedistributeBgpV6;
	private JCheckBox chckbxEIGRPRedistributeRipng;
	private JCheckBox chckbxEIGRPRedistributeStaticV6;
	private JCheckBox chckbxSwitchLegacyIOS;
	private JComboBox<String> comboBoxSTP;
	private JCheckBox chckbxBackboneFast;
	private JCheckBox chckbxUplinkfast;
	private JTextField textFieldHSRPID;
	private JTextField textFieldHSRPV3ID;
	private JTextField textFieldBGPAS;
	private JTextField textFieldBGPV3AS;
	private JTextField textFieldOSPFPassiveInterfacesV3;
	private JLabel lblOSPFPassiveInterfacesV3;
	private JLabel lblOSPFRedistributeBGPAS;
	private JTextField textFieldOSPFRedistributeBGPAS;
	private JTextField textFieldEIGRPPassiveInterfacesV6;
	private JLabel lblEIGRPPassiveInterfacesV6;
	private JTextField textFieldEIGRPRedistributeBGPAS;
	private JLabel lblEIGRPRedistributeBGPAS;
	private JCheckBox chckbxRootguard;

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
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateCommands();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(tabbedPane)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(458, Short.MAX_VALUE)
					.addComponent(btnGenerate)
					.addContainerGap())
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
					.addComponent(textFieldHostname, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelGeneral.setVerticalGroup(
			gl_panelGeneral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGeneral.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelGeneral.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHostname)
						.addComponent(textFieldHostname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(276, Short.MAX_VALUE))
		);
		panelGeneral.setLayout(gl_panelGeneral);
		
		JPanel panelL3Interface = new JPanel();
		tabbedPane.addTab("L3 Interfaces", null, panelL3Interface, null);
		
		textFieldL3Interface = new JTextField();
		textFieldL3Interface.setColumns(10);
		
		comboBoxInterface = new JComboBox<>();
		comboBoxInterface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interface it=(Interface)comboBoxInterface.getSelectedItem();
				if (it!=null) {
					textFieldIpv4Address.setText(it.IPv4Add);
					textFieldIpv4Subnet.setText(it.IPv4Sub);
					chckbxInterfaceOSPF.setSelected(it.OSPFEn);
					textFieldOSPFArea.setText(it.OSPFArea);
					chckbxEIGRP.setSelected(it.EIGRPEn);
					chckbxRipv2.setSelected(it.RIPEn);
					chckbxBgp.setSelected(it.BGPEn);
					textFieldIpv6Address.setText(it.IPv6Add);
					textFieldIpv6Subnet.setText(it.IPv6Sub);
					textFieldOSPFv3.setText(it.OSPFV3Area);
					chckbxOspfv3.setSelected(it.OSPFV3En);
					chckbxEigrpIpv6.setSelected(it.EIGRPv6En);
					chckbxRipng.setSelected(it.RIPngEn);
					checkBoxBgpv3.setSelected(it.BGPv6En);
					textFieldHSRPIP.setText(it.HSRPIP);
					textFieldHSRPPriority.setText(it.HSRPPrio);
					textFieldHSRPID.setText(it.HSRPID);
					textFieldHSRPv3IP.setText(it.HSRPV3IP);
					textFieldHSRPv3Priority.setText(it.HSRPV3Prio);
					textFieldHSRPV3ID.setText(it.HSRPV3ID);
					textFieldBGPAS.setText(it.BGPAS);
					textFieldBGPV3AS.setText(it.BGPV3AS);
				} else {
					textFieldIpv4Address.setText("");
					textFieldIpv4Subnet.setText("");
					chckbxInterfaceOSPF.setSelected(false);
					textFieldOSPFArea.setText("");
					chckbxEIGRP.setSelected(false);
					chckbxRipv2.setSelected(false);
					chckbxBgp.setSelected(false);
					textFieldIpv6Address.setText("");
					textFieldIpv6Subnet.setText("");
					textFieldOSPFv3.setText("");
					chckbxOspfv3.setSelected(false);
					chckbxEigrpIpv6.setSelected(false);
					chckbxRipng.setSelected(false);
					checkBoxBgpv3.setSelected(false);
					textFieldHSRPIP.setText("");
					textFieldHSRPPriority.setText("");
					textFieldHSRPID.setText("");
					textFieldHSRPv3IP.setText("");
					textFieldHSRPv3Priority.setText("");
					textFieldHSRPV3ID.setText("");
					textFieldBGPAS.setText("");
					textFieldBGPV3AS.setText("");
				}
			}
			
		});
		
		JLabel lblInterface = new JLabel("Interface :");
		lblInterface.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblSelectInterface = new JLabel("Select Interface :");
		
		btnAddInterface = new JButton("Add Interface");
		btnAddInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textFieldL3Interface.getText().isEmpty()) {
					boolean exists=false;
					for (Interface i : CCG.ints) exists|=(i.name.equals(textFieldL3Interface.getText()));
					if (!exists) {
						Interface newInt=new Interface(textFieldL3Interface.getText());
						comboBoxInterface.addItem(newInt);
					}
					comboBoxInterface.setSelectedItem(Interface.Map.get(textFieldL3Interface.getText()));
				}
			}
		});
		
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
		
		chckbxInterfaceOSPF = new JCheckBox("OSPF");
		
		textFieldOSPFArea = new JTextField();
		textFieldOSPFArea.setColumns(10);
		
		chckbxEIGRP = new JCheckBox("EIGRP");
		
		chckbxRipv2 = new JCheckBox("RIPv2");
		
		chckbxOspfv3 = new JCheckBox("OSPFv3");
		
		textFieldOSPFv3 = new JTextField();
		textFieldOSPFv3.setColumns(10);
		
		chckbxEigrpIpv6 = new JCheckBox("EIGRP IPv6");
		
		chckbxRipng = new JCheckBox("RIPng");
		
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
		
		chckbxBgp = new JCheckBox("BGP");
		
		checkBoxBgpv3 = new JCheckBox("BGPv6");
		
		btnDeleteInterface = new JButton("Delete Interface");
		btnDeleteInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxInterface.getSelectedIndex()!=-1) {
					((Interface)comboBoxInterface.getSelectedItem()).destroy();
					comboBoxInterface.removeItem(comboBoxInterface.getSelectedItem());
				}
			}
		});
		
		JLabel lblHSRPId = new JLabel("ID :");
		lblHSRPId.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblHSRPV3Id = new JLabel("ID :");
		lblHSRPV3Id.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldHSRPID = new JTextField();
		textFieldHSRPID.setColumns(10);
		
		textFieldHSRPV3ID = new JTextField();
		textFieldHSRPV3ID.setColumns(10);
		
		textFieldBGPAS = new JTextField();
		textFieldBGPAS.setColumns(10);
		
		textFieldBGPV3AS = new JTextField();
		textFieldBGPV3AS.setColumns(10);
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
									.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldL3Interface, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
										.addComponent(comboBoxInterface, 0, 305, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnAddInterface, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnDeleteInterface, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))))
						.addGroup(gl_panelL3Interface.createSequentialGroup()
							.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblHSRP, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chckbxOspfv3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelL3Interface.createSequentialGroup()
									.addComponent(textFieldOSPFv3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(44)
									.addComponent(chckbxEigrpIpv6, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxRipng, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(checkBoxBgpv3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldBGPV3AS, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelL3Interface.createSequentialGroup()
									.addComponent(textFieldHSRPIP, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblHsrpPriority, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldHSRPPriority, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblHSRPId, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldHSRPID, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panelL3Interface.createSequentialGroup()
							.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panelL3Interface.createSequentialGroup()
									.addComponent(chckbxInterfaceOSPF)
									.addGap(14)
									.addComponent(textFieldOSPFArea, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(54)
									.addComponent(chckbxEIGRP, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(chckbxRipv2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelL3Interface.createSequentialGroup()
									.addComponent(lblIpv6Address, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldIpv6Address, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldIpv6Subnet, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addComponent(chckbxBgp, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldBGPAS, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelL3Interface.createSequentialGroup()
							.addComponent(lblHsrpv3Ip, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldHSRPv3IP, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHSRPv3Priority, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldHSRPv3Priority, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblHSRPV3Id)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldHSRPV3ID, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(comboBoxInterface, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteInterface))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIpv4Address)
						.addComponent(textFieldIpv4Address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(textFieldIpv4Subnet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxInterfaceOSPF)
						.addComponent(textFieldOSPFArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxEIGRP)
						.addComponent(chckbxRipv2)
						.addComponent(chckbxBgp)
						.addComponent(textFieldBGPAS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(chckbxOspfv3)
						.addComponent(textFieldOSPFv3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxEigrpIpv6)
						.addComponent(chckbxRipng)
						.addComponent(checkBoxBgpv3)
						.addComponent(textFieldBGPV3AS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHSRP)
						.addComponent(textFieldHSRPIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHsrpPriority)
						.addComponent(textFieldHSRPPriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHSRPId)
						.addComponent(textFieldHSRPID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelL3Interface.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHsrpv3Ip)
						.addComponent(textFieldHSRPv3IP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHSRPv3Priority)
						.addComponent(textFieldHSRPv3Priority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHSRPV3Id)
						.addComponent(textFieldHSRPV3ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(51))
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
		btnAddNewStaticRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((DefaultTableModel)tableStaticRouting.getModel()).addRow(new String [] {"","",""});
			}
		});
		panel.add(btnAddNewStaticRoute);
		
		JButton btnDeleteStaticRoute = new JButton("Delete");
		btnDeleteStaticRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int [] rows=tableStaticRouting.getSelectedRows();
				Arrays.sort(rows);
				for (int i=0;i<rows.length;i++) {
					rows[i]=rows[i]-i;
				}
				
				for (int i=0;i<rows.length;i++) {
					((DefaultTableModel)tableStaticRouting.getModel()).removeRow(rows[i]);
				}
			}
		});
		panel.add(btnDeleteStaticRoute);
		
		JPanel panelOSPF = new JPanel();
		tabbedPane.addTab("OSPF", null, panelOSPF, null);
		
		JLabel lblSummaryAddress = new JLabel("Summary Address :");
		
		scrollPaneSummaryAddress = new JScrollPane();
		
		JButton btnAddSummaryAddress = new JButton("Add");
		btnAddSummaryAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((DefaultTableModel)tableOSPFSummaryAddress.getModel()).addRow(new String [] {"","",""});
			}
		});
		
		JButton btnDeleteSummaryAddress = new JButton("Delete");
		btnDeleteSummaryAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int [] rows=tableOSPFSummaryAddress.getSelectedRows();
				Arrays.sort(rows);
				for (int i=0;i<rows.length;i++) {
					rows[i]-=i;
				}
				
				for (int row : rows) {
					((DefaultTableModel)tableOSPFSummaryAddress.getModel()).removeRow(row);
				}
			}
		});
		
		JLabel lblOSPFPassiveInterfaces = new JLabel("Passive Interfaces :");
		lblOSPFPassiveInterfaces.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldOSPFPassiveInterfaces = new JTextField();
		textFieldOSPFPassiveInterfaces.setColumns(10);
		
		chckbxOSPFRedistributeEigrp = new JCheckBox("Redistribute EIGRP");
		
		chckbxOSPFRedistributeBgp = new JCheckBox("Redistribute BGP");
		
		chckbxOSPFRedistributeRip = new JCheckBox("Redistribute RIP");
		
		chckbxOSPFRedistributeEigrpV6 = new JCheckBox("Redistribute EIGRP v6");
		
		chckbxOSPFRedistributeBgpV6 = new JCheckBox("Redistribute BGP v6");
		
		chckbxOSPFRedistributeRipng = new JCheckBox("Redistribute RIPng");
		
		chckbxOSPFRedistributeStatic = new JCheckBox("Redistribute Static");
		
		chckbxOSPFRedistributeStaticV6 = new JCheckBox("Redistribute Static");
		
		textFieldOSPFPassiveInterfacesV3 = new JTextField();
		textFieldOSPFPassiveInterfacesV3.setColumns(10);
		
		lblOSPFPassiveInterfacesV3 = new JLabel("Passive Interfaces v3 :");
		
		lblOSPFRedistributeBGPAS = new JLabel("BGP AS :");
		
		textFieldOSPFRedistributeBGPAS = new JTextField();
		textFieldOSPFRedistributeBGPAS.setColumns(10);
		GroupLayout gl_panelOSPF = new GroupLayout(panelOSPF);
		gl_panelOSPF.setHorizontalGroup(
			gl_panelOSPF.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOSPF.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelOSPF.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelOSPF.createSequentialGroup()
							.addGroup(gl_panelOSPF.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelOSPF.createSequentialGroup()
									.addGroup(gl_panelOSPF.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxOSPFRedistributeEigrp)
										.addComponent(chckbxOSPFRedistributeEigrpV6))
									.addGap(18))
								.addGroup(Alignment.TRAILING, gl_panelOSPF.createSequentialGroup()
									.addComponent(lblOSPFRedistributeBGPAS)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panelOSPF.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelOSPF.createSequentialGroup()
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
											.addComponent(chckbxOSPFRedistributeStatic, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panelOSPF.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldOSPFRedistributeBGPAS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addComponent(scrollPaneSummaryAddress, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panelOSPF.createSequentialGroup()
							.addComponent(lblSummaryAddress)
							.addPreferredGap(ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
							.addComponent(btnAddSummaryAddress)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeleteSummaryAddress))
						.addGroup(Alignment.TRAILING, gl_panelOSPF.createSequentialGroup()
							.addGroup(gl_panelOSPF.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblOSPFPassiveInterfaces, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblOSPFPassiveInterfacesV3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(8)
							.addGroup(gl_panelOSPF.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldOSPFPassiveInterfacesV3, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
								.addComponent(textFieldOSPFPassiveInterfaces, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))))
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
					.addComponent(scrollPaneSummaryAddress, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelOSPF.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOSPFPassiveInterfaces)
						.addComponent(textFieldOSPFPassiveInterfaces, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelOSPF.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldOSPFPassiveInterfacesV3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOSPFPassiveInterfacesV3))
					.addGap(6)
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelOSPF.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOSPFRedistributeBGPAS)
						.addComponent(textFieldOSPFRedistributeBGPAS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42))
		);
		
		tableOSPFSummaryAddress = new JTable();
		tableOSPFSummaryAddress.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Area", "Address", "Subnet Prefix"
			}
		));
		tableOSPFSummaryAddress.getColumnModel().getColumn(0).setPreferredWidth(164);
		tableOSPFSummaryAddress.getColumnModel().getColumn(1).setPreferredWidth(89);
		scrollPaneSummaryAddress.setViewportView(tableOSPFSummaryAddress);
		panelOSPF.setLayout(gl_panelOSPF);
		
		JPanel panelEIGRP = new JPanel();
		tabbedPane.addTab("EIGRP", null, panelEIGRP, null);
		
		chckbxEIGRPNoSummary = new JCheckBox("No Summary Address");
		
		JLabel lblEIGRPPassiveInterfaces = new JLabel("Passive Interfaces :");
		
		textFieldEIGRPPassiveInterfaces = new JTextField();
		textFieldEIGRPPassiveInterfaces.setColumns(10);
		
		chckbxEIGRPRedistributeOspf = new JCheckBox("Redistribute OSPF");
		
		chckbxEIGRPRedistributeBgp = new JCheckBox("Redistribute BGP");
		
		chckbxEIGRPRedistributeRip = new JCheckBox("Redistribute RIP");
		
		chckbxEIGRPRedistributeStatic = new JCheckBox("Redistribute Static");
		
		chckbxEIGRPRedistributeOSPFv3 = new JCheckBox("Redistribute OSPFv3");
		
		chckbxEIGRPRedistributeBgpV6 = new JCheckBox("Redistribute BGP v6");
		
		chckbxEIGRPRedistributeRipng = new JCheckBox("Redistribute RIPng");
		
		chckbxEIGRPRedistributeStaticV6 = new JCheckBox("Redistribute Static");
		
		textFieldEIGRPPassiveInterfacesV6 = new JTextField();
		textFieldEIGRPPassiveInterfacesV6.setColumns(10);
		
		lblEIGRPPassiveInterfacesV6 = new JLabel("Passive Interfaces V6 :");
		
		textFieldEIGRPRedistributeBGPAS = new JTextField();
		textFieldEIGRPRedistributeBGPAS.setColumns(10);
		
		lblEIGRPRedistributeBGPAS = new JLabel("BGP AS :");
		GroupLayout gl_panelEIGRP = new GroupLayout(panelEIGRP);
		gl_panelEIGRP.setHorizontalGroup(
			gl_panelEIGRP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEIGRP.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelEIGRP.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelEIGRP.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelEIGRP.createSequentialGroup()
								.addComponent(chckbxEIGRPRedistributeOspf, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addGap(32)
								.addComponent(chckbxEIGRPRedistributeBgp, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(chckbxEIGRPRedistributeRip, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(chckbxEIGRPRedistributeStatic, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panelEIGRP.createSequentialGroup()
								.addComponent(chckbxEIGRPRedistributeOSPFv3, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_panelEIGRP.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelEIGRP.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblEIGRPRedistributeBGPAS)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldEIGRPRedistributeBGPAS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelEIGRP.createSequentialGroup()
										.addComponent(chckbxEIGRPRedistributeBgpV6, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(chckbxEIGRPRedistributeRipng, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(chckbxEIGRPRedistributeStaticV6, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(chckbxEIGRPNoSummary)
						.addGroup(Alignment.TRAILING, gl_panelEIGRP.createSequentialGroup()
							.addGroup(gl_panelEIGRP.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblEIGRPPassiveInterfacesV6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblEIGRPPassiveInterfaces, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelEIGRP.createParallelGroup(Alignment.TRAILING)
								.addComponent(textFieldEIGRPPassiveInterfaces, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
								.addComponent(textFieldEIGRPPassiveInterfacesV6))))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelEIGRP.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldEIGRPPassiveInterfacesV6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEIGRPPassiveInterfacesV6))
					.addGap(9)
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelEIGRP.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldEIGRPRedistributeBGPAS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEIGRPRedistributeBGPAS))
					.addContainerGap(139, Short.MAX_VALUE))
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
		btnBGPAddNeighbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel)tableBGPNeighbors.getModel()).addRow(new String [] {"",""});
			}
		});
		
		JButton btnBGPDeleteNeighbor = new JButton("Delete");
		btnBGPDeleteNeighbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int [] rows=tableBGPNeighbors.getSelectedRows();
				Arrays.sort(rows);
				for (int i=0;i<rows.length;i++) rows[i]-=i;
				
				for (int row : rows) ((DefaultTableModel)tableBGPNeighbors.getModel()).removeRow(row);
			}
		});
		GroupLayout gl_panelBGP = new GroupLayout(panelBGP);
		gl_panelBGP.setHorizontalGroup(
			gl_panelBGP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBGP.createSequentialGroup()
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
							.addComponent(btnBGPDeleteNeighbor, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
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
					.addGap(73))
		);
		
		tableBGPNeighbors = new JTable();
		tableBGPNeighbors.setModel(new DefaultTableModel(
			new Object[][] {
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
		
		chckbxSwitchLegacyIOS = new JCheckBox("Legacy iOS");
		
		JScrollPane scrollPaneVLAN = new JScrollPane();
		
		JButton btnAddVLAN = new JButton("Add VLAN");
		btnAddVLAN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel)tableVLAN.getModel()).addRow(new String [] {"","","","","","",""});
			}
		});
		
		JButton btnDeleteVLAN = new JButton("Delete VLAN");
		btnDeleteVLAN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int [] rows=tableVLAN.getSelectedRows();
				for (int i=0;i<rows.length;i++) rows[i]-=i;
				
				for (int row : rows) ((DefaultTableModel)tableVLAN.getModel()).removeRow(row);
			}
		});
		
		JLabel lblTrunk = new JLabel("Trunk :");
		lblTrunk.setHorizontalAlignment(SwingConstants.CENTER);
		
		textFieldTrunk = new JTextField();
		textFieldTrunk.setColumns(10);
		
		chckbxRootguard = new JCheckBox("RootGuard");
		GroupLayout gl_panelVLAN = new GroupLayout(panelVLAN);
		gl_panelVLAN.setHorizontalGroup(
			gl_panelVLAN.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVLAN.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelVLAN.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneVLAN, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
						.addGroup(gl_panelVLAN.createSequentialGroup()
							.addComponent(chckbxSwitchLegacyIOS)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxRootguard, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
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
						.addComponent(btnDeleteVLAN)
						.addComponent(chckbxRootguard))
					.addGap(18)
					.addComponent(scrollPaneVLAN, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
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
				"VLAN", "Name", "Interfaces", "IP", "IPv6", "Root Primary", "Root Secondary"
			}
		));
		tableVLAN.getColumnModel().getColumn(6).setPreferredWidth(94);
		scrollPaneVLAN.setViewportView(tableVLAN);
		panelVLAN.setLayout(gl_panelVLAN);
		
		JPanel panelSpanningTree = new JPanel();
		tabbedPane.addTab("Spanning Tree", null, panelSpanningTree, null);
		
		JLabel labelSTP = new JLabel("Spanning Tree :");
		
		comboBoxSTP = new JComboBox<>();
		comboBoxSTP.addItem("None");
		comboBoxSTP.addItem("PVST");
		comboBoxSTP.addItem("Rapid-PVST+");
		
		textFieldPortFast = new JTextField();
		textFieldPortFast.setColumns(10);
		
		JLabel lblPortFast = new JLabel("PortFast :");
		lblPortFast.setHorizontalAlignment(SwingConstants.RIGHT);
		
		chckbxBackboneFast = new JCheckBox("BackboneFast");
		
		chckbxUplinkfast = new JCheckBox("UplinkFast");
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
								.addComponent(textFieldPortFast, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)))
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
						.addComponent(textFieldPortFast, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPortFast))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelSpanningTree.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxBackboneFast)
						.addComponent(chckbxUplinkfast))
					.addContainerGap(215, Short.MAX_VALUE))
		);
		panelSpanningTree.setLayout(gl_panelSpanningTree);
		contentPane.setLayout(gl_contentPane);
		
		setupInterfaceSaveData();
		setupSTPSaveData();
	}
	
	private void setupInterfaceSaveData() {
		ArrayList<JTextField> txtFld=new ArrayList<>();
		txtFld.add(textFieldIpv4Address);
		txtFld.add(textFieldIpv4Subnet);
		txtFld.add(textFieldOSPFArea);
		txtFld.add(textFieldIpv6Address);
		txtFld.add(textFieldIpv6Subnet);
		txtFld.add(textFieldOSPFv3);
		txtFld.add(textFieldHSRPIP);
		txtFld.add(textFieldHSRPPriority);
		txtFld.add(textFieldHSRPID);
		txtFld.add(textFieldHSRPv3IP);
		txtFld.add(textFieldHSRPv3Priority);
		txtFld.add(textFieldHSRPV3ID);
		txtFld.add(textFieldBGPAS);
		txtFld.add(textFieldBGPV3AS);
		
		ArrayList<JCheckBox> chckbx=new ArrayList<>();
		chckbx.add(chckbxEIGRP);
		chckbx.add(chckbxRipv2);
		chckbx.add(chckbxBgp);
		chckbx.add(chckbxOspfv3);
		chckbx.add(chckbxEigrpIpv6);
		chckbx.add(chckbxRipng);
		chckbx.add(checkBoxBgpv3);
		chckbx.add(chckbxInterfaceOSPF);
		
		for (JTextField tf : txtFld) {
			tf.addKeyListener(new KeyListener() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					saveInterfaceData();
				}
				@Override
				public void keyReleased(KeyEvent arg0) {
					saveInterfaceData();
				}
				@Override
				public void keyTyped(KeyEvent arg0) {
					saveInterfaceData();
				}
			});
		}
		
		for (JCheckBox cb : chckbx) {
			cb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					saveInterfaceData();
				}
				
			});
		}
	}
	
	private void saveInterfaceData() {
		Interface it=(Interface)comboBoxInterface.getSelectedItem();
		if (it!=null) {
			it.IPv4Add=textFieldIpv4Address.getText();
			it.IPv4Sub=textFieldIpv4Subnet.getText();
			it.OSPFArea=textFieldOSPFArea.getText();
			it.IPv6Add=textFieldIpv6Address.getText();
			it.IPv6Sub=textFieldIpv6Subnet.getText();
			it.OSPFV3Area=textFieldOSPFv3.getText();
			it.HSRPIP=textFieldHSRPIP.getText();
			it.HSRPPrio=textFieldHSRPPriority.getText();
			it.HSRPID=textFieldHSRPID.getText();
			it.HSRPV3IP=textFieldHSRPv3IP.getText();
			it.HSRPV3Prio=textFieldHSRPv3Priority.getText();
			it.HSRPV3ID=textFieldHSRPV3ID.getText();
			it.BGPAS=textFieldBGPAS.getText();
			it.BGPV3AS=textFieldBGPV3AS.getText();
			
			it.EIGRPEn=chckbxEIGRP.isSelected();
			it.RIPEn=chckbxRipv2.isSelected();
			it.BGPEn=chckbxBgp.isSelected();
			it.OSPFV3En=chckbxOspfv3.isSelected();
			it.EIGRPv6En=chckbxEigrpIpv6.isSelected();
			it.RIPngEn=chckbxRipng.isSelected();
			it.BGPv6En=checkBoxBgpv3.isSelected();
			it.OSPFEn=chckbxInterfaceOSPF.isSelected();
		}
	}
	
	private void setupSTPSaveData() {
		
		ArrayList<JTextField> txtFld=new ArrayList<>();
		txtFld.add(textFieldPortFast);
		
		ArrayList<JCheckBox> chckbx=new ArrayList<>();
		chckbx.add(chckbxBackboneFast);
		chckbx.add(chckbxUplinkfast);
		
		ArrayList<JComboBox<String>> comboBox=new ArrayList<>();
		comboBox.add(comboBoxSTP);
		
		for (JTextField tf : txtFld) {
			tf.addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent arg0) {
					saveSTPData();
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					saveSTPData();
				}

				@Override
				public void keyTyped(KeyEvent arg0) {
					saveSTPData();
				}
			
			});
		}
		
		for (JCheckBox cb : chckbx) {
			cb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					saveSTPData();
				}
				
			});
		}
		
		for (JComboBox<String> cb : comboBox) {
			cb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					saveSTPData();
				}
				
			});
		}
	}
	
	private void saveSTPData() {
		CCG.STP=(String)comboBoxSTP.getSelectedItem();
		CCG.PortFast=textFieldPortFast.getText();
		CCG.backboneFast=chckbxBackboneFast.isSelected();
		CCG.uplinkFast=chckbxUplinkfast.isSelected();
	}
	
	public void generateInterfaceCommands(StringBuilder sb) {
		for (Interface it : CCG.ints) {
			addCommand(sb,"int "+it.name);
			if (it.name.contains(".")) {
				addCommand(sb,"int "+it.name.split("\\.")[0]);
				addCommand(sb,"no shut");
				addCommand(sb,"int "+it.name);
				addCommand(sb,"encap dot1Q "+it.name.split("\\.")[1]);
			}
			addCommand(sb,"no shut");

			if (it.IPv4Add!=null && !it.IPv4Add.isEmpty()) {
				addCommand(sb,"ip add "+it.IPv4Add+" "+Utility.getSubnetMask(Integer.parseInt(it.IPv4Sub)));
				if (it.OSPFEn) {
					addCommand(sb,"exit");
					addCommand(sb,"router ospf 1");
					addCommand(sb,"network "+Utility.getSubnetAddress(it.IPv4Add, Integer.parseInt(it.IPv4Sub))+" "+Utility.getWildcardMask(Integer.parseInt(it.IPv4Sub))+" area "+it.OSPFArea);
					addCommand(sb,"exit");
					addCommand(sb,"int "+it.name);
				}
				if (it.EIGRPEn) {
					addCommand(sb,"exit");
					addCommand(sb,"router eigrp 1");
					addCommand(sb,"network "+Utility.getSubnetAddress(it.IPv4Add, Integer.parseInt(it.IPv4Sub))+" "+Utility.getWildcardMask(Integer.parseInt(it.IPv4Sub)));
					addCommand(sb,"exit");
					addCommand(sb,"int "+it.name);
				}
				if (it.RIPEn) {
					addCommand(sb,"exit");
					addCommand(sb,"router rip");
					addCommand(sb,"no auto-sum");
					addCommand(sb,"network "+Utility.getSubnetAddress(it.IPv4Add, Integer.parseInt(it.IPv4Sub)));
					addCommand(sb,"exit");
					addCommand(sb,"int "+it.name);
				}
				if (it.BGPEn) {
					addCommand(sb,"exit");
					addCommand(sb,"router bgp "+it.BGPAS);
					addCommand(sb,"address-family ipv4");
					addCommand(sb,"network "+Utility.getSubnetAddress(it.IPv4Add, Integer.parseInt(it.IPv4Sub))+" mask "+Utility.getSubnetMask(Integer.parseInt(it.IPv4Sub)));
					addCommand(sb,"exit");
					addCommand(sb,"exit");
					addCommand(sb,"int "+it.name);
				}
				if (it.HSRPIP!=null && !it.HSRPIP.isEmpty()) {
					addCommand(sb,"standby "+it.HSRPID+" ip "+it.HSRPIP);
					addCommand(sb,"standby "+it.HSRPID+" priority "+it.HSRPPrio);
				}
				
			}
			if (it.IPv6Add!=null && !it.IPv6Add.isEmpty()) {
				addCommand(sb,"ipv6 en");
				addCommand(sb,"ipv6 add "+it.IPv6Add+"/"+it.IPv6Sub);
				if (it.OSPFV3En) {
					addCommand(sb,"exit");
					addCommand(sb,"ipv6 router ospf 1");
					addCommand(sb,"exit");
					addCommand(sb,"int "+it.name);
					addCommand(sb,"ipv6 ospf 1 area "+it.OSPFV3Area);
				}
				if (it.EIGRPv6En) {
					addCommand(sb,"exit");
					addCommand(sb,"ipv6 router eigrp 1");
					addCommand(sb,"exit");
					addCommand(sb,"int "+it.name);
					addCommand(sb,"ipv6 eigrp 1");
				}
				if (it.RIPngEn) {
					addCommand(sb,"exit");
					addCommand(sb,"ipv6 router rip 1");
					addCommand(sb,"exit");
					addCommand(sb,"int "+it.name);
					addCommand(sb,"ipv6 rip 1 en");
				}
				if (it.BGPv6En) {
					addCommand(sb,"exit");
					addCommand(sb,"router bgp "+it.BGPV3AS);
					addCommand(sb,"address-family ipv6");
					addCommand(sb,"network "+Utility.getSubnetAddressV6(it.IPv6Add, Integer.parseInt(it.IPv6Sub))+"/"+it.IPv6Sub);
					addCommand(sb,"exit");
					addCommand(sb,"int "+it.name);
				}
				if (it.HSRPV3IP!=null && !it.HSRPV3IP.isEmpty()) {
					addCommand(sb,"standby "+it.HSRPV3ID+" ipv6 "+it.HSRPV3IP);
					addCommand(sb,"standby "+it.HSRPV3ID+" priority "+it.HSRPV3Prio);
				}
			}
			addCommand(sb,"exit");
		}
	}
	
	public void generateSTPCommands(StringBuilder sb) {
		if (comboBoxSTP.getSelectedIndex()==1) addCommand(sb,"span mode pvst");
		else if (comboBoxSTP.getSelectedIndex()==2) addCommand(sb,"span mode rapid");
		
		if (chckbxBackboneFast.isSelected()) addCommand(sb,"span backbonefast");
		if (chckbxUplinkfast.isSelected()) addCommand(sb,"span uplinkfast");
		
		if (CCG.PortFast!=null && !CCG.PortFast.isEmpty()) {
			for (String s : CCG.PortFast.split(";")) {
				addCommand(sb,"int "+s);
				addCommand(sb,"span portfast");
				addCommand(sb,"exit");
			}
		}
	}
	
	public void generateStaticRoutingCommands(StringBuilder sb) {
		int staticRouteRows=tableStaticRouting.getModel().getRowCount();
		int staticRouteIPIndex=-1; int staticRouteSubnetIndex=-1; int staticRouteNextHopIndex=-1;
		
		for (int i=0;i<tableStaticRouting.getColumnCount();i++) {
			switch ((String)tableStaticRouting.getColumnName(i)) {
				case "Network Address" : {
					staticRouteIPIndex=i;
					break;
				}
				case "Subnet Prefix" : {
					staticRouteSubnetIndex=i;
					break;
				}
				case "Next Hop" : {
					staticRouteNextHopIndex=i;
					break;
				}
			}
		}

		for (int i=0;i<staticRouteRows;i++) {
			String ip=(String)tableStaticRouting.getValueAt(i,staticRouteIPIndex);
			if (ip.contains(".")) {
				int subnet=Integer.parseInt((String)tableStaticRouting.getValueAt(i,staticRouteSubnetIndex));
				if (subnet>0) {
					addCommand(sb,"ip route "+ip+" "+Utility.getWildcardMask(subnet)+
							   " "+(String)tableStaticRouting.getValueAt(i,staticRouteNextHopIndex));
				} else {
					addCommand(sb,"ip route "+ip+" 0.0.0.0"+
							   " "+(String)tableStaticRouting.getValueAt(i,staticRouteNextHopIndex));
				}
			} else if (ip.contains(":")) {
				int subnet=Integer.parseInt((String)tableStaticRouting.getValueAt(i,staticRouteSubnetIndex));
				addCommand(sb,"ipv6 route "+ip+"/"+subnet+
						   " "+(String)tableStaticRouting.getValueAt(i,staticRouteNextHopIndex));
			}
		}
	}
	
	public void generateOSPFCommands (StringBuilder sb) {
		int rows=tableOSPFSummaryAddress.getModel().getRowCount();
		int summaryIndex=-1; int subnetIndex=-1; int areaIndex=-1;
		
		for (int i=0;i<tableOSPFSummaryAddress.getColumnCount();i++) {
			switch ((String)tableOSPFSummaryAddress.getColumnName(i)) {
				case "Address" : {
					summaryIndex=i;
					break;
				}
				case "Subnet Prefix" : {
					subnetIndex=i;
					break;
				}
				case "Area" : {
					areaIndex=i;
					break;
				}
			}
		}
		
		for (int i=0;i<rows;i++) {
			String area=(String)tableOSPFSummaryAddress.getModel().getValueAt(i,areaIndex);
			String add=(String)tableOSPFSummaryAddress.getModel().getValueAt(i,summaryIndex);
			String subnet=(String)tableOSPFSummaryAddress.getModel().getValueAt(i,subnetIndex);
			if (add.contains(".")) {
				addCommand(sb,"router ospf 1");
				addCommand(sb,"area "+area+" range "+add+" "+Utility.getSubnetMask(Integer.parseInt(subnet)));
				addCommand(sb,"exit");
			} else if (add.contains(":")) {
				addCommand(sb,"ipv6 router ospf 1");
				addCommand(sb,"area "+area+" range "+add+" "+Utility.getSubnetMask(Integer.parseInt(subnet)));
				addCommand(sb,"exit");
			}
		}
		
		String passInt=textFieldOSPFPassiveInterfaces.getText();
		if (passInt!=null && !passInt.isEmpty()) {
			addCommand(sb,"router ospf 1");
			for (String in : passInt.split(";")) {
				addCommand(sb,"pass "+in);
			}
			addCommand(sb,"exit");
		}
		
		passInt=textFieldOSPFPassiveInterfacesV3.getText();
		if (passInt!=null && !passInt.isEmpty()) {
			addCommand(sb,"ipv6 router ospf 1");
			for (String in : passInt.split(";")) {
				addCommand(sb,"pass "+in);
			}
			addCommand(sb,"exit");
		}
		
		if (chckbxOSPFRedistributeEigrp.isSelected() || chckbxOSPFRedistributeBgp.isSelected() || chckbxOSPFRedistributeRip.isSelected() || chckbxOSPFRedistributeStatic.isSelected()) {
			addCommand(sb,"router ospf 1");
			if (chckbxOSPFRedistributeEigrp.isSelected()) addCommand(sb,"redist eigrp 1 subnets");
			if (chckbxOSPFRedistributeBgp.isSelected()) addCommand(sb,"redist bgp "+textFieldOSPFRedistributeBGPAS.getText()+" subnets");
			if (chckbxOSPFRedistributeRip.isSelected()) addCommand(sb,"redist rip subnets");
			if (chckbxOSPFRedistributeStatic.isSelected()) addCommand(sb,"redist static subnets");
			addCommand(sb,"exit");
		}
		
		if (chckbxOSPFRedistributeEigrpV6.isSelected() || chckbxOSPFRedistributeBgpV6.isSelected() || chckbxOSPFRedistributeRipng.isSelected() || chckbxOSPFRedistributeStaticV6.isSelected()) {
			addCommand(sb,"ipv6 router ospf 1");
			if (chckbxOSPFRedistributeEigrpV6.isSelected()) addCommand(sb,"redist eigrp 1");
			if (chckbxOSPFRedistributeBgpV6.isSelected()) addCommand(sb,"redist bgp "+textFieldOSPFRedistributeBGPAS.getText());
			if (chckbxOSPFRedistributeRipng.isSelected()) addCommand(sb,"redist rip 1");
			if (chckbxOSPFRedistributeStaticV6.isSelected()) addCommand(sb,"redist static");
			addCommand(sb,"exit");
		}
	}
	
	public void generateEIGRPCommands (StringBuilder sb) {
		if (chckbxEIGRPNoSummary.isSelected()) {
			addCommand(sb,"router eigrp 1");
			addCommand(sb,"no auto");
			addCommand(sb,"exit");
		}
		
		String passInt=textFieldEIGRPPassiveInterfaces.getText();
		if (passInt!=null && !passInt.isEmpty()) {
			addCommand(sb,"router eigrp 1");
			for (String in : passInt.split(";")) {
				addCommand(sb,"pass "+in);
			}
			addCommand(sb,"exit");
		}
		
		passInt=textFieldEIGRPPassiveInterfacesV6.getText();
		if (passInt!=null && !passInt.isEmpty()) {
			addCommand(sb,"ipv6 router eigrp 1");
			for (String in : passInt.split(";")) {
				addCommand(sb,"pass "+in);
			}
			addCommand(sb,"exit");
		}
		
		if (chckbxEIGRPRedistributeOspf.isSelected() || chckbxEIGRPRedistributeBgp.isSelected() || chckbxEIGRPRedistributeRip.isSelected() || chckbxEIGRPRedistributeStatic.isSelected()) {
			addCommand(sb,"router eigrp 1");
			if (chckbxEIGRPRedistributeOspf.isSelected()) addCommand(sb,"redist ospf 1 metric 10000 100 255 1 1500");
			if (chckbxEIGRPRedistributeBgp.isSelected()) addCommand(sb,"redist bgp "+textFieldEIGRPRedistributeBGPAS.getText()+" metric 8000 100 255 1 1500");
			if (chckbxEIGRPRedistributeRip.isSelected()) addCommand(sb,"redist rip metric 5000 100 255 1 1500");
			if (chckbxEIGRPRedistributeStatic.isSelected()) addCommand(sb,"redist static metric 15000 100 255 1 1500");
			addCommand(sb,"exit");
		}
		
		if (chckbxEIGRPRedistributeOSPFv3.isSelected() || chckbxEIGRPRedistributeBgpV6.isSelected() || chckbxEIGRPRedistributeRipng.isSelected() || chckbxEIGRPRedistributeStaticV6.isSelected()) {
			addCommand(sb,"ipv6 router eigrp 1");
			if (chckbxEIGRPRedistributeOSPFv3.isSelected()) addCommand(sb,"redist ospf 1 metric 10000 100 255 1 1500");
			if (chckbxEIGRPRedistributeBgpV6.isSelected()) addCommand(sb,"redist bgp "+textFieldEIGRPRedistributeBGPAS.getText()+" metric 8000 100 255 1 1500");
			if (chckbxEIGRPRedistributeRipng.isSelected()) addCommand(sb,"redist rip 1 metric 5000 100 255 1 1500");
			if (chckbxEIGRPRedistributeStaticV6.isSelected()) addCommand(sb,"redist static  metric 15000 100 255 1 1500");
			addCommand(sb,"exit");
		}
	}
	
	public void generateBGPCommands(StringBuilder sb) {
		String bgpAS=textFieldBGPAS.getText();
		if (bgpAS!=null && !bgpAS.isEmpty()) {
			addCommand(sb,"router bgp "+bgpAS);
			addCommand(sb,"exit");
			
			int rows=tableBGPNeighbors.getModel().getRowCount();
			int IPIndex=-1; int asIndex=-1;
			
			for (int i=0;i<tableBGPNeighbors.getColumnCount();i++) {
				switch ((String)tableBGPNeighbors.getColumnName(i)) {
					case "IP Address" : {
						IPIndex=i;
						break;
					}
					case "Remote-AS" : {
						asIndex=i;
						break;
					}
				}
			}
			

			for (int i=0;i<rows;i++) {
				addCommand(sb,"router bgp "+bgpAS);
				String ip=(String)tableBGPNeighbors.getModel().getValueAt(i,IPIndex);
				addCommand(sb,"neighbor "+ip+" remote-as "+(String)tableBGPNeighbors.getModel().getValueAt(i,asIndex));
				if (ip.contains(".")) {
					addCommand(sb,"address-family ipv4");
					addCommand(sb,"neighbor "+ip+" activate");
					addCommand(sb,"exit");
				} else if (ip.contains(":")){
					addCommand(sb,"address-family ipv6");
					addCommand(sb,"neighbor "+ip+" activate");
					addCommand(sb,"exit");
				}
				addCommand(sb,"exit");
			}
			
			
		}
	}
	
	public void generateVLANCommands (StringBuilder sb) {
		int rows=tableVLAN.getModel().getRowCount();
		int vlanIndex=-1; int nameIndex=-1; int intIndex=-1;
		int ipIndex=-1; int ipv6Index=-1; int rootPrimaryIndex=-1; int rootSecondaryIndex=-1;
		
		for (int i=0;i<tableVLAN.getColumnCount();i++) {
			switch ((String)tableVLAN.getColumnName(i)) {
				case "VLAN" : {
					vlanIndex=i;
					break;
				}
				case "Name" : {
					nameIndex=i;
					break;
				}
				case "Interfaces" : {
					intIndex=i;
					break;
				}
				case "IP" : {
					ipIndex=i;
					break;
				}
				case "IPv6" : {
					ipv6Index=i;
					break;
				}
				case "Root Primary" : {
					rootPrimaryIndex=i;
					break;
				}
				case "Root Secondary" : {
					rootSecondaryIndex=i;
					break;
				}
			}
		}
		
		for (int i=0;i<rows;i++) {
			String vlan=(String)tableVLAN.getModel().getValueAt(i,vlanIndex);
			String name=(String)tableVLAN.getModel().getValueAt(i,nameIndex);
			String inter=(String)tableVLAN.getModel().getValueAt(i,intIndex);
			String ip=(String)tableVLAN.getModel().getValueAt(i,ipIndex);
			String ipv6=(String)tableVLAN.getModel().getValueAt(i,ipv6Index);
			String rootPrim=(String)tableVLAN.getModel().getValueAt(i,rootPrimaryIndex);
			String rootSec=(String)tableVLAN.getModel().getValueAt(i,rootSecondaryIndex);
			
			if (chckbxSwitchLegacyIOS.isSelected()) {
				addCommand(sb,"exit");
				addCommand(sb,"vlan database");
				if (name!=null && !name.isEmpty()) addCommand(sb,"vlan "+vlan+" name "+name);
				else addCommand(sb,"vlan "+vlan);
				addCommand(sb,"exit");
				addCommand(sb,"conf t");
			} else {
				addCommand(sb,"vlan "+vlan);
				if (name!=null && !name.isEmpty()) addCommand(sb,"name "+name);
				addCommand(sb,"exit");
			}
			
			addCommand(sb,"int vlan "+vlan);
			if (ip!=null && !ip.isEmpty()) addCommand(sb,"ip add "+ip);
			if (ipv6!=null && !ipv6.isEmpty()) addCommand(sb,"ipv6 add "+ipv6);
			addCommand(sb,"exit");
			
			if (inter!=null && !inter.isEmpty()) {
				for (String in : inter.split(";")) {
					addCommand(sb,"int "+in);
					addCommand(sb,"switchport mode access");
					addCommand(sb,"switchport access vlan "+vlan);
					addCommand(sb,"exit");
				}
			}
			
			if (rootPrim!=null && !rootPrim.isEmpty()) addCommand(sb,"span vlan "+vlan+" root primary");
			if (rootSec!=null && !rootSec.isEmpty()) addCommand(sb,"span vlan "+vlan+" root secondary");
		}
		
		String trunks=textFieldTrunk.getText();
		if (trunks!=null && !trunks.isEmpty()) {
			for (String in : trunks.split(";")) {
				addCommand(sb,"int "+in);
				addCommand(sb,"switchport mode trunk");
				for (int i=0;i<rows;i++) {
					String vlan=(String)tableVLAN.getModel().getValueAt(i,vlanIndex);
					addCommand(sb,"switchport trunk allowed vlan add "+vlan);
				}
				addCommand(sb,"exit");
			}
		}
	}
	
	public void generateCommands() {
		StringBuilder sb=new StringBuilder();
		addCommand(sb,"en"); addCommand(sb,"conf t");
		if (!textFieldHostname.getText().isEmpty()) addCommand(sb,"hostname "+textFieldHostname.getText());
		addCommand(sb,"ipv6 uni"); addCommand(sb,"ip routing");
		
		generateInterfaceCommands(sb);
		generateSTPCommands(sb);
		generateStaticRoutingCommands(sb);
		generateOSPFCommands(sb);
		generateEIGRPCommands(sb);
		generateBGPCommands(sb);
		generateVLANCommands(sb);
		
		CommandDialog diag=new CommandDialog(sb.toString());
		diag.setLocationRelativeTo(null);
		diag.setVisible(true);
	}
	
	private void addCommand(StringBuilder sb, String s) {
		sb.append(s);
		sb.append('\n');
	}
}
