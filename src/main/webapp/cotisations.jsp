<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Calcul des Cotisations</title>
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
        form { text-align:center; margin-top:20px; }
        input[type=number] { padding:8px; width:150px; margin:5px; }
        input[type=submit] { padding:8px 15px; background:#40739e; color:#f5f6fa; border:none; border-radius:5px; cursor:pointer;}
        input[type=submit]:hover { background:#273c75;}
    </style>
</head>
<body>
<header>
    <h1>Calcul des Cotisations</h1>
    <a class="button" href="index.jsp">← Dashboard</a>
</header>

<form method="post" action="cotisations">
    <input type="number" name="declarationId" placeholder="ID Déclaration" required>
    <input type="hidden" name="action" value="calculer">
    <input type="submit" value="Calculer Cotisations">
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Assuré</th>
        <th>Déclaration</th>
        <th>Cotisation Salariale</th>
        <th>Cotisation Patronale</th>
    </tr>
    <c:forEach var="c" items="${cotisations}">
        <tr>
            <td>${c.id}</td>
            <td>${c.assure.nom}</td>
            <td>${c.declaration.id}</td>
            <td>${c.cotisationSalariale}</td>
            <td>${c.cotisationPatronale}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>