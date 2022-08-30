package interfaceDao;

import java.util.List;
import model.Course;
import model.Student;

/**
 *
 * @author jdsfe
 */
public interface CourseDao {
    void create(Course c);

    void update(Course c);

    void delete(int id);

    List<Course> findAll();

    Course findById(int id);
}
