package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.Timer;

/*
 *This will run both the client and server the server will run first  and once stared the the client will start  
 */

public class Server_and_Client_Runner {
	static Timer timer;
	public static void main(String[] args) throws RemoteException{
		timer = new Timer(500, al);
		timer.start();
		Server.main(null); // start server
	}

	static ActionListener al = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Running Client /n");
			Client.main(null); //start client 
			timer.stop();
		}
	};
}
