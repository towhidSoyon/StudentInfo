package com.example.studentinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {
    @NonNull
    private List<Student> studentList;

    public void getStudentList(List<Student> studentList){
        this.studentList=studentList;
    }
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Student student= studentList.get(position);
            holder.titleTextView.setText(student.getName());
            holder.yearTextView.setText(student.getId());
            holder.ratingTextView.setText(student.getReg());
            holder.plotTextView1.setText(student.getCourse1());
            holder.plotTextView2.setText(student.getCourse2());
            holder.plotTextView3.setText(student.getCourse3());
            holder.plotTextView4.setText(student.getCourse4());
            holder.plotTextView5.setText(student.getCourse5());
            holder.plotTextView6.setText(student.getCourse6());

        boolean isExpanded = studentList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout expandableLayout;
        TextView titleTextView, yearTextView, ratingTextView, plotTextView1,plotTextView2,plotTextView3,plotTextView4,plotTextView5,plotTextView6;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            titleTextView = itemView.findViewById(R.id.titleTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
            ratingTextView = itemView.findViewById(R.id.ratingTextView);
            plotTextView1 = itemView.findViewById(R.id.plotTextView1);
            plotTextView2 = itemView.findViewById(R.id.plotTextView2);
            plotTextView3 = itemView.findViewById(R.id.plotTextView3);
            plotTextView4 = itemView.findViewById(R.id.plotTextView4);
            plotTextView5 = itemView.findViewById(R.id.plotTextView5);
            plotTextView6 = itemView.findViewById(R.id.plotTextView6);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);

            titleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Student student = studentList.get(getAdapterPosition());
                    student.setExpanded(!student.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }
}
