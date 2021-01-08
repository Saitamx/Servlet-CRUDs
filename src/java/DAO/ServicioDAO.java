/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */
package DAO;

import Conexion.Conectar;

import Modelo.IOpServicio;

import Modelo.Servicio;

import java.sql.ResultSet;

import java.sql.SQLException;

/**
 *
 *
 *
 * @author mtroncoc
 *
 */
public class ServicioDAO implements IOpServicio {

    @Override

    public boolean create(Servicio s) {

        String sql = "INSERT INTO servicio VALUES (" + s.getId()
                + ",'" + s.getNombre()
                + "','" + s.getPrecio()
                + "')";

        Conectar conectar = new Conectar();

        return conectar.ejecutarSQL(sql);

    }

    @Override

    public boolean update(Servicio s) {

        String sql = "UPDATE servicio SET "
                + "nombre='" + s.getNombre()
                + "', precio= '" + s.getPrecio()
                + "' WHERE id =" + s.getId();

        Conectar conectar = new Conectar();

        return conectar.ejecutarSQL(sql);

    }

    @Override

    public boolean delete(int id) {

        String sql = "DELETE FROM servicio WHERE id =" + id;

        Conectar conectar = new Conectar();

        return conectar.ejecutarSQL(sql);

    }

    @Override

    public Servicio read(int id) {

        String sql = "SELECT * FROM servicio WHERE id=" + id;

        Conectar conectar = new Conectar();

        ResultSet rs = conectar.consultar(sql);

        Servicio s = null;

        //Leer el ResultSet y obtener los productos que almacena
        try {

            while (rs.next()) {

                s = new Servicio();

                s.setId(rs.getInt(1));

                s.setNombre(rs.getString(2));

                s.setPrecio(rs.getString(3));

            }

        } catch (SQLException ex) {

            System.out.println(ex);

        }

        return s;

    }

}
