


import java.util.Scanner;

import javax.swing.JOptionPane;

import Lectura.Lector;
import Viajes.Grafo;
import Viajes.Puerto;
import Viajes.Viaje;

public class Ejecutable {

    public static void main(String[] args) {
    	
    	//creamos un lector y cargamos el grafo
        Lector lector = new Lector();
        Grafo grafo = lector.cargarGrafo();
    	
        //INICIALIZO EL MENU CON LOS DATOS DEL GRAFO
    	Menu M = new Menu(grafo);
    	int opcion = M.MenuPrincipal();
    	
    	
    	while(opcion != 6) {
    		if(opcion == 1) {
    			M.ListarPuertos();
    		}
    		else if(opcion == 2) {
    			M.ListarViajesDePuerto();
    		}
    		else if(opcion == 3) {
    			M.MostrarCaminoMinimo();
    		}
    		else if(opcion == 4) {
    			M.IngresarPuerto();
    		}
    		else if(opcion == 5) {
    			M.IngresarViajeAPuerto();
    		}
    		
    		opcion = M.MenuPrincipal();
    	}
    	JOptionPane.showMessageDialog(null, "Muchas gracias por utilizar el sistema. Saludos!!!");
    	
    	
    	
    }
}

