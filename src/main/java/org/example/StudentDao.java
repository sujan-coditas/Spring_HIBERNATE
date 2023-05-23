package org.example;

import org.springframework.orm.hibernate5.HibernateTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentDao implements StudentInterface {

    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public StudentDao() {
    }


    @Override
    public void insert() throws IOException {
        System.out.println("enter name");
        String name=bf.readLine();
        System.out.println("enter city");
        String city=bf.readLine();
        System.out.println("enter course");
        String course=bf.readLine();
        Student student=new Student(name,city,course);
        hibernateTemplate.setCheckWriteOperations(false); // Disable write operation check
        hibernateTemplate.save(student);
        System.out.println("Data Saved ");

    }

    @Override
    public void update() throws IOException {
        System.out.println("Enter the student ID to update:");
        int id = Integer.parseInt(bf.readLine());

        Student student = hibernateTemplate.get(Student.class, id);
        if (student != null) {
            System.out.println("Enter updated name:");
            String name = bf.readLine();
            System.out.println("Enter updated city:");
            String city = bf.readLine();
            System.out.println("Enter updated course:");
            String course = bf.readLine();

            student.setName(name);
            student.setCity(city);
            student.setCourse(course);
            hibernateTemplate.setCheckWriteOperations(false); // Disable write operation check

            hibernateTemplate.update(student);

            System.out.println("Data updated.");
        } else {
            System.out.println("No records found for ID " + id);
        }
    }


    @Override
    public void delete() throws IOException {
        System.out.println("Enter the student ID to update:");
        int id = Integer.parseInt(bf.readLine());


    }

    @Override
    public void studentList() {

    }

    public void getStudentById() {
    }
}
