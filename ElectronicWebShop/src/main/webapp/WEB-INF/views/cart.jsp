<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Kosarica</h1>
                    <p>Svi proizvodi u kosarici</p>
                </div>
            </div>
        </section>
        <section class="container" ng-app="cartApp">
            <div ng-controller='cartCtrl' ng-init="initCartId('${cartId}')">
                <div>
                    <a class="btn btn-danger pull-left" ng-click="clearCart()"><span class="glyphicon glyphicon-remove-sign"></span> Ocisti
                        kosaricu</a>
                </div>
                <table class="table table-hover">
                    <tr>
                        <th>Proizvod</th>
                        <th>Cijena</th>
                        <th>Kolicina</th>
                        <th>Ukupna cijena</th>
                        <th></th>
                    </tr>
                    <tr ng-repeat="item in cart.cartItems">
                        <td>{{item.proizvod.nazivProizvoda}}</td>
                        <td>{{item.proizvod.cijena}}</td>
                        <td>{{item.quantity}}</td>
                        <td>{{item.totalPrice}}</td>
                        <td><a href="#" class="label label-danger"
                               ng-click="removeFromCart(item.proizvod.proizvodId)"><span
                                class="glyphicon glyphicon-remove"></span>Remove</a></td>
                    </tr>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Grand total</th>
                        <th>{{calGrandTotal()}}</th>
                        <th></th>
                    </tr>
                </table>
                <a href="<spring:url value="/proizvod/listaProizvoda"/>" class="btn btn-default">Nastavi kupovati</a>
            </div>
        </section>
    </div>
</div>

<script src="<c:url value="/resources/js/controller.js"/>"></script>
<!-- FOOTER -->
<%@include file="/WEB-INF/views/template/footer.jsp" %>