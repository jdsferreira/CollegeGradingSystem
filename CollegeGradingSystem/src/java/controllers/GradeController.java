package controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import DaoImp.GradeDaoImp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.Grade;

/**
 *
 * @author phili
 */
@WebServlet(name = "GradeController", urlPatterns = {"/GradeController"})
public class GradeController extends HttpServlet {

    GradeDaoImp dao;
    private int nb;

    @Override
    public void init() {
        dao = new GradeDaoImp();
        nb = 0;
    }

    List<Grade> listGrades = new ArrayList<>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int gradeId1 = Integer.parseInt(request.getParameter("gradeId"));
        int studentId1 = Integer.parseInt(request.getParameter("studentId"));
        int courseId1 = Integer.parseInt(request.getParameter("courseId"));
        String semester1 = request.getParameter("semester");
        int score1 = Integer.parseInt(request.getParameter("score"));

        Grade grade1 = new Grade();
        grade1.setGradeId(gradeId1);
        grade1.setStudentId(studentId1);
        grade1.setCourseId(courseId1);
        grade1.setSemester(semester1);
        grade1.setScore(score1);

        listGrades.add(grade1);

        request.setAttribute("listGrades", listGrades);

        getServletContext().getRequestDispatcher("/listGrades.jsp").
                forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        int gradeId1 = Integer.parseInt(request.getParameter("gradeId"));
        int studentId1 = Integer.parseInt(request.getParameter("studentId"));
        int courseId1 = Integer.parseInt(request.getParameter("courseId"));
        String semester1 = request.getParameter("semester");
        int score1 = Integer.parseInt(request.getParameter("score"));

        Grade grade1 = new Grade();

        grade1.setGradeId(gradeId1);
        grade1.setStudentId(studentId1);
        grade1.setCourseId(courseId1);
        grade1.setSemester(semester1);
        grade1.setScore(score1);

        dao.create(grade1);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
