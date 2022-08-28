package interfaceDao;

import java.util.List;
import model.Student;

/**
 *
 * @author jdsfe
 */
public interface StudentDao {



    void create(Student e);

    void update(Student e);

    void delete(int id);

    List<Student> findAll();

    Student findById(int id);

}
