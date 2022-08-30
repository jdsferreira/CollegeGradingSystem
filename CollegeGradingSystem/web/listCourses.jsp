<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    Document   : listCourses
    Created on : Aug 24, 2022, 1:56:40 PM
    Author     : phili
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des cours</title>
    </head>
    <body>
        <table>
            <tr>
                <td>Id</td>
                <td>Nom</td>
                <td>Nombre de crédits </td>
            </tr>
            <c:forEach var="course" items = "${listCourses}">
                <tr>
                    <td>${course.courseId}</td>
                    <td>${course.courseName}</td>
                    <td>${course.creditNumber}</td>
                    <td><a href="<c:url value='/CourseController?x=${course.courseId}&act=delete'/>">Enlever</a></td>
                    <td><a href="<c:url value='/CourseController?x=${course.courseId}&act=update'/>">Modifier</a></td>
                </tr>
            </c:forEach>
        </table>   
    </body>
</html>
