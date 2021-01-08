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
public interface IOpServicio {

    public boolean create(Servicio s);

    public boolean update(Servicio s);

    public boolean delete(int id);

    public Servicio read(int id);
}
