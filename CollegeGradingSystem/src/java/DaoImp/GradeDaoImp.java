package DaoImp;

import connection.ConnectionFactory;
import interfaceDao.GradeDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Grade;
/**
 *
 * @author jdsfe
 */
public class GradeDaoImp implements GradeDao{
    Connection connection = ConnectionFactory.getConnection();

    public GradeDaoImp() {


    }
public void create(Grade grade) {
        PreparedStatement preparedStatement;

        try {
            String createQuery = "INSERT INTO grade (studentid, courseid, semester, score) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setInt(1, grade.getStudentId());
            preparedStatement.setInt(2, grade.getCourseId());
            preparedStatement.setString(3, grade.getSemester());
            preparedStatement.setInt(4, grade.getScore());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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

}
