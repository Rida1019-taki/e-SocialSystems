package org.esocialsystems.esocialsystems.Servlet;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.esocialsystems.esocialsystems.Model.Assure;
import org.esocialsystems.esocialsystems.Services.AssureServices;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/assures")
public class AssureServlet extends HttpServlet {

    @Inject
    private AssureServices assureService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Assure> assures = assureService.listerAssures();
        request.setAttribute("assures", assures);

        try {
            request.getRequestDispatcher("assures.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String action = request.getParameter("action");

        if ("ajouter".equals(action)) {
            String nom = request.getParameter("nom");
            BigDecimal salaire = new BigDecimal(request.getParameter("salaire"));
            Long employeurId = Long.parseLong(request.getParameter("employeurId"));

            assureService.ajouterAssure(null, nom, salaire, employeurId);

        } else if ("modifierSalaire".equals(action)) {
            Long assureId = Long.parseLong(request.getParameter("assureId"));
            BigDecimal salaire = new BigDecimal(request.getParameter("salaire"));

            assureService.modifierSalaire(assureId, salaire);
        }

        response.sendRedirect(request.getContextPath() + "/assures");
    }
}
