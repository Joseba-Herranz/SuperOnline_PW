package Super;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Inventario")
public class ListaProducto {
	
	 private ArrayList<Producto> ListaProductos;

	    public  ListaProducto() {
	        ListaProductos = new ArrayList<Producto>();
	    }

	    public ArrayList<Producto> getListaProductos() {
	        return ListaProductos;
	    }
	  
		@XmlElement(name = "producto")
	    public void setListaProductos(ArrayList<Producto> listaProductos) {
	        ListaProductos = listaProductos;
	    }
	}

