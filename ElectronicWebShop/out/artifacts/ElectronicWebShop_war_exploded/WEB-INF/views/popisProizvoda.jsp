<%--
  Created by IntelliJ IDEA.
  User: Andrej
  Date: 6/7/2018
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@include file="/WEB-INF/views/template/header.jsp" %>

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
                            <td><img src="#" alt="image"/></td>
                            <td>${proizvod.nazivProizvoda}</td>
                            <td>${proizvod.kategorijaProizvoda}</td>
                            <td>${proizvod.stanjeProizvoda}</td>
                            <td>${proizvod.cijena} KN</td>
                            <td><a href="<spring:url value='/listaProizvoda/proizvod/${proizvod.proizvodId}'/>">
                                <span class="glyphicon glyphicon-info-sign"/>
                            </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <a href="<spring:url value="/admin/popisProizvoda/dodajProizvod"/>" class="btn btn-primary">Dodaj proizvod</a>
                <%@include file="/WEB-INF/views/template/footer.jsp" %>
    </title>
</head>
<body>

</body>
</html>
