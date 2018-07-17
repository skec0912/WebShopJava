<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<jsp:useBean id="now" class="java.util.Date" />

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Order</h1>
        </div>
        <p class="lead">Order confirmation</p>
        <div class="container">
            <div class="row">

                <form:form commandName="order" class="form-horizontal">
                    <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">

                        <div class="text-center">
                            <h1>Receipt</h1>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Shipping address</strong><br>
                                        ${order.cart.customer.shippingAddress.streetName}
                                    <br>
                                        ${order.cart.customer.shippingAddress.apartmantNumber}
                                    <br>
                                        ${order.cart.customer.shippingAddress.city},${order.cart.customer.shippingAddress.country}
                                    <br>
                                        ${order.cart.customer.shippingAddress.zipCode}
                                </address>
                            </div>

                            <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                                <p>Shipping Date:<fmt:formatDate type="date" value="${now}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Billing address</strong><br>
                                        ${order.cart.customer.billingAddress.streetName}
                                    <br>
                                        ${order.cart.customer.billingAddress.apartmantNumber}
                                    <br>
                                        ${order.cart.customer.billingAddress.city},${order.cart.customer.billingAddress.country}
                                    <br>
                                        ${order.cart.customer.billingAddress.zipCode}
                                </address>
                            </div>
                        </div>
                        <div class="row">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>#</th>
                                    <th class="text-center">Price</th>
                                    <th class="text-center">Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cartItem" items="${order.cart.cartItems}">
                                    <tr>
                                        <td class="col-md-9"><em>${cartItem.proizvod.nazivProizvoda}</em></td>
                                        <td class="col-md-9" style="text-align: center;"><em>${cartItem.quantity}</em>
                                        </td>
                                        <td class="col-md-9" style="text-align: center;">
                                            <em>${cartItem.proizvod.cijena}</em></td>
                                        <td class="col-md-9" style="text-align: center;"><em>${cartItem.totalPrice}</em>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td class="text-right">
                                        <h4><strong>Grand Total:</strong></h4>
                                    </td>
                                    <td class="text-right text-danger">
                                        <h4><strong>${order.cart.grandTotal}</strong></h4>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <input type="hidden" name="_flowExecutionKey">

                        <br><br>
                        <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
                        <input type="submit" value="Submit order" class="btn btn-default"
                               name="_eventId_orderConfirmed"/>
                        <div id="paypal-button"></div>
                        <script src="https://www.paypalobjects.com/api/checkout.js"></script>
                        <script>
                            paypal.Button.render({
                                // Configure environment
                                env: 'sandbox',
                                client: {
                                    sandbox: 'demo_sandbox_client_id',
                                    production: 'demo_production_client_id'
                                },
                                // Customize button (optional)
                                locale: 'en_US',
                                style: {
                                    size: 'small',
                                    color: 'gold',
                                    shape: 'pill',
                                },
                                // Set up a payment
                                payment: function (data, actions) {
                                    return actions.payment.create({
                                        transactions: [{
                                            amount: {
                                                total: '0.01',
                                                currency: 'USD'
                                            }
                                        }]
                                    });
                                },
                                // Execute the payment
                                onAuthorize: function (data, actions) {
                                    return actions.payment.execute()
                                        .then(function () {
                                            // Show a confirmation message to the buyer
                                            window.alert('Thank you for your purchase!');
                                        });
                                }
                            }, '#paypal-button');
                        </script>
                        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
                    </div>
                </form:form>
            </div>
        </div>
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
