package util;


import dao.ProdutoDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Produto;

@FacesConverter(value = "ProdutoConverter", forClass = Produto.class)
public class ProdutoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Produto temp = null;
        ProdutoDao dao = new ProdutoDao();
        try {
            System.out.println(value);
            temp = dao.buscarNome(value);
	} catch (Exception e) {
            System.out.println("Erro ProdutoConverter converter: "+e.toString());
	}
 	return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj == null){
            return " ";
        }
        if (obj instanceof Produto){
            Produto cur = (Produto)obj;
            return cur.getNomeProduto();
        }
        return "";
    }
    
}