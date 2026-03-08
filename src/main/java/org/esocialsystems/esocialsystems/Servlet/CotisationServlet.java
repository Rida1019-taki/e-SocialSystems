package org.esocialsystems.esocialsystems.Servlet;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.esocialsystems.esocialsystems.DAO.CotisationDAO;
import org.esocialsystems.esocialsystems.Services.CotisationServices;
import org.esocialsystems.esocialsystems.utils.JpaUtil;

import java.io.IOException;

@WebServlet("/cotisations")
public class CotisationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            CotisationDAO dao = new CotisationDAO(em);
            request.setAttribute("cotisations", dao.findAll());
            request.getRequestDispatcher("cotisations.jsp").forward(request, response);
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
            CotisationServices service = new CotisationServices(em);

            if ("calculer".equals(action)) {
                Long declarationId = Long.parseLong(request.getParameter("declarationId"));
                service.calculerCotisations(declarationId);
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }
        response.sendRedirect(request.getContextPath() + "/cotisations");
    }
}
