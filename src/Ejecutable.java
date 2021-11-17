


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
    	
    	
    	while(opcion != 7) {
    		
    		switch(opcion) {
    			case 1:
    				M.ListarPuertos();
    				break;
    			case 2:
        			M.ListarViajesDePuerto();
        			break;
    			case 3:
    				M.MostrarCaminoMinimo();
        			break;
    			case 4:
    				M.IngresarPuerto();
        			break;
    			case 5:
    				M.IngresarViajeAPuerto();
        			break;
    			case 6:
    				M.eliminarPuerto();
        			break;
    			}
    		
		
    		opcion = M.MenuPrincipal();
    	}
    	JOptionPane.showMessageDialog(null, "Muchas gracias por utilizar el sistema. Saludos!!!");
    	
    	
    	
    }
}

