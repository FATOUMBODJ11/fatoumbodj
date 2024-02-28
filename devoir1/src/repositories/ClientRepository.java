package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Client;

public class ClientRepository extends Database{
    private static final String SQL_INSERT = null;
    private static final String SQL_SELECT_ALL = null;
    public void insertClient(Client client){
            openConnexion();
            try {
                initPreparedStatement(SQL_INSERT);
                statement.setString(1, client.getNom());
                int nbreLigne=executeUpdate();
            closeConnexion();
            } catch (SQLException e) {
            e.printStackTrace();
            }
       }
       public List<Client> getAllClients(){
            List<Client> clients=new ArrayList<>();
       try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_ALL);
           ResultSet rs= executeSelect();
             while (rs.next()) {
                  Client client=new Client();
                   client.setId(rs.getInt("id_client"));
                   client.setNom(rs.getString("nom_client"));
                   client.setTelephone(rs.getString("telephone_client"));
                   client.setEmail(rs.getString("email_client"));
                   clients.add(client);
             }
             rs.close();
           closeConnexion();
        }
         catch (SQLException e) {
              System.out.println("Erreur de Connexion a la BD");
        }
        return  clients;
       }
    public void insertcl(Client client) {
        
        throw new UnsupportedOperationException("Unimplemented method 'insertcl'");
    }
    public void insertclient(Client client) {
       
        throw new UnsupportedOperationException("Unimplemented method 'insertclient'");
    }
    
}
