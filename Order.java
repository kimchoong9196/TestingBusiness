
package domain;

import javax.swing.JOptionPane;

public class Order {
    private static String order_no="O1000";
    private String seat_no;
    private String item;
    private double price;
    
    public Order(String order_no, String seat_no, String item, double price){
        this.order_no = order_no;
        this.seat_no = seat_no;
        this.item = item;
        this.price = price;
    }
   public Order(){
        
    }
    
    public String getOrder_no() {
        return order_no;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return  "Order No : " + order_no + "\nSeat No : " + seat_no + "\nItem : " + item + "\nPrice : RM" +price;
    }
    
    
}
