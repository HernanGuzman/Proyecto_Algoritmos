import java.util.Scanner;

import Viajes.Grafo;
import Viajes.Puerto;
import Viajes.Viaje;

public class Menu {
	
	private Grafo grafo;
	
	public Menu(Grafo grafo) {
		this.grafo = grafo;
	}
	
	public int MenuPrincipal() {
		Scanner sc = new Scanner(System.in);
    	//MENU
    	System.out.println("*****************BIENVENIDO AL SISTEMA DE PUERTOS**************************");
    	System.out.println("");
    	System.out.println("Por favor seleccione alguna opcion del menu");
    	System.out.println("1_ Listado de Puertos");
    	System.out.println("2_ Listado de Viajes por Puerto");
    	System.out.println("3_ Camino minimo desde un Puerto");
    	System.out.println("4_ Ingresar un Puerto");
    	System.out.println("5_ Ingresar un Viaje a un Puerto");
    	System.out.println("6_ Salir del sistema");
    	int opcion = sc.nextInt();
    	System.out.println(opcion);
    	return opcion;
	}
	
	public void ListarPuertos() {
		//Scanner scLP = new Scanner(System.in);
		grafo.imprimirPuertos();
		//System.out.println("");
		//System.out.println("Presione cualquier tecla para volver al menu");
		//scLP.next();
		
	}
	
	public void ListarViajesDePuerto() {
		Scanner scVP = new Scanner(System.in);
		System.out.println("");
		System.out.println("Ingrese el codigo del puerto del que desea saber sus viajes");
		grafo.listarViajesPuerto(scVP.nextInt());
		System.out.println("Presione cualquier tecla para volver al menu");
		scVP.next();
		
	}

	public void MostrarCaminoMinimo() {
		Scanner scVP = new Scanner(System.in);
		System.out.println("");
		System.out.println("Ingrese el codigo del puerto del que desea saber el camino minimo");
		grafo.BuscarCaminoMinimo(scVP.nextInt());
		System.out.println("Presione cualquier tecla para volver al menu");
		scVP.next();
		
	}

	public void IngresarPuerto() {
		Scanner scVP = new Scanner(System.in);
		Scanner scVPSal = new Scanner(System.in);
		Scanner scVPS = new Scanner(System.in);
		System.out.println("");
		System.out.println("Ingrese el codigo del puerto del que desea agregar:");
		int codPuerto = scVP.nextInt();
		System.out.println("Ingrese el nombre del puerto:");
		String nomPuerto = scVPS.nextLine();
		System.out.println("Ingrese el pais del puerto:");
		String paisPuerto = scVPS.nextLine();
		Puerto Pu = new Puerto(codPuerto, nomPuerto, paisPuerto);
        grafo.agregarVertice(Pu);
        System.out.println("Puerto ingresado correctamente. Presione cualquier tecla para volver al menu");
        scVPSal.next();
	}

	public void IngresarViajeAPuerto() {
		Scanner scVP = new Scanner(System.in);
		Scanner scVPD = new Scanner(System.in);
		System.out.println("");
		System.out.println("Ingrese el codigo del puerto de origen:");
		int codPuertoOrigen = scVP.nextInt();
		System.out.println("Ingrese el codigo del puerto de destino:");
		int codPuertoDestino = scVP.nextInt();
		System.out.println("Ingrese el nombre del puerto de destino:");
		String nombPuertoDestino = scVPD.nextLine();
		System.out.println("Ingrese los dias de viaje al puerto de destino");
		int diasViaje = scVP.nextInt();
		System.out.println("Ingrese el costo del viaje al puerto de destino");
		int costoViaje = scVP.nextInt();
		
		//creamos un viaje y lo agregamos al grafo
        Viaje Vi = new Viaje(codPuertoDestino, nombPuertoDestino, diasViaje, costoViaje);
        
        grafo.agregarArista(codPuertoOrigen, Vi);
        System.out.println("Viaje ingresado correctamente. Presione cualquier tecla para volver al menu");
        scVP.next();
		
	}
	

}
