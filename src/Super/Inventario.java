package Super;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

public class Inventario extends Super_Online {

	public static int ultimoCatalogo;
	public static int ficheroInventario;
	public static ArrayList<Producto> lista= new ArrayList<Producto>();
	public static ListaProducto listaProducto = new ListaProducto();

	private Inventario(){

	}

	public static void cargarProductos() {
		
	    try {
	        JAXBContext contexto = JAXBContext.newInstance(ListaProducto.class);
	        Unmarshaller marshaller = contexto.createUnmarshaller();
	        File archivo = new File("productos.xml");
	        Inventario.listaProducto = (ListaProducto) marshaller.unmarshal(archivo);
	        Inventario.lista = listaProducto.getListaProductos();
	        for (Producto producto : listaProducto.getListaProductos()) {
	            System.out.println(producto.imprimir());
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }
	}

	public static void guardarProductos(){
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
           /* fichero = new FileWriter("C:/Users/2dam3/Desktop/SuperOnline/productos.txt");
            //pw = new PrintWriter(fichero);

            for (Producto p : lista){
            	fichero.write(p.volcar(lista));
            }
            fichero.close(); */
        	
        	JAXBContext contexto = JAXBContext.newInstance(ListaProducto.class);

			Marshaller marshaller = contexto.createMarshaller();

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			File lista = new File("datos.xml");

			marshaller.marshal(listaProducto, lista);

		} catch (PropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addNuevoProducto(Producto p){
		lista.add(p);
	}

	public static void mostrarProductos(){

		for(Producto p : lista){

			p.imprimir();

		}

	}

	public static Producto getProducto(int id){

		return lista.get(id);


	}

	public void actualizarCantidad(int codigo,int cantidad, Producto p){


	}

	public static int tamano(){

		return 0;
	}

	public static void mostrarProductosEnviables(){
		lista.forEach(producto -> {
			if(producto instanceof Enviable)
			producto.imprimirEnvio();

		});
	}

	public void eliminarProducto(int id){

		lista.remove(id);
	}
	
	/*public static int getUltimo() {
		return 0;
	}*/



}
