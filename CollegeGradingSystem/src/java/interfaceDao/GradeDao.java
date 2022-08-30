package interfaceDao;

import java.util.List;
import model.Grade;

/**
 *
 * @author jdsfe
 */
public interface GradeDao {

    void create(Grade g);

    void update(Grade g);

    void delete(int id);

    List<Grade> findAll();

    Grade findById(int id);

}
