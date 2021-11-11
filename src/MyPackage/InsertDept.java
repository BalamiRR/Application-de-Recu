package MyPackage;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class InsertDept {

	private JFrame frame;
	private JTextField NomDepartement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertDept window = new InsertDept();
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
	public InsertDept() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		NomDepartement = new JTextField();
		NomDepartement.setBounds(56, 62, 133, 21);
		frame.getContentPane().add(NomDepartement);
		NomDepartement.setColumns(10);

		JButton sendButton = new JButton("Insert");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JAVADATA;integratedSecurity=true;");
					String query ="INSERT INTO Departement (NomDepartement) Values(?)";
					PreparedStatement prepared = connection.prepareStatement(query);
					prepared.setString(1, NomDepartement.getText());
					prepared.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserted Succesfully");
				}catch (Exception b) {
					JOptionPane.showMessageDialog(null, b);
				}	
			}
		});
		sendButton.setBounds(230, 62, 85, 21);
		frame.getContentPane().add(sendButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		resetButton.setBounds(325, 62, 85, 21);
		frame.getContentPane().add(resetButton);
	}
}

