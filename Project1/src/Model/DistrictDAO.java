package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DistrictDAO {
    
    public DistrictDAO() {
    }

    public void create(District District) {

        DBConnection db = new DBConnection();
        String consultaSQL = "INSERT INTO students (id, name, canton_id) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, District.getId());
            ps.setString(2, District.getName());
            ps.setInt(4, District.getCanton_id());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el estudiante");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el estudiante, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
     public List<District> read() {

        DBConnection db = new DBConnection();
        List<District> Districts = new ArrayList<>();
        String sql = "SELECT * FROM Districts";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int canton_id = resultSet.getInt("canton_id");
                Districts.add(new District(id, name, canton_id));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return Districts;
    }

    public void update(District District) {

        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE students SET name=?, canton_id=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(2, District.getName());
                ps.setInt(4, District.getCanton_id());
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

        String consultaSQL = "DELETE FROM Districts WHERE id=?";

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