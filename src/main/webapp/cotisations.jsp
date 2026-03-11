<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calcul des Cotisations - e-Social Systems</title>
    <style>
        :root {
            --primary-color: #40739e;
            --secondary-color: #273c75;
            --bg-color: #f5f6fa;
            --text-color: #2f3640;
            --white: #ffffff;
            --accent: #9b59b6;
            --success: #4cd137;
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
            align-items: center;
        }

        input[type=number] {
            padding: 0.7rem;
            border: 1px solid #ddd;
            border-radius: 5px;
            width: 200px;
        }

        .btn {
            padding: 0.7rem 1.5rem;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
            border: none;
            transition: all 0.3s;
        }

        .btn-calc { background-color: var(--accent); color: white; }
        .btn-calc:hover { background-color: #8e44ad; }

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

        .amount { font-weight: 600; color: var(--secondary-color); }
        .amount-salariale { color: #2980b9; }
        .amount-patronale { color: #27ae60; }

        footer {
            text-align: center;
            padding: 1.5rem;
            background-color: #2f3640;
            color: var(--white);
            margin-top: auto;
        }

        @media (max-width: 768px) {
            .form-group { flex-direction: column; align-items: stretch; }
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
        <li><a href="cotisations" class="active">Cotisations</a></li>
    </ul>
</nav>

<main>
    <div class="container">
        <h2>💰 Calcul des Cotisations</h2>

        <c:if test="${not empty sessionScope.message}">
            <div style="padding: 1rem; margin-bottom: 1rem; border-radius: 5px; background-color: ${sessionScope.messageType == 'success' ? '#dff9fb' : '#fab1a0'}; color: ${sessionScope.messageType == 'success' ? '#2ecc71' : '#e74c3c'}; border: 1px solid ${sessionScope.messageType == 'success' ? '#2ecc71' : '#e74c3c'};">
                ${sessionScope.message}
            </div>
            <c:remove var="message" scope="session" />
            <c:remove var="messageType" scope="session" />
        </c:if>
        
        <section class="form-card">
            <form method="post" action="cotisations" class="form-group">
                <input type="number" name="declarationId" placeholder="ID Déclaration" required>
                <input type="hidden" name="action" value="calculer">
                <button type="submit" class="btn btn-calc">Calculer Cotisations</button>
            </form>
        </section>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Assuré</th>
                    <th>ID Déclaration</th>
                    <th>Cotisation Salariale</th>
                    <th>Cotisation Patronale</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="c" items="${cotisations}">
                    <tr>
                        <td><strong>#${c.id}</strong></td>
                        <td>${c.assure.nom}</td>
                        <td><span style="background: #e1e8ed; padding: 2px 8px; border-radius: 12px; font-size: 0.9rem;">#${c.declaration.id}</span></td>
                        <td><span class="amount amount-salariale">${c.cotisationSalariale} DH</span></td>
                        <td><span class="amount amount-patronale">${c.cotisationPatronale} DH</span></td>
                        <td><span class="amount" style="color: var(--secondary-color)">${c.cotisationSalariale + c.cotisationPatronale} DH</span></td>
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