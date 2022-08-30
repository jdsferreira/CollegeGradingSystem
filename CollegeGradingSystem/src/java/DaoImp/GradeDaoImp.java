package DaoImp;

import connection.ConnectionFactory;
import interfaceDao.GradeDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Grade;

/**
 *
 * @author jdsfe
 */
public class GradeDaoImp implements GradeDao {

    Connection connection = ConnectionFactory.getConnection();

    public GradeDaoImp() {

    }

    public void create(Grade grade) {
        PreparedStatement preparedStatement;

        try {
            String createQuery = "INSERT INTO grade (gradeid, studentid, courseid, semester, score) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setInt(1, grade.getGradeId());
            preparedStatement.setInt(2, grade.getStudentId());
            preparedStatement.setInt(3, grade.getCourseId());
            preparedStatement.setString(4, grade.getSemester());
            preparedStatement.setInt(5, grade.getScore());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Grade findById(int id) {
        Grade grade = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String selectIdQuery = "SELECT  * FROM grade where gradeid = ?";
            preparedStatement = connection.prepareStatement(selectIdQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            resultSet.next();
            grade = new Grade();
            grade.setGradeId(resultSet.getInt("gradeid"));
            grade.setStudentId(resultSet.getInt("studentid"));
            grade.setCourseId(resultSet.getInt("courseid"));
            grade.setSemester(resultSet.getString("semester"));
            grade.setScore(resultSet.getInt("score"));

            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return grade;
    }

    public List<Grade> findAll() {
        List<Grade> grades = new ArrayList<>();
        Grade grade = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String selectAllQuery = "SELECT * FROM grade ORDER BY ID";
            preparedStatement = connection.prepareStatement(selectAllQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                grade = new Grade();
                grade.setGradeId(resultSet.getInt("gradeid"));
                grade.setStudentId(resultSet.getInt("studentid"));
                grade.setCourseId(resultSet.getInt("courseid"));
                grade.setSemester(resultSet.getString("semester"));
                grade.setScore(resultSet.getInt("score"));
                grades.add(grade);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return grades;

    }

    public void update(Grade grade) {
        PreparedStatement preparedStatement;

        try {
            String updateQuery = "UPDATE grade SET  studentid = ?, courseid = ?, semester = ?, score = ? WHERE gradeid = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, grade.getStudentId());
            preparedStatement.setInt(2, grade.getCourseId());
            preparedStatement.setString(3, grade.getSemester());
            preparedStatement.setInt(4, grade.getScore());
            preparedStatement.setInt(5, grade.getGradeId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(int id) {
        PreparedStatement preparedStatement;

        try {
            String deleteQuery = "DELETE FROM grade WHERE gradeid = " + id;
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
