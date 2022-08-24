<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    Document   : listResults
    Created on : Aug 24, 2022, 2:56:45 PM
    Author     : phili
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des notes</title>
    </head>
    <body>
        <table>
            <tr>
                <td>ID de l'étudiant</td>
                <td>ID du cours</td>
                <td>Session</td>
                <td>Note</td>
            </tr>
            <c:forEach var="result" items = "${listResults}">
                <tr>
                    <td>${result.studentId}</td>
                    <td>${result.courseId}</td>
                    <td>${result.session}</td>
                    <td>${result.mark}</td>
                </tr>
            </c:forEach>
        </table>   
    </body>
</html>
