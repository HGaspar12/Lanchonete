/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelo.Mesa;
import modelo.Pedido;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.JpaUtil;

/**
 *
 * @author henri
 */
public class MesaDaoTest {
    
    public MesaDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void inserir() {
//        Mesa mesas = new Mesa();
//        mesas.setNumero("11");
//        mesas.setNome("Mesa11");
//        MesaDao dao = new MesaDao();
//        dao.inserir(mesas);
//    }
    
//    @Test
//    public void testlistar(){
//        List<Mesa> mesas = new MesaDao().listarTodos();
//        for(Mesa m:mesas){
//            System.out.println(m.getCodigo());
//            for(Pedido p:m.getPedidos()){
//                System.out.println(p.getProduto().getNomeProduto());
//            }
//        }
//    }

//      @Test
//      public void testexcluir(){
//      Mesa mesas = new Mesa();
//      mesas.setCodigo(10);
//      MesaDao dao = new MesaDao();
//      dao.excluir(mesas);
//      }
    
//        @Test
//        public void buscarNumero(){
//            Mesa mesa = new Mesa();
//            mesa.setNumero("1");
//            MesaDao dao = new MesaDao();
//            Mesa temp = dao.buscarNumero(mesa);
//            for(Pedido p:temp.getPedidos()){
//                
//                System.out.println(p.getQuantidade() +" "+ p.getProduto().getNomeProduto() +" "+ p.getQuantidade()*p.getProduto().getValorProduto());
//                temp.setValorTotal(temp.getValorTotal() + p.getQuantidade()*p.getProduto().getValorProduto());
//            }
//            System.out.println("Valor a pagar: " + temp.getValorTotal());
//            dao.alterar(temp);
//            
//        }
        
        
    
    
}
