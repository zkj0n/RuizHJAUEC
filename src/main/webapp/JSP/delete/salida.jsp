<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <c:import url="/INC/head.jsp">
    <c:param name="title" value="readOne"/>
  </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>

<main class="d-flex justify-content-center flex-column align-items-center mt-5 p-3">
  <h1 class="text-center text-danger">se ha eliminado el siguiente profesor:</h1>
  <table class="mx-auto p-5 bg-light rounded-3 shadow-lg w-50 table">
    <thead class="table-secondary">
    <tr>
      <th>nombre</th>
      <th>primer apellido</th>
      <th>apellido</th>
    </tr>
    </thead>
    <tbody class="table-primary">
    <tr>
      <td>${requestScope.p.nombre}</td>
      <td>${requestScope.p.ape1}</td>
      <td>${requestScope.p.ape2}</td>
    </tr>
  </table>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>
