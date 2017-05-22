package com.example.tung.lesson2_mvp.screen.main;

import com.example.tung.lesson2_mvp.data.Student;
import com.example.tung.lesson2_mvp.screen.BasePresenter;
import com.example.tung.lesson2_mvp.screen.BaseView;

import java.util.List;

/**
 * Created by tung on 5/19/17.
 */

public class MainContract {

    interface View extends BaseView{
        void onAddStudentSuccess();
        void onRemoveStudentSuccess();
        void onAddStudentError();
        void onRemoveStudentError();
    }

    interface Presenter extends BasePresenter<View> {
        long addStudent(Student student);
        int removeStudent(int id);
        List<Student> getAllStudents();
    }
}
