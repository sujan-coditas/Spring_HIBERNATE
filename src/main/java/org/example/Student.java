package org.example;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data@Entity
@NoArgsConstructor@AllArgsConstructor@ToString
public class Student {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String course;

    public Student(String name, String city, String course) {
        this.name = name;
        this.city = city;
        this.course = course;
    }
}
