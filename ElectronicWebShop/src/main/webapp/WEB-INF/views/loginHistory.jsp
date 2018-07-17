<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Svi kupci</h1>
            <p class="lead">Login history</p>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Name</th>
                <th>Date</th>
                <th>IP address</th>
            </tr>
            </thead>
            <c:forEach items="${loginHistoryList}" var="customer">
                <tr>
                    <td>${loginHistory.name}</td>
                    <td>${loginHistory.date}</td>
                    <td>${loginHistory.ip}</td>
                </tr>
            </c:forEach>
        </table>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
