package Viajes;


import java.util.ArrayList;
import java.util.List;

public class NodoGrafo {
    private Puerto dato;
    private List<Viaje> destinos = new ArrayList<Viaje>();
 

    public NodoGrafo(Puerto nuevo){
        this.dato = nuevo;
    }
    public void agregarArista(Viaje arista){
        this.destinos.add(arista);
    }
    public Puerto getDato(){return this.dato;}

    public List<Viaje> getAdyacentes() {return this.destinos;}
    
    public void imprimirAristas(){
        int iterar = 0;
        while (iterar<destinos.size()){
            System.out.println(destinos.get(iterar));
            iterar =  iterar + 1;
        }
    }
}

