package DaoImp;

import connection.ConnectionFactory;
import interfaceDao.CourseDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Course;

/**
 *
 * @author jdsfe
 */
public class CourseDaoImp implements CourseDao {

    Connection connection = ConnectionFactory.getConnection();

    public CourseDaoImp() {
    }

    public void create(Course course) {
        PreparedStatement preparedStatement;

        try {
            String createQuery = "INSERT INTO course (courseid, coursename, creditnumber) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setInt(1, course.getCourseId());
            preparedStatement.setString(2, course.getCourseName());
            preparedStatement.setInt(3, course.getCreditNumber());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Course findById(int id) {
        Course course = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String selectIdQuery = "SELECT  * FROM course where courseid = ?";
            preparedStatement = connection.prepareStatement(selectIdQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            resultSet.next();
            course = new Course();
            course.setCourseId(resultSet.getInt("courseid"));
            course.setCourseName(resultSet.getString("coursename"));
            course.setCreditNumber(resultSet.getInt("creditnumber"));
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return course;
    }

    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        Course course = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String selectAllQuery = "SELECT * FROM course ORDER BY courseid";
            preparedStatement = connection.prepareStatement(selectAllQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                course = new Course();
                course.setCourseId(resultSet.getInt("courseid"));
                course.setCourseName(resultSet.getString("coursename"));
                course.setCreditNumber(resultSet.getInt("creditnumber"));
                courses.add(course);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return courses;

    }

    public void update(Course course) {
        PreparedStatement preparedStatement;

        try {
            String updateQuery = "UPDATE course SET coursename = ?, creditnumber = ? WHERE courseid = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setInt(2, course.getCreditNumber());
            preparedStatement.setInt(3, course.getCourseId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(int id) {
        PreparedStatement preparedStatement;

        try {
            String deleteQuery = "DELETE FROM course WHERE courseid = " + id;
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
