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
        IProfesorDAO profesorDAO = new ProfesorDAO();
        String url;

        try {
            String codigo = request.getParameter("codigo");
            Codigo c = new Codigo(Integer.parseInt(codigo.split("-")[0]), codigo.split("-")[1]);

            Profesor profesor = profesorDAO.getOne(c);

            if (profesor != null) {
                profesorDAO.delete(profesor);
                request.setAttribute("p", profesor);
                request.setAttribute("mensaje", "profesor eliminado");
                url = "./JSP/read/readOne.jsp";
            } else {
                request.setAttribute("error", "Profesor no encontrado");
                url = "./JSP/delete/delete.jsp";
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "id no válido");
            url = "./JSP/delete/delete.jsp";
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