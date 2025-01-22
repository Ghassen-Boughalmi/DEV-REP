import java.rmi.RemoteException;
import java.util.List;

public interface CarnetAdresses extends java.rmi.Remote{
	
	 void ajouterContact(String nom, String numero) throws RemoteException;
	    void supprimerContact(String nom) throws RemoteException;
	    String rechercherContact(String nom) throws RemoteException;
	    List<String> listerContacts() throws RemoteException;
	    void modifierContact(String nom, String nouveauNumero) throws RemoteException;
	    boolean authentifier(String motDePasse) throws RemoteException;
	    
}
