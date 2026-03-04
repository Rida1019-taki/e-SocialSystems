package org.esocialsystems.esocialsystems.Servlet;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.esocialsystems.esocialsystems.Model.Employeur;
import org.esocialsystems.esocialsystems.Services.EmployeurServices;
import java.io.IOException;
import java.util.List;

@WebServlet("/employeurs")
public class EmployeurServlet extends HttpServlet {

    @Inject
    private EmployeurServices employeurService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Employeur> employeurs = employeurService.findAll();
        request.setAttribute("employeurs", employeurs);

        try {
            request.getRequestDispatcher("employeurs.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String action = request.getParameter("action");

        if ("ajouter".equals(action)) {
            String nom = request.getParameter("nom");

            Employeur e = new Employeur();
            e.setNom(nom);

            employeurService.ajouter(e);

        } else if ("modifier".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            String nom = request.getParameter("nom");

            Employeur e = employeurService.findById(id);
            if (e != null) {
                e.setNom(nom);
                employeurService.update(e);
            }

        } else if ("supprimer".equals(action)) {
            Long id = Long.parseLong(request.getParameter("id"));
            employeurService.delete(id);
        }

        response.sendRedirect(request.getContextPath() + "/employeurs");
    }
}
