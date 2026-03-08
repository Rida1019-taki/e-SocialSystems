package org.esocialsystems.esocialsystems.Servlet;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.esocialsystems.esocialsystems.Services.DeclarationServices;
import org.esocialsystems.esocialsystems.utils.JpaUtil;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/declarations")
public class DeclarationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            DeclarationServices service = new DeclarationServices(em);
            request.setAttribute("declarations", service.listerDeclarations());
            request.getRequestDispatcher("declarations.jsp").forward(request, response);
        } finally {
            em.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            DeclarationServices service = new DeclarationServices(em);

            if ("creer".equals(action)) {
                Long employeurId = Long.parseLong(request.getParameter("employeurId"));
                int mois = Integer.parseInt(request.getParameter("mois"));
                int annee = Integer.parseInt(request.getParameter("annee"));
                service.creerDeclaration(employeurId, mois, annee, LocalDate.now());
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }
        response.sendRedirect(request.getContextPath() + "/declarations");
    }
}
