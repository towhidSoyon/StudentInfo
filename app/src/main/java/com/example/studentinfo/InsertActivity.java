package com.example.studentinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity implements  View.OnClickListener{
    private Toolbar insertToolbar;
    private TextView toolbarTextView;
    private EditText insertName , insertId, insertCode1, insertCode2, insertCode3 , insertCode4,insertCode5,insertCode6, insertRegistration;
    private Button insertButton;
    private StudentDB studentDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        setUpDB();

        insertToolbar = findViewById(R.id.insertToolbarId);
        toolbarTextView=findViewById(R.id.toolbarTextID);

        insertName=findViewById(R.id.insertNameId);
        insertId = findViewById(R.id.insertStudentRollId);
        insertCode1 = findViewById(R.id.insertCourse1Id);
        insertCode2 = findViewById(R.id.insertCourse2Id);
        insertCode3 = findViewById(R.id.insertCourse3Id);
        insertCode4 = findViewById(R.id.insertCourse4Id);
        insertCode5 = findViewById(R.id.insertCourse5Id);
        insertCode6 = findViewById(R.id.insertCourse6Id);
        insertRegistration = findViewById(R.id.registrationId);



    }

    private void insertInfo(String name, String id, String course1, String course2, String course3, String course4, String course5, String course6, String reg) {
        Student student = new Student(name,id,course1,course2,course3,course4,course5,course6,reg);
        long value= studentDB.studentDAO().insertData(student);
        if(value == -1){
            Toast.makeText(this, "Insert Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Insert Success", Toast.LENGTH_SHORT).show();
        }
    }

    private void setUpDB() {
        studentDB= Room.databaseBuilder(InsertActivity.this, StudentDB.class, "student_database").allowMainThreadQueries().build();
    }

    @Override
    public void onClick(View view) {

        String name= insertName.getText().toString();
        String id = insertId.getText().toString();
        String course1 = insertCode1.getText().toString();
        String course2 = insertCode2.getText().toString();
        String course3 = insertCode3.getText().toString();
        String course4 = insertCode4.getText().toString();
        String course5 = insertCode5.getText().toString();
        String course6 = insertCode6.getText().toString();
        String reg = insertRegistration.getText().toString();

        if(name.equals("")||id.equals("")||course1.equals("")||course2.equals("")||course3.equals("")
                ||course4.equals("")||course5.equals("")||course6.equals("")||reg.equals("")){
            Toast.makeText(InsertActivity.this, "Fill all the textfield", Toast.LENGTH_SHORT).show();
        }
        else{
            insertInfo(name,id,course1,course2,course3,course4,course5,course6,reg);
        }
    }
}