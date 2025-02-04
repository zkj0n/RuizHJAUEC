<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <c:import url="/INC/head.jsp">
        <c:param name="title" value="update"/>
    </c:import>
</head>
<body>

<c:import url="/INC/header.jsp"/>

<main class="d-flex justify-content-center align-items-center flex-column mt-5 p-3">
    <h1 class="fw-bold text-center">update</h1>
    <form action="Update" method="post" class="mx-auto p-5 bg-light rounded-3 shadow-lg w-50">
        <div class="form-floating mb-3">
            <input type="text"
                   class="form-control"
                   id="id"
                   placeholder="id"
                   name="id">

            <label for="id">id</label>
        </div>
        <button class="btn btn-outline-primary w-100" type="submit">
            actualizar
        </button>
        <c:if test="${requestScope.error != null}">
            <div class="alert alert-danger mt-3" role="alert">
                ${requestScope.error}
            </div>
        </c:if>
    </form>
</main>

<c:import url="/INC/footer.jsp"/>

</body>
</html>

