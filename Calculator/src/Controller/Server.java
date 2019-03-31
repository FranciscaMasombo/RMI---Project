package Controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

import Model.Calculator;
import View.ServerGui;

/*
 * @Author: Francisca Masombo
 * @Date: 31/3/2019
 * @Classname: Server.java
 * @Description: this is the RMI server for the calculator application
 * 
 * Fields
 *  serialVersionUID
 *  view
 *  
 * methods 
 *   public static void main(String args[])
 *   protected Server() 
 *   public double add(double x, double y) 
 *   public double subtract(double x, double y)
 *   public double multiply(double x, double y)
 *   public double divide(double x, double y) 
 */
public class Server extends UnicastRemoteObject implements Calculator{

	/****
	 * FIELDS
	 ******
	 */
	
	private static final long serialVersionUID = 1L;
	private ServerGui view;

	public static void main(String args[]) {
		try {
			// Create object Server class
			Server obj = new Server();
			/*
			 * Bind this object instance to the name Calculator am using the port number
			 * 1099
			 */
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("Calculator", obj);
		} catch (RemoteException e) {
			System.out.println("There seems to be a problem. The port maybe already in use." + e +"\\n");
			e.printStackTrace();

		}

	}

	protected Server() throws RemoteException {
		super();
		this.view = new ServerGui();
		view.outputArea.append("Client Successfully Connected! /n");
		/*
		 * this the button on ther server 
		 */
//		ServerGui.start.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//				Client.main(null);
//				view.outputArea.append("New Client instance started \n");
//				}
//				catch (Exception er) {
//					System.out.println("New Client exception: " + er);
//				}
//			}
//		});
	}

	public String server() {
		view.outputArea.append("Invocation to Server was succesful! \\n");
		System.out.println("Invocation to Server was succesful! \\n");
		return "Hello from RMI server!\\n";
	}

	/**
	 * this returns the sum of two numbers x+y
	 * it is an Rmi method inherited from the calculator Interface in the model package   
	 * @param double x
	 * @param double y
	 * @return double
	 */
	@Override
	public double add(double x, double y) throws RemoteException {
		try {
			System.out.println("Addition request from client with IP address: " + getClientHost()+"\\n");
			view.outputArea.append("Addition request from client with IP address: " + getClientHost()+"\\n");
			
		} catch (ServerNotActiveException e) {
			view.outputArea.append("Could not find ip address\\n");
			e.printStackTrace();
		}
		double total = x + y;
		view.outputArea.append("Adding: " + x + "," + y + "\n");
		view.outputArea.append("Total: " + (x + y) + "\n");
		return total;
	}
	
	/**
	 * this returns the difference of two numbers x-y
	 * it is an Rmi method inherited from the calculator Interface in the model package   
	 * it returns a double  
	 * @param double x
	 * @param double y
	 * @return double
	 * 
	 */
	@Override
	public double subtract(double x, double y) throws RemoteException {
		try {
			System.out.println("Subtraction request from client with IP address:\\n " + getClientHost());
			view.outputArea.append("Subtraction request from client with IP address:\\n " + getClientHost());
			
		} catch (ServerNotActiveException e) {
			view.outputArea.append("Could not find ip address\\n");
			e.printStackTrace();
		}
		
		double total = x - y;
		view.outputArea.append("The difference between: " + x + "," + y + "\n");
		view.outputArea.append("Total: " + (x - y) + "\n");
		return total;
	}
	

	/**
	 * this returns the multiply two numbers x*y
	 * it is an Rmi method inherited from the calculator Interface in the model package   
	 * it returns a double  
	 * @param double x
	 * @param double y
	 * @return double
	 * 
	 */
	@Override
	public double multiply(double x, double y) throws RemoteException {
		try {
			System.out.println("Multiplication request from client with IP address: " + getClientHost()+"\\n");
			view.outputArea.append("Multiplication request from client with IP address: " + getClientHost()+"\\n");
		} catch (ServerNotActiveException e) {
			view.outputArea.append("Could not find ip address\\n");
			e.printStackTrace();
		}
	
		double total = x * y;
		view.outputArea.append("Multiply: " + x + "," + y + "\n");
		view.outputArea.append("Total: " + ((long) x * y) + "\n");
		return total;
	}
	/**
	 * this returns the difference of two numbers x/y
	 * it is an Rmi method inherited from the calculator Interface in the model package   
	 * it returns a double  
	 * @param double x
	 * @param double y
	 * @return double
	 * 
	 */

	@Override
	public double divide(double x, double y) throws RemoteException {
		try {
			view.outputArea.append("Div request from client with IP address: " + getClientHost()+"\\n");
			System.out.println("Div request from client with IP address: " + getClientHost()+"\\n");
		} catch (ServerNotActiveException e) {
			view.outputArea.append("Could not find ip address\\n");
			e.printStackTrace();
		}
		
		double total = x / y;
		view.outputArea.append("Divide: " + x + "," + y + "\n");
		view.outputArea.append("Total: " + (x / y) + "\n");
		return total;
	}

	
}
