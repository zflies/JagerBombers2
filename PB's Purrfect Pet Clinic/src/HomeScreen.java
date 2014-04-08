import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

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
import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JBoardingCalendar;
import com.toedter.calendar.JBoardingDateChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.BirthdayEvaluator;
import com.toedter.calendar.demo.BoardingDateEvaluator;
import com.toedter.calendar.demo.TestDateEvaluator;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
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
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class HomeScreen extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtFirstName_Appointments;
	private JTextField txtLastName_Appointments;
	private JTextField txtPetName_Appointments;
	private JTextField txtFirstName_Boarding;
	private JTextField txtPetName_Boarding;
	private JTextField txtLastName_Boarding;
	private JTextField txtPetType_Boarding;
	private JTextField txtPetSize_Boarding;
	private JTextField txtFirstName;
	private JTextField textField;
	private JTextField txtPetName;
	private JTable tableMonday_Appointments;
	private JTable tableTuesday__Appointments;
	private JTable tableWednesday_Appointments;
	private JTable tableThursday_Appointments;
	private JTable tableFriday_Appointments;
	private JTable tableSaturday_Appointments;
	private JTable tableSelected_Appointments;

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
		
		JDesktopPane desktopPaneView_Appointments = new JDesktopPane();
		
		JDesktopPane desktopPaneCreate_Appointments = new JDesktopPane();
		GroupLayout gl_panelAppointments = new GroupLayout(panelAppointments);
		gl_panelAppointments.setHorizontalGroup(
			gl_panelAppointments.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAppointments.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAppointments.createParallelGroup(Alignment.LEADING)
						.addComponent(desktopPaneView_Appointments)
						.addGroup(gl_panelAppointments.createSequentialGroup()
							.addComponent(calendarAppointments, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(desktopPaneCreate_Appointments)))
					.addContainerGap())
		);
		gl_panelAppointments.setVerticalGroup(
			gl_panelAppointments.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAppointments.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAppointments.createParallelGroup(Alignment.LEADING)
						.addComponent(calendarAppointments, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
						.addComponent(desktopPaneCreate_Appointments, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(desktopPaneView_Appointments, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		txtFirstName_Appointments = new JTextField();
		txtFirstName_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtFirstName_Appointments.setColumns(10);
		
		JButton btnCreate_Appointments = new JButton("Create");
		btnCreate_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JScrollPane scrollPaneAppointment = new JScrollPane();
		
		JEditorPane dtrpnNotes_Appointments = new JEditorPane();
		dtrpnNotes_Appointments.setText("Notes");
		
		JLabel lblFirstName_Appointments = new JLabel("First Name:");
		lblFirstName_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblLastName_Appointments = new JLabel("Last Name:");
		lblLastName_Appointments.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		txtLastName_Appointments = new JTextField();
		txtLastName_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtLastName_Appointments.setColumns(10);
		
		txtPetName_Appointments = new JTextField();
		txtPetName_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtPetName_Appointments.setColumns(10);
		
		JLabel lblPetName_Appointments = new JLabel("Pet Name:");
		lblPetName_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JComboBox cbPetType_Appointments = new JComboBox();
		cbPetType_Appointments.setModel(new DefaultComboBoxModel(new String[] {"Feline", "Canine"}));
		
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		cbPetType_Appointments.setRenderer(dlcr);
		
		JCheckBox chckbxOfficeVisit_Appointments = new JCheckBox("Office Visit");
		chckbxOfficeVisit_Appointments.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		chckbxOfficeVisit_Appointments.setBackground(UIManager.getColor("Desktop.background"));
		
		JCheckBox chckbxMicrochipping_Appointments = new JCheckBox("Microchipping");
		chckbxMicrochipping_Appointments.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		chckbxMicrochipping_Appointments.setBackground(UIManager.getColor("Desktop.background"));


		JCheckBox chckbxHeartwormTesting_Appointments = new JCheckBox("Heartworm Testing");
		chckbxHeartwormTesting_Appointments.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		chckbxHeartwormTesting_Appointments.setBackground(UIManager.getColor("Desktop.background"));


		JCheckBox chckbxSpayNeuter_Appointments = new JCheckBox("Spay/Neuter");
		chckbxSpayNeuter_Appointments.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		chckbxSpayNeuter_Appointments.setBackground(UIManager.getColor("Desktop.background"));

		JCheckBox chckbxLabWork_Appointments = new JCheckBox("Lab Work");
		chckbxLabWork_Appointments.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		chckbxLabWork_Appointments.setBackground(UIManager.getColor("Desktop.background"));


		JCheckBox chckbxDentalCleaning_Appointments = new JCheckBox("Dental Cleaning");
		chckbxDentalCleaning_Appointments.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		chckbxDentalCleaning_Appointments.setBackground(UIManager.getColor("Desktop.background"));


		JCheckBox chckbxXRay_Appointments = new JCheckBox("X-Ray");
		chckbxXRay_Appointments.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		chckbxXRay_Appointments.setBackground(UIManager.getColor("Desktop.background"));
		
		JComboBox cbTime_Appointments = new JComboBox();
		cbTime_Appointments.setModel(new DefaultComboBoxModel(new String[] {"Time"}));
		cbTime_Appointments.setRenderer(dlcr);

		
		GroupLayout gl_desktopPaneCreate_Appointments = new GroupLayout(desktopPaneCreate_Appointments);
		gl_desktopPaneCreate_Appointments.setHorizontalGroup(
			gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
							.addComponent(dtrpnNotes_Appointments, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCreate_Appointments, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
							.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPetName_Appointments, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFirstName_Appointments))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING)
								.addComponent(txtFirstName_Appointments, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPetName_Appointments, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
									.addGap(12)
									.addComponent(cbPetType_Appointments, 0, 93, Short.MAX_VALUE)
									.addGap(8))
								.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblLastName_Appointments, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtLastName_Appointments, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
									.addComponent(cbTime_Appointments, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addGap(6))))
						.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
							.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(chckbxMicrochipping_Appointments, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chckbxOfficeVisit_Appointments, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chckbxHeartwormTesting_Appointments, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

							.addGap(18)
							.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
									.addComponent(chckbxLabWork_Appointments, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(chckbxXRay_Appointments, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
									.addComponent(chckbxSpayNeuter_Appointments, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(chckbxDentalCleaning_Appointments, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))))
					.addGap(12)

					.addComponent(scrollPaneAppointment, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_desktopPaneCreate_Appointments.setVerticalGroup(
			gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPaneAppointment, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
							.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.BASELINE, false)
									.addComponent(lblFirstName_Appointments)
									.addComponent(txtFirstName_Appointments, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtLastName_Appointments, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblLastName_Appointments)))
							.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
									.addGap(11)
									.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPetName_Appointments)
										.addComponent(txtPetName_Appointments, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(cbPetType_Appointments, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cbTime_Appointments, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(17)
							.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxOfficeVisit_Appointments)
								.addComponent(chckbxDentalCleaning_Appointments)
								.addComponent(chckbxSpayNeuter_Appointments))

							.addGap(1)
							.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxMicrochipping_Appointments)
								.addComponent(chckbxXRay_Appointments)
								.addComponent(chckbxLabWork_Appointments))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
									.addComponent(chckbxHeartwormTesting_Appointments, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(dtrpnNotes_Appointments, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
								.addComponent(btnCreate_Appointments, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		
		tableSelected_Appointments = new JTable();
		scrollPaneAppointment.setViewportView(tableSelected_Appointments);
		desktopPaneCreate_Appointments.setLayout(gl_desktopPaneCreate_Appointments);
		
		JScrollPane scrollPaneMonday_Appointments = new JScrollPane();
		
		JScrollPane scrollPaneTues_Appointments = new JScrollPane();
		
		JScrollPane scrollPaneWed_Appointments = new JScrollPane();
		
		JScrollPane scrollPaneThurs_Appointments = new JScrollPane();
		
		JScrollPane scrollPaneFriday_Appointments = new JScrollPane();
		
		JScrollPane scrollPaneSat_Appointments = new JScrollPane();
		GroupLayout gl_desktopPaneView_Appointments = new GroupLayout(desktopPaneView_Appointments);
		gl_desktopPaneView_Appointments.setHorizontalGroup(
			gl_desktopPaneView_Appointments.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_desktopPaneView_Appointments.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneMonday_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(scrollPaneTues_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addGap(14)
					.addComponent(scrollPaneWed_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPaneThurs_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPaneFriday_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPaneSat_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addGap(8))
		);
		gl_desktopPaneView_Appointments.setVerticalGroup(
			gl_desktopPaneView_Appointments.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneView_Appointments.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPaneView_Appointments.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneWed_Appointments, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
						.addComponent(scrollPaneThurs_Appointments, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
						.addComponent(scrollPaneFriday_Appointments, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
						.addComponent(scrollPaneMonday_Appointments, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
						.addComponent(scrollPaneSat_Appointments, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
						.addComponent(scrollPaneTues_Appointments, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		tableSaturday_Appointments = new JTable();
		scrollPaneSat_Appointments.setViewportView(tableSaturday_Appointments);
		
		tableFriday_Appointments = new JTable();
		scrollPaneFriday_Appointments.setViewportView(tableFriday_Appointments);
		
		tableThursday_Appointments = new JTable();
		scrollPaneThurs_Appointments.setViewportView(tableThursday_Appointments);
		
		tableWednesday_Appointments = new JTable();
		scrollPaneWed_Appointments.setViewportView(tableWednesday_Appointments);
		
		tableTuesday__Appointments = new JTable();
		scrollPaneTues_Appointments.setViewportView(tableTuesday__Appointments);
		
		tableMonday_Appointments = new JTable();
		scrollPaneMonday_Appointments.setViewportView(tableMonday_Appointments);
		desktopPaneView_Appointments.setLayout(gl_desktopPaneView_Appointments);
		panelAppointments.setLayout(gl_panelAppointments);
		
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
		
		JDesktopPane desktopPaneCreate_Boarding = new JDesktopPane();
		
		
		JComponent dateChooser = new JBoardingDateChooser();
		((JBoardingDateChooser) dateChooser).getJCalendar().getDayChooser()
				.addDateEvaluator(new BoardingDateEvaluator());
		
		Calendar calendar = Calendar.getInstance();
		Date date = ((JBoardingDateChooser)dateChooser).getDateEditor().getDate();
		if (date != null) {
			calendar.setTime(date);
		}
		((JBoardingDateChooser)dateChooser).getJCalendar().setCalendar(calendar);
		
		JComponent calendarViewBoarding = ((JBoardingDateChooser) dateChooser).getJCalendar();

/*-------------------------------------------------------------------------------------------------------------------------------------------		
---------------------------------------------------------------------------------------------------------------------------------------------		
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------		
Remove the two comments below for .addComponent(calendarViewBoarding... when running the code. To Work with HomeScreen in WindowBuilder view,
comment them out.  Failure to do so will cause errors.
---------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------		
---------------------------------------------------------------------------------------------------------------------------------------------		
---------------------------------------------------------------------------------------------------------------------------------------------*/		
		
		GroupLayout gl_panelBoarding = new GroupLayout(panelBoarding);
		gl_panelBoarding.setHorizontalGroup(
			gl_panelBoarding.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBoarding.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktopPaneCreate_Boarding, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
//					.addComponent(calendarViewBoarding, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(8))
		);
		gl_panelBoarding.setVerticalGroup(
			gl_panelBoarding.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelBoarding.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBoarding.createParallelGroup(Alignment.TRAILING)
//						.addComponent(calendarViewBoarding, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
						.addComponent(desktopPaneCreate_Boarding, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel lblOwner_Boarding = new JLabel("Owner");
		lblOwner_Boarding.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblOwner_Boarding.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblFirstName_Boarding = new JLabel("First Name:");
		lblFirstName_Boarding.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		txtFirstName_Boarding = new JTextField();
		txtFirstName_Boarding.setColumns(10);
		
		JLabel lblLastName_Boarding = new JLabel("Last Name:");
		lblLastName_Boarding.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JLabel lblPet_Boarding = new JLabel("Pet");
		lblPet_Boarding.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblPet_Boarding.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtPetName_Boarding = new JTextField();
		txtPetName_Boarding.setColumns(10);
		
		JCheckBox chckbxBathinggrooming_Boarding = new JCheckBox("Bathing/Grooming");
		chckbxBathinggrooming_Boarding.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
		chckbxBathinggrooming_Boarding.setBackground(UIManager.getColor("Desktop.background"));
		
		JCheckBox chckbxAdditionalPlayTime_Boarding = new JCheckBox("Additional Play Time");
		chckbxAdditionalPlayTime_Boarding.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
		chckbxAdditionalPlayTime_Boarding.setBackground(UIManager.getColor("Desktop.background"));
		
		JCheckBox chckbxDentalCleaning_Boarding = new JCheckBox("Dental Cleaning");
		chckbxDentalCleaning_Boarding.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
		chckbxDentalCleaning_Boarding.setBackground(UIManager.getColor("Desktop.background"));
		
		txtLastName_Boarding = new JTextField();
		txtLastName_Boarding.setColumns(10);
		
		txtPetType_Boarding = new JTextField();
		txtPetType_Boarding.setEnabled(false);
		txtPetType_Boarding.setEditable(false);
		txtPetType_Boarding.setHorizontalAlignment(SwingConstants.CENTER);
		txtPetType_Boarding.setText("Type");
		txtPetType_Boarding.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblAvailableKenels_Boarding = new JLabel("Available Kennels:");
		lblAvailableKenels_Boarding.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JLabel lblPetName_Boarding = new JLabel("Name:");
		lblPetName_Boarding.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JButton btnPetSearch_Boarding = new JButton("Search");
		
		txtPetSize_Boarding = new JTextField();
		txtPetSize_Boarding.setText("Size");
		txtPetSize_Boarding.setHorizontalAlignment(SwingConstants.CENTER);
		txtPetSize_Boarding.setEnabled(false);
		txtPetSize_Boarding.setEditable(false);
		txtPetSize_Boarding.setColumns(10);
		
		JButton btnCreate_Boarding = new JButton("Create");
		btnCreate_Boarding.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblScheduling_Boarding = new JLabel("Scheduling");
		lblScheduling_Boarding.setHorizontalAlignment(SwingConstants.CENTER);
		lblScheduling_Boarding.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		JLabel lblFrom_Boarding = new JLabel("From:");
		lblFrom_Boarding.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JLabel lblTo_Boarding = new JLabel("To:");
		lblTo_Boarding.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JComboBox cbKennels_Boarding = new JComboBox();
		
		JLabel lblKenel_Boarding = new JLabel("Options");
		lblKenel_Boarding.setHorizontalAlignment(SwingConstants.CENTER);
		lblKenel_Boarding.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		JSeparator separator_2 = new JSeparator();
		
		JComponent dateChooserFrom_Boarding = new JBoardingDateChooser();
		
		((JBoardingDateChooser) dateChooserFrom_Boarding).getJCalendar().getDayChooser()
				.addDateEvaluator(new BoardingDateEvaluator());
		((JBoardingDateChooser) dateChooserFrom_Boarding).getJCalendar().getDayChooser()
				.addDateEvaluator(new BirthdayEvaluator());
		((JBoardingDateChooser) dateChooserFrom_Boarding).getJCalendar().getDayChooser()
				.addDateEvaluator(new TestDateEvaluator());
		
		JComponent dateChooserTo_Boarding = new JBoardingDateChooser();

		GroupLayout gl_desktopPaneCreate_Boarding = new GroupLayout(desktopPaneCreate_Boarding);
		gl_desktopPaneCreate_Boarding.setHorizontalGroup(
			gl_desktopPaneCreate_Boarding.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOwner_Boarding, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPaneCreate_Boarding.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFirstName_Boarding, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
						.addComponent(lblLastName_Boarding, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPaneCreate_Boarding.createParallelGroup(Alignment.LEADING)
						.addComponent(txtFirstName_Boarding, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(txtLastName_Boarding, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPaneCreate_Boarding.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
							.addComponent(lblPetName_Boarding, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPetName_Boarding, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPetSearch_Boarding, GroupLayout.PREFERRED_SIZE, 71, Short.MAX_VALUE))
						.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
							.addComponent(txtPetType_Boarding, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
							.addGap(95)
							.addComponent(txtPetSize_Boarding, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblScheduling_Boarding, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPet_Boarding, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFrom_Boarding, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(233))
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addContainerGap()
					.addComponent(dateChooserFrom_Boarding, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTo_Boarding, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(233))
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKenel_Boarding, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxBathinggrooming_Boarding, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(148))
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxAdditionalPlayTime_Boarding, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(136))
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxDentalCleaning_Boarding, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(113))
				.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPaneCreate_Boarding.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
							.addComponent(lblAvailableKenels_Boarding, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
							.addGap(27)
							.addComponent(cbKennels_Boarding, 0, 106, Short.MAX_VALUE))
						.addComponent(dateChooserTo_Boarding, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addGap(207)
					.addComponent(btnCreate_Boarding, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_desktopPaneCreate_Boarding.setVerticalGroup(
			gl_desktopPaneCreate_Boarding.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOwner_Boarding)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPaneCreate_Boarding.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName_Boarding)
						.addComponent(txtFirstName_Boarding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPaneCreate_Boarding.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtLastName_Boarding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLastName_Boarding))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPet_Boarding)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPaneCreate_Boarding.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPetName_Boarding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPetSearch_Boarding)
						.addComponent(lblPetName_Boarding, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPaneCreate_Boarding.createParallelGroup(Alignment.LEADING)
						.addComponent(txtPetSize_Boarding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPetType_Boarding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblScheduling_Boarding, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFrom_Boarding, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dateChooserFrom_Boarding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTo_Boarding, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dateChooserTo_Boarding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addGroup(gl_desktopPaneCreate_Boarding.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAvailableKenels_Boarding, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbKennels_Boarding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblKenel_Boarding)
					.addGroup(gl_desktopPaneCreate_Boarding.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxBathinggrooming_Boarding)
							.addGap(3)
							.addComponent(chckbxAdditionalPlayTime_Boarding)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxDentalCleaning_Boarding)
							.addContainerGap(39, Short.MAX_VALUE))
						.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCreate_Boarding, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		desktopPaneCreate_Boarding.setLayout(gl_desktopPaneCreate_Boarding);

		panelBoarding.setLayout(gl_panelBoarding);
		
		JPanel panelRecords = new JPanel();
		tabbedPane.addTab("   Records   ", null, panelRecords, null);
		
		JButton btnNewOwner = new JButton("New Owner");
		btnNewOwner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnAddPet = new JButton("Add Pet");
		btnAddPet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_panelRecords = new GroupLayout(panelRecords);
		gl_panelRecords.setHorizontalGroup(
			gl_panelRecords.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRecords.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelRecords.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewOwner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelRecords.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelRecords.createSequentialGroup()
							.addGap(305)
							.addGroup(gl_panelRecords.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)))
						.addGroup(gl_panelRecords.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddPet, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelRecords.setVerticalGroup(
			gl_panelRecords.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRecords.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelRecords.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelRecords.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
					.addGap(42)
					.addGroup(gl_panelRecords.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewOwner)
						.addComponent(btnAddPet))
					.addContainerGap())
		);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JTree tree = new JTree();
		panel_2.add(tree, BorderLayout.CENTER);
		
		JLabel lblPet = new JLabel("Pet:");
		lblPet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("10/25/01");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblLbs = new JLabel("100 lbs");
		lblLbs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblBlack = new JLabel("Black");
		lblBlack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblLarge = new JLabel("Large");
		lblLarge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblMale = new JLabel("Male");
		lblMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDog = new JLabel("Dog");
		lblDog.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblFluffy = new JLabel("Fluffy");
		lblFluffy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnEditPetRecords = new JButton("Edit");
		btnEditPetRecords.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDateOfBirth)
						.addComponent(lblWeight)
						.addComponent(lblColor)
						.addComponent(lblSize)
						.addComponent(lblSex)
						.addComponent(lblType)
						.addComponent(lblPet))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFluffy)
						.addComponent(lblDog)
						.addComponent(lblMale)
						.addComponent(lblLarge)
						.addComponent(lblBlack)
						.addComponent(lblLbs)
						.addComponent(label_2))
					.addContainerGap(307, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(382, Short.MAX_VALUE)
					.addComponent(btnEditPetRecords, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPet)
						.addComponent(lblFluffy))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType)
						.addComponent(lblDog))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSex)
						.addComponent(lblMale))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSize)
						.addComponent(lblLarge))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblColor)
						.addComponent(lblBlack))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateOfBirth)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWeight)
						.addComponent(lblLbs))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(btnEditPetRecords, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblOwner = new JLabel("Owner:");
		lblOwner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblState = new JLabel("State:");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblZip = new JLabel("ZIP:");
		lblZip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSomewhereStreet = new JLabel("12489 Somewhere Street");
		lblSomewhereStreet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblLawrence = new JLabel("Lawrence");
		lblLawrence.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblKansas = new JLabel("Kansas");
		lblKansas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("66047");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label = new JLabel("(913)468-0754");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblJaneDoe = new JLabel("Jane Doe");
		lblJaneDoe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnEditOwnerRecords = new JButton("Edit");
		btnEditOwnerRecords.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblOwner)
							.addGap(18)
							.addComponent(lblJaneDoe))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAddress)
								.addComponent(lblCity)
								.addComponent(lblState)
								.addComponent(lblZip)
								.addComponent(lblPhone))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1)
								.addComponent(lblKansas)
								.addComponent(lblLawrence)
								.addComponent(lblSomewhereStreet))))
					.addContainerGap(233, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(382, Short.MAX_VALUE)
					.addComponent(btnEditOwnerRecords, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOwner)
						.addComponent(lblJaneDoe))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhone)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(lblSomewhereStreet))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCity)
						.addComponent(lblLawrence))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblState)
						.addComponent(lblKansas))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZip)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addComponent(btnEditOwnerRecords)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		panelRecords.setLayout(gl_panelRecords);
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
