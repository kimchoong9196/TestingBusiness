package domain;


public class Menu {
    private String id;
    private String fname;
    private double fprice;
   

   
    public Menu() {
    }

    public Menu(String id, String fname, double fprice) {
        this.id = id;
        this.fname = fname;
        this.fprice = fprice;
        
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public double getFprice() {
        return fprice;
    }

    public void setFprice(double fprice) {
        this.fprice = fprice;
    }

    @Override
    public String toString() {
        return "Food ID : " + id + "\nFood Name : " + fname + "\nFood Price : RM" + fprice;
    }


    
}
    
