<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Employeurs - e-Social Systems</title>
    <style>
        :root {
            --primary-color: #40739e;
            --secondary-color: #273c75;
            --bg-color: #f5f6fa;
            --text-color: #2f3640;
            --white: #ffffff;
            --danger: #e84118;
            --success: #4cd137;
            --gray: #7f8fa6;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: var(--bg-color);
            color: var(--text-color);
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        header {
            background-color: #2f3640;
            color: var(--white);
            padding: 1.5rem;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        header h1 { margin: 0; font-size: 1.8rem; }

        nav {
            background-color: var(--white);
            padding: 1rem;
            text-align: center;
            box-shadow: 0 1px 3px rgba(0,0,0,0.05);
        }

        nav ul {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            justify-content: center;
            gap: 1.5rem;
            flex-wrap: wrap;
        }

        nav a {
            text-decoration: none;
            color: var(--primary-color);
            font-weight: 600;
            transition: color 0.3s;
            padding: 0.5rem 1rem;
            border-radius: 4px;
        }

        nav a.active, nav a:hover {
            color: var(--secondary-color);
            background-color: rgba(64, 115, 158, 0.1);
        }

        main {
            flex: 1;
            padding: 2rem;
            max-width: 1100px;
            margin: 0 auto;
            width: 90%;
        }

        .container {
            background-color: var(--white);
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.05);
        }

        h2 { margin-top: 0; color: var(--secondary-color); }

        .form-card {
            background: #f8f9fa;
            padding: 1.5rem;
            border-radius: 8px;
            margin-bottom: 2rem;
            border: 1px solid #e1e8ed;
        }

        .form-group {
            display: flex;
            gap: 1rem;
            flex-wrap: wrap;
        }

        input[type=text] {
            padding: 0.7rem;
            border: 1px solid #ddd;
            border-radius: 5px;
            flex: 1;
            min-width: 200px;
        }

        .btn {
            padding: 0.7rem 1.5rem;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
            border: none;
            transition: all 0.3s;
        }

        .btn-add {
            background-color: var(--success);
            color: white;
        }

        .btn-add:hover { background-color: #44bd32; }

        .btn-delete {
            background-color: var(--danger);
            color: white;
            padding: 0.4rem 0.8rem;
            font-size: 0.85rem;
        }

        .btn-delete:hover { background-color: #c23616; }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 1rem;
        }

        th, td {
            text-align: left;
            padding: 1rem;
            border-bottom: 1px solid #eee;
        }

        th {
            background-color: #f1f2f6;
            color: var(--secondary-color);
            font-weight: 600;
            text-transform: uppercase;
            font-size: 0.85rem;
        }

        tr:hover { background-color: #fcfcfc; }

        footer {
            text-align: center;
            padding: 1.5rem;
            background-color: #2f3640;
            color: var(--white);
            margin-top: auto;
        }

        @media (max-width: 768px) {
            .form-group { flex-direction: column; }
            table { display: block; overflow-x: auto; }
        }
    </style>
</head>
<body>

<header>
    <h1>e-Social Systems</h1>
</header>

<nav>
    <ul>
        <li><a href="index.jsp">Accueil</a></li>
        <li><a href="employeurs" class="active">Employeurs</a></li>
        <li><a href="assures">Assurés</a></li>
        <li><a href="declarations">Déclarations</a></li>
        <li><a href="cotisations">Cotisations</a></li>
    </ul>
</nav>

<main>
    <div class="container">
        <h2>🏢 Gestion des Employeurs</h2>
        
        <section class="form-card">
            <form method="post" action="employeurs" class="form-group">
                <input type="text" name="nom" placeholder="Nom Employeur" required>
                <input type="text" name="raisonSociale" placeholder="Raison Sociale" required>
                <input type="text" name="secteurActivite" placeholder="Secteur d'Activité">
                <input type="hidden" name="action" value="ajouter">
                <button type="submit" class="btn btn-add">Ajouter Employeur</button>
            </form>
        </section>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Raison Sociale</th>
                    <th>Secteur Activité</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="employeur" items="${employeurs}">
                    <tr>
                        <td><strong>#${employeur.id}</strong></td>
                        <td>${employeur.nom}</td>
                        <td>${employeur.raisonSociale}</td>
                        <td>${employeur.secteurActivite}</td>
                        <td>
                            <form method="post" action="employeurs" style="display:inline;">
                                <input type="hidden" name="action" value="supprimer">
                                <input type="hidden" name="id" value="${employeur.id}">
                                <button type="submit" class="btn btn-delete" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet employeur ?')">Supprimer</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</main>

<footer>
    &copy; 2026 e-Social Systems | Tous droits réservés
</footer>

</body>
</html>