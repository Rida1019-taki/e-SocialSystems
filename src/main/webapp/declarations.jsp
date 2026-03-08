<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Déclarations Mensuelles</title>
    <style>
        body { font-family: Arial; background: #f5f6fa; margin:0; padding:0; }
        header { background: #2f3640; color: #f5f6fa; padding:20px; text-align:center;}
        h1 { margin:0;}
        table { margin:30px auto; border-collapse: collapse; width: 90%; background: #fff; }
        th, td { border:1px solid #ddd; padding:12px; text-align:center; }
        th { background-color:#40739e; color:#f5f6fa; }
        tr:hover { background-color:#dcdde1; }
        a.button { text-decoration:none; background:#40739e; color:#f5f6fa; padding:8px 15px; border-radius:5px; transition:0.3s; }
        a.button:hover { background:#273c75; }
        form { text-align:center; margin-top:20px; }
        input[type=number], input[type=date] { padding:8px; margin:5px; width:150px; }
        input[type=submit] { padding:8px 15px; background:#40739e; color:#f5f6fa; border:none; border-radius:5px; cursor:pointer; }
        input[type=submit]:hover { background:#273c75; }
    </style>
</head>
<body>
<header>
    <h1>Déclarations Mensuelles</h1>
    <a class="button" href="index.jsp">← Dashboard</a>
</header>

<form method="post" action="declarations">
    <input type="number" name="employeurId" placeholder="ID Employeur" required>
    <input type="number" name="mois" placeholder="Mois (1-12)" required>
    <input type="number" name="annee" placeholder="Année" required>
    <input type="date" name="dateDeclaration" required>
    <input type="hidden" name="action" value="creer">
    <input type="submit" value="Créer Déclaration">
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Employeur</th>
        <th>Mois</th>
        <th>Année</th>
        <th>Date</th>
    </tr>
    <c:forEach var="dec" items="${declarations}">
        <tr>
            <td>${dec.id}</td>
            <td>${dec.employeur.nom}</td>
            <td>${dec.mois}</td>
            <td>${dec.annee}</td>
            <td>${dec.dateDeclaration}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>