package org.esocialsystems.esocialsystems.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.esocialsystems.esocialsystems.Model.Employeur;
import org.esocialsystems.esocialsystems.Services.EmployeurServices;
import java.io.IOException;
import java.util.List;

@WebServlet("/employeurs")
public class EmployeurServlet extends HttpServlet {

    private EmployeurServices employeurService;

    @Override
    public void init() throws ServletException {
        this.employeurService = new EmployeurServices();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        List<Employeur> employeurs = employeurService.findAll();
        request.setAttribute("employeurs", employeurs);

        request.getRequestDispatcher("employeurs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");

        if ("ajouter".equals(action)) {
            String nom = request.getParameter("nom");
            String raisonSociale = request.getParameter("raisonSociale");
            String secteurActivite = request.getParameter("secteurActivite");

            Employeur e = new Employeur();
            e.setNom(nom);
            e.setRaisonSociale(raisonSociale);
            e.setSecteurActivite(secteurActivite);

            employeurService.ajouter(e);

        } else if ("modifier".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            Employeur e = employeurService.findById(id);
            if (e != null) {
                e.setNom(request.getParameter("nom"));
                e.setRaisonSociale(request.getParameter("raisonSociale"));
                e.setSecteurActivite(request.getParameter("secteurActivite"));
                employeurService.update(e);
            }
        } else if ("supprimer".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            employeurService.delete(id);
        }

        response.sendRedirect(request.getContextPath() + "/employeurs");
    }
}