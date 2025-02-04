<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="change"/>
    </c:import>

</head>
<body>
<c:import url="/INC/header.jsp"/>
<main class="d-flex justify-content-center align-items-center flex-column mt-5 p-3">
    <h1 class="fw-bold text-center">change</h1>
    <c:if test="${requestScope.p.nombre != null}">
        <form action="Change" method="post" class="mx-auto p-5 bg-light rounded-3 shadow-lg w-50">
            <div class="form-floating mb-3">
                <input type="number"
                       class="form-control"
                       id="id"
                       placeholder="id"
                       name="id"
                       value="${requestScope.p.codigo.id}"
                       readonly>

                <label for="id">id</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text"
                       class="form-control"
                       id="tipo"
                       placeholder="tipo"
                       name="tipo"
                       value="${requestScope.p.codigo.tipo}"
                       readonly>

                <label for="tipo">tipo</label>
            </div>
            <div class="form-floating mb-3">
                <input type="datetime-local"
                       class="form-control"
                       id="fecha"
                       placeholder="fecha"
                       name="fecha"
                       value="${requestScope.p.fechaFormateada}"
                       >

                <label for="fecha">fecha</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text"
                       class="form-control"
                       id="nombre"
                       placeholder="nombre"
                       name="nombre"
                       value="${requestScope.p.nombre}">

                <label for="nombre">nombre</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text"
                       class="form-control"
                       id="ape"
                       placeholder="primer apellido"
                       name="ape1"
                       value="${requestScope.p.ape1}">

                <label for="ape">primer apellido</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text"
                       class="form-control"
                       id="ape2"
                       placeholder="segundo apellido"
                       name="ape2"
                       value="${requestScope.p.ape2}">

                <label for="ape2">apellido</label>
            </div>
            <button class="btn btn-outline-primary w-100" type="submit">
                actualizar
            </button>
        </form>
    </c:if>
    <c:if test="${requestScope.error != null}">
        <div class="alert alert-danger mt-3" role="alert">
                ${requestScope.error}
        </div>
    </c:if>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>