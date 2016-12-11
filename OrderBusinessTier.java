package logic;

import domain.Order;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdbc.OrderJDBC;


public class OrderBusinessTier {
        OrderJDBC jdbc;
        
        OrderBusinessTier() throws Exception{
            try {
            jdbc = new OrderJDBC();
        }    catch (SQLException ex) {
            throw new Exception("error connecting to database");
        }
        }
        
        public boolean createOrder(String order_no, String seat_no) throws Exception{
            String newOrderNo = jdbc.getOrderNo();
            Order o = new Order();
            o.setOrder_no(order_no);
            if(seat_no.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the seat no!");
                return false;
            }
            o.setSeat_no(seat_no);
            boolean success = jdbc.createOrder(o);
            if(success)
                return true;
            else
                return false;
        }
        
        public String createOrderItem(String Item) throws Exception{
            Order o = new Order();
            o.setItem(Item);
            o.setPrice(jdbc.getPrice(Item));
            boolean success = jdbc.createOrderItem(o);
            if(success)
                return jdbc.getOrderNo();
            return null;
        }
        
        public String retrieveOrder(String order_no)  throws Exception {
            return jdbc.retrieveOrder(order_no);
       
    } 
         public ArrayList getFoodName() throws SQLException{
        
        return jdbc.getFoodName();
    }
        
        public ArrayList retrieveOrderNo() throws SQLException {
        ArrayList order_no = jdbc.retrieveOrderNo();
        
        return order_no;
    }
        
     public boolean updateOrder(String order_no, String seat_no) throws Exception {

        Order o = new Order();
        if(seat_no.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter the seat no!!!");
            return false;
        }
        o.setOrder_no(order_no);
        o.setSeat_no(seat_no);
        
       boolean success = jdbc.updateOrder(o);
       if (success)
        return true;
       else
           return false;
        
    }   
        
        
    public boolean deleteOrder(String order_no) throws SQLException{
         return jdbc.deleteOrder(order_no);
    }    
        
     public boolean deleteAllOrder() throws SQLException{
         return jdbc.deleteAllOrder();
    }    
     
    public String getOrderNo() throws SQLException{
            return jdbc.getOrderNo();
    } 
    
    public String createNewOrderItem(String order_no, String Item) throws Exception{
            Order o = new Order();
            o.setOrder_no(order_no);
            o.setItem(Item);
            o.setPrice(jdbc.getPrice(Item));
            boolean success = jdbc.createOrderItem(o);
            if(success)
                return jdbc.getOrderNo();
            return null;
        }
    
    public boolean resetOrderList(String order_no) throws SQLException{
            return jdbc.resetOrderList(order_no);
    }
    
    public void viewOrder(DefaultTableModel model, String order_no) throws SQLException{
           jdbc.viewOrder(model, order_no);
        }
}
        

