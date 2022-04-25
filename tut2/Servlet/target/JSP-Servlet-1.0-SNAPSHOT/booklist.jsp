<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL core--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Book List</title>
    <%--Bootstrap--%>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container col-md-6 mt-3">
        <h2 class="text-center">Book List</h2>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author</th>
                    <th scope="col">Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var ="book" items ="${books}">
                    <tr>
                        <th scope="row"><c:out value="${book.id}" /></th>
                        <td><c:out value="${book.title}" /></td>
                        <td><c:out value="${book.author}" /></td>
                        <td><c:out value="${book.price}" /></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>