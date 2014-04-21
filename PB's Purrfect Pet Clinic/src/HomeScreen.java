import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

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
import com.toedter.calendar.JAppointmentCalendar;
import com.toedter.calendar.JBoardingDateChooser;
import com.toedter.calendar.JDateChooser;
//import com.toedter.calendar.demo.BirthdayEvaluator;
//import com.toedter.calendar.demo.BoardingDateEvaluator;
//import com.toedter.calendar.demo.TestDateEvaluator;




import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.SystemColor;

import javax.swing.ListSelectionModel;


public class HomeScreen extends JFrame implements WindowFocusListener {

	private JPanel contentPane;

	// Appointments UI
	private JTextField txtFirstName_Appointments;
	private JTextField txtLastName_Appointments;
	private JTextField txtPetName_Appointments;
	private JEditorPane dtrpnNotes_Appointments;
	private JTable tableMonday_Appointments;
	private JTable tableTuesday_Appointments;
	private JTable tableWednesday_Appointments;
	private JTable tableThursday_Appointments;
	private JTable tableFriday_Appointments;
	private JTable tableSaturday_Appointments;
	private JRadioButton rbOfficeVisit_Appointments;
	private JRadioButton rbMicrochipping_Appointments;
	private JRadioButton rbHeartwormTesting_Appointments;
	private JRadioButton rbSpayNeuter_Appointments;
	private JRadioButton rbLabWork_Appointments;
	private JRadioButton rbDentalCleaning_Appointments;
	private JRadioButton rbXRay_Appointments;
	private JComboBox cbTime_Appointments;
	private final JAppointmentCalendar calendarAppointments;
	private JLabel lblPetOwnerView_Appointment;
	private JLabel lblPetOwnerPhoneView_Appointment;
	private JLabel lblPetSexView_Appointment;
	private JLabel lblPetBreedView_Appointment;
	private JLabel lblPetDOBView_Appointment;
	private JLabel lblPetWeightView_Appointment;
	private JLabel lblPetColorView_Appointment;
	private JLabel lblPetSizeView_Appointment;
	private JLabel lblPetTypeView_Appointment;
	private JLabel lblPetNameView_Appointment;
	private JButton btnDeleteApptView_Appointment;
	private JLabel lblDateView_Appointment;
	private JLabel lblTimeView_Appointment;
	private JLabel lblServiceView_Appointment;
	private JLabel lblRoomView_Appointment;
	private JEditorPane editorPaneNotesView_Appointment;

	
	// Appointments Variables
	private static Vector<String> AppointmentTimes = new Vector<String>();
	private static Vector<Vector<Appointment>> WeekAppointments = new Vector<Vector<Appointment>>();
	private static Vector<String> AppointmentTimesAvailable = new Vector<String>();
	private static Vector<Appointment> Monday_Appointments = new Vector<Appointment>(); 
	private static Vector<Appointment> Tuesday_Appointments = new Vector<Appointment>(); 
	private static Vector<Appointment> Wednesday_Appointments = new Vector<Appointment>(); 
	private static Vector<Appointment> Thursday_Appointments = new Vector<Appointment>(); 
	private static Vector<Appointment> Friday_Appointments = new Vector<Appointment>(); 
	private static Vector<Appointment> Saturday_Appointments = new Vector<Appointment>(); 
	private static Vector<Vector<String>> Monday_Appointments_TableData = new Vector<Vector<String>>();
	private static Vector<Vector<String>> Tuesday_Appointments_TableData = new Vector<Vector<String>>();
	private static Vector<Vector<String>> Wednesday_Appointments_TableData = new Vector<Vector<String>>();
	private static Vector<Vector<String>> Thursday_Appointments_TableData = new Vector<Vector<String>>();
	private static Vector<Vector<String>> Friday_Appointments_TableData = new Vector<Vector<String>>();
	private static Vector<Vector<String>> Saturday_Appointments_TableData = new Vector<Vector<String>>();
	private static Vector<String> ColumnLabels_Appointments = new Vector<String>();
	private static TableColumnModel ColumnModel_Appointments;
	private static TableColumn Column_Appointments;
	private static ButtonGroup groupAppointmentServices;
	private static DefaultListCellRenderer ListCellAlignCenter;
	private static DefaultTableCellRenderer TableCellAlignCenter;



	// Boarding UI
	private JTextField txtFirstName_Boarding;
	private JTextField txtPetName_Boarding;
	private JTextField txtLastName_Boarding;
	private JTextField txtPetType_Boarding;
	private JTextField txtPetSize_Boarding;


	private JTextField txtFirstName;
	private JTextField textField;
	private JTextField txtPetName;

	//Owner labels for records tab
	private JLabel lblAddress_Records;
	private JLabel lblCity_Records;
	private JLabel lblState_Records;
	private JLabel lblZip_Records;
	private JLabel lblPhone_Records;
	private JLabel lblOwner_Records;

	//Pet labels for records tab
	private JLabel lblDateOfBirth_Records;
	private JLabel lblWeight_Records;
	private JLabel lblColor_Records;
	private JLabel lblSize_Records;
	private JLabel lblSex_Records;
	private JLabel lblType_Records;
	private JLabel lblPetName_Records;
	private JLabel lblPetBreed_Records;
	private JLabel lblRabiesDate_Records;
	private JLabel lblDistemperDate_Records;
	private JLabel lblBordatellaDate_Records;
	
	private JTree OwnerTree;

	private JTable servicesTable;
	private JTextField textFieldDaysBoarded_Sales;
	
	//Variables for sales tab
	String sales_column_names[]= {"Item","Price"};
	private DecimalFormat df = new DecimalFormat("0.00");
	private JLabel lblTotal;

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

	public JTree populateTree(){
		//get owner and pet info from DB and populate tree
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Owners");

		try {
			Vector<Owner> Owners = Owner.getAllOwners();
			//for each owner, add them to the tree
			for(int i = 0; i < Owners.size(); i++){
				Owner curOwner = Owners.elementAt(i);
				DefaultMutableTreeNode owner = new DefaultMutableTreeNode(curOwner);
				//for each pet in the current owner add them as a node under their owner
				for(int j = 0; j < curOwner.Pets.size(); j++){
					owner.add(new DefaultMutableTreeNode(curOwner.Pets.elementAt(j)));
				}
				root.add(owner);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Populating Tree.");
		}
		//create new tree from root
		return new JTree(root);
	}

	public void UpdateRecordLabels(Owner selectedOwner, Pet selectedPet){
		//update labels for owner
		lblOwner_Records.setText(selectedOwner.getFullName());
		lblAddress_Records.setText(selectedOwner.getAddress());
		lblCity_Records.setText(selectedOwner.getCity());
		lblState_Records.setText(selectedOwner.getState());
		lblZip_Records.setText(selectedOwner.getZip());
		lblPhone_Records.setText(selectedOwner.getPhone());
		//update labels for pet
		SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
		lblDateOfBirth_Records.setText(formatter.format(selectedPet.getDOB()));
		lblWeight_Records.setText(selectedPet.getWeight().toString() + " lbs.");
		lblColor_Records.setText(selectedPet.getColor());
		lblSize_Records.setText(selectedPet.getPetSizeString());
		lblSex_Records.setText(selectedPet.getPetSexString());
		lblType_Records.setText(selectedPet.getTypeString());
		lblPetName_Records.setText(selectedPet.getName());
		lblPetBreed_Records.setText(selectedPet.getBreed());
		//update immunization labels
		//Rabies Label
		if(selectedPet.getImmunizationStartDate(Immunization.ImmunizationType.Rabies) == null){
			this.lblRabiesDate_Records.setText("No Record");
			this.lblRabiesDate_Records.setForeground(Color.red);
		}
		else{
			Immunization.ImmunizationType ImmuneType = Immunization.ImmunizationType.Rabies;
			Date startDate = selectedPet.getImmunizationStartDate(ImmuneType);
			Date endDate = selectedPet.getImmunizationEndDate(ImmuneType);
			Date today = new Date();
			
			this.lblRabiesDate_Records.setText(formatter.format(startDate));
			if(today.after(endDate))
				this.lblRabiesDate_Records.setForeground(Color.red);
			else
				this.lblRabiesDate_Records.setForeground(Color.green);
		}
		//Distemper Label
		if(selectedPet.getImmunizationStartDate(Immunization.ImmunizationType.Distemper) == null){
			this.lblDistemperDate_Records.setText("No Record");
			this.lblDistemperDate_Records.setForeground(Color.red);
		}
		else{
			Immunization.ImmunizationType ImmuneType = Immunization.ImmunizationType.Distemper;
			Date startDate = selectedPet.getImmunizationStartDate(ImmuneType);
			Date endDate = selectedPet.getImmunizationEndDate(ImmuneType);
			Date today = new Date();
			
			this.lblDistemperDate_Records.setText(formatter.format(startDate));
			if(today.after(endDate))
				this.lblDistemperDate_Records.setForeground(Color.red);
			else
				this.lblDistemperDate_Records.setForeground(Color.green);
		}
		//Bordatella Label
		if(selectedPet.getImmunizationStartDate(Immunization.ImmunizationType.Bordatella) == null){
			this.lblBordatellaDate_Records.setText("No Record");
			this.lblBordatellaDate_Records.setForeground(Color.red);
		}
		else{
			Immunization.ImmunizationType ImmuneType = Immunization.ImmunizationType.Bordatella;
			Date startDate = selectedPet.getImmunizationStartDate(ImmuneType);
			Date endDate = selectedPet.getImmunizationEndDate(ImmuneType);
			Date today = new Date();
			
			this.lblBordatellaDate_Records.setText(formatter.format(startDate));
			if(today.after(endDate))
				this.lblBordatellaDate_Records.setForeground(Color.red);
			else
				this.lblBordatellaDate_Records.setForeground(Color.green);
		}
		
	}

	public void UpdateRecordLabels(Owner selectedOwner){
		//update labels for owner
		lblOwner_Records.setText(selectedOwner.getFullName());
		lblAddress_Records.setText(selectedOwner.getAddress());
		lblCity_Records.setText(selectedOwner.getCity());
		lblState_Records.setText(selectedOwner.getState());
		lblZip_Records.setText(selectedOwner.getZip());
		lblPhone_Records.setText(selectedOwner.getPhone());
		//update labels for pet
		lblDateOfBirth_Records.setText("");
		lblWeight_Records.setText("");
		lblColor_Records.setText("");
		lblSize_Records.setText("");
		lblSex_Records.setText("");
		lblType_Records.setText("");
		lblPetName_Records.setText("");
		lblPetBreed_Records.setText("");
		//update labels for pet immunizations
		lblRabiesDate_Records.setText("");
		lblDistemperDate_Records.setText("");
		lblBordatellaDate_Records.setText("");
	}

	public void ClearRecordLabels(){
		//update labels for owner
		lblOwner_Records.setText("");
		lblAddress_Records.setText("");
		lblCity_Records.setText("");
		lblState_Records.setText("");
		lblZip_Records.setText("");
		lblPhone_Records.setText("");
		//update labels for pet
		lblDateOfBirth_Records.setText("");
		lblWeight_Records.setText("");
		lblColor_Records.setText("");
		lblSize_Records.setText("");
		lblSex_Records.setText("");
		lblType_Records.setText("");
		lblPetName_Records.setText("");
		lblPetBreed_Records.setText("");

		//update labels for pet immunizations
		lblRabiesDate_Records.setText("");
		lblDistemperDate_Records.setText("");
		lblBordatellaDate_Records.setText("");
		
	}

	/**
	 * Create the frame.
	 */
	public HomeScreen() {

		initializeLookAndFeels(); 

		calendarAppointments = new JAppointmentCalendar();

		//loadAppointments();

		setTitle("PB's Purrfect Pet Clinic");
		
		ListCellAlignCenter = new DefaultListCellRenderer();
		ListCellAlignCenter.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
	
		TableCellAlignCenter = new DefaultTableCellRenderer();
		TableCellAlignCenter.setHorizontalAlignment( JLabel.CENTER );

		ColumnLabels_Appointments.clear();
		ColumnLabels_Appointments.add("PET");
		ColumnLabels_Appointments.add("TIME");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 989, 649);
		//setBounds(100, 100, 1585, 649); //< Bounds for complete Window Builder UI edit

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

		final JPanel panelAppointments = new JPanel();
		tabbedPane.addTab("Appointments", null, panelAppointments, null);



		JDesktopPane desktopPaneView_Appointments = new JDesktopPane();

		JDesktopPane desktopPaneCreate_Appointments = new JDesktopPane();

		JButton btnRefreshAppointments = new JButton("Refresh Appointments");
		btnRefreshAppointments.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					refreshAppointments();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JDesktopPane desktopPaneView_Appointment = new JDesktopPane();
		desktopPaneView_Appointment.setBackground(Color.LIGHT_GRAY);


		GroupLayout gl_panelAppointments = new GroupLayout(panelAppointments);
		gl_panelAppointments.setHorizontalGroup(
			gl_panelAppointments.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelAppointments.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAppointments.createParallelGroup(Alignment.LEADING)
						.addComponent(desktopPaneView_Appointments, GroupLayout.DEFAULT_SIZE, 1384, Short.MAX_VALUE)
						.addGroup(gl_panelAppointments.createSequentialGroup()
							.addGroup(gl_panelAppointments.createParallelGroup(Alignment.LEADING)
								.addComponent(calendarAppointments, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelAppointments.createSequentialGroup()
									.addGap(85)
									.addComponent(btnRefreshAppointments, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(desktopPaneCreate_Appointments, GroupLayout.PREFERRED_SIZE, 546, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(desktopPaneView_Appointment, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelAppointments.setVerticalGroup(
			gl_panelAppointments.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAppointments.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAppointments.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAppointments.createSequentialGroup()
							.addComponent(calendarAppointments, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnRefreshAppointments, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(desktopPaneView_Appointment, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(desktopPaneCreate_Appointments, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(desktopPaneView_Appointments, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JDesktopPane desktopPaneView_AppointmentDetails = new JDesktopPane();
		desktopPaneView_AppointmentDetails.setBackground(UIManager.getColor("CheckBox.background"));
		
		lblPetOwnerView_Appointment = new JLabel("Owner:");
		lblPetOwnerView_Appointment.setFont(new Font("Dialog", Font.BOLD, 15));
		
		lblPetOwnerPhoneView_Appointment = new JLabel("Phone:");
		lblPetOwnerPhoneView_Appointment.setFont(new Font("Dialog", Font.BOLD, 15));
		
		lblPetSexView_Appointment = new JLabel("Sex:");
		
		lblPetBreedView_Appointment = new JLabel("Breed:");
		
		lblPetDOBView_Appointment = new JLabel("DOB:");
		
		lblPetWeightView_Appointment = new JLabel("Weight:");
		
		lblPetColorView_Appointment = new JLabel("Color:");
		
		lblPetSizeView_Appointment = new JLabel("Size:");
		
		lblPetTypeView_Appointment = new JLabel("Type:");
		
		lblPetNameView_Appointment = new JLabel("Pet:");
		lblPetNameView_Appointment.setFont(new Font("Dialog", Font.BOLD, 16));
		
		GroupLayout gl_desktopPaneView_Appointment = new GroupLayout(desktopPaneView_Appointment);
		gl_desktopPaneView_Appointment.setHorizontalGroup(
			gl_desktopPaneView_Appointment.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneView_Appointment.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPaneView_Appointment.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPetSexView_Appointment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPetTypeView_Appointment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPetNameView_Appointment, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
						.addComponent(lblPetWeightView_Appointment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPetColorView_Appointment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPetSizeView_Appointment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPetDOBView_Appointment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPetBreedView_Appointment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(gl_desktopPaneView_Appointment.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPaneView_Appointment.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_desktopPaneView_Appointment.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPetOwnerView_Appointment, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
								.addComponent(lblPetOwnerPhoneView_Appointment, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)))
						.addGroup(gl_desktopPaneView_Appointment.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(desktopPaneView_AppointmentDetails, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_desktopPaneView_Appointment.setVerticalGroup(
			gl_desktopPaneView_Appointment.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneView_Appointment.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPaneView_Appointment.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPetNameView_Appointment, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPetOwnerView_Appointment, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPaneView_Appointment.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPetTypeView_Appointment)
						.addComponent(lblPetOwnerPhoneView_Appointment, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_desktopPaneView_Appointment.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPaneView_Appointment.createSequentialGroup()
							.addGap(12)
							.addComponent(lblPetSexView_Appointment)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPetSizeView_Appointment)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPetColorView_Appointment)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPetWeightView_Appointment)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPetDOBView_Appointment)
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
							.addComponent(lblPetBreedView_Appointment))
						.addGroup(gl_desktopPaneView_Appointment.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(desktopPaneView_AppointmentDetails, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		btnDeleteApptView_Appointment = new JButton("Delete Appt.");
		btnDeleteApptView_Appointment.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnDeleteApptView_Appointment.setEnabled(false);
		btnDeleteApptView_Appointment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				// TODO: Show dialog for comfirmation
				Appointment appointment = null;
				
				int row = tableSaturday_Appointments.getSelectedRow();
				if (row != -1 )
				{
					appointment = Saturday_Appointments.get(row);
				}
				else
				{
					row = tableFriday_Appointments.getSelectedRow();
					if (row != -1 )
					{
						appointment = Friday_Appointments.get(row);
					}
					else
					{
						row = tableThursday_Appointments.getSelectedRow();
						if (row != -1 )
						{
							appointment = Thursday_Appointments.get(row);
						}
						else
						{
							row = tableWednesday_Appointments.getSelectedRow();
							if (row != -1 )
							{
								appointment = Wednesday_Appointments.get(row);
							}
							else
							{
								row = tableTuesday_Appointments.getSelectedRow();
								if (row != -1 )
								{
									appointment = Tuesday_Appointments.get(row);
								}
								else
								{
									row = tableMonday_Appointments.getSelectedRow();
									if (row != -1 )
									{
										appointment = Monday_Appointments.get(row);
									}
								}
							}
						}
					}
				}

				appointment.deleteAppointment();
				btnDeleteApptView_Appointment.setEnabled(false);
			
				try {
					refreshAppointments();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		lblDateView_Appointment = new JLabel("DATE:");
		lblTimeView_Appointment = new JLabel("TIME:");
		lblServiceView_Appointment = new JLabel("SERVICE:");
		lblRoomView_Appointment = new JLabel("ROOM:");
		
		editorPaneNotesView_Appointment = new JEditorPane();
		editorPaneNotesView_Appointment.setText("NOTES:");
		editorPaneNotesView_Appointment.setBackground(UIManager.getColor("CheckBox.background"));
		editorPaneNotesView_Appointment.setEditable(false);
		
		GroupLayout gl_desktopPaneView_AppointmentDetails = new GroupLayout(desktopPaneView_AppointmentDetails);
		gl_desktopPaneView_AppointmentDetails.setHorizontalGroup(
			gl_desktopPaneView_AppointmentDetails.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_desktopPaneView_AppointmentDetails.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPaneView_AppointmentDetails.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_desktopPaneView_AppointmentDetails.createSequentialGroup()
							.addComponent(editorPaneNotesView_Appointment, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeleteApptView_Appointment, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_desktopPaneView_AppointmentDetails.createSequentialGroup()
							.addGroup(gl_desktopPaneView_AppointmentDetails.createParallelGroup(Alignment.LEADING)
								.addComponent(lblServiceView_Appointment, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(lblDateView_Appointment, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_desktopPaneView_AppointmentDetails.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblRoomView_Appointment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTimeView_Appointment, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_desktopPaneView_AppointmentDetails.setVerticalGroup(
			gl_desktopPaneView_AppointmentDetails.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_desktopPaneView_AppointmentDetails.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_desktopPaneView_AppointmentDetails.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateView_Appointment)
						.addComponent(lblTimeView_Appointment))
					.addGap(18)
					.addGroup(gl_desktopPaneView_AppointmentDetails.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblServiceView_Appointment)
						.addComponent(lblRoomView_Appointment))
					.addGap(18)
					.addGroup(gl_desktopPaneView_AppointmentDetails.createParallelGroup(Alignment.TRAILING)
						.addComponent(editorPaneNotesView_Appointment, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteApptView_Appointment, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		desktopPaneView_AppointmentDetails.setLayout(gl_desktopPaneView_AppointmentDetails);
		desktopPaneView_Appointment.setLayout(gl_desktopPaneView_Appointment);

		txtFirstName_Appointments = new JTextField();
		txtFirstName_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtFirstName_Appointments.setColumns(10);

		JButton btnCreate_Appointments = new JButton("Create");
		btnCreate_Appointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String sFirstName = txtFirstName_Appointments.getText();
				String sLastName = txtLastName_Appointments.getText();
				String sPetName = txtPetName_Appointments.getText();

				// Validate that all info is filled in
				if ( sFirstName.isEmpty() || sLastName.isEmpty() || sPetName.isEmpty() )
				{
					JOptionPane.showMessageDialog(panelAppointments, "Please provide all Pet and Owner Names", "Missing Fields", JOptionPane.INFORMATION_MESSAGE);
				}

				/*---- Get Owner ----*/
				Owner owner = new Owner( sFirstName, sLastName, "", "", "", "", "" );
				int nOwnerID = 0;
				try {
					nOwnerID = owner.getID();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(panelAppointments, "Owner not found.  Please create a new record.", "Not Found", JOptionPane.INFORMATION_MESSAGE);
					//e.printStackTrace();
				}

				if ( nOwnerID != 0 )
				{
					/*---- Get Pet ----*/
					Pet pet = new Pet( Pet.Type.cat, sPetName, null, null, null, null, null, null, null, null, null );
					int nPetID = 0;
					try {
						nPetID = pet.getID( nOwnerID );
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panelAppointments, "Pet not found.  Please create a new record.", "Not Found", JOptionPane.INFORMATION_MESSAGE);
						//e1.printStackTrace();	
					}

					if ( nPetID != 0 )
					{
						/*---- Create Appointment ----*/
						String sNotes = dtrpnNotes_Appointments.getText();
						if ( sNotes.equals("Notes") )
						{
							sNotes = ""; // "Notes" is default in the box.  Do not want to save this if it has not been modified
						}
						
						
						// TODO: Query for servce ID?
						@SuppressWarnings("unused")
						String sServiceName = "";

						AbstractButton button = groupAppointmentServices.getElements().nextElement();

						if (button.isSelected()) {
							sServiceName = button.getText();
						}

						String sServiceID = "1";

						Date date = calendarAppointments.getDate();

						// TODO: Get Time selection from Time Spinner
						String sTime = AppointmentTimesAvailable.get( cbTime_Appointments.getSelectedIndex() ).toString();

						Appointment appointment = new Appointment( 0, nPetID, sServiceID, date, sTime, "no", sNotes);

						appointment.createAppointment();
						
						// TODO: Reset the UI to accept another appointment
						resetCreateAppointmentUI();
					}
				}
			}
		});


		btnCreate_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

		dtrpnNotes_Appointments = new JEditorPane();
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


		rbOfficeVisit_Appointments = new JRadioButton("Office Visit");
		rbOfficeVisit_Appointments.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		rbOfficeVisit_Appointments.setBackground(UIManager.getColor("Desktop.background"));
		rbOfficeVisit_Appointments.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				updateAppointmentTimesAvailable( 15, true, "" );

			}
		} );

		rbMicrochipping_Appointments = new JRadioButton("Microchipping");
		rbMicrochipping_Appointments.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		rbMicrochipping_Appointments.setBackground(UIManager.getColor("Desktop.background"));
		rbMicrochipping_Appointments.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateAppointmentTimesAvailable( 30, true, "" );

			}
		} );

		rbHeartwormTesting_Appointments = new JRadioButton("Heartworm Testing");
		rbHeartwormTesting_Appointments.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		rbHeartwormTesting_Appointments.setBackground(UIManager.getColor("Desktop.background"));
		rbHeartwormTesting_Appointments.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		} );



		rbSpayNeuter_Appointments = new JRadioButton("Spay/Neuter");
		rbSpayNeuter_Appointments.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		rbSpayNeuter_Appointments.setBackground(UIManager.getColor("Desktop.background"));
		rbSpayNeuter_Appointments.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		} );

		rbLabWork_Appointments = new JRadioButton("Lab Work");
		rbLabWork_Appointments.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		rbLabWork_Appointments.setBackground(UIManager.getColor("Desktop.background"));
		rbLabWork_Appointments.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		} );

		rbDentalCleaning_Appointments = new JRadioButton("Dental Cleaning");
		rbDentalCleaning_Appointments.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		rbDentalCleaning_Appointments.setBackground(UIManager.getColor("Desktop.background"));
		rbDentalCleaning_Appointments.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		} );

		rbXRay_Appointments = new JRadioButton("X-Ray");
		rbXRay_Appointments.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		rbXRay_Appointments.setBackground(UIManager.getColor("Desktop.background"));
		rbXRay_Appointments.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				
			}
		} );

		groupAppointmentServices = new ButtonGroup();
		groupAppointmentServices.add(rbOfficeVisit_Appointments);
		groupAppointmentServices.add(rbMicrochipping_Appointments);
		groupAppointmentServices.add(rbHeartwormTesting_Appointments);
		groupAppointmentServices.add(rbSpayNeuter_Appointments);
		groupAppointmentServices.add(rbLabWork_Appointments);
		groupAppointmentServices.add(rbDentalCleaning_Appointments);
		groupAppointmentServices.add(rbXRay_Appointments);

		AppointmentTimesAvailable.add("Select Time");
			
		cbTime_Appointments = new JComboBox();
		cbTime_Appointments.setModel(new DefaultComboBoxModel(AppointmentTimesAvailable));
		cbTime_Appointments.setEnabled( false );
		cbTime_Appointments.setToolTipText("Please select a service.");
		cbTime_Appointments.setRenderer(ListCellAlignCenter);


		GroupLayout gl_desktopPaneCreate_Appointments = new GroupLayout(desktopPaneCreate_Appointments);
		gl_desktopPaneCreate_Appointments.setHorizontalGroup(
			gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
							.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(rbMicrochipping_Appointments, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rbOfficeVisit_Appointments, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rbHeartwormTesting_Appointments, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
									.addComponent(rbLabWork_Appointments, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rbXRay_Appointments, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
									.addComponent(rbSpayNeuter_Appointments, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rbDentalCleaning_Appointments, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.TRAILING, gl_desktopPaneCreate_Appointments.createSequentialGroup()
							.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
									.addComponent(dtrpnNotes_Appointments, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnCreate_Appointments, GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE))
								.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
									.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPetName_Appointments, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFirstName_Appointments))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING)
										.addComponent(txtFirstName_Appointments, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtPetName_Appointments, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblLastName_Appointments, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(cbTime_Appointments, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtLastName_Appointments, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))))
							.addGap(9)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_desktopPaneCreate_Appointments.setVerticalGroup(
			gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
					.addContainerGap()
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
								.addComponent(txtPetName_Appointments, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_desktopPaneCreate_Appointments.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbTime_Appointments, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(17)
					.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.BASELINE)
						.addComponent(rbOfficeVisit_Appointments)
						.addComponent(rbDentalCleaning_Appointments)
						.addComponent(rbSpayNeuter_Appointments))
					.addGap(1)
					.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.BASELINE)
						.addComponent(rbMicrochipping_Appointments)
						.addComponent(rbXRay_Appointments)
						.addComponent(rbLabWork_Appointments))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rbHeartwormTesting_Appointments, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addGroup(gl_desktopPaneCreate_Appointments.createParallelGroup(Alignment.LEADING)
						.addComponent(dtrpnNotes_Appointments, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(btnCreate_Appointments, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
					.addContainerGap())
		);
		desktopPaneCreate_Appointments.setLayout(gl_desktopPaneCreate_Appointments);

		JScrollPane scrollPaneMonday_Appointments = new JScrollPane();

		JScrollPane scrollPaneTues_Appointments = new JScrollPane();

		JScrollPane scrollPaneWed_Appointments = new JScrollPane();

		JScrollPane scrollPaneThurs_Appointments = new JScrollPane();

		JScrollPane scrollPaneFriday_Appointments = new JScrollPane();

		JScrollPane scrollPaneSat_Appointments = new JScrollPane();

		JLabel lblMonday_Appointments = new JLabel("Monday");
		lblMonday_Appointments.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblMonday_Appointments.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblTuesday_Appointments = new JLabel("Tuesday");
		lblTuesday_Appointments.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTuesday_Appointments.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblWednesday_Appointments = new JLabel("Wednesday");
		lblWednesday_Appointments.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblWednesday_Appointments.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblThursday_Appointments = new JLabel("Thursday");
		lblThursday_Appointments.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblThursday_Appointments.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblFriday_Appointments = new JLabel("Friday");
		lblFriday_Appointments.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblFriday_Appointments.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSaturday_Appointments = new JLabel("Saturday");
		lblSaturday_Appointments.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblSaturday_Appointments.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_desktopPaneView_Appointments = new GroupLayout(desktopPaneView_Appointments);
		gl_desktopPaneView_Appointments.setHorizontalGroup(
				gl_desktopPaneView_Appointments.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneView_Appointments.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_desktopPaneView_Appointments.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMonday_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
								.addComponent(scrollPaneMonday_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
								.addGap(12)
								.addGroup(gl_desktopPaneView_Appointments.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTuesday_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
										.addComponent(scrollPaneTues_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
										.addGap(14)
										.addGroup(gl_desktopPaneView_Appointments.createParallelGroup(Alignment.LEADING)
												.addComponent(lblWednesday_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
												.addComponent(scrollPaneWed_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_desktopPaneView_Appointments.createParallelGroup(Alignment.LEADING)
														.addComponent(lblThursday_Appointments, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
														.addComponent(scrollPaneThurs_Appointments, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_desktopPaneView_Appointments.createParallelGroup(Alignment.LEADING)
																.addComponent(lblFriday_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
																.addComponent(scrollPaneFriday_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addGroup(gl_desktopPaneView_Appointments.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblSaturday_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
																		.addComponent(scrollPaneSat_Appointments, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
																		.addGap(8))
				);
		gl_desktopPaneView_Appointments.setVerticalGroup(
				gl_desktopPaneView_Appointments.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneView_Appointments.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_desktopPaneView_Appointments.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMonday_Appointments)
								.addComponent(lblTuesday_Appointments)
								.addComponent(lblWednesday_Appointments)
								.addComponent(lblThursday_Appointments)
								.addComponent(lblFriday_Appointments)
								.addComponent(lblSaturday_Appointments))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_desktopPaneView_Appointments.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPaneSat_Appointments, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
										.addComponent(scrollPaneFriday_Appointments, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
										.addComponent(scrollPaneThurs_Appointments, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
										.addComponent(scrollPaneWed_Appointments, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
										.addComponent(scrollPaneTues_Appointments, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
										.addComponent(scrollPaneMonday_Appointments, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
										.addContainerGap())
				);


		/* --------------------------
		 *  Saturday Appointments
		 */
		tableSaturday_Appointments = new JTable(new DefaultTableModel( Saturday_Appointments_TableData, ColumnLabels_Appointments ) {
			boolean[] columnEditables = new boolean[] {
					false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableSaturday_Appointments.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ColumnModel_Appointments = tableSaturday_Appointments.getColumnModel();
		Column_Appointments = ColumnModel_Appointments.getColumn(1);
		Column_Appointments.setMinWidth(50);
		Column_Appointments.setMaxWidth(80);
		Column_Appointments.setCellRenderer(TableCellAlignCenter);
		tableSaturday_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		tableSaturday_Appointments.setRowHeight(tableSaturday_Appointments.getRowHeight() + 20);
		scrollPaneSat_Appointments.setViewportView(tableSaturday_Appointments);
		tableSaturday_Appointments.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = tableSaturday_Appointments.getSelectedRow();
				if (row != -1 )
				{
					Appointment appointment = Saturday_Appointments.get(row);
					updateViewAppointment( appointment );
				}
			}
		});
		tableSaturday_Appointments.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				tableMonday_Appointments.getSelectionModel().clearSelection();
				tableTuesday_Appointments.getSelectionModel().clearSelection();
				tableWednesday_Appointments.getSelectionModel().clearSelection();
				tableThursday_Appointments.getSelectionModel().clearSelection();
				tableFriday_Appointments.getSelectionModel().clearSelection();
			}
		});
		//----------------------------




		/* --------------------------
		 *  Friday Appointments
		 */
		tableFriday_Appointments  = new JTable(new DefaultTableModel( Friday_Appointments_TableData, ColumnLabels_Appointments ) {
			boolean[] columnEditables = new boolean[] {
					false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableFriday_Appointments.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ColumnModel_Appointments = tableFriday_Appointments.getColumnModel();
		Column_Appointments = ColumnModel_Appointments.getColumn(1);
		Column_Appointments.setMinWidth(50);
		Column_Appointments.setMaxWidth(80);
		Column_Appointments.setCellRenderer(TableCellAlignCenter);
		tableFriday_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		tableFriday_Appointments.setRowHeight(tableFriday_Appointments.getRowHeight() + 20);
		scrollPaneFriday_Appointments.setViewportView(tableFriday_Appointments);
		tableFriday_Appointments.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = tableFriday_Appointments.getSelectedRow();
				if (row != -1 )
				{
					Appointment appointment = Friday_Appointments.get(row);
					updateViewAppointment( appointment );
				}
			}
		});
		tableFriday_Appointments.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				tableMonday_Appointments.getSelectionModel().clearSelection();
				tableTuesday_Appointments.getSelectionModel().clearSelection();
				tableWednesday_Appointments.getSelectionModel().clearSelection();
				tableThursday_Appointments.getSelectionModel().clearSelection();
				tableSaturday_Appointments.getSelectionModel().clearSelection();
			}
		});
		//----------------------------



		/* --------------------------
		 *  Thursday Appointments
		 */
		tableThursday_Appointments = new JTable(new DefaultTableModel( Thursday_Appointments_TableData, ColumnLabels_Appointments ) {
			boolean[] columnEditables = new boolean[] {
					false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableThursday_Appointments.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ColumnModel_Appointments = tableThursday_Appointments.getColumnModel();
		Column_Appointments = ColumnModel_Appointments.getColumn(1);
		Column_Appointments.setMinWidth(50);
		Column_Appointments.setMaxWidth(80);
		Column_Appointments.setCellRenderer(TableCellAlignCenter);
		tableThursday_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		tableThursday_Appointments.setRowHeight(tableThursday_Appointments.getRowHeight() + 20);
		scrollPaneThurs_Appointments.setViewportView(tableThursday_Appointments);
		tableThursday_Appointments.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = tableThursday_Appointments.getSelectedRow();
				if (row != -1 )
				{
					Appointment appointment = Thursday_Appointments.get(row);
					updateViewAppointment( appointment );
				}			
			}
		});
		tableThursday_Appointments.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				tableMonday_Appointments.getSelectionModel().clearSelection();
				tableTuesday_Appointments.getSelectionModel().clearSelection();
				tableWednesday_Appointments.getSelectionModel().clearSelection();
				tableFriday_Appointments.getSelectionModel().clearSelection();
				tableSaturday_Appointments.getSelectionModel().clearSelection();
			}
		});
		//----------------------------




		/* --------------------------
		 *  Wednesday Appointments
		 */
		tableWednesday_Appointments  = new JTable(new DefaultTableModel( Wednesday_Appointments_TableData, ColumnLabels_Appointments ) {
			boolean[] columnEditables = new boolean[] {
					false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableWednesday_Appointments.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ColumnModel_Appointments = tableWednesday_Appointments.getColumnModel();
		Column_Appointments = ColumnModel_Appointments.getColumn(1);
		Column_Appointments.setMinWidth(50);
		Column_Appointments.setMaxWidth(80);
		Column_Appointments.setCellRenderer(TableCellAlignCenter);
		tableWednesday_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		tableWednesday_Appointments.setRowHeight(tableWednesday_Appointments.getRowHeight() + 20);
		scrollPaneWed_Appointments.setViewportView(tableWednesday_Appointments);
		tableWednesday_Appointments.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = tableWednesday_Appointments.getSelectedRow();
				if (row != -1 )
				{
					Appointment appointment = Wednesday_Appointments.get(row);
					updateViewAppointment( appointment );
				}	
			}
		});
		tableWednesday_Appointments.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				tableMonday_Appointments.getSelectionModel().clearSelection();
				tableTuesday_Appointments.getSelectionModel().clearSelection();
				tableThursday_Appointments.getSelectionModel().clearSelection();
				tableFriday_Appointments.getSelectionModel().clearSelection();
				tableSaturday_Appointments.getSelectionModel().clearSelection();
			}
		});
		//----------------------------




		/* --------------------------
		 *  Tuesday Appointments
		 */
		tableTuesday_Appointments = new JTable(new DefaultTableModel( Tuesday_Appointments_TableData, ColumnLabels_Appointments ) {
			boolean[] columnEditables = new boolean[] {
					false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableTuesday_Appointments.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ColumnModel_Appointments = tableTuesday_Appointments.getColumnModel();
		Column_Appointments = ColumnModel_Appointments.getColumn(1);
		Column_Appointments.setMinWidth(50);
		Column_Appointments.setMaxWidth(80);
		Column_Appointments.setCellRenderer(TableCellAlignCenter);
		tableTuesday_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		tableTuesday_Appointments.setRowHeight(tableTuesday_Appointments.getRowHeight() + 20);
		scrollPaneTues_Appointments.setViewportView(tableTuesday_Appointments);
		tableTuesday_Appointments.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = tableTuesday_Appointments.getSelectedRow();
				if (row != -1 )
				{
					Appointment appointment = Tuesday_Appointments.get(row);
					updateViewAppointment( appointment );
				}	
			}
		});
		tableTuesday_Appointments.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				tableMonday_Appointments.getSelectionModel().clearSelection();
				tableWednesday_Appointments.getSelectionModel().clearSelection();
				tableThursday_Appointments.getSelectionModel().clearSelection();
				tableFriday_Appointments.getSelectionModel().clearSelection();
				tableSaturday_Appointments.getSelectionModel().clearSelection();
			}
		});
		//----------------------------




		/* --------------------------
		 *  Monday Appointments
		 */
		tableMonday_Appointments = new JTable(new DefaultTableModel( Monday_Appointments_TableData, ColumnLabels_Appointments ) {
			boolean[] columnEditables = new boolean[] {
					false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableMonday_Appointments.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ColumnModel_Appointments = tableMonday_Appointments.getColumnModel();
		Column_Appointments = ColumnModel_Appointments.getColumn(1);
		Column_Appointments.setMinWidth(50);
		Column_Appointments.setMaxWidth(80);
		Column_Appointments.setCellRenderer(TableCellAlignCenter);
		tableMonday_Appointments.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		tableMonday_Appointments.setRowHeight(tableMonday_Appointments.getRowHeight() + 20);
		scrollPaneMonday_Appointments.setViewportView(tableMonday_Appointments);
		tableMonday_Appointments.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = tableMonday_Appointments.getSelectedRow();
				if (row != -1 )
				{
					Appointment appointment = Monday_Appointments.get(row);
					updateViewAppointment( appointment );
				}	
			}
		});
		tableMonday_Appointments.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				tableTuesday_Appointments.clearSelection();
				tableWednesday_Appointments.clearSelection();
				tableThursday_Appointments.clearSelection();
				tableFriday_Appointments.clearSelection();
				tableSaturday_Appointments.clearSelection();
			}
		});
		//----------------------------


		try {
			refreshAppointments(); 		// Load the appointments for the week when the application is first started and fill the appointment tables
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		desktopPaneView_Appointments.setLayout(gl_desktopPaneView_Appointments);
		panelAppointments.setLayout(gl_panelAppointments);

		JPanel panelSales = new JPanel();
		tabbedPane.addTab("    Sales    ", null, panelSales, null);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnPay = new JButton("Pay");
		btnPay.setFont(new Font("Lucida Grande", Font.PLAIN, 16));

		JDesktopPane desktopPaneServices_Sales = new JDesktopPane();

		JDesktopPane desktopPaneImmunizations_Sales = new JDesktopPane();

		JLabel label_4 = new JLabel("");

		JButton btnRabiesCat_Sales = new JButton("Rabies Cat");
		btnRabiesCat_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Rabies Cat");
			}
		});
		btnRabiesCat_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JButton btnRabiesDog_Sales = new JButton("Rabies Dog");
		btnRabiesDog_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Rabies Dog");
			}
		});
		btnRabiesDog_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JButton btnDistempterDog_Sales = new JButton("Distempter Dog");
		btnDistempterDog_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Distemper Dog");
			}
		});
		btnDistempterDog_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JButton btnDistemperCat_Sales = new JButton("Distemper Cat");
		btnDistemperCat_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Distemper Cat");
			}
		});
		btnDistemperCat_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JButton btnBordetella_Sales = new JButton("Bordetella");
		btnBordetella_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Bordetella");
			}
		});
		btnBordetella_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JLabel label_5 = new JLabel("");

		JLabel lblImmunizations_Sales = new JLabel("Immunizations");
		lblImmunizations_Sales.setHorizontalAlignment(SwingConstants.CENTER);
		lblImmunizations_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GroupLayout gl_desktopPaneImmunizations_Sales = new GroupLayout(desktopPaneImmunizations_Sales);
		gl_desktopPaneImmunizations_Sales.setHorizontalGroup(
				gl_desktopPaneImmunizations_Sales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneImmunizations_Sales.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_desktopPaneImmunizations_Sales.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_desktopPaneImmunizations_Sales.createSequentialGroup()
										.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_desktopPaneImmunizations_Sales.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnRabiesCat_Sales, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnRabiesDog_Sales, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_desktopPaneImmunizations_Sales.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(btnDistempterDog_Sales, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnDistemperCat_Sales, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnBordetella_Sales, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(label_5, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
														.addComponent(lblImmunizations_Sales, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
														.addContainerGap())
				);
		gl_desktopPaneImmunizations_Sales.setVerticalGroup(
				gl_desktopPaneImmunizations_Sales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneImmunizations_Sales.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblImmunizations_Sales)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_desktopPaneImmunizations_Sales.createParallelGroup(Alignment.LEADING)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_desktopPaneImmunizations_Sales.createSequentialGroup()
										.addGroup(gl_desktopPaneImmunizations_Sales.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnRabiesCat_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnDistemperCat_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_desktopPaneImmunizations_Sales.createParallelGroup(Alignment.BASELINE, false)
														.addComponent(btnBordetella_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnDistempterDog_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnRabiesDog_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))))
														.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		desktopPaneImmunizations_Sales.setLayout(gl_desktopPaneImmunizations_Sales);

		JDesktopPane desktopPaneBoarding_Sales = new JDesktopPane();

		JButton btnCat_Sales = new JButton("Cat");
		btnCat_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int daysBoarded = Integer.parseInt(textFieldDaysBoarded_Sales.getText());
				updateTotal("Boarding Cat", daysBoarded);
			}
		});
		btnCat_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JButton btnSmallDog_Sales = new JButton("Bath/Groom Cat");
		btnSmallDog_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Bath/Groom Cat");
			}
		});
		btnSmallDog_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JButton btnMediumDog_Sales = new JButton("Bath/Groom Dog");
		btnMediumDog_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Bath/Groom Dog");
			}
		});
		btnMediumDog_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JButton btnBathgroomCat_Sales = new JButton("Small Dog");
		btnBathgroomCat_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int daysBoarded = Integer.parseInt(textFieldDaysBoarded_Sales.getText());
				updateTotal("Boarding Small Dog", daysBoarded);
			}
		});
		btnBathgroomCat_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JButton btnLargeDog_Sales = new JButton("Medium Dog");
		btnLargeDog_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int daysBoarded = Integer.parseInt(textFieldDaysBoarded_Sales.getText());
					updateTotal("Boarding Medium Dog", daysBoarded);
				}
				catch(NumberFormatException nfe){
					textFieldDaysBoarded_Sales.setText("0");
				}
				
			}
		});
		btnLargeDog_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JLabel lblBoarding_Sales = new JLabel("Boarding");
		lblBoarding_Sales.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoarding_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		JButton btnBathgroomDog_Sales = new JButton("Large Dog");
		btnBathgroomDog_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int daysBoarded = Integer.parseInt(textFieldDaysBoarded_Sales.getText());
				updateTotal("Boarding Large Dog", daysBoarded);
			}
		});
		btnBathgroomDog_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		textFieldDaysBoarded_Sales = new JTextField();
		textFieldDaysBoarded_Sales.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDaysBoarded_Sales.setText("0");
		textFieldDaysBoarded_Sales.setColumns(10);

		JLabel lblDaysBoarded_Sales = new JLabel("Days Boarded:");
		lblDaysBoarded_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDaysBoarded_Sales.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel label_6 = new JLabel("");

		JLabel lblA = new JLabel("");
		GroupLayout gl_desktopPaneBoarding_Sales = new GroupLayout(desktopPaneBoarding_Sales);
		gl_desktopPaneBoarding_Sales.setHorizontalGroup(
				gl_desktopPaneBoarding_Sales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneBoarding_Sales.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_desktopPaneBoarding_Sales.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_desktopPaneBoarding_Sales.createSequentialGroup()
										.addComponent(label_6, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_desktopPaneBoarding_Sales.createParallelGroup(Alignment.LEADING)
												.addComponent(btnSmallDog_Sales, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnCat_Sales, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_desktopPaneBoarding_Sales.createParallelGroup(Alignment.LEADING, false)
														.addGroup(gl_desktopPaneBoarding_Sales.createSequentialGroup()
																.addComponent(btnBathgroomCat_Sales, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnLargeDog_Sales, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
																.addGap(6)
																.addComponent(btnBathgroomDog_Sales, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_desktopPaneBoarding_Sales.createSequentialGroup()
																		.addComponent(btnMediumDog_Sales, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(lblDaysBoarded_Sales, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(textFieldDaysBoarded_Sales, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(lblA, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
																		.addPreferredGap(ComponentPlacement.RELATED))
																		.addComponent(lblBoarding_Sales, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE))
																		.addGap(0))
				);
		gl_desktopPaneBoarding_Sales.setVerticalGroup(
				gl_desktopPaneBoarding_Sales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneBoarding_Sales.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblBoarding_Sales)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_desktopPaneBoarding_Sales.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblA, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
								.addComponent(label_6, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_desktopPaneBoarding_Sales.createSequentialGroup()
										.addGroup(gl_desktopPaneBoarding_Sales.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnBathgroomCat_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnLargeDog_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnBathgroomDog_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnCat_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_desktopPaneBoarding_Sales.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnMediumDog_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnSmallDog_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldDaysBoarded_Sales, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblDaysBoarded_Sales, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
														.addContainerGap())
				);
		desktopPaneBoarding_Sales.setLayout(gl_desktopPaneBoarding_Sales);

		JDesktopPane desktopPaneProducts_Sales = new JDesktopPane();

		JLabel label_7 = new JLabel("");

		JLabel label_8 = new JLabel("");

		JButton btnKittenFood_Sales = new JButton("Kitten Food (10lbs)");
		btnKittenFood_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Kitten Food");
			}
		});
		btnKittenFood_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		JButton btnHeartwormCat_Sales = new JButton("Heartworm");
		btnHeartwormCat_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Heartworm Cat");
			}
		});
		btnHeartwormCat_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		JButton btnlowFatAdult = new JButton("(Low Fat) Adult Food");
		btnlowFatAdult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Reduced Fat Adult Dog Food");
			}
		});
		btnlowFatAdult.setFont(new Font("Dialog", Font.PLAIN, 10));

		JButton btnFleatick_2 = new JButton("Flea/Tick");
		btnFleatick_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Flea/Tick Dog");
			}
		});
		btnFleatick_2.setFont(new Font("Dialog", Font.PLAIN, 10));

		JButton btnredFatAdultCatFood_Sales = new JButton("(Low Fat) Adult Food");
		btnredFatAdultCatFood_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Reduced Fat Adult Cat Food");
			}
		});
		btnredFatAdultCatFood_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		JLabel lblProducts_Sales = new JLabel("Products");
		lblProducts_Sales.setVerticalAlignment(SwingConstants.BOTTOM);
		lblProducts_Sales.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducts_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		JButton btnPuppyFoodmedlg = new JButton("Puppy Food (med/lg)");
		btnPuppyFoodmedlg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Puppy Medium/Large Food");
			}
		});
		btnPuppyFoodmedlg.setFont(new Font("Dialog", Font.PLAIN, 10));

		JButton btnHeartwormLargeDog_Sales = new JButton("Heartworm (large)");
		btnHeartwormLargeDog_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Heartworm Large Dog");
			}
		});
		btnHeartwormLargeDog_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		JButton btnseniorAdultFood_1 = new JButton("(Senior) Adult Food");
		btnseniorAdultFood_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Senior Adult Dog Food");
			}
		});
		btnseniorAdultFood_1.setFont(new Font("Dialog", Font.PLAIN, 10));

		JButton btnseniorAdultCatFood_Sales = new JButton("(Senior) Adult Food");
		btnseniorAdultCatFood_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Senior Adult Cat Food");
			}
		});
		btnseniorAdultCatFood_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		JButton btnAdultCatFood_Sales = new JButton("Adult Food (15lbs)");
		btnAdultCatFood_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Adult Cat Food");
			}
		});
		btnAdultCatFood_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		JButton btnFleatickCat_Sales = new JButton("Flea/Tick");
		btnFleatickCat_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Flea/Tick Cat");
			}
		});
		btnFleatickCat_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		JButton btnAdultFood = new JButton("Adult Food");
		btnAdultFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Adult Dog Food");
			}
		});
		btnAdultFood.setFont(new Font("Dialog", Font.PLAIN, 10));

		JButton btnPuppyFoodSmall_Sales = new JButton("Puppy Food (sm)");
		btnPuppyFoodSmall_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Puppy Small Food");
			}
		});
		btnPuppyFoodSmall_Sales.setFont(new Font("Dialog", Font.PLAIN, 10));

		JButton btnHeartwormSmallMedDog_Sales = new JButton("Heartworm (sm/med)");
		btnHeartwormSmallMedDog_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Heartworm Small Medium Dog");
			}
		});
		btnHeartwormSmallMedDog_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		JLabel lblNewLabel_1 = new JLabel("Dog");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblCat = new JLabel("Cat");
		lblCat.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblCat.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_desktopPaneProducts_Sales = new GroupLayout(desktopPaneProducts_Sales);
		gl_desktopPaneProducts_Sales.setHorizontalGroup(
				gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneProducts_Sales.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_desktopPaneProducts_Sales.createSequentialGroup()
										.addComponent(lblProducts_Sales, GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
										.addGap(6))
										.addGroup(gl_desktopPaneProducts_Sales.createSequentialGroup()
												.addComponent(label_8, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_desktopPaneProducts_Sales.createSequentialGroup()
																.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.LEADING)
																		.addComponent(btnHeartwormCat_Sales, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
																		.addComponent(btnKittenFood_Sales, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.LEADING)
																				.addComponent(btnAdultCatFood_Sales, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
																				.addComponent(btnFleatickCat_Sales, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
																				.addComponent(lblCat, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
																				.addGroup(gl_desktopPaneProducts_Sales.createSequentialGroup()
																						.addComponent(btnredFatAdultCatFood_Sales, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(ComponentPlacement.RELATED)
																						.addComponent(btnseniorAdultCatFood_Sales, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
																						.addGap(19)
																						.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.TRAILING, false)
																								.addGroup(gl_desktopPaneProducts_Sales.createSequentialGroup()
																										.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.TRAILING)
																												.addComponent(btnAdultFood, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																												.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.TRAILING, false)
																														.addComponent(btnPuppyFoodSmall_Sales, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
																														.addComponent(btnHeartwormSmallMedDog_Sales, GroupLayout.PREFERRED_SIZE, 135, Short.MAX_VALUE))
																														.addComponent(btnseniorAdultFood_1, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
																														.addPreferredGap(ComponentPlacement.RELATED)
																														.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.LEADING)
																																.addComponent(btnFleatick_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																.addComponent(btnlowFatAdult, 0, 0, Short.MAX_VALUE)
																																.addComponent(btnHeartwormLargeDog_Sales, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
																																.addComponent(btnPuppyFoodmedlg, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 134, Short.MAX_VALUE)))
																																.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
																																.addPreferredGap(ComponentPlacement.RELATED)
																																.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)))
																																.addGap(3))
				);
		gl_desktopPaneProducts_Sales.setVerticalGroup(
				gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneProducts_Sales.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblProducts_Sales)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.LEADING)
								.addComponent(label_8, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
								.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
								.addGroup(gl_desktopPaneProducts_Sales.createSequentialGroup()
										.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblCat)
												.addComponent(lblNewLabel_1))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnHeartwormCat_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnFleatickCat_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnHeartwormLargeDog_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnHeartwormSmallMedDog_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.BASELINE)
																		.addComponent(btnKittenFood_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
																		.addComponent(btnAdultCatFood_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.BASELINE)
																				.addComponent(btnPuppyFoodmedlg, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
																				.addComponent(btnPuppyFoodSmall_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
																				.addPreferredGap(ComponentPlacement.RELATED)
																				.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.LEADING)
																						.addGroup(gl_desktopPaneProducts_Sales.createSequentialGroup()
																								.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.BASELINE)
																										.addComponent(btnlowFatAdult, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
																										.addComponent(btnAdultFood, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(ComponentPlacement.RELATED)
																										.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.BASELINE)
																												.addComponent(btnseniorAdultFood_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
																												.addComponent(btnFleatick_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
																												.addGroup(gl_desktopPaneProducts_Sales.createParallelGroup(Alignment.BASELINE)
																														.addComponent(btnredFatAdultCatFood_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
																														.addComponent(btnseniorAdultCatFood_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
																														.addGap(45)))
																														.addGap(4))
				);
		desktopPaneProducts_Sales.setLayout(gl_desktopPaneProducts_Sales);

		JLabel lblA_1 = new JLabel("");

		JLabel lblA_2 = new JLabel("");
		
		JLabel lblTotalText = new JLabel("Total:");
		lblTotalText.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		lblTotal = new JLabel("$0.00");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GroupLayout gl_panelSales = new GroupLayout(panelSales);
		gl_panelSales.setHorizontalGroup(
			gl_panelSales.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelSales.createSequentialGroup()
					.addGroup(gl_panelSales.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSales.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelSales.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addGroup(gl_panelSales.createSequentialGroup()
									.addComponent(lblA_2, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnPay, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblA_1, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))))
						.addGroup(gl_panelSales.createSequentialGroup()
							.addGap(21)
							.addComponent(lblTotalText)
							.addGap(18)
							.addComponent(lblTotal, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelSales.createParallelGroup(Alignment.TRAILING)
						.addComponent(desktopPaneProducts_Sales, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
						.addComponent(desktopPaneServices_Sales, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
						.addComponent(desktopPaneImmunizations_Sales, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
						.addComponent(desktopPaneBoarding_Sales, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelSales.setVerticalGroup(
			gl_panelSales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSales.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSales.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelSales.createSequentialGroup()
							.addComponent(desktopPaneServices_Sales, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(desktopPaneImmunizations_Sales, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(desktopPaneBoarding_Sales, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(desktopPaneProducts_Sales, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panelSales.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
							.addGap(31)
							.addGroup(gl_panelSales.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTotalText)
								.addComponent(lblTotal))
							.addGap(18)
							.addGroup(gl_panelSales.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnPay, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelSales.createSequentialGroup()
									.addGroup(gl_panelSales.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblA_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblA_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
									.addGap(6)))))
					.addGap(6))
		);

		JLabel lblServices = new JLabel("Services");
		lblServices.setHorizontalAlignment(SwingConstants.CENTER);
		lblServices.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		JButton btnOfficeVisit_Sales = new JButton("Office Visit");
		btnOfficeVisit_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JButton btnLabWork_Sales = new JButton("Lab Work");
		btnLabWork_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JButton btnSpayneuterDog_Sales = new JButton("Spay/Neuter Dog");
		btnSpayneuterDog_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Spay/Neuter Dog");
			}
		});
		btnSpayneuterDog_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JButton btnSpayneuterCat_Sales = new JButton("Spay/Neuter Cat");
		btnSpayneuterCat_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Spay/Neuter Cat");
			}
		});
		btnSpayneuterCat_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JButton btnDentalDog_Sales = new JButton("Dental Dog");
		btnDentalDog_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Dental Dog");
			}
		});
		btnDentalDog_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JButton btnDentalCat_Sales = new JButton("Dental Cat");
		btnDentalCat_Sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal("Dental Cat");
			}
		});
		btnDentalCat_Sales.setFont(new Font("Lucida Grande", Font.PLAIN, 14));

		JLabel lblNewLabel = new JLabel("");

		JLabel label_3 = new JLabel("");
		GroupLayout gl_desktopPaneServices_Sales = new GroupLayout(desktopPaneServices_Sales);
		gl_desktopPaneServices_Sales.setHorizontalGroup(
				gl_desktopPaneServices_Sales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneServices_Sales.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_desktopPaneServices_Sales.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_desktopPaneServices_Sales.createSequentialGroup()
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_desktopPaneServices_Sales.createParallelGroup(Alignment.LEADING)
												.addComponent(btnLabWork_Sales, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnOfficeVisit_Sales, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_desktopPaneServices_Sales.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(btnSpayneuterCat_Sales, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnSpayneuterDog_Sales, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_desktopPaneServices_Sales.createParallelGroup(Alignment.LEADING, false)
																.addComponent(btnDentalCat_Sales, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
																.addComponent(btnDentalDog_Sales, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
																.addComponent(lblServices, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
																.addContainerGap())
				);
		gl_desktopPaneServices_Sales.setVerticalGroup(
				gl_desktopPaneServices_Sales.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPaneServices_Sales.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblServices)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_desktopPaneServices_Sales.createParallelGroup(Alignment.LEADING, false)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_desktopPaneServices_Sales.createSequentialGroup()
										.addGroup(gl_desktopPaneServices_Sales.createParallelGroup(Alignment.BASELINE, false)
												.addComponent(btnOfficeVisit_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnDentalDog_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnSpayneuterDog_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_desktopPaneServices_Sales.createParallelGroup(Alignment.BASELINE, false)
														.addComponent(btnDentalCat_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnSpayneuterCat_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnLabWork_Sales, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))))
														.addGap(0, 0, Short.MAX_VALUE))
				);
		desktopPaneServices_Sales.setLayout(gl_desktopPaneServices_Sales);
		
		DefaultTableModel table_model= new DefaultTableModel(sales_column_names, 0);
		servicesTable = new JTable(table_model);
		scrollPane.setViewportView(servicesTable);
		panelSales.setLayout(gl_panelSales);

		JPanel panelBoarding = new JPanel();						  
		tabbedPane.addTab("  Boarding   ", null, panelBoarding, null);

		JDesktopPane desktopPaneCreate_Boarding = new JDesktopPane();

		JComponent dateChooser = new JBoardingDateChooser();

		Calendar calendar = Calendar.getInstance();
		Date date = ((JBoardingDateChooser)dateChooser).getDateEditor().getDate();
		if (date != null) {
			calendar.setTime(date);
		}
		((JBoardingDateChooser)dateChooser).getJCalendar().setCalendar(calendar);

		JComponent calendarViewBoarding = ((JBoardingDateChooser) dateChooser).getJCalendar();

		//JBoardingCalendar calendarViewBoarding = new JBoardingCalendar();

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
						.addPreferredGap(ComponentPlacement.UNRELATED)
						//.addComponent(calendarViewBoarding, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_panelBoarding.setVerticalGroup(
				gl_panelBoarding.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelBoarding.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelBoarding.createParallelGroup(Alignment.TRAILING)
								//.addComponent(calendarViewBoarding, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
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

		JComponent dateChooserFrom_Boarding = new JDateChooser();

		JComponent dateChooserTo_Boarding = new JDateChooser();

		JEditorPane editorPaneNotes_Boarding = new JEditorPane();
		editorPaneNotes_Boarding.setText("Notes");

		JButton btnCreate_Boarding = new JButton("Create");
		btnCreate_Boarding.setFont(new Font("Lucida Grande", Font.PLAIN, 16));

		GroupLayout gl_desktopPaneCreate_Boarding = new GroupLayout(desktopPaneCreate_Boarding);
		gl_desktopPaneCreate_Boarding.setHorizontalGroup(
				gl_desktopPaneCreate_Boarding.createParallelGroup(Alignment.TRAILING)
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
																						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
																						.addContainerGap())
																						.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
																								.addContainerGap()
																								.addComponent(lblPet_Boarding, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
																								.addContainerGap())
																								.addGroup(Alignment.LEADING, gl_desktopPaneCreate_Boarding.createSequentialGroup()
																										.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
																										.addContainerGap())
																										.addGroup(Alignment.LEADING, gl_desktopPaneCreate_Boarding.createSequentialGroup()
																												.addContainerGap()
																												.addComponent(lblScheduling_Boarding, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
																												.addContainerGap())
																												.addGroup(Alignment.LEADING, gl_desktopPaneCreate_Boarding.createSequentialGroup()
																														.addContainerGap()
																														.addComponent(lblFrom_Boarding, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
																														.addGap(233))
																														.addGroup(Alignment.LEADING, gl_desktopPaneCreate_Boarding.createSequentialGroup()
																																.addContainerGap()
																																.addComponent(dateChooserFrom_Boarding, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
																																.addContainerGap(20, Short.MAX_VALUE))
																																.addGroup(Alignment.LEADING, gl_desktopPaneCreate_Boarding.createSequentialGroup()
																																		.addContainerGap()
																																		.addComponent(lblTo_Boarding, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
																																		.addGap(233))
																																		.addGroup(Alignment.LEADING, gl_desktopPaneCreate_Boarding.createSequentialGroup()
																																				.addContainerGap()
																																				.addComponent(dateChooserTo_Boarding, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
																																				.addContainerGap(20, Short.MAX_VALUE))
																																				.addGroup(Alignment.LEADING, gl_desktopPaneCreate_Boarding.createSequentialGroup()
																																						.addContainerGap()
																																						.addComponent(lblAvailableKenels_Boarding, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
																																						.addGap(27)
																																						.addComponent(cbKennels_Boarding, 0, 106, Short.MAX_VALUE)
																																						.addContainerGap())
																																						.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
																																						.addGroup(Alignment.LEADING, gl_desktopPaneCreate_Boarding.createSequentialGroup()
																																								.addContainerGap()
																																								.addComponent(lblKenel_Boarding, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
																																								.addContainerGap())
																																								.addGroup(Alignment.LEADING, gl_desktopPaneCreate_Boarding.createSequentialGroup()
																																										.addContainerGap()
																																										.addComponent(chckbxBathinggrooming_Boarding, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																										.addGap(148))
																																										.addGroup(Alignment.LEADING, gl_desktopPaneCreate_Boarding.createSequentialGroup()
																																												.addContainerGap()
																																												.addComponent(chckbxAdditionalPlayTime_Boarding, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																												.addGap(136))
																																												.addGroup(Alignment.LEADING, gl_desktopPaneCreate_Boarding.createSequentialGroup()
																																														.addContainerGap()
																																														.addComponent(chckbxDentalCleaning_Boarding, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
																																														.addGap(113))
																																														.addGroup(Alignment.LEADING, gl_desktopPaneCreate_Boarding.createSequentialGroup()
																																																.addContainerGap()
																																																.addComponent(editorPaneNotes_Boarding, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
																																																.addContainerGap())
																																																.addGroup(gl_desktopPaneCreate_Boarding.createSequentialGroup()
																																																		.addGap(213)
																																																		.addComponent(btnCreate_Boarding, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
														.addGap(5)
														.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblScheduling_Boarding)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblFrom_Boarding, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(dateChooserFrom_Boarding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblTo_Boarding, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(dateChooserTo_Boarding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_desktopPaneCreate_Boarding.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblAvailableKenels_Boarding, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
																.addComponent(cbKennels_Boarding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(lblKenel_Boarding, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(chckbxBathinggrooming_Boarding)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(chckbxAdditionalPlayTime_Boarding)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(chckbxDentalCleaning_Boarding)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(editorPaneNotes_Boarding, GroupLayout.PREFERRED_SIZE, 7, Short.MAX_VALUE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnCreate_Boarding)
																.addContainerGap())
				);
		desktopPaneCreate_Boarding.setLayout(gl_desktopPaneCreate_Boarding);

		panelBoarding.setLayout(gl_panelBoarding);

		JPanel panelRecords = new JPanel();
		tabbedPane.addTab("   Records   ", null, panelRecords, null);

		JButton btnNewOwner = new JButton("New Owner");
		btnNewOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewOwnerFrame Frame = new NewOwnerFrame();
				Frame.setVisible(true);
				Frame.setLocationRelativeTo(null);
				Frame.setAlwaysOnTop(true);
			}
		});
		btnNewOwner.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));

		//NOTE: Begin Tree
		addWindowFocusListener(this);
		OwnerTree = populateTree();
		OwnerTree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) OwnerTree.getLastSelectedPathComponent();
				if (node == null)
					//Nothing is selected.     
					return;

				Object nodeInfo = node.getUserObject();
				if (node.isLeaf()) {
					Pet selectedPet = (Pet) nodeInfo;
					DefaultMutableTreeNode Parent = (DefaultMutableTreeNode) node.getParent();
					Owner selectedOwner = (Owner) Parent.getUserObject();
					UpdateRecordLabels(selectedOwner, selectedPet);
				} else {
					Owner selectedOwner = (Owner) nodeInfo;
					UpdateRecordLabels(selectedOwner);
				}
			}
		});
		OwnerTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		JButton btnAddPet = new JButton("Add Pet");
		btnAddPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//grab currently selected owner
				Owner selectedOwner;
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) OwnerTree.getLastSelectedPathComponent();
				if (node == null)
					//Nothing is selected.     
					return;

				Object nodeInfo = node.getUserObject();
				if (node.isLeaf()) {
					DefaultMutableTreeNode Parent = (DefaultMutableTreeNode) node.getParent();
					selectedOwner = (Owner) Parent.getUserObject();
				} else {
					selectedOwner = (Owner) nodeInfo;
				}

				//add pet to DB
				NewPetFrame Frame = new NewPetFrame(selectedOwner);
				Frame.setVisible(true);
				Frame.setLocationRelativeTo(null);
				Frame.setAlwaysOnTop(true);
			}
		});
		btnAddPet.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
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
							.addGap(6)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelRecords.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)))
						.addComponent(btnAddPet, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelRecords.setVerticalGroup(
				gl_panelRecords.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRecords.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelRecords.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
						.addGroup(gl_panelRecords.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panelRecords.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 232, Short.MAX_VALUE))))
					.addGap(42)
					.addGroup(gl_panelRecords.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewOwner)
						.addComponent(btnAddPet))
					.addContainerGap())
		);
		
		JLabel lblImmunizations = new JLabel("Immunizations:");
		lblImmunizations.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblRabies = new JLabel("Rabies:");
		lblRabies.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDistemper = new JLabel("Distemper:");
		lblDistemper.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblBordatella = new JLabel("Bordatella:");
		lblBordatella.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblDistemperDate_Records = new JLabel("Date");
		lblDistemperDate_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblBordatellaDate_Records = new JLabel("Date");
		lblBordatellaDate_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblRabiesDate_Records = new JLabel("Date");
		lblRabiesDate_Records.setForeground(Color.BLACK);
		lblRabiesDate_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnRabiesUpdate = new JButton("Update");
		btnRabiesUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) OwnerTree.getLastSelectedPathComponent();
			    if (node == null)
			    //Nothing is selected.     
			    return;
		
			    Object nodeInfo = node.getUserObject();
			    if (node.isLeaf()) {
			        Pet selectedPet = (Pet) nodeInfo;
			        DefaultMutableTreeNode Parent = (DefaultMutableTreeNode) node.getParent();
			        Owner selectedOwner = (Owner) Parent.getUserObject();
			        int OwnerID;
			        int PetID;
			        Immunization.ImmunizationType Rabies = Immunization.ImmunizationType.Rabies;
					try {
						OwnerID = selectedOwner.getID();
						PetID = selectedPet.getID(OwnerID);
						
						if(lblRabiesDate_Records.getText().compareTo("No Record") == 0){
				        	selectedPet.createImmunization(Rabies, PetID);
				        }
				        else{
				        	selectedPet.updateImmunization(Rabies, PetID);
				        }
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "Immunization could not be updated at this time.", "Error", JOptionPane.ERROR_MESSAGE);
					} 
			    }
			    windowGainedFocus();
			}
		});
		
		JButton btnDistemperUpdate = new JButton("Update");
		btnDistemperUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) OwnerTree.getLastSelectedPathComponent();
			    if (node == null)
			    //Nothing is selected.     
			    return;
		
			    Object nodeInfo = node.getUserObject();
			    if (node.isLeaf()) {
			        Pet selectedPet = (Pet) nodeInfo;
			        DefaultMutableTreeNode Parent = (DefaultMutableTreeNode) node.getParent();
			        Owner selectedOwner = (Owner) Parent.getUserObject();
			        int OwnerID;
			        int PetID;
			        Immunization.ImmunizationType Distemper = Immunization.ImmunizationType.Distemper;
					try {
						OwnerID = selectedOwner.getID();
						PetID = selectedPet.getID(OwnerID);
						
						if(lblDistemperDate_Records.getText().compareTo("No Record") == 0){
				        	selectedPet.createImmunization(Distemper, PetID);
				        }
				        else{
				        	selectedPet.updateImmunization(Distemper, PetID);
				        }
					} catch (SQLException e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "Immunization could not be updated at this time.", "Error", JOptionPane.ERROR_MESSAGE);
					} 
			    }
			    windowGainedFocus();
			}
		});
		
		JButton btnBordatellaUpdate = new JButton("Update");
		btnBordatellaUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) OwnerTree.getLastSelectedPathComponent();
			    if (node == null)
			    //Nothing is selected.     
			    return;
		
			    Object nodeInfo = node.getUserObject();
			    if (node.isLeaf()) {
			        Pet selectedPet = (Pet) nodeInfo;
			        DefaultMutableTreeNode Parent = (DefaultMutableTreeNode) node.getParent();
			        Owner selectedOwner = (Owner) Parent.getUserObject();
			        int OwnerID;
			        int PetID;
			        Immunization.ImmunizationType Bordatella = Immunization.ImmunizationType.Bordatella;
					try {
						OwnerID = selectedOwner.getID();
						PetID = selectedPet.getID(OwnerID);
						
						if(lblBordatellaDate_Records.getText().compareTo("No Record") == 0){
				        	selectedPet.createImmunization(Bordatella, PetID);
				        }
				        else{
				        	selectedPet.updateImmunization(Bordatella, PetID);
				        }
					} catch (SQLException e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "Immunization could not be updated at this time.", "Error", JOptionPane.ERROR_MESSAGE);
					} 
			    }
			    windowGainedFocus();
				
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDistemper)
								.addComponent(lblRabies)
								.addComponent(lblBordatella))
							.addGap(18)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(lblBordatellaDate_Records)
									.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
									.addComponent(btnBordatellaUpdate))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(lblRabiesDate_Records)
									.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
									.addComponent(btnRabiesUpdate))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(lblDistemperDate_Records)
									.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
									.addComponent(btnDistemperUpdate))))
						.addComponent(lblImmunizations))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblImmunizations)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRabies)
						.addComponent(lblRabiesDate_Records)
						.addComponent(btnRabiesUpdate))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDistemper)
						.addComponent(lblDistemperDate_Records)
						.addComponent(btnDistemperUpdate))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBordatella)
						.addComponent(lblBordatellaDate_Records)
						.addComponent(btnBordatellaUpdate))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		panel_2.setLayout(new BorderLayout(0, 0));

		panel_2.add(OwnerTree, BorderLayout.CENTER);

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

		lblDateOfBirth_Records = new JLabel("");
		lblDateOfBirth_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblWeight_Records = new JLabel("");
		lblWeight_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblColor_Records = new JLabel("");
		lblColor_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblSize_Records = new JLabel("");
		lblSize_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblSex_Records = new JLabel("");
		lblSex_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblType_Records = new JLabel("");
		lblType_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblPetName_Records = new JLabel("");
		lblPetName_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnEditPetRecords = new JButton("Edit");
		btnEditPetRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//grab currently selected owner
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) OwnerTree.getLastSelectedPathComponent();
				if (node == null)
					//Nothing is selected.     
					return;

				Object nodeInfo = node.getUserObject();
				Owner curOwner;
				Pet curPet;
				if (node.isLeaf()) {
					curPet = (Pet) nodeInfo;
					DefaultMutableTreeNode Parent = (DefaultMutableTreeNode) node.getParent();
					curOwner = (Owner) Parent.getUserObject();
				} else {
					return;
				}
				//open new frame to begin editing
				EditPetInfo Frame = new EditPetInfo(curOwner, curPet);
				Frame.setVisible(true);
				Frame.setLocationRelativeTo(null);
				Frame.setAlwaysOnTop(true);
			}
		});
		btnEditPetRecords.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblBreed = new JLabel("Breed:");
		lblBreed.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblPetBreed_Records = new JLabel("");
		lblPetBreed_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap(341, Short.MAX_VALUE)
						.addComponent(btnEditPetRecords, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDateOfBirth)
										.addComponent(lblWeight)
										.addComponent(lblColor)
										.addComponent(lblSize)
										.addComponent(lblSex)
										.addComponent(lblType)
										.addComponent(lblPet)
										.addComponent(lblBreed))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(lblPetBreed_Records)
												.addComponent(lblPetName_Records)
												.addComponent(lblType_Records)
												.addComponent(lblSex_Records)
												.addComponent(lblSize_Records)
												.addComponent(lblColor_Records)
												.addComponent(lblWeight_Records)
												.addComponent(lblDateOfBirth_Records))
												.addContainerGap(289, Short.MAX_VALUE))
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPet)
								.addComponent(lblPetName_Records))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblType)
										.addComponent(lblType_Records))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblSex)
												.addComponent(lblSex_Records))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblSize)
														.addComponent(lblSize_Records))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblColor)
																.addComponent(lblColor_Records))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
																		.addComponent(lblDateOfBirth)
																		.addComponent(lblDateOfBirth_Records))
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
																				.addComponent(lblWeight)
																				.addComponent(lblWeight_Records))
																				.addPreferredGap(ComponentPlacement.RELATED)
																				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
																						.addComponent(lblBreed)
																						.addComponent(lblPetBreed_Records))
																						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

		lblAddress_Records = new JLabel("");
		lblAddress_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblCity_Records = new JLabel("");
		lblCity_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblState_Records = new JLabel("");
		lblState_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblZip_Records = new JLabel("");
		lblZip_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblPhone_Records = new JLabel("");
		lblPhone_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblOwner_Records = new JLabel("");
		lblOwner_Records.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnEditOwnerRecords = new JButton("Edit");
		btnEditOwnerRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//grab currently selected owner
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) OwnerTree.getLastSelectedPathComponent();
				if (node == null)
					//Nothing is selected.     
					return;

				Object nodeInfo = node.getUserObject();
				Owner curOwner;
				if (node.isLeaf()) {
					DefaultMutableTreeNode Parent = (DefaultMutableTreeNode) node.getParent();
					curOwner = (Owner) Parent.getUserObject();
				} else {
					curOwner = (Owner) nodeInfo;
				}
				//open new frame to begin editing
				EditOwnerInfo Frame = new EditOwnerInfo(curOwner);
				Frame.setVisible(true);
				Frame.setLocationRelativeTo(null);
				Frame.setAlwaysOnTop(true);
			}
		});
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
										.addComponent(lblOwner_Records))
										.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblAddress)
														.addComponent(lblCity)
														.addComponent(lblState)
														.addComponent(lblZip)
														.addComponent(lblPhone))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																.addComponent(lblPhone_Records)
																.addComponent(lblZip_Records)
																.addComponent(lblState_Records)
																.addComponent(lblCity_Records)
																.addComponent(lblAddress_Records))))
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
								.addComponent(lblOwner_Records))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPhone)
										.addComponent(lblPhone_Records))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblAddress)
												.addComponent(lblAddress_Records))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblCity)
														.addComponent(lblCity_Records))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblState)
																.addComponent(lblState_Records))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
																		.addComponent(lblZip)
																		.addComponent(lblZip_Records))
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

	/**
	 * Load the appointments for the current week when the app is first started.  This function
	 * will initialize each appointments table, Monday through Sunday.
	 */
	public void loadAppointments() {

		Date date = calendarAppointments.getDate(); //< Selected Date on Appointments Calendar

		int nDayOfWeek = date.getDay();				//< Selected Date's Day of Week (i.e. 0 == Sunday, 1 == Monday, ...)

		if ( nDayOfWeek != 1 )
		{
			date.setDate( date.getDate() - ( nDayOfWeek - 1 ) );	//< Set the date to Monday
		}

		WeekAppointments.clear();		//< Reset the Week Appointment Table's data 

		while ( WeekAppointments.size() < 6 )
		{
			WeekAppointments.add( Appointment.getDayAppointments( date ) );
			date.setDate( date.getDate() + 1 ); //< Move on to the next day
		}

	} // end of function loadAppointments()


	/**
	 * Refresh the appointments for the current week after the application has been started.  This assumes the
	 * Tables have already been initialized
	 * @throws SQLException 
	 */
	public void refreshAppointments() throws SQLException {

		loadAppointments();

		if ( WeekAppointments.size() < 6 )
		{
			return;
		}

		/* Assign each Day's appointments to their appropriate day */
		Monday_Appointments = WeekAppointments.get( 0 );
		Tuesday_Appointments = WeekAppointments.get( 1 );
		Wednesday_Appointments = WeekAppointments.get( 2 );
		Thursday_Appointments = WeekAppointments.get( 3 );
		Friday_Appointments = WeekAppointments.get( 4 );
		Saturday_Appointments = WeekAppointments.get( 5 );


		/* Clear the data that was previosly loaded into the tables */
		Monday_Appointments_TableData.clear();
		Tuesday_Appointments_TableData.clear();
		Wednesday_Appointments_TableData.clear();
		Thursday_Appointments_TableData.clear();
		Friday_Appointments_TableData.clear();
		Saturday_Appointments_TableData.clear();


		/* Retrieve the needed data to populate the appointment tables for each day */
		Pet pet = new Pet(null, null, null, null, null, null, null, null, null, null, null);

		for ( int i = 0; i < Monday_Appointments.size(); i++ )
		{
			Vector<String> data = new Vector<String>();

			Appointment appointment = Monday_Appointments.get( i );

			data.add( pet.getName( appointment.nPetID ) );
			data.add( appointment.sTimeSelected );

			Monday_Appointments_TableData.add( data );
		}

		for ( int i = 0; i < Tuesday_Appointments.size(); i++ )
		{
			Vector<String> data = new Vector<String>();

			Appointment appointment = Tuesday_Appointments.get( i );

			data.add( pet.getName( appointment.nPetID ) );
			data.add( appointment.sTimeSelected );

			Tuesday_Appointments_TableData.add( data );
		}

		for ( int i = 0; i < Wednesday_Appointments.size(); i++ )
		{
			Vector<String> data = new Vector<String>();

			Appointment appointment = Wednesday_Appointments.get( i );

			data.add( pet.getName( appointment.nPetID ) );
			data.add( appointment.sTimeSelected );

			Wednesday_Appointments_TableData.add( data );
		}

		for ( int i = 0; i < Thursday_Appointments.size(); i++ )
		{
			Vector<String> data = new Vector<String>();

			Appointment appointment = Thursday_Appointments.get( i );

			data.add( pet.getName( appointment.nPetID ) );
			data.add( appointment.sTimeSelected );

			Thursday_Appointments_TableData.add( data );
		}

		for ( int i = 0; i < Friday_Appointments.size(); i++ )
		{
			Vector<String> data = new Vector<String>();

			Appointment appointment = Friday_Appointments.get( i );

			data.add( pet.getName( appointment.nPetID ) );
			data.add( appointment.sTimeSelected );

			Friday_Appointments_TableData.add( data );
		}

		for ( int i = 0; i < Saturday_Appointments.size(); i++ )
		{
			Vector<String> data = new Vector<String>();

			Appointment appointment = Saturday_Appointments.get( i );

			data.add( pet.getName( appointment.nPetID ) );
			data.add( appointment.sTimeSelected );

			Saturday_Appointments_TableData.add( data );
		}


		/* Refresh Monday Table */
		((DefaultTableModel) tableMonday_Appointments.getModel()).fireTableDataChanged(); 
		ColumnModel_Appointments = tableMonday_Appointments.getColumnModel();
		Column_Appointments = ColumnModel_Appointments.getColumn(1);
		Column_Appointments.setMinWidth(50);
		Column_Appointments.setMaxWidth(80);

		/* Refresh Tuesday Table */
		((DefaultTableModel) tableTuesday_Appointments.getModel()).fireTableDataChanged(); 
		ColumnModel_Appointments = tableTuesday_Appointments.getColumnModel();
		Column_Appointments = ColumnModel_Appointments.getColumn(1);
		Column_Appointments.setMinWidth(50);
		Column_Appointments.setMaxWidth(80);

		/* Refresh Wednesday Table */
		((DefaultTableModel) tableWednesday_Appointments.getModel()).fireTableDataChanged(); 
		ColumnModel_Appointments = tableWednesday_Appointments.getColumnModel();
		Column_Appointments = ColumnModel_Appointments.getColumn(1);
		Column_Appointments.setMinWidth(50);
		Column_Appointments.setMaxWidth(80);

		/* Refresh Thursday Table */
		((DefaultTableModel) tableThursday_Appointments.getModel()).fireTableDataChanged(); 
		ColumnModel_Appointments = tableWednesday_Appointments.getColumnModel();
		Column_Appointments = ColumnModel_Appointments.getColumn(1);
		Column_Appointments.setMinWidth(50);
		Column_Appointments.setMaxWidth(80);

		/* Refresh Friday Table */
		((DefaultTableModel) tableFriday_Appointments.getModel()).fireTableDataChanged(); 
		ColumnModel_Appointments = tableFriday_Appointments.getColumnModel();
		Column_Appointments = ColumnModel_Appointments.getColumn(1);
		Column_Appointments.setMinWidth(50);
		Column_Appointments.setMaxWidth(80);

		/* Refresh Saturday Table */
		((DefaultTableModel) tableSaturday_Appointments.getModel()).fireTableDataChanged(); 
		ColumnModel_Appointments = tableSaturday_Appointments.getColumnModel();
		Column_Appointments = ColumnModel_Appointments.getColumn(1);
		Column_Appointments.setMinWidth(50);
		Column_Appointments.setMaxWidth(80);

	} // end of function refreshAppointments()
	
	
	/**
	 * Updates the available times that can be selected when creating an appointment.
	 * @param timeBlockLength	- Given in minutes, sets how long a service is
	 * @param enable	- determines if the combo box for selecting times should be enabled or not
	 * @param tooltip	- String for the tool tip.
	 */
	public void updateAppointmentTimesAvailable( int timeBlockLength, boolean enable, String tooltip )
	{
		AppointmentTimesAvailable.clear();
		
		int nSelectedDay = calendarAppointments.getDate().getDay();

		if ( enable && nSelectedDay != 0 )
		{
			String sHour = "";
			String sMinute = "";
			int nHour = 8;
			int nMinute = 0;
			
			int start = 480; 	// 8:00 AM
			int end = 1080;  	// 6:00 PM
			
			if ( nSelectedDay == 6 )
			{
				start = 540;	// 9:00 AM
				end = 780; 		// 1:00 PM
			}
			
			for ( int i = start; i <= end - timeBlockLength; i += timeBlockLength )
			{
				nHour = ( i / 60 );
				nMinute = ( i % 60 );
				
				sHour = "" + nHour;
				sMinute = "" + nMinute;
				
				if ( nHour < 10 )
				{
					sHour = "0" + nHour;
				}
				
				if ( nMinute < 10 )
				{
					sMinute = "0" + nMinute;
				}
				
				AppointmentTimesAvailable.add( sHour + ":" + sMinute );
			}
		}
		else
		{
			AppointmentTimesAvailable.add("Select Time");
		}
		
		cbTime_Appointments.setModel(new DefaultComboBoxModel( AppointmentTimesAvailable ));
		
		if ( nSelectedDay == 0 )
		{
			cbTime_Appointments.setEnabled( false );
			cbTime_Appointments.setToolTipText( "Closed on Sunday" );
		}
		else
		{
			cbTime_Appointments.setEnabled( enable );
			cbTime_Appointments.setToolTipText( tooltip );
		}
		
	} // end of function updateAppointmentTimesAvailable

	/**
	 * Resets the UI for creating an appointment.  This will empty text fields, erase notes and remove
	 * any selected radio buttons.
	 */
	public void resetCreateAppointmentUI()
	{
		txtFirstName_Appointments.setText("");
		txtLastName_Appointments.setText("");
		txtPetName_Appointments.setText("");
		dtrpnNotes_Appointments.setText("Notes");
		updateAppointmentTimesAvailable(0, false, "Select Service");
		groupAppointmentServices.clearSelection();
		
	} // end of function resetCreateAppointmentUI()
	
	/**
	 * Updates the UI for viewing a specific appointment in the Appointments tab.
	 * @param appointment
	 */
	public void updateViewAppointment( Appointment appointment )
	{
		Pet pet = appointment.getPet();
		Owner owner = appointment.getOwner();
		
		Date date = appointment.getDateSelected();
		
		lblDateView_Appointment.setText("DATE:   "+ ( date.getMonth() + 2 ) + "-" + date.getDate() + "-" + ( date.getYear() + 1900 ) );
		
		Date dob = pet.getDOB();
		String sDOB = dob.getMonth() + "-" + dob.getDate() + "-" + ( dob.getYear() + 1900 );
		
		lblTimeView_Appointment.setText("TIME:   " + appointment.getTimeSelected() );
		editorPaneNotesView_Appointment.setText( "NOTES:   " + appointment.getNotes() );
		lblServiceView_Appointment.setText("SERVICE: " + appointment.getServiceName() );
		lblPetOwnerView_Appointment.setText(      	"Owner:    " + owner.getFullName().toUpperCase() );
		lblPetOwnerPhoneView_Appointment.setText( 	"Phone:    " + owner.getPhone().toUpperCase() );
		lblPetSexView_Appointment.setText(        	"Sex:        " + pet.getPetSex().toString().toUpperCase() );;
		lblPetBreedView_Appointment.setText( 		"Breed:    " + pet.getBreed().toUpperCase() );
		lblPetDOBView_Appointment.setText( 			"DOB:      " + sDOB.toUpperCase() );
		lblPetWeightView_Appointment.setText( 		"Weight:   " + pet.getWeight().toString().toUpperCase() + " lbs." );
		lblPetColorView_Appointment.setText( 		"Color:     " + pet.getColor().toUpperCase() );
		lblPetSizeView_Appointment.setText( 		"Size:       " + pet.getPetSize().toString().toUpperCase() );
		lblPetTypeView_Appointment.setText( 		"Type:      " + pet.getPetType().toString().toUpperCase() );
		lblPetNameView_Appointment.setText( 		"Pet:     " + pet.getName() );
		 
		btnDeleteApptView_Appointment.setEnabled(true);
		//lblRoomView_Appointment
		
	} // end of function updateViewAppointment()
	
	@Override
	public void windowGainedFocus(WindowEvent e) {
		OwnerTree.setModel(populateTree().getModel());
		ClearRecordLabels();
	}
	
	private double getItemPrice(String itemName){
		java.sql.Statement state = DBConnection.OpenConnection();
		String commandstring = "SELECT * FROM avalenti.Services WHERE Name = '" + itemName + "';";
		double itemPrice = 0.00;
		double taxRate = 0.00;
		if(state != null){
			try {
				ResultSet rs = state.executeQuery(commandstring);
				if(rs.next() == true) {
					itemPrice = Double.parseDouble(rs.getString("Cost"));
					taxRate = Double.parseDouble(rs.getString("Tax Rate"));
				}
				state.close();
			} catch (SQLException e) {
				System.err.println("Error in SQL Execution");
				}
		}
		else
			System.err.println("Statement was null.  No connection?");
		
		return itemPrice * taxRate;
	
	}
	
	private void updateTicket(String itemName, double itemPrice){
		DefaultTableModel model = (DefaultTableModel) servicesTable.getModel();
		model.addRow(new Object[]{itemName, df.format(itemPrice)});
	}
	
	private double getCurrentTotal(){
		String totalText = lblTotal.getText();
		String[] totalSplit = totalText.split("\\$");
		return Double.parseDouble(totalSplit[1]);
	}
	
	private void updateTotal(String itemName){
		double itemPrice = getItemPrice(itemName);
		updateTicket(itemName, itemPrice);
		double currentTotal = getCurrentTotal();
		currentTotal += itemPrice;
		lblTotal.setText("$" + df.format(currentTotal));
	}
	
	private void updateTotal(String itemName, int daysBoarded){
		if(daysBoarded != 0){
			double itemPrice = getItemPrice(itemName)*daysBoarded;
			updateTicket(itemName, itemPrice);
			double currentTotal = getCurrentTotal();
			currentTotal += itemPrice;
			lblTotal.setText("$" + df.format(currentTotal));
		}
		textFieldDaysBoarded_Sales.setText("0");
	}
	
	public void windowGainedFocus() {
		OwnerTree.setModel(populateTree().getModel());
		ClearRecordLabels();
	}

	@Override
	public void windowLostFocus(WindowEvent e) {

	}
}
