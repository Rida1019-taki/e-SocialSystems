package org.esocialsystems.esocialsystems.Servlet;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.esocialsystems.esocialsystems.Model.Declaration;
import org.esocialsystems.esocialsystems.Services.DeclarationServices;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/declarations")
public class DeclarationServlet extends HttpServlet {

    @Inject
    private DeclarationServices declarationService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Declaration> declarations = declarationService.listerDeclarations();
        request.setAttribute("declarations", declarations);

        try {
            request.getRequestDispatcher("declarations.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String action = request.getParameter("action");

        if ("creer".equals(action)) {
            Long employeurId = Long.parseLong(request.getParameter("employeurId"));
            int mois = Integer.parseInt(request.getParameter("mois"));
            int annee = Integer.parseInt(request.getParameter("annee"));

            declarationService.creerDeclaration(employeurId, mois, annee, LocalDate.now());
        }

        response.sendRedirect(request.getContextPath() + "/declarations");
    }
}