<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Gestion des Employeurs</title>
    <style>
        body { font-family: Arial; background: #f5f6fa; margin: 0; padding: 0;}
        header { background: #2f3640; color: #f5f6fa; padding: 20px; text-align: center;}
        h1 { margin: 0; }
        table { margin: 30px auto; border-collapse: collapse; width: 80%; background: #fff; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: center; }
        th { background-color: #40739e; color: #f5f6fa; }
        tr:hover { background-color: #dcdde1; }
        a.button { text-decoration: none; background: #40739e; color: #f5f6fa; padding: 8px 15px; border-radius: 5px; transition: 0.3s;}
        a.button:hover { background: #273c75; }
        form { text-align: center; margin-top: 20px; }
        input[type=text] { padding: 8px; width: 200px; margin-right: 10px; }
        input[type=submit] { padding: 8px 15px; background: #40739e; color: #f5f6fa; border: none; border-radius: 5px; cursor: pointer;}
        input[type=submit]:hover { background: #273c75; }
    </style>
</head>
<body>
<header>
    <h1>Gestion des Employeurs</h1>
    <a class="button" href="index.jsp">← Dashboard</a>
</header>

<form method="post" action="employeurs">
    <input type="text" name="nom" placeholder="Nom Employeur" required>
    <input type="text" name="raisonSociale" placeholder="Raison Sociale" required>
    <input type="text" name="secteurActivite" placeholder="Secteur d'Activité">
    <input type="hidden" name="action" value="ajouter">
    <input type="submit" value="Ajouter">
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Raison Sociale</th>
        <th>Secteur Activité</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="employeur" items="${employeurs}">
        <tr>
            <td>${employeur.id}</td>
            <td>${employeur.nom}</td>
            <td>${employeur.raisonSociale}</td>
            <td>${employeur.secteurActivite}</td>
            <td>
                <form method="post" action="employeurs" style="display:inline;">
                    <input type="hidden" name="action" value="supprimer">
                    <input type="hidden" name="id" value="${employeur.id}">
                    <input type="submit" value="Supprimer">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>