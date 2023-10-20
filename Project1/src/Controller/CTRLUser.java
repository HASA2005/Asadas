
package Controller;

import Model.DBConnection;
import Model.Entity;
import Model.EntityDAO;
import Model.Role;
import Model.RoleDAO;
import Model.User;
import Model.UserDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class CTRLUser {
    
    UserDAO ud = new UserDAO();
    EntityDAO ed = new EntityDAO();
    RoleDAO rd = new RoleDAO();
    int id;
    int EntityID;
    int RoleID;
    
    public void loadDataUser(JTable table) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<User> users = ud.read();
        for (User user : users) {
            Object[] row = {user.getId(), user.getName(), user.getFirst_name(),user.getSecond_name(), user.getEmail(),user.getPassword(),this.ed.getNameEntity(user.getEntity_id()),this.rd.getNameRole(user.getRole_id())};
            model.addRow(row);
        }
    }
    
    public void addUser( JTextField name, JTextField first_name, JTextField second_name, JTextField email, JTextField password) {
        //Validaciones aqui

        try {

            this.ud.create(new User(name.getText(), first_name.getText(), second_name.getText(),email.getText(),password.getText() , this.EntityID,this.RoleID));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato");
        }
    }
    
    public void updateUser( JTextField name, JTextField first_name, JTextField second_name, JTextField email, JTextField password) {
        //Validaciones aqui

        try {

            this.ud.update(new User(this.id,name.getText(), first_name.getText(), second_name.getText(),email.getText(),password.getText() , this.EntityID,this.RoleID));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato ");
        }
    }
    
    public void deleteUser(){
        this.ud.delete(this.id);
    }
    public void selectedRow(JTable table, JTextField name, JTextField first_name, JTextField second_name, JTextField email, JTextField password,JComboBox entity, JComboBox role) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText((table.getValueAt(row, 1).toString()));
                first_name.setText((table.getValueAt(row, 2).toString()));
                second_name.setText((table.getValueAt(row, 3).toString()));
                email.setText((table.getValueAt(row, 4).toString()));
                password.setText((table.getValueAt(row, 5).toString()));
                entity.setSelectedItem((table.getValueAt(row, 6).toString()));
                role.setSelectedItem((table.getValueAt(row, 7).toString()));
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de seleccion, error: " + e.toString());
        }
    }
    
    public void clearFields(JTextField name, JTextField first_name, JTextField second_name, JTextField email, JTextField password) {
        name.setText("");
        first_name.setText("");
        second_name.setText("");
        email.setText("");
        password.setText("");
    }
    
    public void getIdEntity(JComboBox entity){
        this.EntityID = this.ed.getIDEntity(entity.getSelectedItem().toString());
    }
    
    public void loadEntity(JComboBox c){
       List<Entity> entitys = this.ed.read();
       DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Entity entity : entitys) {
            model.addElement(entity.getName());
        }
        c.setModel(model);
    }
    
    public void getIdRole(JComboBox role){
        this.RoleID = this.rd.getIDRole(role.getSelectedItem().toString());
    }
    
    public void loadRole(JComboBox c){
       List<Role> roles = this.rd.read();
       DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Role Roles : roles) {
            model.addElement(Roles.getName());
        }
        c.setModel(model);
    }
    public User findUserByUsername(String username) {
    return ud.getUserByUsername(username);
}

 }
