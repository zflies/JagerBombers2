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
import javax.swing.JSeparator;


public class HomeScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField textField;
	private JTextField txtPetName;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField txtType;
	private JTextField txtSize;

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
		chckbxOfficeVisit.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		chckbxOfficeVisit.setBackground(UIManager.getColor("Desktop.background"));
		
		JCheckBox chckbxMicrochipping = new JCheckBox("Microchipping");
		chckbxMicrochipping.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		chckbxMicrochipping.setBackground(UIManager.getColor("Desktop.background"));

		JCheckBox chckbxHeartwormTesting = new JCheckBox("Heartworm Testing");
		chckbxHeartwormTesting.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		chckbxHeartwormTesting.setBackground(UIManager.getColor("Desktop.background"));

		JCheckBox chckbxSpayNeuter = new JCheckBox("Spay/Neuter");
		chckbxSpayNeuter.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		chckbxSpayNeuter.setBackground(UIManager.getColor("Desktop.background"));

		JCheckBox chckbxLabWork = new JCheckBox("Lab Work");
		chckbxLabWork.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		chckbxLabWork.setBackground(UIManager.getColor("Desktop.background"));

		JCheckBox chckbxDentalCleaning = new JCheckBox("Dental Cleaning");
		chckbxDentalCleaning.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		chckbxDentalCleaning.setBackground(UIManager.getColor("Desktop.background"));

		JCheckBox chckbxXRay = new JCheckBox("X-Ray");
		chckbxXRay.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		chckbxXRay.setBackground(UIManager.getColor("Desktop.background"));
		
		JComboBox cbTime = new JComboBox();
		cbTime.setModel(new DefaultComboBoxModel(new String[] {"Time"}));

		cbTime.setRenderer(dlcr);
		
		GroupLayout gl_desktopPane_1 = new GroupLayout(desktopPane_1);
		gl_desktopPane_1.setHorizontalGroup(
			gl_desktopPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_desktopPane_1.createSequentialGroup()
							.addComponent(dtrpnNotes, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
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
							.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_desktopPane_1.createSequentialGroup()
									.addComponent(cbTime, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addGap(6))))
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
					.addGap(12)
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
							.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_desktopPane_1.createSequentialGroup()
									.addGap(11)
									.addGroup(gl_desktopPane_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPetName)
										.addComponent(txtPetName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(cbPetType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_desktopPane_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cbTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(17)
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
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		
		JDesktopPane desktopPane_3 = new JDesktopPane();
		GroupLayout gl_panelBoarding = new GroupLayout(panelBoarding);
		gl_panelBoarding.setHorizontalGroup(
			gl_panelBoarding.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelBoarding.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktopPane_3, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(desktopPane_2, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelBoarding.setVerticalGroup(
			gl_panelBoarding.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelBoarding.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBoarding.createParallelGroup(Alignment.TRAILING)
						.addComponent(desktopPane_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
						.addComponent(desktopPane_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel lblOwner = new JLabel("Owner");
		lblOwner.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblOwner.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblLastName_1 = new JLabel("First Name:");
		lblLastName_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblLastName_2 = new JLabel("Last Name:");
		lblLastName_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JLabel lblPet = new JLabel("Pet");
		lblPet.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblPet.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JCheckBox chckbxBathinggrooming = new JCheckBox("Bathing/Grooming");
		chckbxBathinggrooming.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
		chckbxBathinggrooming.setBackground(UIManager.getColor("Desktop.background"));
		
		JCheckBox chckbxAdditionalPlayTime = new JCheckBox("Additional Play Time");
		chckbxAdditionalPlayTime.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
		chckbxAdditionalPlayTime.setBackground(UIManager.getColor("Desktop.background"));
		
		JCheckBox chckbxDentalCleaning_1 = new JCheckBox("Dental Cleaning");
		chckbxDentalCleaning_1.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
		chckbxDentalCleaning_1.setBackground(UIManager.getColor("Desktop.background"));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		txtType = new JTextField();
		txtType.setEnabled(false);
		txtType.setEditable(false);
		txtType.setHorizontalAlignment(SwingConstants.CENTER);
		txtType.setText("Type");
		txtType.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblAvailableKenels = new JLabel("Available Kennels:");
		lblAvailableKenels.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Search");
		
		txtSize = new JTextField();
		txtSize.setText("Size");
		txtSize.setHorizontalAlignment(SwingConstants.CENTER);
		txtSize.setEnabled(false);
		txtSize.setEditable(false);
		txtSize.setColumns(10);
		
		JButton btnCreate_1 = new JButton("Create");
		btnCreate_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblScheduling = new JLabel("Scheduling");
		lblScheduling.setHorizontalAlignment(SwingConstants.CENTER);
		lblScheduling.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		JCalendar calendarBoardingFrom = new JCalendar();
		
		JCalendar calendarBoardingTo = new JCalendar();
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblKenel = new JLabel("Options");
		lblKenel.setHorizontalAlignment(SwingConstants.CENTER);
		lblKenel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		JSeparator separator_2 = new JSeparator();

		GroupLayout gl_desktopPane_3 = new GroupLayout(desktopPane_3);
		gl_desktopPane_3.setHorizontalGroup(
			gl_desktopPane_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOwner, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPane_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLastName_1, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
						.addComponent(lblLastName_2, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPane_3.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPane_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPane_3.createSequentialGroup()
							.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 71, Short.MAX_VALUE))
						.addGroup(gl_desktopPane_3.createSequentialGroup()
							.addComponent(txtType, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
							.addGap(95)
							.addComponent(txtSize, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblScheduling, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFrom, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(233))
				.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPet, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(calendarBoardingFrom, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTo, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(233))
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(calendarBoardingTo, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAvailableKenels, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(comboBox, 0, 113, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(separator_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKenel, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxBathinggrooming, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(148))
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxAdditionalPlayTime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(136))
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxDentalCleaning_1, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(113))
				.addGroup(Alignment.TRAILING, gl_desktopPane_3.createSequentialGroup()
					.addGap(207)
					.addComponent(btnCreate_1, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_desktopPane_3.setVerticalGroup(
			gl_desktopPane_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOwner)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPane_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPane_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLastName_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPet)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPane_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPane_3.createParallelGroup(Alignment.LEADING)
						.addComponent(txtSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblScheduling, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFrom, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(calendarBoardingFrom, GroupLayout.PREFERRED_SIZE, 14, Short.MAX_VALUE)
					.addGap(14)
					.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(calendarBoardingTo, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_desktopPane_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAvailableKenels, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblKenel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxBathinggrooming)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxAdditionalPlayTime)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxDentalCleaning_1)
					.addGap(5)
					.addComponent(btnCreate_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		desktopPane_3.setLayout(gl_desktopPane_3);
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
