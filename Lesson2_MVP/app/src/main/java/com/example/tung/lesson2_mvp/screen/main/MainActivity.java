package com.example.tung.lesson2_mvp.screen.main;

import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tung.lesson2_mvp.R;
import com.example.tung.lesson2_mvp.data.Student;
import com.example.tung.lesson2_mvp.data.StudentRepositoryImpl;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    Button btnAdd;
    EditText etId, etName, etPhone;
    StudentsAdapter adapter;
    RecyclerView rcvStudents;
    MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
    }

    private void initWidget() {

        etId = (EditText) findViewById(R.id.et_id);
        etName = (EditText) findViewById(R.id.et_name);
        etPhone = (EditText) findViewById(R.id.et_phone);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(etId.getText().toString().trim());
                String name = etName.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                Student student = new Student(id, name, phone);
                if (mPresenter.addStudent(student) != -1)
                    adapter.addItem(adapter.getItemCount(), student);
            }
        });

        mPresenter = new MainPresenter(StudentRepositoryImpl.getInstance(getApplicationContext()));
        mPresenter.setView(this);
        rcvStudents = (RecyclerView) findViewById(R.id.rcv_students);
        adapter = new StudentsAdapter(mPresenter.getAllStudents(), new StudentsAdapter.OnButtonDeleteStudentClick() {
            @Override
            public void removeItem(int position) {
                if (mPresenter.removeStudent(adapter.getItem(position).getId()) != -1)
                    adapter.removeItem(position);
            }
        });
        rcvStudents.setAdapter(adapter);
        rcvStudents.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onAddStudentSuccess() {
        Toast.makeText(this, "Add student success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRemoveStudentSuccess() {
        Toast.makeText(this, "Remove student success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddStudentError() {
        Toast.makeText(this, "Add student error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRemoveStudentError() {
        Toast.makeText(this, "Remove student error", Toast.LENGTH_SHORT).show();
    }
}
