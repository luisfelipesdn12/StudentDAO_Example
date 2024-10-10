package br.dev.joaquim.StudentApp.dao;

import java.util.List;

import br.dev.joaquim.StudentApp.entities.Student;

public interface StudentDAO {
  public boolean create(Student student);

  public List<Student> findAll();

  public Student findByRa(int ra);

  public boolean update(Student student);

  public boolean setCourse(int ra, int courseId);

  public boolean delete(int ra);
}
