/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conectar;
import Modelo.IOpCliente;
import Modelo.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mtroncoc
 */
public class ClienteDAO implements IOpCliente {

    @Override
    public boolean create(Cliente c) {
        String sql = "INSERT INTO cliente VALUES (" + c.getId()
                + ",'" + c.getNombre()
                + "','" + c.getEmail()
                + "','" + c.getTelefono()
                + "')";
        Conectar conectar = new Conectar();
        return conectar.ejecutarSQL(sql);

    }

    @Override
    public boolean update(Cliente c) {
        String sql = "UPDATE cliente SET "
                + "nombre='" + c.getNombre()
                + "',email= '" + c.getEmail()
                + "',telefono= '" + c.getTelefono()
                + "' WHERE id =" + c.getId();
        Conectar conectar = new Conectar();
        return conectar.ejecutarSQL(sql);

    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM cliente WHERE id =" + id;
        Conectar conectar = new Conectar();
        return conectar.ejecutarSQL(sql);
    }

    @Override
    public Cliente read(int id) {
        String sql = "SELECT * FROM cliente WHERE id=" + id;
        Conectar conectar = new Conectar();

        ResultSet rs = conectar.consultar(sql);
        Cliente c = null;
        //Leer el ResultSet y obtener los productos que almacena
        try {

            while (rs.next()) {
                c = new Cliente();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setTelefono(rs.getString(4));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return c;

    }

    public ArrayList<Cliente> read() {

        String sql = "SELECT * FROM cliente";
        ArrayList<Cliente> clientes = new ArrayList<>();
        Conectar conectar = new Conectar();

        ResultSet rs = conectar.consultar(sql);

        //Leer el ResultSet y obtener los productos que almacena
        try {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setTelefono(rs.getString(4));
                clientes.add(c);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return clientes;
    }
}
