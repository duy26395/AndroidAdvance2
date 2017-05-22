package com.example.tung.lesson2_mvp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tung on 5/19/17.
 */

public class StudentRepositoryImpl extends DatabaseHelper implements StudentRepository {

    private static StudentRepositoryImpl mStudentRepository;

    public static StudentRepository getInstance(Context context) {
        if (mStudentRepository == null) mStudentRepository = new StudentRepositoryImpl(context);
        return mStudentRepository;
    }

    private StudentRepositoryImpl(Context context) {
        super(context);
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        db = getReadableDatabase();
        String[] projection = {Student.COLUMN_ID, Student.COLUMN_NAME, Student.COLUMN_PHONE};
        cursor = db.query(TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        if (cursor.moveToFirst()) {
            do {
                students.add(new Student(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = null;
        db = getReadableDatabase();
        String[] projection = {Student.COLUMN_ID, Student.COLUMN_NAME, Student.COLUMN_PHONE};
        String selection = Student.COLUMN_ID + "=?";
        String[] selectionArgs = {String.valueOf(id)};
        cursor = db.query(TABLE_NAME,        // Ten table
                projection,                         // Nhung column tra ve
                selection,                          // menh de where
                selectionArgs,                      // doi so truyen vao menh de where
                null,                               // group by
                null,                               // filter
                null                                // order by
        );
        if (cursor != null && cursor.moveToFirst()) {
            student = new Student(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
        }
        cursor.close();
        db.close();
        return student;
    }

    @Override
    public long addStudent(Student student) {
        if (student == null) return -1;
        db = this.getWritableDatabase();
        System.out.println(student.getContentValues());
        long result = db.insert(TABLE_NAME,
                null,
                student.getContentValues());
        db.close();
        return result;
    }

    @Override
    public boolean updateStudent(Student student) {
        if (student == null) return false;
        db = getWritableDatabase();
        String whereClause = Student.COLUMN_ID + "=?";
        String[] whereArgs = { String.valueOf(student.getId()) };
        long result = db.update(TABLE_NAME,
                student.getContentValues(),
                whereClause,
                whereArgs);
        return result != -1;
    }

    @Override
    public int removeStudent(int id) {
        db = this.getWritableDatabase();
        int result = db.delete(TABLE_NAME,
                Student.COLUMN_ID + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
        return result;
    }

    @Override
    public int getCount(){
        db = this.getReadableDatabase();
        cursor = db.rawQuery("SELECT  * FROM " + TABLE_NAME, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        return count;
    }
}
