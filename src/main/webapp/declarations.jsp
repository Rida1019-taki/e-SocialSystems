<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Déclarations Mensuelles - e-Social Systems</title>
    <style>
        :root {
            --primary-color: #40739e;
            --secondary-color: #273c75;
            --bg-color: #f5f6fa;
            --text-color: #2f3640;
            --white: #ffffff;
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
            align-items: flex-end;
        }

        .input-wrapper {
            display: flex;
            flex-direction: column;
            gap: 0.3rem;
            flex: 1;
            min-width: 150px;
        }

        label {
            font-size: 0.85rem;
            font-weight: 600;
            color: var(--gray);
        }

        input[type=number], input[type=date] {
            padding: 0.7rem;
            border: 1px solid #ddd;
            border-radius: 5px;
            width: 100%;
            box-sizing: border-box;
        }

        .btn {
            padding: 0.7rem 1.5rem;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
            border: none;
            transition: all 0.3s;
        }

        .btn-add { background-color: var(--success); color: white; }
        .btn-add:hover { background-color: #44bd32; }

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

        .date-badge {
            background: #e1e8ed;
            padding: 2px 8px;
            border-radius: 12px;
            font-size: 0.9rem;
        }

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
        <li><a href="declarations" class="active">Déclarations</a></li>
        <li><a href="cotisations">Cotisations</a></li>
    </ul>
</nav>

<main>
    <div class="container">
        <h2>📄 Déclarations Mensuelles</h2>

        <c:if test="${not empty sessionScope.message}">
            <div style="padding: 1rem; margin-bottom: 1rem; border-radius: 5px; background-color: ${sessionScope.messageType == 'success' ? '#dff9fb' : '#fab1a0'}; color: ${sessionScope.messageType == 'success' ? '#2ecc71' : '#e74c3c'}; border: 1px solid ${sessionScope.messageType == 'success' ? '#2ecc71' : '#e74c3c'};">
                ${sessionScope.message}
            </div>
            <c:remove var="message" scope="session" />
            <c:remove var="messageType" scope="session" />
        </c:if>
        
        <section class="form-card">
            <form method="post" action="declarations" class="form-group">
                <div class="input-wrapper">
                    <label>ID Employeur</label>
                    <input type="number" name="employeurId" placeholder="ID" required>
                </div>
                <div class="input-wrapper">
                    <label>Mois (1-12)</label>
                    <input type="number" name="mois" min="1" max="12" placeholder="MM" required>
                </div>
                <div class="input-wrapper">
                    <label>Année</label>
                    <input type="number" name="annee" placeholder="YYYY" required>
                </div>
                <div class="input-wrapper">
                    <label>Date Déclaration</label>
                    <input type="date" name="dateDeclaration" required>
                </div>
                <input type="hidden" name="action" value="creer">
                <button type="submit" class="btn btn-add">Créer Déclaration</button>
            </form>
        </section>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Employeur</th>
                    <th>Période</th>
                    <th>Date de Déclaration</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dec" items="${declarations}">
                    <tr>
                        <td><strong>#${dec.id}</strong></td>
                        <td>${dec.employeur.nom}</td>
                        <td><span style="font-weight: 600;">${dec.mois} / ${dec.annee}</span></td>
                        <td><span class="date-badge">${dec.dateDeclaration}</span></td>
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