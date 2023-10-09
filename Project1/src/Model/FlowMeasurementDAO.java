
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


public class FlowMeasurementDAO {
    
    public FlowMeasurementDAO() {
    }

    public void create(FlowMeasurement flowMeasurement) {

        DBConnection db = new DBConnection();
        String consultaSQL = "INSERT INTO flow_measurements (capacity, method, observation, date, weather, rising_id, samplingsite_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, flowMeasurement.getCapacity());
            ps.setString(2, flowMeasurement.getMethod());
            ps.setString(3, flowMeasurement.getObservation());
            ps.setDate(4, new java.sql.Date(flowMeasurement.getDate().getTime()));
            ps.setString(5, flowMeasurement.getWeather());
            ps.setInt(6, flowMeasurement.getRising_id());
            ps.setInt(7, flowMeasurement.getSamplingsite_id());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente la medicion ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente la medicion, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

    public List<FlowMeasurement> read() {

        DBConnection db = new DBConnection();
        List<FlowMeasurement> flowMeasurement = new ArrayList<>();
        String sql = "SELECT * FROM flow_measurements";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String capacity = resultSet.getString("capacity");
                String method = resultSet.getString("method");
                String observation = resultSet.getString("observation");
                Date bDate = resultSet.getDate("date");
                String weather = resultSet.getString("weather");
                int risingID = resultSet.getInt("rising_id");
                int samplingsiteID = resultSet.getInt("samplingsite_id");
                flowMeasurement.add(new FlowMeasurement(id, capacity, method, observation ,bDate, weather, risingID, samplingsiteID));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return flowMeasurement;
    }
    
    public void update(FlowMeasurement flowMeasurement) {

        DBConnection db = new DBConnection();
        String consultaSQL = "UPDATE flow_measurements SET capacity=?, method=?, observation=? ,date=?, weather=?, rising_id=?, samplingsite_id=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, flowMeasurement.getCapacity());
            ps.setString(2, flowMeasurement.getMethod());
            ps.setString(4, flowMeasurement.getObservation());
            ps.setDate(3, new java.sql.Date(flowMeasurement.getDate().getTime()));
            ps.setString(4, flowMeasurement.getWeather());
            ps.setInt(5, flowMeasurement.getRising_id());
            ps.setInt(5, flowMeasurement.getSamplingsite_id());
            ps.setInt(6, flowMeasurement.getId());
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

        String consultaSQL = "DELETE FROM flow_measurements WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente la medicion");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.toString());
        }finally {
            db.disconnect();
        } 
    }


}
