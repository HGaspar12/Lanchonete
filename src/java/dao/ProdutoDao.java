package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Produto;
import util.JpaUtil;

public class ProdutoDao implements Serializable {

    EntityManager manager;

    public boolean inserirProduto(Produto novoProduto) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(novoProduto);
        tx.commit();
        manager.close();
        return true;
    }

    public boolean excluir(Produto novoProduto) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        // recupera a referência ao objeto
        Produto temp = manager.find(Produto.class, novoProduto.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }
    
     public List<Produto> listarProdutos(){
        EntityManager manager = JpaUtil.getEntityManager();
        CriteriaQuery<Produto> query = manager.getCriteriaBuilder().createQuery(Produto.class);
        query.select(query.from(Produto.class));
        List<Produto> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }
   
      public Produto buscarNome(String produto){
        Produto retorno;
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT p FROM Produto p WHERE p.nomeProduto = :nome";
        TypedQuery<Produto> query = manager.createQuery(sql, Produto.class); 
        query.setParameter("nome", produto);
        retorno = query.getSingleResult();
        manager.close();
        return retorno;
    }
      
//     public void alterar(Produto produto) {
//        manager = JpaUtil.getEntityManager();
//        manager.getTransaction().begin();
//        produto = manager.merge(produto);
//        manager.getTransaction().commit();
//        manager.close();
//    }
}
