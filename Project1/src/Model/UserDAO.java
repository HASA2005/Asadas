
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class UserDAO {
   
    public UserDAO(){
    }
    
    
      public void create(User User) {

        DBConnection db = new DBConnection();
        String consultaSQL = "INSERT INTO User (id,name,first_name, second_name, email, password, entity_id, role_id ) VALUES (?, ?, ?, ?,?,?,?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, User.getId());
            ps.setString(2, User.getName());
            ps.setString(3, User.getFirst_name());
            ps.setString(4, User.getSecond_name());
            ps.setString(5, User.getEmail());
            ps.setString(6, User.getPassword());
            ps.setInt(7, User.getEntity_id());
            ps.setInt(8, User.getRole_id());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el usuario ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el usuario, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

    public List<User> read() {

        DBConnection db = new DBConnection();
        List<User> Users = new ArrayList<>();
        String sql = "SELECT * FROM Users";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name  = resultSet.getString("name");
                String first_name = resultSet.getString("first_name");
                String second_name  = resultSet.getString("second_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                int entity_id = resultSet.getInt("entity_id");
                int  role_id = resultSet.getInt("role_id");
                Users.add(new User(id,name, first_name, second_name, email, password, entity_id, role_id ));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return Users;
        }


    public void update(User User) {

        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE User SET  id, name, first_name, second_name, email, password, entity_id, role_id  WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, User.getId());
            ps.setString(2, User.getName());
            ps.setString(4, User.getFirst_name());
            ps.setString(5, User.getSecond_name());
            ps.setString(6, User.getEmail());
            ps.setString(7, User.getPassword());
             ps.setInt(8, User.getEntity_id());
                    ps.setInt(9, User.getRole_id());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error:" + e.toString());
        }finally {
            db.disconnect();
        }
        
    }

    public void delete(int id) {

        DBConnection db = new DBConnection();

        String consultaSQL = "DELETE FROM User WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el usuario ");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.toString());
        }finally {
            db.disconnect();
        } 
    }
       
    
}


































