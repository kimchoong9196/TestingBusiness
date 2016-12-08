package domain;


public class Personnel {
    private static String staffId = "s100";
    private static String memberId = "m200";
    private String id;
    private String name;
    private String ic;
    private String bdate;
    private String address;
    private String gender;
    private String hp;
    private String stype;
    private int age;
    private int loyalthy;

    
    public Personnel() {
    }

    public Personnel(String id, String name, String ic, String bdate, String address, String gender, String hp, String stype, int age, int loyalthy) {
        this.id = id;
        this.name = name;
        this.ic = ic;
        this.bdate = bdate;
        this.address = address;
        this.gender = gender;
        this.hp = hp;
        this.stype = stype;
        this.age = age;
        this.loyalthy = loyalthy;
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

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getIc() {
        return ic;
    }
    
    public void setLoyalthy(int loyalthy) {
        this.loyalthy = loyalthy;
    }

    public int getLoyalthy() {
        return loyalthy;
    }


    public String toString() {
        return  "Id : " + id + "\nName : " + name + "\nIC : " + ic +" \nBirthdate : " + bdate + "\nAddress : " + address + "\nGender : " + gender + "\nHP : " + hp + "\nType : " + stype + "\nAge : " + age+"\nLoyalthy : "+loyalthy;
    }
    
    
    
}
