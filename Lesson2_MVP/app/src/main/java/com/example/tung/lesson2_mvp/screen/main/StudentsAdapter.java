package com.example.tung.lesson2_mvp.screen.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tung.lesson2_mvp.R;
import com.example.tung.lesson2_mvp.data.Student;

import java.util.List;

/**
 * Created by tung on 5/19/17.
 */

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    List<Student> mStudents;
    OnButtonDeleteStudentClick mOnButtonDeleteStudentClick;

    public StudentsAdapter(List<Student> students, OnButtonDeleteStudentClick onButtonDeleteStudentClick) {
        mStudents = students;
        mOnButtonDeleteStudentClick = onButtonDeleteStudentClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        View v = layoutInflater.inflate(R.layout.item_student, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mStudents.get(position));
    }

    @Override
    public int getItemCount() {
        return mStudents != null ? mStudents.size() : 0;
    }

    public Student getItem(int position) {
        return mStudents.get(position);
    }

    public void addItem(int position, Student student){
        mStudents.add(position,student);
        notifyItemInserted(position);
    }

    public void removeItem(int position){
        mStudents.remove(position);
        notifyItemRemoved(position);
    }

    public void updateItem(int position, Student student){
        mStudents.set(position,student);
        notifyItemChanged(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvId, tvName, tvPphone;
        private Button btnDelele;

        public ViewHolder(View itemView) {
            super(itemView);

            tvId = (TextView) itemView.findViewById(R.id.tv_id);
            tvName = (TextView) itemView.findViewById(R.id.et_name);
            tvPphone = (TextView) itemView.findViewById(R.id.et_phone);
            btnDelele = (Button) itemView.findViewById(R.id.btn_delete);

            btnDelele.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnButtonDeleteStudentClick.removeItem(getAdapterPosition());
                }
            });
        }

        public void bindData(Student student) {
            if (student == null) return;
            tvId.setText("" + student.getId());
            tvName.setText("Name: " + student.getName());
            tvPphone.setText("Phone: " + student.getPhone());
        }
    }

    public interface OnButtonDeleteStudentClick {
        void removeItem(int position);
    }
}
