package com.basics.programs.stream.casestudy1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        /* Initialize students with values */
        Student student1 = new Student(
                "Stream",
                20,
                new Address("2020"),
                Arrays.asList(new MobileNumber("9112331333"), new MobileNumber("9112331323")));

        Student student2 = new Student(
                "Java",
                20,
                new Address("1990"),
                Arrays.asList(new MobileNumber("9112331334"), new MobileNumber("9112331324"), new MobileNumber("9112331325")));

        Student student3 = new Student(
                "Spring",
                20,
                new Address("2010"),
                Arrays.asList(new MobileNumber("9112331335"), new MobileNumber("9112331336")));

        List<Student> students = Arrays.asList(student1, student2, student3);

        /*****************************************************
         Get student with exact match name "Stream"
         *****************************************************/
        Optional<Student> studName = students.stream()
                .filter(student -> student.getName().equals("Stream"))
                .findFirst();
        System.out.println(studName.isPresent() ? "Student name "+studName.get().getName()+" matched" : "No student found");

        /*****************************************************
         Get student with matching zipcode "1990"
         *****************************************************/
        Optional<Student> studAddress = students.stream()
                .filter(student -> student.getAddress().getZipcode().equals("1991"))
                .findFirst();
        System.out.println(studAddress.isPresent() ? "Student Address "+studAddress.get().getAddress().getZipcode()+" matched" : "No Address found");

        /*****************************************************
         Get all student having mobile numbers 9112331334
         *****************************************************/
        List<Student> stud2 = students.stream()
                .filter(student -> student.getMobileNumbers().stream().anyMatch(obj -> Objects.equals(obj.getNumber(), "9112331334")))
                .collect(Collectors.toList());

        String result1 = stud2.stream().map(std -> std.getName()).collect(Collectors.joining(",", "[", "]"));
        System.out.println(result1);
        System.out.println("--------------------");
    }
}
