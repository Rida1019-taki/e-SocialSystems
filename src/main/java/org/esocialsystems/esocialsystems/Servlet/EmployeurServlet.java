package org.esocialsystems.esocialsystems.Servlet;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.esocialsystems.esocialsystems.Model.Employeur;
import org.esocialsystems.esocialsystems.Services.EmployeurServices;
import org.esocialsystems.esocialsystems.utils.JpaUtil;

import java.io.IOException;

@WebServlet("/employeurs")
public class EmployeurServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            EmployeurServices service = new EmployeurServices(em);
            request.setAttribute("employeurs", service.findAll());
            request.getRequestDispatcher("employeurs.jsp").forward(request, response);
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
            EmployeurServices service = new EmployeurServices(em);

            if ("ajouter".equals(action)) {
                Employeur e = new Employeur();
                e.setNom(request.getParameter("nom"));
                e.setRaisonSociale(request.getParameter("raisonSociale"));
                e.setSecteurActivite(request.getParameter("secteurActivite"));
                service.ajouter(e);
            } else if ("supprimer".equals(action)) {
                service.delete(Long.parseLong(request.getParameter("id")));
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }
        response.sendRedirect(request.getContextPath() + "/employeurs");
    }
}
