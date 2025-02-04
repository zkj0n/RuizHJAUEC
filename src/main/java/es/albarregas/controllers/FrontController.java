package es.albarregas.controllers;

import es.albarregas.DAO.IProfesorDAO;
import es.albarregas.DAO.ProfesorDAO;
import es.albarregas.beans.Profesor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

@WebServlet(name = "FrontController", value = "/FrontController")
public class FrontController extends HttpServlet {

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
//        processRequest(request, response);
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
        String accion = request.getParameter("accion");
        String url= ".";
        IProfesorDAO profesorDAO = new ProfesorDAO();
        List<Profesor> profesores = null;
        switch (accion.substring(0, 1).toLowerCase()){
            case "c":
                url = "./JSP/create/create.jsp";
            break;
            case "r":
                profesores = profesorDAO.get();
                request.setAttribute("profesores", profesores);
                url = "./JSP/read/read.jsp";
            break;
            case "u":
                profesores = profesorDAO.get();
                request.setAttribute("profesores", profesores);
                url = "./JSP/update/update.jsp";
            break;
            case "d":
                profesores = profesorDAO.get();
                request.setAttribute("profesores", profesores);
                url = "./JSP/delete/delete.jsp";
            break;
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