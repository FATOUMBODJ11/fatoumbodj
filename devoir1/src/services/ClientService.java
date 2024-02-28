package services;

import java.util.List;

import entities.Client;
import repositories.ClientRepository;

public class ClientService {
    private ClientRepository clientRepository=new ClientRepository();
    public void ajouterClient(Client client){
        clientRepository.insertClient(client);
    }
    public List<Client> listerClient(){
          return clientRepository.getAllClients();
    }
    
}
