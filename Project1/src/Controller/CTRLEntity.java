
package Controller;

import Model.Entity;
import Model.EntityDAO;
import Model.User;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class CTRLEntity {
    
    EntityDAO ED = new EntityDAO();
    int id;
    
    public void loadDataUser(JTable table) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<Entity> entitys = ED.read();
        for (Entity Entitys : entitys) {
            Object[] row = {Entitys.getId(), Entitys.getLegal_ID(), Entitys.getName(),
                Entitys.getMail(), Entitys.getTelephone(),Entitys.getAddress(),Entitys.getDescription()};
            model.addRow(row);
        }
    }
    
    public void addEntity(JTextField legalID ,JTextField name, JTextField mail, JTextField telephone, JTextField address, JTextField description) {
        //Validaciones aqui

        try {

            this.ED.create(new Entity(Integer.parseInt(legalID.getText()), name.getText(), mail.getText(),Integer.parseInt( telephone.getText()),address.getText(),description.getText() ));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato");
        }
    }
    
     public void updateEntity(JTextField legalID ,JTextField name, JTextField mail, JTextField telephone, JTextField address, JTextField description) {
        //Validaciones aqui

        try {

            this.ED.create(new Entity(this.id,Integer.parseInt(legalID.getText()), name.getText(), mail.getText(),Integer.parseInt( telephone.getText()),address.getText(),description.getText() ));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato");
        }
    }
     
      public void deleteUser(){
        this.ED.delete(this.id);
    }
    public void selectedRow(JTable table, JTextField legalID ,JTextField name, JTextField mail, JTextField telephone, JTextField address, JTextField description) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                legalID.setText((table.getValueAt(row, 1).toString()));
                name.setText((table.getValueAt(row, 2).toString()));
                mail.setText((table.getValueAt(row, 3).toString()));
                telephone.setText((table.getValueAt(row, 4).toString()));
                address.setText((table.getValueAt(row, 5).toString()));
                description.setText((table.getValueAt(row, 6).toString()));
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de seleccion, error: " + e.toString());
        }
    }
    
    public void clearFields(JTextField legalID ,JTextField name, JTextField mail, JTextField telephone, JTextField address, JTextField description) {
        name.setText("");
        legalID.setText("");
        mail.setText("");
        telephone.setText("");
        address.setText("");
        description.setText("");
    }
    
}
