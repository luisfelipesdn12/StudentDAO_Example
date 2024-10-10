package br.dev.joaquim.StudentApp.entities;

public class Student {
  private int ra;
  private String name;
  private int courseId;
  private Course course;

  public Student() {
  }

  public Student(int ra, String name) {
    this.ra = ra;
    this.name = name;
  }

  public Student(int ra, String name, int courseId) {
    this.ra = ra;
    this.name = name;
    this.courseId = courseId;
  }

  public Student(int ra, String name, int courseId, Course course) {
    this.ra = ra;
    this.name = name;
    this.courseId = courseId;
    this.course = course;
  }

  public int getRa() {
    return ra;
  }

  public String getName() {
    return name;
  }

  public void setRa(int ra) {
    this.ra = ra;
  }

  public void setName(String name) {
    this.name = name;
  }
  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  @Override
  public String toString() {
    return "Student " + getName() + " [" + getRa() + "] - Course [" + (course != null ? course.getName() : "Sem curso") + "]";
  }
}

