package ma.ensa;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;
import java.rmi.registry.LocateRegistry;

public class LanceServeur {
	public static void main(String[] args) {
	    try {
	      LocateRegistry.createRegistry(1099);

	      System.out.println("Mise en place du Security Manager ...");
	      if (System.getSecurityManager() == null) {
	      }

	      InformationImpl informationImpl = new InformationImpl();
	      
	      System.out.println(informationImpl);

	      String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TestRMI";
	      System.out.println("Enregistrement de l'objet avec l'url : " + url);
	      Naming.rebind(url, informationImpl);

	      System.out.println("Serveur lancé");
	    } catch (RemoteException e) {
	      e.printStackTrace();
	    } catch (MalformedURLException e) {
	      e.printStackTrace();
	    } catch (java.net.UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}
