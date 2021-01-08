/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ClienteDAO;
import Modelo.Cliente;
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
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    ClienteDAO clienteDAO = new ClienteDAO();

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
                String email = request.getParameter("txtEmail");
                String telefono = request.getParameter("txtTelefono");

                //Paso 2: Guardar los valores en un objeto
                Cliente c = new Cliente(id, nombre, email, telefono);

                //Paso 3: Guardar los valores en la bd
                if (clienteDAO.create(c)) {
                    request.getSession().setAttribute("msj", "Cliente se agregó exitosamente");
                    response.sendRedirect("crudCliente.jsp");
                } else {
                    request.getSession().setAttribute("msj", "Falló el registro de cliente");
                    response.sendRedirect("crudCliente.jsp");
                }
            }

            if (bt.equals("Buscar")) {
                //Paso 1: Recuperar el id de cliente del formulario
                int id = Integer.parseInt(request.getParameter("txtId"));

                //Paso 2: Buscar en la bd el id ingresado
                Cliente c = clienteDAO.read(id);

                //Paso 3: Verificar existencia y Rellenar el formulario con el cliente encontrado.
                if (c == null) {
                    //No encuentra el cliente
                    request.getSession().setAttribute("id", "");
                    request.getSession().setAttribute("nombre", "");
                    request.getSession().setAttribute("email", "");
                    request.getSession().setAttribute("telefono", "");

                    request.getSession().setAttribute("msj", "Cliente Buscado NO existe");
                    response.sendRedirect("crudCliente.jsp");
                } else {
                    //Si lo encontró
                    request.getSession().setAttribute("id", c.getId());
                    request.getSession().setAttribute("nombre", c.getNombre());
                    request.getSession().setAttribute("email", c.getEmail());
                    request.getSession().setAttribute("telefono", c.getTelefono());
                    request.getSession().setAttribute("msj", "");
                    response.sendRedirect("crudCliente.jsp");
                }

            }

            if (bt.equals("Actualizar")) {
                //Paso 1: Recuperar valores del formulario
                int id = Integer.parseInt(request.getParameter("txtId"));
                String nombre = request.getParameter("txtNombre");
                String email = request.getParameter("txtEmail");
                String telefono = request.getParameter("txtTelefono");

                //Paso 2: Guardar los valores en un objeto
                Cliente c = new Cliente(id, nombre, email, telefono);

                //Paso 3: Guardar los valores en la bd
                if (clienteDAO.update(c)) {
                    request.getSession().setAttribute("msj", "Cliente se actualizó exitosamente");
                    response.sendRedirect("crudCliente.jsp");

                } else {
                    request.getSession().setAttribute("msj", "Falló la actualización de cliente");
                    response.sendRedirect("crudCliente.jsp");
                }

            }

            if (bt.equals("Eliminar")) {
                //Paso 1: Recuperar el id de cliente del formulario
                int id = Integer.parseInt(request.getParameter("txtId"));

                //Paso 2: Buscar en la bd el id ingresado
                Cliente c = clienteDAO.read(id);

                //Paso 3: Verificar existencia y Rellenar el formulario con el cliente encontrado.
                if (c == null) {
                    //No existe el cliente
                    request.getSession().setAttribute("msj", "Cliente NO existe, No se puede eliminar");
                    response.sendRedirect("crudCliente.jsp");
                } else {
                    //Si lo encontró
                    if (clienteDAO.delete(id)) {
                        request.getSession().setAttribute("msj", "Cliente se eliminó correctamente");
                        response.sendRedirect("crudCliente.jsp");
                    } else {
                        request.getSession().setAttribute("msj", "Error al eliminar cliente");
                        response.sendRedirect("crudCliente.jsp");
                    }

                    request.getSession().setAttribute("id", "");
                    request.getSession().setAttribute("nombre", "");
                    request.getSession().setAttribute("email", "");
                    request.getSession().setAttribute("telefono", "");
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
