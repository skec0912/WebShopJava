<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Uspjesna registracija! :) </h1>
                </div>
            </div>
        </section>
        <section class="container">
            <p>
                <a href="<spring:url value="/proizvod/listaProizvoda"/>" class="btn btn-default">Proizvodi</a>
            </p>
        </section>
    </div>
</div>

<script src="<c:url value="/resources/js/controller.js"/>"></script>
<!-- FOOTER -->
<%@include file="/WEB-INF/views/template/footer.jsp" %>