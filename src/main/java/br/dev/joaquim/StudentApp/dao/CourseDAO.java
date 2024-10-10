package br.dev.joaquim.StudentApp.dao;

import java.util.List;

import br.dev.joaquim.StudentApp.entities.Course;

public interface CourseDAO {
  public boolean create(Course course);

  public List<Course> findAll();

  public Course findById(int id);

  public boolean update(Course course);

  public boolean delete(int id);
}
