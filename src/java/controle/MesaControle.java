package controle;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Mesa;
import dao.MesaDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelo.Pedido;
import modelo.Produto;
import util.JpaUtil;

@ManagedBean(name = "mesaControle")
@ViewScoped
        
public class MesaControle implements Serializable{

    /**
     * @return the dao2
     */
    public PedidoDao getDao2() {
        return dao2;
    }

    /**
     * @param dao2 the dao2 to set
     */
    public void setDao2(PedidoDao dao2) {
        this.dao2 = dao2;
    }

    private Mesa mesa; //mantem os dados da mesa
    private Mesa aux;
    private MesaDao dao; //usado para persistir
    private PedidoDao dao2;
    private ProdutoDao dao3;
    private List<Mesa> mesas;
    private List<Pedido> listaPedidos;
    private List<Produto> listaProdutos;
    private Mesa mesaSelecionada;
    private Mesa novaMesa;
    private Pedido novoPedido;
    private Produto novoProduto;
    private Produto produtoSelecionado;

    public MesaControle(){
        mesa = new Mesa();
        dao = new MesaDao();
        dao2 = new PedidoDao();
        dao3 = new ProdutoDao();
        mesas = dao.listarTodos();
        listaProdutos = dao3.listarProdutos();
        mesaSelecionada = new Mesa();
        produtoSelecionado = new Produto();
        novaMesa = new Mesa();
        novoPedido = new Pedido();
        novoProduto = new Produto();
        
    }
      
    public void inserir(){
        getDao().inserir(novaMesa);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mesa Cadastrada", null));
        getMesas().add(novaMesa);
        novaMesa = new Mesa();
    }
    
        public void inserirProduto(){
            getDao3().inserirProduto(novoProduto);
        FacesContext context = FacesContext.getCurrentInstance();
        getNovoProduto().add(novoProduto);
        novoProduto = new Produto();
    }
    
    
    public void inserirPedido(){
        getDao2().inserirPedido(novoPedido);
        novoPedido.setProduto(produtoSelecionado);
        novoPedido.setMesa(mesaSelecionada);
        mesaSelecionada.getPedidos().add(novoPedido);
        getDao().alterar(mesaSelecionada);
        FacesContext context = FacesContext.getCurrentInstance();
    }
    
    public void listarTodos() {
        listaPedidos = mesaSelecionada.getPedidos();
    }
    public void listarTodosProdutos(){
        listaProdutos = dao3.listarProdutos();
    }
    
     public void preparaAlterar(Mesa m){
        setAux(m);
    }
    
    public void alterar(){
        getDao().alterar(getAux());
    }
    
    public void excluirMesa(){
        System.out.println(mesaSelecionada.getCodigo());
        getDao().excluir(mesaSelecionada);
        getMesas().remove(mesaSelecionada);
    }
    public void excluirPedido(Pedido novoPedido){
        System.out.println("ataeat");
        dao2.excluir(novoPedido);
        getListaPedidos().remove(novoPedido); 
    }
    
    /**
     * @return the produtoSelecionado
     */
    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    /**
     * @param produtoSelecionado the produtoSelecionado to set
     */
    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    /**
     * @return the listaProdutos
     */
    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    /**
     * @param listaProdutos the listaProdutos to set
     */
    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    /**
     * @return the mesa
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * @param mesa the mesa to set
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    /**
     * @return the aux
     */
    public Mesa getAux() {
        return aux;
    }

    /**
     * @param aux the aux to set
     */
    public void setAux(Mesa aux) {
        this.aux = aux;
    }

    /**
     * @return the dao
     */
    public MesaDao getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(MesaDao dao) {
        this.dao = dao;
    }

    /**
     * @return the mesas
     */
    public List<Mesa> getMesas() {
        return mesas;
    }

    /**
     * @param mesas the mesas to set
     */
    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    /**
     * @return the mesaSelecionada
     */
    public Mesa getMesaSelecionada() {
        return mesaSelecionada;
    }

    /**
     * @param mesaSelecionada the mesaSelecionada to set
     */
    public void setMesaSelecionada(Mesa mesaSelecionada) {
        this.mesaSelecionada = mesaSelecionada;
    }

    /**
     * @return the listaPedidos
     */
    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    /**
     * @param listaPedidos the listaPedidos to set
     */
    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    /**
     * @return the novaMesa
     */
    public Mesa getNovaMesa() {
        return novaMesa;
    }

    /**
     * @param novaMesa the novaMesa to set
     */
    public void setNovaMesa(Mesa novaMesa) {
        this.novaMesa = novaMesa;
    }

    /**
     * @return the novoPedido
     */
    public Pedido getNovoPedido() {
        return novoPedido;
    }

    /**
     * @param novoPedido the novoPedido to set
     */
    public void setNovoPedido(Pedido novoPedido) {
        this.novoPedido = novoPedido;
    }

    /**
     * @return the novoProduto
     */
    public Produto getNovoProduto() {
        return novoProduto;
    }

    /**
     * @param novoProduto the novoProduto to set
     */
    public void setNovoProduto(Produto novoProduto) {
        this.novoProduto = novoProduto;
    }

    /**
     * @return the dao3
     */
    public ProdutoDao getDao3() {
        return dao3;
    }

    /**
     * @param dao3 the dao3 to set
     */
    public void setDao3(ProdutoDao dao3) {
        this.dao3 = dao3;
    }

    private FacesMessage FacesMessage(FacesMessage.Severity SEVERITY_INFO, String aaa, String teste) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
