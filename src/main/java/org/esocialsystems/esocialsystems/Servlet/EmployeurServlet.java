package org.esocialsystems.esocialsystems.Servlet;

import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.esocialsystems.esocialsystems.Model.Employeur;
import org.esocialsystems.esocialsystems.Services.EmployeurServices;
import java.io.IOException;
import java.util.List;

@WebServlet("/employeurs")
public class EmployeurServlet extends HttpServlet {
    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        // Smiya khassha tkon kif li f persistence.xml
        this.emf = Persistence.createEntityManagerFactory("eSocialPU");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EntityManager em = emf.createEntityManager();
        try {
            EmployeurServices service = new EmployeurServices(em);
            request.setAttribute("employeurs", service.findAll());
            // Path bidoun /WEB-INF/ hit ghadi t-khrej l-JSP l-webapp
            request.getRequestDispatcher("employeurs.jsp").forward(request, response);
        } finally {
            em.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        EntityManager em = emf.createEntityManager();
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
            // Zid hna logic dyal modifier ila bghiti...

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }
        response.sendRedirect(request.getContextPath() + "/employeurs");
    }

    @Override
    public void destroy() {
        if (emf != null) emf.close();
    }
}