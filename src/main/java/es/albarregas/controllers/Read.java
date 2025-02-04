package es.albarregas.controllers;

import es.albarregas.DAO.IProfesorDAO;
import es.albarregas.DAO.ProfesorDAO;
import es.albarregas.beans.Codigo;
import es.albarregas.beans.Profesor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Read", value = "/Read")
public class Read extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./FrontController").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");

        String url;
        IProfesorDAO profesorDAO = new ProfesorDAO();
        if (id != null && !id.isEmpty()) {
            String tipo = request.getParameter("tipo");
            Codigo pk = new Codigo();
            pk.setId(Integer.parseInt(id));
            pk.setTipo(tipo);
            Profesor profesor = profesorDAO.getOne(pk);
            if (profesor != null) {
                request.setAttribute("p", profesor);
                url = "./JSP/read/readOne.jsp";
            } else {
                request.setAttribute("error", "no se ha encontrado ningún profesor con ese id");
                url = "./JSP/read/read.jsp";
            }
        } else {
            List<Profesor> profesores = profesorDAO.get();
            if (!profesores.isEmpty()) {
                request.setAttribute("profesores", profesores);
                url = "./JSP/read/readAll.jsp";
            } else {
                request.setAttribute("error", "aún no hay profesores registrados");
                url = "./JSP/read/read.jsp";
            }
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}