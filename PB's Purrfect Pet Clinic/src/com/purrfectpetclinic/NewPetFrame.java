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
import java.util.Date;

import com.toedter.calendar.JBoardingDateChooser;
import com.toedter.calendar.JDateChooser;


public class NewPetFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPetName;
	private JTextField txtPetColor;
	private JTextField txtPetWeight;
	private JTextField txtPetBreed;
	private JTextField txtPetPrescriptions;
	private JComponent DateChooser;

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
		setBounds(100, 100, 450, 600);
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
				
				
				//create and add pet to DB
				Pet newPet = new Pet(Type, Name, owner.getFullName(), Sex, Size, Color, DOB, Prescriptions, Double.valueOf(WeightString), Breed, Notes);
				try {
					newPet.addPetDB();
					dispose();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(contentPane, "Could not add Pet at this time.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		DateChooser = new JDateChooser();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPrescriptions)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPetPrescriptions, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
						.addComponent(lblNotes)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCancel)
							.addPreferredGap(ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
							.addComponent(btnAddPet))
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
								.addComponent(cboPetType, 0, 335, Short.MAX_VALUE)
								.addComponent(cboPetSex, 0, 335, Short.MAX_VALUE)
								.addComponent(txtPetName, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
								.addComponent(cboPetSize, Alignment.TRAILING, 0, 335, Short.MAX_VALUE)
								.addComponent(txtPetColor, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
								.addComponent(DateChooser, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
								.addComponent(txtPetWeight, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
								.addComponent(txtPetBreed, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))))
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnAddPet))
					.addContainerGap())
		);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel.add(txtPetNotes, BorderLayout.CENTER);
		contentPane.setLayout(gl_contentPane);
	}
}
