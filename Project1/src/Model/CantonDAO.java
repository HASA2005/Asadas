package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CantonDAO {
    
    
    public CantonDAO() {
    }

    public void create(Canton Canton) {

        DBConnection db = new DBConnection();
        String consultaSQL = "INSERT INTO students (id, name, province_id,) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, Canton.getId());
            ps.setString(2, Canton.getName());
            ps.setString(2, Canton.getProvince_id());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el estudiante");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el estudiante, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
     public List<Canton> read() {

        DBConnection db = new DBConnection();
        List<Canton> Cantones = new ArrayList<>();
        String sql = "SELECT * FROM Cantones";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String province_id = resultSet.getString("Province_id");
                Cantones.add(new Canton(id, name, province_id));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return Cantones;
    }

    public void update(Canton Canton) {

        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE students SET name=?, getProvince_id=?, WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, Canton.getId());
            ps.setString(2, Canton.getName());
            ps.setString(4, Canton.getProvince_id());
           
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

        String consultaSQL = "DELETE FROM Cantones WHERE id=?";

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
