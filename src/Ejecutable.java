
import Lectura.Lector;
import Viajes.Grafo;
import Viajes.Puerto;
import Viajes.Viaje;

public class Ejecutable {

    public static void main(String[] args) {
        Lector lector = new Lector();
        Grafo grafo = lector.cargarGrafo();
        grafo.dijkstra(1);
        grafo.imprimir();
        
         Puerto Pu = new Puerto(714, "Lima", "Peru");
         grafo.agregarVertice(Pu);
         
         Viaje Vi = new Viaje(1, "Buenos Aires", 6, 13000);
         
         grafo.agregarArista(714, Vi);
         System.out.println("*******************************************");
         System.out.println("");
         grafo.imprimir();
         grafo.dijkstra(3);
    }
}

