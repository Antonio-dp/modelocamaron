package interfaces;


import dominio.Pedido;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author tonyd
 */
public interface IModeloPedido {
    public Pedido consultar(Integer idPedido);
    public Pedido eliminar(Pedido pedido);
    public Pedido registrar(Pedido pedido);
}
