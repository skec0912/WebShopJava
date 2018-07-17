<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer</h1>
        </div>
        <p class="lead">Customer details</p>

        <form:form commandName="order" class="form-horizontal">

        <h3>Shipping address</h3>

        <div class="form-group">
            <label for="shippingStreet">Naziv ulice:</label>
            <form:input path="cart.customer.shippingAddress.streetName" id="shippingStreet" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="shippingApartmentNumber">Kucni broj:</label>
            <form:input path="cart.customer.shippingAddress.apartmantNumber" id="shippingApartmentNumber" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="shippingCity">Grad</label>
            <form:input path="cart.customer.shippingAddress.city" id="shippingCity" cssClass="form-control"/>
        </div>


        <div class="form-group">
            <label for="shippingState">Drzava:</label>
            <form:input path="cart.customer.shippingAddress.country" id="shippingState" cssClass="form-control"/>
        </div>

        <div class="form-group">
            <label for="zipCode">Postanski broj:</label>
            <form:input path="cart.customer.shippingAddress.zipCode" id="zipCode" cssClass="form-control"/>
        </div>

        <input type="hidden" name="_flowExecutionKey" >

        <br><br>
        <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
        <input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected"/>
        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
        </form:form>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
