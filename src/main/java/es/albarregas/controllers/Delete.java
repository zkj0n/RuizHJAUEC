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
import java.io.PrintWriter;

@WebServlet(name = "Delete", value = "/Delete"/*, initParams = {
        @WebInitParam(name = "Primero", value = "Hola"),
        @WebInitParam(name = "Segundo", value = "Mundo")}*/)
public class Delete extends HttpServlet {

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
        String tipo = request.getParameter("tipo");
        Codigo pk = new Codigo();
        pk.setId(Integer.parseInt(id));
        pk.setTipo(tipo);
        String url;
        if (id == null || id.isEmpty()) {
            request.setAttribute("error", "el id no puede ser nulo");
            url = "./JSP/delete/delete.jsp";
        } else {
            IProfesorDAO profesorDAO = new ProfesorDAO();
            Profesor profesor = profesorDAO.getOne(pk);
            if (profesor != null) {
                profesorDAO.delete(profesor);
                request.setAttribute("p", profesor);
                url = "./JSP/delete/salida.jsp";
            } else {
                request.setAttribute("error", "no existe un profesor con el id " + id);
                url = "./JSP/delete/delete.jsp";
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