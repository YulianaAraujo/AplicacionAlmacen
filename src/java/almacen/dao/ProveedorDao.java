/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen.dao;

import almacen.modelo.Proveedor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yulis Araujo
 */
@Stateless
public class ProveedorDao implements ProveedorDaoLocal {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addProveedor(Proveedor proveedor) {
        em.persist(proveedor);
    }

    @Override
    public void editProveedor(Proveedor proveedor) {
        em.merge(proveedor);
    }

    @Override
    public void deleteProveedor(int idProveedor) {
        em.remove(getProveedor(idProveedor));
    }

    
    @Override
    public Proveedor getProveedor(int idProveedor) {
        return em.find(Proveedor.class,idProveedor);
    }

    @Override
    public List<Proveedor> getTodoProveedor(String parameter) {
        return em.createNamedQuery("Proveedor.getTodo").getResultList();
    }
    
}
