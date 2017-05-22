package com.example.tung.lesson2_mvp.screen.main;

import com.example.tung.lesson2_mvp.data.Student;
import com.example.tung.lesson2_mvp.data.StudentRepository;

import java.util.List;

/**
 * Created by tung on 5/19/17.
 */

public class MainPresenter implements MainContract.Presenter {

    StudentRepository mStudentRepository;
    MainContract.View mMainActivity;

    public MainPresenter(StudentRepository studentRepository) {
        mStudentRepository = studentRepository;
    }

    @Override
    public void setView(MainContract.View view) {
        mMainActivity = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public long addStudent(Student student) {
        long result = mStudentRepository.addStudent(student);
        if (result == -1) mMainActivity.onAddStudentError();
        else mMainActivity.onAddStudentSuccess();
        return result;
    }

    @Override
    public int removeStudent(int id) {
        int result = mStudentRepository.removeStudent(id);
        if (result == -1) mMainActivity.onRemoveStudentError();
        else mMainActivity.onRemoveStudentSuccess();
        return result;
    }

    @Override
    public List<Student> getAllStudents() {
        return mStudentRepository.getAllStudents();
    }

}
