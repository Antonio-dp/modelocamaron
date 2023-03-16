/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import dominio.Pedido;
import interfaces.IConexionBD;
import interfaces.IModeloPedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/**
 *
 * @author tonyd
 */
public class ModeloPedido implements IModeloPedido {

    private final IConexionBD conexionBD;

    public ModeloPedido(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Pedido consultar(Integer idPedido) {
        EntityManager em = this.conexionBD.crearConexion();
        try {
            return em.find(Pedido.class, idPedido);
        } catch (IllegalStateException e) {
            System.err.println("No se pudo consultar el pedido" + idPedido);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Pedido eliminar(Pedido pedido) {
        EntityManager em = this.conexionBD.crearConexion();
        try {
            em.getTransaction().begin();  
            Query query = em.createQuery("DELETE FROM Pedido e WHERE e.id = :idPedido");
            query.setParameter("idPedido", pedido.getId()).executeUpdate();
            em.getTransaction().commit();
            return pedido;
        } catch (IllegalStateException e) {
            System.err.println("No se pudo eliminar el pedido" + pedido.getId());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Pedido registrar(Pedido pedido) {
        EntityManager em = this.conexionBD.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
            return pedido;
        } catch (IllegalStateException e) {
            System.err.println("No se pudo agregar el pedido" + pedido.getId());
            e.printStackTrace();
            return null;
        }
    }

}
