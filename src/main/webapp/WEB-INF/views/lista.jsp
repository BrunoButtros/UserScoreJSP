<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Usuários</title>
</head>
<body>
    <h1>Lista de Usuários</h1>

    <table border="1">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Score</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userScores}" var="user">
                <tr>
                    <td>${user.nome}</td>
                    <td>${user.score}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
