package com.example.studentinfo;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Student.class}, version = 1,exportSchema = false)
public abstract class StudentDB extends RoomDatabase {

    public abstract StudentDAO studentDAO();
}
