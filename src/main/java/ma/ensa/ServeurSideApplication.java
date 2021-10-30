package ma.ensa;

import java.net.MalformedURLException;
import java.rmi.*;
import java.net.InetAddress;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServeurSideApplication {

	public static void main(String[] args) throws UnknownHostException, java.net.UnknownHostException {
		SpringApplication.run(ServeurSideApplication.class, args);
	try {
	    if (System.getSecurityManager() == null) {
	      System.setSecurityManager(new RMISecurityManager());
	    }
	    InformationImpl informationImpl = new InformationImpl();
	    String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TestRMI";
	    System.out.println("Enregistrement de l'objet avec l'url : " + url);
	    Naming.rebind(url, informationImpl);

	    System.out.println("Serveur lancé");
	  } catch (RemoteException e) {
	    e.printStackTrace();
	  } catch (MalformedURLException e) {
	    e.printStackTrace();
	  }
}

}
