package businesstier;

import domain.Personnel;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdbc.PersonnelJDBC;

public class PersonnelBusinessTier {
    PersonnelJDBC jdbc;
    
    public PersonnelBusinessTier () throws Exception {
        try {
            jdbc = new PersonnelJDBC();
        }    catch (SQLException ex) {
            throw new Exception("error connecting to database");
        }
    }
    
    public String createPersonnel (Personnel p) throws Exception {
        int iage;
        int iic;

        if(p.getName().equals("")){
            JOptionPane.showMessageDialog(null, "Invalid name input");
            return "";
        } 
        
         if(p.getIc().equals("")){
            JOptionPane.showMessageDialog(null, "Invalid IC No input");
            return "";
        } 
 
        if(p.getAddress().equals("")){
            JOptionPane.showMessageDialog(null, "Invalid address input");
            return "";
        } 
        if(p.getHp().equals("")){
            JOptionPane.showMessageDialog(null, "Invalid hp input");
            return "";
        } 
        
        if (p.getStype().equals("Staff"))
            p.setId(jdbc.setStaffId(p.getStype()));
        else
            p.setId(jdbc.setMemberId(p.getStype()));
        
        if (p.getStype().equals("Staff"))
            p.setStype("S");
        else
            p.setStype("M");
        
       boolean success = jdbc.createPersonnnel(p);
       if (success)
        return p.getId();
       else
           return "";
    }
    
    public ArrayList retrieveName() throws SQLException {
        ArrayList name = jdbc.retrieveName();
        return name;
    }
    
    public ArrayList retrieveAllId() throws SQLException {
        ArrayList id = jdbc.retrieveAllId();
        return id;
    }
    
    
    public String retrieveAPersonnel (String name) throws SQLException{
        String n = jdbc.retrieveAPersonnel(name);
        try{
            Personnel p = new Personnel();
        if(name==""){
            return null;
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return n;
    }
    
    public ArrayList retrieveId(String id) throws SQLException{
        return jdbc.retrieveId(id);
    }
    
    public boolean updatePersonnel (Personnel p) throws Exception {
        int iage;
      
       if(p.getName().equals("")){
            JOptionPane.showMessageDialog(null, "Invalid name input");
            return false;
        } 
        
         if(p.getIc().equals("")){
            JOptionPane.showMessageDialog(null, "Invalid IC No input");
            return false;
        } 

        if(p.getAddress().equals("")){
            JOptionPane.showMessageDialog(null, "Invalid address input");
            return false;
        } 
        if(p.getHp().equals("")){
            JOptionPane.showMessageDialog(null, "Invalid hp input");
            return false;
        } 
         
       boolean success = jdbc.updatePersonnel(p);
       if (success)
        return true;
       else
           return false;
        
    }
    
    public ArrayList getStaffId(String type) throws SQLException{
        return jdbc.getStaffId(type);
    }
    public void viewPersonnel(DefaultTableModel model) throws SQLException{
           jdbc.viewPersonnel(model);
        }
    
    public boolean deletePersonnel (String name) throws Exception {
                    return jdbc.deletePersonnel(name);
    }
 
}
