<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>e-Social Systems</title>
    <style>
        /* ======= CSS Global ======= */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f6fa;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #2f3640;
            color: #f5f6fa;
            padding: 20px;
            text-align: center;
        }

        h1 {
            margin: 0;
            font-size: 2em;
        }

        nav {
            margin: 30px auto;
            width: 80%;
            text-align: center;
        }

        nav ul {
            list-style: none;
            padding: 0;
        }

        nav li {
            display: inline-block;
            margin: 15px 25px;
        }

        nav a {
            text-decoration: none;
            background-color: #40739e;
            color: #f5f6fa;
            padding: 12px 25px;
            border-radius: 5px;
            font-weight: bold;
            transition: 0.3s;
        }

        nav a:hover {
            background-color: #273c75;
        }

        footer {
            text-align: center;
            padding: 15px;
            background-color: #2f3640;
            color: #f5f6fa;
            position: fixed;
            width: 100%;
            bottom: 0;
        }

        /* ======= Box Dashboard ======= */
        .dashboard {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 20px;
            margin: 50px auto;
            width: 80%;
        }

        .card {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            width: 200px;
            text-align: center;
            transition: 0.3s;
        }

        .card:hover {
            box-shadow: 0 6px 12px rgba(0,0,0,0.2);
            transform: translateY(-5px);
        }

        .card a {
            display: block;
            margin-top: 15px;
            color: #40739e;
            text-decoration: none;
            font-weight: bold;
        }

        .card a:hover {
            color: #273c75;
        }
    </style>
</head>
<body>

<header>
    <h1>Bienvenue dans e-Social Systems</h1>
</header>

<div class="dashboard">
    <div class="card">
        <h2>Employeurs</h2>
        <a href="employeurs">Gérer les Employeurs</a>
    </div>

    <div class="card">
        <h2>Assurés</h2>
        <a href="assures">Gérer les Assurés</a>
    </div>

    <div class="card">
        <h2>Déclarations</h2>
        <a href="declarations">Déclarations Mensuelles</a>
    </div>

    <div class="card">
        <h2>Cotisations</h2>
        <a href="cotisations">Calcul des Cotisations</a>
    </div>

    <div class="card">
        <h2>Droits Sociaux</h2>
        <a href="droits">Consulter Droits Sociaux</a>
    </div>
</div>

<footer>
    &copy; 2026 e-Social Systems | Tous droits réservés
</footer>

</body>
</html>