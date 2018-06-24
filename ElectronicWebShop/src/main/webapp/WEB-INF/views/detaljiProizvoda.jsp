<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Detalji proizvoda</h1>
            <p class="lead">Ovdje pogledajte detalje proizvoda!</p>
        </div>
        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/slike/${proizvod.proizvodId}.png" />" alt="image"
                         style="width:100%"/>
                </div>

                <div class="col-md-5">
                    <h3>${proizvod.nazivProizvoda}</h3>
                    <p>${proizvod.opisProizvoda}</p>
                    <p>
                        <strong>Proizvodac</strong> : ${proizvod.proizvodac}
                    </p>
                    <p>
                        <strong>Kategorija</strong> : ${proizvod.kategorijaProizvoda}
                    </p>
                    <p>
                        <strong>Stanje</strong> : ${proizvod.stanjeProizvoda}
                    </p>
                    <h4>${proizvod.cijena} KN</h4>
                    <br>

                    <c:set var="role" scope="page" value="${param.role}"/>
                    <c:set var="url" scope="page" value="/proizvod/listaProizvoda"/>
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/popisProizvoda"/>
                    </c:if>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value="${url}"/> " class="btn btn-default">Back</a>

                        <a href="#" class="btn btn-warning btn-large"
                           ng-click="addToCart('${proizvod.proizvodId}')"><span
                                class="glyphicon glyphicon-shopping-cart"></span>Order now</a>

                        <a href="<spring:url value='/cart'/>" class="btn btn-default"><span
                                class="glyphicon glyphicon-hand-right"></span>View Cart</a>
                    </p>
                </div>

            </div>
        </div>

        <script src="<c:url value="/resources/js/controller.js"/>"></script>
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
