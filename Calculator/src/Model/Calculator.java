package Model;

import java.rmi.Remote;
import java.rmi.RemoteException;
/*
 * @author Francisca 
 * this is the calculator interface 
 * Methods 
 *  add
 *  subtract
 *  multiply
 *  divide
 */

public interface Calculator extends Remote {
	// this returns that answer of adding two numbers x + y
	double add(double x, double y) throws RemoteException;
	// this returns that answer of taking away two numbers x - y
	double subtract(double x, double y) throws RemoteException;
	// this returns that answer of multiplying two numbers x x y
	double multiply(double x, double y) throws RemoteException;
	// this returns that answer of dividig two numbers x + y
	double divide(double x, double y) throws RemoteException;
	

}
