<%--
  Created by IntelliJ IDEA.
  User: Andrej
  Date: 5/27/2018
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista proizvoda</title>
</head>
<body>
<table>
    <thead>
        <th>Naziv proizvoda</th>
        <th>Kategorija</th>
        <th>Stanje</th>
        <th>Cijena</th>
    </thead>
    <tr>
        <td>
            ${proizvod.nazivProizvoda}
            ${proizvod.kategorijaProizvoda}
            ${proizvod.stanjeProizvoda}
            ${proizvod.cijena}
        </td>
    </tr>
</table>
</body>
</html>
