package org.esocialsystems.esocialsystems.Servlet;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.esocialsystems.esocialsystems.Services.CotisationServices;

import java.io.IOException;

@WebServlet("/cotisations")
public class CotisationServlet extends HttpServlet {

    @Inject
    private CotisationServices cotisationService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String action = request.getParameter("action");

        if ("calculer".equals(action)) {
            Long declarationId = Long.parseLong(request.getParameter("declarationId"));
            cotisationService.calculerCotisations(declarationId);
        }

        response.sendRedirect(request.getContextPath() + "/cotisations");
    }

}
