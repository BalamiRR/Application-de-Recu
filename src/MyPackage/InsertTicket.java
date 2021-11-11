package MyPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class InsertTicket {

	private JFrame frame;
	private JTextField text_siret_no;
	private JTextField text_nom_societe;
	private JComboBox combo_depart;
	private JTextField text_description;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox combo_type;
	private JLabel lblNewLabel_2;
	private JTextField text_adresse;
	private JLabel lblNewLabel_3;
	private JTextField text_code_postal;
	private JLabel lblNewLabel_4;
	private JTextField text_montant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertTicket window = new InsertTicket();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InsertTicket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	try {	
		frame = new JFrame();
		frame.setBounds(100, 100, 767, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		text_siret_no = new JTextField();
		text_siret_no.setBounds(494, 64, 167, 36);
		frame.getContentPane().add(text_siret_no);
		text_siret_no.setColumns(10);
		
		text_nom_societe = new JTextField();
		text_nom_societe.setBounds(127, 64, 167, 36);
		frame.getContentPane().add(text_nom_societe);
		text_nom_societe.setColumns(10);
		

		JComboBox combo_ville = new JComboBox();
		combo_ville.setBounds(127, 132, 167, 33);
		frame.getContentPane().add(combo_ville);
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JAVADATA;integratedSecurity=true;");
		Statement stm = connection.createStatement();
		
		ResultSet rs = stm.executeQuery("Select NomVille from Ville");
		
		while(rs.next()) {
			String name = rs.getString("NomVille");
			combo_ville.addItem(name);
			
			}
		}catch (Exception b) {
			JOptionPane.showMessageDialog(null, b);
		}
		
		combo_depart = new JComboBox();
		combo_depart.setBounds(494, 132, 167, 33);
		frame.getContentPane().add(combo_depart);
		
		text_description = new JTextField();
		text_description.setBounds(192, 279, 404, 36);
		frame.getContentPane().add(text_description);
		text_description.setColumns(10);
		
		lblNewLabel = new JLabel("Montant");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(114, 202, 84, 21);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(429, 200, 55, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		combo_type = new JComboBox();
		combo_type.setBounds(494, 200, 102, 35);
		frame.getContentPane().add(combo_type);
		
		lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(80, 282, 102, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		text_adresse = new JTextField();
		text_adresse.setBounds(483, 354, 113, 36);
		frame.getContentPane().add(text_adresse);
		text_adresse.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Code Postal");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(77, 354, 121, 36);
		frame.getContentPane().add(lblNewLabel_3);
		
		text_code_postal = new JTextField();
		text_code_postal.setBounds(192, 354, 113, 36);
		frame.getContentPane().add(text_code_postal);
		text_code_postal.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Adresse");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(396, 354, 84, 29);
		frame.getContentPane().add(lblNewLabel_4);
		
		text_montant = new JTextField();
		text_montant.setBounds(192, 199, 102, 36);
		frame.getContentPane().add(text_montant);
		text_montant.setColumns(10);
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(80, 409, 157, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(511, 409, 150, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Nom");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(61, 65, 65, 25);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Siret No");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(410, 54, 89, 47);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Ville");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(61, 138, 70, 21);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Departement");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(369, 132, 130, 33);
		frame.getContentPane().add(lblNewLabel_8);
	}
}
