<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Detalji proizvoda</h1>
            <p class="lead">Ovdje pogledajte detalje proizvoda!</p>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/slike/${proizvod.proizvodId}.png" />" alt="image" style="width:100%"/>
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
                </div>

            </div>
        </div>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
