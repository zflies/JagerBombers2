import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.awt.Font;
import java.sql.SQLException;


public class EditOwnerInfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtZip;
	private JTextField txtPhone;
	private Owner OldOwner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditOwnerInfo frame = new EditOwnerInfo(new Owner("Alex", "Valentine", "4501 Wimbledon Dr.", "Lawrence", "KS", "66047", "(913)302-0754"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private boolean checkInput() throws Exception{
		if(txtFirstName.getText().compareTo("") == 0 || txtLastName.getText().compareTo("") == 0
				|| txtAddress.getText().compareTo("") == 0 || txtCity.getText().compareTo("") == 0
				|| txtState.getText().compareTo("") == 0 || txtZip.getText().compareTo("") == 0 
				|| txtPhone.getText().compareTo("") == 0){
			throw new Exception("All fields are required");
		}
		return true;
	}

	/**
	 * Create the frame.
	 */
	public EditOwnerInfo(final Owner OldOwner) {
		this.OldOwner = OldOwner;
		setTitle("Edit Owner");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblState = new JLabel("State:");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblZip = new JLabel("Zip:");
		lblZip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSaveOwner = new JButton("Save");
		btnSaveOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					checkInput();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				String FirstName = txtFirstName.getText();
				String LastName = txtLastName.getText();
				String Address = txtAddress.getText();
				String City = txtCity.getText();
				String State = txtState.getText();
				String Zip = txtZip.getText();
				String Phone = txtPhone.getText();
				
				Owner newOwner = new Owner(FirstName, LastName, Address, City, State, Zip, Phone);
					try {
						newOwner.replaceOwner(OldOwner);
						dispose();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(contentPane, "Could not save Owner at this time.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
			}
		});
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		
		txtState = new JTextField();
		txtState.setColumns(10);
		
		txtZip = new JTextField();
		txtZip.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		
		JButton btnDeleteOwner = new JButton("Delete");
		btnDeleteOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					OldOwner.deleteOwner();
					dispose();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(contentPane, "Could not delete Owner at this time.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblFirstName)
							.addGap(18)
							.addComponent(txtFirstName, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLastName)
								.addComponent(lblAddress)
								.addComponent(lblCity)
								.addComponent(lblState)
								.addComponent(lblZip))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtAddress, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
								.addComponent(txtLastName, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
								.addComponent(txtCity, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
								.addComponent(txtState, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
								.addComponent(txtZip, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
								.addComponent(txtPhone, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCancel)
							.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
							.addComponent(btnDeleteOwner)
							.addGap(108)
							.addComponent(btnSaveOwner))
						.addComponent(lblPhone))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName)
						.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCity)
						.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblState)
						.addComponent(txtState, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZip)
						.addComponent(txtZip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhone)
						.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnSaveOwner)
						.addComponent(btnDeleteOwner))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		//populate boxes with oldOwner info
		txtFirstName.setText(this.OldOwner.getFirstName());
		txtLastName.setText(this.OldOwner.getLastName());
		txtAddress.setText(this.OldOwner.getAddress());
		txtCity.setText(this.OldOwner.getCity());
		txtState.setText(this.OldOwner.getState());
		txtZip.setText(this.OldOwner.getZip());
		txtPhone.setText(this.OldOwner.getPhone());
	}
}
