 
package logic;

import domain.Payment;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdbc.PaymentJDBC;

public class PaymentBusinessTier {
        PaymentJDBC jdbc;
        
        PaymentBusinessTier() throws Exception{
            try {
            jdbc = new PaymentJDBC();
        }    catch (SQLException ex) {
            throw new Exception("error connecting to database");
        }
        }
        
        public boolean createPayment(String payment_id, String order_no, String payment_type, String account_no, double subtotal, double gst, double total) throws SQLException{
                Payment p = new Payment();
                p.setPayment_id(payment_id);
                p.setOrder_no(order_no);
                p.setPayment_type(payment_type);
                if(account_no.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the account no!");
                    return false;
                }
                else{
                p.setAccount_no(account_no);
                }
                if(subtotal==0 && gst==0 && total==0){
                    JOptionPane.showMessageDialog(null, "Empty subtotal, gst and total!");
                    return false;
                }
                else{
                        p.setSubtotal(subtotal);
                        p.setGst(gst);
                        p.setTotal(total);   
                }  
                return jdbc.createPayment(p); 
        }
        
        public String getPaymentId() throws SQLException{
            return jdbc.getPaymentId();
        } 
        
        
        
        public double calculation(String order_no) throws SQLException{
            double price = jdbc.calculation(order_no);
                return price;
          }
        
        public String retrievePayment(String payment_id) throws SQLException{
                  return  jdbc.retrievePayment(payment_id);
    }
        
         public ArrayList retrievePaymentId() throws SQLException {
            return  jdbc.retrievePaymentId();
    }
      public String generateReceipt(String payment_id, String member) throws SQLException{
        return jdbc.generateReceipt(payment_id, member);
    }
      
      public boolean updateMemberLoyalthy(String member_id) throws SQLException{
         return jdbc.updateMemberLoyalthy(member_id);
     }
      
      public ArrayList retrieveReceipt(String payment_id) throws SQLException{
        return jdbc.retrieveReceipt(payment_id);
    }
      
      public void viewItem(DefaultTableModel model, String order_no) throws SQLException{
         jdbc.viewItem(model, order_no);
}
}
