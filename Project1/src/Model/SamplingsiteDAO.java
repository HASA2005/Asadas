
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Samplingsite;

public class SamplingsiteDAO {
    
    public SamplingsiteDAO(){
    }
    
    public void create(Samplingsite Samplingsite) {

        DBConnection db = new DBConnection();
        String consultaSQL = "INSERT INTO Samplingsites (id, name) VALUES (?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(2, Samplingsite.getName());
            ps.setInt(1, Samplingsite.getProvince_id());
             ps.setInt(1, Samplingsite.getDistrict_id());
              ps.setInt(1, Samplingsite.getCanton_id());
               ps.setInt(1, Samplingsite.getEntity_id());
                
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el sitio de muestreo");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el sitio de muestreo, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
     public List<Samplingsite> read() {

        DBConnection db = new DBConnection();
        List<Samplingsite> Samplingsites = new ArrayList<>();
        String sql = "SELECT * FROM Samplingsite";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int province_id = resultSet.getInt("province_id");
                int district_id = resultSet.getInt("district_id");
                int canton_id = resultSet.getInt("canton_id");
                int entity_id = resultSet.getInt("entity_id");
                Samplingsites.add(new Samplingsite(id, name, province_id, district_id, canton_id, entity_id));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return Samplingsites;
    }

    public void update(Samplingsite Samplingsite) {

        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE Samplingsites SET name=?, WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, Samplingsite.getId());
            ps.setString(2, Samplingsite.getName());
            ps.setInt(3,Samplingsite.getProvince_id());
            ps.setInt(4,Samplingsite.getDistrict_id());
            ps.setInt(5, Samplingsite.getCanton_id());
            ps.setInt(6,Samplingsite.getEntity_id());
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

        String consultaSQL = "DELETE FROM Samplingsites WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el sitio de muestreo");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.toString());
        }finally {
            db.disconnect();
        } 
    
    
    
    
}
}
