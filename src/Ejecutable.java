


import java.util.Scanner;

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
    	System.out.println("SALUDOS!!!!!!");
    	
    	
    	
        /*
        //imprimimos el grafo
        grafo.imprimir();
        
        //Buscamos los caminos mínimos desde el puerto 1 (Buenos Aires)
        grafo.dijkstra(1);
        
        //creamos un puerto y lo agregamos al grafo
         Puerto Pu = new Puerto(714, "Lima", "Peru");
         grafo.agregarVertice(Pu);
         Puerto Pue = new Puerto(74, "cuzco", "Peru");
         grafo.agregarVertice(Pue);
       //creamos un viaje y lo agregamos al grafo
         Viaje Vi = new Viaje(1, "Buenos Aires", 6, 13000);
         
         grafo.agregarArista(714, Vi);
         System.out.println("*******************************************");
         System.out.println("");
         grafo.imprimir();
         
         //probamos con otro punto de partida
         grafo.dijkstra(3);
         System.out.println("*******************************************");
         System.out.println("");
         
         //imprimimos todos los puertos
         grafo.imprimirPuertos();
         
         System.out.println("**************");
         //Imprimimos el puerto con código 3
         grafo.buscarPuerto(3);
         
         */
    }
}

