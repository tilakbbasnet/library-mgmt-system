package net.diyotech.ems.model;

import java.util.Arrays;

public class Test {
    private String fullname;
    private String[] hobbies;
    private Address address;

    public Test() {
    }

    public Test(String fullname, String[] hobbies, Address address) {
        this.fullname = fullname;
        this.hobbies = hobbies;
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullname='" + fullname + '\'' +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", address=" + address +
                '}';
    }
}
