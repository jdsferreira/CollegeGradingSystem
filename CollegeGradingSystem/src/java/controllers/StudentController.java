/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DaoImp.StudentDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author jdsfe
 */
@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {

    StudentDaoImp dao;
    private int nb;

    @Override
    public void init() {
        dao = new StudentDaoImp();
        nb = 0;
    }

    List<Student> listStudents = new ArrayList<>();

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

        listStudents = dao.findAll();

        request.setAttribute("listStudents", listStudents);

        getServletContext().getRequestDispatcher("/listStudents.jsp").
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

        nb++;
        int id = Integer.parseInt(request.getParameter("x"));
        String action = request.getParameter("act");

        if (action.equals("delete")) {
            dao.delete(id);
            
        }
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

        nb++;

        int id1 = Integer.parseInt(request.getParameter("id"));
        String firstName1 = request.getParameter("firstName");
        String lastName1 = request.getParameter("lasttName");
        String address1 = request.getParameter("address");
        String city1 = request.getParameter("city");
        Student student1 = new Student();

        student1.setStudentId(id1);
        student1.setFirstName(firstName1);
        student1.setLastName(lastName1);
        student1.setAddress(address1);
        student1.setCity(city1);

        dao.create(student1);

        processRequest(request, response);

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
