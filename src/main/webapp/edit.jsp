<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 21/02/2024
  Time: 9:54 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Assignment</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>

    <div class="row justify-content-center mt-4">
        <form  class="col-md-6" method="post">
            <h1 align="center" class="">Edit Assignment</h1>
            <div  class="form-group">
                <label hidden="hidden" for="txtId">ID</label>
                <input type="hidden" class="form-control" name="id" id="txtId" value="${requestScope["product"].getId()}">
            </div>
            <div class="form-group">
                <label for="s">Date Start</label>
                <input type="text" class="form-control" name="name" id="s" value="${requestScope["product"].getName()}">
            </div>
            <div class="form-group">
                <label for="e">Date Start</label>
                <input type="text" class="form-control" name="date" id="e" value="${requestScope["product"].getDate()}">
            </div>
            <div class="form-group">
                <label for="id">Lớp</label>
                <select id="id" class="form-control" name="id_ca">
                    <c:forEach items="${category}" var="c">
                        <option value="${c.id}">${c.nameC}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group mt-2">
                <button class="btn btn-danger" role="button" type="submit">Save</button>
            </div>
        </form>
    </div>
</body>
</body>
</html>
