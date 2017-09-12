package controle;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Mesa;
import dao.MesaDao;
import java.util.ArrayList;
import modelo.Pedido;

@ManagedBean(name = "mesaControle")
@ViewScoped
        
public class MesaControle implements Serializable{
    private Mesa mesa; //mantem os dados da mesa
    private Mesa aux;
    private MesaDao dao; //usado para persistir
    private List<Mesa> mesas;
    private List<Pedido> listaPedidos;
    private Mesa mesaSelecionada;
    private Mesa novaMesa;

    public MesaControle(){
        mesa = new Mesa();
        dao = new MesaDao();
        mesas = dao.listarTodos();
        mesaSelecionada = new Mesa();
        novaMesa = new Mesa();
        
    }
      
    public void inserir(){
        getDao().inserir(novaMesa);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mesa Cadastrada", null));
        getMesas().add(novaMesa);
        novaMesa = new Mesa();
    }
    public void listarTodos() {
        listaPedidos = mesaSelecionada.getPedidos();
    }
    
     public void preparaAlterar(Mesa m){
        setAux(m);
    }
    
    public void alterar(){
        getDao().alterar(getAux());
    }
    
    public void excluir(Mesa m){
        getDao().excluir(m);
        getMesas().remove(m);
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
 
}
