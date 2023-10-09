
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class NascentDAO {
    
    public NascentDAO() {
    }

    public void create(Nascent nascent) {

        DBConnection db = new DBConnection();
        String consultaSQL = "INSERT INTO Nascents (name, address, length, description, province_id, district_id, entity_id, canton_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, nascent.getName());
            ps.setString(2, nascent.getAddress());
            ps.setDouble(2, nascent.getLength());
            ps.setString(4, nascent.getDescription());
            ps.setInt(5, nascent.getProvince_id());
            ps.setInt(5, nascent.getCanton_id());
            ps.setInt(5, nascent.getDistrict_id());
            ps.setInt(5, nascent.getEntity_id());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente la naciente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente la naciente, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
    
    public List<Nascent> read() {

        DBConnection db = new DBConnection();
        List<Nascent> nascents = new ArrayList<>();
        String sql = "SELECT * FROM nascents";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Double length = resultSet.getDouble("length");
                String description = resultSet.getString("description");
                int provinceID = resultSet.getInt("province_id");
                int cantonID = resultSet.getInt("canton_id");
                int districtID = resultSet.getInt("district_id");
                int entityID = resultSet.getInt("entity_id");
                nascents.add(new Nascent(id,name,address,length,description ,provinceID,cantonID,districtID,entityID ));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return nascents;
    }
    
    public void update(Nascent nascent) {

        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE students SET name=?, address=?, length=? , description=?, province_id=?, canton_id=?, district_id=?, entity_id=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, nascent.getName());
            ps.setString(2, nascent.getAddress());
            ps.setDouble(3, nascent.getLength());
            ps.setString(4, nascent.getDescription());
            ps.setInt(5, nascent.getProvince_id());
            ps.setInt(6, nascent.getCanton_id());
            ps.setInt(7, nascent.getDistrict_id());
            ps.setInt(8, nascent.getEntity_id());
            ps.setInt(9, nascent.getId());
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

        String consultaSQL = "DELETE FROM nascents WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente la naciente");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.toString());
        }finally {
            db.disconnect();
        } 
    }

}
