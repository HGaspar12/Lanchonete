/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Mesa;
import modelo.Pedido;
import util.JpaUtil;



public class MesaDao implements Serializable {
    EntityManager manager;
    
    public boolean inserir(Mesa mesas){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(mesas);
        tx.commit();
        manager.close();
        return true;
    }
    public boolean inserir(String mesa){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(mesa);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Mesa> listarTodos(){
        EntityManager manager = JpaUtil.getEntityManager();
        CriteriaQuery<Mesa> query = manager.getCriteriaBuilder().createQuery(Mesa.class);
        query.select(query.from(Mesa.class));
        List<Mesa> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }

    public boolean excluir(Mesa mesas){
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        // recupera a referência ao objeto
        Mesa temp = manager.find(Mesa.class, mesas.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }
    
    
   public Mesa buscarNumero(Mesa mesa){
        Mesa retorno;
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT m FROM Mesa m WHERE m.numero = :numero";
        TypedQuery<Mesa> query = manager.createQuery(sql, Mesa.class); 
        query.setParameter("numero", mesa.getNumero());
        retorno = query.getSingleResult();
        manager.close();
        return retorno;
    }
   public Mesa buscarNumero(String mesa){
        Mesa retorno;
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT m FROM Mesa m WHERE m.numero = :numero";
        TypedQuery<Mesa> query = manager.createQuery(sql, Mesa.class); 
        query.setParameter("numero", mesa);
        retorno = query.getSingleResult();
        manager.close();
        return retorno;
    }
   
   public void alterar(Mesa mesa) {
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        mesa = manager.merge(mesa);
        manager.getTransaction().commit();
        manager.close();
    }
    
}   

