<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide" src="<c:url value='/resources/slike/back1.jpg'/>" alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Zelite li najbolje performanse po najnizim cijenama? </h1>
                    <p>U danasnje vrijeme je vrlo tesko izabrati pravi laptop. Zbog toga smo za Vas pripremili bogatu
                        ponudu uredaja po pristupacnim cijenama i performansama primjerenima zahtjevima svakog
                        korisnika, bilo da se radi o uredaju za surfanje, posao ili gaming.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide" src="<c:url value='/resources/slike/back2.jpg'/>" alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Jos uvijek nemate smartphone? Na pravom ste mjestu.</h1>
                    <p>Najbolji omjer cijene i kvalitete baz obzira da li trazite uredaj sa osnovnim funkcijama ili
                        napredniji uredaj s mnostvom korisnih funkcija i aplikacija.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide" src="<c:url value='/resources/slike/back3.jpg'/>" alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Velika ponuda televizora</h1>
                    <p>Televizori u nasoj ponudi su savrseni spoj performansi, dizajna i prihvatljive cijene. Uz velik
                        izbor televizora razlicitih dijagonala, boja i performansa svatko ce pronaci svoj model.</p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/proizvod/listaProizvoda?searchCondition=Laptop"/> "
               role="button">
                <img class="img-circle" src="<c:url value="/resources/slike/laptop.png"/>" alt="Laptop Image"
                     width="140" height="140">
            </a>
            <h2>Laptopi</h2>
            <p>Najbolja ponuda laptopa</p>
        </div><!-- /.col-lg-4 -->


    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/proizvod/listaProizvoda?searchCondition=Televizor"/> "
               role="button">
                <img class="img-circle" src="<c:url value="/resources/slike/televizor.jpg"/>" alt="Televizor Image"
                     width="140" height="140">
            </a>
            <h2>Televizori</h2>
            <p>Najbolja ponuda televizora</p>
        </div><!-- /.col-lg-4 -->

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/proizvod/listaProizvoda?searchCondition=Mobitel"/> "
               role="button">
                <img class="img-circle" src="<c:url value="/resources/slike/mobitel.jpg"/>" alt="Mobitel Image"
                     width="140" height="140">
            </a>
            <h2>Mobiteli</h2>
            <p>Najbolja ponuda mobitela</p>
        </div><!-- /.col-lg-4 -->

    </div><!-- /.row -->
    <!-- FOOTER -->
    <%@include file="/WEB-INF/views/template/footer.jsp" %>

