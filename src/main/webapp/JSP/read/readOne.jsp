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
  <h1 class="fw-bold text-center">${requestScope.mensaje}</h1>
  <table class="mx-auto p-5 bg-light rounded-3 shadow-lg w-50 table">
    <thead class="table-secondary">
    <tr>
        <th>id</th>
        <th>tipo</th>
        <th>nombre y apellidos</th>
    </tr>
    </thead>
    <tbody class="table-primary">
    <tr>
      <c:if test="${requestScope.p.nombre != null}">
        <td>${requestScope.p.codigo.id}</td>
        <td>${requestScope.p.codigo.tipo}</td>
        <td>${requestScope.p.nombre} ${requestScope.p.ape1} ${requestScope.p.ape2}</td>
      </c:if>
    </tr>
  </table>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>
