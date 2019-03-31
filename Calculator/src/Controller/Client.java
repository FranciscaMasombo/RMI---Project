package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Model.Calculator;
import View.CalculatorGui;

/*
 * @author Francisca Masombo
 *
 *this is the class Client 
 *Fields
 * view
 * x
 * y
 * currentFunction
 * calculator
 * 
 *Constructor:
 *  public Client()
 *  
 *Methods 
 *  public static void main(String[] args)
 *  protected void submit(String currentFunction2)
 *  private void calculate(String s)
 *  protected void functionInput(String i)
 *  protected void delete()
 *  protected void clear()
 *  protected void Input(String i)
 */
public class Client {

	/*
	 * FIELDS
	 ****************************************************************
	 */
	private CalculatorGui view; // the calculator gui
	private double answer = 0.0; // all the answers when are done
	private String x = ""; // numbers before the function
	private String y = ""; // numbers after the function
	private String currentFunction = ""; // the current function
	private static Calculator calculator = null; // object calculator

	/**
	 * 
	 * Main Method will start the GUI
	 */
	public static void main(String[] args) {
		new Client();
	}

	/*
	 * Constructor
	 */
	public Client() {
		view = new CalculatorGui();
		ButtonClicked(); // this is the method with all the buttons
		view.outputArea_bottom.append("Start using the calculater \n");
	}

	/*
	 * This method is going to listen to the button clicked and then perform an
	 * action BUTTONS add button 0 to 9
	 * 
	 */
	private void ButtonClicked() {

		/**
		 * Numbers 0 to 9
		 */
		view.B_zero.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Input("0");

			}

		});
		view.B_one.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Input("1");

			}

		});
		view.B_two.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Input("2");

			}

		});
		view.B_three.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Input("3");

			}

		});
		view.B_four.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Input("4");

			}

		});
		view.B_five.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Input("5");

			}

		});
		view.B_six.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Input("6");

			}

		});
		view.B_seven.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Input("7");

			}

		});
		view.B_eight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Input("8");

			}

		});
		view.B_nine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Input("9");

			}

		});

		/*
		 * These are the functions + , * , / , -
		 */

		view.B_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				functionInput("+");

			}

		});
		view.B_subtract.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				functionInput("-");

			}

		});
		view.B_multi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				functionInput("*");

			}

		});
		view.B_divide.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				functionInput("/");

			}

		});

		/*
		 * These are the the buttons
		 */

		view.submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				submit(currentFunction);

			}

		});
		view.clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clear();
				view.outputArea_top.setText("");
			}

		});
		view.delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				delete();

			}

		});

	}

	private void calculate(String s) {

		try {
			// Calculator is the interface in the package model
			calculator = (Calculator) Naming.lookup("//" + "localhost" + "/Calculator");
			switch (s) {
			case "add":
				answer = calculator.add(Integer.parseInt(x), Integer.parseInt(y));
				// this will print to the output area
				view.outputArea_bottom.append(Integer.parseInt(x) + " + " + Integer.parseInt(y));
				break;
			case "subtract":
				answer = calculator.subtract(Integer.parseInt(x), Integer.parseInt(y));
				// this will print to the output area
				view.outputArea_bottom.append(Integer.parseInt(x) + " - " + Integer.parseInt(y));
				break;
			case "multi":
				answer = calculator.multiply(Integer.parseInt(x), Integer.parseInt(y));
				// this will print to the output area
				view.outputArea_bottom.append(Integer.parseInt(x) + " * " + Integer.parseInt(y));
				break;
			case "div":
				answer = calculator.divide(Integer.parseInt(x), Integer.parseInt(y));
				// this will print to the output area
				view.outputArea_bottom.append(Integer.parseInt(x) + " / " + Integer.parseInt(y));
				break;
			}
			view.outputArea_bottom.append("Result from server: " + answer + "\n");
			// view.outputArea_top.append(answer);
			clear();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			view.outputArea_bottom.append("Error:" + "\n");
			view.outputArea_bottom.append(e.getMessage() + "\n");
			view.outputArea_bottom.append("Please check that you have entered a number then a function then a number");
			e.printStackTrace();

		}
	}

	/*
	 * In the method we will need to check that a valid number is entered this
	 * method will send back to the server
	 */
	protected void submit(String currentFunction2) {
		if (!x.isEmpty() && !y.isEmpty() && !currentFunction.isEmpty()) {
			view.outputArea_bottom.append("To server:  \\n");
			switch (currentFunction2) {
			case "+":
				calculate("add");
				break;
			case "-":
				calculate("subtract");
				break;
			case "*":
				calculate("multi");
				break;
			case "/":
				calculate("div");
				break;
			}
		} else {
			view.outputArea_bottom
					.append("Please check the input you need to have a number, a fuction and another number \n");
		}

	}

	protected void functionInput(String i) {

		if (x.length() > 0 && currentFunction.isEmpty()) {
			view.outputArea_top.setText(x + i);
			currentFunction = i;
		} else if (!currentFunction.isEmpty()) { // ensure only one operator
			view.outputArea_bottom.append("One fuction per calculation \n");
		} else {
			view.outputArea_bottom.append("No Number has been entered \n");
		}
	}

	protected void delete() {
		view.outputArea_top.setText("");

	}

	/*
	 * will clear all the fields
	 */
	protected void clear() {
		x = "";
		y = "";
		currentFunction = "";

	}

	protected void Input(String i) {
		if (x.length() < 7 && currentFunction.isEmpty()) {
			view.outputArea_top.setText(x + i);
			x += i;
		} else if (y.length() < 7 && !currentFunction.isEmpty()) {
			y += i;
			// will add the number x and the function and then the number y to the top of
			// the calculater
			view.outputArea_top.setText(x + currentFunction + y);
		}

	}

}
