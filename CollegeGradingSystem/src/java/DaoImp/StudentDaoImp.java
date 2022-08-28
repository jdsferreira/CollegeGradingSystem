package DaoImp;

import connection.ConnectionFactory;
import interfaceDao.StudentDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author jdsfe
 */
public class StudentDaoImp implements StudentDao {

    Connection connection = ConnectionFactory.getConnection();

    public StudentDaoImp() {
    }

    public void create(Student student) {
        PreparedStatement preparedStatement;

        try {
            String createQuery = "INSERT INTO student (studentid, firstname, lastname, address, city) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getCity());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String selectIdQuery = "SELECT  * FROM student where studentid = ?";
            preparedStatement = connection.prepareStatement(selectIdQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            resultSet.next();
            student = new Student();
            student.setStudentId(resultSet.getInt("studentid"));
            student.setFirstName(resultSet.getString("firstName"));
            student.setLastName(resultSet.getString("lastName"));
            student.setAddress(resultSet.getString("address"));
            student.setCity(resultSet.getString("city"));
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return student;
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        Student student = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String selectAllQuery = "SELECT * FROM student ORDER BY ID";
            preparedStatement = connection.prepareStatement(selectAllQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                student.setStudentId(resultSet.getInt("studentid"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                student.setAddress(resultSet.getString("address"));
                student.setCity(resultSet.getString("city"));
                students.add(student);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return students;

    }

    public void update(Student student) {
        PreparedStatement preparedStatement;

        try {
            String updateQuery = "UPDATE student SET firstname = ?, lastname = ?, address = ?, city = ? WHERE studentid = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getCity());
            preparedStatement.setInt(5, student.getStudentId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(int id) {
        PreparedStatement preparedStatement;

        try {
            String deleteQuery = "DELETE FROM student WHERE studentid = " + id;
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
