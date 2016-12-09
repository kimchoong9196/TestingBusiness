package logic;

import domain.Menu;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdbc.MenuJDBC;

public class MenuBusinessTier {
   MenuJDBC jdbc;
    
    MenuBusinessTier () throws Exception {
        try {
            jdbc = new MenuJDBC();
        }    catch (SQLException ex) {
            throw new Exception("error connecting to database");
        }
    }
    
    public boolean createMenu (String id, String fname, String fprice) throws Exception {
      Double ffprice;
      
      if(fname.equals("")){
          JOptionPane.showMessageDialog(null, "Please enter the food id!");
          return false;
      }

        try{
            ffprice = Double.parseDouble(fprice);
        } catch (NumberFormatException ex){
            throw new Exception("Invalid price input!!");
        }
        Menu m = new Menu();
        m.setId(id);
        m.setFname(fname);
        m.setFprice(ffprice);      
       
       boolean success = jdbc.createMenu(m);
       if (success)
        return true;
       else
           return false;
    }
    
    
    
    public ArrayList retrieveFood() throws SQLException {
        return jdbc.retrieveFood();
    }
    
    public ArrayList retrieveAllFoodId() throws SQLException {
        return jdbc.retrieveAllFoodId();
    }
    
    
    public ArrayList <Menu> retrieveAllMenu()  throws SQLException{
        return jdbc.retrieveAllMenu();
    }
    
    public String retrieveAMenu(String food_id) throws SQLException{
        String n = jdbc.retrieveAMenu(food_id);
        try{
            Menu p = new Menu();
        if(food_id.equals("")){
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
    
    public boolean updateMenu (String id, String fname, String fprice) throws Exception {
        double ffprice;
  
        if(fname.equals("")){
          JOptionPane.showMessageDialog(null, "Please enter the food id!");
          return false;
      }
        
        try{
         ffprice =Double.parseDouble(fprice);
        } catch (NumberFormatException ex){
            throw new Exception("Invalid price input!!");
        }

        Menu p = new Menu();
        p.setId(id);
        p.setFname(fname);
        p.setFprice(ffprice);
       boolean success = jdbc.updateMenu(p);
       if (success)
        return true;
       else
           return false;
        
    }
    
    public boolean deleteMenu (String fname) throws Exception {
        return jdbc.deleteMenu(fname);
    }
    
    public void viewMenu(DefaultTableModel model) throws SQLException{
           jdbc.viewMenu(model);
        }
    
    
}
