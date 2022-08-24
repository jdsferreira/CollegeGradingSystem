<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    Document   : listStudents
    Created on : 2022-08-24, 11:12:08
    Author     : jdsfe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste d'étudiants</title>
    </head>
    <body>
        <table>
            <tr>
                <td>Id</td>
                <td>Prénom</td>
                <td>Nom</td>
                <td>Adresse</td>
                <td>Ville</td>
            </tr>
            <c:forEach var="student" items = "${listStudents}">
                <tr>
                    <td>${student.studentId}</td>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.address}</td>
                    <td>${student.city}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
