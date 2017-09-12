package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Pedido;
import util.JpaUtil;


public class PedidoDao implements Serializable {
    EntityManager manager;
    
    public boolean inserir(Pedido novoPedido){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(novoPedido);
        tx.commit();
        manager.close();
        return true;
    }
}
