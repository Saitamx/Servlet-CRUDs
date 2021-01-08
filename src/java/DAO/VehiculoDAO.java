/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */
package DAO;

import Conexion.Conectar;
import Modelo.IOpVehiculo;
import Modelo.Vehiculo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 *
 *
 * @author mtroncoc
 *
 */
public class VehiculoDAO implements IOpVehiculo {

    @Override
    public boolean create(Vehiculo v) {
        String sql = "INSERT INTO vehiculo VALUES (" + v.getId()
                + ",'" + v.getPatente()
                + "','" + v.getColor()
                + "','" + v.getModelo()
                + "')";
        Conectar conectar = new Conectar();
        return conectar.ejecutarSQL(sql);

    }

    @Override
    public boolean update(Vehiculo v) {
        String sql = "UPDATE vehiculo SET "
                + "patente='" + v.getPatente()
                + "',color= '" + v.getColor()
                + "',modelo= '" + v.getModelo()
                + "' WHERE id =" + v.getId();

        Conectar conectar = new Conectar();
        return conectar.ejecutarSQL(sql);
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM vehiculo WHERE id =" + id;
        Conectar conectar = new Conectar();
        return conectar.ejecutarSQL(sql);
    }

    @Override
    public Vehiculo read(int id) {
        String sql = "SELECT * FROM vehiculo WHERE id=" + id;
        Conectar conectar = new Conectar();
        ResultSet rs = conectar.consultar(sql);
        Vehiculo v = null;
        //Leer el ResultSet y obtener los productos que almacena
        try {
            while (rs.next()) {
                v = new Vehiculo();
                v.setId(rs.getInt(1));
                v.setPatente(rs.getString(2));
                v.setColor(rs.getString(3));
                v.setModelo(rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return v;
    }

}
