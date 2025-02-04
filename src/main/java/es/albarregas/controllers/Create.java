package es.albarregas.controllers;

import es.albarregas.DAO.IProfesorDAO;
import es.albarregas.DAO.ProfesorDAO;
import es.albarregas.beans.Profesor;
import es.albarregas.models.ProfesorModel;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "Create", value = "/Create")
public class Create extends HttpServlet {

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

        Profesor profesor = new Profesor();
        String url;
        try {
            BeanUtils.populate(profesor, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        if (ProfesorModel.validarProfesor(profesor)) {
            IProfesorDAO profesorDAO = new ProfesorDAO();
            profesorDAO.add(profesor);
            request.setAttribute("p", profesor);
            url = "./JSP/read/readOne.jsp";
        } else {
            request.setAttribute("error", "el nombre y el primer apellido son obligatorios");
            url = "./JSP/create/create.jsp";
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