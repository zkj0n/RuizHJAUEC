<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="readAll"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>

<main class="d-flex justify-content-center align-items-center mt-5 p-3">
    <table class="mx-auto p-5 bg-light rounded-3 shadow-lg w-50 table">
        <thead class="table-secondary">
        <tr>
            <th>id</th>
            <th>tipo</th>
            <th>nombre y apellidos</th>
            <th>fecha</th>
        </tr>
        </thead>
        <tbody class="table-primary">
        <c:if test="${requestScope.profesores.size() > 0}">
            <c:forEach items="${requestScope.profesores}" var="p">
                <tr>
                    <td>${p.codigo.id}</td>
                    <td>${p.codigo.tipo}</td>
                    <td>${p.nombre} ${p.ape1} ${p.ape2}</td>
                    <td>${p.fechaFormateada}</td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${requestScope.profesores.size() == 0}">
            <tr>
                <td colspan="3" class="text-center fs-3">no hay profesores</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>
