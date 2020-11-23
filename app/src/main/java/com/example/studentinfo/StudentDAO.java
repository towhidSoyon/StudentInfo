package com.example.studentinfo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDAO {
    @Insert
    public long insertData(Student student);

    @Query("SELECT * FROM student_table")
    public List<Student> readData();
}
