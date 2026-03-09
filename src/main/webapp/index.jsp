<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - e-Social Systems</title>
    <style>
        :root {
            --primary-color: #40739e;
            --secondary-color: #273c75;
            --bg-color: #f5f6fa;
            --text-color: #2f3640;
            --white: #ffffff;
            --accent: #3498db;
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
            padding: 2.5rem 1.5rem;
            text-align: center;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }

        header h1 {
            margin: 0;
            font-size: 2.5rem;
            letter-spacing: 1px;
        }

        header p {
            margin-top: 10px;
            opacity: 0.8;
            font-size: 1.1rem;
        }

        main {
            flex: 1;
            padding: 3rem 2rem;
            max-width: 1200px;
            margin: 0 auto;
            width: 100%;
            box-sizing: border-box;
        }

        .dashboard {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
            gap: 2rem;
        }

        .card {
            background-color: var(--white);
            padding: 2.5rem;
            border-radius: 12px;
            box-shadow: 0 10px 20px rgba(0,0,0,0.05);
            text-align: center;
            transition: all 0.3s ease;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            border-top: 5px solid var(--primary-color);
        }

        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 15px 30px rgba(0,0,0,0.1);
        }

        .card h2 {
            margin: 0 0 1rem 0;
            color: var(--secondary-color);
            font-size: 1.5rem;
        }

        .card .icon {
            font-size: 3rem;
            margin-bottom: 1.5rem;
            color: var(--primary-color);
        }

        .card a {
            display: inline-block;
            margin-top: 1.5rem;
            background-color: var(--primary-color);
            color: var(--white);
            text-decoration: none;
            font-weight: bold;
            padding: 0.8rem 1.5rem;
            border-radius: 30px;
            transition: background 0.3s;
        }

        .card a:hover {
            background-color: var(--secondary-color);
        }

        footer {
            text-align: center;
            padding: 2rem;
            background-color: #2f3640;
            color: var(--white);
            font-size: 0.9rem;
        }

        /* Responsive */
        @media (max-width: 600px) {
            header h1 { font-size: 1.8rem; }
            .dashboard { grid-template-columns: 1fr; }
        }
    </style>
</head>
<body>

<header>
    <h1>e-Social Systems</h1>
    <p>Système de gestion intégrée de la protection sociale</p>
</header>

<main>
    <div class="dashboard">
        <div class="card">
            <div class="icon">🏢</div>
            <h2>Employeurs</h2>
            <p>Gérer les informations des entreprises et organismes.</p>
            <a href="employeurs">Accéder</a>
        </div>

        <div class="card">
            <div class="icon">👥</div>
            <h2>Assurés</h2>
            <p>Gérer le registre des employés et assurés sociaux.</p>
            <a href="assures">Accéder</a>
        </div>

        <div class="card">
            <div class="icon">📄</div>
            <h2>Déclarations</h2>
            <p>Suivi et gestion des déclarations mensuelles.</p>
            <a href="declarations">Accéder</a>
        </div>

        <div class="card">
            <div class="icon">💰</div>
            <h2>Cotisations</h2>
            <p>Calcul et consultation des cotisations sociales.</p>
            <a href="cotisations">Accéder</a>
        </div>

        <div class="card">
            <div class="icon">⚖️</div>
            <h2>Droits Sociaux</h2>
            <p>Consulter les droits et prestations des assurés.</p>
            <a href="droits">Accéder</a>
        </div>
    </div>
</main>

<footer>
    &copy; 2026 e-Social Systems | Plateforme Sécurisée de Gestion Sociale
</footer>

</body>
</html>