import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import com.jgoodies.looks.FontPolicies;
import com.jgoodies.looks.FontPolicy;
import com.jgoodies.looks.FontSet;
import com.jgoodies.looks.FontSets;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.toedter.calendar.JCalendar;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;


public class HomeScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField textField;
	private JTextField txtPetName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen frame = new HomeScreen();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public HomeScreen() {
		
		setTitle("PB's Purrfect Pet Clinic");
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 962, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
					.addGap(3))
		);
		
		JPanel panelAppointments = new JPanel();
		tabbedPane.addTab("Appointments", null, panelAppointments, null);
		
		initializeLookAndFeels();

		JCalendar calendarAppointments = new JCalendar();
		
		JDesktopPane desktopPane = new JDesktopPane();
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		GroupLayout gl_panelAppointments = new GroupLayout(panelAppointments);
		gl_panelAppointments.setHorizontalGroup(
			gl_panelAppointments.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAppointments.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAppointments.createParallelGroup(Alignment.LEADING)
						.addComponent(desktopPane)
						.addGroup(gl_panelAppointments.createSequentialGroup()
							.addComponent(calendarAppointments, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(desktopPane_1)))
					.addContainerGap())
		);
		gl_panelAppointments.setVerticalGroup(
			gl_panelAppointments.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAppointments.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAppointments.createParallelGroup(Alignment.LEADING)
						.addComponent(calendarAppointments, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
						.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtFirstName.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JScrollPane scrollPaneAppointment = new JScrollPane();
		
		JEditorPane dtrpnNotes = new JEditorPane();
		dtrpnNotes.setText("Notes");
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textField.setColumns(10);
		
		txtPetName = new JTextField();
		txtPetName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtPetName.setColumns(10);
		
		JLabel lblPetName = new JLabel("Pet Name:");
		lblPetName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JComboBox cbPetType = new JComboBox();
		cbPetType.setModel(new DefaultComboBoxModel(new String[] {"Feline", "Canine"}));
		
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		cbPetType.setRenderer(dlcr);
		
		JCheckBox chckbxOfficeVisit = new JCheckBox("Office Visit");
		chckbxOfficeVisit.setBackground(UIManager.getColor("Desktop.background"));
		
		JCheckBox chckbxMicrochipping = new JCheckBox("Microchipping");
		chckbxMicrochipping.setBackground(UIManager.getColor("Desktop.background"));

		JCheckBox chckbxHeartwormTesting = new JCheckBox("Heartworm Testing");
		chckbxHeartwormTesting.setBackground(UIManager.getColor("Desktop.background"));

		JCheckBox chckbxSpayNeuter = new JCheckBox("Spay/Neuter");
		chckbxSpayNeuter.setBackground(UIManager.getColor("Desktop.background"));

		JCheckBox chckbxLabWork = new JCheckBox("Lab Work");
		chckbxLabWork.setBackground(UIManager.getColor("Desktop.background"));

		JCheckBox chckbxDentalCleaning = new JCheckBox("Dental Cleaning");
		chckbxDentalCleaning.setBackground(UIManager.getColor("Desktop.background"));

		JCheckBox chckbxXRay = new JCheckBox("X-Ray");
		chckbxXRay.setBackground(UIManager.getColor("Desktop.background"));

		
		GroupLayout gl_desktopPane_1 = new GroupLayout(desktopPane_1);
		gl_desktopPane_1.setHorizontalGroup(
			gl_desktopPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_desktopPane_1.createSequentialGroup()
							.addComponent(dtrpnNotes, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_desktopPane_1.createSequentialGroup()
							.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPetName, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFirstName))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.LEADING)
								.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPetName, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_desktopPane_1.createSequentialGroup()
									.addGap(12)
									.addComponent(cbPetType, 0, 93, Short.MAX_VALUE)
									.addGap(8))
								.addGroup(gl_desktopPane_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblLastName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_desktopPane_1.createSequentialGroup()
							.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(chckbxMicrochipping, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chckbxOfficeVisit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chckbxHeartwormTesting, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_desktopPane_1.createSequentialGroup()
									.addComponent(chckbxLabWork, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(chckbxXRay, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_desktopPane_1.createSequentialGroup()
									.addComponent(chckbxSpayNeuter, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(chckbxDentalCleaning, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))))
					.addGap(18)
					.addComponent(scrollPaneAppointment, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_desktopPane_1.setVerticalGroup(
			gl_desktopPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPaneAppointment, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_desktopPane_1.createSequentialGroup()
							.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.BASELINE, false)
									.addComponent(lblFirstName)
									.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblLastName)))
							.addGap(11)
							.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPetName)
								.addComponent(txtPetName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbPetType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxOfficeVisit)
								.addComponent(chckbxDentalCleaning)
								.addComponent(chckbxSpayNeuter))
							.addGap(1)
							.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxMicrochipping)
								.addComponent(chckbxXRay)
								.addComponent(chckbxLabWork))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_desktopPane_1.createSequentialGroup()
									.addComponent(chckbxHeartwormTesting, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(dtrpnNotes, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
								.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		desktopPane_1.setLayout(gl_desktopPane_1);
		
		JScrollPane scrollPaneMonday = new JScrollPane();
		
		JScrollPane scrollPaneTues = new JScrollPane();
		
		JScrollPane scrollPaneWed = new JScrollPane();
		
		JScrollPane scrollPaneThurs = new JScrollPane();
		
		JScrollPane scrollPaneFriday = new JScrollPane();
		
		JScrollPane scrollPaneSat = new JScrollPane();
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_desktopPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneMonday, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(scrollPaneTues, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addGap(14)
					.addComponent(scrollPaneWed, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPaneThurs, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPaneFriday, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPaneSat, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addGap(8))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneWed, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
						.addComponent(scrollPaneThurs, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
						.addComponent(scrollPaneFriday, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
						.addComponent(scrollPaneMonday, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
						.addComponent(scrollPaneSat, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
						.addComponent(scrollPaneTues, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
					.addContainerGap())
		);
		desktopPane.setLayout(gl_desktopPane);
		panelAppointments.setLayout(gl_panelAppointments);
		
		JPanel panelRecords = new JPanel();
		tabbedPane.addTab("   Records   ", null, panelRecords, null);
		GroupLayout gl_panelRecords = new GroupLayout(panelRecords);
		gl_panelRecords.setHorizontalGroup(
			gl_panelRecords.createParallelGroup(Alignment.LEADING)
				.addGap(0, 835, Short.MAX_VALUE)
		);
		gl_panelRecords.setVerticalGroup(
			gl_panelRecords.createParallelGroup(Alignment.LEADING)
				.addGap(0, 568, Short.MAX_VALUE)
		);
		panelRecords.setLayout(gl_panelRecords);
		
		JPanel panelSales = new JPanel();
		tabbedPane.addTab("    Sales    ", null, panelSales, null);
		GroupLayout gl_panelSales = new GroupLayout(panelSales);
		gl_panelSales.setHorizontalGroup(
			gl_panelSales.createParallelGroup(Alignment.LEADING)
				.addGap(0, 835, Short.MAX_VALUE)
		);
		gl_panelSales.setVerticalGroup(
			gl_panelSales.createParallelGroup(Alignment.LEADING)
				.addGap(0, 568, Short.MAX_VALUE)
		);
		panelSales.setLayout(gl_panelSales);
		
		JPanel panelBoarding = new JPanel();						  
		tabbedPane.addTab("  Boarding   ", null, panelBoarding, null);
		GroupLayout gl_panelBoarding = new GroupLayout(panelBoarding);
		gl_panelBoarding.setHorizontalGroup(
			gl_panelBoarding.createParallelGroup(Alignment.LEADING)
				.addGap(0, 835, Short.MAX_VALUE)
		);
		gl_panelBoarding.setVerticalGroup(
			gl_panelBoarding.createParallelGroup(Alignment.LEADING)
				.addGap(0, 568, Short.MAX_VALUE)
		);
		panelBoarding.setLayout(gl_panelBoarding);
		contentPane.setLayout(gl_contentPane);
	}
	

	/**
	 * Installs the JGoodies Look & Feels, if available, in classpath.
	 */
	public final void initializeLookAndFeels() {
		// if in classpath thry to load JGoodies Plastic Look & Feel
		try {
			LookAndFeelInfo[] lnfs = UIManager.getInstalledLookAndFeels();
			boolean found = false;
			for (int i = 0; i < lnfs.length; i++) {
				if (lnfs[i].getName().equals("JGoodies Plastic 3D")) {
					found = true;
				}
			}
			if (!found) {
				UIManager.installLookAndFeel("JGoodies Plastic 3D",
						"com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
			}
			String os = System.getProperty("os.name");
			FontSet fontSet = null;
			if (os.startsWith("Windows")) {
				fontSet = FontSets.createDefaultFontSet(new Font(
						"arial unicode MS", Font.PLAIN, 12));
			} else {
				fontSet = FontSets.createDefaultFontSet(new Font(
						"arial unicode", Font.PLAIN, 12));				
			}
			FontPolicy fixedPolicy = FontPolicies.createFixedPolicy(fontSet);
			PlasticLookAndFeel.setFontPolicy(fixedPolicy);

			UIManager
					.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch (Throwable t) {
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
