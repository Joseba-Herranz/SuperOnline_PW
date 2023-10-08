package Super;

import java.util.Scanner;

public class FrutaHortaliza extends Perecedero {

	private String origen;
	private double valor_iva=0.16;
	private boolean eFragil;

	public FrutaHortaliza(int codigo, String nombre, double precio, int cantidad, double peso) {
		super(codigo, nombre, precio, cantidad, peso);
		// TODO Auto-generated constructor stub
	}

	public FrutaHortaliza(Scanner sc){
		super(sc);
		String fragil;
		System.out.println("Introduzca el nombre de la fruta o hortailza");
		setNombre(sc.nextLine());

		System.out.println("Introduzca el precio");
		setPrecio(sc.nextDouble());

		System.out.println("Introduzca la cantidad");
		setCantidad(sc.nextInt());

		System.out.println("Introduzca el peso");
		setPeso(sc.nextDouble());

		sc.nextLine();

		System.out.println("Introduza el orign");
		setOrigen(sc.nextLine());

		

		System.out.println("La fruta u hortaliza es fragil");
		fragil=sc.nextLine();
		if(fragil.equalsIgnoreCase("si")){
			eFragil=true;
		}else{
			eFragil=false;
		}

	}




	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String volcar(){

		return "";

	}

	@Override
	public void imprimir(){
		super.imprimir();
		System.out.println("origen: "+origen);
		if(eFragil==true){
			System.out.println("El paquete es fragil");
		}else{
			System.out.println("El paquete no es fragil");
		}

	}

	public boolean envioFragil(boolean fragil){


		return eFragil;
	}

	public void calcularPrecioEnvio(){

	}




}
