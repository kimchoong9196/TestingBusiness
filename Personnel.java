package domain;


public class Personnel {
    private static String staffId;
    private static String memberId;
    private String id;
    private String name;
    private String ic;
    private String address;
    private String gender;
    private String hp;
    private String stype;

    public Personnel() {
    }

    public Personnel(String id, String name, String ic, String address, String gender, String hp, String stype) {
        this.id = id;
        this.name = name;
        this.ic = ic;
        this.address = address;
        this.gender = gender;
        this.hp = hp;
        this.stype = stype;
    }

    public static String getStaffId() {
        return staffId;
    }

    public static void setStaffId(String staffId) {
        Personnel.staffId = staffId;
    }

    public static String getMemberId() {
        return memberId;
    }

    public static void setMemberId(String memberId) {
        Personnel.memberId = memberId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }
 
  
 
    
    
}
