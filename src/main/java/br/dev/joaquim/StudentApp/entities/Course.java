package br.dev.joaquim.StudentApp.entities;

public class Course {
  private int id;
  private String name;

  public Course() {
  }

  public Course(String name) {
    this.name = name;
  }

  public Course(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Course " + getName() + " [" + getId() + "]";
  }
}
