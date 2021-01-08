/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author mtroncoc
 */
public interface IOpVehiculo {

    public boolean create(Vehiculo v);

    public boolean update(Vehiculo v);

    public boolean delete(int id);

    public Vehiculo read(int id);
}
