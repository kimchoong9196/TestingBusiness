
package jdbc;

import domain.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OrderJDBC {
    Connection con;
    Statement stmt,stmt2;
    Order o;
    
    public OrderJDBC() throws SQLException{
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password="";
            con = DriverManager.getConnection(url,username,password);
            stmt = con.createStatement();
            stmt2 = con.createStatement();
            
    }
    
    public boolean createOrder(Order o) throws SQLException{
            String sql = "insert into neworder(order_no,seat_no) values('"+ o.getOrder_no() + "', '" + o.getSeat_no()+"')";
            int rs = stmt.executeUpdate(sql);
            if(rs>0){
                return true;
            }
            else                
                return false;   
    }
    
    public boolean createOrderItem(Order o) throws SQLException{
            String sql = "insert into order_list values('"+ o.getOrder_no() + "', '"+ o.getItem()+"',"+o.getPrice()+")";
            int rs = stmt.executeUpdate(sql);
            if(rs>0){
                return true;
            }
            else
                 return false;   
    }
    
    public String getOrderNo() throws SQLException{
        
        String sql = "select MAX(order_no) as highestOrderNo from neworder";
        ResultSet rs = stmt.executeQuery(sql);
        String newOrderNo = null;
      
        boolean found=false;
        while (rs.next()){
           
           String temp = rs.getString("highestOrderNo");
                  if (temp!=null){
                 found = true;
             temp = temp.substring(1);
                 int iid = Integer.parseInt(temp) + 1;
           newOrderNo = "O" +iid;
      
        } 
        if (!found){
              newOrderNo = "O1000";
        }
        }
    return newOrderNo;
    }
    
    public ArrayList getFoodName() throws SQLException{
        ArrayList food = new ArrayList();
        String sql = "select food_name from menu";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            food.add(rs.getString("food_name"));
        }
        return food;
    }

    public double getPrice(String food_name) throws SQLException{
        double price = 0;
        String sql = "select food_price from menu where food_name ='"+food_name+"'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            price = rs.getDouble("food_price");
        }
        return price;
    }
    
    public String retrieveOrder(String order_no)  throws SQLException {
        Order o = new Order();
        ArrayList item_list = new ArrayList();
        String sql = "select * from order_list where order_no ='" + order_no +"'";
        String sql2 = "select * from neworder where order_no ='" + order_no +"'";
        ResultSet rs = stmt.executeQuery(sql);
        int no = 0;
        while(rs.next()){
           o.setOrder_no(rs.getString("order_no"));
           o.setItem(rs.getString("item"));
           o.setPrice(rs.getDouble("price"));
           JOptionPane.showMessageDialog(null, "Item " + (no+1) + " : " + o.getItem() + "\nPrice : " + o.getPrice());
           no++;
        }
       ResultSet rs2 = stmt2.executeQuery(sql2);
        while(rs2.next()){
          o.setSeat_no(rs2.getString("seat_no"));
        }
        return "Order No:" + o.getOrder_no() + "\nSeat No: " +o.getSeat_no()+ "\nItem: " +no;
    }
    
    public ArrayList retrieveOrderNo() throws SQLException {
        ArrayList order_no = new ArrayList();
        String sql = "select Distinct order_no from neworder";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            order_no.add(rs.getString("order_no"));
        }
        return order_no;
    }
    
    public boolean updateOrder(Order o) throws SQLException {   
           String sql = "Update neworder set seat_no='"+
           o.getSeat_no() +"' where order_no='"+ o.getOrder_no()+"'";
           int result = stmt.executeUpdate(sql);
        
              if (result > 0)
                   return true;
              else
                  return false;
        
        
    }
    
    
    
    
    public boolean deleteOrder(String order_no) throws SQLException{
        String sql = "Delete from neworder where order_no = '" +order_no+ "'";
        String sql2 = "Delete from order_list where order_no = '" +order_no+ "'";
        int r1 = stmt.executeUpdate(sql);
        int r2 = stmt2.executeUpdate(sql2);
        if(r1 > 0 && r2 > 0)
            return true;
        else
            return false;
    }
    
    public boolean resetOrderList(String order_no) throws SQLException{
        String sql = "Delete from order_list where order_no = '" +order_no+ "'";
        int r1 = stmt.executeUpdate(sql);
        if(r1 > 0)
            return true;
        else
            return false;
    }
    
    
    
    public boolean deleteAllOrder() throws SQLException{
        String sql = "Delete from neworder";
        String sql2 = "Delete from order_list";
        int r1 = stmt.executeUpdate(sql);
        int r2 = stmt2.executeUpdate(sql2);
        if(r1 > 0 && r2 > 0)
            return true;
        else
            return false;
    }
    
    public void viewOrder(DefaultTableModel model, String order_no) throws SQLException{
         String sql = "select * from order_list where order_no = '"+order_no+"'";
        ResultSet rs = stmt.executeQuery(sql);
        int i = 0;
        while(rs.next()){
            i++;
            String list = i + "";
            String item = rs.getString("item");
            String price = rs.getDouble("price")+ "";
            String value [] = {list, item, price};
            model.addRow(value);
        }
 
}
}