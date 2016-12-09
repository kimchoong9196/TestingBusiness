package jdbc;

import domain.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class MenuJDBC {
    Statement stmt, stmt1;
     Connection con;
     
    public MenuJDBC () throws SQLException{
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password="";
            con = DriverManager.getConnection(url,username,password);
            stmt= con.createStatement();
            stmt1=con.createStatement();
    }
    
    public boolean createMenu (Menu m) throws SQLException{
      String sql = "insert into menu values('"+
               m.getId() +"','" +
               m.getFname() +"'," +
               m.getFprice() + ")";
              int result = stmt.executeUpdate(sql);
              if (result > 0)
                   return true;
              else
                  return false;
    }
    
    public ArrayList retrieveFood() throws SQLException {
        ArrayList fname = new ArrayList();
        String sql = "select food_name from menu";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            fname.add(rs.getString("food_name"));
        }
        return fname;
    }
    
    public ArrayList retrieveAllFoodId() throws SQLException {
        ArrayList id = new ArrayList();
        String sql = "select food_id from menu";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            id.add(rs.getString("food_id"));
        }
        return id;
    }
    
    public ArrayList <Menu> retrieveAllMenu() throws SQLException {
        ArrayList value = new ArrayList();
        String sql = "select * from menu";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){        
           value.add("Food Id: "+rs.getString("food_id")+"\nFood Name: "+rs.getString("food_name")+"\nPrice : RM"+rs.getDouble("food_price")+"");
        }   
        return value;
    }
    
    public String retrieveAMenu(String food_id) throws SQLException {
        
        Menu m = new Menu();
        String sql = "select * from menu where food_id ='" + food_id +"'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
           m.setId(rs.getString("food_id"));
           m.setFname(rs.getString("food_name"));
           m.setFprice(rs.getDouble("food_price"));   
        }
        
        return m.toString();  
      
    }
    
    public ArrayList retrieveId(String id) throws SQLException{
        ArrayList value = new ArrayList();
        String sql = "select * from menu where food_id ='" + id +"'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
           value.add(rs.getString("food_name"));
           value.add(rs.getString("food_price")); 
        }
        return value;
    }
    
    
    
    public boolean updateMenu(Menu m) throws SQLException { 
        String sql = "Update menu set food_name='"+
               m.getFname() +"', food_price=" +
               m.getFprice() +" where food_id='"+ m.getId()+"'";
              int result = stmt.executeUpdate(sql);
              if (result > 0)
                   return true;
              else
                  return false;    
    }
    
    public boolean deleteMenu (String fname) throws SQLException {
        String sql = "Delete from menu where food_name = '" +fname+"'";
        int rs = stmt.executeUpdate(sql);
        
        if(rs >0)
             return true;
        else
            return false;
    }
    
    public static void main(String[] args) throws Exception {
        new MenuJDBC();
    }

    public void viewMenu(DefaultTableModel model) throws SQLException{
         String sql = "select * from menu order by food_name";
        ResultSet rs = stmt.executeQuery(sql);
  
        while(rs.next()){
            String id = rs.getString("food_id");
            String food = rs.getString("food_name");
            String price = rs.getDouble("food_price") + "";
            String value [] = {id, food, price};
            model.addRow(value);
        }
    }
    
    
    
}
