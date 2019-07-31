package com.hairui.sc.dao;

import com.hairui.sc.entity.Course;
import com.hairui.sc.entity.Student;

import java.util.List;

public interface CourseDao {
    void insert(Course course);
    void update(Course course);
    void delete(int id);
    Course select(int id);
    List<Course> selectAll();
}
