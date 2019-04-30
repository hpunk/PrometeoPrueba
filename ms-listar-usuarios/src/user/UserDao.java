package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class UserDao {

 
    private List<User> users = listarUsuarios();
    
    
    private List<User> listarUsuarios(){
        List<User> usuarios = new ArrayList<User>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf245vhack",
                    "inf245vhack", "Lh9NYEbo8vjxFIwa");
            Statement sentencia = con.createStatement();
            String instruccion = "Select * From UsuariosPrueba";
            ResultSet rs = sentencia.executeQuery(instruccion);
            
            
            while(rs.next()){
                int idUser = rs.getInt("User_id");
                String name = rs.getString("name");
                String carrera = rs.getString("carrera");
                //System.out.println(rs.getInt("User_id")+" "+rs.getString("name"));

                User aux = new User(idUser, name, carrera);
                usuarios.add(aux);
                
            }
            con.close();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return usuarios;
    }
    private static UserDao userDao = null;
 
    private UserDao() {
    }
 
    static UserDao instance() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }
 
    Optional<User> getUserById(int id) {
        return users.stream()
          .filter(u -> u.id == id)
          .findAny();
    }
 
    Iterable<User> getAllUsernames() {
        return users;
    }
}
