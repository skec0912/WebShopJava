<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@include file="/WEB-INF/views/template/header.jsp" %>

        <div class="container-wrapper">
            <div class="container">
                <div class="page-header">
                    <h1>Registriraj se</h1>
                </div>
                <p>Unesite osobne podatke</p>

                <form:form action="${pageContext.request.contextPath}/register" method="post" commandName="customer">

                <h3>Osnovne informacije</h3>

                <div class="form-group">
                    <label for="name">Naziv:</label><form:errors path="customerName" cssStyle="color:red"/>
                    <form:input path="customerName" id="name" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label for="customerEmail">Email:</label><span style="color:red">${emailMsg}</span>
                    <form:errors path="customerEmail" cssStyle="color:red"/>
                    <form:input path="customerEmail" id="customerEmail" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label for="customerPhone">Telefon:</label>
                    <form:input path="customerPhone" id="customerPhone" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label for="username">Korisnicko ime:</label><span style="color:red">${usernameMsg}</span>
                    <form:errors path="username" cssStyle="color:red"/>
                    <form:input path="username" id="username" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label for="password">Lozinka:</label><form:errors path="password" cssStyle="color:red"/>
                    <form:password path="password" id="password" cssClass="form-control"/>
                </div>

                <h3>Billing address</h3>

                <div class="form-group">
                    <label for="billingStreet">Naziv ulice:</label>
                    <form:input path="billingAddress.streetName" id="billingStreet" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label for="billingApartmentNumber">Kucni broj:</label>
                    <form:input path="billingAddress.apartmantNumber" id="billingApartmentNumber" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label for="billingCity">Grad</label>
                    <form:input path="billingAddress.city" id="billingCity" cssClass="form-control"/>
                </div>


                <div class="form-group">
                    <label for="billingState">Drzava:</label>
                    <form:input path="billingAddress.country" id="billingState" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label for="zipCode">Postanski broj:</label>
                    <form:input path="billingAddress.zipCode" id="zipCode" cssClass="form-control"/>
                </div>

                <h3>Shipping address</h3>

                <div class="form-group">
                    <label for="shippingStreet">Naziv ulice:</label>
                    <form:input path="shippingAddress.streetName" id="shippingStreet" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label for="shippingApartmentNumber">Kucni broj:</label>
                    <form:input path="shippingAddress.apartmantNumber" id="shippingApartmentNumber" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <label for="shippingCity">Grad:</label>
                    <form:input path="shippingAddress.city" id="shippingCity" cssClass="form-control"/>
                </div>


                <div class="form-group">
                    <label for="shippingState">Drzava:</label>
                    <form:input path="shippingAddress.country" id="shippingState" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label for="zipCode">Postanski broj:</label>
                    <form:input path="shippingAddress.zipCode" id="zipCode" cssClass="form-control"/>
                </div>

                <br><br>
                <input type="submit" value="Potvrdi" class="btn btn-default">
                <a href="<c:url value="/"/>" class="btn btn-default">Ponisti</a>

                </form:form>

                <%@include file="/WEB-INF/views/template/footer.jsp" %>
