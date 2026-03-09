<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Droits Sociaux - e-Social Systems</title>
    <style>
        :root {
            --primary-color: #40739e;
            --secondary-color: #273c75;
            --bg-color: #f5f6fa;
            --text-color: #2f3640;
            --white: #ffffff;
            --accent: #1abc9c;
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

        .badge-months {
            background-color: #3498db;
            color: white;
            padding: 4px 10px;
            border-radius: 20px;
            font-size: 0.85rem;
            font-weight: bold;
        }

        .total-cotis {
            font-weight: bold;
            color: var(--accent);
            font-size: 1.1rem;
        }

        footer {
            text-align: center;
            padding: 1.5rem;
            background-color: #2f3640;
            color: var(--white);
            margin-top: auto;
        }

        @media (max-width: 768px) {
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
        <li><a href="employeurs">Employeurs</a></li>
        <li><a href="assures">Assurés</a></li>
        <li><a href="declarations">Déclarations</a></li>
        <li><a href="cotisations">Cotisations</a></li>
        <li><a href="droits" class="active">Droits Sociaux</a></li>
    </ul>
</nav>

<main>
    <div class="container">
        <h2>⚖️ Consultation des Droits Sociaux</h2>
        
        <table>
            <thead>
                <tr>
                    <th>Nom de l'Assuré</th>
                    <th>Employeur Actuel</th>
                    <th>Mois Déclarés</th>
                    <th>Cumul des Cotisations</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="assure" items="${assures}">
                    <tr>
                        <td><strong>${assure.nom}</strong></td>
                        <td><span style="color: var(--gray)">${assure.employeur.nom}</span></td>
                        <td><span class="badge-months">${moisMap[assure.id]} mois</span></td>
                        <td><span class="total-cotis">${cotisMap[assure.id]} DH</span></td>
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