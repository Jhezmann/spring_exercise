package cn.jhezmann.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Person {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private List<String> hobbies;
    private Map<Integer,String> course;
    private Mate mate;
    private User user;

    public Person() {
        System.out.println("Person类加载。");
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setCourse(Map<Integer, String> course) {
        this.course = course;
    }

    public void setMate(Mate mate) {
        this.mate = mate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public Map<Integer, String> getCourse() {
        return course;
    }

    public Mate getMate() {
        return mate;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Person{" +
                "\nid=" + id +
                ", \nname='" + name + '\'' +
                ", \ngender='" + gender + '\'' +
                ", \nbirthday=" + birthday +
                ", \nhobbies=" + hobbies +
                ", \ncourse=" + course +
                ", \nmate=" + mate +
                ", \nuser=" + user +
                "\n}";
    }

    public static Person creatPersonFactory(){
        Staff staff = new Staff();
        staff.setName("staffInFactory");
        return staff;
    }
}
