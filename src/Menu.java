import java.util.Scanner;

import javax.swing.JOptionPane;

import Viajes.Grafo;
import Viajes.Puerto;
import Viajes.Viaje;

public class Menu {
	
	private Grafo grafo;
	
	public Menu(Grafo grafo) {
		this.grafo = grafo;
	}
	
	public int MenuPrincipal() {
		
		//Scanner sc = new Scanner(System.in);
    	//MENU
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al sistema de puertos"
				+ "\n Por favor seleccione alguna opcion del menu"
				+ "\n 1_ Listado de Puertos"
				+ "\n 2_ Listado de Viajes por Puerto"
				+ "\n 3_ Camino minimo desde un Puerto a otro"
				+ "\n 4_ Ingresar un Puerto"
				+ "\n 5_ Ingresar un Viaje a un Puerto"
				+ "\n 6_ Salir del sistema"
				));
		
    	return valor;
	}
	
	public void ListarPuertos() {
		grafo.imprimirPuertos();
		Scanner scVP = new Scanner(System.in);
		System.out.println("Presione cualquier tecla para volver al menu");
		scVP.next();			
	}
	
	public void ListarViajesDePuerto() {
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del puerto del que desea saber sus viajes"));
		grafo.listarViajesPuerto(valor);
		Scanner scVP = new Scanner(System.in);
		System.out.println("Presione cualquier tecla para volver al menu");
		scVP.next();
		
		
	}

	public void MostrarCaminoMinimo() {
		int inicio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del puerto del que desea salir"));
		int llegada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del puerto al que desea llegar"));
		grafo.BuscarCaminoMinimo(inicio, llegada);
		Scanner scVP = new Scanner(System.in);
		System.out.println("Presione cualquier tecla para volver al menu");
		scVP.next();
	
	}

	public void IngresarPuerto() {
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del puerto del que desea agregar:"));
		while(existePuertoCodigo(codigo)) {
			 codigo = Integer.parseInt(JOptionPane.showInputDialog("El código del puerto ya existe"
					+ "\nIngrese otro código del puerto del que desea agregar:"));
		}
		String nombre = (JOptionPane.showInputDialog("Ingrese el nombre del puerto"));
		String pais = (JOptionPane.showInputDialog("Ingrese el pais del puerto:"));
				
		
		Puerto Pu = new Puerto(codigo, nombre, pais);
        grafo.agregarVertice(Pu);
        System.out.println("Puerto ingresado correctamente. Presione cualquier tecla para volver al menu");
        Scanner scVP = new Scanner(System.in);
        scVP.next();
	}

	private boolean existePuertoCodigo(int codigo) {
		return (grafo.buscar(codigo)!=null);
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
