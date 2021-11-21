/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen.dao;

import almacen.modelo.Proveedor;
import java.util.List;

/**
 *
 * @author Yulis Araujo
 */
public interface ProveedorDaoLocal {

    void addProveedor(Proveedor proveedor);

    void editProveedor(Proveedor proveedor);

    void deleteProveedor(int idProveedor);

    Proveedor getProveedor(int idProveedor);

    List<Proveedor> getTodoProveedor(String parameter); 
    
}
