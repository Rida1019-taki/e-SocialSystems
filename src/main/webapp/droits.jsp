<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Droits Sociaux</title>
    <style>
        body { font-family: Arial; background:#f5f6fa; margin:0; padding:0;}
        header { background:#2f3640; color:#f5f6fa; padding:20px; text-align:center;}
        h1 { margin:0;}
        table { margin:30px auto; border-collapse: collapse; width: 90%; background:#fff; }
        th, td { border:1px solid #ddd; padding:12px; text-align:center;}
        th { background-color:#40739e; color:#f5f6fa;}
        tr:hover { background-color:#dcdde1;}
        a.button { text-decoration:none; background:#40739e; color:#f5f6fa; padding:8px 15px; border-radius:5px; transition:0.3s;}
        a.button:hover { background:#273c75;}
    </style>
</head>
<body>
<header>
    <h1>Droits Sociaux</h1>
    <a class="button" href="index.jsp">← Dashboard</a>
</header>

<table>
    <tr>
        <th>Nom Assuré</th>
        <th>Employeur</th>
        <th>Mois Déclarés</th>
        <th>Total Cotisations</th>
    </tr>
    <c:forEach var="assure" items="${assures}">
        <tr>
            <td>${assure.nom}</td>
            <td>${assure.employeur.nom}</td>
            <td>${droitSocialService.getNombreMois(assure.id)}</td>
            <td>${droitSocialService.getTotalCotisations(assure.id)}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>