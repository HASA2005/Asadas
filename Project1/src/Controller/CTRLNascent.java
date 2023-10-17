
package Controller;

import Model.Canton;
import Model.CantonDAO;
import Model.District;
import Model.DistrictDAO;
import Model.Entity;
import Model.EntityDAO;
import Model.Nascent;
import Model.NascentDAO;
import Model.Province;
import Model.ProvinceDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



public class CTRLNascent {
    NascentDAO ND = new NascentDAO();
    ProvinceDAO PD = new ProvinceDAO();
    CantonDAO CD =new CantonDAO();
    DistrictDAO DD = new DistrictDAO();
    EntityDAO ED = new EntityDAO();
    int id;
    int EntityID,ProvinceID,CantonID,DistrictID;
    
    
    public void loadDataUser(JTable table) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<Nascent> Nascents = ND.read();
        for (Nascent nascent : Nascents) {
            Object[] row = {nascent.getId(), nascent.getName(), nascent.getAddress(),
                nascent.getLatitude(), nascent.getLength(),nascent.getDescription(),this.PD.getNameProvinces(nascent.getProvince_id()),this.CD.getNameCanton(nascent.getCanton_id()),
            this.DD.getNameDistricts(nascent.getDistrict_id()),this.ED.getNameEntity(nascent.getEntity_id())};
            model.addRow(row);
        }
    }
    
    public void addNascent( JTextField name, JTextField address, JTextField latitude, JTextField length, JTextField description) {
        //Validaciones aqui

        try {

            this.ND.create(new Nascent(name.getText(), address.getText(), Double.parseDouble(latitude.getText()),Double.parseDouble(length.getText()),description.getText(),this.ProvinceID,this.CantonID,this.DistrictID , this.EntityID));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato");
        }
    }
    
    public void UpdateNascent( JTextField name, JTextField address, JTextField latitude, JTextField length, JTextField description) {
        //Validaciones aqui

        try {

            this.ND.create(new Nascent(this.id,name.getText(), address.getText(), Double.parseDouble(latitude.getText()),Double.parseDouble(length.getText()),description.getText(),this.ProvinceID,this.CantonID,this.DistrictID , this.EntityID));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato");
        }
    }
    
    public void deleteNascent(){
        this.ND.delete(this.id);
    }
    public void selectedRow(JTable table, JTextField name, JTextField address, JTextField latitude, JTextField length, JTextField description,JComboBox province,JComboBox canton,JComboBox district,JComboBox entity) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText((table.getValueAt(row, 1).toString()));
                address.setText((table.getValueAt(row, 2).toString()));
                latitude.setText((table.getValueAt(row, 3).toString()));
                length.setText((table.getValueAt(row, 4).toString()));
                description.setText((table.getValueAt(row, 5).toString()));
                province.setSelectedItem((table.getValueAt(row, 6).toString()));
                canton.setSelectedItem((table.getValueAt(row, 7).toString()));
                district.setSelectedItem((table.getValueAt(row, 8).toString()));
                entity.setSelectedItem((table.getValueAt(row, 9).toString()));
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de seleccion, error: " + e.toString());
        }
    }
    
    public void clearFields(JTextField name, JTextField address, JTextField latitude, JTextField length, JTextField description) {
        name.setText("");
        address.setText("");
        latitude.setText("");
        length.setText("");
        description.setText("");
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
    
    public void getIdProvince(JComboBox province){
        this.ProvinceID = this.PD.getIDProvinces(province.getSelectedItem().toString());
    }
    
    public void loadProvince(JComboBox c){
       List<Province> province = this.PD.read();
       DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Province provinces : province) {
            model.addElement(provinces.getName());
        }
        c.setModel(model);
    }
    
    public void getIdCanton(JComboBox canton){
        this.CantonID = this.CD.getIDCanton(canton.getSelectedItem().toString());
    }
    
    public void loadCanton(JComboBox c){
       List<Canton> canton = this.CD.read();
       DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Canton cantons : canton) {
            model.addElement(cantons.getName());
        }
        c.setModel(model);
    }
        
        public void getIdDistrict(JComboBox district){
        this.DistrictID = this.DD.getIDDistricts(district.getSelectedItem().toString());
    }
    
    public void loadDistrict(JComboBox c){
       List<District> district = this.DD.read();
       DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (District districts : district) {
            model.addElement(districts.getName());
        }
        c.setModel(model);
    }
}
