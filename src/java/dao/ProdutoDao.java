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

    public boolean inserir(Produto novoProduto) {
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
}
