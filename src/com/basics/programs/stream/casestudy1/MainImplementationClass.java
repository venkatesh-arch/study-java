package com.basics.programs.stream.casestudy1;

import java.util.List;

public class MainImplementationClass {
    public String name;
    public int age;
    public  Address address;
    public List<MobileNumber> mobileNumbers;

    public MainImplementationClass(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.mobileNumbers = mobileNumbers;
    }
}
