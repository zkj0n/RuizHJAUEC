package es.albarregas.controllers.update;

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

@WebServlet(name = "Update", value = "/Update"/*, initParams = {
        @WebInitParam(name = "Primero", value = "Hola"),
        @WebInitParam(name = "Segundo", value = "Mundo")}*/)
public class Update extends HttpServlet {

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
        String id = request.getParameter("id");
        String tipo = request.getParameter("tipo");

        Codigo pk = new Codigo();
        pk.setId(Integer.parseInt(id));
        pk.setTipo(tipo);
        String url;
        if (id != null && !id.isEmpty()) {
            IProfesorDAO profesorDAO = new ProfesorDAO();
            Profesor profesor;
            profesor = profesorDAO.getOne((pk));
            if (profesor != null) {
                request.setAttribute("p", profesor);
                url = "./JSP/update/change.jsp";
            } else {
                request.setAttribute("error", "no se ha encontrado ningún profesor con ese id");
                url = "./JSP/update/update.jsp";
            }
        } else {
            request.setAttribute("error", "no se ha seleccionado ningún profesor");
            url = "./JSP/update/update.jsp";
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