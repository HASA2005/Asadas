
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Role;


public class RoleDAO {
    
    public RoleDAO(){}
    
    
    public void create(Role Role) {

        DBConnection db = new DBConnection();
        String consultaSQL = "INSERT INTO Cantons (id, name) VALUES (?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, Role.getId());
            ps.setString(2, Role.getName());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el Rol");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el Rol, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
     public List<Role> read() {

        DBConnection db = new DBConnection();
        List<Role> Roles = new ArrayList<>();
        String sql = "SELECT * FROM Role";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Roles.add(new Role(id, name));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return Roles;
    }

    public void update(Role Role) {

        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE Roles SET name=?, WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, Role.getId());
            ps.setString(2, Role.getName());
            
           
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

        String consultaSQL = "DELETE FROM Roles WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el Rol");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.toString());
        }finally {
            db.disconnect();
        } 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
