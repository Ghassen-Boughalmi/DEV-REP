import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServeurCarnetAdresses {
    public static void main(String[] args) {
        try {
            CarnetAdressesImpl carnet = new CarnetAdressesImpl("admin1234");
            Registry registry = LocateRegistry.createRegistry(3553);
            registry.rebind("CarnetAdressesService", carnet);
            System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
