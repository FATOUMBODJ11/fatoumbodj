import java.util.List;
import java.util.Scanner;

import entities.Adresse;
import entities.Client;
import services.AdresseService;
import services.ClientService;

public class App {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        ClientService clientService=new ClientService();
        AdresseService adresseService=new AdresseService();
        do {
            System.out.println("1-Creer un  Client");
            System.out.println("2-Lister les Clients"); 
            System.out.println("3-Ajouter  une addresse");
            System.out.println("4-Lister les addresses "); 
            System.out.println("5-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
             switch (choix) {
             case 1:
                     System.out.println("Entrer le nom du client");
                     String nomClient=sc.nextLine(); 
                     Client client=new Client();
                     client.setNom(nomClient);
                     clientService.ajouterClient(client);
                    break;
                case 2:
                    List<Client> clients= clientService.listerClient();
                    for (Client cl : clients) {
                        System.out.println("ID : "+cl.getId() ); 
                        System.out.println("NOM : "+cl.getNom() ); 
                        System.out.println("TELEPHONE : "+cl.getTelephone() ); 
                        System.out.println("EMAIL : "+cl.getEmail() );   
                    }
                  
                    break; 
                    
              case 3:
                     System.out.println("Entrer la ville ");
                     String ville=sc.nextLine(); 
                     System.out.println("Entrer le quartier ");
                     String quartier=sc.nextLine();
                     System.out.println("Entrer le numvilla");
                     String numVilla=sc.nextLine(); 
                     clients= clientService.listerClient(); 
                        for (Client cl : clients) {
                            System.out.println(cl.getId()+"-"+cl.getNom());   
                        }
                       System.out.println("Entrer Id d'un Client");
                       int idClient=sc.nextInt();
                       client=new Client();
                       client.setId(idClient);
                       Adresse adresse=new Adresse();
                       adresse.setVille(ville);
                       adresse.setQuartier(quartier);
                       adresse.setNumVilla(numVilla);
                       adresse.setClient(client);;
                       adresseService.ajouterAdresse(adresse);
                   break;

                   case 4:
                   List<Adresse> adresses= adresseService.listerAdresse();
                   for (Adresse a : adresses) {
                       System.out.println("ID : "+a.getId() ); 
                       System.out.println("ville : "+a.getVille() ); 
                       System.out.println("quartier : "+a.getQuartier() ); 
                       System.out.println("numvilla : "+a.getNumVilla() ); 
                       System.out.println("Client : "+a.getClient().getNom() ); 
                       System.out.println("------------------------------------");      
                   
                   }
                   break; 
                    
                }
          } while (choix!=5);
        
    }
}
