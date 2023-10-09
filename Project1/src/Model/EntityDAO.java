package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class EntityDAO {
    
     public EntityDAO() {
    }

   public void create(Entity Entity) {

        DBConnection db = new DBConnection();
        String consultaSQL = "INSERT INTO students (id, legal_ID, name, telephone,address,description) VALUES (?, ?, ?, ?,?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, Entity.getLegal_ID());
            ps.setString(2, Entity.getName());
            ps.setInt(3, Entity.getTelephone());
            ps.setString(4, Entity.getAddress());
            ps.setString(5, Entity.getDescription());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el estudiante");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el estudiante, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

    public List<Entity> read() {

        DBConnection db = new DBConnection();
        List<Entity> Entities = new ArrayList<>();
        String sql = "SELECT * FROM Entities";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int legal_ID = Integer.parseInt(resultSet.getString("legal_ID"));
                String name = resultSet.getString("name");
                int telephone = resultSet.getInt("telephone");
                String address = resultSet.getString("address");
                String description = resultSet.getString("description");
                Entities.add(new Entity(id, legal_ID, name, telephone, address,description));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return Entities;
    }

    public void update(Entity Entity) {

        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE students SET legal_ID=?, name=?, telephone=?, address=?,description=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, Entity.getLegal_ID());
            ps.setString(2, Entity.getName());
            ps.setInt(3, Entity.getTelephone());
            ps.setString(4, Entity.getAddress());
            ps.setString(5, Entity.getDescription());
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

        String consultaSQL = "DELETE FROM Entities WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el estudiante");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.toString());
        }finally {
            db.disconnect();
        } 
    }
}
