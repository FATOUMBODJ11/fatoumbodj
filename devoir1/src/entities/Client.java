package entities;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String nom; 
    private String telephone;
    private String email;

    List<Client> clients=new ArrayList<>();
      
    public List<Client> getClients() {
        return clients;
    }
    public void setClient(List<Client> clients) {
        this.clients = clients;
    }

    
    public Client() {
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    } 
    
    
}
