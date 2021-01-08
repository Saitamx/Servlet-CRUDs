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
public interface IOpCliente {

    public boolean create(Cliente c);

    public boolean update(Cliente c);

    public boolean delete(int id);

    public Cliente read(int id);
}
