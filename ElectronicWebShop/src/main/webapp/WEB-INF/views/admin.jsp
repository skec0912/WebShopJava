<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Dobrodosao Administratore :)</h1>
            <p class="lead">Ovo je stranica za administratore ducana</p>
        </div>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>Welcome:${pageContext.request.userPrincipal.name} | <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
        </h2>
        </c:if>

        <h3>
            <a href="<c:url value='/admin/popisProizvoda'/>">Popis proizvoda</a>
        </h3>

        <p>Ovdje mozete pregledavati, kontrolirati i prilagodavati popis proizvoda!</p>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
