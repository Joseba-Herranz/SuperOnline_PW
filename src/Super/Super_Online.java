package Super;

import java.util.Scanner;

public class Super_Online {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion = 1;

		System.out.println("========================================================================");
		System.out.println("=                 SISTEMA DE GESTION DE SUPER-ON-LINE                  =");
		System.out.println("========================================================================");
		System.out.println();
		System.out.println();


		while (opcion != 0) {
			mostrarMenuInventario();
			System.out.println("Opci�n? ");
			opcion = leerOpcion(7); // hay 6 acciones principales sobre el inventario + terminar la aplicaci�n
			switch(opcion) {
			case 0:	System.out.println("Termina la aplicaci�n");
					System.exit(0);
			case 1: Inventario.cargarProductos();
					pause();
					break; // cargar productos
			case 2: Inventario.mostrarProductos();
					pause();
					break;
			case 3:     //actualizar la cantidad de un producto en almanc�n
				Producto p;
				while (opcion!=0) {
					Inventario.mostrarProductos();
					System.out.println("0 - Finalizar actualizaci�n del inventario");
					System.out.println("Elige el n�mero del producto a actualizar, tecla:x (/= 0):");
					System.out.println("Opci�n? ");
					opcion = leerOpcion(Inventario.tamano()+1); //se han mostrado todos los articulos (talla) + opcion de salida
					if (opcion!=0) {
						p = Inventario.getProducto(opcion);  //el mismo producto
						System.out.println("Producto elegido: "+p.getNombre()+", existencias: "+p.getCantidad());
						System.out.println("Elige la nueva cantidad:");
						int cant = in.nextInt();
						in.nextLine();
						p.setCantidad(cant);   //actualiza el mismo producto del inventario
												//NO ES NECESARIA LA ACTUALIZACI�N DESDE INVENTARIO!!
						System.out.println("Producto actualizado: "+p.getNombre()+", Nueva cantidad en almac�n: "+p.getCantidad());
						System.out.println();
						pause();
					}
				} opcion=1; break;
			case 4: 	//a�adir un nuevo producto al almanc�n
				while (opcion!=0) {
					mostrarMenuAddNuevoProducto();
					System.out.println("Opci�n? ");
					opcion = leerOpcion(6); // 5 clases de productos y salida del men�
					if (opcion!=0) {
						Producto P = nuevoProducto(opcion);
						Inventario.addNuevoProducto(P);
						System.out.println("Producto a�adido, n�mero "+Inventario.tamano());
						Inventario.getProducto(Inventario.tamano()).imprimir(); //imprime el �ltimo producto incluido
						System.out.println();
						System.out.println();
						pause();
					}
				} opcion=1; break;
			case 5: Inventario.mostrarProductosEnviables();
					pause();
					break;
			case 6: Inventario.guardarProductos();
					pause();
					break;
			}
		}
	}

	public static void mostrarMenuInventario() {// ver productos del super ordenados
		System.out.println("====================================================================");
		System.out.println("=            MENU PRINCIPAL - GESTI�N DE INVENTARIO                =");
		System.out.println("====================================================================");
		System.out.println("            tecla:1   - Cargar productos");
		System.out.println("            tecla:2   - Mostrar inventario");
		System.out.println("            tecla:3   - Actualizar existencias");
		System.out.println("            tecla:4   - A�adir nuevo producto");
		System.out.println("            tecla:5   - Mostrar productos enviables");
		System.out.println("            tecla:6   - Guardar inventario");
		System.out.println("            tecla:0   - Terminar");
		System.out.println("====================================================================");
	}


	public static void mostrarMenuAddNuevoProducto() {// ver productos y escoger uno
		System.out.println("====================================================");
		System.out.println("=   Elige el tipo de producto que quieres a�adir:  =");
		System.out.println("====================================================");
		System.out.println("         tecla:1 - Lacteo");
		System.out.println("         tecla:2 - Frutas u hortalizas");
		System.out.println("         tecla:3 - Bebidas");
		System.out.println("         tecla:4 - Herramientas");
		System.out.println("         tecla:5 - Otros");
		System.out.println("         tecla:0 - Cancelar");
		System.out.println("====================================================");
	}

	public static Producto nuevoProducto (int n) {
		Scanner es = new Scanner (System.in);
		Producto P;
		switch(n) {
			case 1: P = new Lacteo(es);break;
			case 2: P = new FrutaHortaliza(es);break;
			case 3: P = new Bebida(es);break;
			case 4: P = new Herramienta(es);break;
			default: P = new Otros(es);break;
		}
		return P;
	}

	private static void pause() {
		System.out.println("(pulsa 0 para continuar...");
		leerOpcion(1);
	}


	private static int leerOpcion(int max) {
		Scanner sc = new Scanner(System.in);
		boolean terminar = false;
		int n = 0;
		while (!terminar) {
			try {
				n = in.nextInt();
				in.nextLine();
				if (n>=max || n<0) {
					throw new Exception();
				}
				terminar = true;
			} catch (Exception e) {
				System.out.println("Opci�n incorrecta! elije de nuevo");
				sc.nextLine();
			}
		}
		return n;
	}
}