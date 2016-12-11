
package domain;

public class Payment {
    private String payment_id;
    private String order_no;
    private String payment_type;
    private String account_no;
    private double subtotal;
    private double gst;
    private double total;
    
    public Payment(){  
     }
    

    public Payment(String payment_id, String order_no, String payment_type, String account_no, double subtotal, double gst, double total){
        this.payment_id = payment_id;
        this.order_no = order_no;
        this.payment_type = payment_type;
        this.account_no = account_no;
        this.subtotal = subtotal;
        this.gst = gst;
        this.total = total;
    }
    
    
    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getGst() {
        return gst;
    }

    public double getTotal() {
        return total;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getPayment_type() {
        return payment_type;
    }
    
    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getAccount_no() {
        return account_no;
    }
    
    public String toString(){
        return "Payment ID : " +payment_id+ "\nOrder NO :"+ order_no+ "\nPayment Type : "+ payment_type + "\nAccount No:"
                +account_no+ "\nSubtotal: RM" + subtotal +"\nGST: RM"+gst+"\nTotat Price: RM" +total;
    }
}
