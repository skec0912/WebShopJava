<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Uredi proizvod</h1>
        </div>
        <p>Uredite pojedinosti o proizvodu</p>

        <form:form action="${pageContext.request.contextPath}/admin/proizvod/editProizvod" method="post" commandName="proizvod" enctype="multipart/form-data">
        <form:hidden path="proizvodId" value="${proizvod.proizvodId}"/>
        <div class="form-group">
            <label for="naziv">Naziv:</label>
            <form:input path="nazivProizvoda" id="naziv" cssClass="form-control" value="${proizvod.nazivProizvoda}"/>
        </div>

        <div class="form-group">
            <label for="kategorija">Kategorija:</label>
            <label class="checkbox-inline"><form:radiobutton checked="true" path="kategorijaProizvoda" id="kategorija" value="Televizori"/>Televizori</label>
            <label class="checkbox-inline"><form:radiobutton path="kategorijaProizvoda" id="kategorija" value="Mobiteli"/>Mobiteli</label>
            <label class="checkbox-inline"><form:radiobutton path="kategorijaProizvoda" id="kategorija" value="Laptopi"/>Laptopi</label>
        </div>

        <div class="form-group">
            <label for="opis">Opis:</label>
            <form:input path="opisProizvoda" id="opis" cssClass="form-control"  value="${proizvod.opisProizvoda}"/>
        </div>

        <div class="form-group">
            <label for="cijena">Cijena:</label>
            <form:input path="cijena" id="cijena" cssClass="form-control"  value="${proizvod.cijena}"/>
        </div>
        <div class="form-group">
            <label for="stanjeProizvoda">Stanje proizvoda:</label>
            <label class="checkbox-inline"><form:radiobutton checked="true" path="stanjeProizvoda" id="novo" value="novo"/>Novo</label>
            <label class="checkbox-inline"><form:radiobutton path="stanjeProizvoda" id="koristeno" value="koristeno"/>Koristeno </label>
        </div>

        <div class="form-group">
            <label for="statusProizvoda">Status proizvoda:</label>
            <label class="checkbox-inline">
                <form:radiobutton checked="true" path="statusProizvoda" id="active" value="Active"/>Aktivan</label>
            <label class="checkbox-inline">
                <form:radiobutton path="statusProizvoda" id="neaktivan" value="neaktivan"/>Ne aktivan</label>
        </div>

        <div class="form-group">
            <label for="proizvodaNaSkladistu">Kolicina proizvoda na skladistu:</label>
            <form:input path="proizvodaNaSkladistu" id="proizvodaNaSkladistu" cssClass="form-control"  value="${proizvod.proizvodaNaSkladistu}"/>
        </div>

        <div class="form-group">
            <label for="proizvodac">Proizvodac:</label>
            <form:input path="proizvodac" id="proizvodac" cssClass="form-control"  value="${proizvod.proizvodac}"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="slika">Dodaj sliku</label>
            <form:input path="slika" type="file" id="slika" cssClass="form-input"/>
        </div>

        <br><br>
        <input type="submit" value="Potvrdi" class="btn btn-default">
        <a href="<c:url value="/admin/popisProizvoda"/>" class="btn btn-default">Ponisti</a>

        </form:form>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
