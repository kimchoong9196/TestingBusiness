package jdbc;

import domain.Payment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PaymentJDBC {
    Connection con;
    Statement stmt,stmt2;
    Payment o;
    
    public PaymentJDBC() throws SQLException{
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password="";
            con = DriverManager.getConnection(url,username,password);
            stmt = con.createStatement();
            stmt2 = con.createStatement();     
    }
    
    public boolean createPayment(Payment p) throws SQLException{
        String sql = "insert into payment values('"+p.getPayment_id()+"','"+p.getOrder_no()+"','"+p.getPayment_type()
                +"','"+p.getAccount_no()+"'," +p.getSubtotal()+"," +p.getGst()+","+p.getTotal()+")";
        int rs = stmt.executeUpdate(sql);
        if(rs>0)
            return true;
        else
            return false;
    }
    
    public String getPaymentId() throws SQLException{
        
        String sql = "select MAX(payment_id) as highestPaymentId from payment";
        ResultSet rs = stmt.executeQuery(sql);
        String newPaymentId = null;
      
        boolean found=false;
        while (rs.next()){
           
           String temp = rs.getString("highestPaymentId");
                  if (temp!=null){
                 found = true;
             temp = temp.substring(1);
                 int iid = Integer.parseInt(temp) + 1;
           newPaymentId = "P" +iid;
      
        } 
        if (!found){
              newPaymentId = "P1000";
        }
        }
    return newPaymentId;
    }
    
    public double calculation(String order_no) throws SQLException{
        double price=0;
        String sql = "select sum(price) as newprice from order_list where order_no = '" +order_no+ "'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            price = rs.getDouble("newprice");
        }
        return price;
    }
    
    public String retrievePayment(String payment_id) throws SQLException{
        String sql = "select * from payment where payment_id = '" +payment_id+ "'";
        String order_no="", payment_type="", account_no="";
        double subtotal=0.0, gst=0.0, total=0.0;
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
        order_no = rs.getString("order_no");
        payment_type = rs.getString("payment_type");
        account_no = rs.getString("account_no");
        subtotal = rs.getDouble("subtotal");
        gst = rs.getDouble("gst");
        total = rs.getDouble("total");
        }
        String sql2 = "select * from order_list where order_no ='"+order_no+"'";
        ResultSet rs2 = stmt2.executeQuery(sql2);
        int no = 0;
        while(rs2.next()){
           JOptionPane.showMessageDialog(null, "Item " + (no+1) + " : " + rs2.getString("item") + "\nPrice : " + rs2.getDouble("price"));
           no++;
        }
        
        return "Payment ID : " +payment_id+ "\nOrder NO :"+ order_no+ "\nPayment Type : "+ payment_type + "\nAccount No:"
                +account_no+ "\nSubtotal: RM" + subtotal +"\nGST: RM"+gst+"\nTotal Price : RM" +total;
    }
    
     public ArrayList retrievePaymentId() throws SQLException {
        ArrayList payment_id = new ArrayList();
        String sql = "select Distinct payment_id from payment";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            payment_id.add(rs.getString("payment_id"));
        }
        return payment_id;
    }
     
     public String generateReceipt(String payment_id, String member) throws SQLException{
        String sql = "select * from payment where payment_id = '" +payment_id+ "'";
        String order_no="", payment_type="", account_no="";
        double subtotal=0.0, gst=0.0, total=0.0;
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
        order_no = rs.getString("order_no");
        payment_type = rs.getString("payment_type");
        account_no = rs.getString("account_no");
        subtotal = rs.getDouble("subtotal");
        gst = rs.getDouble("gst");
        total = rs.getDouble("total");
        }
        String sql2 = "select * from order_list where order_no ='"+order_no+"'";
        ResultSet rs2 = stmt2.executeQuery(sql2);
        int no = 0;
        while(rs2.next()){
           no++;
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return "Payment ID : " +payment_id+ "\nOrder NO :"+ order_no+ "\nPayment Type : "+payment_type + "\nMember : " +member+ "\nAccount No:"
                +account_no+ "\nSubtotal: RM" + subtotal +"\nGST: RM"+gst+"\nTotat Price: RM" +total+"\nTime : "+ dateFormat.format(cal.getTime());
    }
     
     public boolean updateMemberLoyalthy(String member_id) throws SQLException{
         String sql ="select loyalthy from personnel where id ='" +member_id+ "'";
         int add = 0;
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next()){
             add=rs.getInt("loyalthy");
         }
         add += 1;
         String sql2 ="Update personnel set loyalthy =" +add+" where id = '" +member_id+ "'";
         int rs2 = stmt2.executeUpdate(sql2);
         if(!(rs2>0)){
             JOptionPane.showMessageDialog(null, "Error in updating member loyalthy!!!");
             return false;
         }
         else
             return true;
         }
     
     public ArrayList retrieveReceipt(String payment_id) throws SQLException{
        String sql = "select * from payment where payment_id = '" +payment_id+ "'";
        ArrayList value = new ArrayList();
        String order_no="", payment_type="", account_no="";
        double subtotal=0.0, gst=0.0, total=0.0;
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
        value.add(rs.getString("order_no"));
        value.add(rs.getString("payment_type"));
        value.add(rs.getString("account_no"));
        value.add(rs.getDouble("subtotal")+"");
        value.add(rs.getDouble("gst")+"");
        value.add(rs.getDouble("total")+"");
        }
        
        return value;
    }
     
     public void viewItem(DefaultTableModel model, String order_no) throws SQLException{
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
