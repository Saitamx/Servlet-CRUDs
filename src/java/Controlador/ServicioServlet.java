/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ServicioDAO;
import Modelo.Servicio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mtroncoc
 */
@WebServlet(name = "ServicioServlet", urlPatterns = {"/ServicioServlet"})
public class ServicioServlet extends HttpServlet {

    ServicioDAO servicioDAO = new ServicioDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //Recuperar boton
            String bt = request.getParameter("bt");

            if (bt.equals("Registrar")) {

                //Paso 1: Recuperar valores del formulario
                int id = Integer.parseInt(request.getParameter("txtId"));
                String nombre = request.getParameter("txtNombre");
                String precio = request.getParameter("txtPrecio");

                //Paso 2: Guardar los valores en un objeto
                Servicio s = new Servicio(id, nombre, precio);

                //Paso 3: Guardar los valores en la bd
                if (servicioDAO.create(s)) {
                    request.getSession().setAttribute("msj", "Servicio se agregó exitosamente");
                    response.sendRedirect("crudServicio.jsp");
                } else {
                    request.getSession().setAttribute("msj", "Falló el registro de servicio");
                    response.sendRedirect("crudServicio.jsp");
                }
            }

            if (bt.equals("Buscar")) {
                //Paso 1: Recuperar el id de servicio del formulario
                int id = Integer.parseInt(request.getParameter("txtId"));

                //Paso 2: Buscar en la bd el id ingresado
                Servicio s = servicioDAO.read(id);

                //Paso 3: Verificar existencia y Rellenar el formulario con el servicio encontrado.
                if (s == null) {
                    //No encuentra el servicio
                    request.getSession().setAttribute("id", "");
                    request.getSession().setAttribute("nombre", "");
                    request.getSession().setAttribute("precio", "");

                    request.getSession().setAttribute("msj", "Servicio Buscado NO existe");
                    response.sendRedirect("crudServicio.jsp");
                } else {
                    //Si lo encontró
                    request.getSession().setAttribute("id", s.getId());
                    request.getSession().setAttribute("nombre", s.getNombre());
                    request.getSession().setAttribute("precio", s.getPrecio());
                    request.getSession().setAttribute("msj", "");
                    response.sendRedirect("crudServicio.jsp");
                }

            }

            if (bt.equals("Actualizar")) {
                //Paso 1: Recuperar valores del formulario
                int id = Integer.parseInt(request.getParameter("txtId"));
                String nombre = request.getParameter("txtNombre");
                String precio = request.getParameter("txtPrecio");

                //Paso 2: Guardar los valores en un objeto
                Servicio s = new Servicio(id, nombre, precio);

                //Paso 3: Guardar los valores en la bd
                if (servicioDAO.update(s)) {
                    request.getSession().setAttribute("msj", "Servicio se actualizó exitosamente");
                    response.sendRedirect("crudServicio.jsp");

                } else {
                    request.getSession().setAttribute("msj", "Falló la actualización de servicio");
                    response.sendRedirect("crudServicio.jsp");
                }

            }

            if (bt.equals("Eliminar")) {
                //Paso 1: Recuperar el id de servicio del formulario
                int id = Integer.parseInt(request.getParameter("txtId"));

                //Paso 2: Buscar en la bd el id ingresado
                Servicio s = servicioDAO.read(id);

                //Paso 3: Verificar existencia y Rellenar el formulario con el servicio encontrado.
                if (s == null) {
                    //No existe el servicio
                    request.getSession().setAttribute("msj", "Servicio NO existe, No se puede eliminar");
                    response.sendRedirect("crudServicio.jsp");
                } else {
                    //Si lo encontró
                    if (servicioDAO.delete(id)) {
                        request.getSession().setAttribute("msj", "Servicio se eliminó correctamente");
                        response.sendRedirect("crudServicio.jsp");
                    } else {
                        request.getSession().setAttribute("msj", "Error al eliminar servicio");
                        response.sendRedirect("crudServicio.jsp");
                    }

                    request.getSession().setAttribute("id", "");
                    request.getSession().setAttribute("nombre", "");
                    request.getSession().setAttribute("precio", "");
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
