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
				+ "\n 6_ Eliminar puerto"
				+ "\n 7_ Salir del sistema"
				));
		
    	return valor;
	}
	
	public void ListarPuertos() {
		grafo.imprimirPuertos();
		JOptionPane.showMessageDialog(null,"Continuar");
		System.out.println(" ");
					
	}
	
	public void ListarViajesDePuerto() {
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del puerto del que desea saber sus viajes"));
		grafo.listarViajesPuerto(valor);
		JOptionPane.showMessageDialog(null,"Continuar");
		System.out.println(" ");
		
	}

	public void MostrarCaminoMinimo() {
		int inicio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del puerto del que desea salir"));
		int llegada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del puerto al que desea llegar"));
		int comparacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo por el que desea buscar el camino minimo"
				+ "\n 1_ Costo"
				+ "\n 2_ Duracion del viaje"
				));
		grafo.BuscarCaminoMinimo(inicio, llegada, comparacion);
		JOptionPane.showMessageDialog(null,"Continuar");
		System.out.println(" ");
	
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
        JOptionPane.showMessageDialog(null,"Puerto ingresado correctamente.");
        System.out.println(" ");
      
	}

	private boolean existePuertoCodigo(int codigo) {
		return (grafo.buscar(codigo)!=null);
	}

	public void IngresarViajeAPuerto() {
		int codigoOrg = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del puerto de origen:"));
		int codigoDest = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del puerto de destino:"));
		
		//Validamos que exista el código
		while(!existePuertoCodigo(codigoOrg)) {
			codigoOrg = Integer.parseInt(JOptionPane.showInputDialog("El código del puerto de origen no existe"
					+ "\nIngrese otro código del puerto de origen:"));
		}
		
		String nombre = (JOptionPane.showInputDialog("Ingrese el nombre del puerto de destino:"));
		int diasViaje =Integer.parseInt(JOptionPane.showInputDialog("Ingrese los días de viaje al puerto de destino"));
		
		
		int costoViaje =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el costo del viaje"));
		
		//creamos un viaje y lo agregamos al grafo
        Viaje Vi = new Viaje(codigoDest, nombre, diasViaje, costoViaje);
        
        grafo.agregarArista(codigoOrg, Vi);
        JOptionPane.showMessageDialog(null,"Viaje ingresado correctamente.");
        System.out.println(" ");
       
		
	}
	 public void eliminarPuerto() {
		 int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del puerto que desea eliminar:"));
			while(!existePuertoCodigo(codigo)) {
				 codigo = Integer.parseInt(JOptionPane.showInputDialog("El código del puerto no existe"
						+ "\nIngrese otro código del puerto a eliminar:"));
			}
			
	        grafo.eliminarPuerto(codigo);
	        JOptionPane.showMessageDialog(null,"Puerto eliminado correctamente.");
	        System.out.println(" ");
		
	    	
	    }

	

}
