package org.esocialsystems.esocialsystems.Servlet;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.esocialsystems.esocialsystems.Services.AssureServices;
import org.esocialsystems.esocialsystems.utils.JpaUtil;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/assures")
public class AssureServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            AssureServices service = new AssureServices(em);
            request.setAttribute("assures", service.listerAssures());
            request.getRequestDispatcher("assures.jsp").forward(request, response);
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
            AssureServices service = new AssureServices(em);

            if ("ajouter".equals(action)) {
                String nom = request.getParameter("nom");
                BigDecimal salaire = new BigDecimal(request.getParameter("salaire"));
                Long employeurId = Long.parseLong(request.getParameter("employeurId"));
                service.ajouterAssure(null, nom, salaire, employeurId);
            } else if ("modifierSalaire".equals(action)) {
                Long assureId = Long.parseLong(request.getParameter("assureId"));
                BigDecimal salaire = new BigDecimal(request.getParameter("salaire"));
                service.modifierSalaire(assureId, salaire);
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }
        response.sendRedirect(request.getContextPath() + "/assures");
    }
}
