import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientCarnetAdresses {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 3553);
            CarnetAdresses carnet = (CarnetAdresses) registry.lookup("CarnetAdressesService");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez le mot de passe : ");
            String motDePasse = scanner.nextLine();

            if (!carnet.authentifier(motDePasse)) {
                System.out.println("Mot de passe incorrect.");
                return;
            }

            while (true) {
                System.out.println("\nMenu :");
                System.out.println("1. Ajouter un contact");
                System.out.println("2. Supprimer un contact");
                System.out.println("3. Rechercher un contact");
                System.out.println("4. Lister les contacts");
                System.out.println("5. Modifier un contact");
                System.out.println("6. Quitter");
                System.out.print("Choisissez une option : ");

                int choix = scanner.nextInt();
                scanner.nextLine(); 

                switch (choix) {
                    case 1:
                        System.out.print("Nom : ");
                        String nom = scanner.nextLine();
                        System.out.print("Numéro : ");
                        String numero = scanner.nextLine();
                        carnet.ajouterContact(nom, numero);
                        break;

                    case 2:
                        System.out.print("Nom : ");
                        nom = scanner.nextLine();
                        carnet.supprimerContact(nom);
                        break;

                    case 3:
                        System.out.print("Nom : ");
                        nom = scanner.nextLine();
                        System.out.println("Numéro : " + carnet.rechercherContact(nom));
                        break;

                    case 4:
                        System.out.println("Contacts :");
                        for (String contact : carnet.listerContacts()) {
                            System.out.println(contact);
                        }
                        break;

                    case 5:
                        System.out.print("Nom : ");
                        nom = scanner.nextLine();
                        System.out.print("Nouveau numéro : ");
                        String nouveauNumero = scanner.nextLine();
                        carnet.modifierContact(nom, nouveauNumero);
                        break;

                    case 6:
                        System.out.println("Au revoir !");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Option invalide.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
