<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Gestion des Assurés</title>
    <style>
        body { font-family: Arial; background: #f5f6fa; margin: 0; padding: 0;}
        header { background: #2f3640; color: #f5f6fa; padding: 20px; text-align: center;}
        h1 { margin: 0; }
        table { margin: 30px auto; border-collapse: collapse; width: 90%; background: #fff; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: center; }
        th { background-color: #40739e; color: #f5f6fa; }
        tr:hover { background-color: #dcdde1; }
        a.button { text-decoration: none; background: #40739e; color: #f5f6fa; padding: 8px 15px; border-radius: 5px; transition: 0.3s;}
        a.button:hover { background: #273c75; }
        form { text-align: center; margin-top: 20px; }
        input[type=text], input[type=number] { padding: 8px; width: 150px; margin: 5px;}
        input[type=submit] { padding: 8px 15px; background: #40739e; color: #f5f6fa; border: none; border-radius: 5px; cursor: pointer;}
        input[type=submit]:hover { background: #273c75; }
    </style>
</head>
<body>
<header>
    <h1>Gestion des Assurés</h1>
    <a class="button" href="index.jsp">← Dashboard</a>
</header>

<form method="post" action="assures">
    <input type="text" name="nom" placeholder="Nom Assuré" required>
    <input type="number" step="0.01" name="salaire" placeholder="Salaire Mensuel" required>
    <input type="number" name="employeurId" placeholder="ID Employeur" required>
    <input type="hidden" name="action" value="ajouter">
    <input type="submit" value="Ajouter">
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Salaire</th>
        <th>Employeur</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="assure" items="${assures}">
        <tr>
            <td>${assure.id}</td>
            <td>${assure.nom}</td>
            <td>${assure.salaireMensuel}</td>
            <td>${assure.employeur.nom}</td>
            <td>
                <form method="post" action="assures" style="display:inline;">
                    <input type="hidden" name="action" value="modifierSalaire">
                    <input type="hidden" name="assureId" value="${assure.id}">
                    <input type="number" step="0.01" name="salaire" placeholder="Nouveau Salaire">
                    <input type="submit" value="Modifier">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>