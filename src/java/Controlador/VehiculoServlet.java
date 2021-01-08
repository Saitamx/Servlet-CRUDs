/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.VehiculoDAO;
import Modelo.Vehiculo;
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
@WebServlet(name = "VehiculoServlet", urlPatterns = {"/VehiculoServlet"})
public class VehiculoServlet extends HttpServlet {

    VehiculoDAO vehiculoDAO = new VehiculoDAO();

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
                String patente = request.getParameter("txtPatente");
                String color = request.getParameter("txtColor");
                String modelo = request.getParameter("txtModelo");

                //Paso 2: Guardar los valores en un objeto
                Vehiculo v = new Vehiculo(id, patente, color, modelo);

                //Paso 3: Guardar los valores en la bd
                if (vehiculoDAO.create(v)) {
                    request.getSession().setAttribute("msj", "Vehiculo se agregó exitosamente");
                    response.sendRedirect("crudVehiculo.jsp");
                } else {
                    request.getSession().setAttribute("msj", "Falló el registro de vehiculo");
                    response.sendRedirect("crudVehiculo.jsp");
                }
            }

            if (bt.equals("Buscar")) {
                //Paso 1: Recuperar el id de vehiculo del formulario
                int id = Integer.parseInt(request.getParameter("txtId"));

                //Paso 2: Buscar en la bd el id ingresado
                Vehiculo v = vehiculoDAO.read(id);

                //Paso 3: Verificar existencia y Rellenar el formulario con el vehiculo encontrado.
                if (v == null) {
                    //No encuentra el vehiculo
                    request.getSession().setAttribute("id", "");
                    request.getSession().setAttribute("patente", "");
                    request.getSession().setAttribute("color", "");
                    request.getSession().setAttribute("modelo", "");

                    request.getSession().setAttribute("msj", "Vehiculo Buscado NO existe");
                    response.sendRedirect("crudVehiculo.jsp");
                } else {
                    //Si lo encontró
                    request.getSession().setAttribute("id", v.getId());
                    request.getSession().setAttribute("patente", v.getPatente());
                    request.getSession().setAttribute("color", v.getColor());
                    request.getSession().setAttribute("modelo", v.getModelo());
                    request.getSession().setAttribute("msj", "");
                    response.sendRedirect("crudVehiculo.jsp");
                }

            }

            if (bt.equals("Actualizar")) {
                //Paso 1: Recuperar valores del formulario
                int id = Integer.parseInt(request.getParameter("txtId"));
                String nombre = request.getParameter("txtNombre");
                String patente = request.getParameter("txtPatente");
                String color = request.getParameter("txtColor");
                String modelo = request.getParameter("txtModelo");

                //Paso 2: Guardar los valores en un objeto
                Vehiculo v = new Vehiculo(id, patente, color, modelo);

                //Paso 3: Guardar los valores en la bd
                if (vehiculoDAO.update(v)) {
                    request.getSession().setAttribute("msj", "Vehiculo se actualizó exitosamente");
                    response.sendRedirect("crudVehiculo.jsp");

                } else {
                    request.getSession().setAttribute("msj", "Falló la actualización de vehiculo");
                    response.sendRedirect("crudVehiculo.jsp");
                }

            }

            if (bt.equals("Eliminar")) {
                //Paso 1: Recuperar el id de vehiculo del formulario
                int id = Integer.parseInt(request.getParameter("txtId"));

                //Paso 2: Buscar en la bd el id ingresado
                Vehiculo v = vehiculoDAO.read(id);

                //Paso 3: Verificar existencia y Rellenar el formulario con el vehiculo encontrado.
                if (v == null) {
                    //No existe el vehiculo
                    request.getSession().setAttribute("msj", "Vehiculo NO existe, No se puede eliminar");
                    response.sendRedirect("crudVehiculo.jsp");
                } else {
                    //Si lo encontró
                    if (vehiculoDAO.delete(id)) {
                        request.getSession().setAttribute("msj", "Vehiculo se eliminó correctamente");
                        response.sendRedirect("crudVehiculo.jsp");
                    } else {
                        request.getSession().setAttribute("msj", "Error al eliminar vehiculo");
                        response.sendRedirect("crudVehiculo.jsp");
                    }

                    request.getSession().setAttribute("id", "");
                    request.getSession().setAttribute("patente", "");
                    request.getSession().setAttribute("color", "");
                    request.getSession().setAttribute("modelo", "");
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
