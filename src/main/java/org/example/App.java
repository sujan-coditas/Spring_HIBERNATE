package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        ApplicationContext context= new ClassPathXmlApplicationContext("application.xml");
        context.getBean("studentDao", StudentDao.class);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StudentDao sd = context.getBean("studentDao", StudentDao.class);
        boolean exit = true;
        while (exit) {
            System.out.println("Enter \n 0.EXIT \n 1. INSERT \n 2.UPDATE \n 3.DELETE \n 4. GET STUDENT BY ID \n 5. All Students");
            int choice = Integer.parseInt(bf.readLine());
            switch (choice) {
                case 1:
                    sd.insert();
                    break;
                case 2:
                    sd.update();
                    break;
                case 3:
                    sd.delete();
                    break;
                case 4:
                    sd.getStudentById();
                    break;
                case 5:
                    sd.studentList();
                    break;
                case 0:
                    exit = false;
                    break;

                default:
                    System.out.println("Enter valid option");
                    break;
            }
        }

    }
}
