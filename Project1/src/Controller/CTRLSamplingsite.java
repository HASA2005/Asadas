package Controller;

import Model.CantonDAO;
import Model.DistrictDAO;
import Model.Entity;
import Model.EntityDAO;
import Model.ProvinceDAO;
import Model.Samplingsite;
import Model.SamplingsiteDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Cliente
 */
public class CTRLSamplingsite {
    SamplingsiteDAO SSt = new SamplingsiteDAO();
    ProvinceDAO PD = new ProvinceDAO();
    CantonDAO CD =new CantonDAO();
    DistrictDAO DD = new DistrictDAO();
    EntityDAO ED = new EntityDAO();
    int id;
    String name;
    int EntityID,ProvinceID,CantonID,DistrictID;
    
    
    
    
        public void loadDataSamplingsite(JTable table) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<Samplingsite> sampling = SSt.read();
        for (Samplingsite samplingsite : sampling) {
            Object[] row = {samplingsite.getId(), samplingsite.getName(),this.PD.getNameProvinces(samplingsite.getProvince_id()),this.CD.getNameCanton(samplingsite.getCanton_id()),
            this.DD.getNameDistricts(samplingsite.getDistrict_id()),this.ED.getNameEntity(samplingsite.getEntity_id())};
            model.addRow(row);
        }
    }
        public void addSamplingsite(JTextField name) {
    // Validaciones aquí

    try {
        this.SSt.create(new Samplingsite(name.getText(),this.ProvinceID,this.CantonID,this.DistrictID, this.EntityID));
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Error de formato");
    }
}

        public void updateSamplingsite(JTextField name, JTextField province, JTextField canton, JTextField distrito, JTextField entity) {
    // Validaciones aquí

    try {
        this.SSt.update(new Samplingsite(this.id, name.getText(),this.ProvinceID,this.CantonID,this.DistrictID, this.EntityID));
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Error de formato");
    }
}

         public void deleteSamplingsite(){
        this.SSt.delete(this.id);
    }
        
     public void selectedRow(JTable table, JTextField name, JTextField province, JTextField canton, JTextField distrito, JTextField entity) {
    try {
        int row = table.getSelectedRow();
        if (row >= 0) {
            this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
            name.setText(table.getValueAt(row, 1).toString());
            province.setText(table.getValueAt(row, 2).toString());
            canton.setText(table.getValueAt(row, 3).toString());
            distrito.setText(table.getValueAt(row, 4).toString());
            entity.setText(table.getValueAt(row, 5).toString());
           
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
    }
}
        public void getIdEntity(JComboBox entity){
        this.EntityID = this.ED.getIDEntity(entity.getSelectedItem().toString());
    }
    
    public void loadEntity(JComboBox c){
       List<Entity> entitys = this.ED.read();
       DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Entity entity : entitys) {
            model.addElement(entity.getName());
        }
        c.setModel(model);
    }
         
}