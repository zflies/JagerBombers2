package com.purrfectpetclinic;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.toedter.calendar.JBoardingDateChooser;
import com.toedter.calendar.JDateChooser;

import javax.swing.JCheckBox;


public class NewPetFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPetName;
	private JTextField txtPetColor;
	private JTextField txtPetWeight;
	private JTextField txtPetBreed;
	private JTextField txtPetPrescriptions;
	private JComponent DateChooser;
	
	private JCheckBox chckbxImmunization;
	private JCheckBox chckbxWellnessVisit;
	private JCheckBox chckbxLabWork;
	private JComboBox comboBoxImmunization;
	private JComboBox comboBoxWellness;
	private JComboBox comboBoxLabWork;
	
	private JCheckBox chckbxEmailImmunization;
	private JCheckBox chckbxTextImmunization;
	private JCheckBox chckbxPostcardImmunization;
	private JCheckBox chckbxEmailWellness;
	private JCheckBox chckbxTextWellness;
	private JCheckBox chckbxPostcardWellness;
	private JCheckBox chckbxEmailLabWork;
	private JCheckBox chckbxTextLabWork;
	private JCheckBox chckbxPostcardLabWork;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPetFrame frame = new NewPetFrame(new Owner("Alex", "Valentine", "4501 Wimbledon Dr.", "Lawrence", "KS", "66047", "(913)302-0754"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private boolean checkInput() throws Exception{
		if(txtPetName.getText().compareTo("") == 0 || txtPetColor.getText().compareTo("") == 0 
				|| txtPetWeight.getText().compareTo("") == 0 || txtPetBreed.getText().compareTo("") == 0){
			throw new Exception("All fields are required");
		}
		
		return true;
	}

	/**
	 * Create the frame.
	 */
	public NewPetFrame(final Owner owner) {
		setTitle("Add a Pet");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 887);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblType = new JLabel("Type:");
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblSex = new JLabel("Sex:");
		
		JLabel lblSize = new JLabel("Size:");
		
		JLabel lblColor = new JLabel("Color:");
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		
		JLabel lblWeight = new JLabel("Weight:");
		
		JLabel lblBreed = new JLabel("Breed:");
		
		JLabel lblPrescriptions = new JLabel("Prescriptions:");
		
		JLabel lblNotes = new JLabel("Notes:");
		
		final JComboBox cboPetType = new JComboBox();
		cboPetType.setModel(new DefaultComboBoxModel(new String[] {"dog", "cat"}));
		
		txtPetName = new JTextField();
		txtPetName.setColumns(10);
		
		final JComboBox cboPetSex = new JComboBox();
		cboPetSex.setModel(new DefaultComboBoxModel(new String[] {"male", "female"}));
		
		final JComboBox cboPetSize = new JComboBox();
		cboPetSize.setModel(new DefaultComboBoxModel(new String[] {"small", "medium", "large"}));
		
		txtPetColor = new JTextField();
		txtPetColor.setColumns(10);
		
		txtPetWeight = new JTextField();
		txtPetWeight.setColumns(10);
		
		txtPetBreed = new JTextField();
		txtPetBreed.setColumns(10);
		
		txtPetPrescriptions = new JTextField();
		txtPetPrescriptions.setColumns(10);
		
		final JTextArea txtPetNotes = new JTextArea();
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnAddPet = new JButton("Add Pet");
		btnAddPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					checkInput();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				String TypeString = (String) cboPetType.getSelectedItem();
				Pet.Type Type;
				if(TypeString.compareTo("cat") == 0)
					Type = Pet.Type.cat;
				else
					Type = Pet.Type.dog;
				String Name = txtPetName.getText();
				String SexString = (String) cboPetSex.getSelectedItem();
				Pet.Sex Sex;
				if(SexString.compareTo("male") == 0)
					Sex = Pet.Sex.male;
				else
					Sex = Pet.Sex.female;
				String SizeString = (String) cboPetSize.getSelectedItem();
				Pet.Size Size;
				if(SizeString.compareTo("small") == 0)
					Size = Pet.Size.small;
				else if(SizeString.compareTo("medium") == 0)
					Size = Pet.Size.medium;
				else
					Size = Pet.Size.large;
				String Color = txtPetColor.getText();
				String WeightString = txtPetWeight.getText();
				String Prescriptions = txtPetPrescriptions.getText();
				String Notes = txtPetNotes.getText();
				String Breed = txtPetBreed.getText();
				Date DOB = ((JDateChooser) DateChooser).getDateEditor().getDate();
				
				List<String> immunizationReminder = new ArrayList<String> ();
				List<String> wellnessReminder = new ArrayList<String> ();
				List<String> labReminder = new ArrayList<String> ();
				
				if(chckbxImmunization.isSelected()){
					if(chckbxEmailImmunization.isSelected()){
						immunizationReminder.add("email");
					}
					if(chckbxTextImmunization.isSelected()){
						immunizationReminder.add("text");		
					}
					if(chckbxPostcardImmunization.isSelected()){
						immunizationReminder.add("postcard");
					}
					int index = comboBoxImmunization.getSelectedIndex();
					if(index == 0){
						immunizationReminder.add("oneWeek");
					}
					else if(index == 1){
						immunizationReminder.add("twoWeeks");
					}
					else{
						immunizationReminder.add("oneMonth");
					}
				}
				
				if(chckbxWellnessVisit.isSelected()){
					if(chckbxEmailWellness.isSelected()){
						wellnessReminder.add("email");
					}
					if(chckbxTextWellness.isSelected()){
						wellnessReminder.add("text");		
					}
					if(chckbxPostcardWellness.isSelected()){
						wellnessReminder.add("postcard");
					}
					int index = comboBoxWellness.getSelectedIndex();
					if(index == 0){
						wellnessReminder.add("oneWeek");
					}
					else if(index == 1){
						wellnessReminder.add("twoWeeks");
					}
					else{
						wellnessReminder.add("oneMonth");
					}
				}
				
				if(chckbxLabWork.isSelected()){
					if(chckbxEmailLabWork.isSelected()){
						labReminder.add("email");
					}
					if(chckbxTextLabWork.isSelected()){
						labReminder.add("text");		
					}
					if(chckbxPostcardLabWork.isSelected()){
						labReminder.add("postcard");
					}
					int index = comboBoxLabWork.getSelectedIndex();
					if(index == 0){
						labReminder.add("oneWeek");
					}
					else if(index == 1){
						labReminder.add("twoWeeks");
					}
					else{
						labReminder.add("oneMonth");
					}
				}
				
				
				//create and add pet to DB
				Pet newPet = new Pet(Type, Name, owner.getFullName(), Sex, Size, Color, DOB, Prescriptions, Double.valueOf(WeightString), Breed, Notes);
				try {
					newPet.addPetDB();
					newPet.addReminders(immunizationReminder, wellnessReminder, labReminder);
					dispose();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(contentPane, "Could not add Pet at this time.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		DateChooser = new JDateChooser();
		
		JLabel lblReminders = new JLabel("Reminders:");
		
		chckbxImmunization = new JCheckBox("Immunization");
		
		chckbxEmailImmunization = new JCheckBox("Email");
		
		chckbxTextImmunization = new JCheckBox("Text");
		
		chckbxPostcardImmunization = new JCheckBox("Postcard");
		
		comboBoxImmunization = new JComboBox(new DefaultComboBoxModel(new String[] {"1 Week", "2 Weeks", "1 Month"}));
		
		chckbxWellnessVisit = new JCheckBox("Wellness Visit");
		
		chckbxEmailWellness = new JCheckBox("Email");
		
		chckbxTextWellness = new JCheckBox("Text");
		
		chckbxPostcardWellness = new JCheckBox("Postcard");
		
		comboBoxWellness = new JComboBox(new DefaultComboBoxModel(new String[] {"1 Week", "2 Weeks", "1 Month"}));
		
		chckbxLabWork = new JCheckBox("Lab Work");
		
		chckbxEmailLabWork = new JCheckBox("Email");
		
		chckbxTextLabWork = new JCheckBox("Text");
		
	    chckbxPostcardLabWork = new JCheckBox("Postcard");
		
		comboBoxLabWork = new JComboBox(new DefaultComboBoxModel(new String[] {"1 Week", "2 Weeks", "1 Month"}));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPrescriptions)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtPetPrescriptions, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
								.addComponent(lblNotes)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDateOfBirth)
										.addComponent(lblColor)
										.addComponent(lblWeight)
										.addComponent(lblBreed)
										.addComponent(lblName)
										.addComponent(lblSex)
										.addComponent(lblType)
										.addComponent(lblSize))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(cboPetType, 0, 345, Short.MAX_VALUE)
										.addComponent(cboPetSex, 0, 345, Short.MAX_VALUE)
										.addComponent(txtPetName, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
										.addComponent(cboPetSize, Alignment.TRAILING, 0, 345, Short.MAX_VALUE)
										.addComponent(txtPetColor, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
										.addComponent(DateChooser, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
										.addComponent(txtPetWeight, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
										.addComponent(txtPetBreed, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCancel)
							.addPreferredGap(ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
							.addComponent(btnAddPet))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblReminders))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addComponent(chckbxEmailImmunization)
									.addGap(18)
									.addComponent(chckbxTextImmunization)
									.addGap(18)
									.addComponent(chckbxPostcardImmunization))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(chckbxImmunization)
									.addPreferredGap(ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
									.addComponent(comboBoxImmunization, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addComponent(chckbxEmailWellness)
									.addGap(18)
									.addComponent(chckbxTextWellness)
									.addGap(18)
									.addComponent(chckbxPostcardWellness)
									.addGap(115))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(chckbxWellnessVisit)
									.addPreferredGap(ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
									.addComponent(comboBoxWellness, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addComponent(chckbxEmailLabWork)
									.addGap(18)
									.addComponent(chckbxTextLabWork)
									.addGap(18)
									.addComponent(chckbxPostcardLabWork))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(chckbxLabWork)
									.addPreferredGap(ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
									.addComponent(comboBoxLabWork, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType)
						.addComponent(cboPetType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(txtPetName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSex)
						.addComponent(cboPetSex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSize)
						.addComponent(cboPetSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblColor)
						.addComponent(txtPetColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDateOfBirth)
						.addComponent(DateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWeight)
						.addComponent(txtPetWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBreed)
						.addComponent(txtPetBreed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrescriptions)
						.addComponent(txtPetPrescriptions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNotes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblReminders)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxImmunization)
						.addComponent(comboBoxImmunization, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxEmailImmunization)
						.addComponent(chckbxTextImmunization)
						.addComponent(chckbxPostcardImmunization))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxWellnessVisit)
						.addComponent(comboBoxWellness, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxEmailWellness)
						.addComponent(chckbxTextWellness)
						.addComponent(chckbxPostcardWellness))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxLabWork)
						.addComponent(comboBoxLabWork, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxEmailLabWork)
						.addComponent(chckbxTextLabWork)
						.addComponent(chckbxPostcardLabWork))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCancel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAddPet)
							.addContainerGap())))
		);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel.add(txtPetNotes, BorderLayout.CENTER);
		contentPane.setLayout(gl_contentPane);
	}
}
