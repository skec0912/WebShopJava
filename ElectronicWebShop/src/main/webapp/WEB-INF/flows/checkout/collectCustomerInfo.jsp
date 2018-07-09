<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer</h1>
        </div>
        <p class="lead">Customer details</p>

        <form:form commandName="order" class="form-horizontal">

        <h3>Osnovne informacije</h3>

        <div class="form-group">
            <label for="name">Naziv:</label>
            <form:input path="cart.customer.customerName" id="name" cssClass="form-control"/>
        </div>

        <div class="form-group">
            <label for="customerEmail">Email:</label>
            <form:input path="cart.customer.customerEmail" id="customerEmail" cssClass="form-control"/>
        </div>

        <div class="form-group">
            <label for="customerPhone">Telefon:</label>
            <form:input path="cart.customer.customerPhone" id="customerPhone" cssClass="form-control"/>
        </div>


        <h3>Billing address</h3>

        <div class="form-group">
            <label for="billingStreet">Naziv ulice:</label>
            <form:input path="cart.customer.billingAddress.streetName" id="billingStreet" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="billingApartmentNumber">Kucni broj:</label>
            <form:input path="cart.customer.billingAddress.apartmantNumber" id="billingApartmentNumber" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="billingCity">Grad</label>
            <form:input path="cart.customer.billingAddress.city" id="billingCity" cssClass="form-control"/>
        </div>


        <div class="form-group">
            <label for="billingState">Drzava:</label>
            <form:input path="cart.customer.billingAddress.country" id="billingState" cssClass="form-control"/>
        </div>

        <div class="form-group">
            <label for="zipCode">Postanski broj:</label>
            <form:input path="cart.customer.billingAddress.zipCode" id="zipCode" cssClass="form-control"/>
        </div>

        <<input type="hidden" name="_flowExecutionKey" >

        <br><br>
        <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected"/>
        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
        </form:form>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
