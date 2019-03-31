package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * This is the class CalculatorGui
 * When called this will be the interface for the client class it will be where the user can do there calculations 
 * 
 */

public class CalculatorGui {

	public JFrame client;
	// Text area to display contents
		public JTextArea outputArea_top;
		public JTextArea outputArea_bottom;
	//Buttons for the number 
		public  JButton B_zero;
		public  JButton B_one;
		public JButton B_two;
		public JButton B_three;
		public JButton B_four;
		public JButton B_five;
		public JButton B_six;
		public JButton B_seven;
		public JButton B_eight;
		public JButton B_nine;
	
	//Buttons for the math functions 
		public JButton B_add;
		public JButton B_subtract;
		public JButton B_multi;
		public JButton B_divide;
		
	
	//Buttons for the functions 
		public JButton submit, clear, exit,delete;	
	
		public JScrollPane scroll;
	
	public CalculatorGui() {
		calculator();
	}
	
	private void calculator() {
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
		} // This line gives Windows Theme
				
		client = new JFrame("Calculator"); // client is the name of the JFrame 

		B_zero = new JButton("0");
		B_one = new JButton("1");
		B_two = new JButton("2");
		B_three = new JButton("3");
		B_four = new JButton("4");
		B_five = new JButton("5");
		B_six = new JButton("6");
		B_seven = new JButton("7");
		B_eight = new JButton("8");
		B_nine = new JButton("9");
		
		B_add = new JButton("+");
		B_subtract = new JButton("-");
		B_multi = new JButton("x");
		B_divide = new JButton("/");
		
		submit = new JButton("Submit");
		clear = new JButton("Clear");
		delete = new JButton("Delete");
		exit = new JButton("Exit");

		outputArea_top =new JTextArea();
		outputArea_top.setFont(new Font("Arial", Font.PLAIN, 10));
		
		outputArea_bottom =new JTextArea();
		outputArea_bottom.setFont(new Font("Arial", Font.PLAIN, 10));
		scroll = new JScrollPane(outputArea_bottom);
		
		client.add(outputArea_top).setBounds(30,40,250,50);
		
		// first row
		client.add(B_divide).setBounds(40,100,50,40);
		client.add(B_seven).setBounds(100,100,50,40);
		client.add(B_eight).setBounds(160,100,50,40);
		client.add(B_nine).setBounds(220,100,50,40);
		
		//second row 
		client.add(B_multi).setBounds(40,150,50,40);
		client.add(B_four).setBounds(100,150,50,40);
		client.add(B_five).setBounds(160,150,50,40);
		client.add(B_six).setBounds(220,150,50,40);
		
		//third row 
		client.add(B_subtract).setBounds(40,200,50,40);
		client.add(B_one).setBounds(100,200,50,40);
		client.add(B_two).setBounds(160,200,50,40);
		client.add(B_three).setBounds(220,200,50,40);
		
		//forth row 
		client.add(B_add).setBounds(40,250,50,40);
		client.add(B_zero).setBounds(100,250,50,40);
		client.add(clear).setBounds(160,250,110,40);
		//fifth row
		//client.add(delete).setBounds(40,310,110,40);
		client.add(submit).setBounds(40,310,230,40);
		
		//sixth row 
		//client.add(outputArea_bottom).setBounds(30,360,250,150);
		//client.add(exit).setBounds(200,510,80,40);
		client.add(new JScrollPane(outputArea_bottom)).setBounds(30,360,250,150);; // this is the main text area that will show responses  
		outputArea_bottom.setEditable(false);
		outputArea_top.setEditable(false);
		client.setLayout(null);
		client.setSize(310,600);
		client.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		client.setResizable(false);
		client.setVisible(true);

	}
	public static void main(String...s)
	{
		new CalculatorGui();
	}
}
