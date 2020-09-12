package cn.jhezmann.beans;

public class PersonFactory {
    public Person methodCreatePersonFactory(){
        Staff staff = new Staff();
        staff.setName("staffInFactory");
        return staff;
    }
}
