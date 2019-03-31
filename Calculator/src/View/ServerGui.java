package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import Controller.Client;

public class ServerGui {
	/*
	 * FIELDS
	 */
	public JFrame server;
	public static JButton start;
	public JScrollPane scroll;
	public JTextArea outputArea;
	public ServerGui(){
		// this will start the Gui that is created in the method Run 
		Run();
	}

	private void Run() {
		/*
		 * THEME
		 */
		try {
			// This is the team of the GUI
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} //
		server = new JFrame("Server"); // client is the name of the JFrame 
		start = new JButton("Start Client");
	
		outputArea =new JTextArea();
		server.setLayout(new BorderLayout());
		outputArea.setFont(new Font("Arial", Font.PLAIN, 10));
		outputArea.setEditable(false);
		//scroll = new JScrollPane(outputArea);
		server.add(start).setBounds(10,400,280,50);
		server.add( new JScrollPane(outputArea)).setBounds(30,30,250,350);
		outputArea.setFont(new Font("Arial", Font.PLAIN, 10));
		outputArea.setEditable(false);
		server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				server.setLayout(null);
				server.setSize(310,500);
				server.setResizable(false);
				start.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						Client.main(null);
						outputArea.append("New Client started \n");
						}
						catch (Exception e1) {
							System.out.println("New Client exception: " + e1);
						}
					}
				});
				server.setVisible(true);
				
	}

	public void Message(String string) {
		// TODO Auto-generated method stub
		outputArea.setText(outputArea.getText() + "\n" + string);
	}
}
