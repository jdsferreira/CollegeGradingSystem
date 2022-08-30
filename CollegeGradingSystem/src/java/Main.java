
import DaoImp.StudentDaoImp;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author phili
 */
public class Main {

    public static void main(String[] args) {

        StudentDaoImp dao = new StudentDaoImp();
        List<Student> listStudents = new ArrayList<>();

        listStudents = dao.findAll();

        for (int i = 0; i < listStudents.size(); i++) {

            System.out.println(listStudents.get(i).getFirstName());

        }

    }

}
