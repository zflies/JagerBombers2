package com.purrfectpetclinic;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;


public class CashPaymentDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textFieldCash;
	private JLabel lblChangeAmount;
	private DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Create the dialog.
	 */
	public CashPaymentDialog(final double currentTotal) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblTotalAmount = new JLabel(df.format(currentTotal));
		lblTotalAmount.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblCash = new JLabel("Cash:");
		lblCash.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		textFieldCash = new JTextField();
		textFieldCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Get total amount and get it to double
				 * Make sure amount user enters here is greater than or equal to it
				 * Update Change field with difference
				 */
				double cashTendered = Double.parseDouble(textFieldCash.getText());
				if(cashTendered > currentTotal){
					lblChangeAmount.setText(df.format(cashTendered - currentTotal));
					okButton.setEnabled(true);
				}
			}
		});
		textFieldCash.setColumns(10);
		
		JLabel lblChange = new JLabel("Change:");
		lblChange.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		lblChangeAmount = new JLabel("$0.00");
		lblChangeAmount.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(152)
							.addComponent(lblTotal)
							.addGap(18)
							.addComponent(lblTotalAmount))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(107)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblChange)
									.addGap(18)
									.addComponent(lblChangeAmount))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblCash)
									.addGap(36)
									.addComponent(textFieldCash, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalAmount)
						.addComponent(lblTotal))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCash, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCash))
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChange)
						.addComponent(lblChangeAmount))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Pay");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(contentPanel, "Transaction Completed!");
						dispose();
					}
				});
				okButton.setEnabled(false);
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(6)
						.addComponent(cancelButton)
						.addGap(283)
						.addComponent(okButton))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
							.addComponent(cancelButton)
							.addComponent(okButton)))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}
	
	
}
