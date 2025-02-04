package es.albarregas.controllers.update;

import es.albarregas.DAO.IProfesorDAO;
import es.albarregas.DAO.ProfesorDAO;
import es.albarregas.beans.Codigo;
import es.albarregas.beans.Profesor;
import es.albarregas.models.ProfesorModel;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "Change", value = "/Change")
public class Change extends HttpServlet {

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
        IProfesorDAO profesorDAO = new ProfesorDAO();
        String url;
        try {
            ConvertUtils.register(new org.apache.commons.beanutils.converters.SqlTimestampConverter(null), java.util.Calendar.class);
            BeanUtils.populate(profesor, request.getParameterMap());
            profesor.setCodigo(new Codigo(Integer.parseInt(request.getParameter("id")), request.getParameter("tipo")));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        if (ProfesorModel.validarProfesor(profesor)) {
            Profesor profesorAntiguo = profesorDAO.getOne(profesor.getCodigo());

            if (profesorAntiguo.equals(profesor)){
                request.setAttribute("error", "no se ha modificado ningún campo");
                request.setAttribute("p", profesor);
                url = "./JSP/update/change.jsp";
            } else {
                profesorDAO.update(profesor);
                request.setAttribute("p", profesor);
                request.setAttribute("mensaje", "profesor modificado");
                url = "./JSP/read/readOne.jsp";
            }

        } else {
            request.setAttribute("error", "el nombre y el primer apellido son obligatorios");
            url = "./JSP/update/change.jsp";
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