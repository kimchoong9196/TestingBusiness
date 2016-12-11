package jdbc;

import domain.Personnel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PersonnelJDBC {
    Statement stmt, stmt1;
    PreparedStatement stmt2;
     Connection con;
     
    public PersonnelJDBC () throws SQLException{
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password="";
            con = DriverManager.getConnection(url,username,password);
            stmt= con.createStatement();
            stmt1=con.createStatement();
    }
    
    public String setStaffId(String stype )throws SQLException{
        String type = "S";
        String sql = "select MAX(id) as highestId from personnel where stype=?";
        stmt2 = con.prepareStatement(sql);
        stmt2.setString(1, type);
      
        ResultSet rs = stmt2.executeQuery();
        String newId = null;
      
        boolean found=false;
        while (rs.next()){
           
           String temp = rs.getString("highestId");
                  if (temp!=null){
                 found = true;
             temp = temp.substring(1);
                 int iid = Integer.parseInt(temp) + 1;
           newId = type +iid;
      
        } }
        if (!found)
            newId = "S100";

            return newId;    
    }
    
    public String setMemberId(String stype )throws SQLException{
        String type = "M";
        String sql = "select MAX(id) as highestId from personnel where stype=?";
        stmt2 = con.prepareStatement(sql);
        stmt2.setString(1, type);
      
        ResultSet rs = stmt2.executeQuery();
        String newId = null;
      
        boolean found=false;
        while (rs.next()){
           
           String temp = rs.getString("highestId");
                  if (temp!=null){
                 found = true;
             temp = temp.substring(1);
                 int iid = Integer.parseInt(temp) + 1;
           newId = type +iid;
      
        } }
        if (!found)
            newId = "M100";

            return newId;    
    }
             
    
    public boolean createPersonnnel (Personnel p) 
                        throws SQLException{
      String sql = "insert into personnel values('"+
               p.getId() +"','" +
               p.getName() +"','" +
               p.getIc() +"','" +
               p.getAddress()+ "','" +
               p.getGender() + "','" +
               p.getHp() + "','" +
               p.getStype() +"')";
              int result = stmt.executeUpdate(sql);
        
              if (result > 0)
                   return true;
              else
                  return false;
    }
    
    public ArrayList retrieveName() throws SQLException {
        ArrayList name = new ArrayList();
        String sql = "select name from personnel";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            name.add(rs.getString("name"));
        }
        return name;
    }
    
    public ArrayList retrieveAllId() throws SQLException {
        ArrayList id = new ArrayList();
        String sql = "select id from personnel";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            id.add(rs.getString("id"));
        }
        return id;
    }
    
    
    public String retrieveAPersonnel(String name) throws SQLException {  
        Personnel p = new Personnel();
        String sql = "select * from personnel where name ='" + name +"'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
           p.setId(rs.getString("id"));
           p.setName(rs.getString("name"));
           p.setIc(rs.getString("ic"));
           p.setGender(rs.getString("gender"));
           p.setHp(rs.getString("hp"));
           p.setStype(rs.getString("stype"));
           p.setAddress(rs.getString("address"));
        }
        
        return p.toString();  
    }
    
    public ArrayList retrieveId(String id) throws SQLException{
        ArrayList value = new ArrayList();
        String sql = "select * from personnel where id ='" + id +"'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
           value.add(rs.getString("name"));
           value.add(rs.getString("ic"));
           value.add(rs.getString("address"));
           value.add(rs.getString("gender"));
           value.add(rs.getString("hp"));
           
        }
        return value;
    }
    
    
    
    public boolean updatePersonnel (Personnel p)
            throws SQLException {
        
        String sql = "Update personnel set name='"+
               p.getName() + "', ic='" +
               p.getIc() + "', address='" +
               p.getAddress()+ "', gender='" +
               p.getGender() + "', hp='" +
               p.getHp()  +"' where id='"+ p.getId()+"'";
              int result = stmt.executeUpdate(sql);
        
              if (result > 0)
                   return true;
              else
                  return false;
        
        
    }
    
    public boolean deletePersonnel (String name)
            throws SQLException {
        String sql = "Delete from personnel where name = '" +name+"'";
        int rs = stmt.executeUpdate(sql);
        
        if(rs >0)
             return true;
        else
            return false;
    }
    
    public ArrayList getStaffId(String type) throws SQLException{
        ArrayList staff_id = new ArrayList();
        String sql = "select Distinct id from personnel where stype = '" +type+"'";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            staff_id.add(rs.getString("id"));
        }
        return staff_id;
    }
    
    public void viewPersonnel(DefaultTableModel model) throws SQLException{
         String sql = "select * from personnel order by name";
        ResultSet rs = stmt.executeQuery(sql);
  
        while(rs.next()){
            String id = rs.getString("id");
            String name = rs.getString("name");
            String ic = rs.getString("ic");
            String address = rs.getString("address");
            String gender = rs.getString("gender");
            String hp = rs.getString("hp");
            String stype = rs.getString("stype");
            String value [] = {id, name, ic, address, gender, hp, stype};
            model.addRow(value);
        }
    }
}
