package com.example.studentinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mainToolbar;
    private TextView toolbarTextView;
    private FloatingActionButton insertButton;
    private RecyclerView recyclerView;
    private StudentDB studentDB;
    private StudentAdapter adapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpDB();

        insertButton= findViewById(R.id.insertButtonId);
        mainToolbar=findViewById(R.id.mainToolbarId);
        toolbarTextView= findViewById(R.id.toolbarTextID);
        toolbarTextView.setText("Student Information");
        setSupportActionBar(mainToolbar);

        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);
        adapter= new StudentAdapter();
        studentList= new ArrayList<>();

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,InsertActivity.class);
                startActivity(intent);
            }
        });

        loadData();
    }

    private void loadData() {
        studentList= studentDB.studentDAO().readData();
        adapter.getStudentList(studentList);
        recyclerView.setAdapter(adapter);
    }


    private void setUpDB() {
        studentDB= Room.databaseBuilder(MainActivity.this, StudentDB.class, "student_database").allowMainThreadQueries().build();
    }
}