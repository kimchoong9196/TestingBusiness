package logic;

import domain.Personnel;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdbc.PersonnelJDBC;

public class PersonnelBusinessTier {
    PersonnelJDBC jdbc;
    
    PersonnelBusinessTier () throws Exception {
        try {
            jdbc = new PersonnelJDBC();
        }    catch (SQLException ex) {
            throw new Exception("error connecting to database");
        }
    }
    
    public String createPersonnel (String name, String ic,
            String bdate, String address,
            String gender, String hp, String stype,
            String age) throws Exception {
        int iage;
        int iic;

        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Invalid name input");
            return "";
        } 
        
         if(ic.equals("")){
            JOptionPane.showMessageDialog(null, "Invalid IC No input");
            return "";
        } 
 
        if(bdate.equals("")){
            JOptionPane.showMessageDialog(null, "Invalid birthdate input");
            return "";
        } 
        if(address.equals("")){
            JOptionPane.showMessageDialog(null, "Invalid address input");
            return "";
        } 
        if(hp.equals("")){
            JOptionPane.showMessageDialog(null, "Invalid hp input");
            return "";
        } 
        
        try{
            iage = Integer.parseInt(age);
        } catch (NumberFormatException ex){
            throw new Exception("Invalid age format");
        }
        
        Personnel p = new Personnel();
        if (stype.equals("staff"))
            p.setId(jdbc.setStaffId(stype));
        else
            p.setId(jdbc.setMemberId(stype));
        p.setName(name);
        p.setIc(ic);
        p.setBdate(bdate);
        p.setAddress(address);
        p.setGender(gender);
        p.setHp(hp);
        if (stype.equals("staff"))
            p.setStype("s");
        else
            p.setStype("m");
        p.setAge(iage);
        p.setLoyalthy(0);
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
    
    public boolean updatePersonnel (String id, String name, String ic, String bdate, String address,
            String gender, String hp, 
            String age
            ) throws Exception {
        int iage;
      
       if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Invalid name input");
            return false;
        } 
        
         if(ic.equals("")){
            JOptionPane.showMessageDialog(null, "Invalid IC No input");
            return false;
        } 

        if(bdate.equals("")){
            JOptionPane.showMessageDialog(null, "Invalid birthdate input");
            return false;
        } 

        if(address.equals("")){
            JOptionPane.showMessageDialog(null, "Invalid address input");
            return false;
        } 
        if(hp.equals("")){
            JOptionPane.showMessageDialog(null, "Invalid hp input");
            return false;
        } 
        
        try{
            iage = Integer.parseInt(age);
        } catch (NumberFormatException ex){
            throw new Exception("invalid age format");
        }
    
        Personnel p = new Personnel();
        p.setId(id);
        p.setName(name);
        p.setIc(ic);
        p.setBdate(bdate);
        p.setAddress(address);
        p.setGender(gender);
        p.setHp(hp);
        p.setAge(iage);
       boolean success = jdbc.updatePersonnel(p);
       if (success)
        return true;
       else
           return false;
        
    }
    
    public boolean deletePersonnel (String name) throws Exception {
                    return jdbc.deletePersonnel(name);
    }
    
    public ArrayList getStaffId(String type) throws SQLException{
        return jdbc.getStaffId(type);
    }
    public void viewPersonnel(DefaultTableModel model) throws SQLException{
           jdbc.viewPersonnel(model);
        }
 
}
