<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <c:import url="INC/head.jsp">
            <c:param name="title" value="inicio"/>
        </c:import>

    </head>
    <body class="overflow-hidden">

        <c:import url="INC/header.jsp"/>

        <main class="text-lowercase h-100 d-flex align-items-center overflow-hidden"
              style="min-height: 80vh;">

            <div class="container overflow-hidden">
                <div class="row">
                    <div class="col-12 text-center">
                        <h1 class="mb-4">selecciona una opci&oacute;n en el header</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 text-center">
                        <p class="mb-4 badge bg-danger fs-5">disfruta de este video mientras tanto</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 text-center shadow">
                        <video class="shadow rounded" src="IMG/live.mp4" autoplay loop muted style="max-width: 50vw; max-height: 50vh; object-fit: cover;"></video>
                    </div>
                </div>
            </div>
        </main>

        <c:import url="INC/footer.jsp"/>
    </body>
</html>
