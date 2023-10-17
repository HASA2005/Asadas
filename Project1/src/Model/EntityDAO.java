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
        String consultaSQL = "INSERT INTO entitys (id, legal_ID, name, mail, telephone,address,description) VALUES (?, ?, ?, ?,?,?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, Entity.getLegal_ID());
            ps.setString(2, Entity.getName());
            ps.setString(3, Entity.getMail());
            ps.setInt(4, Entity.getTelephone());
            ps.setString(5, Entity.getAddress());
            ps.setString(6, Entity.getDescription());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente la entidad");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente la entidad, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }


    public List<Entity> read() {

        DBConnection db = new DBConnection();
        List<Entity> Entitys = new ArrayList<>();
        String sql = "SELECT * FROM entitys";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int legal_ID = Integer.parseInt(resultSet.getString("legal_ID"));
                String name = resultSet.getString("name");
                String mail = resultSet.getString("mail");
                int telephone = resultSet.getInt("telephone");
                String address = resultSet.getString("address");
                String description = resultSet.getString("description");
                Entitys.add(new Entity(id, legal_ID, name, mail ,telephone, address,description));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return Entitys;
    }
    
      public void update(Entity Entity) {

        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE entitys SET legal_ID=?, name=?, mail=?, telephone=?, address=?,description=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, Entity.getLegal_ID());
            ps.setString(2, Entity.getName());
            ps.setString(3, Entity.getMail());
            ps.setInt(4, Entity.getTelephone());
            ps.setString(5, Entity.getAddress());
            ps.setString(6, Entity.getDescription());
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

        String consultaSQL = "DELETE FROM entitys WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente la entidad");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.toString());
        }finally {
            db.disconnect();
        } 
    }
    
     public int getIDEntity(String name) {
        int value = 0;
        DBConnection db = new DBConnection();
        String sql = "SELECT id FROM entitys WHERE name = ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                value = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return value;
    }
     
     public String getNameEntity(int id) {
        String value = "";
        DBConnection db = new DBConnection();
        String sql = "SELECT name FROM entitys WHERE id = ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                value = resultSet.getString("name");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return value;
    }


}
