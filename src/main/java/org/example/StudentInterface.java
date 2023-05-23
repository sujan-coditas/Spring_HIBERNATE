package org.example;

import java.io.IOException;

public interface StudentInterface  {
    void insert() throws IOException;


    void update() throws IOException;
    void delete() throws IOException;

    void studentList();
}
