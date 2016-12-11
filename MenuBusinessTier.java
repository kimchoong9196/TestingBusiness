package businesstier;

import domain.Menu;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdbc.MenuJDBC;

public class MenuBusinessTier {
   MenuJDBC jdbc;
    
    public MenuBusinessTier () throws Exception {
        try {
            jdbc = new MenuJDBC();
        }    catch (SQLException ex) {
            throw new Exception("error connecting to database");
        }
    }
    
    public boolean createMenu (Menu m) throws Exception {
      Double ffprice;
      
      if(m.getFname().equals("")){
          JOptionPane.showMessageDialog(null, "Please enter the food id!");
          return false;
      } 
       
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
    
    public boolean updateMenu (Menu m) throws Exception {
        double ffprice;
  
        if(m.getFname().equals("")){
          JOptionPane.showMessageDialog(null, "Please enter the food id!");
          return false;
      }
        
       boolean success = jdbc.updateMenu(m);
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
