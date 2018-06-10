<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<html>
<head>
</head>
<body>
    <div class="container-wrapper">
            <div class="container">
                <div class="page-header">
                    <h1>Popis proizvoda</h1>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr class="bg-success">
                        <th>Slika</th>
                        <th>Naziv</th>
                        <th>Kategorija</th>
                        <th>Stanje</th>
                        <th>Cijena</th>
                        <th></th>
                    </tr>
                    </thead>
                    <c:forEach items="${proizvodi}" var="proizvod">
                        <tr>
                            <td><img src="<c:url value="/resources/slike/${proizvod.proizvodId}.png" />" alt="image" style="width:100%"/></td>
                            <td>${proizvod.nazivProizvoda}</td>
                            <td>${proizvod.kategorijaProizvoda}</td>
                            <td>${proizvod.stanjeProizvoda}</td>
                            <td>${proizvod.cijena} KN</td>
                            <td><a href="<spring:url value='/listaProizvoda/proizvod/${proizvod.proizvodId}'/>">
                                <span class="glyphicon glyphicon-info-sign"/>
                                </a>
                                <a href="<spring:url value='/admin/popisProizvoda/deleteProizvod/${proizvod.proizvodId}'/>">
                                    <span class="glyphicon glyphicon-remove"/>
                                </a>

                                <a href="<spring:url value='/admin/popisProizvoda/editProizvod/${proizvod.proizvodId}'/>">
                                    <span class="glyphicon glyphicon-pencil"/>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <a href="<spring:url value="/admin/popisProizvoda/dodajProizvod"/>" class="btn btn-primary">Dodaj
                    proizvod</a>
                <%@include file="/WEB-INF/views/template/footer.jsp" %>


</body>
</html>
