import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarnetAdressesImpl extends UnicastRemoteObject implements CarnetAdresses {
    private Map<String, String> contacts;
    private final String motDePasse;

    protected CarnetAdressesImpl(String motDePasse) throws RemoteException {
        super();
        this.contacts = new HashMap<>();
        this.motDePasse = motDePasse;
    }

    @Override
    public synchronized void ajouterContact(String nom, String numero) throws RemoteException {
        contacts.put(nom, numero);
    }

    @Override
    public synchronized void supprimerContact(String nom) throws RemoteException {
        contacts.remove(nom);
    }

    @Override
    public String rechercherContact(String nom) throws RemoteException {
        return contacts.getOrDefault(nom, "Contact non trouvé.");
    }

    @Override
    public List<String> listerContacts() throws RemoteException {
        List<String> liste = new ArrayList<>();
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            liste.add(entry.getKey() + ": " + entry.getValue());
        }
        return liste;
    }

    @Override
    public synchronized void modifierContact(String nom, String nouveauNumero) throws RemoteException {
        if (contacts.containsKey(nom)) {
            contacts.put(nom, nouveauNumero);
        } else {
            throw new RemoteException("Contact non trouvé.");
        }
    }

    @Override
    public boolean authentifier(String motDePasse) throws RemoteException {
        return this.motDePasse.equals(motDePasse);
    }
}
