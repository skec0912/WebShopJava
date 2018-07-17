<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Dobrodosao Administratore :)</h1>
            <p class="lead">Ovo je stranica za administratore ducana</p>
        </div>
        <h3>
            <a href="<c:url value="/admin/popisProizvoda"/> ">Product inventory</a>
        </h3>
        <p>Ovdje mozete uredivati popis proizvoda</p>

        <br>

        <h3>
            <a href="<c:url value='/admin/customer'/>">Customer Management</a>
        </h3>
        <p>Ovdje mozete pregledavati informacije o kupcima.</p>

        <br>
        <h3>
            <a href="<c:url value='/admin/loginHistory'/>">Login History</a>
        </h3>
        <p>Ovdje mozete pregledavati informacije o loginima.</p>

        <br>
        <br>
        <br>
        <br>
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
