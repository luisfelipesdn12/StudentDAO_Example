package br.dev.joaquim.StudentApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.dev.joaquim.StudentApp.entities.Course;

public class H2CourseDAO implements CourseDAO {
  private Connection connection;
  private String url = "jdbc:h2:file:~/data/students;";
  private String user = "root";
  private String password = "root";

  public H2CourseDAO() {
    connect();
    createTableIfNotExists();
  }

  private void connect() {
    try {
      this.connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException ex) {
      this.connection = null;
      System.out.println("Problema ao conectar no banco de dados");
      ex.printStackTrace();
    }
  }

  private void createTableIfNotExists() {
    try {
      String sql = "CREATE TABLE IF NOT EXISTS courses(" +
          "id INT AUTO_INCREMENT, name VARCHAR(256), PRIMARY KEY (id));";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.execute();
    } catch (SQLException ex) {
      System.out.println("Problema ao criar a tabela");
      ex.printStackTrace();
    } catch (NullPointerException ex) {
      System.out.println("Problema ao criar a tabela (sem conexao)");
    }
  }

  @Override
  public boolean create(Course course) {
    try {
      String sql = "INSERT INTO courses (name) VALUES(?)";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, course.getName());
      stmt.executeUpdate();

      return true;

    } catch (SQLException ex) {
      System.out.println("Problema ao criar curso");
      ex.printStackTrace();
    } catch (NullPointerException ex) {
      System.out.println("Problema ao criar curso (sem conexao)");
    }

    return false;
  }

  @Override
  public List<Course> findAll() {
    try {
      String sql = "SELECT * FROM courses";
      PreparedStatement stmt = connection.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();

      List<Course> courses = new ArrayList<>();

      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        Course course = new Course(id, name);
        courses.add(course);
      }

      return courses;

    } catch (SQLException ex) {
      System.out.println("Problema ao buscar cursos");
      ex.printStackTrace();
    } catch (NullPointerException ex) {
      System.out.println("Problema ao buscar cursos (sem conexao)");
    }

    return new ArrayList<>();
  }

  @Override
  public Course findById(int id) {
    try {
      String sql = "SELECT * FROM courses WHERE id = ?";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        String name = rs.getString("name");
        return new Course(id, name);
      }
    } catch (SQLException ex) {
      System.out.println("Problema ao buscar curso pelo ID");
      ex.printStackTrace();
    } catch (NullPointerException ex) {
      System.out.println("Problema ao buscar curso pelo ID (sem conexao)");
    }

    return null;
  }

  @Override
  public boolean update(Course course) {
    try {
      String sql = "UPDATE courses SET name = ? WHERE id = ?";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1, course.getName());
      stmt.setInt(2, course.getId());
      stmt.executeUpdate();

      return true;

    } catch (SQLException ex) {
      System.out.println("Problema ao atualizar curso");
      ex.printStackTrace();
    } catch (NullPointerException ex) {
      System.out.println("Problema ao atualizar curso (sem conexao)");
    }

    return false;
  }

  @Override
  public boolean delete(int id) {
    try {
      String sql = "DELETE FROM courses WHERE id = ?";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setInt(1, id);
      stmt.executeUpdate();

      return true;

    } catch (SQLException ex) {
      System.out.println("Problema ao apagar curso");
      ex.printStackTrace();
    } catch (NullPointerException ex) {
      System.out.println("Problema ao apagar curso (sem conexao)");
    }

    return false;
  }
}
