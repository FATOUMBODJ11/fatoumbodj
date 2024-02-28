package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Adresse;
import entities.Client;

public class AdresseRepository extends Database {
    private final  String SQL_SELECT_ALL="select * from adresse b, client z where b.client_id=z.id_client" ;
    private final  String SQL_INSERT="INSERT INTO `adresse` (`villa`, `quartier`, `numvilla`, `client_id`) VALUES (?,?,?,?)";
    public void insertA(Adresse adresse){
            openConnexion();
            try {
                initPreparedStatement(SQL_INSERT);
                statement.setString(1, adresse.getVille());
                statement.setString(2, adresse.getQuartier());
                statement.setString(2, adresse.getNumVilla());
                statement.setInt(4, adresse.getClient().getId());
                int nbreLigne=executeUpdate();
            closeConnexion();
            } catch (SQLException e) {
            e.printStackTrace();
            }
       }
       public List<Adresse> getAllAdresses(){
            List<Adresse> adresses=new ArrayList<>();
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
                     
                     Adresse adresse=new Adresse();
                     adresse.setId(rs.getInt("id_adresse"));
                     adresse.setVille(rs.getString("ville"));
                     adresse.setQuartier(rs.getString("quartier"));
                     adresse.setNumVilla(rs.getString("numvilla"));
                     adresse.setClient(client);
                  
                     adresses.add(adresse);
             }
             rs.close();
            closeConnexion();
          }
          catch (SQLException e) {
              System.out.println("Erreur de Connexion a la BD");
         }
         return  adresses;
       }
    public void insertAdresse(Adresse adresse) {
        throw new UnsupportedOperationException("Unimplemented method 'insertAdresse'");
    }
    
    
}
