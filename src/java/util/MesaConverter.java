package util;


import dao.MesaDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Mesa;

@FacesConverter(value = "MesaConverter", forClass = Mesa.class)
public class MesaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Mesa temp = null;
        MesaDao dao = new MesaDao();
        try {
            System.out.println(value);
            temp = dao.buscarNumero(value);
	} catch (Exception e) {
            System.out.println("Erro MesaConverter converter: "+e.toString());
	}
 	return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj == null){
            return " ";
        }
        if (obj instanceof Mesa){
            Mesa cur = (Mesa)obj;
            return cur.getNumero();
        }
        return "";
    }
    
}