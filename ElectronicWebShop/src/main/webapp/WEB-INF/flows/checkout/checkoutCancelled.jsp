<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1 class="alert alert-danger">Checkout cancelled </h1>
                    <p>Vasa narudzba je otkazana. Nastavite kupnju.</p>
                </div>
            </div>
        </section>
        <section class="container">
            <p>
                <a href="<spring:url value="/proizvod/listaProizvoda/all"/>" class="btn btn-default">Proizvodi</a>
            </p>
        </section>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>