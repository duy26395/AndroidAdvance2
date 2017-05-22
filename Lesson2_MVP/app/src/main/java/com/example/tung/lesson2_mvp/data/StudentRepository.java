package com.example.tung.lesson2_mvp.data;

import java.util.List;

/**
 * Created by tung on 5/19/17.
 */

public interface StudentRepository {

    List<Student> getAllStudents();

    Student getStudentById(int id);

    long addStudent(Student student);

    boolean updateStudent(Student student);

    int removeStudent(int id);

    int getCount();
}
